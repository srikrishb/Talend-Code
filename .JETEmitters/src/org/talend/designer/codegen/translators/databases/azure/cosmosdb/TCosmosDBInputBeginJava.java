package org.talend.designer.codegen.translators.databases.azure.cosmosdb;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.process.IConnection;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.core.model.metadata.types.JavaType;
import org.talend.core.model.process.IConnectionCategory;
import java.util.List;
import java.util.Map;

public class TCosmosDBInputBeginJava
{
  protected static String nl;
  public static synchronized TCosmosDBInputBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TCosmosDBInputBeginJava result = new TCosmosDBInputBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "\t\t\t\tlog.debug(\"";
  protected final String TEXT_2 = " - Retrieving records from the datasource.\");" + NL + "\t\t\t";
  protected final String TEXT_3 = NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_4 = " - Retrieved records count: \"+ nb_line_";
  protected final String TEXT_5 = " + \" .\");" + NL + "\t\t\t";
  protected final String TEXT_6 = NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_7 = " - Retrieved records count: \"+ globalMap.get(\"";
  protected final String TEXT_8 = "_NB_LINE\") + \" .\");" + NL + "\t\t\t";
  protected final String TEXT_9 = NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_10 = " - Retrieved records count: \"+ nb_line_";
  protected final String TEXT_11 = " + \" .\");" + NL + "\t\t\t";
  protected final String TEXT_12 = NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_13 = " - Written records count: \" + nb_line_";
  protected final String TEXT_14 = " + \" .\");" + NL + "\t\t\t";
  protected final String TEXT_15 = NL + "\t\t\t\tfinal StringBuffer log4jSb_";
  protected final String TEXT_16 = " = new StringBuffer();" + NL + "\t\t\t";
  protected final String TEXT_17 = NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_18 = " - Retrieving the record \" + (nb_line_";
  protected final String TEXT_19 = ") + \".\");" + NL + "\t\t\t";
  protected final String TEXT_20 = NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_21 = " - Writing the record \" + nb_line_";
  protected final String TEXT_22 = " + \" to the file.\");" + NL + "\t\t\t";
  protected final String TEXT_23 = NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_24 = " - Processing the record \" + nb_line_";
  protected final String TEXT_25 = " + \".\");" + NL + "\t\t\t";
  protected final String TEXT_26 = NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_27 = " - Processed records count: \" + nb_line_";
  protected final String TEXT_28 = " + \" .\");" + NL + "\t\t\t";
  protected final String TEXT_29 = NL + "\tint nb_line_";
  protected final String TEXT_30 = " = 0;" + NL + "\t";
  protected final String TEXT_31 = NL + "\t\t\tcom.mongodb.Mongo mongo_";
  protected final String TEXT_32 = "=null;" + NL + "\t\t\tcom.mongodb.DB db_";
  protected final String TEXT_33 = "=null;" + NL + "\t\t\t";
  protected final String TEXT_34 = NL + "\t\t\t\tmongo_";
  protected final String TEXT_35 = "=(com.mongodb.Mongo)globalMap.get(\"mongo_";
  protected final String TEXT_36 = "\");" + NL + "\t\t\t\tdb_";
  protected final String TEXT_37 = " = (com.mongodb.DB) globalMap.get(\"db_";
  protected final String TEXT_38 = "\");" + NL + "\t\t\t\t";
  protected final String TEXT_39 = "\t" + NL + "\t\t\t\t\tlog.info(\"";
  protected final String TEXT_40 = " - Get an existing client from \" + \"";
  protected final String TEXT_41 = "\" + \".\");" + NL + "\t\t\t\t\tlog.info(\"";
  protected final String TEXT_42 = " - Get an existing DB from \" + \"";
  protected final String TEXT_43 = "\" + \".\");" + NL + "\t\t\t\t";
  protected final String TEXT_44 = NL + "\t\t\ttry{ // link with the \"finally\" on the \"finally.javajet\"" + NL + "\t\t\t\t";
  protected final String TEXT_45 = NL + NL + "                // Empty client options" + NL + "                com.mongodb.MongoClientOptions clientOptions_";
  protected final String TEXT_46 = " = new com.mongodb.MongoClientOptions.Builder().build();";
  protected final String TEXT_47 = NL + "                    clientOptions_";
  protected final String TEXT_48 = " = new com.mongodb.MongoClientOptions.Builder()" + NL + "                    .socketFactory(javax.net.ssl.SSLSocketFactory.getDefault())" + NL + "                    .build();";
  protected final String TEXT_49 = NL + "                // Empty client credentials list" + NL + "                java.util.List<com.mongodb.MongoCredential> mongoCredentialList_";
  protected final String TEXT_50 = " = new java.util.ArrayList<com.mongodb.MongoCredential>();" + NL;
  protected final String TEXT_51 = NL + "                    com.mongodb.MongoCredential mongoCredential_";
  protected final String TEXT_52 = ";";
  protected final String TEXT_53 = " " + NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_54 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_55 = ");";
  protected final String TEXT_56 = NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_57 = " = ";
  protected final String TEXT_58 = "; ";
  protected final String TEXT_59 = NL + "                    \t\t\tmongoCredential_";
  protected final String TEXT_60 = " = com.mongodb.MongoCredential.createCredential(";
  protected final String TEXT_61 = ", ";
  protected final String TEXT_62 = ", new String(decryptedPassword_";
  protected final String TEXT_63 = ").toCharArray());";
  protected final String TEXT_64 = NL + "                            mongoCredential_";
  protected final String TEXT_65 = " = com.mongodb.MongoCredential.createPlainCredential(";
  protected final String TEXT_66 = ", \"$external\", new String(decryptedPassword_";
  protected final String TEXT_67 = ").toCharArray());";
  protected final String TEXT_68 = NL + "                            mongoCredential_";
  protected final String TEXT_69 = " = com.mongodb.MongoCredential.createScramSha1Credential(";
  protected final String TEXT_70 = ", ";
  protected final String TEXT_71 = ", new String(decryptedPassword_";
  protected final String TEXT_72 = ").toCharArray());";
  protected final String TEXT_73 = NL + "                        System.setProperty(\"java.security.krb5.realm\", ";
  protected final String TEXT_74 = ");" + NL + "                        System.setProperty(\"java.security.krb5.kdc\", ";
  protected final String TEXT_75 = ");" + NL + "                        System.setProperty(\"javax.security.auth.useSubjectCredsOnly\", \"false\");" + NL + "                        mongoCredential_";
  protected final String TEXT_76 = " = com.mongodb.MongoCredential.createGSSAPICredential(";
  protected final String TEXT_77 = ");";
  protected final String TEXT_78 = NL + "                    mongoCredentialList_";
  protected final String TEXT_79 = ".add(mongoCredential_";
  protected final String TEXT_80 = ");";
  protected final String TEXT_81 = NL + "\t\t\t\t\tList<com.mongodb.ServerAddress> addrs_";
  protected final String TEXT_82 = " = new java.util.ArrayList<com.mongodb.ServerAddress>();" + NL + "\t\t\t\t\t";
  protected final String TEXT_83 = NL + "\t\t\t\t\t\taddrs_";
  protected final String TEXT_84 = ".add(new com.mongodb.ServerAddress(";
  protected final String TEXT_85 = ",";
  protected final String TEXT_86 = "));" + NL + "\t\t\t\t\t";
  protected final String TEXT_87 = NL + "                    mongo_";
  protected final String TEXT_88 = " = new ";
  protected final String TEXT_89 = "(addrs_";
  protected final String TEXT_90 = ", mongoCredentialList_";
  protected final String TEXT_91 = ", clientOptions_";
  protected final String TEXT_92 = ");";
  protected final String TEXT_93 = NL + "                    com.mongodb.ServerAddress serverAddress_";
  protected final String TEXT_94 = " = new com.mongodb.ServerAddress(";
  protected final String TEXT_95 = ", ";
  protected final String TEXT_96 = ");" + NL + "                    mongo_";
  protected final String TEXT_97 = " = new ";
  protected final String TEXT_98 = "(serverAddress_";
  protected final String TEXT_99 = ", mongoCredentialList_";
  protected final String TEXT_100 = ", clientOptions_";
  protected final String TEXT_101 = ");";
  protected final String TEXT_102 = NL + NL + "\t\t\t\tdb_";
  protected final String TEXT_103 = " = mongo_";
  protected final String TEXT_104 = ".getDB(";
  protected final String TEXT_105 = ");" + NL + "\t\t\t\t";
  protected final String TEXT_106 = NL + "\t\t\t            mongo_";
  protected final String TEXT_107 = ".setReadPreference(com.mongodb.ReadPreference.primary());" + NL + "\t\t\t            ";
  protected final String TEXT_108 = NL + "\t\t\t            mongo_";
  protected final String TEXT_109 = ".setReadPreference(com.mongodb.ReadPreference.primaryPreferred());" + NL + "\t\t\t            ";
  protected final String TEXT_110 = NL + "\t\t\t            mongo_";
  protected final String TEXT_111 = ".setReadPreference(com.mongodb.ReadPreference.secondary());" + NL + "\t\t\t            ";
  protected final String TEXT_112 = NL + "\t\t\t            mongo_";
  protected final String TEXT_113 = ".setReadPreference(com.mongodb.ReadPreference.secondaryPreferred());" + NL + "\t\t\t            ";
  protected final String TEXT_114 = NL + "\t\t\t            mongo_";
  protected final String TEXT_115 = ".setReadPreference(com.mongodb.ReadPreference.nearest());" + NL + "\t\t\t            ";
  protected final String TEXT_116 = NL + "\t\t\t            // Unhandled" + NL + "\t\t\t            ";
  protected final String TEXT_117 = NL + "\t\t            mongo_";
  protected final String TEXT_118 = ".addOption(com.mongodb.Bytes.QUERYOPTION_NOTIMEOUT);" + NL + "\t\t        ";
  protected final String TEXT_119 = "\t" + NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_120 = " - Connecting to \" + mongo_";
  protected final String TEXT_121 = ".getServerAddressList() + \".\");" + NL + "\t\t\t\t";
  protected final String TEXT_122 = NL + NL + "\t\t\t\tcom.mongodb.DBCollection coll_";
  protected final String TEXT_123 = " = db_";
  protected final String TEXT_124 = ".getCollection(";
  protected final String TEXT_125 = ");" + NL + "\t\t\t\t" + NL + "\t\t\t\ttry{" + NL + "\t\t\t\t\t// Add warning if an index is not in the query." + NL + "\t\t\t\t\tboolean needIndexWarning = true;" + NL + "\t\t\t\t\tString indexList = \"\";" + NL + "\t                for (com.mongodb.DBObject index: coll_";
  protected final String TEXT_126 = ".getIndexInfo()) {" + NL + "\t                    for (String key: ((com.mongodb.DBObject)index.get(\"key\")).keySet()) {" + NL + "\t                        // The regexp is:" + NL + "\t                        // - contain the db DBcolumnName between two backslashed quotes" + NL + "\t                        // - is followed at some point by a colon" + NL + "\t                        // - there is no comma between the the DBcolumnName and the colon" + NL + "\t                        if  ((";
  protected final String TEXT_127 = ").matches(\".*\" + key + \"[^,]*:.*\")) {" + NL + "\t                            // We have an index, do not print error message" + NL + "\t                            needIndexWarning = false;" + NL + "\t                        } else {" + NL + "\t                            // This index is not in the query, add it into the indexList" + NL + "\t                            indexList += \", \" + key;" + NL + "\t                        }" + NL + "\t                    }" + NL + "\t                }" + NL + "\t                if ((!\"\".equals(indexList)) && (needIndexWarning)) {" + NL + "\t                    ";
  protected final String TEXT_128 = NL + "\t                        log.warn(\"";
  protected final String TEXT_129 = " - The query does not contain any reference an index.  [\" + indexList.substring(1) + \" ]\");" + NL + "\t                        ";
  protected final String TEXT_130 = NL + "\t                        System.err.println(\"";
  protected final String TEXT_131 = " - The query does not contain any reference an index.  [\" + indexList.substring(1) + \" ]\");" + NL + "\t                        ";
  protected final String TEXT_132 = NL + "\t                }" + NL + "\t            }catch(com.mongodb.MongoException e){" + NL + "\t            \t// caught an exception after issuing the getIndexInfo()" + NL + "\t            \t// don't fail the whole job" + NL + "\t            \t// maybe due to authorization" + NL + "\t            }" + NL;
  protected final String TEXT_133 = NL + "\t                \tjava.util.List<com.mongodb.DBObject> aggregationStages = new java.util.ArrayList<com.mongodb.DBObject>();" + NL + "\t                ";
  protected final String TEXT_134 = NL + "\t                \taggregationStages.add((com.mongodb.DBObject) com.mongodb.util.JSON.parse(";
  protected final String TEXT_135 = "));" + NL + "\t                ";
  protected final String TEXT_136 = NL + "\t                com.mongodb.Cursor cursor_";
  protected final String TEXT_137 = " = coll_";
  protected final String TEXT_138 = ".aggregate(aggregationStages, com.mongodb.AggregationOptions.builder().outputMode(com.mongodb.AggregationOptions.OutputMode.CURSOR).allowDiskUse(";
  protected final String TEXT_139 = ").build());" + NL + "\t                ";
  protected final String TEXT_140 = NL + "\t                com.mongodb.DBObject myQuery_";
  protected final String TEXT_141 = " = (com.mongodb.DBObject) com.mongodb.util.JSON.parse(";
  protected final String TEXT_142 = ");" + NL + "\t\t    \t\tcom.mongodb.DBObject fields_";
  protected final String TEXT_143 = " = new com.mongodb.BasicDBObject();" + NL + "\t\t  \t\t\tcom.mongodb.DBCursor cursor_";
  protected final String TEXT_144 = " = coll_";
  protected final String TEXT_145 = ".find(myQuery_";
  protected final String TEXT_146 = ", fields_";
  protected final String TEXT_147 = ");" + NL + "\t                ";
  protected final String TEXT_148 = NL + "\t\t\t\t" + NL + "\t\t\t\tclass DBObjectInputUtil_";
  protected final String TEXT_149 = "{" + NL + "\t\t\t\t\t// Get the node value in embedded document, " + NL + "\t\t\t\t\t//If have no embedded document get root document node." + NL + "\t\t\t\t\tpublic Object getValue(String parentNode,String currentName,com.mongodb.DBObject dbObject){" + NL + "\t\t\t\t\t\tObject value=null;" + NL + "\t\t\t\t\t\tif(dbObject==null){" + NL + "\t\t\t\t\t\t\treturn null;" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\tif (parentNode == null || \"\".equals(parentNode)) {" + NL + "\t\t\t\t\t\t    if (\"*\".equals(currentName)) {" + NL + "\t\t\t\t\t\t        value = dbObject;" + NL + "\t\t\t\t\t\t    } else if (dbObject.get(currentName)!=null){" + NL + "\t\t\t\t\t\t\t\tvalue=dbObject.get(currentName);" + NL + "\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t}else{" + NL + "\t\t\t\t\t\t\tString objNames[] = objNames = parentNode.split(\"\\\\.\");" + NL + "\t\t\t\t\t\t\tcom.mongodb.DBObject currentObj=dbObject;" + NL + "\t\t\t\t\t\t\tfor(int i=0;i<objNames.length;i++){" + NL + "\t\t\t\t\t\t\t\tcurrentObj=(com.mongodb.DBObject)currentObj.get(objNames[i]);" + NL + "\t\t\t\t\t\t\t\tif(currentObj==null){" + NL + "\t\t\t\t\t\t\t\t\tbreak;" + NL + "\t\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t\tif (\"*\".equals(currentName)) {" + NL + "                                value = currentObj;" + NL + "                            } else if(currentObj!=null){" + NL + "\t\t\t\t\t\t\t\tvalue=currentObj.get(currentName);" + NL + "\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\treturn value;" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t}" + NL + "\t\t\t\tDBObjectInputUtil_";
  protected final String TEXT_150 = " dbObjectInputUtil_";
  protected final String TEXT_151 = "=new DBObjectInputUtil_";
  protected final String TEXT_152 = "();" + NL + "\t\t\t\tjava.util.Map<String, String> pathMap_";
  protected final String TEXT_153 = "=new java.util.HashMap<String, String>();";
  protected final String TEXT_154 = NL + "\t\t\t\tpathMap_";
  protected final String TEXT_155 = ".put(\"";
  protected final String TEXT_156 = "\",";
  protected final String TEXT_157 = ");";
  protected final String TEXT_158 = NL + "\t  \t\t\tcursor_";
  protected final String TEXT_159 = " = cursor_";
  protected final String TEXT_160 = ".limit(";
  protected final String TEXT_161 = ");";
  protected final String TEXT_162 = NL + "\t\t  \t\tcom.mongodb.DBObject orderBy_";
  protected final String TEXT_163 = " = new com.mongodb.BasicDBObject();";
  protected final String TEXT_164 = NL + "\t\t  \t\torderBy_";
  protected final String TEXT_165 = ".put(";
  protected final String TEXT_166 = ",";
  protected final String TEXT_167 = ");";
  protected final String TEXT_168 = NL + "\t\t\t\tcursor_";
  protected final String TEXT_169 = ".sort(orderBy_";
  protected final String TEXT_170 = ");";
  protected final String TEXT_171 = NL + "\t\t\t\twhile (cursor_";
  protected final String TEXT_172 = ".hasNext()){";
  protected final String TEXT_173 = NL + "\t\t\t\tcom.mongodb.DBObject o_";
  protected final String TEXT_174 = " = cursor_";
  protected final String TEXT_175 = ".next();" + NL + "\t\t\t\tnb_line_";
  protected final String TEXT_176 = "++;";
  protected final String TEXT_177 = NL + "\t\t\t\tObject valueObj_";
  protected final String TEXT_178 = "=null;";
  protected final String TEXT_179 = NL + "                    valueObj_";
  protected final String TEXT_180 = "=dbObjectInputUtil_";
  protected final String TEXT_181 = ".getValue(pathMap_";
  protected final String TEXT_182 = ".get(\"";
  protected final String TEXT_183 = "\"),\"";
  protected final String TEXT_184 = "\",o_";
  protected final String TEXT_185 = ");";
  protected final String TEXT_186 = NL + "\t\t\t\t";
  protected final String TEXT_187 = ".";
  protected final String TEXT_188 = " = valueObj_";
  protected final String TEXT_189 = ";";
  protected final String TEXT_190 = NL + "\t\t\t\tif(valueObj_";
  protected final String TEXT_191 = "!=null && valueObj_";
  protected final String TEXT_192 = ".toString().length() > 0) {";
  protected final String TEXT_193 = NL + "                            if (valueObj_";
  protected final String TEXT_194 = " instanceof java.util.Date) {" + NL + "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_195 = ".";
  protected final String TEXT_196 = " = ParserUtils.parseTo_Date((java.util.Date)valueObj_";
  protected final String TEXT_197 = ", ";
  protected final String TEXT_198 = ");" + NL + "                            } else {";
  protected final String TEXT_199 = NL + "                                ";
  protected final String TEXT_200 = ".";
  protected final String TEXT_201 = " = ParserUtils.parseTo_Date((String)valueObj_";
  protected final String TEXT_202 = ", ";
  protected final String TEXT_203 = ");" + NL + "                            }";
  protected final String TEXT_204 = NL + "\t\t\t\t\t";
  protected final String TEXT_205 = ".";
  protected final String TEXT_206 = " = java.nio.charset.Charset.defaultCharset().decode(java.nio.ByteBuffer.wrap((byte[])valueObj_";
  protected final String TEXT_207 = ")).toString().getBytes(utf8Charset);";
  protected final String TEXT_208 = NL + "\t\t\t\t\t";
  protected final String TEXT_209 = ".";
  protected final String TEXT_210 = " = valueObj_";
  protected final String TEXT_211 = ".toString();";
  protected final String TEXT_212 = NL + "                            if (valueObj_";
  protected final String TEXT_213 = ".getClass().equals(Double.class)) {";
  protected final String TEXT_214 = NL + "                                ";
  protected final String TEXT_215 = ".";
  protected final String TEXT_216 = " = ParserUtils.parseTo_Double(valueObj_";
  protected final String TEXT_217 = ".toString()).intValue();" + NL + "                            } else {";
  protected final String TEXT_218 = NL + "                                ";
  protected final String TEXT_219 = ".";
  protected final String TEXT_220 = " = ParserUtils.parseTo_";
  protected final String TEXT_221 = "(valueObj_";
  protected final String TEXT_222 = ".toString());" + NL + "                            }";
  protected final String TEXT_223 = NL + "                            if (valueObj_";
  protected final String TEXT_224 = ".getClass().equals(Double.class)) {";
  protected final String TEXT_225 = NL + "                                ";
  protected final String TEXT_226 = ".";
  protected final String TEXT_227 = " = ParserUtils.parseTo_Double(valueObj_";
  protected final String TEXT_228 = ".toString()).longValue();" + NL + "                            } else {";
  protected final String TEXT_229 = NL + "                                ";
  protected final String TEXT_230 = ".";
  protected final String TEXT_231 = " = ParserUtils.parseTo_";
  protected final String TEXT_232 = "(valueObj_";
  protected final String TEXT_233 = ".toString());" + NL + "                            }";
  protected final String TEXT_234 = NL + "                            if (valueObj_";
  protected final String TEXT_235 = ".getClass().equals(Double.class)) {";
  protected final String TEXT_236 = NL + "                                ";
  protected final String TEXT_237 = ".";
  protected final String TEXT_238 = " = ParserUtils.parseTo_Double(valueObj_";
  protected final String TEXT_239 = ".toString()).shortValue();" + NL + "                            } else {";
  protected final String TEXT_240 = NL + "                                ";
  protected final String TEXT_241 = ".";
  protected final String TEXT_242 = " = ParserUtils.parseTo_";
  protected final String TEXT_243 = "(valueObj_";
  protected final String TEXT_244 = ".toString());" + NL + "                            }";
  protected final String TEXT_245 = NL + "                            ";
  protected final String TEXT_246 = ".";
  protected final String TEXT_247 = " = ParserUtils.parseTo_";
  protected final String TEXT_248 = "(valueObj_";
  protected final String TEXT_249 = ".toString());";
  protected final String TEXT_250 = NL + "\t\t\t\t}else{" + NL + "\t\t\t\t\t";
  protected final String TEXT_251 = ".";
  protected final String TEXT_252 = " = ";
  protected final String TEXT_253 = ";" + NL + "\t\t\t\t}";
  protected final String TEXT_254 = NL;
  protected final String TEXT_255 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
	//this util class use by set log4j debug paramters
	class DefaultLog4jFileUtil {
	
