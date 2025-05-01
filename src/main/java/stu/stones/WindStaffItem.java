package stu.stones;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LightningEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.FireballEntity;
import net.minecraft.entity.projectile.WindChargeEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class WindStaffItem extends Item {


    public WindStaffItem(Settings settings){
        super(settings);

    }

    @Override
    public ActionResult use(World world, PlayerEntity user, Hand hand) {

        // This is to prevent desync.
        if (world.isClient) {
            return ActionResult.PASS;
        }

        // Spawn the wind charge.
        user.swingHand(hand, true);
        WindChargeEntity ball = new WindChargeEntity(world,
                user.getBlockPos().getX(),
                user.getBlockPos().getY(),
                user.getBlockPos().getZ(),
                user.getRotationVector());
        world.spawnEntity(ball);

        ItemStack staff = user.getStackInHand(hand);
        staff.damage(1, user, EquipmentSlot.MAINHAND);

        return ActionResult.SUCCESS;
    }

}
