package com.example.utsrifat.data.response;

import com.google.gson.annotations.SerializedName;

public class Users{

	@SerializedName("avatar_url")
	private String avatarUrl;

	@SerializedName("name")
	private String name;

	@SerializedName("bio")
	private String bio;

	@SerializedName("login")
	private String username;

	public String getAvatarUrl(){
		return avatarUrl;
	}

	public String getName(){
		return name;
	}

	public String getBio(){
		return bio;
	}

	public String getUsername(){
		return username;
	}
}