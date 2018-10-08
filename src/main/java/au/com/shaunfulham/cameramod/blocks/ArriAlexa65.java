package au.com.shaunfulham.cameramod.blocks;


import au.com.shaunfulham.cameramod.BlockUtils;
import au.com.shaunfulham.cameramod.Cameramod;
import au.com.shaunfulham.cameramod.gui.CameraGui;
import au.com.shaunfulham.cameramod.misc.CameraView;
import au.com.shaunfulham.cameramod.proxy.packets.PacketSMountCamera;
import au.com.shaunfulham.cameramod.tileentity.EntityAlexa65;
import net.minecraft.block.Block;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import org.lwjgl.opengl.GL15;

import javax.annotation.Nullable;

public class ArriAlexa65 extends CameraBlockBase
{


    public ArriAlexa65(String id)
    {
        super(id);
    }

    @Override
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ)
    {
      Minecraft.getMinecraft().displayGuiScreen(new CameraGui());
      return true;
    }

        public void mountCamera(World world, int x, int y, int z, int id, EntityPlayer player){

        if(player.getRidingEntity() != null && player.getRidingEntity() instanceof EntityAlexa65){
            EntityAlexa65 dummyEntity = new EntityAlexa65(world, x, y, z, id, (EntityAlexa65) player.getRidingEntity());
            WorldUtils.addScheduledTask(world, () -> world.spawnEntity(dummyEntity));
            player.startRiding(dummyEntity);
            return;
        }

        EntityAlexa65 dummyEntity = new EntityAlexa65(world, x, y, z, id, player);
        WorldUtils.addScheduledTask(world, () -> world.spawnEntity(dummyEntity));
        player.startRiding(dummyEntity);

        for(Object e : world.loadedEntityList)
            if(e instanceof EntityLiving)
                if(((EntityLiving)e).getAttackTarget() == player)
                    ((EntityLiving)e).setAttackTarget(null);
    }




}
