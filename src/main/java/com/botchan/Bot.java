package com.botchan;

import java.io.BufferedReader;
import java.io.FileReader;

import sx.blah.discord.api.ClientBuilder;
import sx.blah.discord.api.IDiscordClient;
import sx.blah.discord.util.DiscordException;
import sx.blah.discord.util.HTTP429Exception;

@SuppressWarnings("deprecation")
public class Bot {
	
	private String token;
	private static IDiscordClient client;
	private QuoteRecord quoteRec;
	private EventHandler eventHandler;

	public Bot() {
		this.eventHandler = new EventHandler(this);
		this.quoteRec = new QuoteRecord(eventHandler);
	}
	
	public void login() throws Exception {
		BufferedReader br = new BufferedReader(new FileReader("token.txt"));
        try {
            this.token = br.readLine();
            br.close();
        } catch (Exception e) {
            throw new Exception("Token File not found");
        }
		try {
			client = new ClientBuilder().withToken(this.token).login();
	        client.getDispatcher().registerListener(eventHandler);
		} catch (DiscordException e) {
			e.printStackTrace();
		}
	}
	
	public IDiscordClient getClient() {
		return Bot.client;
	}
	
	public QuoteRecord getQuoteRecord() {
		return this.quoteRec;
	}
	
	/* _____________________________________________
					Bot settings
	   _____________________________________________*/
	
	public void changeBotUsername(String name) throws DiscordException, HTTP429Exception {
	    client.changeUsername(name);
	}
}
