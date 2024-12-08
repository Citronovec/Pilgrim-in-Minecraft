package net.citron.pilgrim.item;

import net.fabricmc.fabric.api.event.player.UseItemCallback;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Hand;
import net.minecraft.util.Rarity;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class AmberItem extends Item {
    public AmberItem(Settings settings) {
        super(settings);
    }
    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity player, Hand hand) {
        if (world.isClient) {
            // Perform custom behavior on the server-side
            player.sendMessage(Text.literal("You used the custom item!"), true);

            player.heal(2.0F);
        }

        // Return the result of the action:
        // PASS: Continue with default behavior.
        // CONSUME: Prevent further use and consume the item.
        // FAIL: Cancel the action completely.
        return TypedActionResult.success(player.getStackInHand(hand));
    }
}
