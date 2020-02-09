package org.cysdigital.nitroplus;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.cysdigital.nitroplus.command.Command;

import javax.annotation.Nonnull;
import java.util.HashMap;
import java.util.Map;

public class CommandListener extends ListenerAdapter {

    private final static String PREFIX = "*";
    private final Map<String, Command> commands = new HashMap<>();

    @Override
    public void onMessageReceived(@Nonnull MessageReceivedEvent event) {
        if(event.getAuthor().getId().equals(event.getJDA().getSelfUser().getId())){
            if(event.getMessage().getContentRaw().startsWith("*")){

            }
        }
    }

    public void registerCommand(String commandName, Command command){
        commands.put(commandName, command);
    }
}
