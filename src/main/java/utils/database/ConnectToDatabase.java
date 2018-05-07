package main.java.utils.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import main.java.fds.managers.FileReaderManager;
import main.java.fds.utils.JsonUtils;

public class ConnectToDatabase {

	public static Connection conn = null;
	public static Statement stmt = null;
	public static ResultSet resultSet = null;

	public void SetUpConnection() throws SQLException, ClassNotFoundException {
		Class.forName(FileReaderManager.getInstance().getConfigReader().getJDBCType());
		conn = DriverManager.getConnection(FileReaderManager.getInstance().getConfigReader().getJDBCConnection(),
				FileReaderManager.getInstance().getConfigReader().getDBUser(),
				FileReaderManager.getInstance().getConfigReader().getDBPassword());
	}

	public void PrepareTestData(String sqlQuery) {
		try {
			stmt = conn.createStatement();
			resultSet = stmt.executeQuery(sqlQuery);
			JsonUtils.convertToJSONString(resultSet);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void CloseTheConnection() throws SQLException {

		if (resultSet != null) {
			try {
				resultSet.close();
			} catch (Exception e) {
			}
		}

		if (stmt != null) {
			try {
				stmt.close();
			} catch (Exception e) {
			}
		}

		if (conn != null) {
			try {
				conn.close();
			} catch (Exception e) {
			}
		}
	}
}
