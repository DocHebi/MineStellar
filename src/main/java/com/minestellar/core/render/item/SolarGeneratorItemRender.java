/**
 * Copyright (c) 14/feb/2015 Davide Cossu.
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

package com.minestellar.core.render.item;

import org.lwjgl.opengl.GL11;

import com.minestellar.core.blocks.tile.TileEntitySolarGenerator;
import com.minestellar.core.model.ModelSolarPanel;
import com.minestellar.core.render.tile.TileEntityRenderSolarPanel;

import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.IItemRenderer;

public class SolarGeneratorItemRender implements IItemRenderer{
	
	@Override
	public boolean handleRenderType(ItemStack item, ItemRenderType type) {
		return true;
	}

	@Override
	public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item, ItemRendererHelper helper) {
		return true;
	}

	@Override
	public void renderItem(ItemRenderType type, ItemStack item, Object... data) {
		switch(type){
		case EQUIPPED_FIRST_PERSON:
			GL11.glPushMatrix();
			GL11.glTranslated(0, 0.25, 0);
			TileEntityRendererDispatcher.instance.renderTileEntityAt(new TileEntitySolarGenerator(), 0.0D, 0.0D, 0.0D, 0.0F);
			GL11.glTranslated(0, -0.25, 0);
			GL11.glPopMatrix();
			break;
		case INVENTORY:
			GL11.glPushMatrix();
			GL11.glScaled(0.75, 0.75, 0.75);
			GL11.glTranslated(0, -0.75, 0);
			TileEntityRendererDispatcher.instance.renderTileEntityAt(new TileEntitySolarGenerator(), 0.0D, 0.0D, 0.0D, 0.0F);
			GL11.glTranslated(0, 0.75, 0);
			GL11.glPopMatrix();
			break;
		case ENTITY:
			GL11.glPushMatrix();
			GL11.glTranslated(-0.5, 0, -0.5);
			TileEntityRendererDispatcher.instance.renderTileEntityAt(new TileEntitySolarGenerator(), 0.0D, 0.0D, 0.0D, 0.0F);
			GL11.glTranslated(0.5, 0, 0.5);
			GL11.glPopMatrix();
		default:
			break;
		}
	}

}