package au.com.shaunfulham.cameramod.client;

import au.com.shaunfulham.cameramod.items.Alexa65;
import au.com.shaunfulham.cameramod.items.ItemCamera;
import net.minecraft.client.model.ModelPlayer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.util.EnumHand;

public class RenderArriAlexa65 extends AbstractRenderCamera<Alexa65>
{
    @Override
    public void applyPlayerModel(Alexa65 item, EntityPlayer player, ModelPlayer model, float partialTicks)
    {
        model.bipedRightArm.rotateAngleY = (float) Math.toRadians(10F);
    }

}
