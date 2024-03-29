package com.botchan;

import sx.blah.discord.handle.impl.events.MessageReceivedEvent;

public class TLModule implements ITLModule {
	public SynonymDictionary synonymDictionary;
	private TLLinkDictionary linkDictionary;
	private EventHandler eh;

	public TLModule(EventHandler parent) {
		this.eh = parent;
		try {
			this.synonymDictionary = new SynonymDictionary("synonyms.txt");
		} catch (Exception e) {
			e.printStackTrace();
			this.synonymDictionary = new SynonymDictionary();
		}

		this.linkDictionary = new TLLinkDictionary();
	}

	public void AddLink(String pattern, ICommand command) {
		linkDictionary.AddCommand(pattern, command);
	}

	public void Interpret(String pattern, EventHandler eh, MessageReceivedEvent event) {
		linkDictionary.ResetIndexes();
		pattern = synonymDictionary.FindComplexPatterns(pattern);
		String[] p = pattern.split("[, -]");
		for (int i = 0; i < p.length; i++) {
			p[i] = synonymDictionary.GetMeaningOf(p[i]);
		}
		TLCommand c = linkDictionary.GetMatchCommand(p);
		if (c != null) {
			BotchanEvent bevent = new BotchanEvent();
			bevent.setEvent(event);
			bevent.setModule(this);
			c.getCommand().Run(bevent);
		}
	}

	public void Say(String pattern, MessageReceivedEvent event, SayMode mode) {
		String answer = pattern;
		if (mode == SayMode.simple_nat)
			answer = synonymDictionary.Naturalize(pattern);
		if (mode == SayMode.complex_nat)
			answer = synonymDictionary.NaturalizeUsingComplexes(pattern);
		if (mode != SayMode.no_nat) {
			char c = Character.toUpperCase(answer.charAt(0));
			StringBuilder b = new StringBuilder(answer);
			b.setCharAt(0, c);
			eh.sendMessage(b.toString(), event, false);
		} else {
			eh.sendMessage(pattern, event, false);
		}
	}


	public enum SayMode{
		no_nat,
		simple_nat,
		complex_nat
	}
}
