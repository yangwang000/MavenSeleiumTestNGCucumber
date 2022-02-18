package com.ada.demo.api.actions;

import com.ada.demo.api.ApiRequest;
import com.ada.demo.dataObjects.User;
import io.restassured.http.Cookies;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class SignUpApi {
	private Cookies cookies;

	public Cookies getCookies(){
		return cookies;
	}

	public Response getAccount(){
		cookies = new Cookies();
//		Response response = given().
//				        baseUri(ConfigLoader.getInstance().getBaseUrl()).
//				        cookies(getCookies()).
//				        log().all().
//				when().
//						get("/account").
//				then().
//				        log().all().
//						extract().response();

		Response response = ApiRequest.get("/account", getCookies());

		if(response.getStatusCode() != 200){
			throw new RuntimeException("Failed to fetch the account, HTTP Status Code: " + response.getStatusCode());
		}
		return response;
	}

	public String fetchRegisterNonceValueUsingGroovy(){
		Response response = getAccount();
		return response.htmlPath().getString("**.findAll { it.@name == 'woocommerce-register-nonce' }.@value");
	}

	public String fetchRegisterNonceValueUsingJsoup(){
		Response response = getAccount();
		Document doc = Jsoup.parse(response.body().prettyPrint());
		Element element = doc.selectFirst("#woocommerce-register-nonce");
		return element.attr("value");
	}

	public Response register(User user){
		Cookies cookies = new Cookies();
		Header header = new Header("content-type", "application/x-www-form-urlencoded");
		Headers headers = new Headers(header);
		HashMap<String, Object> formParams = new HashMap<>();
		formParams.put("username", user.getUsername());
		formParams.put("email", user.getEmail());
		formParams.put("password", user.getPassword());
		formParams.put("woocommerce-register-nonce", fetchRegisterNonceValueUsingJsoup());
		formParams.put("register", "Register");

//		Response response = given().
//				baseUri(ConfigLoader.getInstance().getBaseUrl()).
//				headers(headers).
//				formParams(formParams).
//				cookies(cookies).
//				log().all().
//				when().
//				post("/account").
//				then().
//				log().all().
//				extract().
//				response();
		Response response = ApiRequest.post("/account", headers, formParams, cookies);
		if(response.getStatusCode() != 302){
			throw new RuntimeException("Failed to register the account, HTTP Status Code: " + response.getStatusCode());
		}
		this.cookies = response.getDetailedCookies();
		return response;
	}
}
