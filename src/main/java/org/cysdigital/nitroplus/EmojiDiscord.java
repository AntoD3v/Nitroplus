package org.cysdigital.nitroplus;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.events.ReadyEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import javax.annotation.Nonnull;
import java.util.HashMap;
import java.util.Map;

public class EmojiDiscord extends ListenerAdapter {

    public final Map<String, String> emoji = new HashMap<>();

    @Override
    public void onReady(@Nonnull ReadyEvent event) {
        event.getJDA().getGuilds().forEach(guild -> {
            System.out.println(guild.getName());
            guild.getEmotes().forEach(emote -> {
                System.out.println(emote.getAsMention());
            });
        });
    }


}
