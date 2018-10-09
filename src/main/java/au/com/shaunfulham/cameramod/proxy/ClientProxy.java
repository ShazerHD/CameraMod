package au.com.shaunfulham.cameramod.proxy;

import au.com.shaunfulham.cameramod.client.AbstractRenderCamera;
import au.com.shaunfulham.cameramod.client.CameraRenderRegistry;
import au.com.shaunfulham.cameramod.client.RenderArriAlexa65;
import au.com.shaunfulham.cameramod.items.Alexa65;
import au.com.shaunfulham.cameramod.items.ItemCamera;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class ClientProxy extends CommonProxy
{

    public void preInit(FMLPreInitializationEvent event)
    {
        registerLandVehicleRenderingHandler(Alexa65.class, new RenderArriAlexa65());
    }

    public void init(FMLInitializationEvent event)
    {

    }

    public void postInit(FMLPostInitializationEvent event)
    {
        
    }

    private <T extends ItemCamera> void registerLandVehicleRenderingHandler(Class<T> clazz, AbstractRenderCamera<T> render)
    {
        CameraRenderRegistry.registerRender(clazz, render);
    }

}
