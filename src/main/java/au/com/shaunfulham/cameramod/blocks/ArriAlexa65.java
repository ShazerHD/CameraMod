package au.com.shaunfulham.cameramod.blocks;


import au.com.shaunfulham.cameramod.Cameramod;
import au.com.shaunfulham.cameramod.gui.CameraGui;
import au.com.shaunfulham.cameramod.tileentity.EntityAlexa65;
import net.minecraft.block.Block;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.lwjgl.opengl.GL15;

import javax.annotation.Nullable;

public class ArriAlexa65 extends CameraBlockBase
{

    public int playerX;
    public int playerY;
    public int playerZ;
    EntityAlexa65 te = new EntityAlexa65();

     public EntityPlayer openedGui;

    public ArriAlexa65(String id)
    {
        super(id);
    }

    @Override
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ)
    {
        if(worldIn.isRemote)
        {
            openedGui = playerIn;
            playerX = playerIn.getPosition().getX();
            playerY = playerIn.getPosition().getY();
            playerZ = playerIn.getPosition().getZ();
            playerIn.attemptTeleport(pos.getX(), pos.getY(), pos.getZ());
            Minecraft.getMinecraft().displayGuiScreen(new CameraGui());
        }

        return super.onBlockActivated(worldIn, pos, state, playerIn, hand, facing, hitX, hitY, hitZ);
    }


    @Override
    public boolean hasTileEntity(IBlockState state)
    {
        return true;
    }

    @Nullable
    @Override
    public TileEntity createTileEntity(World world, IBlockState state)
    {
        return te;
    }

    @Override
    public boolean isFullBlock(IBlockState state)
    {
        return false;
    }

    @Override
    public boolean isFullCube(IBlockState state)
    {
        return false;
    }

    @Override
    public boolean isOpaqueCube(IBlockState state)
    {
        return false;
    }
}
