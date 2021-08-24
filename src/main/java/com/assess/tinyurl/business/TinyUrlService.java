package com.assess.tinyurl.business;

import java.nio.charset.StandardCharsets;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assess.tinyurl.entity.URLEntity;
import com.assess.tinyurl.model.UrlDTO;
import com.google.common.hash.Hashing;

@Service
public class TinyUrlService {

	@Autowired
	TinyUrlDataStoreService tinyUrlDataStore;

	public UrlDTO generateShortUrl(String url) {
		URLEntity temp = tinyUrlDataStore.fetchShortURL(url);
		if (temp != null) {
			return new UrlDTO(temp.getShort_url());
		} else {
			StringBuffer shortenedURL = new StringBuffer("http://www.turl.com/");
			URLEntity tempEntity = new URLEntity(url, shortenedURL
					.append(Hashing.murmur3_32().hashString(url, StandardCharsets.UTF_8).toString()).toString());
			tinyUrlDataStore.save(tempEntity);
			return new UrlDTO((tempEntity.getShort_url()));
		}
	}

}
