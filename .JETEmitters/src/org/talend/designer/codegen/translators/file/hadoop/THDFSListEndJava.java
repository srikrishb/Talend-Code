package org.talend.designer.codegen.translators.file.hadoop;

import org.talend.core.model.process.INode;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.ElementParameterParser;

public class THDFSListEndJava
{
  protected static String nl;
  public static synchronized THDFSListEndJava create(String lineSeparator)
  {
    nl = lineSeparator;
    THDFSListEndJava result = new THDFSListEndJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "    }//TD512" + NL + "  }//TD1024" + NL + "  globalMap.put(\"";
  protected final String TEXT_3 = "_NB_FILE\", NB_FILE";
  protected final String TEXT_4 = ");";
  protected final String TEXT_5 = NL + "    log.info(\"";
  protected final String TEXT_6 = " - File or directory count : \" + NB_FILE";
  protected final String TEXT_7 = ");";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	String cid = node.getUniqueName();
	
	boolean isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));

    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_4);
    
	if(isLog4jEnabled) {

    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_7);
    
	}

    return stringBuffer.toString();
  }
}
