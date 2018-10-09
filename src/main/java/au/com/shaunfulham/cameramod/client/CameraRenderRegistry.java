package au.com.shaunfulham.cameramod.client;

import au.com.shaunfulham.cameramod.items.ItemCamera;

import javax.annotation.Nullable;
import java.util.HashMap;
import java.util.Map;

public final class CameraRenderRegistry
{
    private static final Map<Class<? extends ItemCamera>, AbstractRenderCamera<? extends ItemCamera>> renderMap = new HashMap<>();

    public static void registerRender(Class<? extends ItemCamera> clazz, AbstractRenderCamera<? extends ItemCamera> render)
    {
        renderMap.put(clazz, render);
    }

    @Nullable
    public static AbstractRenderCamera<?> getRender(Class<? extends ItemCamera> clazz)
    {
        return renderMap.get(clazz);
    }
}