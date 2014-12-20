package com.testmad.gaiamod.handlers;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import com.testmad.gaiamod.amulets.ModAmulets;
import com.testmad.gaiamod.essence.ModEssence;
import com.testmad.gaiamod.stones.ModStones;

public class AltarRecipes {

	public AltarRecipes() {

	}

	public static ItemStack getAltarResult(Item item, Item item2, Item item3,
			Item item4) {
		return getOutput(item, item2, item3, item4);
	}

	private static ItemStack getOutput(Item item, Item item2, Item item3,
			Item item4) {
		if (item == ModEssence.earthEssenceItem
				&& item2 == Item.getItemFromBlock(Blocks.dirt)
				&& item3 == Item.getItemFromBlock(Blocks.dirt)
				&& item4 == ModStones.stoneItem) {
			return new ItemStack(ModStones.earthStoneItem, 1);
		}

		if (item == ModEssence.fireEssenceItem && item2 == Items.lava_bucket
				&& item3 == Items.lava_bucket && item4 == ModStones.stoneItem) {
			return new ItemStack(ModStones.fireStoneItem, 1);
		}

		if (item == ModEssence.windEssenceItem && item2 == Items.feather
				&& item3 == Items.feather && item4 == ModStones.stoneItem) {
			return new ItemStack(ModStones.windStoneItem, 1);
		}

		if (item == ModEssence.waterEssenceItem && item2 == Items.water_bucket
				&& item3 == Items.water_bucket && item4 == ModStones.stoneItem) {
			return new ItemStack(ModStones.waterStoneItem, 1);
		}

		if (item == ModEssence.heartEssenceItem && item2 == Items.porkchop
				&& item3 == Items.porkchop && item4 == ModStones.stoneItem) {
			return new ItemStack(ModStones.heartStoneItem, 1);
		}

		if (item == ModEssence.stormEssenceItem && item2 == Items.water_bucket
				&& item3 == Items.redstone && item4 == ModStones.stoneItem) {
			return new ItemStack(ModStones.stormStoneItem, 1);
		}

		if (item == ModEssence.chaosEssenceItem
				&& item2 == Item.getItemFromBlock(Blocks.obsidian)
				&& item3 == Items.diamond && item4 == ModStones.stoneItem) {
			return new ItemStack(ModStones.chaosStoneItem, 1);
		}

		if (item == ModEssence.orderEssenceItem && item2 == Items.diamond
				&& item3 == Items.emerald && item4 == ModStones.stoneItem) {
			return new ItemStack(ModStones.orderStoneItem, 1);
		}

		if (item == ModStones.earthStoneItem
				&& item2 == Item.getItemFromBlock(Blocks.dirt)
				&& item3 == Item.getItemFromBlock(Blocks.dirt)
				&& item4 == ModAmulets.amuletItem) {
			return new ItemStack(ModAmulets.earthAmuletItem, 1);
		}

		if (item == ModStones.fireStoneItem && item2 == Items.lava_bucket
				&& item3 == Items.lava_bucket && item4 == ModAmulets.amuletItem) {
			return new ItemStack(ModAmulets.fireAmuletItem, 1);
		}

		if (item == ModStones.windStoneItem && item2 == Items.feather
				&& item3 == Items.feather && item4 == ModAmulets.amuletItem) {
			return new ItemStack(ModAmulets.windAmuletItem, 1);
		}

		if (item == ModStones.waterStoneItem && item2 == Items.water_bucket
				&& item3 == Items.water_bucket
				&& item4 == ModAmulets.amuletItem) {
			return new ItemStack(ModAmulets.waterAmuletItem, 1);
		}

		if (item == ModStones.heartStoneItem && item2 == Items.porkchop
				&& item3 == Items.porkchop && item4 == ModAmulets.amuletItem) {
			return new ItemStack(ModAmulets.heartAmuletItem, 1);
		}

		if (item == ModStones.stormStoneItem && item2 == Items.water_bucket
				&& item3 == Items.redstone && item4 == ModAmulets.amuletItem) {
			return new ItemStack(ModAmulets.stormAmuletItem, 1);
		}

		if (item == ModStones.chaosStoneItem
				&& item2 == Item.getItemFromBlock(Blocks.obsidian)
				&& item3 == Items.diamond && item4 == ModAmulets.amuletItem) {
			return new ItemStack(ModAmulets.chaosAmuletItem, 1);
		}

		if (item == ModStones.orderStoneItem && item2 == Items.diamond
				&& item3 == Items.emerald && item4 == ModAmulets.amuletItem) {
			return new ItemStack(ModAmulets.orderAmuletItem, 1);
		}

		return null;
	}

