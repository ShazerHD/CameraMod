package au.com.shaunfulham.cameramod.tileentity;

import au.com.shaunfulham.cameramod.Option;
import au.com.shaunfulham.cameramod.blocks.ArriAlexa65;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;

public class TileEntityAlexa65 extends TileEntityCamera
{
    private final float CAMERA_SPEED = 0.0180F;

    public float cameraRotation = 0.0F;
    public boolean addToRotation = true;
    public boolean down = false;
    private Option.OptionFloat rotationSpeedOption = new Option.OptionFloat("rotationSpeed", CAMERA_SPEED, 0.0100F, 0.0250F, 0.001F);
    private Option.OptionBoolean shouldRotateOption = new Option.OptionBoolean("shouldRotate", true);
    private Option.OptionDouble customRotationOption = new Option.OptionDouble(this, "customRotation", (double)cameraRotation, 1.55D, -1.55D, (double)rotationSpeedOption.asFloat(), true);

    @Override
    public void update(){
        super.update();

        if(!shouldRotateOption.asBoolean())
        {
            cameraRotation = (float)customRotationOption.asDouble();
            return;
        }

        if(addToRotation && cameraRotation <= 1.55F)
            cameraRotation += rotationSpeedOption.asFloat();
        else
            addToRotation = false;

        if(!addToRotation && cameraRotation >= -1.55F)
            cameraRotation -= rotationSpeedOption.asFloat();
        else
            addToRotation = true;
    }

    public Option<?>[] customOptions() {
        return new Option[]{ rotationSpeedOption, shouldRotateOption, customRotationOption };
    }

    @Override
    public void onLoad()
    {
        super.onLoad();
        down = world.getBlockState(pos).getValue(ArriAlexa65.FACING) == EnumFacing.DOWN;
    }

    @Override
    public int getSizeInventory()
    {
        return 0;
    }

    @Override
    public boolean isEmpty()
    {
        return false;
    }

    @Override
    public ItemStack getStackInSlot(int index)
    {
        return null;
    }

    @Override
    public ItemStack decrStackSize(int index, int count)
    {
        return null;
    }

    @Override
    public ItemStack removeStackFromSlot(int index)
    {
        return null;
    }

    @Override
    public void setInventorySlotContents(int index, ItemStack stack)
    {

    }

    @Override
    public boolean isUsableByPlayer(EntityPlayer player)
    {
        return false;
    }

    @Override
    public void openInventory(EntityPlayer player)
    {

    }

    @Override
    public void closeInventory(EntityPlayer player)
    {

    }

    @Override
    public boolean isItemValidForSlot(int index, ItemStack stack)
    {
        return false;
    }

    @Override
    public void clear()
    {

    }

    @Override
    public String getName()
    {
        return null;
    }

    @Override
    public boolean hasCustomName()
    {
        return false;
    }
}
