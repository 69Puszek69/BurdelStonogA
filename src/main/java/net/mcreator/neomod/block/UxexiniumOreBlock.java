
package net.mcreator.neomod.block;

import net.minecraft.block.material.Material;

@NeomodModElements.ModElement.Tag
public class UxexiniumOreBlock extends NeomodModElements.ModElement {

	@ObjectHolder("neomod:uxexinium_ore")
	public static final Block block = null;

	public UxexiniumOreBlock(NeomodModElements instance) {
		super(instance, 23);

	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new CustomBlock());
		elements.items.add(() -> new BlockItem(block, new Item.Properties().group(GunZItemGroup.tab)).setRegistryName(block.getRegistryName()));
	}

	public static class CustomBlock extends Block {

		public CustomBlock() {
			super(

					Block.Properties.create(Material.ROCK).sound(SoundType.METAL).hardnessAndResistance(4f, 19.5f).lightValue(0));

			setRegistryName("uxexinium_ore");
		}

		@Override
		public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {
			List<ItemStack> dropsOriginal = super.getDrops(state, builder);
			if (!dropsOriginal.isEmpty())
				return dropsOriginal;
			return Collections.singletonList(new ItemStack(UxexiniumItem.block, (int) (1)));
		}

	}

}
