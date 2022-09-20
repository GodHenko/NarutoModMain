package com.godhenko.narutorevival.procedures.chakra;

import com.godhenko.narutorevival.NarutoRevival;
import com.godhenko.narutorevival.inits.KeyMappingsInit;
import com.godhenko.narutorevival.network.NarutoRevivalModVariables;
import net.minecraft.client.Minecraft;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.living.LivingDamageEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.lwjgl.glfw.GLFW;

@Mod.EventBusSubscriber(modid = NarutoRevival.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT)
public class ChakraControl {

    boolean controlOn = false;

    @SubscribeEvent
    public static void onPlayerTick(TickEvent.PlayerTickEvent e) {
        if(KeyMappingsInit.isChakraControlActive) {
            Player player = e.player;
            Level world = e.player.level;


            //Water walking
            BlockState blockState = player.getCommandSenderWorld().getBlockState(player.blockPosition());
            if (blockState.getMaterial() == Material.WATER && !player.isInWater() || blockState.getBlock() == Blocks.SEAGRASS && !player.isInWater()) {
                Vec3 vel = player.getDeltaMovement();
                player.setDeltaMovement( vel.x(),0,vel.z());
            }


            //Wall Climbing (spider)
            if (player.horizontalCollision) {
                Vec3 vel = player.getDeltaMovement();
                player.setDeltaMovement(vel.x(), 0.2 + ((player.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                        .orElse(new NarutoRevivalModVariables.PlayerVariables())).speed)/100, vel.z());
            }
        }
    }


    //Double jump
    private static boolean haveJumped=false;
    @SubscribeEvent
    public static void onSpacePressed(InputEvent.KeyInputEvent e)
    {

        if(Minecraft.getInstance().player == null)
        {
            return;
        }

        if(KeyMappingsInit.isChakraControlActive) {
            Level world = Minecraft.getInstance().player.level;
            Player player = Minecraft.getInstance().player;
            if (e.getKey() == GLFW.GLFW_KEY_SPACE && e.getAction() == GLFW.GLFW_RELEASE && haveJumped == false && !player.isOnGround()) {
                Vec3 vel = player.getDeltaMovement();
                final double yPosition = vel.y();
                player.setDeltaMovement(vel.x(), 0.4 + ((player.getCapability(NarutoRevivalModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                        .orElse(new NarutoRevivalModVariables.PlayerVariables())).speed)/50, vel.z());
                haveJumped = true;
            } else if (player.isOnGround()) {
                haveJumped = false;
            }
        }
    }


    @SubscribeEvent
    public static void cancelFallDamagesEvent(LivingDamageEvent e){
        if(KeyMappingsInit.isChakraControlActive && e.getSource() == DamageSource.FALL){
            e.setCanceled(true);
        }
    }
}
