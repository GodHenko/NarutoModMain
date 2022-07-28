package com.godhenko.narutorevival.network;

import com.godhenko.narutorevival.NarutoRevival;
import net.minecraftforge.network.PacketDistributor;
import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;

import net.minecraft.world.level.saveddata.SavedData;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.nbt.CompoundTag;

import java.util.function.Supplier;



@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class NarutoRevivalModVariables {
	@SubscribeEvent
	public static void init(FMLCommonSetupEvent event) {
		NarutoRevival.addNetworkMessage(SavedDataSyncMessage.class, SavedDataSyncMessage::buffer, SavedDataSyncMessage::new,
				SavedDataSyncMessage::handler);
	}

	@Mod.EventBusSubscriber
	public static class EventBusVariableHandlers {
		@SubscribeEvent
		public static void onPlayerLoggedIn(PlayerEvent.PlayerLoggedInEvent event) {
			if (!event.getPlayer().level.isClientSide()) {
				SavedData mapdata = MapVariables.get(event.getPlayer().level);
				SavedData worlddata = WorldVariables.get(event.getPlayer().level);
				if (mapdata != null)
					NarutoRevival.PACKET_HANDLER.send(PacketDistributor.PLAYER.with(() -> (ServerPlayer) event.getPlayer()),
							new SavedDataSyncMessage(0, mapdata));
				if (worlddata != null)
					NarutoRevival.PACKET_HANDLER.send(PacketDistributor.PLAYER.with(() -> (ServerPlayer) event.getPlayer()),
							new SavedDataSyncMessage(1, worlddata));
			}
		}

		@SubscribeEvent
		public static void onPlayerChangedDimension(PlayerEvent.PlayerChangedDimensionEvent event) {
			if (!event.getPlayer().level.isClientSide()) {
				SavedData worlddata = WorldVariables.get(event.getPlayer().level);
				if (worlddata != null)
					NarutoRevival.PACKET_HANDLER.send(PacketDistributor.PLAYER.with(() -> (ServerPlayer) event.getPlayer()),
							new SavedDataSyncMessage(1, worlddata));
			}
		}
	}

	public static class WorldVariables extends SavedData {
		public static final String DATA_NAME = "statsgui_worldvars";

		public static WorldVariables load(CompoundTag tag) {
			WorldVariables data = new WorldVariables();
			data.read(tag);
			return data;
		}

		public void read(CompoundTag nbt) {
		}

		@Override
		public CompoundTag save(CompoundTag nbt) {
			return nbt;
		}

		public void syncData(LevelAccessor world) {
			this.setDirty();
			if (world instanceof Level level && !level.isClientSide())
				NarutoRevival.PACKET_HANDLER.send(PacketDistributor.DIMENSION.with(level::dimension), new SavedDataSyncMessage(1, this));
		}

		static WorldVariables clientSide = new WorldVariables();

		public static WorldVariables get(LevelAccessor world) {
			if (world instanceof ServerLevel level) {
				return level.getDataStorage().computeIfAbsent(e -> WorldVariables.load(e), WorldVariables::new, DATA_NAME);
			} else {
				return clientSide;
			}
		}
	}

	public static class MapVariables extends SavedData {
		public static final String DATA_NAME = "statsgui_mapvars";
		public double XP = 0;
		public double chakra = 0;
		public double maxChakra = 100;
		public double maxLvlXp = 10.0;
		public double Lvl = 1.0;
		public double progress = 0;
		public double skillPoints = 0;
		public double jutsuPoints = 0;
		public double ninjutsu = 0;
		public double taijutsu = 0;
		public double genjutsu = 0;
		public double kenjutsu = 0;
		public double shurikenjutsu = 0;
		public double summoning = 0;
		public double kinjutsu = 0;
		public double senjutsu = 0;
		public double medical = 0;
		public double intelligence = 0;
		///////////////////////////////
		public double addninjutsu = 0;
		public double addtaijutsu = 0;
		public double addgenjutsu = 0;
		public double addkenjutsu = 0;
		public double addshurikenjutsu = 0;
		public double addsummoning = 0;
		public double addkinjutsu = 0;
		public double addsenjutsu = 0;
		public double addmedical = 0;
		public double addintelligence = 0;

		public double strength = 0;
		public double agility = 0;
		public double speed = 0;
		public double addstrength = 0;
		public double addagility = 0;
		public double addspeed = 0;
		public double progresspercent = 0;

		public static MapVariables load(CompoundTag tag) {
			MapVariables data = new MapVariables();
			data.read(tag);
			return data;
		}

		public void read(CompoundTag nbt) {
			XP = nbt.getDouble("XP");
			chakra = nbt.getDouble("chakra");
			maxChakra = nbt.getDouble("maxChakra");
			maxLvlXp = nbt.getDouble("maxLvlXp");
			Lvl = nbt.getDouble("Lvl");
			progress = nbt.getDouble("progress");
			skillPoints = nbt.getDouble("skillPoints");
			jutsuPoints = nbt.getDouble("jutsuPoints");

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
			//////////////////////////////////////////////////////
			addninjutsu = nbt.getDouble("addninjutsu");
			addtaijutsu = nbt.getDouble("addtaijutsu");
			addgenjutsu = nbt.getDouble("addgenjutsu");
			addkenjutsu = nbt.getDouble("addkenjutsu");
			addshurikenjutsu = nbt.getDouble("addshurikenjutsu");
			addsummoning = nbt.getDouble("addsummoning");
			addkinjutsu = nbt.getDouble("addkinjutsu");
			addsenjutsu = nbt.getDouble("addsenjutsu");
			addmedical = nbt.getDouble("addmedical");
			addintelligence = nbt.getDouble("addintelligence");


			strength = nbt.getDouble("strength");
			agility = nbt.getDouble("agility");
			speed = nbt.getDouble("speed");
			addstrength = nbt.getDouble("addstrength");
			addagility = nbt.getDouble("addagility");
			addspeed = nbt.getDouble("addspeed");
			progresspercent = nbt.getDouble("progresspercent");
		}

		@Override
		public CompoundTag save(CompoundTag nbt) {
			nbt.putDouble("XP", XP);
			nbt.putDouble("chakra",chakra);
			nbt.putDouble("maxChakra",maxChakra);
			nbt.putDouble("maxLvlXp", maxLvlXp);
			nbt.putDouble("Lvl", Lvl);
			nbt.putDouble("progress", progress);
			nbt.putDouble("skillPoints", skillPoints);
			nbt.putDouble("jutsuPoints",jutsuPoints);

			nbt.putDouble("ninjutsu",ninjutsu);
			nbt.putDouble("taijutsu",taijutsu);
			nbt.putDouble("genjutsu",genjutsu);
			nbt.putDouble("kenjutsu",kenjutsu);
			nbt.putDouble("shurikenjutsu",shurikenjutsu);
			nbt.putDouble("summoning",summoning);
			nbt.putDouble("kinjutsu",kinjutsu);
			nbt.putDouble("senjutsu",senjutsu);
			nbt.putDouble("medical",medical);
			nbt.putDouble("intelligence",intelligence);
			/////////////////////////////////////////////////
			nbt.putDouble("addninjutsu",addninjutsu);
			nbt.putDouble("addtaijutsu",addtaijutsu);
			nbt.putDouble("addgenjutsu",addgenjutsu);
			nbt.putDouble("addkenjutsu",addkenjutsu);
			nbt.putDouble("addshurikenjutsu",addshurikenjutsu);
			nbt.putDouble("addsummoning",addsummoning);
			nbt.putDouble("addkinjutsu",addkinjutsu);
			nbt.putDouble("addsenjutsu",addsenjutsu);
			nbt.putDouble("addmedical",addmedical);
			nbt.putDouble("addintelligence",addintelligence);


			nbt.putDouble("strength", strength);
			nbt.putDouble("agility", agility);
			nbt.putDouble("speed", speed);
			nbt.putDouble("addstrength", addstrength);
			nbt.putDouble("addagility", addagility);
			nbt.putDouble("addspeed", addspeed);
			nbt.putDouble("progresspercent", progresspercent);
			return nbt;
		}

		public void syncData(LevelAccessor world) {
			this.setDirty();
			if (world instanceof Level && !world.isClientSide())
				NarutoRevival.PACKET_HANDLER.send(PacketDistributor.ALL.noArg(), new SavedDataSyncMessage(0, this));
		}

		static MapVariables clientSide = new MapVariables();

		public static MapVariables get(LevelAccessor world) {
			if (world instanceof ServerLevelAccessor serverLevelAcc) {
				return serverLevelAcc.getLevel().getServer().getLevel(Level.OVERWORLD).getDataStorage().computeIfAbsent(e -> MapVariables.load(e),
						MapVariables::new, DATA_NAME);
			} else {
				return clientSide;
			}
		}
	}

	public static class SavedDataSyncMessage {
		public int type;
		public SavedData data;

		public SavedDataSyncMessage(FriendlyByteBuf buffer) {
			this.type = buffer.readInt();
			this.data = this.type == 0 ? new MapVariables() : new WorldVariables();
			if (this.data instanceof MapVariables _mapvars)
				_mapvars.read(buffer.readNbt());
			else if (this.data instanceof WorldVariables _worldvars)
				_worldvars.read(buffer.readNbt());
		}

		public SavedDataSyncMessage(int type, SavedData data) {
			this.type = type;
			this.data = data;
		}

		public static void buffer(SavedDataSyncMessage message, FriendlyByteBuf buffer) {
			buffer.writeInt(message.type);
			buffer.writeNbt(message.data.save(new CompoundTag()));
		}

		public static void handler(SavedDataSyncMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
			NetworkEvent.Context context = contextSupplier.get();
			context.enqueueWork(() -> {
				if (!context.getDirection().getReceptionSide().isServer()) {
					if (message.type == 0)
						MapVariables.clientSide = (MapVariables) message.data;
					else
						WorldVariables.clientSide = (WorldVariables) message.data;
				}
			});
			context.setPacketHandled(true);
		}
	}
}
