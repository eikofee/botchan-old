package com.botchan.commands;

import com.botchan.*;
import sx.blah.discord.handle.impl.events.MessageReceivedEvent;

public class HelloWorld implements ICommand{

	@Override
	public void Run(BotchanEvent event) {
		event.getModule().Say("Hello World!", event.getEvent(), TLModule.SayMode.no_nat);
	}
}
