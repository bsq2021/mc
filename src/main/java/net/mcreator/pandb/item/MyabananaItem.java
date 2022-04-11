
package net.mcreator.pandb.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.util.ResourceLocation;
import net.minecraft.item.Rarity;
import net.minecraft.item.MusicDiscItem;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item;

import net.mcreator.pandb.PAndBModElements;

@PAndBModElements.ModElement.Tag
public class MyabananaItem extends PAndBModElements.ModElement {
	@ObjectHolder("p_and_b:myabanana")
	public static final Item block = null;

	public MyabananaItem(PAndBModElements instance) {
		super(instance, 11);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new MusicDiscItemCustom());
	}

	public static class MusicDiscItemCustom extends MusicDiscItem {
		public MusicDiscItemCustom() {
			super(0, PAndBModElements.sounds.get(new ResourceLocation("p_and_b:immabanana")),
					new Item.Properties().group(ItemGroup.MISC).maxStackSize(1).rarity(Rarity.RARE));
			setRegistryName("myabanana");
		}
	}
}
