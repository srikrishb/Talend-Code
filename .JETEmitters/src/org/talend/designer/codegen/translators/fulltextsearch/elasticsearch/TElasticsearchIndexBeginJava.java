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
import java.util.ArrayList;
import java.util.HashMap;
import java.io.ByteArrayInputStream;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class TElasticsearchIndexBeginJava
{
  protected static String nl;
  public static synchronized TElasticsearchIndexBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TElasticsearchIndexBeginJava result = new TElasticsearchIndexBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + NL + NL + "\torg.elasticsearch.common.settings.Settings settings";
  protected final String TEXT_3 = " = null;" + NL + "\torg.elasticsearch.client.Client esClient";
  protected final String TEXT_4 = " = null;";
  protected final String TEXT_5 = NL + "\tsettings";
  protected final String TEXT_6 = " = org.elasticsearch.common.settings.ImmutableSettings.settingsBuilder().put(\"cluster.name\" , ";
  protected final String TEXT_7 = ").build();" + NL + "    \t\tesClient";
  protected final String TEXT_8 = " = new org.elasticsearch.client.transport.TransportClient(settings";
  protected final String TEXT_9 = ")" + NL + "    \t\t\t\t.addTransportAddress(new org.elasticsearch.common.transport.InetSocketTransportAddress(";
  protected final String TEXT_10 = ", Integer.valueOf(";
  protected final String TEXT_11 = ")));";
  protected final String TEXT_12 = NL + "        try{" + NL + "            settings";
  protected final String TEXT_13 = " = org.elasticsearch.common.settings.Settings.settingsBuilder().put(\"cluster.name\" , ";
  protected final String TEXT_14 = ").build();" + NL + "            esClient";
  protected final String TEXT_15 = " = org.elasticsearch.client.transport.TransportClient.builder().settings(settings";
  protected final String TEXT_16 = ").build()" + NL + "                    .addTransportAddress(new org.elasticsearch.common.transport.InetSocketTransportAddress(java.net.InetAddress.getByName(";
  protected final String TEXT_17 = "), Integer.valueOf(";
  protected final String TEXT_18 = ")));" + NL + "" + NL + "        } catch (Exception e){" + NL + "" + NL + "        }";
  protected final String TEXT_19 = NL + "int bulkRequestsSize";
  protected final String TEXT_20 = " = 0;" + NL + "int nb_line_";
  protected final String TEXT_21 = " = 0;" + NL + "org.elasticsearch.action.bulk.BulkRequestBuilder bulkRequest";
  protected final String TEXT_22 = " = esClient";
  protected final String TEXT_23 = ".prepareBulk();" + NL + NL + NL + NL;
  protected final String TEXT_24 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
     
    CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
    INode node = (INode)codeGenArgument.getArgument();
    String cid = node.getUniqueName();	
    String esClientHost = ElementParameterParser.getValue(node, "__ES_HOST__");
	String esClientPort = ElementParameterParser.getValue(node, "__ES_PORT__");
	String esClusterName = ElementParameterParser.getValue(node, "__ES_CLUSTER__");

    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_4);
    
	try {
		Class.forName("org.elasticsearch.common.settings.ImmutableSettings");


    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_6);
    stringBuffer.append(esClusterName);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_9);
    stringBuffer.append(esClientHost);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(esClientPort);
    stringBuffer.append(TEXT_11);
    
	} catch (ClassNotFoundException e) {

    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_13);
    stringBuffer.append(esClusterName);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_16);
    stringBuffer.append(esClientHost);
    stringBuffer.append(TEXT_17);
    stringBuffer.append(esClientPort);
    stringBuffer.append(TEXT_18);
    
	}

    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_23);
    stringBuffer.append(TEXT_24);
    return stringBuffer.toString();
  }
}
