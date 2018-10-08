package au.com.shaunfulham.cameramod.tileentity;

import au.com.shaunfulham.cameramod.BlockUtils;
import au.com.shaunfulham.cameramod.blocks.ArriAlexa65;
import au.com.shaunfulham.cameramod.init.ModBlocks;
import au.com.shaunfulham.cameramod.misc.KeyBindings;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.lwjgl.input.Mouse;

public class EntityAlexa65 extends Entity
{


    private final float CAMERA_SPEED = 10.0f;

    public int blockPosX;
    public int blockPosY;
    public int blockPosZ;

    private double cameraUseX;
    private double cameraUseY;
    private double cameraUseZ;
    private float cameraUseYaw;
    private float cameraUsePitch;

    private int id;
    private int toggleLightCooldown = 0;
    private float zoomAmount = 1F;

    private String playerViewingName = null;

    public EntityAlexa65(World world){
        super(world);
        noClip = true;
        height = 0.0001F;
        width = 0.0001F;
    }

    public EntityAlexa65(World world, double x, double y, double z, int id, EntityPlayer player){
        this(world);
        blockPosX = (int) x;
        blockPosY = (int) y;
        blockPosZ = (int) z;
        cameraUseX = player.posX;
        cameraUseY = player.posY;
        cameraUseZ = player.posZ;
        cameraUseYaw = player.rotationYaw;
        cameraUsePitch = player.rotationPitch;
        this.id = id;
        playerViewingName = player.getName();
        setPosition(x + 0.5D, y, z + 0.5D);

        rotationPitch = 30F;

        EnumFacing facing = BlockUtils.getBlockPropertyAsEnum(world, BlockUtils.toPos((int) Math.floor(posX), (int) posY, (int) Math.floor(posZ)), ArriAlexa65.FACING);

        if(facing == EnumFacing.NORTH)
            rotationYaw = 180F;
        else if(facing == EnumFacing.WEST)
            rotationYaw = 90F;
        else if(facing == EnumFacing.SOUTH)
            rotationYaw = 0F;
        else if(facing == EnumFacing.EAST)
            rotationYaw = 270F;
        else if(facing == EnumFacing.DOWN)
            rotationPitch = 75;
    }

    public EntityAlexa65(World world, double x, double y, double z, int id, EntityAlexa65 camera){
        this(world);
        blockPosX = (int) x;
        blockPosY = (int) y;
        blockPosZ = (int) z;
        cameraUseX = camera.cameraUseX;
        cameraUseY = camera.cameraUseY;
        cameraUseZ = camera.cameraUseZ;
        cameraUseYaw = camera.cameraUseYaw;
        cameraUsePitch = camera.cameraUsePitch;
        this.id = id;
        playerViewingName = camera.playerViewingName;
        setPosition(x + 0.5D, y, z + 0.5D);

        rotationPitch = 30.0F;

        EnumFacing facing = BlockUtils.getBlockPropertyAsEnum(world, BlockUtils.toPos((int) Math.floor(posX), (int) posY, (int) Math.floor(posZ)), ArriAlexa65.FACING);

        if(facing == EnumFacing.NORTH)
            rotationYaw = 180F;
        else if(facing == EnumFacing.WEST)
            rotationYaw = 90F;
        else if(facing == EnumFacing.SOUTH)
            rotationYaw = 0F;
        else if(facing == EnumFacing.EAST)
            rotationYaw = 270F;
        else if(facing == EnumFacing.DOWN)
            rotationPitch = 75;
    }

    @Override
    public double getMountedYOffset(){
        return height * -7500D;
    }

    @Override
    protected boolean shouldSetPosAfterLoading(){
        return false;
    }

    @Override
    public boolean shouldDismountInWater(Entity rider){
        return true;
    }

