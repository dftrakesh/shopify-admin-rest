package com.dft.api.shopify.model;

import com.dft.api.shopify.mappers.DateDeserializer;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.time.LocalDateTime;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@Data @NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class ShopifyScriptTag {
	
	@XmlElement(name = "id")
	@JsonProperty("id")
	private String id;

	@XmlElement(name = "src")
	@JsonProperty("src")
	private String src;

	@XmlElement(name = "event")
	@JsonProperty("event")
	private String event;
	
	@XmlElement(name = "created_at")
	@JsonProperty("created_at")
	@JsonDeserialize(using = DateDeserializer.class)
	public LocalDateTime createdAt;

	@XmlElement(name = "updated_at")
	@JsonProperty("updated_at")
	@JsonDeserialize(using = DateDeserializer.class)
	public LocalDateTime  updatedAt;
	
	@XmlElement(name = "display_scope")
	@JsonProperty("display_scope")
	private String displayScope;

	public ShopifyScriptTag(String src, String event, String displayScope) {
		this.src = src;
		this.event = event;
		this.displayScope = displayScope;
	}

}
