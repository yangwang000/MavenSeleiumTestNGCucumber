package com.ada.utils;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;

public class JsonUtils {

	public static <T> T deserializeJson(String fileName, Class<T> T) throws IOException {
		InputStream is = JsonUtils.class.getClassLoader().getResourceAsStream(fileName);
		ObjectMapper objectMapper = new ObjectMapper();
		return objectMapper.readValue(is, T);
	}
}
