package au.com.shaunfulham.cameramod;

import net.minecraft.util.text.translation.I18n;

public class ClientUtils
{
    public static String localize(String key, Object... params)
    {
        return String.format(I18n.translateToLocal(key), params);
    }
}
