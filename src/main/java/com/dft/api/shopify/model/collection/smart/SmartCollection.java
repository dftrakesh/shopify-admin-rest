package com.dft.api.shopify.model.collection.smart;

import com.dft.api.shopify.mappers.DateDeserializer;
import com.dft.api.shopify.model.ShopifyRule;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class SmartCollection {

	private String id;
	private String title;
	private String handle;
	private boolean published;

	@XmlElement(name = "body_html")
	private String bodyHtml;

	@XmlElement(name = "published_scope")
	private String publishedScope;

	@XmlElement(name = "sort_order")
	private String sortOrder;

	@XmlElement(name = "template_suffix")
	private String templateSuffix;

	@XmlElement(name = "published_at")
	@JsonDeserialize(using = DateDeserializer.class)
	public LocalDateTime  publishedAt;

	@XmlElement(name = "updated_at")
	@JsonDeserialize(using = DateDeserializer.class)
	public LocalDateTime updatedAt;
	
	private boolean disjunctive;
	
	@XmlElement(name = "rules")
    private List<ShopifyRule> rules = new LinkedList<>();
    
   }
