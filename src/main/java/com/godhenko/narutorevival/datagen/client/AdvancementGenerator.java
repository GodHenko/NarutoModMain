package com.godhenko.narutorevival.datagen.client;

import net.minecraft.advancements.*;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.advancements.AdvancementProvider;


import java.util.function.Consumer;
import java.util.function.Supplier;

public class AdvancementGenerator extends AdvancementProvider {
    public AdvancementGenerator(DataGenerator generatorIn) {
        super(generatorIn);
        MainAdvancements main = new MainAdvancements();

    }

    @SuppressWarnings("ClassCanBeRecord")
    private static class NarutoAdvancements implements Consumer<Consumer<Advancement>> {

        private final Supplier<Advancement> root;

        public NarutoAdvancements(Supplier<Advancement> root) {
            this.root = root;
        }

        @Override
        public void accept(Consumer<Advancement> consumer) {

        }
    }

    private static class MainAdvancements implements Consumer<Consumer<Advancement>> {
        Advancement root;

        @Override
        public void accept(Consumer<Advancement> consumer) {

        }

        public Advancement getRoot() {
            return root;
        }
    }
}