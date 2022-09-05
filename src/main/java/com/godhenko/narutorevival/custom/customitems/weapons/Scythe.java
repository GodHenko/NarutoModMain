
package com.godhenko.narutorevival.custom.customitems.weapons;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;

public class Scythe extends SwordItem {
	public Scythe() {
		super(new Tier() {
			public int getUses() {
				return 3156;
			}

			public float getSpeed() {
				return 10f;
			}

			public float getAttackDamageBonus() {
				return 8f;
			}

			public int getLevel() {
				return 5;
			}

			public int getEnchantmentValue() {
				return 20;
			}

			public Ingredient getRepairIngredient() {
				return Ingredient.EMPTY;
			}
		}, 3, -2.2f, new Properties().tab(CreativeModeTab.TAB_COMBAT));
	}
}
