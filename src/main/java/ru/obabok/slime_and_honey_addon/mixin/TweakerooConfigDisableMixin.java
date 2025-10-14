package ru.obabok.slime_and_honey_addon.mixin;

import com.google.common.collect.ImmutableList;
import fi.dy.masa.malilib.config.IHotkeyTogglable;
import fi.dy.masa.malilib.config.options.ConfigBooleanHotkeyed;
import fi.dy.masa.tweakeroo.config.Configs;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.ArrayList;
import java.util.List;

@Mixin(Configs.Disable.class)
public class TweakerooConfigDisableMixin {
    @Shadow(remap = false)
    @Final
    @Mutable
    public static ConfigBooleanHotkeyed DISABLE_SLIME_BLOCK_SLOWDOWN;

    @Shadow(remap = false)
    @Final
    @Mutable
    public static ImmutableList<IHotkeyTogglable> OPTIONS;

    @Inject(method = "<clinit>", at = @At("RETURN"))
    private static void onClinit(CallbackInfo ci) {
        ConfigBooleanHotkeyed oldConfig = DISABLE_SLIME_BLOCK_SLOWDOWN;

        ConfigBooleanHotkeyed newConfig = new ConfigBooleanHotkeyed(
                "disableSlimeHoneyBlockBehavior", false, ""
        ).apply("slimehoney.config.disable");

        List<IHotkeyTogglable> newOptionsList = new ArrayList<>();
        for (IHotkeyTogglable option : OPTIONS) {
            if (option == oldConfig) {
                newOptionsList.add(newConfig);
            } else {
                newOptionsList.add(option);
            }
        }
        OPTIONS = ImmutableList.copyOf(newOptionsList);

        DISABLE_SLIME_BLOCK_SLOWDOWN = newConfig;
    }

}
