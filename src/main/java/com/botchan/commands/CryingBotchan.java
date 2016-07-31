package com.botchan.commands;

import com.botchan.BotchanEvent;
import com.botchan.ICommand;
import com.botchan.TLModule;
import sx.blah.discord.handle.impl.events.MessageReceivedEvent;

public class CryingBotchan implements ICommand {
	@Override
	public void Run(BotchanEvent event) {
		event.getModule().Say(":cry:", event.getEvent(), TLModule.SayMode.no_nat);
	}
}
