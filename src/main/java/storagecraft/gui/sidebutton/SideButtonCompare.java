package storagecraft.gui.sidebutton;

import net.minecraft.util.EnumChatFormatting;
import storagecraft.StorageCraft;
import storagecraft.gui.GuiBase;
import storagecraft.network.MessageCompareUpdate;
import storagecraft.tile.ICompareSetting;

public class SideButtonCompare extends SideButton
{
	private ICompareSetting setting;
	private int mask;

	public SideButtonCompare(ICompareSetting setting, int mask)
	{
		this.setting = setting;
		this.mask = mask;
	}

	@Override
	public String getTooltip(GuiBase gui)
	{
		StringBuilder builder = new StringBuilder();

		builder.append(EnumChatFormatting.YELLOW).append(gui.t("sidebutton.storagecraft:compare." + mask)).append(EnumChatFormatting.RESET).append("\n");

		if ((setting.getCompare() & mask) == mask)
		{
			builder.append(gui.t("misc.storagecraft:yes"));
		}
		else
		{
			builder.append(gui.t("misc.storagecraft:no"));
		}

		return builder.toString();
	}

	@Override
	public void draw(GuiBase gui, int x, int y)
	{
	}

	@Override
	public void actionPerformed()
	{
		StorageCraft.NETWORK.sendToServer(new MessageCompareUpdate(setting, setting.getCompare() ^ mask));
	}
}
