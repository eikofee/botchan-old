package com.botchan.commands;

import com.botchan.ICommand;
import com.botchan.TLModule;
import sx.blah.discord.handle.impl.events.MessageReceivedEvent;
import org.json.*;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

public class DanbooruQuery implements ICommand {
	@Override
	public void Run(TLModule tlm, MessageReceivedEvent event) {
		try {
			InputStream stream = new URL("https://danbooru.donmai.us/posts/" + event.getMessage().getContent().replace("db ", "") + ".json").openStream();
			InputStreamReader reader = new InputStreamReader(stream);
			BufferedReader r = new BufferedReader(reader);
			String line;

			String json = "";
			while ((line = r.readLine()) != null)
			{
				json += line + "\n";
			}
			JSONObject o = new JSONObject(json);
			String message = "https://danbooru.donmai.us" + o.getString("file_url");
			r.close();

			tlm.Say(message, event, TLModule.SayMode.no_nat);

		} catch (Exception e) {
			e.getStackTrace();
		}
	}
}
