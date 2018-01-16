package org.talend.designer.codegen.translators.processing;

import org.talend.core.model.process.EConnectionType;
import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import org.talend.commons.utils.StringUtils;

public class TUnpivotRowMainJava
{
  protected static String nl;
  public static synchronized TUnpivotRowMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TUnpivotRowMainJava result = new TUnpivotRowMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "/*" + NL + "\t&copy; British Telecommunications plc, 2009, All Rights Reserved. Licensed for general use under the terms of GPL v2." + NL + "*/";
  protected final String TEXT_2 = NL + "\tString[] pivotKeysArray = {";
  protected final String TEXT_3 = "};" + NL + "" + NL + "\tfor (String field : pivotKeysArray) {" + NL + "\t\t";
  protected final String TEXT_4 = NL + "\t\t";
  protected final String TEXT_5 = ".pivot_key = field;" + NL + "\t\ttry {" + NL + "\t\t\t";
  protected final String TEXT_6 = ".pivot_value = ";
  protected final String TEXT_7 = ".getClass().getDeclaredField(field).get(";
  protected final String TEXT_8 = ").toString();" + NL + "\t\t} catch (Exception e) {" + NL + "\t\t\t";
  protected final String TEXT_9 = ".pivot_value = null;" + NL + "\t\t}" + NL + "\t";
  protected final String TEXT_10 = NL + "\t\tif (";
  protected final String TEXT_11 = ".pivot_value == null || ";
  protected final String TEXT_12 = ".pivot_value.trim().equals(\"\")) {" + NL + "\t\t\tcontinue;" + NL + "\t\t}" + NL + "\t";
  protected final String TEXT_13 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	
	String cid = node.getUniqueName();

	List<Map<String, String>> rowKeys = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node,"__ROW_KEYS__");
		
	String incomingConnName = null;
	String outgoingConnName = null;

	IMetadataTable inMetadata = null;
		
	List< ? extends IConnection> inConns = node.getIncomingConnections();
	if (inConns != null && !inConns.isEmpty()) {
		IConnection inConn = inConns.get(0);
		inMetadata = inConn.getMetadataTable();
		incomingConnName = inConn.getName();
	}
		
	List< ? extends IConnection> outConns = node.getOutgoingConnections(EConnectionType.FLOW_MAIN);
	if (outConns != null && !outConns.isEmpty()) {
		IConnection outConn = outConns.get(0);
		outgoingConnName = outConn.getName();
	} 

	StringBuilder keyFieldsPassThru = new StringBuilder();
	List<String> pivotKeyIndexesArray = new ArrayList<String>();

	for (IMetadataColumn column: inMetadata.getListColumns()) {
		boolean isRowKey = false;
		for (Map<String, String> rowKey : rowKeys) {
			if (column.getLabel().equals(rowKey.get("COLUMN"))) {
				isRowKey = true;
			}
		}

		if (isRowKey) {
			keyFieldsPassThru.append(outgoingConnName);
			keyFieldsPassThru.append(".");
			keyFieldsPassThru.append(column.getLabel());
			keyFieldsPassThru.append("=");
			keyFieldsPassThru.append(incomingConnName);
			keyFieldsPassThru.append(".");
			keyFieldsPassThru.append(column.getLabel());
			keyFieldsPassThru.append(";\n");
		} else {
			pivotKeyIndexesArray.add("\"" + column.getLabel() + "\"");
		}
	} 
    stringBuffer.append(TEXT_2);
    stringBuffer.append( StringUtils.join(pivotKeyIndexesArray.toArray(),","));
    stringBuffer.append(TEXT_3);
    stringBuffer.append( keyFieldsPassThru.toString() );
    stringBuffer.append(TEXT_4);
    stringBuffer.append(outgoingConnName );
    stringBuffer.append(TEXT_5);
    stringBuffer.append(outgoingConnName );
    stringBuffer.append(TEXT_6);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(incomingConnName);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(outgoingConnName );
    stringBuffer.append(TEXT_9);
    	if(("false").equals(ElementParameterParser.getValue(node,"__INCLUDE_EMPTY_VALUES__"))) { 
    stringBuffer.append(TEXT_10);
    stringBuffer.append(outgoingConnName );
    stringBuffer.append(TEXT_11);
    stringBuffer.append(outgoingConnName );
    stringBuffer.append(TEXT_12);
    	} 
    stringBuffer.append(TEXT_13);
    return stringBuffer.toString();
  }
}
