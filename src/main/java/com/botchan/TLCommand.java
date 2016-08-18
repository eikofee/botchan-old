package com.botchan;

public class TLCommand {
	private String[] pattern;

	private ICommand command;

	private int absoluteLength;

	private int localIndex;

	public TLCommand(String pattern, ICommand command) {
		this.setPattern(pattern.split("[ -]"));
		this.setCommand(command);
		String[] a = pattern.split("[ -]");
		this.absoluteLength = 0;
		this.localIndex = 0;
		for (int i = 0; i < a.length; i++)
		{
			if (a[i].charAt(0) != '.')
				this.absoluteLength++;
		}
	}

	public String[] getPattern() {
		return pattern;
	}

	public void setPattern(String[] pattern) {
		this.pattern = pattern;
	}

	public ICommand getCommand() {
		return command;
	}

	public void setCommand(ICommand command) {
		this.command = command;
	}

	public int getAbsoluteLength() {
		return absoluteLength;
	}

	public int getLocalIndex() {
		return localIndex;
	}

	public void incrIndex()
	{
		this.localIndex++;
	}

	public void resetIndex() {this.localIndex = 0;}
}
