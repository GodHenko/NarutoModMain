package com.godhenko.narutorevival.inits;

import com.godhenko.narutorevival.network.BackpackMenu;
import com.godhenko.narutorevival.network.RyoguiMenu;
import com.godhenko.narutorevival.world.inventory.StatsMenu;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.network.IContainerFactory;

import java.util.ArrayList;
import java.util.List;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class MenusInit {
    private static final List<MenuType<?>> REGISTRY = new ArrayList<>();
    public static final MenuType<StatsMenu> STATS = register("stats", (id, inv, extraData) -> new StatsMenu(id, inv, extraData));
    public static final MenuType<BackpackMenu> BACKPACK = register("backpack", (id, inv, extraData) -> new BackpackMenu(id, inv, extraData));
    public static final MenuType<RyoguiMenu> RYOGUI = register("ryogui", (id, inv, extraData) -> new RyoguiMenu(id, inv, extraData));


    private static <T extends AbstractContainerMenu> MenuType<T> register(String registryname, IContainerFactory<T> containerFactory) {
        MenuType<T> menuType = new MenuType<T>(containerFactory);
        menuType.setRegistryName(registryname);
        REGISTRY.add(menuType);
        return menuType;
    }

    @SubscribeEvent
    public static void registerContainers(RegistryEvent.Register<MenuType<?>> event) {
        event.getRegistry().registerAll(REGISTRY.toArray(new MenuType[0]));
    }
}
