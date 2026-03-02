package com.example.examplemod.Tools;

import net.minecraft.core.BlockPos;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;

public class customShovel extends ShovelItem {
    public customShovel() {
        super(Tiers.DIAMOND, 0,0, new Item.Properties().tab(CreativeModeTab.TAB_TOOLS));
    }

    //GOAL: Get a circular hole of radius 2. O is the center, * are the blocks that I want to remove

    //          ***
    //         *****
    //         **O**
    //         *****
    //          ***


    @Override
    public boolean mineBlock(ItemStack stack, Level world, BlockState state, BlockPos pos, LivingEntity player) {
        boolean originalResult = super.mineBlock(stack, world, state, pos, player);

        if (!world.isClientSide && !player.isShiftKeyDown()) {
            int radius = 2;

            //Loop through a 5x5 area
            for (int x = -radius; x <= radius; x++) {
                for (int z = -radius; z <= radius; z++) {

                    //Check if we are at a corner (Absolute X is 2 AND Absolute Z is 2)
                    boolean isCorner = (Math.abs(x) == radius && Math.abs(z) == radius);

                    if (!isCorner) {
                        BlockPos targetPos = pos.offset(x, 0, z);
                        BlockState targetState = world.getBlockState(targetPos);

                        // 2. Make sure we don't re-mine the center or break non-dirt blocks
                        if (targetState.is(BlockTags.MINEABLE_WITH_SHOVEL) && !targetPos.equals(pos)) {
                            world.destroyBlock(targetPos, true, player);
                        }
                    }
                }
            }
        }
        return originalResult;
    }
}
