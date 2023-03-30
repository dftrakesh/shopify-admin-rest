package com.dft.api.shopify.model;

import com.dft.api.shopify.mappers.DateDeserializer;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
public class ShopifyTheme {
	
	@XmlElement(name = "id")
	private String id;
    
	@XmlElement(name = "name")
	private String name;
    
	@XmlElement(name = "created_at")
	@JsonDeserialize(using = DateDeserializer.class)
	public LocalDateTime createdAt;
    
	@XmlElement(name = "updated_at")
	@JsonDeserialize(using = DateDeserializer.class)
	public LocalDateTime  updatedAt;
    
	@XmlElement(name = "role")
	private String role;
    
	@XmlElement(name = "theme_store_id")
	private int themeStoreId;
    
	@XmlElement(name = "previewable")
	private boolean previewable;
    
	@XmlElement(name = "processing")
	private boolean processing;
    
	@XmlElement(name = "admin_graphql_api_id")
	private String adminGraphqlApiId;

}
