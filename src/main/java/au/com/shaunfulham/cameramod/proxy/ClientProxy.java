package au.com.shaunfulham.cameramod.proxy;

import au.com.shaunfulham.cameramod.client.AbstractRenderCamera;
import au.com.shaunfulham.cameramod.client.CameraRenderRegistry;
import au.com.shaunfulham.cameramod.client.ClientEvents;
import au.com.shaunfulham.cameramod.client.RenderArriAlexa65;
import au.com.shaunfulham.cameramod.init.RegistrationHandler;
import au.com.shaunfulham.cameramod.items.Alexa65;
import au.com.shaunfulham.cameramod.items.ItemCamera;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class ClientProxy extends CommonProxy
{

    public void preInit(FMLPreInitializationEvent event)
    {
        RegistrationHandler.init();

        MinecraftForge.EVENT_BUS.register(new ClientEvents());
    }

}
