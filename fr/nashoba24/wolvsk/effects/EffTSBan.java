package fr.nashoba24.wolvsk.effects;

import javax.annotation.Nullable;

import org.bukkit.event.Event;

import com.github.theholywaffle.teamspeak3.api.wrapper.Client;

import ch.njol.skript.lang.Effect;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser.ParseResult;
import ch.njol.util.Kleenean;
import fr.nashoba24.wolvsk.WolvSK;

public class EffTSBan extends Effect {
	
	private Expression<String> client;
	private Expression<String> msg;
	
	@SuppressWarnings("unchecked")
	@Override
	public boolean init(Expression<?>[] expr, int matchedPattern, Kleenean paramKleenean, ParseResult paramParseResult) {
		client = (Expression<String>) expr[0];
		msg = (Expression<String>) expr[1];
		return true;
	}
	
	@Override
	public String toString(@Nullable Event e, boolean b) {
		return "ts3 ban";
	}
	
	@Override
	protected void execute(Event e) {
		Client c = WolvSK.ts3api.getClientByNameExact(client.getSingle(e), true);
		if(c!=null) {
			WolvSK.ts3api.banClient(c.getId(), msg.getSingle(e));
		}
	}
}
