package com.minestellar.core.items;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemBucket;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import com.minestellar.core.Minestellar;
import com.minestellar.core.blocks.CoreBlocks;
import com.minestellar.core.proxy.ClientProxyCore;

public class ItemBucketOil extends ItemBucket
{
	private Block isFull;

	public ItemBucketOil(String name)
	{
		super(CoreBlocks.oilFluidBlock);
		this.isFull = CoreBlocks.oilFluidBlock;
		this.setMaxStackSize(1);
		this.setUnlocalizedName(name);
	}

	@Override
	public EnumRarity getRarity(ItemStack par1ItemStack)
	{
		return ClientProxyCore.stellarItem;
	}

	@Override
	public CreativeTabs getCreativeTab()
	{
		return Minestellar.stellarItemsTab;
	}

	@Override
	public boolean tryPlaceContainedLiquid(World par1World, int x, int y, int z)
	{
		Material material = par1World.getBlock(x, y, z).getMaterial();
		boolean flag = !material.isSolid();

		if (this.isFull == Blocks.air)
		{
			return false;
		}
		else if (!par1World.isAirBlock(x, y, z) && par1World.getBlock(x, y, z).getMaterial().isSolid())
		{
			return false;
		}
		else
		{
			if (par1World.provider.isHellWorld && this.isFull != Blocks.air)
			{
				par1World.playSoundEffect(x + 0.5F, y + 0.5F, z + 0.5F, "random.fizz", 0.5F, 2.6F + (par1World.rand.nextFloat() - par1World.rand.nextFloat()) * 0.8F);

				for (int l = 0; l < 8; l++)
				{
					par1World.spawnParticle("largesmoke", x + Math.random(), y + Math.random(), z + Math.random(), 0.0D, 0.0D, 0.0D);
				}
			}
			else
			{
				if (!par1World.isRemote && flag && !material.isLiquid())
				{
					par1World.func_147480_a(x, y, z, true);
				}
				par1World.setBlock(x, y, z, this.isFull, 0, 3);
			}
			return true;
		}
	}

	@Override
	public void registerIcons(IIconRegister iconRegister)
	{
		this.itemIcon = iconRegister.registerIcon(Minestellar.TEXTURE_PREFIX + "oil_bucket");
	}
}