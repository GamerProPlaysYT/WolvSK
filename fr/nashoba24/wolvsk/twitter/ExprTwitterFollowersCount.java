package fr.nashoba24.wolvsk.twitter;

import javax.annotation.Nullable;

import org.bukkit.event.Event;

import twitter4j.User;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser.ParseResult;
import ch.njol.skript.lang.util.SimpleExpression;
import ch.njol.util.Kleenean;

public class ExprTwitterFollowersCount extends SimpleExpression<Integer>{
	
	private Expression<User> user;
	
	@Override
	public boolean isSingle() {
		return true;
	}
	
	@Override
	public Class<? extends Integer> getReturnType() {
		return Integer.class;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public boolean init(Expression<?>[] expr, int matchedPattern, Kleenean paramKleenean, ParseResult paramParseResult) {
		user = (Expression<User>) expr[0];
		return true;
	}
	
	@Override
	public String toString(@Nullable Event e, boolean paramBoolean) {
		return "followers count";
	}
	
	@Override
	@Nullable
	protected Integer[] get(Event e) {
		if(WolvSKTwitter.tf==null) { return null; }
		return new Integer[] { user.getSingle(e).getFollowersCount() };
	}
}

