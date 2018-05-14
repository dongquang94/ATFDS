package main.java.fds.bean;

import java.util.HashMap;
import java.util.Map;

public class User {

	public int id;
	public String username;
	public String password;
	public String fullname;
	public String file_upload;
	public Map<String, Object> additionalProperties = new HashMap<String, Object>();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getFullName() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	
	public String getFileUpload() {
		return file_upload;
	}

	public void setFileUpload(String file_upload) {
		this.file_upload = file_upload;
	}

	public Map<String, Object> getAdditionalProperties() {
		return this.additionalProperties;
	}

	public void setAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
	}

}