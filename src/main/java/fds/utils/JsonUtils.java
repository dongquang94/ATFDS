package main.java.fds.utils;

import org.json.JSONArray;
import org.json.JSONObject;
import java.sql.ResultSet;

public class JsonUtils {
	
	private static String testDataJsonString;
	public static String convertToJSONString(ResultSet resultSet)throws Exception {
		JSONArray jsonArray = new JSONArray();
		while (resultSet.next()) {
			JSONObject obj = new JSONObject();
			int total_rows = resultSet.getMetaData().getColumnCount();
			for (int i = 0; i < total_rows; i++) {
				obj.put(resultSet.getMetaData().getColumnLabel(i + 1).toLowerCase(), resultSet.getObject(i + 1));
				}
			jsonArray.put(obj);
			}
		return testDataJsonString = jsonArray.toString();
	}

	public static String getTestDataJson() {
		return testDataJsonString;
	}
}
