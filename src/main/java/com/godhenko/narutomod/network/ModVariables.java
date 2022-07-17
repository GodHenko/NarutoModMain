package com.godhenko.narutomod.network;

import com.godhenko.narutomod.NarutoMod;
import net.minecraftforge.network.PacketDistributor;
import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.common.util.FakePlayer;
import net.minecraftforge.common.capabilities.RegisterCapabilitiesEvent;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;
import net.minecraftforge.common.capabilities.CapabilityToken;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.common.capabilities.Capability;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.nbt.Tag;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.core.Direction;
import net.minecraft.client.Minecraft;

import java.util.function.Supplier;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModVariables {
    @SubscribeEvent
    public static void init(FMLCommonSetupEvent event) {
        NarutoMod.addNetworkMessage(PlayerVariablesSyncMessage.class, PlayerVariablesSyncMessage::buffer,
                PlayerVariablesSyncMessage::new, PlayerVariablesSyncMessage::handler);
    }

    @SubscribeEvent
    public static void init(RegisterCapabilitiesEvent event) {
        event.register(PlayerVariables.class);
    }

    @Mod.EventBusSubscriber
    public static class EventBusVariableHandlers {
        @SubscribeEvent
        public static void onPlayerLoggedInSyncPlayerVariables(PlayerEvent.PlayerLoggedInEvent event) {
            if (!event.getPlayer().level.isClientSide())
                ((PlayerVariables) event.getPlayer().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables()))
                        .syncPlayerVariables(event.getPlayer());
        }

        @SubscribeEvent
        public static void onPlayerRespawnedSyncPlayerVariables(PlayerEvent.PlayerRespawnEvent event) {
            if (!event.getPlayer().level.isClientSide())
                ((PlayerVariables) event.getPlayer().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables()))
                        .syncPlayerVariables(event.getPlayer());
        }

        @SubscribeEvent
        public static void onPlayerChangedDimensionSyncPlayerVariables(PlayerEvent.PlayerChangedDimensionEvent event) {
            if (!event.getPlayer().level.isClientSide())
                ((PlayerVariables) event.getPlayer().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables()))
                        .syncPlayerVariables(event.getPlayer());
        }

        @SubscribeEvent
        public static void clonePlayer(PlayerEvent.Clone event) {
            event.getOriginal().revive();
            PlayerVariables original = ((PlayerVariables) event.getOriginal().getCapability(PLAYER_VARIABLES_CAPABILITY, null)
                    .orElse(new PlayerVariables()));
            PlayerVariables clone = ((PlayerVariables) event.getEntity().getCapability(PLAYER_VARIABLES_CAPABILITY, null)
                    .orElse(new PlayerVariables()));
            clone.ninjutsu = original.ninjutsu;
            clone.taijutsu = original.taijutsu;
            clone.genjutsu = original.genjutsu;
            clone.kenjutsu = original.kenjutsu;
            clone.shurikenjutsu = original.shurikenjutsu;
            clone.summoning = original.summoning;
            clone.kinjutsu = original.kinjutsu;
            clone.senjutsu = original.senjutsu;
            clone.medical = original.medical;
            clone.intelligence = original.intelligence;
            clone.speed = original.speed;
            clone.level = original.level;
            clone.xp = original.xp;
            clone.xpMax = original.xpMax;
            if (!event.isWasDeath()) {
            }
        }
    }

    public static final Capability<PlayerVariables> PLAYER_VARIABLES_CAPABILITY = CapabilityManager.get(new CapabilityToken<PlayerVariables>() {
    });

    @Mod.EventBusSubscriber
    private static class PlayerVariablesProvider implements ICapabilitySerializable<Tag> {
        @SubscribeEvent
        public static void onAttachCapabilities(AttachCapabilitiesEvent<Entity> event) {
            if (event.getObject() instanceof Player && !(event.getObject() instanceof FakePlayer))
                event.addCapability(new ResourceLocation("narutomod", "player_variables"), new PlayerVariablesProvider());
        }

        private final PlayerVariables playerVariables = new PlayerVariables();
        private final LazyOptional<PlayerVariables> instance = LazyOptional.of(() -> playerVariables);

        @Override
        public <T> LazyOptional<T> getCapability(Capability<T> cap, Direction side) {
            return cap == PLAYER_VARIABLES_CAPABILITY ? instance.cast() : LazyOptional.empty();
        }

        @Override
        public Tag serializeNBT() {
            return playerVariables.writeNBT();
        }

        @Override
        public void deserializeNBT(Tag nbt) {
            playerVariables.readNBT(nbt);
        }
    }

    public static class PlayerVariables {
        public double ninjutsu = 0;
        public double taijutsu = 0;
        public double genjutsu = 0;
        public double kenjutsu = 0;
        public double shurikenjutsu = 0;
        public double summoning = 0;
        public double kinjutsu = 0;
        public double senjutsu = 0;
        public double medical = 0;
        public double speed = 0;
        public double intelligence = 0;
        public double level = 0;
        public double xp = 0;
        public double xpMax = 0;

        public void syncPlayerVariables(Entity entity) {
            if (entity instanceof ServerPlayer serverPlayer)
                NarutoMod.PACKET_HANDLER.send(PacketDistributor.PLAYER.with(() -> serverPlayer),
                        new PlayerVariablesSyncMessage(this));
        }

        public Tag writeNBT() {
            CompoundTag nbt = new CompoundTag();
            nbt.putDouble("ninjutsu", ninjutsu);
            nbt.putDouble("taijutsu", taijutsu);
            nbt.putDouble("genjutsu", genjutsu);
            nbt.putDouble("kenjutsu", kenjutsu);
            nbt.putDouble("shurikenjutsu", shurikenjutsu);
            nbt.putDouble("summoning", summoning);
            nbt.putDouble("kinjutsu", kinjutsu);
            nbt.putDouble("senjutsu", senjutsu);
            nbt.putDouble("medical", medical);
            nbt.putDouble("intelligence", intelligence);
            nbt.putDouble("speed", speed);
            nbt.putDouble("level", level);
            nbt.putDouble("xp", xp);
            nbt.putDouble("xpMax", xpMax);
            return nbt;
        }

        public void readNBT(Tag Tag) {
            CompoundTag nbt = (CompoundTag) Tag;
            ninjutsu = nbt.getDouble("ninjutsu");
            taijutsu = nbt.getDouble("taijutsu");
            genjutsu = nbt.getDouble("genjutsu");
            kenjutsu = nbt.getDouble("kenjutsu");
            shurikenjutsu = nbt.getDouble("shurikenjutsu");
            summoning = nbt.getDouble("summoning");
            kinjutsu = nbt.getDouble("kinjutsu");
            senjutsu = nbt.getDouble("senjutsu");
            medical = nbt.getDouble("medical");
            intelligence = nbt.getDouble("intelligence");
            speed = nbt.getDouble("speed");
            level = nbt.getDouble("level");
            xp = nbt.getDouble("xp");
            xpMax = nbt.getDouble("xpMax");
        }
    }

    public static class PlayerVariablesSyncMessage {
        public PlayerVariables data;

        public PlayerVariablesSyncMessage(FriendlyByteBuf buffer) {
            this.data = new PlayerVariables();
            this.data.readNBT(buffer.readNbt());
        }

        public PlayerVariablesSyncMessage(PlayerVariables data) {
            this.data = data;
        }

        public static void buffer(PlayerVariablesSyncMessage message, FriendlyByteBuf buffer) {
            buffer.writeNbt((CompoundTag) message.data.writeNBT());
        }

        public static void handler(PlayerVariablesSyncMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
            NetworkEvent.Context context = contextSupplier.get();
            context.enqueueWork(() -> {
                if (!context.getDirection().getReceptionSide().isServer()) {
                    PlayerVariables variables = ((PlayerVariables) Minecraft.getInstance().player.getCapability(PLAYER_VARIABLES_CAPABILITY, null)
                            .orElse(new PlayerVariables()));
                    variables.ninjutsu = message.data.ninjutsu;
                    variables.taijutsu = message.data.taijutsu;
                    variables.genjutsu = message.data.genjutsu;
                    variables.kenjutsu = message.data.kenjutsu;
                    variables.shurikenjutsu = message.data.shurikenjutsu;
                    variables.summoning = message.data.summoning;
                    variables.kinjutsu = message.data.kinjutsu;
                    variables.senjutsu = message.data.senjutsu;
                    variables.medical = message.data.medical;
                    variables.intelligence = message.data.intelligence;
                    variables.speed = message.data.speed;
                    variables.level = message.data.level;
                    variables.xp = message.data.xp;
                    variables.xpMax = message.data.xpMax;
                }
            });
            context.setPacketHandled(true);
        }
    }
}
