
package com.godhenko.narutorevival.commands.statguicommands;

import com.godhenko.narutorevival.procedures.guiprocedures.addxpprocedures.JutsuPointSettingProcedure;
import com.godhenko.narutorevival.procedures.guiprocedures.addxpprocedures.KenJutsuSettingProcedure;
import com.mojang.brigadier.arguments.DoubleArgumentType;
import net.minecraft.commands.Commands;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraftforge.common.util.FakePlayerFactory;
import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;


@Mod.EventBusSubscriber
public class AlterJutsuPointsCommand {
	@SubscribeEvent
	public static void registerCommand(RegisterCommandsEvent event) {
		event.getDispatcher().register(Commands.literal("setjp").requires((commandSource) -> commandSource.hasPermission(1))

				.then(Commands.argument("value", DoubleArgumentType.doubleArg()).executes(arguments -> {
					ServerLevel world = arguments.getSource().getLevel();
					double x = arguments.getSource().getPosition().x();
					double y = arguments.getSource().getPosition().y();
					double z = arguments.getSource().getPosition().z();
					Entity entity = arguments.getSource().getEntity();
					if (entity == null)
						entity = FakePlayerFactory.getMinecraft(world);
					Direction direction = entity.getDirection();

					JutsuPointSettingProcedure.execute(arguments, entity);
					return 0;
				})));
	}
}
