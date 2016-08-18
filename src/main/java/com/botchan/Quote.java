package com.botchan;

import java.io.Serializable;

public class Quote implements Serializable {

	private static final long serialVersionUID = -3184609232313021599L;
	private String author;
	private String quote;
	
	public Quote(String author, String quote) {
		this.author = author;
		this.quote = quote;
	}

	public String getAuthor() {
		return author;
	}

	public String getQuote() {
		return quote;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public void setQuote(String quote) {
		this.quote = quote;
	}
	
}
