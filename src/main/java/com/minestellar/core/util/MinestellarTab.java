package com.minestellar.core.util;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class MinestellarTab extends CreativeTabs
{
	private final Item itemForTab;
	private final int metaForTab;

	public MinestellarTab(int par1, String par2Str, Item itemForTab, int metaForTab)
	{
		super(par1, par2Str);
		this.itemForTab = itemForTab;
		this.metaForTab = metaForTab;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public Item getTabIconItem()
	{
		return this.itemForTab;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public int func_151243_f()
	{
		return this.metaForTab;
	}
}
