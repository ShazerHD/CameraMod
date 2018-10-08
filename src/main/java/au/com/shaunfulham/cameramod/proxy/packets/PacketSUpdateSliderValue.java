package au.com.shaunfulham.cameramod.proxy.packets;

import au.com.shaunfulham.cameramod.Option;
import au.com.shaunfulham.cameramod.WorldUtils;
import au.com.shaunfulham.cameramod.tileentity.TileEntityCamera;
import io.netty.buffer.ByteBuf;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class PacketSUpdateSliderValue implements IMessage
{
    private BlockPos pos;
    private int id;
    private double value;

    public PacketSUpdateSliderValue(){ }

    public PacketSUpdateSliderValue(BlockPos pos, int id, double v){
        this.pos = pos;
        this.id = id;
        value = v;
    }

    @Override
    public void toBytes(ByteBuf buf) {
        buf.writeLong(pos.toLong());
        buf.writeInt(id);
        buf.writeDouble(value);
    }

    @Override
    public void fromBytes(ByteBuf buf) {
        pos = BlockPos.fromLong(buf.readLong());
        id = buf.readInt();
        value = buf.readDouble();
    }

    public static class Handler extends PacketHelper implements IMessageHandler<PacketSUpdateSliderValue, IMessage>
    {

        @Override
        public IMessage onMessage(PacketSUpdateSliderValue message, MessageContext ctx)
        {
            return null;
        }
    }
}
