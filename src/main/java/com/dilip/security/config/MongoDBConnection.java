package com.dilip.security.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import com.mongodb.MongoClient;

@Configuration
public class MongoDBConnection {

	private static MongoClient client;

	@Value("${host.url}")
	private String hostUrl;

	@Value("${host.port}")
	private String hostPort;

	@Value("${database.name}")
	private String dbName;

	@Bean
	public MongoDbFactory mongoDbFactory() throws Exception {
		MongoClient mongoClient = new MongoClient(hostUrl, Integer.parseInt(hostPort));
		return new SimpleMongoDbFactory(mongoClient, dbName);
	}

	@Bean
	public MongoTemplate mongoTemplate() throws Exception {
		MongoTemplate mongoTemplate = new MongoTemplate(mongoDbFactory());
		return mongoTemplate;
	}

	public static MongoClient getMongConnection() {
		return client = new MongoClient("localhost", 27017);
	}
}