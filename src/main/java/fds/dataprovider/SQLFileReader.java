package main.java.fds.dataprovider;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class SQLFileReader {
	private Properties SQLproperties;
	private final String sqlConnectionPath = "resources//sqlconnection.properties";

	public SQLFileReader() {
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(sqlConnectionPath));
			SQLproperties = new Properties();
			try {
				SQLproperties.load(reader);
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("SQLConnection.properties not found at " + sqlConnectionPath);
		}
	}

	public String getQueryString(String tag) {
		String sqlquery = SQLproperties.getProperty(tag);
		if (sqlquery != null)
			return sqlquery;
		else
			throw new RuntimeException("sqlquery not specified in the SQLConnection.properties file.");
	}
}
