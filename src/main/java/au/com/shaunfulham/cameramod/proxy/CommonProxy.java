package au.com.shaunfulham.cameramod.proxy;

import au.com.shaunfulham.cameramod.init.RegistrationHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class CommonProxy
{
    public void preInit(FMLPreInitializationEvent event)
    {

    }

    public void init(FMLInitializationEvent event) {RegistrationHandler.init();}

    public void postInit(FMLPostInitializationEvent event) {}
}
