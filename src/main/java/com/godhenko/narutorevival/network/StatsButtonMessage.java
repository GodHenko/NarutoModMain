
package com.godhenko.narutorevival.network;

import com.godhenko.narutorevival.NarutoRevival;
import com.godhenko.narutorevival.procedures.guiprocedures.lessprocecdures.LessagilityProcedure;
import com.godhenko.narutorevival.procedures.guiprocedures.lessprocecdures.LessspeedProcedure;
import com.godhenko.narutorevival.procedures.guiprocedures.lessprocecdures.LessstrengthProcedure;
import com.godhenko.narutorevival.procedures.guiprocedures.moreprocedures.MoreagilityProcedure;
import com.godhenko.narutorevival.procedures.guiprocedures.moreprocedures.MorespeedProcedure;
import com.godhenko.narutorevival.procedures.guiprocedures.moreprocedures.MorestrengthProcedure;
import com.godhenko.narutorevival.procedures.guiprocedures.okprocedures.OkagilityProcedure;
import com.godhenko.narutorevival.procedures.guiprocedures.okprocedures.OkspeedProcedure;
import com.godhenko.narutorevival.procedures.guiprocedures.okprocedures.OkstrengthProcedure;
import com.godhenko.narutorevival.world.inventory.StatsMenu;
import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.core.BlockPos;

import java.util.function.Supplier;
import java.util.HashMap;


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

			LessstrengthProcedure.execute(world);
		}
		if (buttonID == 1) {

			MorestrengthProcedure.execute(world);
		}
		if (buttonID == 2) {

			OkstrengthProcedure.execute(world);
		}
		if (buttonID == 3) {

			LessagilityProcedure.execute(world);
		}
		if (buttonID == 4) {

			MoreagilityProcedure.execute(world);
		}
		if (buttonID == 5) {

			OkagilityProcedure.execute(world);
		}
		if (buttonID == 6) {

			LessspeedProcedure.execute(world);
		}
		if (buttonID == 7) {

			MorespeedProcedure.execute(world);
		}
		if (buttonID == 8) {

			OkspeedProcedure.execute(world);
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		NarutoRevival.addNetworkMessage(StatsButtonMessage.class, StatsButtonMessage::buffer, StatsButtonMessage::new, StatsButtonMessage::handler);
	}
}
