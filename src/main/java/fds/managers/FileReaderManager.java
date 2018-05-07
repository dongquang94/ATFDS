package main.java.fds.managers;

import main.java.fds.dataprovider.JsonDataReader;
import main.java.fds.dataprovider.SQLFileReader;
import main.java.fds.dataprovider.ConfigFileReader;
import main.java.fds.managers.FileReaderManager;

public class FileReaderManager {
	private static FileReaderManager fileReaderManager = new FileReaderManager();
	private static ConfigFileReader configFileReader;
	private static JsonDataReader jsonDataReader;
	private static SQLFileReader sqlFileReader;
 
	private FileReaderManager() {
	}
 
	 public static FileReaderManager getInstance( ) {
	      return fileReaderManager;
	 }
 
	 public ConfigFileReader getConfigReader() {
		 return (configFileReader == null) ? new ConfigFileReader() : configFileReader;
	 }
	 
	 public JsonDataReader getJsonReader() throws Exception{
		 return (jsonDataReader == null) ? new JsonDataReader() : jsonDataReader;
	 }
	 
	 public SQLFileReader getSQLReader() throws Exception{
		 return (sqlFileReader == null) ? new SQLFileReader() : sqlFileReader;
	 }
}
