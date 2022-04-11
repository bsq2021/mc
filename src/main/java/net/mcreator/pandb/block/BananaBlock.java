
package net.mcreator.pandb.block;

import net.minecraftforge.registries.ObjectHolder;
import net.minecraftforge.common.util.ForgeSoundType;
import net.minecraftforge.common.ToolType;

import net.minecraft.world.IBlockReader;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.ResourceLocation;
import net.minecraft.loot.LootContext;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item;
import net.minecraft.item.BlockItem;
import net.minecraft.block.material.Material;
import net.minecraft.block.BlockState;
import net.minecraft.block.Block;

import net.mcreator.pandb.item.BananaingotItem;
import net.mcreator.pandb.PAndBModElements;

import java.util.List;
import java.util.Collections;

@PAndBModElements.ModElement.Tag
public class BananaBlock extends PAndBModElements.ModElement {
	@ObjectHolder("p_and_b:banana")
	public static final Block block = null;

	public BananaBlock(PAndBModElements instance) {
		super(instance, 2);
	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new CustomBlock());
		elements.items.add(() -> new BlockItem(block, new Item.Properties().group(ItemGroup.DECORATIONS)).setRegistryName(block.getRegistryName()));
	}

	public static class CustomBlock extends Block {
		public CustomBlock() {
			super(Block.Properties.create(Material.ROCK)
					.sound(new ForgeSoundType(1.0f, 1.0f, () -> new SoundEvent(new ResourceLocation("ambient.underwater.loop.additions.ultra_rare")),
							() -> new SoundEvent(new ResourceLocation("ambient.underwater.loop.additions.rare")),
							() -> new SoundEvent(new ResourceLocation("ambient.underwater.loop.additions")),
							() -> new SoundEvent(new ResourceLocation("block.bubble_column.whirlpool_ambient")),
							() -> new SoundEvent(new ResourceLocation("block.bubble_column.whirlpool_inside"))))
					.hardnessAndResistance(0.5f, 5.5f).setLightLevel(s -> 0).harvestLevel(1).harvestTool(ToolType.PICKAXE).setRequiresTool()
					.slipperiness(5f).speedFactor(2.5f).jumpFactor(0.5f));
			setRegistryName("banana");
		}

		@Override
		public int getOpacity(BlockState state, IBlockReader worldIn, BlockPos pos) {
			return 15;
		}

		@Override
		public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {
			List<ItemStack> dropsOriginal = super.getDrops(state, builder);
			if (!dropsOriginal.isEmpty())
				return dropsOriginal;
			return Collections.singletonList(new ItemStack(BananaingotItem.block));
		}
	}
}
