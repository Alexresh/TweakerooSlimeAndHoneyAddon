package ru.obabok.slime_and_honey_addon.client;

import fi.dy.masa.tweakeroo.config.Configs;
import net.fabricmc.api.ClientModInitializer;
import net.minecraft.world.level.block.Blocks;
import ru.obabok.slime_and_honey_addon.mixin.AbstractBlockMixin;

public class SlimeAndHoneyAddonClient implements ClientModInitializer {

    //slime
    private final float originalSlimeFriction = Blocks.SLIME_BLOCK.getFriction();
    private final float originalSlimeSpeedFactor = Blocks.SLIME_BLOCK.getSpeedFactor();
    private final float originalSlimeBounceRestitution = Blocks.SLIME_BLOCK.getBounceRestitution();

    //honey
    private final float originalHoneyFriction = Blocks.HONEY_BLOCK.getFriction();
    private final float originalHoneySpeedFactor = Blocks.HONEY_BLOCK.getSpeedFactor();
    private final float originalHoneyBounceRestitution = Blocks.HONEY_BLOCK.getBounceRestitution();
    private final float originalHoneyJumpFactor = Blocks.HONEY_BLOCK.getJumpFactor();

    @Override
    public void onInitializeClient() {
        Configs.Disable.DISABLE_SLIME_BLOCK_SLOWDOWN.setValueChangeCallback(noSlowdown -> {
            if(noSlowdown.getBooleanValue()){
                //slime
                ((AbstractBlockMixin) Blocks.SLIME_BLOCK).setFriction(Blocks.STONE.getFriction());
                ((AbstractBlockMixin) Blocks.SLIME_BLOCK).setSpeedFactor(Blocks.STONE.getSpeedFactor());
                ((AbstractBlockMixin) Blocks.SLIME_BLOCK).setBounceRestitution(Blocks.STONE.getBounceRestitution());

                //honey
                ((AbstractBlockMixin) Blocks.HONEY_BLOCK).setFriction(Blocks.STONE.getFriction());
                ((AbstractBlockMixin) Blocks.HONEY_BLOCK).setSpeedFactor(Blocks.STONE.getSpeedFactor());
                ((AbstractBlockMixin) Blocks.HONEY_BLOCK).setBounceRestitution(Blocks.STONE.getBounceRestitution());
                ((AbstractBlockMixin) Blocks.HONEY_BLOCK).setJumpFactor(Blocks.STONE.getJumpFactor());
            }else {
                //slime
                ((AbstractBlockMixin) Blocks.SLIME_BLOCK).setFriction(originalSlimeFriction);
                ((AbstractBlockMixin) Blocks.SLIME_BLOCK).setBounceRestitution(originalSlimeSpeedFactor);
                ((AbstractBlockMixin) Blocks.SLIME_BLOCK).setSpeedFactor(originalSlimeBounceRestitution);

                //honey
                ((AbstractBlockMixin) Blocks.HONEY_BLOCK).setFriction(originalHoneyFriction);
                ((AbstractBlockMixin) Blocks.HONEY_BLOCK).setSpeedFactor(originalHoneySpeedFactor);
                ((AbstractBlockMixin) Blocks.HONEY_BLOCK).setBounceRestitution(originalHoneyBounceRestitution);
                ((AbstractBlockMixin) Blocks.HONEY_BLOCK).setJumpFactor(originalHoneyJumpFactor);
            }
        });
    }
}
