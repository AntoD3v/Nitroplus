package org.cysdigital.nitroplus;

import net.dv8tion.jda.api.AccountType;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.Permission;
import org.cysdigital.nitroplus.command.SpamCommand;
import org.cysdigital.nitroplus.exception.TokenException;

import javax.security.auth.login.LoginException;

public class NitroPlus {

    private final JDABuilder jdaBuilder;
    private final CommandListener commandListener = new CommandListener();
    private JDA jda;

    public NitroPlus(String[] args) throws TokenException {
        if(args.length != 1)
            throw new TokenException("Token missing");
        this.jdaBuilder = new JDABuilder(AccountType.CLIENT);
        this.jdaBuilder.setToken(args[0]);
    }

    public void build() throws LoginException {
        System.out.print("Building ... ");
        this.jdaBuilder.addEventListeners(commandListener);
        this.jdaBuilder.addEventListeners(new EmojiDiscord());
        this.jda = this.jdaBuilder.build();
        this.commandListener.registerCommand("spam", new SpamCommand());
        System.out.println(" done !");
    }

    public static void main(String[] args){
        try {
            NitroPlus nitroPlus = new NitroPlus(args);
            nitroPlus.build();
            System.out.println("Join server with "+nitroPlus.getJda().getInviteUrl(Permission.ADMINISTRATOR));
        } catch (TokenException e) {
            e.printStackTrace();
        } catch (LoginException e) {
            e.printStackTrace();
        }
    }

    public JDA getJda() {
        return jda;
    }

    public JDABuilder getJdaBuilder() {
        return jdaBuilder;
    }
}
