package com.botchan;

import sx.blah.discord.handle.impl.events.MessageReceivedEvent;

public interface ICommand {

	void Run(TLModule tlm, MessageReceivedEvent event);
}
