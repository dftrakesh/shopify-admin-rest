package com.dft.api.shopify.model.collection.smart;

import java.util.LinkedList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import com.dft.api.shopify.model.ShopifyCollectionImage;
import com.dft.api.shopify.model.ShopifyRule;
import com.dft.api.shopify.model.adapters.DateTimeAdapter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.joda.time.DateTime;

import lombok.Data;

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
	@XmlJavaTypeAdapter(DateTimeAdapter.class)
	private DateTime publishedAt;

	@XmlElement(name = "updated_at")
	@XmlJavaTypeAdapter(DateTimeAdapter.class)
	private DateTime updatedAt;
	
	private boolean disjunctive;
	
	@XmlElement(name = "rules")
    private List<ShopifyRule> rules = new LinkedList<>();
    
   }
