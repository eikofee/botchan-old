package com.botchan;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.util.ArrayList;

import sx.blah.discord.handle.impl.events.MessageReceivedEvent;

public class QuoteRecord {
	
	private final static String path = "quotes.txt";
	private ArrayList<Quote> quotes;
	private EventHandler eventHandler;
	
	public QuoteRecord(EventHandler eventHandler) {
		this.quotes = new ArrayList<Quote>();
		this.loadQuotes();
		this.eventHandler = eventHandler;
	}
	
	public void loadQuotes() {
		String line;
		String author = "";
		String quote = "";
		String[] splitting;
		try (
		    InputStream fis = new FileInputStream(path);
		    InputStreamReader isr = new InputStreamReader(fis, Charset.forName("UTF-8"));
		    BufferedReader br = new BufferedReader(isr);
		) {
		    while ((line = br.readLine()) != null) {
		    	splitting = line.split(" - ");
		    	author = splitting[1];
		    	quote = splitting[0];
		        quotes.add(new Quote(author, quote));
		    }
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void record(String author, String quote) {
		this.quotes.add(new Quote(author, quote));
		try(FileWriter fw = new FileWriter(path, true);
			BufferedWriter bw = new BufferedWriter(fw);
			PrintWriter out = new PrintWriter(bw)) {
			out.println("\""+quote.replace("\n", " ").replace("\"", "''")+"\""+" - "+author);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void randomQuote(MessageReceivedEvent event) {
		int index = (int)(Math.random()*quotes.size());
		eventHandler.sendMessage(quotes.get(index).getQuote()+" - "+quotes.get(index).getAuthor(), event);
	}
}
