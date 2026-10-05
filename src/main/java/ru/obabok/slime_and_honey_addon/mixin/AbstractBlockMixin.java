package ru.obabok.slime_and_honey_addon.mixin;

import net.minecraft.world.level.block.state.BlockBehaviour;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(BlockBehaviour.class)
public interface AbstractBlockMixin {
    @Mutable
    @Accessor("friction")
    void setFriction(float friction);

    @Mutable
    @Accessor("speedFactor")
    void setSpeedFactor(float speedFactor);

    @Mutable
    @Accessor("bounceRestitution")
    void setBounceRestitution(float bounceRestitution);

    @Mutable
    @Accessor("jumpFactor")
    void setJumpFactor(float jumpFactor);

}
