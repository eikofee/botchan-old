package com.botchan;

import sx.blah.discord.handle.impl.events.MessageReceivedEvent;

public class TLModule implements ITLModule{
	public SynonymDictionary synonymDictionary;
	private TLLinkDictionary linkDictionary;

	public TLModule(){
		try {
			this.synonymDictionary = new SynonymDictionary("synonyms.txt");
		}catch (Exception e) {
			e.printStackTrace();
			this.synonymDictionary = new SynonymDictionary();
		}

			this.linkDictionary = new TLLinkDictionary();
	}

	public void AddLink(String pattern, ICommand command) {
		linkDictionary.AddCommand(pattern, command);
	}

	public void Interpret(String pattern, EventHandler eh, MessageReceivedEvent event){
		String[] p = pattern.split("[ -]");
		for (int i = 0; i < p.length; i++){
			p[i] = synonymDictionary.GetMeaningOf(p[i]);
		}
		TLCommand c = linkDictionary.GetMatchCommand(p);
		if (c != null)
			c.getCommand().Run(eh, event);
	}
}