	public static ItemStack getEnchantingResult(Item item, Item item2,
			ItemStack item3, ItemStack item4) {
		return getEnchanted(item, item2, item3, item4);
	}

	private static ItemStack getEnchanted(Item item, Item item2,
			ItemStack item3, ItemStack item4) {
		ItemStack result;

		if (item == ModAmulets.earthAmuletItem
				&& item2.getItemEnchantability() > 0) {
			if (item2 == Items.diamond_shovel || item2 == Items.diamond_pickaxe
					|| item2 == Items.diamond_axe || item2 == Items.shears) {
				int lvl = EnchantmentHelper.getEnchantmentLevel(
						Enchantment.efficiency.effectId, item4);
				if (lvl == 5) {
					return null;
				} else if (item3.stackSize < lvl) {
					return null;
				} else if (item3.stackSize > lvl) {
					result = new ItemStack(item2, 1);
					result.addEnchantment(Enchantment.efficiency, lvl + 1);
					return result;
				}
			} else if (item2 == Items.fishing_rod) {
				int lvl = EnchantmentHelper.getEnchantmentLevel(
						Enchantment.field_151369_A.effectId, item4);
				if (lvl == 3) {
					return null;
				} else if (item3.stackSize < lvl) {
					return null;
				} else if (item3.stackSize > lvl) {
					result = new ItemStack(item2, 1);
					result.addEnchantment(Enchantment.field_151369_A, lvl + 1);
					return result;
				}
			}
		}

		// todo add gaia swords//

		if (item == ModAmulets.fireAmuletItem
				&& item2.getItemEnchantability() > 0) {
			if (item2 == Items.diamond_sword) {
				int lvl = EnchantmentHelper.getEnchantmentLevel(
						Enchantment.fireAspect.effectId, item4);
				if (lvl == 2) {
					return null;
				} else if (item3.stackSize < lvl) {
					return null;
				} else if (item3.stackSize > lvl) {
					result = new ItemStack(item2, 1);
					result.addEnchantment(Enchantment.fireAspect, lvl + 1);
					return result;
				}
			} else if (item2 == Items.bow) {
				int lvl = EnchantmentHelper.getEnchantmentLevel(
						Enchantment.flame.effectId, item4);
				if (lvl == 1) {
					return null;
				} else if (item3.stackSize < lvl) {
					return null;
				} else if (item3.stackSize > lvl) {
					result = new ItemStack(item2, 1);
					result.addEnchantment(Enchantment.flame, lvl + 1);
					return result;
				}
			}
		}

		if (item == ModAmulets.windAmuletItem
				&& item2.getItemEnchantability() > 0) {
			if (item2 == Items.diamond_sword) {
				int lvl = EnchantmentHelper.getEnchantmentLevel(
						Enchantment.knockback.effectId, item4);
				if (lvl == 2) {
					return null;
				} else if (item3.stackSize < lvl) {
					return null;
				} else if (item3.stackSize > lvl) {
					result = new ItemStack(item2, 1);
					result.addEnchantment(Enchantment.knockback, lvl + 1);
					return result;
				}
			} else if (item2 == Items.bow) {
				int lvl = EnchantmentHelper.getEnchantmentLevel(
						Enchantment.punch.effectId, item4);
				if (lvl == 2) {
					return null;
				} else if (item3.stackSize < lvl) {
					return null;
				} else if (item3.stackSize > lvl) {
					result = new ItemStack(item2, 1);
					result.addEnchantment(Enchantment.punch, lvl + 1);
					return result;
				}
			}
		}

		if (item == ModAmulets.waterAmuletItem
				&& item2.getItemEnchantability() > 0) {
			if (item2 == Items.diamond_sword || item2 == Items.diamond_axe) {
				int lvl = EnchantmentHelper.getEnchantmentLevel(
						Enchantment.sharpness.effectId, item4);
				if (lvl == 5) {
					return null;
				} else if (item3.stackSize < lvl) {
					return null;
				} else if (item3.stackSize > lvl) {
					result = new ItemStack(item2, 1);
					result.addEnchantment(Enchantment.sharpness, lvl + 1);
					return result;
				}
			} else if (item2 == Items.bow) {
				int lvl = EnchantmentHelper.getEnchantmentLevel(
						Enchantment.power.effectId, item4);
				if (lvl == 5) {
					return null;
				} else if (item3.stackSize < lvl) {
					return null;
				} else if (item3.stackSize > lvl) {
					result = new ItemStack(item2, 1);
					result.addEnchantment(Enchantment.power, lvl + 1);
					return result;
				}
			}
		}

		if (item == ModAmulets.heartAmuletItem
				&& item2.getItemEnchantability() > 0) {
			if (item2 == Items.diamond_sword) {
				int lvl = EnchantmentHelper.getEnchantmentLevel(
						Enchantment.looting.effectId, item4);
				if (lvl == 3) {
					return null;
				} else if (item3.stackSize < lvl) {
					return null;
				} else if (item3.stackSize > lvl) {
					result = new ItemStack(item2, 1);
					result.addEnchantment(Enchantment.looting, lvl + 1);
					return result;
				}
			} else if (item2 == Items.diamond_axe) {
				int lvl = EnchantmentHelper.getEnchantmentLevel(
						Enchantment.smite.effectId, item4);
				if (lvl == 5) {
					return null;
				} else if (item3.stackSize < lvl) {
					return null;
				} else if (item3.stackSize > lvl) {
					result = new ItemStack(item2, 1);
					result.addEnchantment(Enchantment.smite, lvl + 1);
					return result;
				}
			} else if (item2 == Items.bow) {
				int lvl = EnchantmentHelper.getEnchantmentLevel(
						Enchantment.infinity.effectId, item4);
				if (lvl == 1) {
					return null;
				} else if (item3.stackSize < lvl) {
					return null;
				} else if (item3.stackSize > lvl) {
					result = new ItemStack(item2, 1);
					result.addEnchantment(Enchantment.infinity, lvl + 1);
					return result;
				}
			}
		}

		if (item == ModAmulets.stormAmuletItem
				&& item2.getItemEnchantability() > 0) {
			if (item2 == Items.diamond_pickaxe || item2 == Items.diamond_shovel
					|| item2 == Items.diamond_axe || item2 == Items.fishing_rod
					|| item2 == Items.diamond_sword || item2 == Items.bow
					|| item2 == Items.diamond_hoe || item2 == Items.shears
					|| item2 == Items.flint_and_steel
					|| item2 == Items.carrot_on_a_stick) {
				int lvl = EnchantmentHelper.getEnchantmentLevel(
						Enchantment.unbreaking.effectId, item4);
				if (lvl == 3) {
					return null;
				} else if (item3.stackSize < lvl) {
					return null;
				} else if (item3.stackSize > lvl) {
					result = new ItemStack(item2, 1);
					result.addEnchantment(Enchantment.unbreaking, lvl + 1);
					return result;
				}
			}
		}

		if (item == ModAmulets.chaosAmuletItem
				&& item2.getItemEnchantability() > 0) {
			if (item2 == Items.diamond_pickaxe || item2 == Items.diamond_shovel
					|| item2 == Items.diamond_axe || item2 == Items.shears) {
				if (EnchantmentHelper.getEnchantmentLevel(
						Enchantment.fortune.effectId, item4) > 0) {
					return null;
				} else {
					int lvl = EnchantmentHelper.getEnchantmentLevel(
							Enchantment.silkTouch.effectId, item4);
					if (lvl == 1) {
						return null;
					} else if (item3.stackSize < lvl) {
						return null;
					} else if (item3.stackSize > lvl) {
						result = new ItemStack(item2, 1);
						result.addEnchantment(Enchantment.silkTouch, lvl + 1);
						return result;
					}
				}
			}
		}

		if (item == ModAmulets.chaosAmuletItem
				&& item2.getItemEnchantability() > 0) {
			if (item2 == Items.diamond_pickaxe || item2 == Items.diamond_shovel
					|| item2 == Items.diamond_axe) {
				if (EnchantmentHelper.getEnchantmentLevel(
						Enchantment.silkTouch.effectId, item4) > 0) {
					return null;
				} else {
					int lvl = EnchantmentHelper.getEnchantmentLevel(
							Enchantment.fortune.effectId, item4);
					if (lvl == 3) {
						return null;
					} else if (item3.stackSize < lvl) {
						return null;
					} else if (item3.stackSize > lvl) {
						result = new ItemStack(item2, 1);
						result.addEnchantment(Enchantment.fortune, lvl + 1);
						return result;
					}
				}
			}
		}

		return null;

	}

	public static ItemStack getShrineResult(Item item) {
		// TODO Auto-generated method stub
		return null;
	}

}
