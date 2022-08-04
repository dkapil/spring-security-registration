package com.baeldung.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.security.access.event.AuthorizationFailureEvent;
import org.springframework.security.web.FilterInvocation;
import org.springframework.stereotype.Component;

import com.baeldung.persistence.model.User;

@Component
public class AuthorizationFailureEventListener implements ApplicationListener<AuthorizationFailureEvent> {

	private static final Logger LOG = LoggerFactory.getLogger(AuthorizationFailureEventListener.class);

	@Override
	public void onApplicationEvent(final AuthorizationFailureEvent e) {

		LOG.info("User {} attempted to access unauthorized URL {}",
				((User) e.getAuthentication().getPrincipal()).getFirstName(),
				((FilterInvocation) e.getSource()).getRequestUrl());
	}
}