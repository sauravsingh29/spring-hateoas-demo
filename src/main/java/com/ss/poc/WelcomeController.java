package com.ss.poc;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {

	private static final String TEMPLATE = "Hello, %s!";

	@RequestMapping("/welcome")
	public HttpEntity<Welcome> welcomeUser(
			@RequestParam(value = "name", required = false, defaultValue = "Guest") String name) {
		Welcome welcome = new Welcome(String.format(TEMPLATE, name));
		welcome.add(linkTo(methodOn(WelcomeController.class).welcomeUser(name)).withSelfRel());
		return new ResponseEntity<Welcome>(welcome, HttpStatus.OK);
	}

}
