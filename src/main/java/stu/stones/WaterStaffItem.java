package stu.stones;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LightningEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.WaterFluid;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class WaterStaffItem extends Item {


    public WaterStaffItem(Settings settings){
        super(settings);

    }

    @Override
    public ActionResult use(World world, PlayerEntity user, Hand hand) {

        // This is to prevent desync.
        if (world.isClient) {
            return ActionResult.PASS;
        }

        BlockPos frontOfPlayer = user.getBlockPos().offset(user.getHorizontalFacing(), 2);

        // Spawn the water.
        user.swingHand(hand, true);
        world.setBlockState(frontOfPlayer, Blocks.WATER.getDefaultState());

        ItemStack staff = user.getStackInHand(hand);
        staff.damage(1, user, EquipmentSlot.MAINHAND);


        return ActionResult.SUCCESS;
    }

}
