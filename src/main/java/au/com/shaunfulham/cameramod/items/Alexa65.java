package au.com.shaunfulham.cameramod.items;

import au.com.shaunfulham.cameramod.gui.CameraGui;
import com.mrcrayfish.obfuscate.Obfuscate;
import com.mrcrayfish.obfuscate.client.event.ModelPlayerEvent;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class Alexa65 extends ItemBlock
{
    public Alexa65(Block block)
    {
        super(block);
    }

    @Override
    public boolean isValidArmor(ItemStack stack, EntityEquipmentSlot armorType, Entity entity) {
        if(armorType.getSlotIndex() == 2)
        {
            return true;
        }
        return false;
    }
}
