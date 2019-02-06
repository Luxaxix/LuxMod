package luxmod.init;

import luxmod.Reference;
import luxmod.items.ItemBasic;
import luxmod.items.ItemCustomFood;
import luxmod.items.ItemEffectFood;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber(modid=Reference.MODID)
public class ModItems {
   
   public static Item luxItem1;
   public static Item luxDust1;
   static Item luxFood;
   static Item luxFoodGlow;
   
   @SubscribeEvent
   public static void registerItems(RegistryEvent.Register<Item> event) {
      event.getRegistry().registerAll(luxItem1, luxDust1, luxFood, luxFoodGlow);      
   }
   
   public static void init() {
      luxItem1 = new ItemBasic("luxItem1").setCreativeTab(CreativeTabs.MISC).setMaxStackSize(32);
      luxDust1 = new ItemBasic("luxDust1").setCreativeTab(CreativeTabs.MISC).setMaxStackSize(64);
      luxFood = new ItemCustomFood("luxFood", 6, 0.5f, true).setCreativeTab(CreativeTabs.FOOD).setMaxStackSize(8);
      luxFoodGlow = new ItemEffectFood("luxFoodGlow", 0, 0.1f, false).setCreativeTab(CreativeTabs.FOOD).setMaxStackSize(1);
   }
   
   @SubscribeEvent
   public static void registerRenders(ModelRegistryEvent event) {
      registerRender(luxItem1);
      registerRender(luxDust1);
      registerRender(luxFood);
      registerRender(luxFoodGlow);
   }
   
   public static void registerRender(Item item) {
      ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation( item.getRegistryName(), "inventory"));
   }
   
}
