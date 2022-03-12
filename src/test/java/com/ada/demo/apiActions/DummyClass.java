package com.ada.demo.apiActions;

import com.ada.demo.dataObjects.User;
import com.ada.utils.FakerUtils;

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
