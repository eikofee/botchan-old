package com.botchan;

public interface ITLModule {

	void AddLink(String pattern, ICommand command);

	void AddLink(String pattern, IScenario scenario);
}
