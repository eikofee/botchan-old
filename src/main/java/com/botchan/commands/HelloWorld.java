package com.botchan.commands;

import com.botchan.*;
import sx.blah.discord.handle.impl.events.MessageReceivedEvent;

public class HelloWorld implements ICommand{

	@Override
	public void Run(TLModule tlm, MessageReceivedEvent event) {
		tlm.Say("Hello World!", event);
	}
}
