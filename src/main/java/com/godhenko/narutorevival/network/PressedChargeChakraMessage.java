package com.godhenko.narutorevival.network;

import com.godhenko.narutorevival.NarutoRevival;
import com.godhenko.narutorevival.procedures.chakra.ChargeChakraProcdure;
import com.godhenko.narutorevival.procedures.guiprocedures.otherprocedures.OpenStatsOnKeyPressedProcedure;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.network.NetworkEvent;

import java.util.function.Supplier;
@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)

public class PressedChargeChakraMessage {
    int type, pressedms;

    public PressedChargeChakraMessage(int type, int pressedms) {
        this.type = type;
        this.pressedms = pressedms;
    }

    public PressedChargeChakraMessage(FriendlyByteBuf buffer) {
        this.type = buffer.readInt();
        this.pressedms = buffer.readInt();
    }

    public static void buffer(PressedChargeChakraMessage message, FriendlyByteBuf buffer) {
        buffer.writeInt(message.type);
        buffer.writeInt(message.pressedms);
    }

    public static void handler(PressedChargeChakraMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
        NetworkEvent.Context context = contextSupplier.get();
        context.enqueueWork(() -> {
            pressAction(context.getSender(), message.type, message.pressedms);
        });
        context.setPacketHandled(true);
    }

    public static void pressAction(Player entity, int type, int pressedms) {
        Level world = entity.level;
        double x = entity.getX();
        double y = entity.getY();
        double z = entity.getZ();
        // security measure to prevent arbitrary chunk generation
        if (!world.hasChunkAt(entity.blockPosition()))
            return;
        if (type == 0) {

            ChargeChakraProcdure.execute(world, x, y, z, entity);
        }
    }

    @SubscribeEvent
    public static void registerMessage(FMLCommonSetupEvent event) {
        NarutoRevival.addNetworkMessage(PressedChargeChakraMessage.class, PressedChargeChakraMessage::buffer, PressedChargeChakraMessage::new, PressedChargeChakraMessage::handler);
    }
}