    @Override
    public void onUpdate(){
        if(world.isRemote && isBeingRidden()){
            EntityPlayer lowestEntity = (EntityPlayer)getPassengers().get(0);


            if(toggleLightCooldown > 0)
                toggleLightCooldown -= 1;

            if(lowestEntity.rotationYaw != rotationYaw){
                lowestEntity.setPositionAndRotation(lowestEntity.posX, lowestEntity.posY, lowestEntity.posZ, rotationYaw, rotationPitch);
                lowestEntity.rotationYaw = rotationYaw;
            }

            if(lowestEntity.rotationPitch != rotationPitch)
                lowestEntity.setPositionAndRotation(lowestEntity.posX, lowestEntity.posY, lowestEntity.posZ, rotationYaw, rotationPitch);

            checkKeysPressed();

        }

        if(!world.isRemote)
            if(getPassengers().size() == 0 | BlockUtils.getBlock(world, blockPosX, blockPosY, blockPosZ) != ModBlocks.ARRI_ALEXA_65){
                setDead();
                return;
            }
    }

    @SideOnly(Side.CLIENT)
    private void checkKeysPressed() {
        if (Minecraft.getMinecraft().gameSettings.keyBindSneak.isPressed())
            dismountRidingEntity();

        if(Minecraft.getMinecraft().gameSettings.keyBindForward.isKeyDown())
            moveViewUp();

        if(Minecraft.getMinecraft().gameSettings.keyBindBack.isKeyDown())
            moveViewDown();

        if(Minecraft.getMinecraft().gameSettings.keyBindLeft.isKeyDown())
            moveViewLeft();

        if(Minecraft.getMinecraft().gameSettings.keyBindRight.isKeyDown())
            moveViewRight();


        if(KeyBindings.cameraZoomIn.isPressed())
            zoomCameraView(-1);

        if(KeyBindings.cameraZoomOut.isPressed())
            zoomCameraView(1);
    }

    public void moveViewUp() {
        if(isCameraDown())
        {
            if(rotationPitch > 55F)
                setRotation(rotationYaw, rotationPitch -= CAMERA_SPEED);
        }
        else if(rotationPitch > -25F)
            setRotation(rotationYaw, rotationPitch -= CAMERA_SPEED);

    }

    public void moveViewDown(){
        if(isCameraDown())
        {
            if(rotationPitch < 100F)
                setRotation(rotationYaw, rotationPitch += CAMERA_SPEED);
        }
        else if(rotationPitch < 60F)
            setRotation(rotationYaw, rotationPitch += CAMERA_SPEED);


    }

    public void moveViewLeft() {
        if(BlockUtils.hasBlockProperty(world, BlockUtils.toPos((int) Math.floor(posX), (int) posY, (int) Math.floor(posZ)), ArriAlexa65.FACING)) {
            EnumFacing facing = BlockUtils.getBlockPropertyAsEnum(world, BlockUtils.toPos((int) Math.floor(posX), (int) posY, (int) Math.floor(posZ)), ArriAlexa65.FACING);

            if(facing == EnumFacing.EAST)
            {
                if((rotationYaw - CAMERA_SPEED) > -180F)
                    setRotation(rotationYaw -= CAMERA_SPEED, rotationPitch);
            }
            else if(facing == EnumFacing.WEST)
            {
                if((rotationYaw - CAMERA_SPEED) > 0F)
                    setRotation(rotationYaw -= CAMERA_SPEED, rotationPitch);
            }
            else if(facing == EnumFacing.NORTH)
            {
                // Handles some problems the occurs from the way the rotationYaw value works in MC
                if((((rotationYaw - CAMERA_SPEED) > 90F) && ((rotationYaw - CAMERA_SPEED) < 185F)) || (((rotationYaw - CAMERA_SPEED) > -190F) && ((rotationYaw - CAMERA_SPEED) < -90F)))
                    setRotation(rotationYaw -= CAMERA_SPEED, rotationPitch);
            }
            else if(facing == EnumFacing.SOUTH)
            {
                if((rotationYaw - CAMERA_SPEED) > -90F)
                    setRotation(rotationYaw -= CAMERA_SPEED, rotationPitch);
            }
            else if(facing == EnumFacing.DOWN)
                setRotation(rotationYaw -= CAMERA_SPEED, rotationPitch);


        }
    }

