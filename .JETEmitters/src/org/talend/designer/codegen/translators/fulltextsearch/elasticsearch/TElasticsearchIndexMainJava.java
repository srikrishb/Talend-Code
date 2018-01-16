package org.talend.designer.codegen.translators.fulltextsearch.elasticsearch;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.EConnectionType;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.core.model.metadata.types.JavaType;
import java.util.List;
import java.util.Map;

public class TElasticsearchIndexMainJava
{
  protected static String nl;
  public static synchronized TElasticsearchIndexMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TElasticsearchIndexMainJava result = new TElasticsearchIndexMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "java.util.Map<String, Object> request";
  protected final String TEXT_3 = " = new java.util.HashMap<String, Object>();" + NL + "String key";
  protected final String TEXT_4 = "=\"\";";
  protected final String TEXT_5 = NL + "                \tkey";
  protected final String TEXT_6 = "+=";
  protected final String TEXT_7 = ".";
  protected final String TEXT_8 = ";" + NL + "\t\t\t\t";
  protected final String TEXT_9 = NL + "\t\t\t\trequest";
  protected final String TEXT_10 = ".put(\"";
  protected final String TEXT_11 = "\", ";
  protected final String TEXT_12 = ".";
  protected final String TEXT_13 = ");" + NL + "\t\t\t\t";
  protected final String TEXT_14 = NL + NL + "if(key";
  protected final String TEXT_15 = ".isEmpty() && request";
  protected final String TEXT_16 = ".size()==1){" + NL + "\tString json";
  protected final String TEXT_17 = " = request";
  protected final String TEXT_18 = ".values().iterator().next().toString();" + NL + "\tbulkRequest";
  protected final String TEXT_19 = ".add(esClient";
  protected final String TEXT_20 = ".prepareIndex(";
  protected final String TEXT_21 = ", ";
  protected final String TEXT_22 = ")" + NL + "    \t\t\t\t.setSource(json";
  protected final String TEXT_23 = "));" + NL + "}else{" + NL + "\tbulkRequest";
  protected final String TEXT_24 = ".add(esClient";
  protected final String TEXT_25 = ".prepareIndex(";
  protected final String TEXT_26 = ", ";
  protected final String TEXT_27 = ", key";
  protected final String TEXT_28 = ")" + NL + "    \t\t\t\t.setSource(request";
  protected final String TEXT_29 = "));" + NL + "}" + NL + "bulkRequestsSize";
  protected final String TEXT_30 = "++;    \t" + NL + "nb_line_";
  protected final String TEXT_31 = "++;\t\t\t" + NL + "if(bulkRequestsSize";
  protected final String TEXT_32 = " == ";
  protected final String TEXT_33 = "){" + NL + "    org.elasticsearch.action.bulk.BulkResponse response";
  protected final String TEXT_34 = " = bulkRequest";
  protected final String TEXT_35 = ".execute().actionGet();" + NL + "    if(response";
  protected final String TEXT_36 = ".hasFailures() && ";
  protected final String TEXT_37 = "){" + NL + "    \tthrow new RuntimeException(\"Exception Indexing Bulk: \" + response";
  protected final String TEXT_38 = ".buildFailureMessage());" + NL + "    }" + NL + "    bulkRequest";
  protected final String TEXT_39 = " = esClient";
  protected final String TEXT_40 = ".prepareBulk();\t" + NL + "    bulkRequestsSize";
  protected final String TEXT_41 = " = 0;" + NL + "    " + NL + "    if( ";
  protected final String TEXT_42 = " ) {" + NL + "    \tSystem.out.println(\"Indexed requests\");" + NL + "    }" + NL + "}";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();
String cid = node.getUniqueName();

    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_4);
    
String esIndex = ElementParameterParser.getValue(node, "__ES_INDEX__");
String esType = ElementParameterParser.getValue(node, "__ES_TYPE__");
String esBatchSize = ElementParameterParser.getValue(node, "__BATCH_SIZE__");

Boolean verboseConsole = new Boolean(ElementParameterParser.getValue(node, "__VERBOSE_INDEXING__"));  
Boolean dieError = new Boolean(ElementParameterParser.getValue(node, "__DIE_ERROR__"));  

List<IMetadataColumn> columns = null;
List<IMetadataTable> metadatas = node.getMetadataList();
IMetadataTable metadata = null;
if ((metadatas != null) && (metadatas.size() > 0)) {
  metadata = metadatas.get(0);
  if (metadata != null) {
    columns = metadata.getListColumns();        
  }
}

List< ? extends IConnection> conns = node.getIncomingConnections();
if(conns!=null){
	if (conns.size()>0){
		IConnection conn =conns.get(0);
        if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
            int sizeColumns = columns.size();
            
            for (int i = 0; i < sizeColumns; i++) {
                IMetadataColumn column = columns.get(i);
                JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
                //TODO type conversion
				
                if(column.isKey()){
				
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_6);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_7);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_8);
    
                }   
				
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_10);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_11);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_12);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_13);
    
            }
        }
    }
}


    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_17);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_20);
    stringBuffer.append(esIndex );
    stringBuffer.append(TEXT_21);
    stringBuffer.append(esType );
    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_23);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_24);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_25);
    stringBuffer.append(esIndex );
    stringBuffer.append(TEXT_26);
    stringBuffer.append(esType );
    stringBuffer.append(TEXT_27);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_28);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_32);
    stringBuffer.append(esBatchSize);
    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_34);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_36);
    stringBuffer.append(dieError );
    stringBuffer.append(TEXT_37);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_38);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_39);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_40);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_41);
    stringBuffer.append(verboseConsole );
    stringBuffer.append(TEXT_42);
    return stringBuffer.toString();
  }
}
