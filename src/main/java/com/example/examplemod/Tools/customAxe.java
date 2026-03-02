package com.example.examplemod.Tools;

import net.minecraft.core.BlockPos;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;

public class customAxe extends AxeItem {

    public customAxe(){
        super(Tiers.DIAMOND, 0,0, new Item.Properties().tab(CreativeModeTab.TAB_TOOLS));
    }

    @Override
    public boolean mineBlock(ItemStack stack, Level world, BlockState block, BlockPos position, LivingEntity player) {
        boolean originalResult = super.mineBlock(stack, world, block, position, player);

        BlockPos positionAbove = position.above();
        while(world.getBlockState(positionAbove).is(BlockTags.LOGS) && !player.isShiftKeyDown()){
            world.destroyBlock(positionAbove, true, player);
            positionAbove = positionAbove.above();
        }

        BlockPos positionUnder = position.below();
        while(world.getBlockState(positionUnder).is(BlockTags.LOGS) && !player.isShiftKeyDown()){
            world.destroyBlock(positionUnder, true, player);
            positionUnder = positionUnder.below();
        }
        return originalResult;
    }
}
