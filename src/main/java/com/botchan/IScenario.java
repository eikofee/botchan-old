package com.botchan;

public interface IScenario {
	void LinkToScenario (String pattern, IScenario scenario);

	void LinkToCommand (String pattern, ICommand command);
}
