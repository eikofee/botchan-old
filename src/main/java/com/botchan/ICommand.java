package com.botchan;

import sx.blah.discord.handle.impl.events.MessageReceivedEvent;

public interface ICommand {

	void Run(EventHandler eh, MessageReceivedEvent event);
}
