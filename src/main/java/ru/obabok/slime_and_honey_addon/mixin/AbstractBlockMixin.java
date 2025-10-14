package ru.obabok.slime_and_honey_addon.mixin;

import net.minecraft.block.AbstractBlock;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(AbstractBlock.class)
public interface AbstractBlockMixin {
    @Mutable
    @Accessor("slipperiness")
    void setSlipperiness(float friction);

    @Mutable
    @Accessor("velocityMultiplier")
    void setVelocityMultiplier(float friction);

    @Mutable
    @Accessor("jumpVelocityMultiplier")
    void setJumpVelocityMultiplier(float friction);
}
