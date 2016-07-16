package com.botchan;

public class TLScenario {
	private String[] pattern;

	private IScenario scenario;

	public TLScenario(String pattern, IScenario scenario) {
		this.setPattern(pattern.split("[ -]"));
		this.setScenario(scenario);
	}

	public String[] getPattern() {
		return pattern;
	}

	public void setPattern(String[] pattern) {
		this.pattern = pattern;
	}

	public IScenario getScenario() {
		return scenario;
	}

	public void setScenario(IScenario scenario) {
		this.scenario = scenario;
	}
}
