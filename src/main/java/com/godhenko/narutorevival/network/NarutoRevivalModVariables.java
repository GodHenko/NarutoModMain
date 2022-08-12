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
		public double battlepower = 0;
		public double XP = 0;
		public double chakra = 0;
		public double maxChakra = 100;
		public double maxLvlXp = 10.0;
		public double maxIntelligence = 100;
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

		//Clans
		public double clan = 0;
		public double uchiha = 1;
		public double hyuga = 2;
		public double uzumaki = 3;
		public double aburame  =4;
		public double akimichi  =5;
		public double hatake  =6;
		public double hozuki  =7;
		public double iburi  =8;
		public double inuzuka  =9;
		public double jugo  =10;
		public double kaguya  =11;
		public double kurama  =12;
		public double tsuchigumo  =13;
		public double nara  =14;
		public double sarutobi  =15;
		public double fuma  =16;
		public double senju  =17;
		public double yuki  = 18;
		public double yamanaka  =19;
		public double lee  =20;
		public double chinoike  =21;
		public double shirogane  =22;

		//Villages
		public double village = 0;
		public double konohagakure = 1;
		public double sunagakure = 2;
		public double kumogakure = 3;
		public double iwagakure = 4;
		public double akatsuki = 5;
		public double amegakure = 6;
		public double getsugakure = 7;
		public double hoshigakure = 8;
		public double ishigakure = 9;
		public double jomae = 10;
		public double kirigakure = 11;
		public double kusagakure = 12;
		public double nadeshiko = 13;
		public double otagakure = 14;
		public double ryuchi_cave = 15;
		public double shimogakure = 16;
		public double takigaure = 17;
		public double takumi = 18;
		public double tanigakure = 19;
		public double mount_myoboku = 20;
		public double yugagakure = 21;
		public double yukigakure = 22;
		public double yumegakure = 23;
		public double shikotsu = 24;

		//Rank
		public double rank = 0;
		public double academy_student = 1;
		public double genin = 2;
		public double chunin = 3;
		public double jonin = 4;
		public double anbu = 5;
		public double kazekage = 6;
		//Natures
		public double fire = 0;
		public double wind = 0;
		public double earth = 0;
		public double lightning = 0;
		public double water = 0;
		//nature learners
		public double fire_learner = 0;
		//Land
		public double land = 0;
		public double land_of_earth = 1;
		public double land_of_fire = 2;
		public double land_of_iron = 3;
		public double land_of_lightning = 4;
		public double land_of_sky = 5;
		public double land_of_snow = 6;
		public double land_of_sound = 7;
		public double land_of_water = 8;
		public double land_of_wind = 9;



		public static MapVariables load(CompoundTag tag) {
			MapVariables data = new MapVariables();
			data.read(tag);
			return data;
		}

		public void read(CompoundTag nbt) {
			battlepower = nbt.getDouble("battlepower");
			XP = nbt.getDouble("XP");
			chakra = nbt.getDouble("chakra");
			maxChakra = nbt.getDouble("maxChakra");
			maxLvlXp = nbt.getDouble("maxLvlXp");
			maxIntelligence = nbt.getDouble("maxIntelligence");
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

			//clans
			clan = nbt.getDouble("clan");
			uchiha = nbt.getDouble("uchiha");
			hyuga = nbt.getDouble("hyuga");
			uzumaki = nbt.getDouble("uzumaki");
			aburame = nbt.getDouble("aburame");
			akimichi = nbt.getDouble("akimichi");
			hatake = nbt.getDouble("hatake");
			hozuki = nbt.getDouble("hozuki");
			iburi = nbt.getDouble("iburi");
			inuzuka = nbt.getDouble("inuzuka");
			jugo = nbt.getDouble("jugo");
			kaguya = nbt.getDouble("kaguya");
			kurama = nbt.getDouble("kurama");
			tsuchigumo = nbt.getDouble("tsuchigumo");
			nara = nbt.getDouble("nara");
			sarutobi = nbt.getDouble("sarutobi");
			fuma = nbt.getDouble("fuma");
			senju = nbt.getDouble("senju");
			yuki = nbt.getDouble("yuki");
			yamanaka = nbt.getDouble("yamanaka");
			lee = nbt.getDouble("lee");
			chinoike = nbt.getDouble("chinoike");
			shirogane = nbt.getDouble("shirogane");
			//villages
			village = nbt.getDouble("village");
			konohagakure = nbt.getDouble("konohagakure");
			sunagakure = nbt.getDouble("sunagakure");
			kirigakure = nbt.getDouble("kirigakure");
			kumogakure = nbt.getDouble("kumogakure");
			iwagakure = nbt.getDouble("iwagakure");
			akatsuki = nbt.getDouble("akatsuki");
			amegakure = nbt.getDouble("amegakure");
			getsugakure = nbt.getDouble("getsugakure");
			hoshigakure = nbt.getDouble("hoshigakure");
			ishigakure = nbt.getDouble("ishigakure");
			jomae = nbt.getDouble("jomae");
			kirigakure = nbt.getDouble("kirigakure");
			kusagakure = nbt.getDouble("kusagakure");
			nadeshiko = nbt.getDouble("nadeshiko");
			otagakure = nbt.getDouble("otagakure");
			ryuchi_cave = nbt.getDouble("ryuchi_cave");
			shimogakure = nbt.getDouble("shimogakure");
			takigaure = nbt.getDouble("takigaure");
			takumi = nbt.getDouble("takumi");
			tanigakure = nbt.getDouble("tanigakure");
			mount_myoboku = nbt.getDouble("mount_myoboku");
			yugagakure = nbt.getDouble("yugagakure");
			yukigakure = nbt.getDouble("yukigakure");
			yumegakure = nbt.getDouble("yumegakure");
			shikotsu = nbt.getDouble("shikotsu");
			//Rank
			rank = nbt.getDouble("rank");
			academy_student = nbt.getDouble("academy_student");
			genin = nbt.getDouble("genin");
			chunin = nbt.getDouble("chunin");
			jonin = nbt.getDouble("jonin");
			kazekage = nbt.getDouble("kazekage");

			//Natures
			fire = nbt.getDouble("fire");
			wind = nbt.getDouble("wind");
			earth = nbt.getDouble("earth");
			lightning = nbt.getDouble("lightning");
			water = nbt.getDouble("water");
			//Nature Learners
			fire_learner = nbt.getDouble("fire_learner");
			//Land
			land_of_earth = nbt.getDouble("land_of_earth");
			land_of_fire = nbt.getDouble("land_of_fire");
			land_of_iron = nbt.getDouble("land_of_iron");
			land_of_lightning = nbt.getDouble("land_of_lightning");
			land_of_sky = nbt.getDouble("land_of_sky");
			land_of_snow = nbt.getDouble("land_of_snow");
			land_of_sound = nbt.getDouble("land_of_sound");
			land_of_water = nbt.getDouble("land_of_water");
			land_of_wind = nbt.getDouble("land_of_wind");



		}

		@Override
		public CompoundTag save(CompoundTag nbt) {
			nbt.putDouble("battlepower",battlepower);
			nbt.putDouble("XP", XP);
			nbt.putDouble("chakra",chakra);
			nbt.putDouble("maxChakra",maxChakra);
			nbt.putDouble("maxLvlXp", maxLvlXp);
			nbt.putDouble("maxIntelligence",maxIntelligence);
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

			//Clans
			nbt.putDouble("clan",clan);
			nbt.putDouble("uchiha",uchiha);
			nbt.putDouble("hyuga",hyuga);
			nbt.putDouble("uzumaki",uzumaki);
			nbt.putDouble("aburame",aburame);
			nbt.putDouble("akimichi",akimichi);
			nbt.putDouble("hatake",hatake);
			nbt.putDouble("hozuki",hozuki);
			nbt.putDouble("iburi",iburi);
			nbt.putDouble("inuzuka",inuzuka);
			nbt.putDouble("jugo",jugo);
			nbt.putDouble("kaguya",kaguya);
			nbt.putDouble("kurama",kurama);
			nbt.putDouble("tsuchigumo",tsuchigumo);
			nbt.putDouble("nara",nara);
			nbt.putDouble("sarutobi",sarutobi);
			nbt.putDouble("fuma",fuma);
			nbt.putDouble("senju",senju);
			nbt.putDouble("yuki",yuki);
			nbt.putDouble("yamanaka",yamanaka);
			nbt.putDouble("lee",lee);
			nbt.putDouble("chinoike",chinoike);
			nbt.putDouble("shirogane",shirogane);

			//Natures
			nbt.putDouble("fire",fire);
			nbt.putDouble("water",water);
			nbt.putDouble("wind",wind);
			nbt.putDouble("earth",earth);
			nbt.putDouble("lightning",lightning);
			//Nature learners
			nbt.putDouble("fire_learner",fire_learner);
			//Village
			nbt.putDouble("village",village);
			nbt.putDouble("konohagakure",konohagakure);
			nbt.putDouble("sunagakure",sunagakure);
			nbt.putDouble("kirigakure",kirigakure);
			nbt.putDouble("kumogakure",kumogakure);
			nbt.putDouble("iwagakure",iwagakure);
			nbt.putDouble("akatsuki",akatsuki);
			nbt.putDouble("amegakure",amegakure);
			nbt.putDouble("getsugakure",getsugakure);
			nbt.putDouble("hoshigakure",hoshigakure);
			nbt.putDouble("ishigakure",ishigakure);
			nbt.putDouble("jomae",jomae);
			nbt.putDouble("kirigakure",kirigakure);
			nbt.putDouble("kusagakure",kusagakure);
			nbt.putDouble("nadeshiko",nadeshiko);
			nbt.putDouble("otagakure",otagakure);
			nbt.putDouble("ryuchi_cave",ryuchi_cave);
			nbt.putDouble("shimogakure",shimogakure);
			nbt.putDouble("takigaure",takigaure);
			nbt.putDouble("takumi",takumi);
			nbt.putDouble("tanigakure",tanigakure);
			nbt.putDouble("mount_myoboku",mount_myoboku);
			nbt.putDouble("yugagakure",yugagakure);
			nbt.putDouble("yukigakure",yukigakure);
			nbt.putDouble("yumegakure",yumegakure);
			nbt.putDouble("shikotsu",shikotsu);
			//Rank
			nbt.putDouble("rank",rank);
			nbt.putDouble("academy_student",academy_student);
			nbt.putDouble("genin",genin);
			nbt.putDouble("chunin",chunin);
			nbt.putDouble("jonin",jonin);
			nbt.putDouble("kazekage",kazekage);
			//Land
			nbt.putDouble("land",land);
			nbt.putDouble("land_of_earth",land_of_earth);
			nbt.putDouble("land_of_fire",land_of_fire);
			nbt.putDouble("land_of_iron",land_of_iron);
			nbt.putDouble("land_of_lightning",land_of_lightning);
			nbt.putDouble("land_of_sky",land_of_sky);
			nbt.putDouble("land_of_snow",land_of_snow);
			nbt.putDouble("land_of_sound",land_of_sound);
			nbt.putDouble("land_of_water",land_of_water);
			nbt.putDouble("land_of_wind",land_of_wind);

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
