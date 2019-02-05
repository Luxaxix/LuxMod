package luxmod.init;

import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModRecipes {
   
   public static void init() {
      GameRegistry.addSmelting(ModItems.luxDust1, new ItemStack(ModItems.luxItem1, 1), 1.5f);
      GameRegistry.addSmelting(ModBlocks.luxBlockOre1, new ItemStack(ModItems.luxItem1, 2), 0.5f);
   }
   
   
}
