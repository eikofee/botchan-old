package com.botchan;

import sx.blah.discord.handle.impl.events.MessageReceivedEvent;

public class BotchanEvent {
	private TLModule module;
	private MessageReceivedEvent event;

	public TLModule getModule() {
		return module;
	}

	public void setModule(TLModule module) {
		this.module = module;
	}

	public MessageReceivedEvent getEvent() {
		return event;
	}

	public void setEvent(MessageReceivedEvent event) {
		this.event = event;
	}

	public String[] getArguments() {
		return arguments;
	}

	public void setArguments(String[] arguments) {
		this.arguments = arguments;
	}

	private String[] arguments;
}
