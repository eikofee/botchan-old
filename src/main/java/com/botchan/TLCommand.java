package com.botchan;

public class TLCommand {
	private String[] pattern;

	private ICommand command;


	public TLCommand(String pattern, ICommand command) {
		this.setPattern(pattern.split("[ -]"));
		this.setCommand(command);
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
}
