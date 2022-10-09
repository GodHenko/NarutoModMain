package com.godhenko.narutorevival.chakra;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.IntegerArgumentType;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.commands.arguments.EntityArgument;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.server.level.ServerPlayer;

import java.util.Collection;

public class SetChakraCommand {
    public static void register(CommandDispatcher<CommandSourceStack> dispatcher) {
        dispatcher.register(
            Commands.literal("setchakra").requires((player) -> {
                return player.hasPermission(2);
            })
            .then(Commands.argument("targets", EntityArgument.players())
            .then(Commands.argument("chakra", IntegerArgumentType.integer(0, 100))
            .executes(context -> {
                return setMana(context.getSource(), EntityArgument.getPlayers(context, "targets"), IntegerArgumentType.getInteger(context, "chakra"));
            })
        )));
    }

    private static int setMana(CommandSourceStack source, Collection<ServerPlayer> targets, int mana) {
        for (ServerPlayer player : targets) {
            ChakraManager.setChakra(player, mana);
        }

        if (targets.size() == 1) {
            source.sendSuccess(new TranslatableComponent("commands.setmana.success.single", targets.iterator().next().getDisplayName(), mana), true);
        } else {
            source.sendSuccess(new TranslatableComponent("commands.setmana.success.multiple", targets.size(), mana), true);
        }

        return targets.size();
    }
}
