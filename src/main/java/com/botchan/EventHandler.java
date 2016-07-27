package com.botchan;

import com.botchan.commands.CryingBotchan;
import com.botchan.commands.DanbooruQuery;
import com.botchan.commands.HelloWorld;
import com.botchan.commands.RandomYesNoAnswer;
import sx.blah.discord.api.events.*;
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
		module.AddLink("_greeting _botchan_name", new HelloWorld());
		module.AddLink("_yes_no_question_mark _botchan_name ?", new RandomYesNoAnswer());
		module.AddLink("fuck you _botchan_name", new CryingBotchan());
		module.AddLink("db 2298456", new DanbooruQuery());
	}
	
	@EventSubscriber
	public void onMessageEvent(MessageReceivedEvent event) {
		String messageSent = event.getMessage().getContent();
		module.Interpret(messageSent, this, event);
		if (messageSent.equals("Check.")) {
			sendMessage("ok", event);
		}
		if (messageSent.equals("getSyn")){
			sendMessage(module.synonymDictionary.GetSynonymOf("_greeting"),event);
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