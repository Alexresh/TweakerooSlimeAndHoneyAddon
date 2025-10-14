package ru.obabok.slime_and_honey_addon.mixin;

import fi.dy.masa.tweakeroo.config.Configs;
import net.minecraft.block.HoneyBlock;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(HoneyBlock.class)
public class HoneyBlockMixin {
    @Inject(method = "addCollisionEffects",at = @At("HEAD"), cancellable = true)
    private void addColision(World world, Entity entity, CallbackInfo ci){
        if(Configs.Disable.DISABLE_SLIME_BLOCK_SLOWDOWN.getBooleanValue() && entity instanceof PlayerEntity){
            ci.cancel();
        }
    }

}
