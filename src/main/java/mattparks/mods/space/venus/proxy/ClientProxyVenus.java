package mattparks.mods.space.venus.proxy;

import java.util.ArrayList;

import mattparks.mods.space.venus.entities.EntityEvolvedBlaze;
import mattparks.mods.space.venus.entities.EntityVenusianTNT;
import mattparks.mods.space.venus.entities.EntityVenusianVillager;
import mattparks.mods.space.venus.entities.render.RenderEvolvedBlaze;
import mattparks.mods.space.venus.entities.render.RenderVenusianTNT;
import mattparks.mods.space.venus.entities.render.RenderVenusianVillager;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.audio.SoundPoolEntry;
import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent.ClientTickEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ClientProxyVenus extends CommonProxyVenus 
{
	private static Minecraft mc = FMLClientHandler.instance().getClient();
	
	private static int renderIndexGemArmor;
	private static int renderIndexSulfurArmor;
	private static int renderIndexJetpack;
		
	public static ArrayList<SoundPoolEntry> newMusic = new ArrayList<SoundPoolEntry>();

    
    @Override
    public void preInit(FMLPreInitializationEvent event) 
    {
        ClientProxyVenus.renderIndexGemArmor = RenderingRegistry.addNewArmourRendererPrefix("gem");
        ClientProxyVenus.renderIndexSulfurArmor = RenderingRegistry.addNewArmourRendererPrefix("sulfur");
        ClientProxyVenus.renderIndexJetpack = RenderingRegistry.addNewArmourRendererPrefix("jetpack");
        
        super.preInit(event);
    }
    
    @Override
    public int getGemArmorRenderIndex()
    {
        return ClientProxyVenus.renderIndexGemArmor;
    }

    @Override
    public int getSulfurArmorRenderIndex()
    {
        return ClientProxyVenus.renderIndexSulfurArmor;
    }
    
    @Override
    public int getJetpackArmorRenderIndex()
    {
        return ClientProxyVenus.renderIndexJetpack;
    }

    
    public static void registerEntityRenderers()
    {
    	RenderingRegistry.registerEntityRenderingHandler(EntityEvolvedBlaze.class, new RenderEvolvedBlaze());
		RenderingRegistry.registerEntityRenderingHandler(EntityVenusianVillager.class, new RenderVenusianVillager());    
    }

    @Override
    public void init(FMLInitializationEvent event) 
    {
        FMLCommonHandler.instance().bus().register(new TickHandlerClient());

		RenderingRegistry.registerEntityRenderingHandler(EntityVenusianTNT.class, new RenderVenusianTNT());
		
        super.init(event);
    }

    @Override
    public void postInit(FMLPostInitializationEvent event)
    {
        ClientProxyVenus.registerEntityRenderers();
        super.postInit(event);
    }
    
	public void registerRenderInfo() 
	{
	}
	
	@Override
	public int getBlockRender(Block block)
	{
		return -1;
	}
	
    public static class TickHandlerClient
    {
        @SideOnly(Side.CLIENT)
        @SubscribeEvent
        public void onClientTick(ClientTickEvent event)
        {
        }
    }
}
