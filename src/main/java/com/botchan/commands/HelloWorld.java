package com.botchan.commands;

import com.botchan.*;
import sx.blah.discord.handle.impl.events.MessageReceivedEvent;

public class HelloWorld implements ICommand{

	@Override
	public void Run(EventHandler eh, MessageReceivedEvent event) {
		eh.sendMessage("Hello World!", event);
	}
}
