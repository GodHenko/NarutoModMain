package com.godhenko.narutorevival.commands.statguicommands;

import com.godhenko.narutorevival.network.extra.Stats;
import com.godhenko.narutorevival.network.extra.stat.StatManager;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.IntegerArgumentType;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.commands.arguments.EntityArgument;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.server.level.ServerPlayer;

import java.util.Collection;

public class StatCommands {
    public static void register(CommandDispatcher<CommandSourceStack> dispatcher) {
        dispatcher.register(
            Commands.literal("skillset").requires((player) -> {
                return player.hasPermission(2);
            }).then(Commands.argument("skill", SkillArgument.skill())
                .then(Commands.argument("targets", EntityArgument.players())
                    .then(Commands.argument("value", IntegerArgumentType.integer(0))
                        .executes(context -> {
                            return set(context.getSource(),
                                    SkillArgument.getSkill(context, "skill"),
                                    EntityArgument.getPlayers(context, "targets"),
                                    IntegerArgumentType.getInteger(context, "value")
                            );
                        })
                    )
                )
            )
        );
    }

    private static int set(CommandSourceStack source, Stats stats, Collection<ServerPlayer> targets, int value) {
        if (stats == null) return 0;

        StatManager manager = stats.get().getManager();

        for (ServerPlayer player : targets) {
            manager.set(player, value);
        }

        if (targets.size() == 1) {
            source.sendSuccess(new TranslatableComponent("commands.narutorevival.success.single", targets.iterator().next().getDisplayName(), value), true);
        } else {
            source.sendSuccess(new TranslatableComponent("commands.narutorevival.success.multiple", targets.size(), value), true);
        }

        return targets.size();
    }
}
