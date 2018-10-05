package au.com.shaunfulham.cameramod.items;

import au.com.shaunfulham.cameramod.blocks.ArriAlexa65;
import au.com.shaunfulham.cameramod.gui.CameraGui;
import au.com.shaunfulham.cameramod.init.ModBlocks;
import au.com.shaunfulham.cameramod.init.RegistrationHandler;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
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
    public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn)
    {
        Minecraft.getMinecraft().displayGuiScreen(new CameraGui());
        return new ActionResult<>(EnumActionResult.SUCCESS, new ItemStack(ModBlocks.ARRI_ALEXA_65, 0));
    }
}
