package au.com.shaunfulham.cameramod.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.util.ResourceLocation;

public class CameraBlockBase extends Block
{
    public CameraBlockBase(String id)
    {
        super(Material.IRON);
        this.setUnlocalizedName(id);
        this.setRegistryName(id);
        this.setCreativeTab(CreativeTabs.REDSTONE);
    }
}
