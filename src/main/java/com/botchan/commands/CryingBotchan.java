package com.botchan.commands;

import com.botchan.ICommand;
import com.botchan.TLModule;
import sx.blah.discord.handle.impl.events.MessageReceivedEvent;

public class CryingBotchan implements ICommand {
	@Override
	public void Run(TLModule tlm, MessageReceivedEvent event) {
		tlm.Say(":cry:", event, TLModule.SayMode.no_nat);
	}
}
