package com.botchan;

import java.util.LinkedList;
import java.util.List;

public class TLLinkDictionary {
	private LinkedList<TLCommand> commands;

	public TLLinkDictionary() {
		commands = new LinkedList<>();
	}

	public void AddCommand(String pattern, ICommand command){
		commands.add(new TLCommand(pattern, command));
	}

	public TLCommand GetMatchCommand(String[] p) {
		return	GetMatchCommand(p, 0, commands);
	}

	private TLCommand GetMatchCommand(String[] p, int index, List<TLCommand> l){
		if (p.length == index)
			for (int i = 0; i < l.size(); i++)
			{
				boolean b = true;
				for (int j = index; j < l.get(i).getPattern().length && b ; j++)
				{
					String s = l.get(i).getPattern()[j];
					b = b && s.charAt(0) == '.';
				}
				if (b)
					return l.get(0);
			}
		if (p[index].equals(""))
			return GetMatchCommand(p, index++, l);
		LinkedList<TLCommand> c = new LinkedList<>();
		for (int i = 0; i < l.size(); i++){
			TLCommand command = l.get(i);
			if (p[index].equals(command.getPattern()[command.getLocalIndex()]) || command.getPattern()[command.getLocalIndex()].equals("*")){
				c.add(command);
				command.incrIndex();
			}
			if (index > 0 && command.getPattern()[command.getLocalIndex() - 1].equals("*")){
				c.add(command);
			}
		}
		if (c.size() < 1)
			return null;
		return GetMatchCommand(p, index + 1, c);
	}

	public void ResetIndexes() {
		for (int i = 0; i < this.commands.size(); i++)
		{
			this.commands.get(i).resetIndex();
		}
	}
}
