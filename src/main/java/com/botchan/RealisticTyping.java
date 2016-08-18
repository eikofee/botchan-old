package com.botchan;

import sx.blah.discord.api.IDiscordClient;

public class RealisticTyping {

	private IDiscordClient client;
	private static float charactersPerMinutes = 330;
	
	public RealisticTyping(IDiscordClient client) {
		this.client = client;
	}
	
	public void toggleTypingStatus(String ChannelID, String message)
	{
		float charactersPerMiliseconds = (RealisticTyping.charactersPerMinutes/60)/1000;
	    this.client.getChannelByID(ChannelID).toggleTypingStatus();
	    try {
			Thread.sleep((int)(message.length()/charactersPerMiliseconds));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	    this.client.getChannelByID(ChannelID).toggleTypingStatus();
	}
	
}
