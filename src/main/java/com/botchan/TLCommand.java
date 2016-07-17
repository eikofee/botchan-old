package com.botchan;

public class TLCommand {
	private String[] pattern;

	private ICommand command;

	private int indexScan;

	public int getIndexScan() {
		return indexScan % pattern.length;
	}

	public void incrIndexScan(){
		this.indexScan++;
	}

	public void resetIndex(){
		indexScan = 0;
	}

	public TLCommand(String pattern, ICommand command) {
		this.setPattern(pattern.split("[ -]"));
		this.setCommand(command);
		this.indexScan = 0;
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
