package com.quotehouse.quote.domain;

import java.util.HashSet;
import java.util.Set;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "quotes")
public class Quote {
	@Id
	private String id;
	private String author;
//	@NotEmpty(message = "Please add a quote")
	private String quote;
	private Set<String> tags;

	public Quote() {
		this.tags = new HashSet<>();
	}

	public Quote(QuoteBuilder quoteBuilder) {
		this.author = quoteBuilder.author;
		this.quote = quoteBuilder.quote;
		this.tags = quoteBuilder.tags;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getQuote() {
		return quote;
	}

	public void setQuote(String quote) {
		this.quote = quote;
	}

	public Set<String> getTags() {
		return tags;
	}

	public void setTags(Set<String> tags) {
		this.tags = tags;
	}
	
	public static class QuoteBuilder {
		private String author;
		private String quote;
		private Set<String> tags;
		
		public QuoteBuilder author(String author) {
			this.author = author;
			return this;
		}
		
		public QuoteBuilder quote(String quote) {
			this.quote = quote;
			return this;
		}
		
		public QuoteBuilder tags(Set<String> tags) {
			this.tags = tags;
			return this;
		}
		
		public Quote build() {
			return new Quote(this);
		}
	}

	@Override
	public String toString() {
		return "Quote [id=" + id + ", author=" + author + ", quote=" + quote + ", tags=" + tags + "]";
	}

}
