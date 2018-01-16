package org.talend.designer.codegen.translators.elt.map.hive;

import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.process.IConnection;
import org.talend.designer.runprocess.ProcessorException;
import org.talend.designer.runprocess.ProcessorUtilities;
import java.util.List;
import java.util.Map;

public class TELTHiveOutputMainJava
{
  protected static String nl;
  public static synchronized TELTHiveOutputMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TELTHiveOutputMainJava result = new TELTHiveOutputMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "    String select_query_";
  protected final String TEXT_3 = " = null;" + NL + "    String tableName_";
  protected final String TEXT_4 = " = null;";
  protected final String TEXT_5 = NL + "        select_query_";
  protected final String TEXT_6 = " = (String) globalMap.get(\"";
  protected final String TEXT_7 = "\"+\"QUERY\"+\"";
  protected final String TEXT_8 = "\");" + NL;
  protected final String TEXT_9 = NL + "        String dbschema_";
  protected final String TEXT_10 = " = ";
  protected final String TEXT_11 = ";" + NL + "        if(dbschema_";
  protected final String TEXT_12 = " != null && dbschema_";
  protected final String TEXT_13 = ".trim().length() > 0) {" + NL + "             tableName_";
  protected final String TEXT_14 = " = ";
  protected final String TEXT_15 = " + \".\" + ";
  protected final String TEXT_16 = ";" + NL + "        } else {" + NL + "            tableName_";
  protected final String TEXT_17 = " = ";
  protected final String TEXT_18 = ";" + NL + "        }";
  protected final String TEXT_19 = NL + "\tjava.io.File localPigLatin_";
  protected final String TEXT_20 = " = new java.io.File(projectName + \"_\" + jobName + \"_\" + Thread.currentThread().getId() +\".hive\");" + NL + "\tjava.io.FileWriter fw_";
  protected final String TEXT_21 = " = new java.io.FileWriter(localPigLatin_";
  protected final String TEXT_22 = ".getAbsoluteFile());" + NL + "\tjava.io.BufferedWriter bw_";
  protected final String TEXT_23 = " = new java.io.BufferedWriter(fw_";
  protected final String TEXT_24 = ");" + NL + "\tjava.lang.StringBuilder libjars_";
  protected final String TEXT_25 = " = new StringBuilder();";
  protected final String TEXT_26 = " " + NL + "\t\t\tfinal String hdInsightPassword_";
  protected final String TEXT_27 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_28 = ");";
  protected final String TEXT_29 = NL + "\t\t\tfinal String hdInsightPassword_";
  protected final String TEXT_30 = " = ";
  protected final String TEXT_31 = "; ";
  protected final String TEXT_32 = " " + NL + "\t\t\tfinal String wasbPassword_";
  protected final String TEXT_33 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_34 = ");";
  protected final String TEXT_35 = NL + "\t\t\tfinal String wasbPassword_";
  protected final String TEXT_36 = " = ";
  protected final String TEXT_37 = "; ";
  protected final String TEXT_38 = NL + "\t\torg.talend.bigdata.launcher.fs.FileSystem azureFs_";
  protected final String TEXT_39 = " = new org.talend.bigdata.launcher.fs.AzureFileSystem(\"DefaultEndpointsProtocol=https;\"" + NL + "\t\t\t+ \"AccountName=\"" + NL + "\t\t\t+ ";
  protected final String TEXT_40 = NL + "\t\t\t+ \";\"" + NL + "\t\t\t+ \"AccountKey=\" + wasbPassword_";
  protected final String TEXT_41 = ", ";
  protected final String TEXT_42 = ");" + NL + "\t\t\t\t" + NL + "\t\torg.talend.bigdata.launcher.webhcat.WebHCatJob instance_";
  protected final String TEXT_43 = " = new org.talend.bigdata.launcher.webhcat.QueryJob(azureFs_";
  protected final String TEXT_44 = ", org.talend.bigdata.launcher.utils.JobType.HIVE);" + NL + "\t\t\t\t\t\t" + NL + "\t\tinstance_";
  protected final String TEXT_45 = ".setCredentials(new org.talend.bigdata.launcher.security.HDInsightCredentials(";
  protected final String TEXT_46 = ", hdInsightPassword_";
  protected final String TEXT_47 = "));" + NL + "\t\tinstance_";
  protected final String TEXT_48 = ".setUsername(";
  protected final String TEXT_49 = ");" + NL + "\t\tinstance_";
  protected final String TEXT_50 = ".setWebhcatEndpoint(\"https\", ";
  protected final String TEXT_51 = " + \":\" + ";
  protected final String TEXT_52 = ");" + NL + "\t\tinstance_";
  protected final String TEXT_53 = ".setStatusFolder(org.talend.bigdata.launcher.utils.Utils.removeFirstSlash(";
  protected final String TEXT_54 = "));" + NL + "\t\tinstance_";
  protected final String TEXT_55 = ".setRemoteFolder(org.talend.bigdata.launcher.utils.Utils.removeFirstSlash(";
  protected final String TEXT_56 = "));";
  protected final String TEXT_57 = NL + "\t\torg.talend.bigdata.launcher.webhcat.WebHCatJob instance_";
  protected final String TEXT_58 = " = (org.talend.bigdata.launcher.webhcat.WebHCatJob) globalMap.get(\"conn_";
  protected final String TEXT_59 = "\");" + NL + "\t\t" + NL + "\t\torg.talend.bigdata.launcher.fs.FileSystem azureFs_";
  protected final String TEXT_60 = " = instance_";
  protected final String TEXT_61 = ".getFileSystem();\t\t" + NL + "\t\t" + NL + "\t\tjava.util.List<String> connectionCommandList_";
  protected final String TEXT_62 = " = (java.util.List<String>)globalMap.get(\"commandList_";
  protected final String TEXT_63 = "\");" + NL + "\t\tfor(String command : connectionCommandList_";
  protected final String TEXT_64 = ") {" + NL + "\t\t\tbw_";
  protected final String TEXT_65 = ".write(command);" + NL + "\t\t}";
  protected final String TEXT_66 = NL + "\t((org.talend.bigdata.launcher.webhcat.QueryJob)instance_";
  protected final String TEXT_67 = ").setFileToExecute(projectName + \"_\" + jobName + \"_\" + Thread.currentThread().getId() +\".hive\");" + NL + "\tString wasbPath_";
  protected final String TEXT_68 = " = azureFs_";
  protected final String TEXT_69 = ".getFileSystemPrefix() + \"/\"\t+ instance_";
  protected final String TEXT_70 = ".getRemoteFolder()\t+ \"/libjars/\";";
  protected final String TEXT_71 = NL + "                bw_";
  protected final String TEXT_72 = ".write(\"SET mapreduce.map.memory.mb=\" + ";
  protected final String TEXT_73 = " + \";\");" + NL + "                bw_";
  protected final String TEXT_74 = ".write(\"SET mapreduce.reduce.memory.mb=\" + ";
  protected final String TEXT_75 = " + \";\");" + NL + "                bw_";
  protected final String TEXT_76 = ".write(\"SET yarn.app.mapreduce.am.resource.mb=\" + ";
  protected final String TEXT_77 = " + \";\");";
  protected final String TEXT_78 = NL + "                    bw_";
  protected final String TEXT_79 = ".write(\"SET \"+";
  protected final String TEXT_80 = "+\"=\"+";
  protected final String TEXT_81 = " + \";\");";
  protected final String TEXT_82 = NL + "            String dbname_";
  protected final String TEXT_83 = " = ";
  protected final String TEXT_84 = ";" + NL + "            if(dbname_";
  protected final String TEXT_85 = "!=null && !\"\".equals(dbname_";
  protected final String TEXT_86 = ".trim()) && !\"default\".equals(dbname_";
  protected final String TEXT_87 = ".trim())) {" + NL + "                bw_";
  protected final String TEXT_88 = ".write(\"use \" + dbname_";
  protected final String TEXT_89 = " + \";\");" + NL + "            }";
  protected final String TEXT_90 = NL + "\tjava.lang.StringBuilder libjars_";
  protected final String TEXT_91 = " = new StringBuilder();" + NL + "\tString stagingBucketPath_";
  protected final String TEXT_92 = " = \"\";";
  protected final String TEXT_93 = NL + "        java.util.List<String> connectionCommandList_";
  protected final String TEXT_94 = " = new java.util.ArrayList<String>();  ";
  protected final String TEXT_95 = NL + "            connectionCommandList_";
  protected final String TEXT_96 = ".add(\"SET mapreduce.map.memory.mb=\" + ";
  protected final String TEXT_97 = " + \";\");" + NL + "            connectionCommandList_";
  protected final String TEXT_98 = ".add(\"SET mapreduce.reduce.memory.mb=\" + ";
  protected final String TEXT_99 = " + \";\");" + NL + "            connectionCommandList_";
  protected final String TEXT_100 = ".add(\"SET yarn.app.mapreduce.am.resource.mb=\" + ";
  protected final String TEXT_101 = " + \";\");";
  protected final String TEXT_102 = NL + "                connectionCommandList_";
  protected final String TEXT_103 = ".add(\"SET \"+";
  protected final String TEXT_104 = "+\"=\"+";
  protected final String TEXT_105 = " + \";\");";
  protected final String TEXT_106 = NL + NL + "        String dbname_";
  protected final String TEXT_107 = " = ";
  protected final String TEXT_108 = ";" + NL + "        if(dbname_";
  protected final String TEXT_109 = "!=null && !\"\".equals(dbname_";
  protected final String TEXT_110 = ".trim()) && !\"default\".equals(dbname_";
  protected final String TEXT_111 = ".trim())) {" + NL + "            connectionCommandList_";
  protected final String TEXT_112 = ".add(\"use \" + dbname_";
  protected final String TEXT_113 = " + \";\");" + NL + "        }" + NL + "" + NL + "        org.talend.bigdata.launcher.google.dataproc.DataprocHiveJob instance_";
  protected final String TEXT_114 = " =" + NL + "            new org.talend.bigdata.launcher.google.dataproc.DataprocHiveJob.Builder()" + NL + "            .withTalendJobName(projectName + \"_\" + jobName + \"_\" + jobVersion.replace(\".\",\"_\") + \"_\" + pid)" + NL + "            .withClusterName(";
  protected final String TEXT_115 = ")" + NL + "            .withRegion(";
  protected final String TEXT_116 = ")" + NL + "            .withProjectId(";
  protected final String TEXT_117 = ")" + NL + "            .withJarsBucket(";
  protected final String TEXT_118 = ")";
  protected final String TEXT_119 = NL + "                .withServiceAccountCredentialsPath(";
  protected final String TEXT_120 = ")";
  protected final String TEXT_121 = NL + NL + "            .withInitialisationQueries(connectionCommandList_";
  protected final String TEXT_122 = ")" + NL + "            .build();";
  protected final String TEXT_123 = NL + "            for (String command: connectionCommandList_";
  protected final String TEXT_124 = " ) {" + NL + "                log.debug(\"Initialization command from ";
  protected final String TEXT_125 = ": \" + command);" + NL + "            }";
  protected final String TEXT_126 = NL + "        org.talend.bigdata.launcher.google.dataproc.DataprocHiveJob instance_";
  protected final String TEXT_127 = " = (org.talend.bigdata.launcher.google.dataproc.DataprocHiveJob) globalMap.get(\"conn_";
  protected final String TEXT_128 = "\");" + NL + "        stagingBucketPath_";
  protected final String TEXT_129 = " = (String) globalMap.get(\"stagingBucket_";
  protected final String TEXT_130 = "\");" + NL + "        instance_";
  protected final String TEXT_131 = ".clearQueriesCache();" + NL + "        instance_";
  protected final String TEXT_132 = ".clearLibJars();";
  protected final String TEXT_133 = NL + "        java.sql.Connection conn_";
  protected final String TEXT_134 = " = null;" + NL;
  protected final String TEXT_135 = NL + "        globalMap.put(\"current_client_path_separator\", System.getProperty(\"path.separator\"));" + NL + "        System.setProperty(\"path.separator\", ";
  protected final String TEXT_136 = ");";
  protected final String TEXT_137 = NL + "            conn_";
  protected final String TEXT_138 = " = (java.sql.Connection)globalMap.get(\"";
  protected final String TEXT_139 = "\");" + NL + "" + NL + "            String dbname_";
  protected final String TEXT_140 = " = (String)globalMap.get(\"";
  protected final String TEXT_141 = "\");" + NL + "            if(dbname_";
  protected final String TEXT_142 = "!=null && !\"\".equals(dbname_";
  protected final String TEXT_143 = ".trim()) && !\"default\".equals(dbname_";
  protected final String TEXT_144 = ".trim())) {" + NL + "                java.sql.Statement goToDatabase_";
  protected final String TEXT_145 = " = conn_";
  protected final String TEXT_146 = ".createStatement();" + NL + "                goToDatabase_";
  protected final String TEXT_147 = ".execute(\"use \" + dbname_";
  protected final String TEXT_148 = ");" + NL + "                goToDatabase_";
  protected final String TEXT_149 = ".close();" + NL + "            }" + NL + "" + NL + "            String dbUser_";
  protected final String TEXT_150 = " = (String)globalMap.get(\"";
  protected final String TEXT_151 = "\");" + NL + "" + NL + "" + NL + "            globalMap.put(\"HADOOP_USER_NAME_";
  protected final String TEXT_152 = "\", System.getProperty(\"HADOOP_USER_NAME\"));" + NL + "            if(dbUser_";
  protected final String TEXT_153 = "!=null && !\"\".equals(dbUser_";
  protected final String TEXT_154 = ".trim())) {" + NL + "                System.setProperty(\"HADOOP_USER_NAME\",dbUser_";
  protected final String TEXT_155 = ");" + NL + "                //make relative file path work for hive" + NL + "                globalMap.put(\"current_client_user_name\", System.getProperty(\"user.name\"));" + NL + "                System.setProperty(\"user.name\",dbUser_";
  protected final String TEXT_156 = ");" + NL + "            }";
  protected final String TEXT_157 = NL + "                if(true) {" + NL + "                    throw new java.lang.Exception(\"The distribution ";
  protected final String TEXT_158 = " does not support this version of Hive . Please check your component configuration.\");" + NL + "                }";
  protected final String TEXT_159 = NL + "                if(true) {" + NL + "                    throw new java.lang.Exception(\"The distribution ";
  protected final String TEXT_160 = " does not support this connection mode . Please check your component configuration.\");" + NL + "                }";
  protected final String TEXT_161 = NL + "                if(true) {" + NL + "                    throw new java.lang.Exception(\"The Hive version and the connection mode are not compatible together. Please check your component configuration.\");" + NL + "                }";
  protected final String TEXT_162 = NL + "            String dbUser_";
  protected final String TEXT_163 = " = ";
  protected final String TEXT_164 = ";" + NL;
  protected final String TEXT_165 = NL;
  protected final String TEXT_166 = NL + "            ";
  protected final String TEXT_167 = "String decryptedPassword_";
  protected final String TEXT_168 = " = null;";
  protected final String TEXT_169 = " " + NL + "\tdecryptedPassword_";
  protected final String TEXT_170 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_171 = ");";
  protected final String TEXT_172 = NL + "\tdecryptedPassword_";
  protected final String TEXT_173 = " = ";
  protected final String TEXT_174 = "; ";
  protected final String TEXT_175 = NL + NL + "            String dbPwd_";
  protected final String TEXT_176 = " = decryptedPassword_";
  protected final String TEXT_177 = ";" + NL;
  protected final String TEXT_178 = NL + "                String username_";
  protected final String TEXT_179 = " = ";
  protected final String TEXT_180 = ";" + NL + "                if(username_";
  protected final String TEXT_181 = "!=null && !\"\".equals(username_";
  protected final String TEXT_182 = ".trim())) {" + NL + "                    System.setProperty(\"HADOOP_USER_NAME\",username_";
  protected final String TEXT_183 = ");" + NL + "                }";
  protected final String TEXT_184 = NL + NL + "            globalMap.put(\"HADOOP_USER_NAME_";
  protected final String TEXT_185 = "\", System.getProperty(\"HADOOP_USER_NAME\"));";
  protected final String TEXT_186 = NL + "                System.setProperty(\"hive.metastore.local\", \"false\");" + NL + "                System.setProperty(\"hive.metastore.uris\", \"thrift://\" + ";
  protected final String TEXT_187 = " + \":\" + ";
  protected final String TEXT_188 = ");" + NL + "                System.setProperty(\"hive.metastore.execute.setugi\", \"true\");" + NL + "                String url_";
  protected final String TEXT_189 = " = \"jdbc:";
  protected final String TEXT_190 = "://\";";
  protected final String TEXT_191 = NL + "                    if(dbUser_";
  protected final String TEXT_192 = "!=null && !\"\".equals(dbUser_";
  protected final String TEXT_193 = ".trim())) {" + NL + "                        System.setProperty(\"HADOOP_USER_NAME\",dbUser_";
  protected final String TEXT_194 = ");" + NL + "                        //make relative file path work for hive" + NL + "                        globalMap.put(\"current_client_user_name\", System.getProperty(\"user.name\"));" + NL + "                        System.setProperty(\"user.name\",dbUser_";
  protected final String TEXT_195 = ");" + NL + "                    }";
  protected final String TEXT_196 = NL + "                                String decryptedSslStorePassword_";
  protected final String TEXT_197 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_198 = ");";
  protected final String TEXT_199 = NL + "                                String decryptedSslStorePassword_";
  protected final String TEXT_200 = " = ";
  protected final String TEXT_201 = ";";
  protected final String TEXT_202 = NL + "                            String url_";
  protected final String TEXT_203 = " = \"jdbc:";
  protected final String TEXT_204 = "://\" + ";
  protected final String TEXT_205 = " + \":\" + ";
  protected final String TEXT_206 = " + \"/\" + ";
  protected final String TEXT_207 = " + \";principal=\" + ";
  protected final String TEXT_208 = "+\";ssl=true\" +\";sslTrustStore=\" + ";
  protected final String TEXT_209 = " + \";trustStorePassword=\" + decryptedSslStorePassword_";
  protected final String TEXT_210 = ";";
  protected final String TEXT_211 = NL + "                            String url_";
  protected final String TEXT_212 = " = \"jdbc:";
  protected final String TEXT_213 = "://\" + ";
  protected final String TEXT_214 = " + \":\" + ";
  protected final String TEXT_215 = " + \"/\" + ";
  protected final String TEXT_216 = " + \";principal=\" + ";
  protected final String TEXT_217 = "+\";sasl.qop=auth-conf\";";
  protected final String TEXT_218 = NL + "                        String url_";
  protected final String TEXT_219 = " = \"jdbc:";
  protected final String TEXT_220 = "://\" + ";
  protected final String TEXT_221 = " + \":\" + ";
  protected final String TEXT_222 = " + \"/\" + ";
  protected final String TEXT_223 = " + \";principal=\" + ";
  protected final String TEXT_224 = ";";
  protected final String TEXT_225 = NL + "                                String decryptedSslStorePassword_";
  protected final String TEXT_226 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_227 = ");";
  protected final String TEXT_228 = NL + "                                String decryptedSslStorePassword_";
  protected final String TEXT_229 = " = ";
  protected final String TEXT_230 = ";";
  protected final String TEXT_231 = NL + "                            String decryptedSslStorePassword_";
  protected final String TEXT_232 = " = \"\";";
  protected final String TEXT_233 = NL + "                        String url_";
  protected final String TEXT_234 = " = \"jdbc:";
  protected final String TEXT_235 = "://\" + ";
  protected final String TEXT_236 = " + \":\" + ";
  protected final String TEXT_237 = " + \"/\" + ";
  protected final String TEXT_238 = "+ \";ssl=true\" +\";sslTrustStore=\" + ";
  protected final String TEXT_239 = " + \";trustStorePassword=\" + decryptedSslStorePassword_";
  protected final String TEXT_240 = ";";
  protected final String TEXT_241 = NL + "                        String url_";
  protected final String TEXT_242 = " = \"jdbc:";
  protected final String TEXT_243 = "://\" + ";
  protected final String TEXT_244 = " + \":\" + ";
  protected final String TEXT_245 = " + \"/\" + ";
  protected final String TEXT_246 = ";";
  protected final String TEXT_247 = NL + "                String additionalJdbcSettings_";
  protected final String TEXT_248 = " = ";
  protected final String TEXT_249 = ";" + NL + "                if(!\"\".equals(additionalJdbcSettings_";
  protected final String TEXT_250 = ".trim())) {" + NL + "                    if(!additionalJdbcSettings_";
  protected final String TEXT_251 = ".startsWith(\";\")) {" + NL + "                        additionalJdbcSettings_";
  protected final String TEXT_252 = " = \";\" + additionalJdbcSettings_";
  protected final String TEXT_253 = ";" + NL + "                    }" + NL + "                    url_";
  protected final String TEXT_254 = " += additionalJdbcSettings_";
  protected final String TEXT_255 = ";" + NL + "                }";
  protected final String TEXT_256 = NL + "            java.lang.Class.forName(\"";
  protected final String TEXT_257 = "\");";
  protected final String TEXT_258 = NL + "                conn_";
  protected final String TEXT_259 = " = java.sql.DriverManager.getConnection(url_";
  protected final String TEXT_260 = ");";
  protected final String TEXT_261 = NL + "                conn_";
  protected final String TEXT_262 = " = java.sql.DriverManager.getConnection(url_";
  protected final String TEXT_263 = ", dbUser_";
  protected final String TEXT_264 = ", dbPwd_";
  protected final String TEXT_265 = ");";
  protected final String TEXT_266 = NL + "            java.sql.Statement init_";
  protected final String TEXT_267 = " = conn_";
  protected final String TEXT_268 = ".createStatement();";
  protected final String TEXT_269 = NL + "                init_";
  protected final String TEXT_270 = ".execute(\"SET mapred.job.map.memory.mb=\" + ";
  protected final String TEXT_271 = ");" + NL + "                init_";
  protected final String TEXT_272 = ".execute(\"SET mapred.job.reduce.memory.mb=\" + ";
  protected final String TEXT_273 = ");";
  protected final String TEXT_274 = NL + "                init_";
  protected final String TEXT_275 = ".execute(\"SET dfs.namenode.kerberos.principal=\" + ";
  protected final String TEXT_276 = ");";
  protected final String TEXT_277 = NL + "                    init_";
  protected final String TEXT_278 = ".execute(\"SET mapreduce.jobtracker.kerberos.principal=\" + ";
  protected final String TEXT_279 = ");";
  protected final String TEXT_280 = NL + "                    init_";
  protected final String TEXT_281 = ".execute(\"SET yarn.resourcemanager.principal=\" + ";
  protected final String TEXT_282 = ");";
  protected final String TEXT_283 = NL + "                    init_";
  protected final String TEXT_284 = ".execute(\"SET mapreduce.framework.name=yarn\");" + NL + "                    init_";
  protected final String TEXT_285 = ".execute(\"SET yarn.resourcemanager.address=\" + ";
  protected final String TEXT_286 = ");";
  protected final String TEXT_287 = NL + "                    init_";
  protected final String TEXT_288 = ".execute(\"SET mapreduce.jobhistory.address=\" + ";
  protected final String TEXT_289 = ");";
  protected final String TEXT_290 = NL + "                    init_";
  protected final String TEXT_291 = ".execute(\"SET yarn.resourcemanager.scheduler.address=\" + ";
  protected final String TEXT_292 = ");";
  protected final String TEXT_293 = NL + "                    init_";
  protected final String TEXT_294 = ".execute(\"SET dfs.client.use.datanode.hostname=true\");";
  protected final String TEXT_295 = NL + "                    init_";
  protected final String TEXT_296 = ".execute(\"SET fs.default.name=\" + ";
  protected final String TEXT_297 = ");";
  protected final String TEXT_298 = NL + "                        init_";
  protected final String TEXT_299 = ".execute(\"SET mapreduce.app-submission.cross-platform=true\");";
  protected final String TEXT_300 = NL + "                        init_";
  protected final String TEXT_301 = ".execute(\"SET mapreduce.job.map.output.collector.class=org.apache.hadoop.mapred.MapRFsOutputBuffer\");" + NL + "                        init_";
  protected final String TEXT_302 = ".execute(\"SET mapreduce.job.reduce.shuffle.consumer.plugin.class=org.apache.hadoop.mapreduce.task.reduce.DirectShuffle\");";
  protected final String TEXT_303 = NL + "                        init_";
  protected final String TEXT_304 = ".execute(\"SET mapreduce.application.classpath=";
  protected final String TEXT_305 = "\");";
  protected final String TEXT_306 = NL + "                    init_";
  protected final String TEXT_307 = ".execute(\"SET yarn.application.classpath=";
  protected final String TEXT_308 = "\");";
  protected final String TEXT_309 = NL + "                    init_";
  protected final String TEXT_310 = ".execute(\"SET mapreduce.map.memory.mb=\" + ";
  protected final String TEXT_311 = ");" + NL + "                    init_";
  protected final String TEXT_312 = ".execute(\"SET mapreduce.reduce.memory.mb=\" + ";
  protected final String TEXT_313 = ");" + NL + "                    init_";
  protected final String TEXT_314 = ".execute(\"SET yarn.app.mapreduce.am.resource.mb=\" + ";
  protected final String TEXT_315 = ");";
  protected final String TEXT_316 = NL + "                    init_";
  protected final String TEXT_317 = ".execute(\"SET \"+";
  protected final String TEXT_318 = "+\"=\"+";
  protected final String TEXT_319 = ");";
  protected final String TEXT_320 = NL;
  protected final String TEXT_321 = NL + "        \t   ";
  protected final String TEXT_322 = NL;
  protected final String TEXT_323 = NL + "    \t\tinit_";
  protected final String TEXT_324 = ".execute(\"SET hive.execution.engine=tez\");";
  protected final String TEXT_325 = NL + "                        System.err.println(\"Please set the path of Tez lib in 'Tez lib path'!\");";
  protected final String TEXT_326 = NL;
  protected final String TEXT_327 = NL + "        String username_";
  protected final String TEXT_328 = " = (";
  protected final String TEXT_329 = " != null && !\"\".equals(";
  protected final String TEXT_330 = ")) ? ";
  protected final String TEXT_331 = " : System.getProperty(\"user.name\");;" + NL + "        org.apache.hadoop.fs.FileSystem fs_";
  protected final String TEXT_332 = " = null;";
  protected final String TEXT_333 = NL + "        org.apache.hadoop.conf.Configuration conf_";
  protected final String TEXT_334 = " = new org.apache.hadoop.conf.Configuration(); " + NL + "        conf_";
  protected final String TEXT_335 = ".set(\"";
  protected final String TEXT_336 = "\", ";
  protected final String TEXT_337 = ");" + NL + "        ";
  protected final String TEXT_338 = NL + "            conf_";
  protected final String TEXT_339 = ".set(\"dfs.client.use.datanode.hostname\", \"true\");";
  protected final String TEXT_340 = NL + "        \t\tconf_";
  protected final String TEXT_341 = ".set(";
  protected final String TEXT_342 = " ,";
  protected final String TEXT_343 = ");" + NL + "        \t";
  protected final String TEXT_344 = NL + "            username_";
  protected final String TEXT_345 = " = null;" + NL + "    \t\tconf_";
  protected final String TEXT_346 = ".set(\"dfs.namenode.kerberos.principal\", ";
  protected final String TEXT_347 = ");" + NL + "    \t\t";
  protected final String TEXT_348 = NL + "    \t\t\torg.apache.hadoop.security.UserGroupInformation.loginUserFromKeytab(";
  protected final String TEXT_349 = ", ";
  protected final String TEXT_350 = ");" + NL + "    \t\t";
  protected final String TEXT_351 = NL + "\t\t\tconf_";
  protected final String TEXT_352 = ".set(\"hadoop.job.ugi\",username_";
  protected final String TEXT_353 = "+\",\"+username_";
  protected final String TEXT_354 = ");" + NL + "        \tfs_";
  protected final String TEXT_355 = " = org.apache.hadoop.fs.FileSystem.get(conf_";
  protected final String TEXT_356 = ");";
  protected final String TEXT_357 = NL + "        \t" + NL + "        \tif(username_";
  protected final String TEXT_358 = " == null || \"\".equals(username_";
  protected final String TEXT_359 = ")){" + NL + "        \t\tfs_";
  protected final String TEXT_360 = " = org.apache.hadoop.fs.FileSystem.get(conf_";
  protected final String TEXT_361 = ");" + NL + "        \t}else{" + NL + "        \t\tfs_";
  protected final String TEXT_362 = " = org.apache.hadoop.fs.FileSystem.get(new java.net.URI(conf_";
  protected final String TEXT_363 = ".get(\"";
  protected final String TEXT_364 = "\")),conf_";
  protected final String TEXT_365 = ",username_";
  protected final String TEXT_366 = ");" + NL + "        \t}\t";
  protected final String TEXT_367 = NL + "                    String hdfsUserName_";
  protected final String TEXT_368 = " = (";
  protected final String TEXT_369 = " != null && !\"\".equals(";
  protected final String TEXT_370 = ")) ? ";
  protected final String TEXT_371 = " : System.getProperty(\"user.name\");" + NL + "                    String tezLibPath_";
  protected final String TEXT_372 = " = \"/tmp/\" + hdfsUserName_";
  protected final String TEXT_373 = " + \"/talend_tez_libs/";
  protected final String TEXT_374 = "\";";
  protected final String TEXT_375 = NL + "                    String tezLibPath_";
  protected final String TEXT_376 = " = ";
  protected final String TEXT_377 = ";";
  protected final String TEXT_378 = NL + "                fs_";
  protected final String TEXT_379 = ".mkdirs(new org.apache.hadoop.fs.Path(tezLibPath_";
  protected final String TEXT_380 = "));";
  protected final String TEXT_381 = NL + "                String[] classPaths_";
  protected final String TEXT_382 = " = System.getProperty(\"java.class.path\").split(";
  protected final String TEXT_383 = "String.valueOf(globalMap.get(\"current_client_path_separator\"))";
  protected final String TEXT_384 = "System.getProperty(\"path.separator\")";
  protected final String TEXT_385 = ");" + NL + "                String tezLibLocalPath_";
  protected final String TEXT_386 = " = null;" + NL + "                for(String classPath_";
  protected final String TEXT_387 = " : classPaths_";
  protected final String TEXT_388 = "){";
  protected final String TEXT_389 = NL + "                        if(classPath_";
  protected final String TEXT_390 = ".endsWith(\"";
  protected final String TEXT_391 = "\")){" + NL + "                            org.apache.hadoop.fs.Path tezJarPath_";
  protected final String TEXT_392 = " = new org.apache.hadoop.fs.Path(tezLibPath_";
  protected final String TEXT_393 = " + \"/";
  protected final String TEXT_394 = "\");" + NL + "                            if(!fs_";
  protected final String TEXT_395 = ".exists(tezJarPath_";
  protected final String TEXT_396 = ")){" + NL + "                                fs_";
  protected final String TEXT_397 = ".copyFromLocalFile(false, false, new org.apache.hadoop.fs.Path(classPath_";
  protected final String TEXT_398 = "), tezJarPath_";
  protected final String TEXT_399 = ");" + NL + "                            }" + NL + "                        }";
  protected final String TEXT_400 = NL + "                }";
  protected final String TEXT_401 = NL + "                String tezLibPath_";
  protected final String TEXT_402 = " = ";
  protected final String TEXT_403 = ";";
  protected final String TEXT_404 = NL + "\t\t\tStringBuilder script_";
  protected final String TEXT_405 = " = new StringBuilder();" + NL + "\t\t\tString[] tezLibPaths_";
  protected final String TEXT_406 = " = tezLibPath_";
  protected final String TEXT_407 = ".split(\",\");" + NL + "\t\t\tscript_";
  protected final String TEXT_408 = ".append(\"SET tez.lib.uris=\");" + NL + "\t\t\tint tezLibPathCount_";
  protected final String TEXT_409 = " = 1;" + NL + "\t\t\tfor(String tezLibPathKey_";
  protected final String TEXT_410 = " : tezLibPaths_";
  protected final String TEXT_411 = "){" + NL + "\t\t\t\t script_";
  protected final String TEXT_412 = ".append(";
  protected final String TEXT_413 = " + \"/\" + tezLibPathKey_";
  protected final String TEXT_414 = ");" + NL + "\t\t\t\t if(tezLibPathCount_";
  protected final String TEXT_415 = " < tezLibPaths_";
  protected final String TEXT_416 = ".length){" + NL + "\t\t\t\t \tscript_";
  protected final String TEXT_417 = ".append(\",\");" + NL + "\t\t\t\t }" + NL + "\t\t\t\t tezLibPathCount_";
  protected final String TEXT_418 = "++;" + NL + "\t\t\t}" + NL + "\t\t\tinit_";
  protected final String TEXT_419 = ".execute(script_";
  protected final String TEXT_420 = ".toString());" + NL + "\t\t";
  protected final String TEXT_421 = NL + "            init_";
  protected final String TEXT_422 = ".close();" + NL + "" + NL + "            String dbname_";
  protected final String TEXT_423 = " = ";
  protected final String TEXT_424 = ";" + NL + "            if(dbname_";
  protected final String TEXT_425 = "!=null && !\"\".equals(dbname_";
  protected final String TEXT_426 = ".trim()) && !\"default\".equals(dbname_";
  protected final String TEXT_427 = ".trim())) {" + NL + "                java.sql.Statement goToDatabase_";
  protected final String TEXT_428 = " = conn_";
  protected final String TEXT_429 = ".createStatement();" + NL + "                goToDatabase_";
  protected final String TEXT_430 = ".execute(\"use \" + dbname_";
  protected final String TEXT_431 = ");" + NL + "                goToDatabase_";
  protected final String TEXT_432 = ".close();" + NL + "            }";
  protected final String TEXT_433 = NL + "                java.sql.Statement statement_";
  protected final String TEXT_434 = " = conn_";
  protected final String TEXT_435 = ".createStatement();";
  protected final String TEXT_436 = NL + "                    statement_";
  protected final String TEXT_437 = ".execute(\"SET hbase.zookeeper.quorum=\"+";
  protected final String TEXT_438 = ");";
  protected final String TEXT_439 = NL;
  protected final String TEXT_440 = NL + "                    statement_";
  protected final String TEXT_441 = ".execute(\"SET hbase.zookeeper.property.clientPort=\"+";
  protected final String TEXT_442 = ");";
  protected final String TEXT_443 = NL;
  protected final String TEXT_444 = NL + "                    statement_";
  protected final String TEXT_445 = ".execute(\"SET zookeeper.znode.parent=\"+";
  protected final String TEXT_446 = ");";
  protected final String TEXT_447 = NL;
  protected final String TEXT_448 = NL + "                        statement_";
  protected final String TEXT_449 = ".execute(\"add jar \"+";
  protected final String TEXT_450 = ");";
  protected final String TEXT_451 = NL + "                statement_";
  protected final String TEXT_452 = ".close();";
  protected final String TEXT_453 = NL + "        if(true) {" + NL + "            throw new java.lang.UnsupportedOperationException(\"Parquet is only supported if the distribution uses embedded Hive version 0.10 or later.\");" + NL + "        }";
  protected final String TEXT_454 = NL + "                routines.system.GetJarsToRegister getJarsToRegister_";
  protected final String TEXT_455 = " = new GetJarsToRegister();";
  protected final String TEXT_456 = NL + "\tclass GetHiveJarsToRegister_";
  protected final String TEXT_457 = " extends routines.system.GetJarsToRegister {" + NL + "\t\t" + NL + "\t\tprivate String uploadJarToHDFS(String jar) throws Exception {" + NL + "\t\t\t";
  protected final String TEXT_458 = NL;
  protected final String TEXT_459 = NL + "        String username_";
  protected final String TEXT_460 = " = (";
  protected final String TEXT_461 = " != null && !\"\".equals(";
  protected final String TEXT_462 = ")) ? ";
  protected final String TEXT_463 = " : System.getProperty(\"user.name\");;" + NL + "        org.apache.hadoop.fs.FileSystem fs_";
  protected final String TEXT_464 = " = null;";
  protected final String TEXT_465 = NL + "        org.apache.hadoop.conf.Configuration conf_";
  protected final String TEXT_466 = " = new org.apache.hadoop.conf.Configuration(); " + NL + "        conf_";
  protected final String TEXT_467 = ".set(\"";
  protected final String TEXT_468 = "\", ";
  protected final String TEXT_469 = ");" + NL + "        ";
  protected final String TEXT_470 = NL + "            conf_";
  protected final String TEXT_471 = ".set(\"dfs.client.use.datanode.hostname\", \"true\");";
  protected final String TEXT_472 = NL + "        \t\tconf_";
  protected final String TEXT_473 = ".set(";
  protected final String TEXT_474 = " ,";
  protected final String TEXT_475 = ");" + NL + "        \t";
  protected final String TEXT_476 = NL + "            username_";
  protected final String TEXT_477 = " = null;" + NL + "    \t\tconf_";
  protected final String TEXT_478 = ".set(\"dfs.namenode.kerberos.principal\", ";
  protected final String TEXT_479 = ");" + NL + "    \t\t";
  protected final String TEXT_480 = NL + "    \t\t\torg.apache.hadoop.security.UserGroupInformation.loginUserFromKeytab(";
  protected final String TEXT_481 = ", ";
  protected final String TEXT_482 = ");" + NL + "    \t\t";
  protected final String TEXT_483 = NL + "\t\t\tconf_";
  protected final String TEXT_484 = ".set(\"hadoop.job.ugi\",username_";
  protected final String TEXT_485 = "+\",\"+username_";
  protected final String TEXT_486 = ");" + NL + "        \tfs_";
  protected final String TEXT_487 = " = org.apache.hadoop.fs.FileSystem.get(conf_";
  protected final String TEXT_488 = ");";
  protected final String TEXT_489 = NL + "        \t" + NL + "        \tif(username_";
  protected final String TEXT_490 = " == null || \"\".equals(username_";
  protected final String TEXT_491 = ")){" + NL + "        \t\tfs_";
  protected final String TEXT_492 = " = org.apache.hadoop.fs.FileSystem.get(conf_";
  protected final String TEXT_493 = ");" + NL + "        \t}else{" + NL + "        \t\tfs_";
  protected final String TEXT_494 = " = org.apache.hadoop.fs.FileSystem.get(new java.net.URI(conf_";
  protected final String TEXT_495 = ".get(\"";
  protected final String TEXT_496 = "\")),conf_";
  protected final String TEXT_497 = ",username_";
  protected final String TEXT_498 = ");" + NL + "        \t}\t";
  protected final String TEXT_499 = NL + "\t\t\t";
  protected final String TEXT_500 = NL + "\t\t\t" + NL + "\t\t\tString pathUsername_";
  protected final String TEXT_501 = " = username_";
  protected final String TEXT_502 = " == null ? org.apache.hadoop.security.UserGroupInformation.getLoginUser().getShortUserName() : username_";
  protected final String TEXT_503 = ";" + NL + "\t\t\tfs_";
  protected final String TEXT_504 = ".mkdirs(new org.apache.hadoop.fs.Path(\"/user/\" + pathUsername_";
  protected final String TEXT_505 = " + \"/tmp\"), new org.apache.hadoop.fs.permission.FsPermission(org.apache.hadoop.fs.permission.FsAction.ALL, org.apache.hadoop.fs.permission.FsAction.ALL, org.apache.hadoop.fs.permission.FsAction.ALL));" + NL + "\t\t\tfs_";
  protected final String TEXT_506 = ".copyFromLocalFile(false, true, new org.apache.hadoop.fs.Path(jar), new org.apache.hadoop.fs.Path(\"/user/\" + pathUsername_";
  protected final String TEXT_507 = " + \"/tmp\"));" + NL + "\t\t\treturn ";
  protected final String TEXT_508 = " + \"/user/\" + pathUsername_";
  protected final String TEXT_509 = " + \"/tmp/\" + new java.io.File(jar).getName();" + NL + "\t\t}" + NL + "\t\t" + NL + "\t\tpublic String replaceJarPaths(String originalClassPathLine) throws Exception {" + NL + "\t\t\tString classPathLine = super.replaceJarPaths(originalClassPathLine);" + NL + "\t\t\tString hdfsPath = uploadJarToHDFS(classPathLine);" + NL + "\t\t\treturn hdfsPath;" + NL + "\t\t}" + NL + "\t}" + NL + "                    GetHiveJarsToRegister_";
  protected final String TEXT_510 = " getJarsToRegister_";
  protected final String TEXT_511 = " = new GetHiveJarsToRegister_";
  protected final String TEXT_512 = "();";
  protected final String TEXT_513 = NL + "                java.sql.Statement addJar_";
  protected final String TEXT_514 = " = null;";
  protected final String TEXT_515 = NL + "                            addJar_";
  protected final String TEXT_516 = " = conn_";
  protected final String TEXT_517 = ".createStatement();" + NL + "                            try {" + NL + "                                addJar_";
  protected final String TEXT_518 = ".execute(\"add jar \" + getJarsToRegister_";
  protected final String TEXT_519 = ".replaceJarPaths(\"";
  protected final String TEXT_520 = "\"));" + NL + "                            } catch (Exception e) {" + NL + "                                e.printStackTrace();" + NL + "                            } finally {" + NL + "                                addJar_";
  protected final String TEXT_521 = ".close();" + NL + "                            }";
  protected final String TEXT_522 = NL + "                                    bw_";
  protected final String TEXT_523 = ".write(\"ADD JAR \" + wasbPath_";
  protected final String TEXT_524 = " + new java.io.File(getJarsToRegister_";
  protected final String TEXT_525 = ".replaceJarPaths(\"";
  protected final String TEXT_526 = "\")).getName() + \";\");" + NL + "                                    libjars_";
  protected final String TEXT_527 = ".append(getJarsToRegister_";
  protected final String TEXT_528 = ".replaceJarPaths(\"";
  protected final String TEXT_529 = "\") + \",\");";
  protected final String TEXT_530 = NL + "                                        log.debug(\"Query for ";
  protected final String TEXT_531 = ": \" + \"ADD JAR \" + stagingBucketPath_";
  protected final String TEXT_532 = " + new java.io.File(getJarsToRegister_";
  protected final String TEXT_533 = ".replaceJarPaths(\"";
  protected final String TEXT_534 = "\")).getName() + \";\");";
  protected final String TEXT_535 = NL + "                                    instance_";
  protected final String TEXT_536 = ".addQuery(\"ADD JAR \" + stagingBucketPath_";
  protected final String TEXT_537 = " + new java.io.File(getJarsToRegister_";
  protected final String TEXT_538 = ".replaceJarPaths(\"";
  protected final String TEXT_539 = "\")).getName() + \";\");" + NL + "                                    libjars_";
  protected final String TEXT_540 = ".append(getJarsToRegister_";
  protected final String TEXT_541 = ".replaceJarPaths(\"";
  protected final String TEXT_542 = "\") + \",\");";
  protected final String TEXT_543 = NL + "            java.sql.Statement setCompression_";
  protected final String TEXT_544 = " = conn_";
  protected final String TEXT_545 = ".createStatement();" + NL + "            try {" + NL + "                setCompression_";
  protected final String TEXT_546 = ".execute(\"SET parquet.compression=";
  protected final String TEXT_547 = "\");" + NL + "            } finally {" + NL + "                setCompression_";
  protected final String TEXT_548 = ".close();" + NL + "            }";
  protected final String TEXT_549 = NL + "                bw_";
  protected final String TEXT_550 = ".write(\"SET parquet.compression=";
  protected final String TEXT_551 = ";\");";
  protected final String TEXT_552 = NL + "                    log.debug(\"Query for ";
  protected final String TEXT_553 = ": \" + \"SET parquet.compression=";
  protected final String TEXT_554 = ";\");";
  protected final String TEXT_555 = NL + "                instance_";
  protected final String TEXT_556 = ".addQuery(\"SET parquet.compression=";
  protected final String TEXT_557 = ";\");";
  protected final String TEXT_558 = NL + "        java.sql.Statement stmt_";
  protected final String TEXT_559 = " = conn_";
  protected final String TEXT_560 = ".createStatement();";
  protected final String TEXT_561 = NL + "    StringBuffer partitionSql_";
  protected final String TEXT_562 = " = new StringBuffer();" + NL + "    String startPartition_";
  protected final String TEXT_563 = " = \"\";" + NL + "    String endPartition_";
  protected final String TEXT_564 = " = \"\";" + NL + "    String bodyPartition_";
  protected final String TEXT_565 = " = \"\";";
  protected final String TEXT_566 = NL + "    startPartition_";
  protected final String TEXT_567 = " = \" PARTITION(\";" + NL + "    endPartition_";
  protected final String TEXT_568 = " = \")\";";
  protected final String TEXT_569 = NL + "                bodyPartition_";
  protected final String TEXT_570 = " = bodyPartition_";
  protected final String TEXT_571 = " + ";
  protected final String TEXT_572 = ";";
  protected final String TEXT_573 = NL + "                       bodyPartition_";
  protected final String TEXT_574 = " = bodyPartition_";
  protected final String TEXT_575 = " + \"=\";" + NL + "                       bodyPartition_";
  protected final String TEXT_576 = " = bodyPartition_";
  protected final String TEXT_577 = " + ";
  protected final String TEXT_578 = ";";
  protected final String TEXT_579 = NL + "                    bodyPartition_";
  protected final String TEXT_580 = " = bodyPartition_";
  protected final String TEXT_581 = " + \",\";";
  protected final String TEXT_582 = NL + "    partitionSql_";
  protected final String TEXT_583 = ".append(startPartition_";
  protected final String TEXT_584 = ").append(bodyPartition_";
  protected final String TEXT_585 = ").append(endPartition_";
  protected final String TEXT_586 = ");" + NL;
  protected final String TEXT_587 = NL + "    String insertQuery_";
  protected final String TEXT_588 = " = \"INSERT INTO TABLE \"+tableName_";
  protected final String TEXT_589 = " + partitionSql_";
  protected final String TEXT_590 = ".toString() + \" \"+select_query_";
  protected final String TEXT_591 = ";";
  protected final String TEXT_592 = NL + "            log.debug(\"Insert query for ";
  protected final String TEXT_593 = ": \" + insertQuery_";
  protected final String TEXT_594 = ");";
  protected final String TEXT_595 = NL + "            stmt_";
  protected final String TEXT_596 = ".execute(insertQuery_";
  protected final String TEXT_597 = ");";
  protected final String TEXT_598 = NL + "            bw_";
  protected final String TEXT_599 = ".write(insertQuery_";
  protected final String TEXT_600 = " + \";\");";
  protected final String TEXT_601 = NL + "            instance_";
  protected final String TEXT_602 = ".addQuery(insertQuery_";
  protected final String TEXT_603 = " + \";\");";
  protected final String TEXT_604 = NL + "    String overwriteQuery_";
  protected final String TEXT_605 = " = \"INSERT OVERWRITE TABLE \"+tableName_";
  protected final String TEXT_606 = "+ partitionSql_";
  protected final String TEXT_607 = ".toString() + \" \"+select_query_";
  protected final String TEXT_608 = ";";
  protected final String TEXT_609 = NL + "            log.debug(\"Overwrite query for ";
  protected final String TEXT_610 = ": \" + overwriteQuery_";
  protected final String TEXT_611 = ");";
  protected final String TEXT_612 = NL + "            stmt_";
  protected final String TEXT_613 = ".execute(overwriteQuery_";
  protected final String TEXT_614 = ");" + NL;
  protected final String TEXT_615 = NL + "            bw_";
  protected final String TEXT_616 = ".write(overwriteQuery_";
  protected final String TEXT_617 = " + \";\");";
  protected final String TEXT_618 = NL + "            instance_";
  protected final String TEXT_619 = ".addQuery(overwriteQuery_";
  protected final String TEXT_620 = " + \";\");";
  protected final String TEXT_621 = NL + "stmt_";
  protected final String TEXT_622 = ".close();" + NL;
  protected final String TEXT_623 = NL + "    if(conn_";
  protected final String TEXT_624 = " != null && !conn_";
  protected final String TEXT_625 = ".isClosed()) {" + NL + "        conn_";
  protected final String TEXT_626 = " .close();" + NL + "    }";
  protected final String TEXT_627 = NL + NL + "String currentClientPathSeparator_";
  protected final String TEXT_628 = " = (String)globalMap.get(\"current_client_path_separator\");" + NL + "if(currentClientPathSeparator_";
  protected final String TEXT_629 = "!=null) {" + NL + "    System.setProperty(\"path.separator\", currentClientPathSeparator_";
  protected final String TEXT_630 = ");" + NL + "    globalMap.put(\"current_client_path_separator\", null);" + NL + "}" + NL + "" + NL + "String currentClientUsername_";
  protected final String TEXT_631 = " = (String)globalMap.get(\"current_client_user_name\");" + NL + "if(currentClientUsername_";
  protected final String TEXT_632 = "!=null) {" + NL + "    System.setProperty(\"user.name\", currentClientUsername_";
  protected final String TEXT_633 = ");" + NL + "    globalMap.put(\"current_client_user_name\", null);" + NL + "}" + NL + "" + NL + "String originalHadoopUsername_";
  protected final String TEXT_634 = " = (String)globalMap.get(\"HADOOP_USER_NAME_";
  protected final String TEXT_635 = "\");" + NL + "if(originalHadoopUsername_";
  protected final String TEXT_636 = "!=null) {" + NL + "    System.setProperty(\"HADOOP_USER_NAME\", originalHadoopUsername_";
  protected final String TEXT_637 = ");" + NL + "    globalMap.put(\"HADOOP_USER_NAME_";
  protected final String TEXT_638 = "\", null);" + NL + "} else {" + NL + "    System.clearProperty(\"HADOOP_USER_NAME\");" + NL + "}";
  protected final String TEXT_639 = NL + "        bw_";
  protected final String TEXT_640 = ".close();" + NL + "        if(libjars_";
  protected final String TEXT_641 = ".length() > 0) {" + NL + "            instance_";
  protected final String TEXT_642 = ".setLibJars(libjars_";
  protected final String TEXT_643 = ".toString().substring(0, libjars_";
  protected final String TEXT_644 = ".length()-1));" + NL + "        }" + NL + "" + NL + "        instance_";
  protected final String TEXT_645 = ".callWS(instance_";
  protected final String TEXT_646 = ".sendFiles());" + NL + "        int exitCode_";
  protected final String TEXT_647 = " = instance_";
  protected final String TEXT_648 = ".execute();" + NL + "        if(exitCode_";
  protected final String TEXT_649 = " > 0) {" + NL + "            throw new Exception(\"The Hive job failed. Please read the logs for more details\");" + NL + "        }";
  protected final String TEXT_650 = NL + "            int exitCode_";
  protected final String TEXT_651 = " = instance_";
  protected final String TEXT_652 = ".executeJob();" + NL + "            System.out.println(instance_";
  protected final String TEXT_653 = ".getJobLog());" + NL + "            if(exitCode_";
  protected final String TEXT_654 = " > 0) {" + NL + "                    throw new Exception(\"The Hive job failed. Please read the logs for more details\");" + NL + "            }";
  protected final String TEXT_655 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
    CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
    INode node = (INode)codeGenArgument.getArgument();

