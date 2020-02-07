package org.cysdigital.nitroplus;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import org.cysdigital.nitroplus.exception.TokenException;

public class NitroPlus {

    private final JDABuilder jdaBuilder;

    public NitroPlus(String[] args) throws TokenException {
        if(args.length != 1)
            throw new TokenException("Token missing");
        this.jdaBuilder = new JDABuilder(args[0]);
        this.jdaBuilder.addEventListeners(new CommandListener());
    }

    public static void main(String[] args){
        try {
            NitroPlus nitroPlus = new NitroPlus(args);

        } catch (TokenException e) {
            e.printStackTrace();
        }
    }

}
