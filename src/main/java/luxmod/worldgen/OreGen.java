package luxmod.worldgen;

import java.util.Random;

import com.google.common.base.Predicate;

import luxmod.init.ModBlocks;
import net.minecraft.block.state.IBlockState;
import net.minecraft.block.state.pattern.BlockMatcher;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraftforge.fml.common.IWorldGenerator;

public class OreGen implements IWorldGenerator {

   @Override
   public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator,
         IChunkProvider chunkProvider) {
      
      switch(world.provider.getDimension()) {
         //Nether
         case -1:
            break;
      
         //Overworld
         case 0:
            runGenerator(ModBlocks.luxBlockOre1.getDefaultState(), 8, 5, 0, 32, BlockMatcher.forBlock(Blocks.STONE), world, random, chunkX, chunkZ);
            break;
         
         //End
         case 1:
            runGenerator(Blocks.DIAMOND_BLOCK.getDefaultState(), 30, 50, 0, 255, BlockMatcher.forBlock(Blocks.END_STONE), world, random, chunkX, chunkZ);
            break;
            
         //Everything else
         default:
            break;
      
      }
   }
   
   private void runGenerator(IBlockState blockToGen, int amount, int chance, int minHeight, int maxHeight, Predicate<IBlockState> blockToReplace, World world, Random random, int chunkX, int chunkZ) {
      
      if (minHeight < 0 || maxHeight > 256 || minHeight > maxHeight) {
         throw new IllegalArgumentException("Illegal Heigth Arguments for WorldGenerator");
      }
      
      WorldGenMinable generator = new WorldGenMinable(blockToGen, amount, blockToReplace);
      int heightDiff = maxHeight - minHeight +1;
      for (int i = 0; i < chance; i++) {
         int x = chunkX * 16 + random.nextInt(16);
         int y = minHeight + random.nextInt(heightDiff);
         int z = chunkZ * 16 + random.nextInt(16);
         
         generator.generate(world, random, new BlockPos(x,y,z));
      }
   }
}