    public void moveViewRight(){
        if(BlockUtils.hasBlockProperty(world, BlockUtils.toPos((int) Math.floor(posX), (int) posY, (int) Math.floor(posZ)), ArriAlexa65.FACING)) {
            EnumFacing facing = BlockUtils.getBlockPropertyAsEnum(world, BlockUtils.toPos((int) Math.floor(posX), (int) posY, (int) Math.floor(posZ)), ArriAlexa65.FACING);

            if(facing == EnumFacing.EAST)
            {
                if((rotationYaw + CAMERA_SPEED) < 0F)
                    setRotation(rotationYaw += CAMERA_SPEED, rotationPitch);
            }
            else if(facing == EnumFacing.WEST)
            {
                if((rotationYaw + CAMERA_SPEED) < 180F)
                    setRotation(rotationYaw += CAMERA_SPEED, rotationPitch);
            }
            else if(facing == EnumFacing.NORTH)
            {
                if((((rotationYaw + CAMERA_SPEED) > 85F) && ((rotationYaw + CAMERA_SPEED) < 185F)) || ((rotationYaw + CAMERA_SPEED) < -95F) && ((rotationYaw + CAMERA_SPEED) > -180F))
                    setRotation(rotationYaw += CAMERA_SPEED, rotationPitch);
            }
            else if(facing == EnumFacing.SOUTH)
            {
                if((rotationYaw + CAMERA_SPEED) < 90F)
                    setRotation(rotationYaw += CAMERA_SPEED, rotationPitch);
            }
            else if(facing == EnumFacing.DOWN)
                setRotation(rotationYaw += CAMERA_SPEED, rotationPitch);


        }
    }

    public void zoomCameraView(int zoom) {
        if(zoom > 0){
            if(zoomAmount == -0.5F)
                zoomAmount = 1F;
            else if(zoomAmount == 1F)
                zoomAmount = 2F;
        }else if(zoom < 0)
            if(zoomAmount == 2F)
                zoomAmount = 1F;
            else if(zoomAmount == 1F)
                zoomAmount = -0.5F;

    }




    public float getZoomAmount(){
        return zoomAmount;
    }



    @Override
    protected void entityInit(){}

    @Override
    public void writeEntityToNBT(NBTTagCompound tag){
        tag.setInteger("CameraID", id);

        if(playerViewingName != null)
            tag.setString("playerName", playerViewingName);

        if(cameraUseX != 0.0D)
            tag.setDouble("cameraUseX", cameraUseX);

        if(cameraUseY != 0.0D)
            tag.setDouble("cameraUseY", cameraUseY);

        if(cameraUseZ != 0.0D)
            tag.setDouble("cameraUseZ", cameraUseZ);

        if(cameraUseYaw != 0.0D)
            tag.setDouble("cameraUseYaw", cameraUseYaw);

        if(cameraUsePitch != 0.0D)
            tag.setDouble("cameraUsePitch", cameraUsePitch);
    }

    @Override
    public void readEntityFromNBT(NBTTagCompound tag){
        id = tag.getInteger("CameraID");

        if(tag.hasKey("playerName"))
            playerViewingName = tag.getString("playerName");

        if(tag.hasKey("cameraUseX"))
            cameraUseX = tag.getDouble("cameraUseX");

        if(tag.hasKey("cameraUseY"))
            cameraUseY = tag.getDouble("cameraUseY");

        if(tag.hasKey("cameraUseZ"))
            cameraUseZ = tag.getDouble("cameraUseZ");

        if(tag.hasKey("cameraUseYaw"))
            cameraUseYaw = tag.getFloat("cameraUseYaw");

        if(tag.hasKey("cameraUsePitch"))
            cameraUsePitch = tag.getFloat("cameraUsePitch");
    }

    private boolean isCameraDown()
    {
        return world.getTileEntity(getPosition()) instanceof TileEntityAlexa65 && ((TileEntityAlexa65)world.getTileEntity(getPosition())).down;
    }
}
