package com.example.examplemod;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.*;

public class customSword extends SwordItem {
    public customSword(){
        super(Tiers.DIAMOND, 5, -2.5F, new Item.Properties().tab(CreativeModeTab.TAB_COMBAT));
    }

    @Override
    public boolean hurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        // Calculate the horizontal push
        double xPush = attacker.getX() - target.getX();
        double zPush = attacker.getZ() - target.getZ();

        // 0.5D is a solid 'Player Jump' height.
        // We add your ratio logic to it so it scales with distance, but never hits zero.
        double yLaunch = (Math.abs(xPush) + Math.abs(zPush)) / 8;

        target.setDeltaMovement(-xPush, yLaunch, -zPush);
        target.hurtMarked = true;

        return super.hurtEnemy(stack, target, attacker);
    }
}