    String cid = node.getUniqueName();
    String processId = node.getProcess().getId();

    boolean isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));

    String dbtable = null;
    String uniqueNameConnection = null;
    INode previousNode = null;
    boolean setFsDefaultName=false;
    String connectionMode = "";
    String fsDefaultName = "";
    org.talend.hadoop.distribution.component.HiveComponent hiveDistrib = null;
    boolean isCustom = false;
    INode connectionInformationNode = node;

    
    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_4);
    
    List<IConnection> connections = (List<IConnection>) node.getIncomingConnections();
    if(connections != null && connections.size() > 0 && connections.get(0) != null) {
        IConnection connection = connections.get(0);
        previousNode = connection.getSource();
        String previousComponentName = previousNode.getUniqueName();
        dbtable = connection.getName();
        uniqueNameConnection = connection.getUniqueName();

        
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_6);
    stringBuffer.append(previousComponentName);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(uniqueNameConnection);
    stringBuffer.append(TEXT_8);
    
    }

    String differenttable = ElementParameterParser.getValue(node, "__DIFFERENT_TABLE_NAME__");
    boolean useDifferentTable = "true".equals(ElementParameterParser.getValue(node, "__USE_DIFFERENT_TABLE__"));

       String dbschema = ElementParameterParser.getValue(node,"__ELT_SCHEMA_NAME__");
    
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(dbschema);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(dbschema);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(useDifferentTable? differenttable:"\""+dbtable +"\"");
    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_17);
    stringBuffer.append(useDifferentTable? differenttable:"\""+dbtable +"\"");
    stringBuffer.append(TEXT_18);
    

    String dataAction = ElementParameterParser.getValue(node,"__DATA_ACTION__");

    List<Map<String, String>> fieldPartitions = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__FIELD_PARTITION__");

    String dbhost = null;
    String dbport = null;
    String dbname = null;
    String dbuser = null;
    String hiveVersion = null;
    String distribution = null;

    //hbase settings
    String storeByHBase = null;
    String zookeeperQuorumForHBase = null;
    String zookeeperClientPortForHBase = null;

    boolean setZNodeParent = false;
    String zNodeParent = null;

    String sslTrustStore = null;
    String sslStorepasswordFieldName = null;

    boolean useSsl = false;
    String additionalJdbcSettings = "";

    String defineRegisterJar = null;
    List<Map<String, String>> registerJarForHBase = null;

    if(previousNode != null) {
        dbhost = ElementParameterParser.getValue(previousNode, "__HOST__");
        dbport = ElementParameterParser.getValue(previousNode, "__PORT__");
        dbname = ElementParameterParser.getValue(previousNode, "__DBNAME__");
        dbuser = ElementParameterParser.getValue(previousNode, "__USER__");
        connectionInformationNode = previousNode;
        hiveVersion = ElementParameterParser.getValue(previousNode, "__HIVE_VERSION__");
        distribution = ElementParameterParser.getValue(previousNode, "__DISTRIBUTION__");

        additionalJdbcSettings = ElementParameterParser.getValue(previousNode, "__HIVE_ADDITIONAL_JDBC__");
        useSsl = "true".equals(ElementParameterParser.getValue(previousNode, "__USE_SSL__"));
        sslTrustStore = ElementParameterParser.getValue(previousNode, "__SSL_TRUST_STORE__");
        sslStorepasswordFieldName = "__SSL_TRUST_STORE_PASSWORD__";

        storeByHBase = ElementParameterParser.getValue(previousNode, "__STORE_BY_HBASE__");
        zookeeperQuorumForHBase = ElementParameterParser.getValue(previousNode, "__ZOOKEEPER_QUORUM__");
        zookeeperClientPortForHBase = ElementParameterParser.getValue(previousNode, "__ZOOKEEPER_CLIENT_PORT__");

        setZNodeParent = "true".equals(ElementParameterParser.getValue(previousNode, "__SET_ZNODE_PARENT__"));
        zNodeParent = ElementParameterParser.getValue(previousNode, "__ZNODE_PARENT__");

        defineRegisterJar = ElementParameterParser.getValue(previousNode, "__DEFINE_REGISTER_JAR__");
        registerJarForHBase = (List<Map<String, String>>)ElementParameterParser.getObjectValue(previousNode, "__REGISTER_JAR__");

        String theDistribution = ElementParameterParser.getValue(previousNode, "__DISTRIBUTION__");
        String theVersion = ElementParameterParser.getValue(previousNode, "__HIVE_VERSION__");

        if("true".equals(ElementParameterParser.getValue(previousNode,"__USE_EXISTING_CONNECTION__"))) {
            String connection = ElementParameterParser.getValue(previousNode, "__CONNECTION__");
            for (INode pNode : previousNode.getProcess().getNodesOfType("tHiveConnection")) {
                if(connection!=null && connection.equals(pNode.getUniqueName())) {
                    theDistribution = ElementParameterParser.getValue(pNode, "__DISTRIBUTION__");
                    theVersion = ElementParameterParser.getValue(pNode, "__HIVE_VERSION__");
                    connectionInformationNode = pNode;
                }
            }
        }

        try {
            hiveDistrib = (org.talend.hadoop.distribution.component.HiveComponent) org.talend.hadoop.distribution.DistributionFactory.buildDistribution(theDistribution, theVersion);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return "";
        }
        isCustom = hiveDistrib instanceof org.talend.hadoop.distribution.custom.CustomDistribution;
    }

    if(hiveDistrib.isExecutedThroughWebHCat()) {
        INode nodeBackup = node;
        node = previousNode;

    
	String useExistingConn = ElementParameterParser.getValue(node,"__USE_EXISTING_CONNECTION__");

    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_23);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_24);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_25);
    
	if("false".equals(useExistingConn)) {
		String passwordFieldName = "__HDINSIGHT_PASSWORD__";
		if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {

    stringBuffer.append(TEXT_26);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_27);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_28);
    
		} else {

    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_30);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_31);
    
		}
			
		passwordFieldName = "__WASB_PASSWORD__";
		if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {

    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_33);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_34);
    
		} else {

    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_36);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_37);
    
		}

    stringBuffer.append(TEXT_38);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_39);
    stringBuffer.append(ElementParameterParser.getValue(node, "__WASB_USERNAME__"));
    stringBuffer.append(TEXT_40);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_41);
    stringBuffer.append(ElementParameterParser.getValue(node, "__WASB_CONTAINER__"));
    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_43);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_44);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_45);
    stringBuffer.append(ElementParameterParser.getValue(node, "__HDINSIGHT_USERNAME__"));
    stringBuffer.append(TEXT_46);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_48);
    stringBuffer.append(ElementParameterParser.getValue(node, "__WEBHCAT_USERNAME__"));
    stringBuffer.append(TEXT_49);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_50);
    stringBuffer.append(ElementParameterParser.getValue(node, "__WEBHCAT_HOST__"));
    stringBuffer.append(TEXT_51);
    stringBuffer.append(ElementParameterParser.getValue(node, "__WEBHCAT_PORT__"));
    stringBuffer.append(TEXT_52);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_53);
    stringBuffer.append(ElementParameterParser.getValue(node, "__STATUSDIR__"));
    stringBuffer.append(TEXT_54);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_55);
    stringBuffer.append(ElementParameterParser.getValue(node, "__REMOTE_FOLDER__"));
    stringBuffer.append(TEXT_56);
    
	} else {
		String azureConnection = ElementParameterParser.getValue(node,"__CONNECTION__");

    stringBuffer.append(TEXT_57);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_58);
    stringBuffer.append(azureConnection);
    stringBuffer.append(TEXT_59);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_60);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_61);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_62);
    stringBuffer.append(azureConnection);
    stringBuffer.append(TEXT_63);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_64);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_65);
    
	}

    stringBuffer.append(TEXT_66);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_67);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_68);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_69);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_70);
    
        node = nodeBackup;
        if("false".equals(useExistingConn)) { // This variable is declared and initialized in the GetAzureConnection.javajet
            boolean setMemory = "true".equals(ElementParameterParser.getValue(previousNode, "__SET_MEMORY__"));
            if(setMemory) {
                String mapMemory = ElementParameterParser.getValue(previousNode,"__MAPREDUCE_MAP_MEMORY_MB__");
                String reduceMemory = ElementParameterParser.getValue(previousNode,"__MAPREDUCE_REDUCE_MEMORY_MB__");
                String amMemory = ElementParameterParser.getValue(previousNode,"__YARN_APP_MAPREDUCE_AM_RESOURCE_MB__");

    stringBuffer.append(TEXT_71);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_72);
    stringBuffer.append(mapMemory);
    stringBuffer.append(TEXT_73);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_74);
    stringBuffer.append(reduceMemory);
    stringBuffer.append(TEXT_75);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_76);
    stringBuffer.append(amMemory);
    stringBuffer.append(TEXT_77);
    
            }

            List<Map<String, String>> advProps = (List<Map<String,String>>)ElementParameterParser.getObjectValue(previousNode, "__ADVANCED_PROPERTIES__");
            if(advProps!=null) {
                for(Map<String, String> item : advProps){

    stringBuffer.append(TEXT_78);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_79);
    stringBuffer.append(item.get("PROPERTY"));
    stringBuffer.append(TEXT_80);
    stringBuffer.append(item.get("VALUE"));
    stringBuffer.append(TEXT_81);
    
                }
            }

    stringBuffer.append(TEXT_82);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_83);
    stringBuffer.append(dbname);
    stringBuffer.append(TEXT_84);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_85);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_86);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_87);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_88);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_89);
    
        }
    } else if(hiveDistrib.isGoogleDataprocDistribution()) {
        INode nodeBackup = node;
        node = previousNode;
        
    
	String useExistingConn = ElementParameterParser.getValue(node,"__USE_EXISTING_CONNECTION__");

    stringBuffer.append(TEXT_90);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_91);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_92);
    
	if("false".equals(useExistingConn)) {

    stringBuffer.append(TEXT_93);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_94);
    
        boolean setMemory = "true".equals(ElementParameterParser.getValue(node, "__SET_MEMORY__"));
        if(setMemory) {
            String mapMemory = ElementParameterParser.getValue(node,"__MAPREDUCE_MAP_MEMORY_MB__");
            String reduceMemory = ElementParameterParser.getValue(node,"__MAPREDUCE_REDUCE_MEMORY_MB__");
            String amMemory = ElementParameterParser.getValue(node,"__YARN_APP_MAPREDUCE_AM_RESOURCE_MB__");

    stringBuffer.append(TEXT_95);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_96);
    stringBuffer.append(mapMemory);
    stringBuffer.append(TEXT_97);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_98);
    stringBuffer.append(reduceMemory);
    stringBuffer.append(TEXT_99);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_100);
    stringBuffer.append(amMemory);
    stringBuffer.append(TEXT_101);
    
        }

        List<Map<String, String>> advProps = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__ADVANCED_PROPERTIES__");
        if(advProps!=null) {
            for(Map<String, String> item : advProps){

    stringBuffer.append(TEXT_102);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_103);
    stringBuffer.append(item.get("PROPERTY"));
    stringBuffer.append(TEXT_104);
    stringBuffer.append(item.get("VALUE"));
    stringBuffer.append(TEXT_105);
    
            }
        }

    stringBuffer.append(TEXT_106);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_107);
    stringBuffer.append(dbname);
    stringBuffer.append(TEXT_108);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_109);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_110);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_111);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_112);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_113);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_114);
    stringBuffer.append(ElementParameterParser.getValue(node, "__GOOGLE_CLUSTER_ID__"));
    stringBuffer.append(TEXT_115);
    stringBuffer.append(ElementParameterParser.getValue(node, "__GOOGLE_REGION__"));
    stringBuffer.append(TEXT_116);
    stringBuffer.append(ElementParameterParser.getValue(node, "__GOOGLE_PROJECT_ID__"));
    stringBuffer.append(TEXT_117);
    stringBuffer.append(ElementParameterParser.getValue(node, "__GOOGLE_JARS_BUCKET__"));
    stringBuffer.append(TEXT_118);
    
            if(ElementParameterParser.getBooleanValue(node, "__DEFINE_PATH_TO_GOOGLE_CREDENTIALS__")) {

    stringBuffer.append(TEXT_119);
    stringBuffer.append(ElementParameterParser.getValue(node, "__PATH_TO_GOOGLE_CREDENTIALS__"));
    stringBuffer.append(TEXT_120);
                  
            }

    stringBuffer.append(TEXT_121);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_122);
    
        if(isLog4jEnabled) {

    stringBuffer.append(TEXT_123);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_124);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_125);
    
        }
	} else {
		String dataprocConnection = ElementParameterParser.getValue(node,"__CONNECTION__");

    stringBuffer.append(TEXT_126);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_127);
    stringBuffer.append(dataprocConnection);
    stringBuffer.append(TEXT_128);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_129);
    stringBuffer.append(dataprocConnection);
    stringBuffer.append(TEXT_130);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_131);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_132);
    
	}

    
        node = nodeBackup;
    } else {
        boolean useExistingConn = ("true").equals(ElementParameterParser.getValue(previousNode, "__USE_EXISTING_CONNECTION__"));

    stringBuffer.append(TEXT_133);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_134);
    
        connectionMode = ElementParameterParser.getValue(previousNode, "__CONNECTION_MODE__");
        setFsDefaultName = "true".equals(ElementParameterParser.getValue(previousNode, "__SET_FS_DEFAULT_NAME__"));
        fsDefaultName = ElementParameterParser.getValue(previousNode, "__FS_DEFAULT_NAME__");
        connectionInformationNode = previousNode;

        String yarnClasspathSeparator = ElementParameterParser.getValue(previousNode, "__CLASSPATH_SEPARATOR__");

    stringBuffer.append(TEXT_135);
    stringBuffer.append(yarnClasspathSeparator);
    stringBuffer.append(TEXT_136);
    

        if(useExistingConn) {
             connectionMode = "";
             setFsDefaultName = false;
             fsDefaultName = "";
             dbuser = "";
             hiveVersion = "";
             distribution = "";
            String connection = ElementParameterParser.getValue(previousNode, "__CONNECTION__");
            for (INode pNode : node.getProcess().getNodesOfType("tHiveConnection")) {
                    if(connection!=null && connection.equals(pNode.getUniqueName())) {
                        connectionMode = ElementParameterParser.getValue(pNode, "__CONNECTION_MODE__");
                        setFsDefaultName = "true".equals(ElementParameterParser.getValue(pNode, "__SET_FS_DEFAULT_NAME__"));
                        fsDefaultName = ElementParameterParser.getValue(pNode, "__FS_DEFAULT_NAME__");
                        dbuser = ElementParameterParser.getValue(pNode, "__USER__");
                        hiveVersion = ElementParameterParser.getValue(pNode, "__HIVE_VERSION__");
                        distribution = ElementParameterParser.getValue(pNode, "__DISTRIBUTION__");
                        connectionInformationNode = pNode;
                        break;
                    }
             }

            String conn = "conn_" + connection;
            String db = "db_" + connection;
            String dbUser = "dbUser_" + connection;
            
    stringBuffer.append(TEXT_137);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_138);
    stringBuffer.append(conn);
    stringBuffer.append(TEXT_139);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_140);
    stringBuffer.append(db);
    stringBuffer.append(TEXT_141);
    stringBuffer.append(cid);
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
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_148);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_149);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_150);
    stringBuffer.append(dbUser);
    stringBuffer.append(TEXT_151);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_152);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_153);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_154);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_155);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_156);
    
        } else {
            String javaDbDriver = "org.apache.hadoop.hive.jdbc.HiveDriver";
            String hiveServer = ElementParameterParser.getValue(previousNode, "__HIVE_SERVER__");

            boolean useKrb = "true".equals(ElementParameterParser.getValue(previousNode, "__USE_KRB__"));
            boolean securityIsEnabled = useKrb && (isCustom || (hiveDistrib.doSupportKerberos() && (("HIVE".equalsIgnoreCase(hiveServer) && "EMBEDDED".equalsIgnoreCase(connectionMode)) || "HIVE2".equalsIgnoreCase(hiveServer))));
            boolean securedStandaloneHive2 = securityIsEnabled && "HIVE2".equalsIgnoreCase(hiveServer) && "STANDALONE".equalsIgnoreCase(connectionMode);
            boolean securedEmbedded = securityIsEnabled && "EMBEDDED".equalsIgnoreCase(connectionMode);
            boolean securedEmbeddedHive2 = securedEmbedded && "HIVE2".equalsIgnoreCase(hiveServer);

            String hivePrincipal = ElementParameterParser.getValue(previousNode, "__HIVE_PRINCIPAL__");
            if(hiveServer!=null && !"".equals(hiveServer.trim()) && (isCustom || hiveDistrib.doSupportHive2())) {
                hiveServer = hiveServer.toLowerCase();
                if ("hive2".equals(hiveServer)) {
                    javaDbDriver = "org.apache.hive.jdbc.HiveDriver";
                }
            } else {
                hiveServer = "hive";
            }

            if(("hive".equals(hiveServer) && !hiveDistrib.doSupportHive1()) || ("hive2".equals(hiveServer) && !hiveDistrib.doSupportHive2())) {

    stringBuffer.append(TEXT_157);
    stringBuffer.append(hiveDistrib.getVersion());
    stringBuffer.append(TEXT_158);
    
            }

            if(("STANDALONE".equals(connectionMode) && !hiveDistrib.doSupportStandaloneMode()) || ("EMBEDDED".equals(connectionMode) && !hiveDistrib.doSupportEmbeddedMode())) {

    stringBuffer.append(TEXT_159);
    stringBuffer.append(hiveDistrib.getVersion());
    stringBuffer.append(TEXT_160);
    
            }

            if("STANDALONE".equals(connectionMode) && "hive".equals(hiveServer) && !hiveDistrib.doSupportHive1Standalone()) {

    stringBuffer.append(TEXT_161);
    
            }

    stringBuffer.append(TEXT_162);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_163);
    stringBuffer.append(dbuser);
    stringBuffer.append(TEXT_164);
    
            String passwordFieldName = "__PASS__";
            
    stringBuffer.append(TEXT_165);
    stringBuffer.append(TEXT_166);
    stringBuffer.append(TEXT_167);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_168);
    if (ElementParameterParser.canEncrypt(previousNode, passwordFieldName)) {
    stringBuffer.append(TEXT_169);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_170);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(previousNode, passwordFieldName));
    stringBuffer.append(TEXT_171);
    } else {
    stringBuffer.append(TEXT_172);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_173);
    stringBuffer.append( ElementParameterParser.getValue(previousNode, passwordFieldName));
    stringBuffer.append(TEXT_174);
    }
    stringBuffer.append(TEXT_175);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_176);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_177);
    
            boolean setHadoopUser = "true".equals(ElementParameterParser.getValue(previousNode, "__SET_HADOOP_USER__"));
            if (setHadoopUser) {
                String hadoopUser = ElementParameterParser.getValue(previousNode, "__HADOOP_USER__");

    stringBuffer.append(TEXT_178);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_179);
    stringBuffer.append(hadoopUser);
    stringBuffer.append(TEXT_180);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_181);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_182);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_183);
    
            }

    stringBuffer.append(TEXT_184);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_185);
    
            if("EMBEDDED".equals(connectionMode) && (isCustom || hiveDistrib.doSupportEmbeddedMode())) {

    stringBuffer.append(TEXT_186);
    stringBuffer.append(dbhost);
    stringBuffer.append(TEXT_187);
    stringBuffer.append(dbport);
    stringBuffer.append(TEXT_188);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_189);
    stringBuffer.append(hiveServer);
    stringBuffer.append(TEXT_190);
    
                if(isCustom || (!isCustom && hiveDistrib.doSupportImpersonation())) {

    stringBuffer.append(TEXT_191);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_192);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_193);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_194);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_195);
    
                }
            } else if("STANDALONE".equals(connectionMode) && (isCustom || hiveDistrib.doSupportStandaloneMode())) {
                if(securedStandaloneHive2) {

                    // Using SSL in Secure Mode
                    if(useSsl && hiveDistrib.doSupportSSL()) {
                        // Does the distrib support SSL + KERBEROS
                        if(hiveDistrib.doSupportSSLwithKerberos()){
                            if (ElementParameterParser.canEncrypt(node, sslStorepasswordFieldName)) {

    stringBuffer.append(TEXT_196);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_197);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(previousNode, sslStorepasswordFieldName));
    stringBuffer.append(TEXT_198);
    
                            }else{

    stringBuffer.append(TEXT_199);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_200);
    stringBuffer.append( ElementParameterParser.getValue(previousNode, sslStorepasswordFieldName));
    stringBuffer.append(TEXT_201);
    
                            }

    stringBuffer.append(TEXT_202);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_203);
    stringBuffer.append(hiveServer);
    stringBuffer.append(TEXT_204);
    stringBuffer.append(dbhost);
    stringBuffer.append(TEXT_205);
    stringBuffer.append(dbport);
    stringBuffer.append(TEXT_206);
    stringBuffer.append(dbname);
    stringBuffer.append(TEXT_207);
    stringBuffer.append(hivePrincipal);
    stringBuffer.append(TEXT_208);
    stringBuffer.append(sslTrustStore);
    stringBuffer.append(TEXT_209);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_210);
    
                        // Does the distrib support only SASL-QOP + KERBEROS Or was it migrated from old SASL job
                        } else {

    stringBuffer.append(TEXT_211);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_212);
    stringBuffer.append(hiveServer);
    stringBuffer.append(TEXT_213);
    stringBuffer.append(dbhost);
    stringBuffer.append(TEXT_214);
    stringBuffer.append(dbport);
    stringBuffer.append(TEXT_215);
    stringBuffer.append(dbname);
    stringBuffer.append(TEXT_216);
    stringBuffer.append(hivePrincipal);
    stringBuffer.append(TEXT_217);
    
                        }
                    } else {

    stringBuffer.append(TEXT_218);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_219);
    stringBuffer.append(hiveServer);
    stringBuffer.append(TEXT_220);
    stringBuffer.append(dbhost);
    stringBuffer.append(TEXT_221);
    stringBuffer.append(dbport);
    stringBuffer.append(TEXT_222);
    stringBuffer.append(dbname);
    stringBuffer.append(TEXT_223);
    stringBuffer.append(hivePrincipal);
    stringBuffer.append(TEXT_224);
    
                    }
                } else {
                // Using SSL in non Secure Mode
                    if(useSsl && hiveDistrib.doSupportSSL()){
                        if(previousNode != null) {
                            if (ElementParameterParser.canEncrypt(previousNode, sslStorepasswordFieldName)) {

    stringBuffer.append(TEXT_225);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_226);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(previousNode, sslStorepasswordFieldName));
    stringBuffer.append(TEXT_227);
    
                            } else {
    
    stringBuffer.append(TEXT_228);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_229);
    stringBuffer.append( ElementParameterParser.getValue(previousNode, sslStorepasswordFieldName));
    stringBuffer.append(TEXT_230);
    
                            }
                        } else {

    stringBuffer.append(TEXT_231);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_232);
    
                        }

    stringBuffer.append(TEXT_233);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_234);
    stringBuffer.append(hiveServer);
    stringBuffer.append(TEXT_235);
    stringBuffer.append(dbhost);
    stringBuffer.append(TEXT_236);
    stringBuffer.append(dbport);
    stringBuffer.append(TEXT_237);
    stringBuffer.append(dbname);
    stringBuffer.append(TEXT_238);
    stringBuffer.append(sslTrustStore);
    stringBuffer.append(TEXT_239);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_240);
    
                    } else {

    stringBuffer.append(TEXT_241);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_242);
    stringBuffer.append(hiveServer);
    stringBuffer.append(TEXT_243);
    stringBuffer.append(dbhost);
    stringBuffer.append(TEXT_244);
    stringBuffer.append(dbport);
    stringBuffer.append(TEXT_245);
    stringBuffer.append(dbname);
    stringBuffer.append(TEXT_246);
    
                    }
                }

    stringBuffer.append(TEXT_247);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_248);
    stringBuffer.append(additionalJdbcSettings);
    stringBuffer.append(TEXT_249);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_250);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_251);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_252);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_253);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_254);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_255);
    
            }

    stringBuffer.append(TEXT_256);
    stringBuffer.append(javaDbDriver );
    stringBuffer.append(TEXT_257);
    
            if(securedStandaloneHive2) {

    stringBuffer.append(TEXT_258);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_259);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_260);
    
            } else {

    stringBuffer.append(TEXT_261);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_262);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_263);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_264);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_265);
    
            }


    stringBuffer.append(TEXT_266);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_267);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_268);
    
            if(!isCustom && ("HDP_1_2".equals(hiveVersion) || "HDP_1_3".equals(hiveVersion))) {
                String mapMemory = ElementParameterParser.getValue(previousNode,"__MAPRED_JOB_MAP_MEMORY_MB__");
                String reduceMemory = ElementParameterParser.getValue(previousNode,"__MAPRED_JOB_REDUCE_MEMORY_MB__");

    stringBuffer.append(TEXT_269);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_270);
    stringBuffer.append(mapMemory);
    stringBuffer.append(TEXT_271);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_272);
    stringBuffer.append(reduceMemory);
    stringBuffer.append(TEXT_273);
    
            }

            boolean isKerberosAvailableHadoop2 = !isCustom && hiveDistrib.isHadoop2() && hiveDistrib.doSupportKerberos();
            boolean isHadoop2 = !isCustom && hiveDistrib.isHadoop2();
            boolean isKerberosAvailableHadoop1 = !isCustom && hiveDistrib.isHadoop1() && hiveDistrib.doSupportKerberos();

            boolean useYarn = "true".equals(ElementParameterParser.getValue(previousNode, "__USE_YARN__"));

            if(securedEmbedded) {
                String namenodePrincipal = ElementParameterParser.getValue(previousNode, "__NAMENODE_PRINCIPAL__");

    stringBuffer.append(TEXT_274);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_275);
    stringBuffer.append(namenodePrincipal);
    stringBuffer.append(TEXT_276);
    
                if(isKerberosAvailableHadoop1 || (isCustom && !useYarn)) {
                    String jobtrackerPrincipal = ElementParameterParser.getValue(previousNode, "__JOBTRACKER_PRINCIPAL__");

    stringBuffer.append(TEXT_277);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_278);
    stringBuffer.append(jobtrackerPrincipal);
    stringBuffer.append(TEXT_279);
    
                }
                if(isKerberosAvailableHadoop2 || (isCustom && useYarn)) {
                    String resourceManagerPrincipal = ElementParameterParser.getValue(previousNode, "__RESOURCEMANAGER_PRINCIPAL__");

    stringBuffer.append(TEXT_280);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_281);
    stringBuffer.append(resourceManagerPrincipal);
    stringBuffer.append(TEXT_282);
    
                }

            }

            boolean setResourceManager = "true".equals(ElementParameterParser.getValue(previousNode, "__SET_RESOURCE_MANAGER__"));

            if((isCustom && useYarn) || (!isCustom && isHadoop2)) {
                if(setResourceManager) {
                    String resourceManager = ElementParameterParser.getValue(previousNode, "__RESOURCE_MANAGER__");

    stringBuffer.append(TEXT_283);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_284);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_285);
    stringBuffer.append(resourceManager);
    stringBuffer.append(TEXT_286);
    
                }

                boolean setJobHistoryAddress = "true".equals(ElementParameterParser.getValue(previousNode, "__SET_JOBHISTORY_ADDRESS__"));
                if(setJobHistoryAddress) {
                    String jobHistoryAddress = ElementParameterParser.getValue(previousNode,"__JOBHISTORY_ADDRESS__");
                    
    stringBuffer.append(TEXT_287);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_288);
    stringBuffer.append(jobHistoryAddress);
    stringBuffer.append(TEXT_289);
    
                }

                boolean setSchedulerAddress = "true".equals(ElementParameterParser.getValue(previousNode, "__SET_SCHEDULER_ADDRESS__"));
                if(setSchedulerAddress) {
                    String schedulerAddress = ElementParameterParser.getValue(previousNode,"__RESOURCEMANAGER_SCHEDULER_ADDRESS__");

    stringBuffer.append(TEXT_290);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_291);
    stringBuffer.append(schedulerAddress);
    stringBuffer.append(TEXT_292);
    
                }

                if ("true".equals(ElementParameterParser.getValue(previousNode, "__USE_DATANODE_HOSTNAME__"))) {

    stringBuffer.append(TEXT_293);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_294);
    
                }

                if(setFsDefaultName) {

    stringBuffer.append(TEXT_295);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_296);
    stringBuffer.append(fsDefaultName);
    stringBuffer.append(TEXT_297);
    
                }

                if("EMBEDDED".equals(connectionMode) && (isCustom || hiveDistrib.doSupportEmbeddedMode())) {
                    boolean crossPlatformSubmission = "true".equals(ElementParameterParser.getValue(node, "__CROSS_PLATFORM_SUBMISSION__"));
                    if((isCustom && useYarn && crossPlatformSubmission) || (!isCustom && hiveDistrib.doSupportCrossPlatformSubmission())) {

    stringBuffer.append(TEXT_298);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_299);
    
                    }

                    if("MAPR410".equals(hiveVersion)){

    stringBuffer.append(TEXT_300);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_301);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_302);
    
                    }

                    if(hiveDistrib.doSupportCustomMRApplicationCP()){

    stringBuffer.append(TEXT_303);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_304);
    stringBuffer.append(hiveDistrib.getCustomMRApplicationCP());
    stringBuffer.append(TEXT_305);
    
                    }

    stringBuffer.append(TEXT_306);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_307);
    stringBuffer.append(hiveDistrib.getYarnApplicationClasspath());
    stringBuffer.append(TEXT_308);
    
                }

                boolean setMemory = "true".equals(ElementParameterParser.getValue(previousNode, "__SET_MEMORY__"));
                if(setMemory) {
                    String mapMemory = ElementParameterParser.getValue(previousNode,"__MAPREDUCE_MAP_MEMORY_MB__");
                    String reduceMemory = ElementParameterParser.getValue(previousNode,"__MAPREDUCE_REDUCE_MEMORY_MB__");
                    String amMemory = ElementParameterParser.getValue(previousNode,"__YARN_APP_MAPREDUCE_AM_RESOURCE_MB__");

    stringBuffer.append(TEXT_309);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_310);
    stringBuffer.append(mapMemory);
    stringBuffer.append(TEXT_311);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_312);
    stringBuffer.append(reduceMemory);
    stringBuffer.append(TEXT_313);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_314);
    stringBuffer.append(amMemory);
    stringBuffer.append(TEXT_315);
    
                }
            }

            List<Map<String, String>> advProps = (List<Map<String,String>>)ElementParameterParser.getObjectValue(previousNode, "__ADVANCED_PROPERTIES__");
            if(advProps!=null) {
                for(Map<String, String> item : advProps){

    stringBuffer.append(TEXT_316);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_317);
    stringBuffer.append(item.get("PROPERTY"));
    stringBuffer.append(TEXT_318);
    stringBuffer.append(item.get("VALUE"));
    stringBuffer.append(TEXT_319);
    
                }
            }

    stringBuffer.append(TEXT_320);
    
    		boolean useExistingConnection = "true".equals(ElementParameterParser.getValue(node,"__USE_EXISTING_CONNECTION__"));
    		if(!useExistingConnection){

    stringBuffer.append(TEXT_321);
    stringBuffer.append(TEXT_322);
    
class PrepareTez{
	public void invoke(INode node, String cid){
        String hiveDistribution = ElementParameterParser.getValue(node, "__DISTRIBUTION__");
        String hiveVersion = ElementParameterParser.getValue(node, "__HIVE_VERSION__");

        org.talend.hadoop.distribution.component.HiveComponent hiveDistrib = null;
        try {
            hiveDistrib = (org.talend.hadoop.distribution.component.HiveComponent) org.talend.hadoop.distribution.DistributionFactory.buildDistribution(hiveDistribution, hiveVersion);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }

        boolean isCustom = hiveDistrib instanceof org.talend.hadoop.distribution.custom.CustomDistribution;

        boolean changePathSeparator = !hiveDistrib.isExecutedThroughWebHCat();

        String connectionMode = ElementParameterParser.getValue(node, "__CONNECTION_MODE__");
        List<Map<String, String>> advProps = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__ADVANCED_PROPERTIES__");
        String dbuser = ElementParameterParser.getValue(node, "__USER__");
        
        boolean useTez = "tez".equals(ElementParameterParser.getValue(node, "__EXECUTION_ENGINE__"));
    	boolean supportTez = (isCustom || hiveDistrib.doSupportTezForHive()) && "EMBEDDED".equals(connectionMode);
    	if(supportTez && useTez){
    	
    stringBuffer.append(TEXT_323);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_324);
    
            if(advProps != null){
                for(Map<String, String> item : advProps){
                    if("\"tez.lib.uris\"".equals(item.get("PROPERTY"))){
                    
    stringBuffer.append(TEXT_325);
      
                    }
                }
            }
            boolean installTez = "INSTALL".equals(ElementParameterParser.getValue(node, "__TEZ_LIB__"));
            if(installTez){
                //prepare the folder
                
    stringBuffer.append(TEXT_326);
    
class GetFileSystem{
	public void invoke(INode node, String cid){
        String fsDefaultName = ElementParameterParser.getValue(node, "__FS_DEFAULT_NAME__");
        List<Map<String, String>> hadoopProps = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__HADOOP_ADVANCED_PROPERTIES__");
        String user = null;
        
        String fsDefaultNameKey = "fs.default.name";
        
        String distribution = null;
        String hadoopVersion = null;
        boolean isCustom = false;

        String dbuser = ElementParameterParser.getValue(node, "__USER__");
        
    stringBuffer.append(TEXT_327);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_328);
    stringBuffer.append(dbuser);
    stringBuffer.append(TEXT_329);
    stringBuffer.append(dbuser);
    stringBuffer.append(TEXT_330);
    stringBuffer.append(dbuser);
    stringBuffer.append(TEXT_331);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_332);
    
        distribution = ElementParameterParser.getValue(node, "__DISTRIBUTION__");
        hadoopVersion = ElementParameterParser.getValue(node, "__HIVE_VERSION__");
        boolean useKrb = "true".equals(ElementParameterParser.getValue(node, "__USE_KRB__"));
        String kerberosPrincipal = ElementParameterParser.getValue(node, "__NAMENODE_PRINCIPAL__");
        boolean useKeytab = "true".equals(ElementParameterParser.getValue(node, "__USE_KEYTAB__"));
        String userPrincipal = ElementParameterParser.getValue(node, "__PRINCIPAL__");
        String keytabPath = ElementParameterParser.getValue(node, "__KEYTAB_PATH__");
        boolean mrUseDatanodeHostname = "true".equals(ElementParameterParser.getValue(node, "__USE_DATANODE_HOSTNAME__"));

        org.talend.hadoop.distribution.component.HDFSComponent hdfsDistrib = null;
        try {
            hdfsDistrib = (org.talend.hadoop.distribution.component.HDFSComponent) org.talend.hadoop.distribution.DistributionFactory.buildDistribution(distribution, hadoopVersion);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }

        isCustom = hdfsDistrib instanceof org.talend.hadoop.distribution.custom.CustomDistribution;
        
        
    stringBuffer.append(TEXT_333);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_334);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_335);
    stringBuffer.append(fsDefaultNameKey);
    stringBuffer.append(TEXT_336);
    stringBuffer.append(fsDefaultName);
    stringBuffer.append(TEXT_337);
    
        if(mrUseDatanodeHostname && (isCustom || hdfsDistrib.doSupportUseDatanodeHostname())){
        
    stringBuffer.append(TEXT_338);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_339);
    
        }
        if(hadoopProps!=null && hadoopProps.size() > 0){
        	for(Map<String, String> item : hadoopProps){
        	
    stringBuffer.append(TEXT_340);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_341);
    stringBuffer.append(item.get("PROPERTY") );
    stringBuffer.append(TEXT_342);
    stringBuffer.append(item.get("VALUE") );
    stringBuffer.append(TEXT_343);
     
    		}
    	}
        	
    	if((hdfsDistrib.doSupportKerberos() && useKrb && !isCustom) || (isCustom && useKrb)){
    	
    stringBuffer.append(TEXT_344);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_345);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_346);
    stringBuffer.append(kerberosPrincipal);
    stringBuffer.append(TEXT_347);
    
    		if(useKeytab){
    		
    stringBuffer.append(TEXT_348);
    stringBuffer.append(userPrincipal);
    stringBuffer.append(TEXT_349);
    stringBuffer.append(keytabPath);
    stringBuffer.append(TEXT_350);
    
    		}
    	}
    	
    	if(hdfsDistrib.doSupportGroup()){
    		
    stringBuffer.append(TEXT_351);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_352);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_353);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_354);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_355);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_356);
    
        }else{
        
    stringBuffer.append(TEXT_357);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_358);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_359);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_360);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_361);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_362);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_363);
    stringBuffer.append(fsDefaultNameKey);
    stringBuffer.append(TEXT_364);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_365);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_366);
    
        }
    }
}

      
                (new GetFileSystem()).invoke(node, cid);
                String tezLibFolder = ElementParameterParser.getValue(node, "__TEZ_LIB_FOLDER__");
                boolean useDefaultTezLibFolder = "\"/tmp/{USERNAME}/talend_tez_libs/{custom|HIVE_VERSION}\"".equals(tezLibFolder);
                if(useDefaultTezLibFolder){
                
    stringBuffer.append(TEXT_367);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_368);
    stringBuffer.append(dbuser);
    stringBuffer.append(TEXT_369);
    stringBuffer.append(dbuser);
    stringBuffer.append(TEXT_370);
    stringBuffer.append(dbuser);
    stringBuffer.append(TEXT_371);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_372);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_373);
    stringBuffer.append(isCustom?"custom":hiveVersion);
    stringBuffer.append(TEXT_374);
    
                }else{
                
    stringBuffer.append(TEXT_375);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_376);
    stringBuffer.append(tezLibFolder);
    stringBuffer.append(TEXT_377);
    
                }
                
    stringBuffer.append(TEXT_378);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_379);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_380);
    
                List<String> tezLibJarsName = new java.util.ArrayList<String>();
                if(isCustom){
                    List<Map<String,String>> tezLibJarsNameValue = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node,"__TEZ_LIB_NAME__");
                    for(Map<String, String> tezLibJarsNameV : tezLibJarsNameValue){
                        tezLibJarsName.add(tezLibJarsNameV.get("JAR_NAME"));
                    }
                }else{
                    String tezLibJarsNameValue = ElementParameterParser.getValue(node, "__TEZ_JARS_NAME__");
                    if(tezLibJarsNameValue != null && !"".equals(tezLibJarsNameValue)){
                        tezLibJarsName = java.util.Arrays.asList(tezLibJarsNameValue.split(","));
                    }
                }
                
    stringBuffer.append(TEXT_381);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_382);
    if(changePathSeparator){
    stringBuffer.append(TEXT_383);
    }else{
    stringBuffer.append(TEXT_384);
    }
    stringBuffer.append(TEXT_385);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_386);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_387);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_388);
    
                    for(String jarName : tezLibJarsName){
                    
    stringBuffer.append(TEXT_389);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_390);
    stringBuffer.append(jarName);
    stringBuffer.append(TEXT_391);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_392);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_393);
    stringBuffer.append(jarName);
    stringBuffer.append(TEXT_394);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_395);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_396);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_397);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_398);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_399);
    
                    }
                    
    stringBuffer.append(TEXT_400);
    
            }else{
            
    stringBuffer.append(TEXT_401);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_402);
    stringBuffer.append(ElementParameterParser.getValue(node, "__TEZ_LIB_PATH__"));
    stringBuffer.append(TEXT_403);
    
            }
            //define the location of tez lib    
            
    stringBuffer.append(TEXT_404);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_405);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_406);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_407);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_408);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_409);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_410);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_411);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_412);
    stringBuffer.append(ElementParameterParser.getValue(node, "__FS_DEFAULT_NAME__"));
    stringBuffer.append(TEXT_413);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_414);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_415);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_416);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_417);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_418);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_419);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_420);
    
    	}
    }
}

    
    	       (new PrepareTez()).invoke(previousNode, cid);
            }

    stringBuffer.append(TEXT_421);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_422);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_423);
    stringBuffer.append(dbname);
    stringBuffer.append(TEXT_424);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_425);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_426);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_427);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_428);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_429);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_430);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_431);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_432);
    
            if("true".equalsIgnoreCase(storeByHBase) && (isCustom || hiveDistrib.doSupportHBaseForHive())) {
    stringBuffer.append(TEXT_433);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_434);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_435);
    if(zookeeperQuorumForHBase!=null && !"".equals(zookeeperQuorumForHBase) && !"\"\"".equals(zookeeperQuorumForHBase)) {
    stringBuffer.append(TEXT_436);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_437);
    stringBuffer.append(zookeeperQuorumForHBase);
    stringBuffer.append(TEXT_438);
    }
    stringBuffer.append(TEXT_439);
    if(zookeeperClientPortForHBase!=null && !"".equals(zookeeperClientPortForHBase) && !"\"\"".equals(zookeeperClientPortForHBase)) {
    stringBuffer.append(TEXT_440);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_441);
    stringBuffer.append(zookeeperClientPortForHBase);
    stringBuffer.append(TEXT_442);
    }
    stringBuffer.append(TEXT_443);
    if(setZNodeParent && zNodeParent!=null && !"".equals(zNodeParent) && !"\"\"".equals(zNodeParent)) {
    stringBuffer.append(TEXT_444);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_445);
    stringBuffer.append(zNodeParent);
    stringBuffer.append(TEXT_446);
    }
    stringBuffer.append(TEXT_447);
    if("true".equalsIgnoreCase(defineRegisterJar) && registerJarForHBase!=null && registerJarForHBase.size()>0) {
                    for(Map<String, String> jar : registerJarForHBase){
                        String path = jar.get("JAR_PATH");
                        if(path == null || "".equals(path) || "\"\"".equals(path)) {
                            continue;
                        }

    stringBuffer.append(TEXT_448);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_449);
    stringBuffer.append(path);
    stringBuffer.append(TEXT_450);
    
                    }
                }

    stringBuffer.append(TEXT_451);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_452);
    
            }
        }
    }

 List<IMetadataColumn> columnList = null;

 List<IMetadataTable> metadatas = node.getMetadataList();
 if(metadatas !=null && metadatas.size()>0){
     IMetadataTable metadata = metadatas.get(0);
     if(metadata != null){
         columnList = metadata.getListColumns();
     }
}

    // Register jars to handle the parquet format.
    boolean targetTableUsesParquetFormat = "true".equals(ElementParameterParser.getValue(node, "__TARGET_TABLE_IS_A_PARQUET_TABLE__"));

    boolean isParquetSupported = isCustom || hiveDistrib.doSupportParquetFormat();
    if(targetTableUsesParquetFormat && !isParquetSupported) {

    stringBuffer.append(TEXT_453);
    
    }

    boolean generateAddJarCodeForAll = targetTableUsesParquetFormat;

    if(targetTableUsesParquetFormat) {
        String compression = ElementParameterParser.getValue(node, "__PARQUET_COMPRESSION__");
        java.util.List<String> jarsToRegister = null;
        java.util.List<String> jars = null;
        if(generateAddJarCodeForAll) {
            String[] commandLine = new String[] {"<command>"};
            try {
                commandLine = ProcessorUtilities.getCommandLine("win32",true, processId, "",org.talend.designer.runprocess.IProcessor.NO_STATISTICS,org.talend.designer.runprocess.IProcessor.NO_TRACES, new String[]{});
            } catch (ProcessorException e) {
                e.printStackTrace();
            }

            jarsToRegister = new java.util.ArrayList();

            jarsToRegister.add("snappy-java");
            //jarsToRegister.add("parquet-hadoop-bundle");
            jarsToRegister.add("parquet-hive-bundle");

            for (int j = 0; j < commandLine.length; j++) {
                if(commandLine[j].contains("jar")) {
                    jars = java.util.Arrays.asList(commandLine[j].split(";"));
                    break;
                }
            }
        }
        if(jarsToRegister!=null && jars!=null) {
            if("EMBEDDED".equalsIgnoreCase(connectionMode) || hiveDistrib.useCloudLauncher()) {

    stringBuffer.append(TEXT_454);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_455);
    
            } else {
                generateAddJarCodeForAll = false;
                if(setFsDefaultName) {
                    generateAddJarCodeForAll = true;

    stringBuffer.append(TEXT_456);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_457);
    stringBuffer.append(TEXT_458);
    
class GetFileSystem{
	public void invoke(INode node, String cid){
        String fsDefaultName = ElementParameterParser.getValue(node, "__FS_DEFAULT_NAME__");
        List<Map<String, String>> hadoopProps = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__HADOOP_ADVANCED_PROPERTIES__");
        String user = null;
        
        String fsDefaultNameKey = "fs.default.name";
        
        String distribution = null;
        String hadoopVersion = null;
        boolean isCustom = false;

        String dbuser = ElementParameterParser.getValue(node, "__USER__");
        
    stringBuffer.append(TEXT_459);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_460);
    stringBuffer.append(dbuser);
    stringBuffer.append(TEXT_461);
    stringBuffer.append(dbuser);
    stringBuffer.append(TEXT_462);
    stringBuffer.append(dbuser);
    stringBuffer.append(TEXT_463);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_464);
    
        distribution = ElementParameterParser.getValue(node, "__DISTRIBUTION__");
        hadoopVersion = ElementParameterParser.getValue(node, "__HIVE_VERSION__");
        boolean useKrb = "true".equals(ElementParameterParser.getValue(node, "__USE_KRB__"));
        String kerberosPrincipal = ElementParameterParser.getValue(node, "__NAMENODE_PRINCIPAL__");
        boolean useKeytab = "true".equals(ElementParameterParser.getValue(node, "__USE_KEYTAB__"));
        String userPrincipal = ElementParameterParser.getValue(node, "__PRINCIPAL__");
        String keytabPath = ElementParameterParser.getValue(node, "__KEYTAB_PATH__");
        boolean mrUseDatanodeHostname = "true".equals(ElementParameterParser.getValue(node, "__USE_DATANODE_HOSTNAME__"));

        org.talend.hadoop.distribution.component.HDFSComponent hdfsDistrib = null;
        try {
            hdfsDistrib = (org.talend.hadoop.distribution.component.HDFSComponent) org.talend.hadoop.distribution.DistributionFactory.buildDistribution(distribution, hadoopVersion);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }

        isCustom = hdfsDistrib instanceof org.talend.hadoop.distribution.custom.CustomDistribution;
        
        
    stringBuffer.append(TEXT_465);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_466);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_467);
    stringBuffer.append(fsDefaultNameKey);
    stringBuffer.append(TEXT_468);
    stringBuffer.append(fsDefaultName);
    stringBuffer.append(TEXT_469);
    
        if(mrUseDatanodeHostname && (isCustom || hdfsDistrib.doSupportUseDatanodeHostname())){
        
    stringBuffer.append(TEXT_470);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_471);
    
        }
        if(hadoopProps!=null && hadoopProps.size() > 0){
        	for(Map<String, String> item : hadoopProps){
        	
    stringBuffer.append(TEXT_472);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_473);
    stringBuffer.append(item.get("PROPERTY") );
    stringBuffer.append(TEXT_474);
    stringBuffer.append(item.get("VALUE") );
    stringBuffer.append(TEXT_475);
     
    		}
    	}
        	
    	if((hdfsDistrib.doSupportKerberos() && useKrb && !isCustom) || (isCustom && useKrb)){
    	
    stringBuffer.append(TEXT_476);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_477);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_478);
    stringBuffer.append(kerberosPrincipal);
    stringBuffer.append(TEXT_479);
    
    		if(useKeytab){
    		
    stringBuffer.append(TEXT_480);
    stringBuffer.append(userPrincipal);
    stringBuffer.append(TEXT_481);
    stringBuffer.append(keytabPath);
    stringBuffer.append(TEXT_482);
    
    		}
    	}
    	
    	if(hdfsDistrib.doSupportGroup()){
    		
    stringBuffer.append(TEXT_483);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_484);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_485);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_486);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_487);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_488);
    
        }else{
        
    stringBuffer.append(TEXT_489);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_490);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_491);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_492);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_493);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_494);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_495);
    stringBuffer.append(fsDefaultNameKey);
    stringBuffer.append(TEXT_496);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_497);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_498);
    
        }
    }
}

    stringBuffer.append(TEXT_499);
    
			(new GetFileSystem()).invoke(connectionInformationNode, cid);
			
    stringBuffer.append(TEXT_500);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_501);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_502);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_503);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_504);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_505);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_506);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_507);
    stringBuffer.append(fsDefaultName);
    stringBuffer.append(TEXT_508);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_509);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_510);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_511);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_512);
    
                }
            }

            if(generateAddJarCodeForAll) {
                if(!hiveDistrib.useCloudLauncher()) { // Then we create a SQL statement to add the jars.

    stringBuffer.append(TEXT_513);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_514);
    
                }
                for(int i=0; i<jarsToRegister.size(); i++) {
                    String jarToRegister = jarsToRegister.get(i);
                    for(int j=0; j<jars.size(); j++) {
                        if(jars.get(j).contains(jarToRegister)) {
                            if(!hiveDistrib.useCloudLauncher()) { // Then we use the created SQL statement to add the jars.

    stringBuffer.append(TEXT_515);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_516);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_517);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_518);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_519);
    stringBuffer.append(jars.get(j));
    stringBuffer.append(TEXT_520);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_521);
    
                            } else { // cloud distribution
                                if (hiveDistrib.isExecutedThroughWebHCat()) {

    stringBuffer.append(TEXT_522);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_523);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_524);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_525);
    stringBuffer.append(jars.get(j));
    stringBuffer.append(TEXT_526);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_527);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_528);
    stringBuffer.append(jars.get(j));
    stringBuffer.append(TEXT_529);
    
                                } else { // dataproc
                                    if(isLog4jEnabled) {

    stringBuffer.append(TEXT_530);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_531);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_532);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_533);
    stringBuffer.append(jars.get(j));
    stringBuffer.append(TEXT_534);
    
                                    }

    stringBuffer.append(TEXT_535);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_536);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_537);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_538);
    stringBuffer.append(jars.get(j));
    stringBuffer.append(TEXT_539);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_540);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_541);
    stringBuffer.append(jars.get(j));
    stringBuffer.append(TEXT_542);
    
                                }
                            }
                        }
                    }
                }
            }
        }

        if(!hiveDistrib.useCloudLauncher()) {

    stringBuffer.append(TEXT_543);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_544);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_545);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_546);
    stringBuffer.append(compression);
    stringBuffer.append(TEXT_547);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_548);
    
        } else {
            if (hiveDistrib.isExecutedThroughWebHCat()) {

    stringBuffer.append(TEXT_549);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_550);
    stringBuffer.append(compression);
    stringBuffer.append(TEXT_551);
    
            } else { // dataproc
                if(isLog4jEnabled) {

    stringBuffer.append(TEXT_552);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_553);
    stringBuffer.append(compression);
    stringBuffer.append(TEXT_554);
    
                }

    stringBuffer.append(TEXT_555);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_556);
    stringBuffer.append(compression);
    stringBuffer.append(TEXT_557);
    
            }
        }
    }
        // End of parquet format handling.

    
    if(!hiveDistrib.useCloudLauncher()) {

    stringBuffer.append(TEXT_558);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_559);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_560);
    
    }

    stringBuffer.append(TEXT_561);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_562);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_563);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_564);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_565);
    
    //For Bug TDI-24105,support context variables
    if(fieldPartitions != null && !fieldPartitions.isEmpty()) {
        String columnName = null;
        String columnValue = null;
        int count = 0 ;

    stringBuffer.append(TEXT_566);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_567);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_568);
    
        for(Map<String, String> line : fieldPartitions ) {// search in the configuration table
             columnName = line.get("COLUMN_NAME");
             columnValue = line.get("COLUMN_VALUE");
            if (columnName!=null && !"".equals(columnName)) {
                count++;

    stringBuffer.append(TEXT_569);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_570);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_571);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_572);
    
                   if (columnValue!=null && !"".equals(columnValue)) {

    stringBuffer.append(TEXT_573);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_574);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_575);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_576);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_577);
    stringBuffer.append(columnValue);
    stringBuffer.append(TEXT_578);
    
                }
                if(count < fieldPartitions.size()){

    stringBuffer.append(TEXT_579);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_580);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_581);
    
                }
            }
        }
    }

    stringBuffer.append(TEXT_582);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_583);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_584);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_585);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_586);
    

