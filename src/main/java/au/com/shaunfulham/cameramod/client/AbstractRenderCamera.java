package au.com.shaunfulham.cameramod.client;

import au.com.shaunfulham.cameramod.items.ItemCamera;
import net.minecraft.client.model.ModelPlayer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class AbstractRenderCamera <T extends ItemCamera>
{
    public void applyPlayerModel(T item, EntityPlayer player, ModelPlayer model, float partialTicks) {};

    public void applyPlayerRender(T item, EntityPlayer player, float partialTicks) {};
}
