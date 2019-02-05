package luxmod.blocks;

import java.util.ArrayList;

import luxmod.init.ModItems;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

public class BlockOreMultiple extends BlockBasic {
   public BlockOreMultiple(String name, Material material) {
      super(name, material);
   }
   @Override
   public ArrayList<ItemStack> getDrops(IBlockAccess world, BlockPos pos, IBlockState blockstate, int fortune) {
      ArrayList<ItemStack> drops = new ArrayList<ItemStack>();
      drops.add(new ItemStack(ModItems.luxDust1, RANDOM.nextInt(6)+2));
      drops.add(new ItemStack(ModItems.luxItem1, 1));
      
      return drops;  
      
   }
}
