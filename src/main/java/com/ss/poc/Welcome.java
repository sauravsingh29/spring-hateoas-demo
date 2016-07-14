package com.ss.poc;

import org.springframework.hateoas.ResourceSupport;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Welcome extends ResourceSupport {
	
	private final String user;

	public Welcome(@JsonProperty("user") String user) {
		this.user = user;
	}

	public String getUser() {
		return user;
	}
}
