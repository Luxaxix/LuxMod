package luxmod.init;

import luxmod.Reference;
import luxmod.blocks.BlockBasic;
import luxmod.blocks.BlockOre;
import luxmod.blocks.BlockOreMultiple;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber(modid=Reference.MODID)
public class ModBlocks {
   
   static Block luxBlock1;
   public static Block luxBlockOre1;
   static Block luxBlockRng;
   
   public static void init() {
      luxBlock1 = new BlockBasic("luxBlock1", Material.ROCK).setHardness(1.5f).setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
      luxBlock1.setHarvestLevel("pickaxe", 2);
      luxBlockOre1 = new BlockOre("luxBlockOre1", Material.ROCK, ModItems.luxDust1, 2, 8).setHardness(2f).setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
      luxBlockOre1.setLightLevel(0.9f).setHarvestLevel("pickaxe", 3);
      luxBlockRng = new BlockOreMultiple("luxBlockRng", Material.ROCK).setHardness(15f).setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
      luxBlockRng.setHarvestLevel("pickaxe", 3);
   }
   
   @SubscribeEvent
   public static void registerBlocks(RegistryEvent.Register<Block> event) {
      event.getRegistry().registerAll(luxBlock1, luxBlockOre1, luxBlockRng);
   }
   
   @SubscribeEvent
   public static void registerItemBlocks(RegistryEvent.Register<Item> event) {
      event.getRegistry().registerAll(new ItemBlock(luxBlock1).setRegistryName(luxBlock1.getRegistryName()));
      event.getRegistry().registerAll(new ItemBlock(luxBlockOre1).setRegistryName(luxBlockOre1.getRegistryName()));
      event.getRegistry().registerAll(new ItemBlock(luxBlockRng).setRegistryName(luxBlockRng.getRegistryName()));
   }
   
   @SubscribeEvent
   public static void registerRenders(ModelRegistryEvent event) {
      registerRender(Item.getItemFromBlock(luxBlock1));
      registerRender(Item.getItemFromBlock(luxBlockOre1));
      registerRender(Item.getItemFromBlock(luxBlockRng));
   }
   
   public static void registerRender(Item item) {
      ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation( item.getRegistryName(), "inventory"));
   }
}
