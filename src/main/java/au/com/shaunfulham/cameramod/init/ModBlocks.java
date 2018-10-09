package au.com.shaunfulham.cameramod.init;

import au.com.shaunfulham.cameramod.blocks.ArriAlexa65;
import au.com.shaunfulham.cameramod.blocks.CameraBaseBlock;
import au.com.shaunfulham.cameramod.blocks.CameraBlockBase;
import au.com.shaunfulham.cameramod.items.Alexa65;
import au.com.shaunfulham.cameramod.items.CameraBase;
import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;

public class ModBlocks
{

    public static final Block CAMERA_BASE;
    public static final CameraBlockBase ARRI_ALEXA_65;

    static
    {
        CAMERA_BASE  = new CameraBaseBlock("camera_base");
        ARRI_ALEXA_65 = new ArriAlexa65("alexa_65");
    }

    public static void register()
    {
        registerBlock(CAMERA_BASE, new CameraBase(CAMERA_BASE));
        registerBlock(ARRI_ALEXA_65, new Alexa65(ARRI_ALEXA_65));
    }

    public static void registerBlock(Block block, ItemBlock item)
    {
        if (block.getRegistryName() == null)
            throw new IllegalArgumentException("A block being registered does not have a registry name and could be successfully registered.");
        RegistrationHandler.Blocks.add(block);
        item.setRegistryName(block.getRegistryName());
        RegistrationHandler.Items.add(item);
    }

}
