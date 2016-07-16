package com.darichey.EngBot;

import sx.blah.discord.api.events.EventSubscriber;
import sx.blah.discord.handle.impl.events.MessageReceivedEvent;
import sx.blah.discord.handle.impl.events.ReadyEvent;
import sx.blah.discord.util.DiscordException;
import sx.blah.discord.util.MessageBuilder;
import sx.blah.discord.util.MissingPermissionsException;
import sx.blah.discord.util.RateLimitException;

public class EventHandler {
	
	private Bot bot;
	private MessageBuilder messageBuilder;
	
	public EventHandler(Bot bot) {
		this.bot = bot;
		this.messageBuilder = new MessageBuilder(bot.getClient());
	}
	
	@EventSubscriber
	public void onReadyEvent(ReadyEvent event) {
	
	}
	
	@EventSubscriber
	public void onMessageEvent(MessageReceivedEvent event) {
		String messageSent = event.getMessage().getContent();
		if (messageSent.equals("Check.")) {
			sendMessage("ok", event);
		}
	}
	
	public void sendMessage(String message, MessageReceivedEvent event) {
		try {
			messageBuilder.withChannel(event.getMessage().getChannel()).withContent(message).build();
		} catch (RateLimitException e) {
			e.printStackTrace();
		} catch (DiscordException e) {
			e.printStackTrace();
		} catch (MissingPermissionsException e) {
			e.printStackTrace();
		}
	}
}