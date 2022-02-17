package com.ada.api.actions;

import com.ada.utils.ConfigLoader;
import io.restassured.http.Cookies;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class SingUpApi {
	private Cookies cookies;

	public Cookies getCookies(){
		return cookies;
	}

	public Response getAccount(){
		cookies = new Cookies();
		Response response = given().
				        baseUri(ConfigLoader.getInstance().getBaseUrl()).
				        cookies(getCookies()).
				        log().all().
				when().
						get("/account").
				then().
				        log().all().
						extract().response();

		if(response.getStatusCode() != 200){
			throw new RuntimeException("Failed to fetch the account, HTTP Status Code: " + response.getStatusCode());
		}
		return response;
	}
}
