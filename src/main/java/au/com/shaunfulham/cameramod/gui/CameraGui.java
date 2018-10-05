package au.com.shaunfulham.cameramod.gui;

import au.com.shaunfulham.cameramod.Reference;
import au.com.shaunfulham.cameramod.blocks.ArriAlexa65;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiIngame;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.util.ResourceLocation;

public class CameraGui extends GuiScreen
{

    final ResourceLocation texture = new ResourceLocation(Reference.MOD_ID, "textures/gui/camera_gui.png");
    int guiWidth = 176;
    int guiHeight = 166;

    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks)
    {

        Minecraft.getMinecraft().renderEngine.bindTexture(texture);
        drawTexturedModalRect(width / 2 - (guiWidth / 2), height / 2 - (guiHeight / 2) , 0, 0, guiWidth, guiHeight);
        super.drawScreen(mouseX, mouseY, partialTicks);


    }

    @Override
    public void initGui()
    {
        super.initGui();
    }

    @Override
    public boolean doesGuiPauseGame()
    {
        return false;
    }

    @Override
    public void onGuiClosed()
    {

    }
}
