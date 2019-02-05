package luxmod.init;

import luxmod.Reference;
import luxmod.items.ItemBasic;
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
   
   static Item luxItem1;
   
   @SubscribeEvent
   public static void registerItems(RegistryEvent.Register<Item> event) {
      event.getRegistry().registerAll(luxItem1);      
   }
   
   public static void init() {
      luxItem1 = new ItemBasic("luxItem1").setCreativeTab(CreativeTabs.MISC).setMaxStackSize(32);
   }
   
   @SubscribeEvent
   public static void registerRenders(ModelRegistryEvent event) {
      registerRender(luxItem1);
   }
   
   public static void registerRender(Item item) {
      ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation( item.getRegistryName(), "inventory"));
   }
   
}