		INode node = null;
	    String cid = null;
 		boolean isLog4jEnabled = false;
 		String label = null;
 		
 		public DefaultLog4jFileUtil(){
 		}
 		public DefaultLog4jFileUtil(INode node) {
 			this.node = node;
 			this.cid = node.getUniqueName();
 			this.label = cid;
			this.isLog4jEnabled = ("true").equals(org.talend.core.model.process.ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));
 		}
 		
 		public void setCid(String cid) {
 			this.cid = cid;
 		}
 		
		//for all tFileinput* components 
		public void startRetriveDataInfo() {
			if (isLog4jEnabled) {
			
    stringBuffer.append(TEXT_1);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_2);
    
			}
		}
		
		public void retrievedDataNumberInfo() {
			if (isLog4jEnabled) {
			
    stringBuffer.append(TEXT_3);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    
			}
		}
		
		public void retrievedDataNumberInfoFromGlobalMap(INode node) {
			if (isLog4jEnabled) {
			
    stringBuffer.append(TEXT_6);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_8);
    
			}
		}
		
		//for all tFileinput* components 
		public void retrievedDataNumberInfo(INode node) {
			if (isLog4jEnabled) {
			
    stringBuffer.append(TEXT_9);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_11);
    
			}
		}
		
		public void writeDataFinishInfo(INode node) {
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_12);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_14);
    
			}
		}
		
 		//TODO delete it and remove all log4jSb parameter from components
		public void componentStartInfo(INode node) {
			if (isLog4jEnabled) {
			
    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_16);
    
			}
		}
		
		//TODO rename or delete it
		public void debugRetriveData(INode node,boolean hasIncreased) {
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_17);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid);
    stringBuffer.append(hasIncreased?"":"+1");
    stringBuffer.append(TEXT_19);
    
			}
		}
		
		//TODO rename or delete it
		public void debugRetriveData(INode node) {
			debugRetriveData(node,true);
		}
		
		//TODO rename or delete it
		public void debugWriteData(INode node) {
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_20);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_22);
    
			}
		}
		
		public void logCurrentRowNumberInfo() {
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_23);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_24);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_25);
    
			}
		}
		
		public void logDataCountInfo() {
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_26);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_27);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_28);
    
			}
		}
	}
	
	final DefaultLog4jFileUtil log4jFileUtil = new DefaultLog4jFileUtil((INode)(((org.talend.designer.codegen.config.CodeGeneratorArgument)argument).getArgument()));
	
    
  	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
  	INode node = (INode)codeGenArgument.getArgument();
  	String cid = node.getUniqueName();

    String dbhost   = ElementParameterParser.getValue(node, "__HOST__");
    String dbname   = ElementParameterParser.getValue(node, "__DATABASE__");
    String dbuser   = ElementParameterParser.getValue(node, "__USERNAME__");
    boolean authentication="true".equalsIgnoreCase(ElementParameterParser.getValue(node, "__REQUIRED_AUTHENTICATION__"));
    String authenticationMechanism = ElementParameterParser.getValue(node, "__AUTHENTICATION_MECHANISM__");
    String krbUserPrincipal = ElementParameterParser.getValue(node, "__KRB_USER_PRINCIPAL__");
    String krbRealm = ElementParameterParser.getValue(node, "__KRB_REALM__");
    String krbKdc = ElementParameterParser.getValue(node, "__KRB_KDC__");
    String dbpass   = ElementParameterParser.getValue(node, "__PASSWORD__");
    String mongoPort = ElementParameterParser.getValue(node, "__PORT__");
    String dbport = mongoPort.startsWith("context.") ? "Integer.valueOf(" + mongoPort + ").intValue()" : mongoPort.replace("\"", "");
    boolean useExistingConnection = "true".equalsIgnoreCase(ElementParameterParser.getValue(node,"__USE_EXISTING_CONNECTION__"));
    String collection = ElementParameterParser.getValue(node,"__COLLECTION__");
    String query = ElementParameterParser.getValue(node,"__QUERY__");
    query = query.replaceAll("\n","");
    query = query.replaceAll("\r","");
  	String limit = ElementParameterParser.getValue(node,"__LIMIT__");

  	List<Map<String, String>> mapping = (List<Map<String,String>>)ElementParameterParser.getObjectValueXML(node, "__MAPPING__");
  	List<Map<String, String>> sorts = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__SORT__");
  	boolean useReplicaSet="true".equalsIgnoreCase(ElementParameterParser.getValue(node, "__USE_REPLICA_SET__"));
  	boolean setReadPreference = "true".equalsIgnoreCase(ElementParameterParser.getValue(node, "__SET_READ_PREFERENCE__"));
    String readPreference = ElementParameterParser.getValue(node, "__READ_PREFERENCE__");
    boolean isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));
    List<Map<String, String>> aggregationStages = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__AGGREGATION_STAGES__");
    boolean isAggregationQuery = "AGGREGATION_QUERY".equals(ElementParameterParser.getValue(node,"__QUERY_TYPE__"));
    boolean useAuthDB = "true".equalsIgnoreCase(ElementParameterParser.getValue(node, "__SET_AUTHENTICATION_DATABASE__"));
    String authDB = ElementParameterParser.getValue(node, "__AUTHENTICATION_DATABASE__");
    String usedAuthenticationDB = useAuthDB ? authDB : dbname;
    boolean useExternalSort = "true".equalsIgnoreCase(ElementParameterParser.getValue(node, "__EXTERNAL_SORT_AGGREGATION__"));
    boolean queryOptionNoTimeOut = "true".equalsIgnoreCase(ElementParameterParser.getValue(node, "__QUERYOPTION_NOTIMEOUT__"));

  	List<IMetadataTable> metadatas = node.getMetadataList();
  	List<IMetadataColumn> columnList = null;
  	List<? extends IConnection> outputs = node.getOutgoingSortedConnections();
  	String firstConnName = "";
  	if (outputs.size() > 0){
		IConnection out = outputs.get(0);
		if(out!=null && out.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)){
			firstConnName = out.getName();
		}
    }
	
    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_30);
    
  	if(metadatas != null && metadatas.size() > 0){
      	IMetadataTable metadata = metadatas.get(0);
      	if(metadata != null){
		
    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_33);
    
      		if (useExistingConnection){
      			String connection = ElementParameterParser.getValue(node, "__CONNECTION__");
				
    stringBuffer.append(TEXT_34);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_35);
    stringBuffer.append(connection);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_37);
    stringBuffer.append(connection);
    stringBuffer.append(TEXT_38);
    
				if(isLog4jEnabled){
				
    stringBuffer.append(TEXT_39);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_40);
    stringBuffer.append(connection);
    stringBuffer.append(TEXT_41);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_42);
    stringBuffer.append(connection);
    stringBuffer.append(TEXT_43);
    
				}
			}else{
			
    stringBuffer.append(TEXT_44);
    
	 			List<Map<String,String>> replicaAddrs= (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__REPLICA_SET__");

                boolean useSSL = "true".equalsIgnoreCase(ElementParameterParser.getValue(node, "__USE_SSL__"));
                String mongoDbDriver = "com.mongodb.MongoClient";
                
    stringBuffer.append(TEXT_45);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_46);
    
                if (useSSL) {
                    
    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_48);
    
                }
                
                // Client Credentials
                
    stringBuffer.append(TEXT_49);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_50);
    
                // Authentication
                if (authentication){
                    
    stringBuffer.append(TEXT_51);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_52);
    
                    if((authenticationMechanism.equals("NEGOTIATE_MEC"))||(authenticationMechanism.equals("PLAIN_MEC"))||(authenticationMechanism.equals("SCRAMSHA1_MEC"))){
                        String passwordFieldName = "__PASSWORD__";
                        
    if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_53);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_54);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_55);
    } else {
    stringBuffer.append(TEXT_56);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_57);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_58);
    }
    
                        if(authenticationMechanism.equals("NEGOTIATE_MEC")){

    stringBuffer.append(TEXT_59);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_60);
    stringBuffer.append(dbuser);
    stringBuffer.append(TEXT_61);
    stringBuffer.append(usedAuthenticationDB);
    stringBuffer.append(TEXT_62);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_63);
                        
                        } else if(authenticationMechanism.equals("PLAIN_MEC")){
                            
    stringBuffer.append(TEXT_64);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_65);
    stringBuffer.append(dbuser);
    stringBuffer.append(TEXT_66);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_67);
    
                        } else if(authenticationMechanism.equals("SCRAMSHA1_MEC")){
                            
    stringBuffer.append(TEXT_68);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_69);
    stringBuffer.append(dbuser);
    stringBuffer.append(TEXT_70);
    stringBuffer.append(usedAuthenticationDB);
    stringBuffer.append(TEXT_71);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_72);
    
                        }
                    } else { // GSSAPI SASL (KERBEROS)
                        
    stringBuffer.append(TEXT_73);
    stringBuffer.append(krbRealm);
    stringBuffer.append(TEXT_74);
    stringBuffer.append(krbKdc);
    stringBuffer.append(TEXT_75);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_76);
    stringBuffer.append(krbUserPrincipal);
    stringBuffer.append(TEXT_77);
    
                    }
                    
    stringBuffer.append(TEXT_78);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_79);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_80);
    
                }

                // the client
				if(useReplicaSet){
				    
    stringBuffer.append(TEXT_81);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_82);
    
					for(Map<String,String> replicaAddr:replicaAddrs){
					
    stringBuffer.append(TEXT_83);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_84);
    stringBuffer.append(replicaAddr.get("REPLICA_HOST"));
    stringBuffer.append(TEXT_85);
    stringBuffer.append(replicaAddr.get("REPLICA_PORT"));
    stringBuffer.append(TEXT_86);
    
					}
                    
    stringBuffer.append(TEXT_87);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_88);
    stringBuffer.append(mongoDbDriver);
    stringBuffer.append(TEXT_89);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_90);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_91);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_92);
    
				}else{
                    
    stringBuffer.append(TEXT_93);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_94);
    stringBuffer.append(dbhost);
    stringBuffer.append(TEXT_95);
    stringBuffer.append(dbport);
    stringBuffer.append(TEXT_96);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_97);
    stringBuffer.append(mongoDbDriver);
    stringBuffer.append(TEXT_98);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_99);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_100);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_101);
    
				}
                
    stringBuffer.append(TEXT_102);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_103);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_104);
    stringBuffer.append(dbname);
    stringBuffer.append(TEXT_105);
    
			}

			if (setReadPreference) {
			        if (readPreference.equals("PRIMARY")) {
			            
    stringBuffer.append(TEXT_106);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_107);
    
			        } else if (readPreference.equals("PRIMARY_PREFERRED")) {
			            
    stringBuffer.append(TEXT_108);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_109);
    
			        } else if (readPreference.equals("SECONDARY")) {
			            
    stringBuffer.append(TEXT_110);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_111);
    
			        } else if (readPreference.equals("SECONDARY_PREFERRED")) {
			            
    stringBuffer.append(TEXT_112);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_113);
    
			        } else if (readPreference.equals("NEAREST")) {
			            
    stringBuffer.append(TEXT_114);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_115);
    
			        } else {
			            
    stringBuffer.append(TEXT_116);
    
			        }
			}

			if(queryOptionNoTimeOut && !useExistingConnection){
		        
    stringBuffer.append(TEXT_117);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_118);
    
    		}

			if(isLog4jEnabled){
			    
    stringBuffer.append(TEXT_119);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_120);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_121);
    
			}
			log4jFileUtil.startRetriveDataInfo();

			
    stringBuffer.append(TEXT_122);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_123);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_124);
    stringBuffer.append(collection);
    stringBuffer.append(TEXT_125);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_126);
    stringBuffer.append(query);
    stringBuffer.append(TEXT_127);
    
	                    if(isLog4jEnabled){
	                        
    stringBuffer.append(TEXT_128);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_129);
    
	                    } else {
	                        
    stringBuffer.append(TEXT_130);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_131);
    
	                    }
	                    
    stringBuffer.append(TEXT_132);
    
                // AGGREGATION QUERY
                if(isAggregationQuery){
	                
    stringBuffer.append(TEXT_133);
    
	                for (int i=0; i<aggregationStages.size(); i++){
	                
    stringBuffer.append(TEXT_134);
    stringBuffer.append(aggregationStages.get(i).get("AGGREGATION_STAGE"));
    stringBuffer.append(TEXT_135);
    
	                }
	                
    stringBuffer.append(TEXT_136);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_137);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_138);
    stringBuffer.append(useExternalSort);
    stringBuffer.append(TEXT_139);
    
	            // FIND QUERY
                } else {
	                
    stringBuffer.append(TEXT_140);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_141);
    stringBuffer.append(query);
    stringBuffer.append(TEXT_142);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_143);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_144);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_145);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_146);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_147);
    
                }
                
    stringBuffer.append(TEXT_148);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_149);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_150);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_151);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_152);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_153);
    
			for (int i=0;i<mapping.size();i++) {
				String path = mapping.get(i).get("PARENT_NODE_PATH");
				if(path==null || "".equals(path)){
					path="\"\"";
				}
				String schemaColumn=mapping.get(i).get("SCHEMA_COLUMN");

    stringBuffer.append(TEXT_154);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_155);
    stringBuffer.append(schemaColumn);
    stringBuffer.append(TEXT_156);
    stringBuffer.append(path);
    stringBuffer.append(TEXT_157);
    
			}

			// Note: Aggregation queriess do not support limit
			if (limit != null && !"\"\"".equals(limit) && limit.length() > 0 && !isAggregationQuery){

    stringBuffer.append(TEXT_158);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_159);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_160);
    stringBuffer.append(limit);
    stringBuffer.append(TEXT_161);
    
			}

			// Note: Aggregation queriess do not support sort
			if(sorts.size()>0 && !isAggregationQuery){

    stringBuffer.append(TEXT_162);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_163);
    
				for(Map<String, String> line:sorts){
					int order=-1;
					if(("asc").equals(line.get("ORDER"))){
        				order=1;
        			}

    stringBuffer.append(TEXT_164);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_165);
    stringBuffer.append(line.get("COLNAME"));
    stringBuffer.append(TEXT_166);
    stringBuffer.append(order);
    stringBuffer.append(TEXT_167);
    
				}

    stringBuffer.append(TEXT_168);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_169);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_170);
    
			}

    stringBuffer.append(TEXT_171);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_172);
    
          	columnList = metadata.getListColumns();
          	int sizeColumns = columnList.size();

    stringBuffer.append(TEXT_173);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_174);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_175);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_176);
    
			if(firstConnName.length()>0){

    stringBuffer.append(TEXT_177);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_178);
    
				for (int i = 0; i < sizeColumns; i++) {
					IMetadataColumn column = columnList.get(i);
					String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getTalendType(), column.isNullable());
					JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
					String patternValue = column.getPattern() == null || column.getPattern().trim().length() == 0 ? null : column.getPattern();

    stringBuffer.append(TEXT_179);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_180);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_181);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_182);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_183);
    stringBuffer.append(column.getOriginalDbColumnName() );
    stringBuffer.append(TEXT_184);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_185);
    
          			if(javaType == JavaTypesManager.OBJECT) {

    stringBuffer.append(TEXT_186);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_187);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_188);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_189);
    
          			}else{

    stringBuffer.append(TEXT_190);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_191);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_192);
    
						if(javaType == JavaTypesManager.DATE) {

    stringBuffer.append(TEXT_193);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_194);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_195);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_196);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_197);
    stringBuffer.append( patternValue );
    stringBuffer.append(TEXT_198);
    stringBuffer.append(TEXT_199);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_200);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_201);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_202);
    stringBuffer.append( patternValue );
    stringBuffer.append(TEXT_203);
    
						}else if(javaType == JavaTypesManager.BYTE_ARRAY) {

    stringBuffer.append(TEXT_204);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_205);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_206);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_207);
    
						} else if(javaType == JavaTypesManager.STRING){

    stringBuffer.append(TEXT_208);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_209);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_210);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_211);
    
						} else if (javaType == JavaTypesManager.INTEGER){

    stringBuffer.append(TEXT_212);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_213);
    stringBuffer.append(TEXT_214);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_215);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_216);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_217);
    stringBuffer.append(TEXT_218);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_219);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_220);
    stringBuffer.append(typeToGenerate );
    stringBuffer.append(TEXT_221);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_222);
    
                        } else if (javaType == JavaTypesManager.LONG){

    stringBuffer.append(TEXT_223);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_224);
    stringBuffer.append(TEXT_225);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_226);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_227);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_228);
    stringBuffer.append(TEXT_229);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_230);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_231);
    stringBuffer.append(typeToGenerate );
    stringBuffer.append(TEXT_232);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_233);
    
                        } else if (javaType == JavaTypesManager.SHORT){

    stringBuffer.append(TEXT_234);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_235);
    stringBuffer.append(TEXT_236);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_237);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_238);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_239);
    stringBuffer.append(TEXT_240);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_241);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_242);
    stringBuffer.append(typeToGenerate );
    stringBuffer.append(TEXT_243);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_244);
    
                        } else {

    stringBuffer.append(TEXT_245);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_246);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_247);
    stringBuffer.append(typeToGenerate );
    stringBuffer.append(TEXT_248);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_249);
    
						}

    stringBuffer.append(TEXT_250);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_251);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_252);
    stringBuffer.append(JavaTypesManager.getDefaultValueFromJavaType(typeToGenerate));
    stringBuffer.append(TEXT_253);
    
          			}
				}
				log4jFileUtil.debugRetriveData(node);
			}
      	}
  	}

    stringBuffer.append(TEXT_254);
    stringBuffer.append(TEXT_255);
    return stringBuffer.toString();
  }
}
