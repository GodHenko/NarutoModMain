package com.godhenko.narutomod.network;

import com.godhenko.narutomod.NarutoMod;
import com.godhenko.narutomod.procedures.guiprocedures.increaseprocedure.*;
import com.godhenko.narutomod.world.inventory.StatsMenu;
import net.minecraft.core.BlockPos;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.network.NetworkEvent;

import java.util.HashMap;
import java.util.function.Supplier;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class StatsButtonMessage {
    private final int buttonID, x, y, z;

    public StatsButtonMessage(FriendlyByteBuf buffer) {
        this.buttonID = buffer.readInt();
        this.x = buffer.readInt();
        this.y = buffer.readInt();
        this.z = buffer.readInt();
    }

    public StatsButtonMessage(int buttonID, int x, int y, int z) {
        this.buttonID = buttonID;
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public static void buffer(StatsButtonMessage message, FriendlyByteBuf buffer) {
        buffer.writeInt(message.buttonID);
        buffer.writeInt(message.x);
        buffer.writeInt(message.y);
        buffer.writeInt(message.z);
    }

    public static void handler(StatsButtonMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
        NetworkEvent.Context context = contextSupplier.get();
        context.enqueueWork(() -> {
            Player entity = context.getSender();
            int buttonID = message.buttonID;
            int x = message.x;
            int y = message.y;
            int z = message.z;
            handleButtonAction(entity, buttonID, x, y, z);
        });
        context.setPacketHandled(true);
    }

    public static void handleButtonAction(Player entity, int buttonID, int x, int y, int z) {
        Level world = entity.level;
        HashMap guistate = StatsMenu.guistate;
        // security measure to prevent arbitrary chunk generation
        if (!world.hasChunkAt(new BlockPos(x, y, z)))
            return;
        if (buttonID == 0) {

            IncreaseNinjutsuProcedure.execute(entity);
        }
        if (buttonID == 1) {

            IncreaseTaijutsuProcedure.execute(entity);
        }
        if (buttonID == 2) {

            IncreaseGenjutsuProcedure.execute(entity);
        }
        if (buttonID == 3) {

            IncreaseKenjutsuProcedure.execute(entity);
        }
        if (buttonID == 4) {

            IncreaseShurikenjutsuProcedure.execute(entity);
        }
        if (buttonID == 5) {

            IncreaseSummoningProcedure.execute(entity);
        }
        if (buttonID == 6) {

            IncreaseKinjutsuProcedure.execute(entity);
        }
        if (buttonID == 7) {

            IncreaseSenjutsuProcedure.execute(entity);
        }
        if (buttonID == 8) {

            IncreaseMedicalProcedure.execute(entity);
        }
        if (buttonID == 9) {

            IncreaseSpeedProcedure.execute(entity);
        }
        if (buttonID == 10) {

            IncreaseIntelligenceProcedure.execute(entity);
        }
    }

    @SubscribeEvent
    public static void registerMessage(FMLCommonSetupEvent event) {
        NarutoMod.addNetworkMessage(StatsButtonMessage.class, StatsButtonMessage::buffer, StatsButtonMessage::new,
                StatsButtonMessage::handler);
    }
}
