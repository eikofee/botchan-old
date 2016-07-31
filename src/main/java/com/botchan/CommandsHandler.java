package com.botchan;

import com.botchan.commands.CryingBotchan;
import com.botchan.commands.DanbooruQuery;
import com.botchan.commands.HelloWorld;
import com.botchan.commands.RandomYesNoAnswer;

public class CommandsHandler {
	public static void Initialize(TLModule module)
	{
		module.AddLink("_greeting _botchan_name", new HelloWorld());
		module.AddLink("_yes_no_question_mark * _botchan_name ?", new RandomYesNoAnswer());
		module.AddLink("_botchan_name _yes_no_question_mark * ?", new RandomYesNoAnswer());
		module.AddLink("fuck you _botchan_name", new CryingBotchan());
		module.AddLink("db 2298456", new DanbooruQuery());
	}
}
