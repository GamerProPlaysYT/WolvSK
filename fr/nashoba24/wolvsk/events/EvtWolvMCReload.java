package fr.nashoba24.wolvsk.events;

import javax.annotation.Nullable;

import org.bukkit.event.Event;

import ch.njol.skript.lang.Literal;
import ch.njol.skript.lang.SkriptEvent;
import ch.njol.skript.lang.SkriptParser.ParseResult;

public class EvtWolvMCReload extends SkriptEvent {

	@Override
	public String toString(@Nullable Event e, boolean arg1) {
		return null;
	}

	@Override
	public boolean check(Event e) {
		return false;
	}

	@Override
	public boolean init(Literal<?>[] arg0, int arg1, ParseResult arg2) {
		return false;
	}

}
