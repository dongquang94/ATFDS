package main.java.fds.dataprovider;

import java.util.Arrays;
import java.util.List;
import com.google.gson.Gson;

import main.java.fds.bean.User;
import main.java.fds.utils.JsonUtils;

public class JsonDataReader {
	private List<User> userList;

	public JsonDataReader() {
		userList = getUserData();
	}

	private List<User> getUserData() {
		Gson gson = new Gson();
		User[] user = gson.fromJson(JsonUtils.getTestDataJson(), User[].class);
		return Arrays.asList(user);
	}

	public final User getUserById(String id){
		for(User user : userList) {
			if(user.id == Integer.parseInt(id)) 
				return user;
		}
		return null;
	}
}