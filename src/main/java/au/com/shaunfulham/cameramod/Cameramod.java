package au.com.shaunfulham.cameramod;

import au.com.shaunfulham.cameramod.proxy.CommonProxy;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.event.RegistryEvent;

@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.VERSION, acceptedMinecraftVersions = Reference.ACCEPTED_MINECRAFT_VERSIONS)
public class Cameramod
{



    /**
     * This is the instance of your mod as created by Forge. It will never be null.
     */
    @Mod.Instance(Reference.MOD_ID)
    public static Cameramod INSTANCE;

    @SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.COMMON_PROXY_CLASS)
    public static CommonProxy proxy;


    @Mod.EventHandler
    public void preinit(FMLPreInitializationEvent event)
    {
        proxy.preInit(event);
    }


    @Mod.EventHandler
    public void init(FMLInitializationEvent event)
    {

    }


    @Mod.EventHandler
    public void postinit(FMLPostInitializationEvent event)
    {

    }

}
