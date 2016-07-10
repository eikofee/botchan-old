import sx.blah.discord.api.*;
import sx.blah.discord.handle.impl.events.*;

/**
 * Created by Echoffee on 10/07/2016.
 */
public class EventsListener {

    @EventSubscriber
    public void onReady(ReadyEvent event) {
        try {
            MainClass.client.changeUsername("Bot-chan");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @EventSubscriber
    public void onTalking(MessageReceivedEvent event) {
        String message = event.getMessage().toString();

    }
}
