package com.assess.tinyurl.business;

import java.nio.charset.StandardCharsets;

import org.springframework.stereotype.Service;

import com.assess.tinyurl.model.UrlDTO;
import com.google.common.hash.Hashing;

@Service
public class TinyUrlService {
	
	public UrlDTO generateShortUrl(String url) {
		StringBuffer shortenedURL = new StringBuffer("http://www.turl.com/");
		url = Hashing.murmur3_32().hashString(url, StandardCharsets.UTF_8).toString();
		return new UrlDTO((shortenedURL.append(url).toString()));
	}

}
