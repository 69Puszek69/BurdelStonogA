
package net.mcreator.neomod.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.world.World;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.block.BlockState;

import net.mcreator.neomod.itemgroup.GunZItemGroup;
import net.mcreator.neomod.NeomodModElements;

import java.util.List;

@NeomodModElements.ModElement.Tag
public class HeavyAmmoItem extends NeomodModElements.ModElement {
	@ObjectHolder("neomod:heavy_ammo")
	public static final Item block = null;
	public HeavyAmmoItem(NeomodModElements instance) {
		super(instance, 1);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}
	public static class ItemCustom extends Item {
		public ItemCustom() {
			super(new Item.Properties().group(GunZItemGroup.tab).maxStackSize(64));
			setRegistryName("heavy_ammo");
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

		@Override
		public void addInformation(ItemStack itemstack, World world, List<ITextComponent> list, ITooltipFlag flag) {
			super.addInformation(itemstack, world, list, flag);
			list.add(new StringTextComponent("Heavy Ammo"));
			list.add(new StringTextComponent("mostly used by Sniper Rifles"));
		}
	}
}
