package com.assess.tinyurl.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "urldb")
@Entity
public class URLEntity {

	@Id
	@GeneratedValue
	private int id;

	private String primary_url;

	private String short_url;

	@Override
	public String toString() {
		return "URLEntity [id=" + id + ", primary_url=" + primary_url + ", short_url=" + short_url + "]";
	}

	public int getId() {
		return id;
	}
	
	public URLEntity() {}

	public URLEntity(String primary_url, String short_url) {
		super();
		this.primary_url = primary_url;
		this.short_url = short_url;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPrimary_url() {
		return primary_url;
	}

	public void setPrimary_url(String primary_url) {
		this.primary_url = primary_url;
	}

	public String getShort_url() {
		return short_url;
	}

	public void setShort_url(String short_url) {
		this.short_url = short_url;
	}

}
