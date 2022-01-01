package fr.nashoba24.wolvsk.misc;

import ch.njol.skript.Skript;
import ch.njol.skript.lang.ExpressionType;
import ch.njol.skript.lang.util.SimpleEvent;
import ch.njol.skript.registrations.EventValues;
import ch.njol.skript.util.Getter;
import ch.njol.skript.util.Timespan;
import fr.nashoba24.wolvsk.misc.anvilgui.WolvSKAnvilGUI;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import java.util.UUID;

public class WolvSKMisc implements Listener {
	
	public static void register() {
		   Skript.registerExpression(ExprBlockPower.class, Integer.class, ExpressionType.PROPERTY, "power of %block%", "%block%['s] power");
		   Skript.registerCondition(CondOdd.class, "%number% is odd", "%number% is(n't| not) odd");
		   Skript.registerCondition(CondEven.class, "%number% is even", "%number% is(n't| not) even");
			Skript.registerCondition(CondCooldownFinish.class, "cooldown %string% is (finish[ed]|over|done)", "cooldown %string% of %player% is (finish[ed]|over|done)", "cooldown %string% is(n't| not) (finish[ed]|over|done)", "cooldown %string% of %player% is(n't| not) (finish[ed]|over|done)");
			Skript.registerEffect(EffCreateCooldown.class, "create cooldown %string% for %timespan%", "create cooldown %string% (for|of) %player% for %timespan%");
			Skript.registerEffect(EffCreateCooldown.class, "(delete|reset|finish) cooldown %string%", "(delete|reset|finish) cooldown %string% (for|of) %player%");
			Skript.registerExpression(ExprCooldownLeftTime.class, Timespan.class, ExpressionType.PROPERTY, "cooldown[ left][ time] %string%", "cooldown[ left][ time] %string% of %player%");
		   Skript.registerExpression(ExprCountry.class, String.class, ExpressionType.PROPERTY, "country of ip %string%", "country of %player%", "country code of ip %string%", "country code of %player%", "ip %string%['s] country", "%player%['s] country", "ip %string%['s] country code", "%player%['s] country code");
		   Skript.registerExpression(ExprRandomUUID.class, UUID.class, ExpressionType.PROPERTY, "[a ]random uuid");
		   Skript.registerExpression(ExprRandomLicenceCode.class, String.class, ExpressionType.PROPERTY, "[a ]random license code");
		   Skript.registerExpression(ExprRandomAlphaNumericString.class, String.class, ExpressionType.PROPERTY, "[a ]random alpha[ ]numeric[al] (text|string) of length %integer%");
		   Skript.registerExpression(ExprListSort.class, Object.class, ExpressionType.PROPERTY, "%objects% (sorted|in order)");
		   WolvSKAnvilGUI.registerAll();
		   if(Bukkit.getServer().getPluginManager().getPlugin("ProtocolLib") != null) {
			   WolvSKSteer.registerSteer();
			   ExprClientVersion.registerClientVersion();
			   Skript.registerExpression(ExprClientVersion.class, Integer.class, ExpressionType.PROPERTY, "(minecraft|mc) version of %player%");
			   Skript.registerEvent("Vehicle Steer Left", SimpleEvent.class, SteerLeftEvent.class, "vehicle steer left");
			   EventValues.registerEventValue(SteerLeftEvent.class, Player.class, new Getter<Player, SteerLeftEvent>() {
				   public Player get(SteerLeftEvent e) {
					   return e.getPlayer();
				   }
			   }, 0);
			   Skript.registerEvent("Vehicle Steer Right", SimpleEvent.class, SteerRightEvent.class, "vehicle steer right");
			   EventValues.registerEventValue(SteerRightEvent.class, Player.class, new Getter<Player, SteerRightEvent>() {
				   public Player get(SteerRightEvent e) {
					   return e.getPlayer();
				   }
			   }, 0);
			   Skript.registerEvent("Vehicle Steer Forward", SimpleEvent.class, SteerForwardEvent.class, "vehicle steer forward");
			   EventValues.registerEventValue(SteerForwardEvent.class, Player.class, new Getter<Player, SteerForwardEvent>() {
				   public Player get(SteerForwardEvent e) {
					   return e.getPlayer();
				   }
			   }, 0);
			   Skript.registerEvent("Vehicle Steer Backward", SimpleEvent.class, SteerBackwardEvent.class, "vehicle steer backward");
			   EventValues.registerEventValue(SteerBackwardEvent.class, Player.class, new Getter<Player, SteerBackwardEvent>() {
				   public Player get(SteerBackwardEvent e) {
					   return e.getPlayer();
				   }
			   }, 0);
			   Skript.registerEvent("Vehicle Steer Jump", SimpleEvent.class, SteerJumpEvent.class, "vehicle steer jump");
			   EventValues.registerEventValue(SteerJumpEvent.class, Player.class, new Getter<Player, SteerJumpEvent>() {
				   public Player get(SteerJumpEvent e) {
					   return e.getPlayer();
				   }
			   }, 0);
		   }
	}
}
