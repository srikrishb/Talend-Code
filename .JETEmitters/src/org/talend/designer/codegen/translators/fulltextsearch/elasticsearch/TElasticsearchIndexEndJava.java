package org.talend.designer.codegen.translators.fulltextsearch.elasticsearch;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.core.model.metadata.types.JavaType;
import java.util.List;
import java.util.Map;

public class TElasticsearchIndexEndJava
{
  protected static String nl;
  public static synchronized TElasticsearchIndexEndJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TElasticsearchIndexEndJava result = new TElasticsearchIndexEndJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "    globalMap.put(\"";
  protected final String TEXT_2 = "_NB_LINE\", nb_line_";
  protected final String TEXT_3 = ");";
  protected final String TEXT_4 = NL + "if(bulkRequestsSize";
  protected final String TEXT_5 = " > 0){" + NL + "    org.elasticsearch.action.bulk.BulkResponse response";
  protected final String TEXT_6 = " = bulkRequest";
  protected final String TEXT_7 = ".execute().actionGet();" + NL + "    if(response";
  protected final String TEXT_8 = ".hasFailures()){" + NL + "    \t\t" + NL + "    }" + NL + "}" + NL + "esClient";
  protected final String TEXT_9 = ".close();";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();
String cid = node.getUniqueName();	
List<IMetadataTable> metadatas = node.getMetadataList();

if (metadatas != null && metadatas.size() > 0) {
  IMetadataTable metadata = metadatas.get(0);
  
  if (metadata != null) {
    stringBuffer.append(TEXT_1);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    }
}
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_9);
    return stringBuffer.toString();
  }
}
