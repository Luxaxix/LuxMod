package luxmod.blocks;

import java.util.Random;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;

public class BlockOre extends BlockBasic {
   
   Item itemToDrop;
   int minDropAmount;
   int maxDropAmount;
   
   public BlockOre (String name, Material material) {
      this(name, material, null, 1, 1);
   }
   
   public BlockOre (String name, Material material, Item item) {
      this(name, material, item, 1, 1);
   }
   
   public BlockOre (String name, Material material, Item item, int min) {
      this(name, material, item, min, min);
   }
   
   public BlockOre (String name, Material material, Item item, int min, int max) {
      super(name, material);
      this.itemToDrop = item;
      this.minDropAmount = min;
      this.maxDropAmount = max;
   }
   @Override
   public Item getItemDropped(IBlockState blockstate, Random random, int i) {
      if (this.itemToDrop == null)
         return Item.getItemFromBlock(this);
      else
         return this.itemToDrop;
   }
   @Override
   public int quantityDropped (Random random) {
      if (this.minDropAmount>=this.maxDropAmount)
         return this.minDropAmount;
      else
         return this.minDropAmount + random.nextInt(this.maxDropAmount-this.minDropAmount+1);
   }
   @Override
   public int quantityDroppedWithBonus(int fortune, Random random) {
      if (fortune > 0 && Item.getItemFromBlock(this) != this.getItemDropped(this.getDefaultState(), random, fortune)) {
            int i = random.nextInt(fortune + 2) - 1;
            if (i < 0)
               i = 0;
            return this.quantityDropped(random) * (i + 1);
      } else
         return this.quantityDropped(random);  
   }
}
