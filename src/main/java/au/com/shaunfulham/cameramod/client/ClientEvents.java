package au.com.shaunfulham.cameramod.client;

import au.com.shaunfulham.cameramod.items.Alexa65;
import au.com.shaunfulham.cameramod.items.ItemCamera;
import com.mrcrayfish.obfuscate.client.event.ModelPlayerEvent;
import net.minecraft.client.model.ModelPlayer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumHand;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class ClientEvents
{

    @SubscribeEvent
    public void onSetupAngles(ModelPlayerEvent.SetupAngles.Post event)
    {
        EntityPlayer player = event.getEntityPlayer();
        Item heldItem = player.getHeldItem(EnumHand.MAIN_HAND).getItem();
        ModelPlayer model = event.getModelPlayer();

        if(heldItem != null && heldItem instanceof ItemCamera)
        {
            ItemCamera vehicle = (ItemCamera) heldItem;
            /* Suppressed due to warning however it's safe to say cast won't throw an exception
             * due to the registration process of vehicle renders */
            @SuppressWarnings("unchecked")
            AbstractRenderCamera<ItemCamera> render = (AbstractRenderCamera<ItemCamera>) CameraRenderRegistry.getRender(vehicle.getClass());
            if(render != null)
            {
                render.applyPlayerModel(vehicle, player, model, event.getPartialTicks());
                return;
            }

        }

        if(heldItem instanceof Alexa65)
        {
            model.bipedRightArm.rotateAngleX = (float) Math.toRadians(-90F);
            model.bipedRightArm.rotateAngleY = (float) Math.toRadians(20F);
            model.bipedLeftArm.rotateAngleX = (float) Math.toRadians(-90F);
            model.bipedLeftArm.rotateAngleY = (float) Math.toRadians(55F);
            model.bipedLeftArm.offsetX = (float) Math.toRadians(-10F);
            model.bipedLeftArm.offsetZ = (float) Math.toRadians(-10F);
            return;
        } else
        {
            model.bipedRightArm.rotateAngleY = (float) Math.toRadians(0F);
        }
    }

}
