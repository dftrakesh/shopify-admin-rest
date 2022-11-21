package com.dft.api.shopify.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import com.dft.api.shopify.model.adapters.DateTimeAdapter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.joda.time.DateTime;

import lombok.Data;
import lombok.NoArgsConstructor;

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
	@XmlJavaTypeAdapter(DateTimeAdapter.class)
	private DateTime createdAt;
    
	@XmlElement(name = "updated_at")
	@XmlJavaTypeAdapter(DateTimeAdapter.class)
	private DateTime updatedAt;
    
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
