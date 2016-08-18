package com.botchan;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import sx.blah.discord.handle.impl.events.MessageReceivedEvent;

public class QuoteRecord {
	
	private final static String path = "quotes.pomf";
	private ArrayList<Quote> quotes;
	private EventHandler eventHandler;
	
	public QuoteRecord(EventHandler eventHandler) {
		this.quotes = new ArrayList<>();
		this.eventHandler = eventHandler;
	}
	
	public void record(String author, String quote) {
		this.quotes.add(new Quote(author, quote));
		serialize();
	}
	
	public void serialize() {
		try {
			FileOutputStream fout = new FileOutputStream(QuoteRecord.path);
			ObjectOutputStream oos = new ObjectOutputStream(fout);
			oos.writeObject(this.quotes);
			oos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@SuppressWarnings("unchecked")
	public void unserialize() {
		ArrayList<Quote> quotes = new ArrayList<>();
		try {
			FileInputStream fin = new FileInputStream(QuoteRecord.path);
			ObjectInputStream ois = new ObjectInputStream(fin);
			quotes = (ArrayList<Quote>) ois.readObject();
			ois.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		this.quotes = quotes;
	}
	
	public void randomQuote(MessageReceivedEvent event) {
		if (quotes != null) {
			this.unserialize();
			int index = (int)(Math.random()*quotes.size());
			eventHandler.sendMessage("\""+quotes.get(index).getQuote()+"\""+" - "+quotes.get(index).getAuthor(), event);
		}
		else {
			eventHandler.sendMessage("Il n'y pas de citations, désolé.", event);
		}
		
	}
}
