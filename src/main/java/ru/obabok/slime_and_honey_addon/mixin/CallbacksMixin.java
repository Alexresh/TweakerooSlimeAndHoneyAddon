package ru.obabok.slime_and_honey_addon.mixin;

import fi.dy.masa.malilib.config.options.ConfigBoolean;
import fi.dy.masa.tweakeroo.config.Callbacks;
import net.minecraft.block.Blocks;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Callbacks.FeatureCallbackSlime.class)
public class CallbacksMixin {
    @Unique
    private float originalHoneySlipperiness;
    @Unique
    private float originalHoneyJumpVelocity;
    @Unique
    private float originalHoneyVelocity;

    @Inject(method = "<init>", at = @At("RETURN"), remap = false)
    private void init(ConfigBoolean feature, CallbackInfo ci){
        originalHoneySlipperiness = Blocks.HONEY_BLOCK.getSlipperiness();
        originalHoneyJumpVelocity = Blocks.HONEY_BLOCK.getJumpVelocityMultiplier();
        originalHoneyVelocity = Blocks.HONEY_BLOCK.getVelocityMultiplier();
        if (feature.getBooleanValue())
        {
            ((AbstractBlockMixin) Blocks.HONEY_BLOCK).setSlipperiness(Blocks.STONE.getSlipperiness());
            ((AbstractBlockMixin)Blocks.HONEY_BLOCK).setJumpVelocityMultiplier(Blocks.STONE.getJumpVelocityMultiplier());
            ((AbstractBlockMixin)Blocks.HONEY_BLOCK).setVelocityMultiplier(Blocks.STONE.getVelocityMultiplier());
        }
    }
    @Inject(method = "onValueChanged(Lfi/dy/masa/malilib/config/options/ConfigBoolean;)V", at = @At("RETURN"), remap = false)
    public void onValueChange(ConfigBoolean config, CallbackInfo ci){
        if (config.getBooleanValue())
        {
            ((AbstractBlockMixin) Blocks.HONEY_BLOCK).setSlipperiness(Blocks.STONE.getSlipperiness());
            ((AbstractBlockMixin) Blocks.HONEY_BLOCK).setVelocityMultiplier(Blocks.STONE.getVelocityMultiplier());
            ((AbstractBlockMixin) Blocks.HONEY_BLOCK).setJumpVelocityMultiplier(Blocks.STONE.getJumpVelocityMultiplier());
        }
        else
        {
            ((AbstractBlockMixin) Blocks.HONEY_BLOCK).setSlipperiness(originalHoneySlipperiness);
            ((AbstractBlockMixin) Blocks.HONEY_BLOCK).setVelocityMultiplier(originalHoneyVelocity);
            ((AbstractBlockMixin) Blocks.HONEY_BLOCK).setJumpVelocityMultiplier(originalHoneyJumpVelocity);
        }
    }
}
