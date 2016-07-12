import sx.blah.discord.api.*;
import sx.blah.discord.handle.impl.events.*;

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
