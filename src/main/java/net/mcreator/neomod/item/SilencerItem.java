
package net.mcreator.neomod.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.block.BlockState;

import net.mcreator.neomod.itemgroup.GunZItemGroup;
import net.mcreator.neomod.NeomodModElements;

@NeomodModElements.ModElement.Tag
public class SilencerItem extends NeomodModElements.ModElement {
	@ObjectHolder("neomod:silencer")
	public static final Item block = null;
	public SilencerItem(NeomodModElements instance) {
		super(instance, 17);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}
	public static class ItemCustom extends Item {
		public ItemCustom() {
			super(new Item.Properties().group(GunZItemGroup.tab).maxStackSize(64));
			setRegistryName("silencer");
		}

		@Override
		public int getItemEnchantability() {
			return 0;
		}

		@Override
		public int getUseDuration(ItemStack itemstack) {
			return 0;
		}

		@Override
		public float getDestroySpeed(ItemStack par1ItemStack, BlockState par2Block) {
			return 1F;
		}
	}
}
