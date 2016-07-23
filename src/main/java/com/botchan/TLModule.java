package com.botchan;

import sx.blah.discord.handle.impl.events.MessageReceivedEvent;

public class TLModule implements ITLModule{
	public SynonymDictionary synonymDictionary;
	private TLLinkDictionary linkDictionary;
	private EventHandler eh;

	public TLModule(EventHandler parent){
		this.eh = parent;
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
		pattern = synonymDictionary.FindComplexPatterns(pattern);
		String[] p = pattern.split("[ -]");
		for (int i = 0; i < p.length; i++){
			p[i] = synonymDictionary.GetMeaningOf(p[i]);
		}
		TLCommand c = linkDictionary.GetMatchCommand(p);
		if (c != null)
			c.getCommand().Run(this, event);
	}
	public void Say(String pattern, MessageReceivedEvent event){
		String answer = synonymDictionary.Naturalize(pattern);
		eh.sendMessage(answer, event);
	}

}
