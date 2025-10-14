package ru.obabok.slime_and_honey_addon.mixin;

import fi.dy.masa.tweakeroo.config.Configs;
import net.minecraft.block.SlimeBlock;
import net.minecraft.block.TranslucentBlock;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.BlockView;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;


@Mixin(SlimeBlock.class)
public abstract class SlimeBlockMixin extends TranslucentBlock
{
    public SlimeBlockMixin(Settings settings)
    {
        super(settings);
    }

    @Inject(method = "onEntityLand", at = @At("HEAD"), cancellable = true)
    private void onEntityLand(BlockView world, Entity entity, CallbackInfo ci){
        if(Configs.Disable.DISABLE_SLIME_BLOCK_SLOWDOWN.getBooleanValue() && entity instanceof PlayerEntity){
            super.onEntityLand(world, entity);
            ci.cancel();
        }
    }
}