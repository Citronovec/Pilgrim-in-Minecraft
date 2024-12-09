package net.citron.pilgrim.item;

import net.fabricmc.fabric.api.event.player.UseItemCallback;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.ArrowEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Hand;
import net.minecraft.util.Rarity;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class AmberItem extends Item {
    public AmberItem(Settings settings) {
        super(settings);
    }
    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity player, Hand hand) {
        if (!world.isClient) {
            player.sendMessage(Text.literal("looolll"), true);
            Vec3d playerPos = player.getPos();
            Vec3d lookDirection = player.getRotationVec(1.0F);

            // Create a new projectile entity (e.g., an arrow as an example)
            ArrowEntity arrow = new ArrowEntity(EntityType.ARROW, world);
            arrow.setOwner(player);
            arrow.setPos(playerPos.x, playerPos.y + player.getEyeHeight(player.getPose()), playerPos.z);
            arrow.setVelocity(lookDirection.x, lookDirection.y, lookDirection.z, 2.0F, 0.0F); // Speed and spread

            // Add the projectile to the world
            world.spawnEntity(arrow);

            player.heal(2.0F);
        }

        return TypedActionResult.success(player.getStackInHand(hand));
    }
}
