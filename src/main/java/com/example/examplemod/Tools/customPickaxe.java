package com.example.examplemod.Tools;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;

public class customPickaxe extends PickaxeItem {

    public customPickaxe(){
        super(Tiers.DIAMOND, 0, 2.5F, new Item.Properties().tab(CreativeModeTab.TAB_TOOLS));
    }

    @Override
    public boolean mineBlock(ItemStack stack, Level world, BlockState block, BlockPos position, LivingEntity player) {
        boolean originalResult = super.mineBlock(stack, world, block, position, player);

        // 1. Is this the real world (Server) and is the block NOT instant-break (like grass)?
        if (!world.isClientSide) {
            BlockPos blockPosUnder = position.below();
            BlockState stateUnder = world.getBlockState(blockPosUnder);

            if(!stateUnder.isAir() && stateUnder.getDestroySpeed(world, blockPosUnder)!=-1F){
                world.destroyBlock(blockPosUnder, true, player);
                //Voluntarily not take away a damage point

            }
        }

        return originalResult;
    }


}
