package luxmod.items;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemEffectFood extends ItemCustomFood {
   public ItemEffectFood(String name, int fillAmount, float sat, boolean wolf) {
      super(name, fillAmount, sat, wolf);
      setAlwaysEdible();
   }
   
   @Override
   protected void onFoodEaten(ItemStack stack, World worldIn, EntityPlayer player) {
      if (!worldIn.isRemote) {
         player.addPotionEffect(new PotionEffect(MobEffects.JUMP_BOOST, 60*20, 5, false, true));
         player.addPotionEffect(new PotionEffect(MobEffects.HASTE, 30*20, 10, false, true));
      }
   }
   
   @SideOnly(Side.CLIENT)
   public boolean hasEffect(ItemStack stack) {
      return true;
   }
}
