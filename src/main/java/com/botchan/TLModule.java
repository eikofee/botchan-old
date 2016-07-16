package com.botchan;

import sx.blah.discord.api.events.Event;import sx.blah.discord.handle.impl.events.MessageReceivedEvent;

public class TLModule implements ITLModule{
	private SynonymDictionary synonymDictionary;
	private TLLinkDictionary linkDictionary;

	public TLModule(){
		this.synonymDictionary = new SynonymDictionary();
		this.linkDictionary = new TLLinkDictionary();
	}

	public void AddLink(String pattern, ICommand command) {
		linkDictionary.AddCommand(pattern, command);
	}

	public void AddLink(String pattern, IScenario scenario) {
		linkDictionary.AddScenario(pattern, scenario);
	}

	public void Interpret(String pattern, EventHandler eh, MessageReceivedEvent event){
		String[] p = pattern.split("[ -]");
		for (int i = 0; i < p.length; i++){
			p[i] = synonymDictionary.GetMeaningOf(p[i]);
		}
		TLScenario s = null;
		TLCommand c = linkDictionary.GetMatchCommand(p);
		if (c == null)
			s = linkDictionary.GetMatchScenario(p);
		else
			c.getCommand().Run(eh, event);
	}
}
