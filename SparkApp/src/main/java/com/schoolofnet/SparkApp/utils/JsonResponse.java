package com.schoolofnet.SparkApp.utils;

import com.google.gson.Gson;

import spark.ResponseTransformer;

public class JsonResponse implements ResponseTransformer {

	private Gson gson = new Gson(); 
	
	@Override
	public String render(Object obj) throws Exception {
		return gson.toJson(obj);
	}

}