if(columnList != null && columnList.size()>0){
    if(("INSERT").equals(dataAction)){

    stringBuffer.append(TEXT_587);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_588);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_589);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_590);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_591);
    
        if (isLog4jEnabled) {
            
    stringBuffer.append(TEXT_592);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_593);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_594);
    
        }
        if (!hiveDistrib.useCloudLauncher()) {

    stringBuffer.append(TEXT_595);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_596);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_597);
    
        } else if(hiveDistrib.isExecutedThroughWebHCat()) {

    stringBuffer.append(TEXT_598);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_599);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_600);
    
        } else { // dataproc
            
    stringBuffer.append(TEXT_601);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_602);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_603);
    
        }
    } else if (("OVERWRITE").equals(dataAction)){

    stringBuffer.append(TEXT_604);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_605);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_606);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_607);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_608);
    
        if (isLog4jEnabled) {
            
    stringBuffer.append(TEXT_609);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_610);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_611);
    
        }
        if (!hiveDistrib.useCloudLauncher()) {

    stringBuffer.append(TEXT_612);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_613);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_614);
    
        } else if(hiveDistrib.isExecutedThroughWebHCat()) {

    stringBuffer.append(TEXT_615);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_616);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_617);
    
        } else { // dataproc
            
    stringBuffer.append(TEXT_618);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_619);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_620);
    
        }
    }
}

// END

    boolean useExistingConn = ("true").equals(ElementParameterParser.getValue(previousNode, "__USE_EXISTING_CONNECTION__"));

    if(!hiveDistrib.useCloudLauncher()) {

    stringBuffer.append(TEXT_621);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_622);
    
if(!useExistingConn) {
    
    stringBuffer.append(TEXT_623);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_624);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_625);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_626);
    
}

    stringBuffer.append(TEXT_627);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_628);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_629);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_630);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_631);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_632);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_633);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_634);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_635);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_636);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_637);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_638);
    
    } else if(hiveDistrib.isExecutedThroughWebHCat()) {
        
    stringBuffer.append(TEXT_639);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_640);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_641);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_642);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_643);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_644);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_645);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_646);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_647);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_648);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_649);
    
    } else { // dataproc
        
    stringBuffer.append(TEXT_650);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_651);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_652);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_653);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_654);
    
    }

    stringBuffer.append(TEXT_655);
    return stringBuffer.toString();
  }
}
