package com.minestellar.core.util;

import java.util.Arrays;
import java.util.List;

import net.minecraft.entity.Entity;
import net.minecraft.util.StatCollector;

import com.minestellar.core.Minestellar;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import cpw.mods.fml.relauncher.Side;

public class MinestellarUtil
{
	public static int nextID = 0;
	
    public static int to32BitColor(int a, int r, int g, int b)
    {
        a = a << 24;
        r = r << 16;
        g = g << 8;

        return a | r | g | b;
    }

    public static String translate(String key)
    {
        String result = StatCollector.translateToLocal(key);
        int comment = result.indexOf('#');
        return (comment > 0) ? result.substring(0, comment).trim() : result;
    }

    public static List<String> translateWithSplit(String key)
    {
        String translated = translate(key);
        int comment = translated.indexOf('#');
        translated = (comment > 0) ? translated.substring(0, comment).trim() : translated;
        return Arrays.asList(translated.split("\\$"));
    }

    public static String translateWithFormat(String key, Object... values)
    {
        String result = StatCollector.translateToLocalFormatted(key, values);
        int comment = result.indexOf('#');
        return (comment > 0) ? result.substring(0, comment).trim() : result;
    }
    
    public static int nextInternalID()
    {
    	MinestellarUtil.nextID++;
    	return MinestellarUtil.nextID - 1;
    }
    
    public static void registerSpaceCreature(Class<? extends Entity> var0, String var1, int back, int fore)
    {
        if (FMLCommonHandler.instance().getEffectiveSide() == Side.CLIENT)
        {
            LanguageRegistry.instance().addStringLocalization("entity." + var1 + ".name", MinestellarUtil.translate("entity.Minestellar." + var1 + ".name"));
        }

        int newID = EntityRegistry.instance().findGlobalUniqueEntityId();
        EntityRegistry.registerGlobalEntityID(var0, var1, newID, back, fore);
        EntityRegistry.registerModEntity(var0, var1, nextInternalID(), Minestellar.instance, 80, 3, true);
    }

    public static void registerSpaceNonMobEntity(Class<? extends Entity> var0, String var1, int trackingDistance, int updateFreq, boolean sendVel)
    {
        if (FMLCommonHandler.instance().getEffectiveSide() == Side.CLIENT)
        {
            LanguageRegistry.instance().addStringLocalization("entity." + var1 + ".name", MinestellarUtil.translate("entity.Minestellar." + var1 + ".name"));
        }

        EntityRegistry.registerModEntity(var0, var1, nextInternalID(), Minestellar.instance, trackingDistance, updateFreq, sendVel);
    }
}