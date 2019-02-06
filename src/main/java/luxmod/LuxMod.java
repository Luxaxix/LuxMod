package luxmod;

import luxmod.init.ModBlocks;
import luxmod.init.ModItems;
import luxmod.init.ModRecipes;
import luxmod.worldgen.OreGen;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

@Mod(modid=Reference.MODID, name=Reference.MODNAME, version=Reference.VERSION, acceptedMinecraftVersions=Reference.ACCEPTED_MINECRAFT_VERSIONS)
public class LuxMod {
   
   @Instance
   public static LuxMod instance;
   
   @EventHandler
   public void preInit(FMLPreInitializationEvent event) {
      System.out.println(Reference.MODID + ":preInit");
      ModItems.init();
      ModBlocks.init();
   }
   
   @EventHandler
   public void init(FMLInitializationEvent event) {
      System.out.println(Reference.MODID + ":init");
      ModRecipes.init();
      GameRegistry.registerWorldGenerator(new OreGen(), 0);
   }
   
   @EventHandler
   public void postInit(FMLPostInitializationEvent event) {
      System.out.println(Reference.MODID + ":postInit");
   }
   

}
