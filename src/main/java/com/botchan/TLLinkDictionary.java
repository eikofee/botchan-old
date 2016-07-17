package com.botchan;

import java.util.LinkedList;
import java.util.List;

public class TLLinkDictionary {
	private LinkedList<TLCommand> commands;
	private LinkedList<TLScenario> scenarios;

	public TLLinkDictionary() {
		commands = new LinkedList<>();
		scenarios = new LinkedList<>();
	}

	public void AddCommand(String pattern, ICommand command){
		commands.add(new TLCommand(pattern, command));
	}

	public void AddScenario(String pattern, IScenario scenario)
	{
		scenarios.add(new TLScenario(pattern, scenario));
	}

	public TLCommand GetMatchCommand(String[] p) {
		return	GetMatchCommand(p, 0, commands);
	}

//	public TLScenario GetMatchScenario(String[] p) {
//		return	GetMatchScenario(p, 0, scenarios);
//	}

	private TLCommand GetMatchCommand(String[] p, int index, List<TLCommand> l){
		if (p.length == index)
			for (int i = 0; i < l.size(); i++)
			{
				boolean b = true;
				TLCommand command = l.get(i);
				for (int j = index; j < command.getPattern().length && b ; j++)
				{
					String s = command.getPattern()[command.getIndexScan()];
					command.incrIndexScan();
					b = b && s.charAt(0) == '.';
				}
				if (b)
					return l.get(0);
			}
		LinkedList<TLCommand> c = new LinkedList<>();
		for (int i = 0; i < l.size(); i++){
			TLCommand command = l.get(i);
			if (command.getPattern()[command.getIndexScan()].charAt(0) == '.')
			{
				String s = command.getPattern()[command.getIndexScan()];
				while (s.charAt(0) == '.' && ! s.equals(p[index]))
				{
					command.incrIndexScan();
					s = command.getPattern()[command.getIndexScan()];
				}
			}
			if (p[index].equals(command.getPattern()[command.getIndexScan()])){
				c.add(command);
				command.incrIndexScan();
			}
		}
		if (c.size() < 1)
			return null;
		return GetMatchCommand(p, index + 1, c);
	}

//	private TLScenario GetMatchScenario(String[] p, int index, List<TLScenario> l){
//		if (p.length == index)
//			return l.get(0);
//		LinkedList<TLScenario> c = new LinkedList<>();
//		for (int i = 0; i < l.size(); i++){
//			if (p[0].equals(l.get(i).getPattern()[0])){
//				c.add(l.get(i));
//			}
//		}
//		if (c.size() < 1)
//			return null;
//		return GetMatchScenario(p, index + 1, c);
//	}
}
