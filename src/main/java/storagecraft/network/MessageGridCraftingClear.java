package storagecraft.network;

import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import storagecraft.tile.TileGrid;

public class MessageGridCraftingClear implements IMessage, IMessageHandler<MessageGridCraftingClear, IMessage>
{
	private int x;
	private int y;
	private int z;
	
	public MessageGridCraftingClear()
	{
	}
	
	public MessageGridCraftingClear(TileGrid grid)
	{
		this.x = grid.xCoord;
		this.y = grid.yCoord;
		this.z = grid.zCoord;
	}
	
	@Override
	public void fromBytes(ByteBuf buf)
	{
		x = buf.readInt();
		y = buf.readInt();
		z = buf.readInt();
	}
	
	@Override
	public void toBytes(ByteBuf buf)
	{
		buf.writeInt(x);
		buf.writeInt(y);
		buf.writeInt(z);
	}
	
	@Override
	public IMessage onMessage(MessageGridCraftingClear message, MessageContext context)
	{
		EntityPlayerMP player = context.getServerHandler().playerEntity;
		
		TileEntity tile = player.worldObj.getTileEntity(message.x, message.y, message.z);
		
		if (tile instanceof TileGrid)
		{
			TileGrid grid = (TileGrid) tile;
			
			if (grid.isConnected())
			{
				for (int i = 0; i < grid.getCraftingMatrix().getSizeInventory(); ++i)
				{
					ItemStack slot = grid.getCraftingMatrix().getStackInSlot(i);
					
					if (slot != null)
					{
						if (grid.getController().push(slot))
						{
							grid.getCraftingMatrix().setInventorySlotContents(i, null);
						}
					}
				}
			}
		}
		
		return null;
	}
}
