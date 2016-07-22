package com.botchan;

public class TLCommand {
	private String[] pattern;

	private ICommand command;

	private int absoluteLength;

	public TLCommand(String pattern, ICommand command) {
		this.setPattern(pattern.split("[ -]"));
		this.setCommand(command);
		String[] a = pattern.split("[ -]");
		this.absoluteLength = 0;
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
}
