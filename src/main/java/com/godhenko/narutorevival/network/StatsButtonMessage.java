
package com.godhenko.narutorevival.network;

import com.godhenko.narutorevival.NarutoRevival;
import com.godhenko.narutorevival.procedures.guiprocedures.moreprocedures.*;
import com.godhenko.narutorevival.procedures.guiprocedures.moreprocedures.MoreHPProcedure;
import com.godhenko.narutorevival.procedures.guiprocedures.moreprocedures.plus10.*;
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

				MoretaijutsuProcedure.execute(world);
			}
			if (buttonID == 2) {

				MoregenjutsuProcedure.execute(world);
			}
			if (buttonID == 3) {

				MorekenjutsuProcedure.execute(world);
			}
			if (buttonID == 4) {

				MoreshurikenjutsuProcedure.execute(world);
			}
			if (buttonID == 5) {

				MoresummoningProcedure.execute(world);
			}
			if (buttonID == 6) {

				MorekinjutsuProcedure.execute(world);
			}
			if (buttonID == 7) {

				MoresenjutsuProcedure.execute(world);
			}
			if (buttonID == 8) {

				MoreHPProcedure.execute(world, x, y, z);
			}
			if (buttonID == 9) {

				MorespeedProcedure.execute(world);
			}
		if (buttonID == 10) {

			TenMoreninjutsuProcedure.execute(world);
		}
		if (buttonID == 11) {

			TenMoretaijutsuProcedure.execute(world);
		}
		if (buttonID == 12) {

			TenMoregenjutsuProcedure.execute(world);
		}
		if (buttonID == 13) {

			TenMorekenjutsuProcedure.execute(world);
		}
		if (buttonID == 14) {

			TenMoreshurikenjutsuProcedure.execute(world);
		}
		if (buttonID == 15) {

			TenMoresummoningProcedure.execute(world);
		}
		if (buttonID == 16) {

			TenMorekinjutsuProcedure.execute(world);
		}
		if (buttonID == 17) {

			TenMoresenjutsuProcedure.execute(world);
		}
		if (buttonID == 18) {

			TenMoreHPProcedure.execute(world, x, y, z);
		}
		if (buttonID == 19) {

			TenMorespeedProcedure.execute(world);
		}



		}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		NarutoRevival.addNetworkMessage(StatsButtonMessage.class, StatsButtonMessage::buffer, StatsButtonMessage::new, StatsButtonMessage::handler);
	}
}
