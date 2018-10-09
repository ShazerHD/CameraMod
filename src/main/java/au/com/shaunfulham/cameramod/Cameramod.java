package au.com.shaunfulham.cameramod;

import au.com.shaunfulham.cameramod.blocks.ArriAlexa65;
import au.com.shaunfulham.cameramod.client.CameraRenderRegistry;
import au.com.shaunfulham.cameramod.client.RenderArriAlexa65;
import au.com.shaunfulham.cameramod.init.ModBlocks;
import au.com.shaunfulham.cameramod.items.Alexa65;
import au.com.shaunfulham.cameramod.proxy.CommonProxy;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.event.RegistryEvent;

@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.VERSION, acceptedMinecraftVersions = Reference.ACCEPTED_MINECRAFT_VERSIONS)
public class Cameramod
{

    public static CreativeTabs camera_tab = new CreativeTabs("Camera Mod") {
        @Override
        public ItemStack getTabIconItem() {
            return new ItemStack(ModBlocks.ARRI_ALEXA_65);
        }
    };

    /**
     * This is the instance of your mod as created by Forge. It will never be null.
     */
    @Mod.Instance(Reference.MOD_ID)
    public static Cameramod INSTANCE;

    @SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.COMMON_PROXY_CLASS)
    public static CommonProxy proxy;

    public static SimpleNetworkWrapper network;


    @Mod.EventHandler
    public void preinit(FMLPreInitializationEvent event)
    {
        Cameramod.network = NetworkRegistry.INSTANCE.newSimpleChannel(Reference.MOD_ID);
        proxy.preInit(event);
    }


    @Mod.EventHandler
    public void init(FMLInitializationEvent event)
    {

    }


    @Mod.EventHandler
    public void postinit(FMLPostInitializationEvent event)
    {
        proxy.postInit(event);


    }

}
