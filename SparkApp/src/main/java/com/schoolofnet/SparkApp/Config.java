package com.schoolofnet.SparkApp;

import spark.Spark;

public class Config {
	
	public static void setConfig() {
		Spark.port(8080);
		Spark.ipAddress("127.0.0.1");
		//src/main/resources/public
		Spark.staticFileLocation("/public");
	}
}
