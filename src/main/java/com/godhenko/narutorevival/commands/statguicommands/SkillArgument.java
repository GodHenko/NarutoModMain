package com.godhenko.narutorevival.commands.statguicommands;

import com.godhenko.narutorevival.network.extra.Stats;
import com.mojang.brigadier.StringReader;
import com.mojang.brigadier.arguments.ArgumentType;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.brigadier.exceptions.DynamicCommandExceptionType;
import com.mojang.brigadier.suggestion.Suggestions;
import com.mojang.brigadier.suggestion.SuggestionsBuilder;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.SharedSuggestionProvider;
import net.minecraft.network.chat.TranslatableComponent;

import java.util.Arrays;
import java.util.Collection;
import java.util.concurrent.CompletableFuture;

public class SkillArgument implements ArgumentType<Stats> {
    private static final Collection<String> EXAMPLES = Arrays.asList("chakra", "sp", "level", "ninjutsu","taijutsu","genjutsu","kenjutsu","shurikenjutsu","summoning","kinjutsu","senjutsu","medical","speed","intel");
    public static final DynamicCommandExceptionType ERROR_INVALID_VALUE = new DynamicCommandExceptionType((p_85470_) -> {
        return new TranslatableComponent("commands.narutorevival.fail.invalid_skill", p_85470_);
    });

    private SkillArgument() {}

    public static SkillArgument skill() {
        return new SkillArgument();
    }

    public static Stats getSkill(CommandContext<CommandSourceStack> pContext, String pName) {
        return pContext.getArgument(pName, Stats.class);
    }

    @Override
    public Stats parse(StringReader reader) throws CommandSyntaxException {
        String s = reader.readUnquotedString();
        Stats stats = Stats.getByName(s);
        if (stats != null) {
            return stats;
        } else {
            throw ERROR_INVALID_VALUE.create(s);
        }
    }

    @Override
    public <S> CompletableFuture<Suggestions> listSuggestions(CommandContext<S> context, SuggestionsBuilder builder) {
        return SharedSuggestionProvider.suggest(Stats.getNames(), builder);
    }

    @Override
    public Collection<String> getExamples() {
        return EXAMPLES;
    }
}
