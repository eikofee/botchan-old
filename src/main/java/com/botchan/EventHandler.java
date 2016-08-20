package com.botchan;

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

	private TLModule module;

	public EventHandler(Bot bot) {
		this.bot = bot;
		this.messageBuilder = new MessageBuilder(bot.getClient());
	}
	
	@EventSubscriber
	public void onReadyEvent(ReadyEvent event) {
		module = new TLModule(this);
		CommandsHandler.Initialize(module);
	}
	
	@EventSubscriber
	public void onMessageEvent(MessageReceivedEvent event) {
		String messageSent = event.getMessage().getContent();
		module.Interpret(messageSent, this, event);
		if (messageSent.equals("Check.")) {
			sendMessage("ok", event, false);
		}
		if (messageSent.equals("getSyn")){
			sendMessage(module.synonymDictionary.GetSynonymOf("_greeting"), event, false);
		}
		// Zone de test radioactive pour flemmards (TEMPORAIRE)
		if (messageSent.equals("Botchan, affiche une citation")) {
			this.bot.getQuoteRecord().randomQuote(event);
		}
		String command = "Botchan, enregistre la citation suivante : ";
		if (messageSent.startsWith(command)) {
			this.bot.getQuoteRecord().record("Anonyme", messageSent.substring(command.length(), messageSent.length()));
			sendMessage("C'est fait.", event, false);
		}
	}
	
	public void sendMessage(String message, MessageReceivedEvent event, boolean instant) {
		try {
			if (!instant)
				this.bot.getRealisticTyping().toggleTypingStatus(event.getMessage().getChannel().getID(), message);
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