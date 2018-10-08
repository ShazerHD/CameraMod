package au.com.shaunfulham.cameramod;

import net.minecraft.block.Block;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockUtils
{
    public static Block getBlock(World world, BlockPos pos){
        return world.getBlockState(pos).getBlock();
    }

    public static Block getBlock(IBlockAccess access, BlockPos pos){
        return access.getBlockState(pos).getBlock();
    }

    public static Block getBlock(World world, int x, int y, int z){
        return world.getBlockState(toPos(x, y, z)).getBlock();
    }

    public static BlockPos toPos(int x, int y, int z){
        return new BlockPos(x, y, z);
    }

    public static boolean hasBlockProperty(World world, BlockPos pos, IProperty<?> property){
        try{
            world.getBlockState(pos).getValue(property);
            return true;
        }catch(IllegalArgumentException e){
            return false;
        }
    }

    public static EnumFacing getBlockPropertyAsEnum(IBlockAccess world, BlockPos pos, PropertyEnum<?> property){
        return ((EnumFacing) world.getBlockState(pos).getValue(property));
    }
}
