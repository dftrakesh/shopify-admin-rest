package com.dft.api.shopify.model.collection.smart;

import com.dft.api.shopify.mappers.DateDeserializer;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.time.LocalDateTime;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class SmartCollectionImage {

	@XmlElement(name = "created_at")
	@JsonDeserialize(using = DateDeserializer.class)
	public LocalDateTime createdAt;
	
	@XmlElement(name = "alt")
	private String alt;
	
	@XmlElement(name = "src")
	private String source;
	
	@XmlElement(name = "attachment")
	private String attachment;
	
}
