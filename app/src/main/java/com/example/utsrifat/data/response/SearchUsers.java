package com.example.utsrifat.data.response;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class SearchUsers{
	@SerializedName("items")
	private List<Users> users;

	public List<Users> getUsers(){
		return users;
	}
}