package com.ada.demo.api.actions;

import com.ada.demo.dataobjects.User;
import com.ada.demo.utils.FakerUtils;

public class DummyClass {
	public static void main(String[] args){
		String username = "demouser" + new FakerUtils().generateRandomNumber();
		User user = new User()
				.setUsername(username)
				.setPassword("demopwd")
				.setEmail(username+"@demo.com");
		SignUpApi signUpApi = new SignUpApi();
//		System.out.println(signUpApi.register(user));
		System.out.println(signUpApi.getAccount());
		System.out.println(signUpApi.getCookies());
	}
}
