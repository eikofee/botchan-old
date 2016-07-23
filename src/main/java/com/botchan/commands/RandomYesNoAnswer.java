package com.botchan.commands;

import com.botchan.EventHandler;
import com.botchan.ICommand;
import com.botchan.TLModule;
import sx.blah.discord.handle.impl.events.MessageReceivedEvent;

public class RandomYesNoAnswer implements ICommand {
	public void Run(TLModule tlm, MessageReceivedEvent event) {
		String[] answers = new String[] {"_affirmative_answer", "_negative_answer", "_not_sure_answer"};
		int r =(int) Math.floor(Math.random() *10 ) % 3;
		tlm.Say(answers[r] + ".", event);
	}
}
