/**
 * Copyright (c) 04/January/2015 Davide Cossu & Matthew Albrecht.
 *
 * This program is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 3 of the License, or (at your option) any
 * later version.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT ANY
 * WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A
 * PARTICULAR PURPOSE. See the GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License along with
 * this program; if not, see <http://www.gnu.org/licenses>.
 */

package com.minestellar.core.items;

import java.util.List;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

import com.minestellar.core.MinestellarCore;
import com.minestellar.core.util.MinestellarUtil;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemCanisterOil extends ItemCanisterGeneric {
	protected IIcon[] icons = new IIcon[7];

	public ItemCanisterOil(String assetName) {
		super(assetName);
		this.setAllowedFluid("oil");
		this.setContainerItem(this);
		this.setTextureName(MinestellarCore.TEXTURE_PREFIX + assetName);
	}

	@SuppressWarnings({
	"unchecked", "rawtypes"
	})
	@Override
	@SideOnly(Side.CLIENT)
	public void getSubItems(Item par1, CreativeTabs par2CreativeTabs, List par3List) {
		par3List.add(new ItemStack(par1, 1, 1));
		par3List.add(new ItemStack(par1, 1, this.getMaxDamage()));
	}

	@Override
	public void onUpdate(ItemStack par1ItemStack, World par2World, Entity par3Entity, int par4, boolean par5) {
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister iconRegister) {
		for (int i = 0; i < this.icons.length; i++) {
			this.icons[i] = iconRegister.registerIcon(this.getIconString() + "_" + i);
		}
	}

	@Override
	public String getUnlocalizedName(ItemStack itemStack) {
		if (itemStack.getMaxDamage() - itemStack.getItemDamage() == 0) {
			return "item.emptyLiquidCanister";
		}

		if (itemStack.getItemDamage() == 1) {
			return "item.canisterOil";
		}

		return "item.canisterOilPartial";
	}

	@Override
	public IIcon getIconFromDamage(int par1) {
		final int damage = 6 * par1 / this.getMaxDamage();

		if (this.icons.length > damage) {
			return this.icons[this.icons.length - damage - 1];
		}

		return super.getIconFromDamage(damage);
	}

	@SuppressWarnings({
	"unchecked", "rawtypes"
	})
	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4) {
		if (par1ItemStack.getMaxDamage() - par1ItemStack.getItemDamage() > 0) {
			par3List.add(MinestellarUtil.translate("gui.info.oil.name") + ": " + (par1ItemStack.getMaxDamage() - par1ItemStack.getItemDamage()));
		}
	}
}
