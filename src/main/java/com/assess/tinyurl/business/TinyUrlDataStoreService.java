package com.assess.tinyurl.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assess.tinyurl.dao.URLRepository;
import com.assess.tinyurl.entity.URLEntity;

@Service
public class TinyUrlDataStoreService {

	@Autowired
	private URLRepository urlRepository;

	public URLEntity fetchShortURL(String primaryURL) {
		return urlRepository.findAll().stream().filter(url -> primaryURL.equals(url.getPrimary_url())).findAny()
				.orElse(null);
	}
	
	public void save(URLEntity urlEntity) {
		urlRepository.save(urlEntity);
	}
}
