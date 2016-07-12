import sx.blah.discord.api.*;
import sx.blah.discord.util.*;

import java.io.*;

public class MainClass {
    static IDiscordClient client;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader("token.txt"));
        String token;
        try {
            token = br.readLine();
        } catch (Exception e) {
            throw new Exception("Token File not found");
        }
        client = new ClientBuilder().withToken(token).login();
        client.getDispatcher().registerListener(new EventsListener());
    }
}
