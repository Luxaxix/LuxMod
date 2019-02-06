package luxmod.items;

import net.minecraft.item.ItemFood;

public class ItemCustomFood extends ItemFood {
   public ItemCustomFood(String name, int fillAmount, float sat, boolean wolf) {
      super(fillAmount, sat, wolf);
      setUnlocalizedName(name);
      setRegistryName(name);
   }

}
