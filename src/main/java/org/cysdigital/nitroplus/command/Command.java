package org.cysdigital.nitroplus.command;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

public interface Command {
    void onCommand(MessageReceivedEvent messageReceivedEvent);
}
