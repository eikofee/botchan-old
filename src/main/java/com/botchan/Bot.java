package com.botchan;

import java.io.BufferedReader;
import java.io.FileReader;

import com.botchan.reasoning.KnowledgeBase;
import com.botchan.reasoning.ReasonEngine;

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
	private RealisticTyping realtyping;
	private ReasonEngine reasonEngine;
	private KnowledgeBase knowledgeBase;

	public Bot() {
		this.eventHandler = new EventHandler(this);
		this.quoteRec = new QuoteRecord(eventHandler);
		this.reasonEngine = new ReasonEngine();
		this.knowledgeBase = new KnowledgeBase();
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
			this.realtyping = new RealisticTyping(client);
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
	
	public RealisticTyping getRealisticTyping() {
		return this.realtyping;
	}
	
	public KnowledgeBase getKnowledgeBase() {
		return this.knowledgeBase;
	}
	
	/* _____________________________________________
					Bot settings
	   _____________________________________________*/
	
	public void changeBotUsername(String name) throws DiscordException, HTTP429Exception {
	    client.changeUsername(name);
	}
}
