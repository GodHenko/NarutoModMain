
package com.godhenko.narutorevival.network;

import com.godhenko.narutorevival.NarutoRevival;
import com.godhenko.narutorevival.procedures.guiprocedures.moreprocedures.*;
import com.godhenko.narutorevival.procedures.guiprocedures.moreprocedures.MoreHPProcedure;
import com.godhenko.narutorevival.procedures.guiprocedures.moreprocedures.ten.*;
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

				MoreninjutsuProcedure.execute(entity);
			}
			if (buttonID == 1) {

				MoretaijutsuProcedure.execute(entity);
			}
			if (buttonID == 2) {

				MoregenjutsuProcedure.execute(entity);
			}
			if (buttonID == 3) {

				MorekenjutsuProcedure.execute(entity);
			}
			if (buttonID == 4) {

				MoreshurikenjutsuProcedure.execute(entity);
			}
			if (buttonID == 5) {

				MoresummoningProcedure.execute(entity);
			}
			if (buttonID == 6) {

				MorekinjutsuProcedure.execute(entity);
			}
			if (buttonID == 7) {

				MoresenjutsuProcedure.execute(entity);
			}
			if (buttonID == 8) {

				MoreHPProcedure.execute(world, x, y, z,entity);
			}
			if (buttonID == 9) {

				MorespeedProcedure.execute(entity);
			}
			if (buttonID == 10){
				TenMoreninjutsuProcedure.execute(entity);
			}
		if (buttonID == 11) {

			TenMoretaijutsuProcedure.execute(entity);
		}
		if (buttonID == 12) {

			TenMoregenjutsuProcedure.execute(entity);
		}
		if (buttonID == 13) {

			TenMorekenjutsuProcedure.execute(entity);
		}
		if (buttonID == 14) {

			TenMoreshurikenjutsuProcedure.execute(entity);
		}
		if (buttonID == 15) {

			TenMoresummoningProcedure.execute(entity);
		}
		if (buttonID == 16) {

			TenMorekinjutsuProcedure.execute(entity);
		}
		if (buttonID == 17) {

			TenMoresenjutsuProcedure.execute(entity);
		}
		if (buttonID ==18) {

			TenMoreHPProcedure.execute(world, x, y, z,entity);
		}
		if (buttonID == 19) {

			TenMorespeedProcedure.execute(entity);
		}




		}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		NarutoRevival.addNetworkMessage(StatsButtonMessage.class, StatsButtonMessage::buffer, StatsButtonMessage::new, StatsButtonMessage::handler);
	}
}
