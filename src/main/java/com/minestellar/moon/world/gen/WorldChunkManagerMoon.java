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

package com.minestellar.moon.world.gen;

import net.minecraft.world.biome.BiomeGenBase;

import com.minestellar.api.world.gen.WorldChunkManagerMinestellar;

public class WorldChunkManagerMoon extends WorldChunkManagerMinestellar {
	@Override
	public BiomeGenBase getBiome() {
		return BiomeGenBaseMoon.moon;
	}
}
