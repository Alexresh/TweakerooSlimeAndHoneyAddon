package ru.obabok.slime_and_honey_addon.mixin;

import fi.dy.masa.tweakeroo.config.Configs;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Configs.class)
public class TweakerooConfigMixin {
    @Inject(method = "loadFromFile", at = @At("RETURN"), remap = false)
    private static void loadConfig(CallbackInfo ci){
        Configs.Disable.DISABLE_SLIME_BLOCK_SLOWDOWN.onValueChanged();
    }
}
