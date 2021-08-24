package com.assess.tinyurl.controller;

import org.apache.commons.validator.routines.UrlValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity.BodyBuilder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.assess.tinyurl.business.TinyUrlService;
import com.assess.tinyurl.exception.TinyUrlError;
import com.assess.tinyurl.model.UrlDTO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping(value = "/rest/url")
public class TinyUrlController {

	@Autowired
	TinyUrlService tinyURLService;

	@PostMapping
	public ResponseEntity create(@RequestBody final String url) {

		final UrlValidator urlValidator = new UrlValidator(new String[] { "http", "https" });
		if (!urlValidator.isValid(url)) {
			return ResponseEntity.badRequest().body(new TinyUrlError("Invalid URL."));
		}
		return ResponseEntity.ok(tinyURLService.generateShortUrl(url).getUrl());
	}
}
