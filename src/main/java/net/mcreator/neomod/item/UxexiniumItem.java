
package net.mcreator.neomod.item;

@NeomodModElements.ModElement.Tag
public class UxexiniumItem extends NeomodModElements.ModElement {

	@ObjectHolder("neomod:uxexinium")
	public static final Item block = null;

	public UxexiniumItem(NeomodModElements instance) {
		super(instance, 21);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}

	public static class ItemCustom extends Item {

		public ItemCustom() {
			super(new Item.Properties().group(GunZItemGroup.tab).maxStackSize(64));
			setRegistryName("uxexinium");
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