
package com.godhenko.narutorevival.network;

import com.godhenko.narutorevival.NarutoRevival;
import com.godhenko.narutorevival.procedures.guiprocedures.lessprocecdures.*;
import com.godhenko.narutorevival.procedures.guiprocedures.moreprocedures.*;
import com.godhenko.narutorevival.procedures.guiprocedures.okprocedures.*;
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

			MoreninjutsuProcedure.execute(world);
		}
		if (buttonID == 1) {

			LessninjutsuProcedure.execute(world);
		}
		if (buttonID == 2) {

			OkninjutsuProcedure.execute(world);
		}

		if (buttonID == 3) {

			MoretaijutsuProcedure.execute(world);
		}
		if (buttonID == 4) {

			LesstaijutsuProcedure.execute(world);
		}
		if (buttonID == 5) {

			OktaijutsuProcedure.execute(world);
		}
		if (buttonID == 6) {

			MoregenjutsuProcedure.execute(world);
		}
		if (buttonID == 7) {

			LessgenjutsuProcedure.execute(world);
		}
		if (buttonID == 8) {

			OkgenjutsuProcedure.execute(world);
		}
		if (buttonID == 9) {

			MorekenjutsuProcedure.execute(world);
		}
		if (buttonID == 10) {

			LesskenjutsuProcedure.execute(world);
		}
		if (buttonID == 11) {

			OkkenjutsuProcedure.execute(world);
		}
		if (buttonID == 12) {

			MoreshurikenjutsuProcedure.execute(world);
		}
		if (buttonID == 13) {

			LessshurikenjutsuProcedure.execute(world);
		}
		if (buttonID == 14) {

			OkshurikenjutsuProcedure.execute(world);
		}
		if (buttonID == 15) {

			MoresummoningProcedure.execute(world);
		}
		if (buttonID == 16) {

			LesssummoningProcedure.execute(world);
		}
		if (buttonID == 17) {

			OksummoningProcedure.execute(world);
		}
		if (buttonID == 18) {

			MorekinjutsuProcedure.execute(world);
		}
		if (buttonID == 19) {

			LesskinjutsuProcedure.execute(world);
		}
		if (buttonID == 20) {

			OkkinjutsuProcedure.execute(world);
		}
		if (buttonID == 21) {

			MoresenjutsuProcedure.execute(world);
		}
		if (buttonID == 22) {

			LesssennjutsuProcedure.execute(world);
		}
		if (buttonID == 23) {

			OksenjutsuProcedure.execute(world);
		}
		if (buttonID == 24) {

			MoremedicalProcedure.execute(world);
		}
		if (buttonID == 25) {

			LessmedicalProcedure.execute(world);
		}
		if (buttonID == 26) {

			OkmedicalProcedure.execute(world);
		}
		if (buttonID == 27) {

			MorespeedProcedure.execute(world);
		}
		if (buttonID == 28) {

			LessspeedProcedure.execute(world);
		}
		if (buttonID == 29) {

			OkspeedProcedure.execute(world);
		}

	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		NarutoRevival.addNetworkMessage(StatsButtonMessage.class, StatsButtonMessage::buffer, StatsButtonMessage::new, StatsButtonMessage::handler);
	}
}
