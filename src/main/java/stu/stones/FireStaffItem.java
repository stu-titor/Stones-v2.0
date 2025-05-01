package stu.stones;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LightningEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.FireballEntity;
import net.minecraft.item.FireChargeItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class FireStaffItem extends Item {


    public FireStaffItem(Settings settings){
        super(settings);

    }

    @Override
    public ActionResult use(World world, PlayerEntity user, Hand hand) {

        // This is to prevent desync.
        if (world.isClient) {
            return ActionResult.PASS;
        }


        // Spawn the fire charge.
        user.swingHand(hand, true);
        FireballEntity ball = new FireballEntity(world, user, user.getRotationVector(), 5);
        world.spawnEntity(ball);

        ItemStack staff = user.getStackInHand(hand);
        staff.damage(1, user, EquipmentSlot.MAINHAND);

        return ActionResult.SUCCESS;
    }

}
