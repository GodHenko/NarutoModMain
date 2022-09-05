package com.godhenko.narutorevival.network;

import com.godhenko.narutorevival.NarutoRevival;
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
public class NarutoModVariables {
	@SubscribeEvent
	public static void init(FMLCommonSetupEvent event) {
		NarutoRevival.addNetworkMessage(PlayerVariablesSyncMessage.class, PlayerVariablesSyncMessage::buffer, PlayerVariablesSyncMessage::new,
				PlayerVariablesSyncMessage::handler);
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
			clone.battlepower = original.battlepower;
			clone.XP = original.XP;
			clone.chakra = original.chakra;
			clone.maxChakra = original.maxChakra;
			clone.maxLvlXp = original.maxLvlXp;
			clone.maxIntelligence = original.maxIntelligence;
			clone.Lvl = original.Lvl;
			clone.progress = original.progress;
			clone.progresspercent = original.progresspercent;
			clone.skillPoints = original.skillPoints;
			clone.jutsuPoints = original.jutsuPoints;
			//Stats
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
			//Clans
			clone.clan = original.clan;
			clone.uchiha = original.uchiha;
			clone.hyuga = original.hyuga;
			clone.uzumaki = original.uzumaki;
			clone.aburame = original.aburame;
			clone.akimichi = original.akimichi;
			clone.hatake = original.hatake;
			clone.hozuki = original.hozuki;
			clone.iburi = original.iburi;
			clone.inuzuka = original.inuzuka;
			clone.jugo = original.jugo;
			clone.kaguya = original.kaguya;
			clone.kurama = original.kurama;
			clone.tsuchigumo = original.tsuchigumo;
			clone.nara = original.nara;
			clone.sarutobi = original.sarutobi;
			clone.fuma = original.fuma;
			clone.senju = original.senju;
			clone.yuki = original.yuki;
			clone.yamanaka = original.yamanaka;
			clone.lee = original.lee;
			clone.chinoike = original.chinoike;
			clone.shirogane = original.shirogane;
			//Villages
			clone.village = original.village;
			clone.  konohagakure = original.konohagakure;
			clone.  sunagakure = original.sunagakure;
			clone.  kumogakure =original.kumogakure;
			clone.  iwagakure = original.iwagakure;
			clone.  akatsuki = original.akatsuki;
			clone.  amegakure = original.amegakure;
			clone.  getsugakure = original.getsugakure;
			clone.  hoshigakure =original.hoshigakure;
			clone.  ishigakure = original.ishigakure;
			clone.  jomae = original.jomae;
			clone.  kirigakure = original.kirigakure;
			clone.  kusagakure = original.kusagakure;
			clone.  nadeshiko = original.nadeshiko;
			clone.  otagakure = original.otagakure;
			clone.  ryuchi_cave = original.ryuchi_cave;
			clone.  shimogakure = original.shimogakure;
			clone.  takigaure = original.takigaure;
			clone.  takumi = original.takumi;
			clone.  tanigakure = original.tanigakure;
			clone.  mount_myoboku = original.mount_myoboku;
			clone.  yugagakure = original.yugagakure;
			clone.  yukigakure =original.yukigakure;
			clone.  yumegakure = original.yumegakure;
			clone.  shikotsu = original.shikotsu;
			//Rank
			clone. rank = original.rank;
			clone. academy_student = original.academy_student;
			clone. genin = original.genin;
			clone. chunin = original.chunin;
			clone. jonin = original.jonin;
			clone. anbu = original.anbu;
			clone. kazekage = original.kazekage;
			//Natures
			clone. fire = original.fire;
			clone. wind = original.wind;
			clone. earth = original.earth;
			clone. lightning = original.lightning;
			clone. water = original.water;
			//nature learners
			clone. fire_learner = original.fire_learner;
			//Land
			clone. land = original.land;
			clone. land_of_earth = original.land_of_earth;
			clone. land_of_fire = original.land_of_fire;
			clone. land_of_iron = original.land_of_iron;
			clone. land_of_lightning = original.land_of_lightning;
			clone. land_of_sky = original.land_of_sky;
			clone. land_of_snow = original.land_of_snow;
			clone. land_of_sound = original.land_of_sound;
			clone. land_of_water = original.land_of_water;
			clone. land_of_wind = original.land_of_wind;



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
				event.addCapability(new ResourceLocation("stats", "player_variables"), new PlayerVariablesProvider());
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

		public void syncPlayerVariables(Entity entity) {
			if (entity instanceof ServerPlayer serverPlayer)
				NarutoRevival.PACKET_HANDLER.send(PacketDistributor.PLAYER.with(() -> serverPlayer), new PlayerVariablesSyncMessage(this));
		}

		public Tag writeNBT() {
			CompoundTag nbt = new CompoundTag();
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

		public void readNBT(Tag Tag) {
			CompoundTag nbt = (CompoundTag) Tag;
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
					variables.battlepower = message.data.battlepower;
					variables.XP = message.data.XP;
					variables.chakra = message.data.chakra;
					variables.maxChakra = message.data.maxChakra;
					variables.maxLvlXp = message.data.maxLvlXp;
					variables.maxIntelligence = message.data.maxIntelligence;
					variables.Lvl = message.data.Lvl;
					variables.progress = message.data.progress;
					variables.progresspercent = message.data.progresspercent;
					variables.skillPoints = message.data.skillPoints;
					variables.jutsuPoints = message.data.jutsuPoints;
					//Stats
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
					//Clans
					variables.clan = message.data.clan;
					variables.uchiha = message.data.uchiha;
					variables.hyuga = message.data.hyuga;
					variables.uzumaki = message.data.uzumaki;
					variables.aburame = message.data.aburame;
					variables.akimichi = message.data.akimichi;
					variables.hatake = message.data.hatake;
					variables.hozuki = message.data.hozuki;
					variables.iburi = message.data.iburi;
					variables.inuzuka = message.data.inuzuka;
					variables.jugo = message.data.jugo;
					variables.kaguya = message.data.kaguya;
					variables.kurama = message.data.kurama;
					variables.tsuchigumo = message.data.tsuchigumo;
					variables.nara = message.data.nara;
					variables.sarutobi = message.data.sarutobi;
					variables.fuma = message.data.fuma;
					variables.senju = message.data.senju;
					variables.yuki = message.data.yuki;
					variables.yamanaka = message.data.yamanaka;
					variables.lee = message.data.lee;
					variables.chinoike = message.data.chinoike;
					variables.shirogane = message.data.shirogane;
					//Villages
					variables.village = message.data.village;
					variables.  konohagakure = message.data.konohagakure;
					variables.  sunagakure = message.data.sunagakure;
					variables.  kumogakure =message.data.kumogakure;
					variables.  iwagakure = message.data.iwagakure;
					variables.  akatsuki = message.data.akatsuki;
					variables.  amegakure = message.data.amegakure;
					variables.  getsugakure = message.data.getsugakure;
					variables.  hoshigakure =message.data.hoshigakure;
					variables.  ishigakure = message.data.ishigakure;
					variables.  jomae = message.data.jomae;
					variables.  kirigakure = message.data.kirigakure;
					variables.  kusagakure = message.data.kusagakure;
					variables.  nadeshiko = message.data.nadeshiko;
					variables.  otagakure = message.data.otagakure;
					variables.  ryuchi_cave = message.data.ryuchi_cave;
					variables.  shimogakure = message.data.shimogakure;
					variables.  takigaure = message.data.takigaure;
					variables.  takumi = message.data.takumi;
					variables.  tanigakure = message.data.tanigakure;
					variables.  mount_myoboku = message.data.mount_myoboku;
					variables.  yugagakure = message.data.yugagakure;
					variables.  yukigakure =message.data.yukigakure;
					variables.  yumegakure = message.data.yumegakure;
					variables.  shikotsu = message.data.shikotsu;
					//Rank
					variables. rank = message.data.rank;
					variables. academy_student = message.data.academy_student;
					variables. genin = message.data.genin;
					variables. chunin = message.data.chunin;
					variables. jonin = message.data.jonin;
					variables. anbu = message.data.anbu;
					variables. kazekage = message.data.kazekage;
					//Natures
					variables. fire = message.data.fire;
					variables. wind = message.data.wind;
					variables. earth = message.data.earth;
					variables. lightning = message.data.lightning;
					variables. water = message.data.water;
					//nature learners
					variables. fire_learner = message.data.fire_learner;
					//Land
					variables. land = message.data.land;
					variables. land_of_earth = message.data.land_of_earth;
					variables. land_of_fire = message.data.land_of_fire;
					variables. land_of_iron = message.data.land_of_iron;
					variables. land_of_lightning = message.data.land_of_lightning;
					variables. land_of_sky = message.data.land_of_sky;
					variables. land_of_snow = message.data.land_of_snow;
					variables. land_of_sound = message.data.land_of_sound;
					variables. land_of_water = message.data.land_of_water;
					variables. land_of_wind = message.data.land_of_wind;
				}
			});
			context.setPacketHandled(true);
		}
	}
}
