package com.dft.api.shopify.model.collection.smart;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import com.dft.api.shopify.model.adapters.DateTimeAdapter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.joda.time.DateTime;

import lombok.Data;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class SmartCollectionImage {

	@XmlElement(name = "created_at")
	@XmlJavaTypeAdapter(DateTimeAdapter.class)
	private DateTime createdAt;
	
	@XmlElement(name = "alt")
	private String alt;
	
	@XmlElement(name = "src")
	private String source;
	
	@XmlElement(name = "attachment")
	private String attachment;
	
}
