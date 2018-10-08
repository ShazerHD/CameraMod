package au.com.shaunfulham.cameramod.misc;

import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import org.lwjgl.input.Keyboard;

public class KeyBindings
{
    public static KeyBinding cameraZoomIn;
    public static KeyBinding cameraZoomOut;

    public static void init(){
        cameraZoomIn = new KeyBinding("key.cameraZoomIn", Keyboard.KEY_EQUALS, "key.categories.securitycraft");
        cameraZoomOut = new KeyBinding("key.cameraZoomOut", Keyboard.KEY_MINUS, "key.categories.securitycraft");


        ClientRegistry.registerKeyBinding(cameraZoomIn);
        ClientRegistry.registerKeyBinding(cameraZoomOut);

    }
}
