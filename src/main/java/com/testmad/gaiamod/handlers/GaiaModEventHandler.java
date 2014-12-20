package com.testmad.gaiamod.handlers;

import java.lang.reflect.Field;
import java.util.UUID;

import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.IAttributeInstance;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.PlayerCapabilities;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraftforge.client.event.EntityViewRenderEvent;
import net.minecraftforge.client.event.FOVUpdateEvent;
import net.minecraftforge.client.event.RenderBlockOverlayEvent;
import net.minecraftforge.event.entity.EntityStruckByLightningEvent;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.event.entity.living.LivingEvent.LivingJumpEvent;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;

import org.lwjgl.opengl.GL11;

import com.testmad.gaiamod.armor.ModArmor;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.relauncher.ReflectionHelper;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class GaiaModEventHandler {
	private static final UUID wtvID = UUID
			.fromString("641470a0-ff51-4598-bdae-210184bbe083");

	private static Field flySpeedField;

	@SideOnly(Side.CLIENT)
	@SubscribeEvent
	public void onFOVUpdate(FOVUpdateEvent event) {
		IAttributeInstance atinst = event.entity
				.getEntityAttribute(SharedMonsterAttributes.movementSpeed);
		AttributeModifier mod;
		if ((mod = atinst.getModifier(wtvID)) != null) {
			event.newfov = (event.newfov * 2.0f) - 1.0f; // Reversal operation,
															// as seen in
															// EntityPlayerSP
			event.newfov = event.newfov / (float) (1.0 + mod.getAmount()); // Earth
																			// speed
																			// modifier
			event.newfov = (event.newfov + 1.0f) / 2.0f;
		}
	}

	@SideOnly(Side.CLIENT)
	@SubscribeEvent
	public void EntityViewRenderEvent(EntityViewRenderEvent.FogDensity event) {
		EntityLivingBase entityLiving = event.entity;

		if (hasEquippedSet(entityLiving, ModArmor.fireHelmet,
				ModArmor.fireChest, ModArmor.fireLeggings, ModArmor.fireBoots)
				|| hasEquippedSet(entityLiving, ModArmor.chaosHelmet,
						ModArmor.chaosChest, ModArmor.chaosLeggings,
						ModArmor.chaosBoots)
				|| hasEquippedSet(entityLiving, ModArmor.orderHelmet,
						ModArmor.orderChest, ModArmor.orderLeggings,
						ModArmor.orderBoots)) {
			if (event.entity.isInsideOfMaterial(Material.lava)) {
				event.setCanceled(true);
				event.density = 0.2f;
				GL11.glFogi(GL11.GL_FOG_MODE, GL11.GL_EXP);

			}
		}
	}

	@SideOnly(Side.CLIENT)
	@SubscribeEvent
	public void EntityViewRenderEvent(EntityViewRenderEvent.FogColors event) {
		EntityLivingBase entityLiving = event.entity;

		if (hasEquippedSet(entityLiving, ModArmor.fireHelmet,
				ModArmor.fireChest, ModArmor.fireLeggings, ModArmor.fireBoots)
				|| hasEquippedSet(entityLiving, ModArmor.chaosHelmet,
						ModArmor.chaosChest, ModArmor.chaosLeggings,
						ModArmor.chaosBoots)
				|| hasEquippedSet(entityLiving, ModArmor.orderHelmet,
						ModArmor.orderChest, ModArmor.orderLeggings,
						ModArmor.orderBoots)) {
			if (event.entity.isInsideOfMaterial(Material.lava)) {
				event.red = 0.5f;
				event.green = 0;
				event.blue = 0;
			}
		}
	}

	@SideOnly(Side.CLIENT)
	@SubscribeEvent
	public void EntityViewRenderEvent(RenderBlockOverlayEvent event) {
		EntityLivingBase entityLiving = event.player;

		if (hasEquippedSet(entityLiving, ModArmor.fireHelmet,
				ModArmor.fireChest, ModArmor.fireLeggings, ModArmor.fireBoots)
				|| hasEquippedSet(entityLiving, ModArmor.chaosHelmet,
						ModArmor.chaosChest, ModArmor.chaosLeggings,
						ModArmor.chaosBoots)
				|| hasEquippedSet(entityLiving, ModArmor.orderHelmet,
						ModArmor.orderChest, ModArmor.orderLeggings,
						ModArmor.orderBoots)) {
			if (event.player.isInsideOfMaterial(Material.lava)) {
				event.setCanceled(true);

			}
		}
	}

	@SubscribeEvent
	public void onPlayerUpdate(LivingUpdateEvent event) {
		EntityLivingBase entityLiving = event.entityLiving;

		boolean isChaosEquipped = hasEquippedSet(entityLiving,
				ModArmor.chaosHelmet, ModArmor.chaosChest,
				ModArmor.chaosLeggings, ModArmor.chaosBoots);
		boolean isOrderEquipped = hasEquippedSet(entityLiving,
				ModArmor.orderHelmet, ModArmor.orderChest,
				ModArmor.orderLeggings, ModArmor.orderBoots);
		boolean isEarthEquipped = hasEquippedSet(entityLiving,
				ModArmor.earthHelmet, ModArmor.earthChest,
				ModArmor.earthLeggings, ModArmor.earthBoots);
		boolean isWaterEquipped = hasEquippedSet(entityLiving,
				ModArmor.waterHelmet, ModArmor.waterChest,
				ModArmor.waterLeggings, ModArmor.waterBoots);
		boolean isHeartEquipped = hasEquippedSet(entityLiving,
				ModArmor.heartHelmet, ModArmor.heartChest,
				ModArmor.heartLeggings, ModArmor.heartBoots);
		boolean isFireEquipped = hasEquippedSet(entityLiving,
				ModArmor.fireHelmet, ModArmor.fireChest, ModArmor.fireLeggings,
				ModArmor.fireBoots);
		boolean isWindEquipped = hasEquippedSet(entityLiving,
				ModArmor.windHelmet, ModArmor.windChest, ModArmor.windLeggings,
				ModArmor.windBoots);

		if (!entityLiving.isSneaking()
				&& (isEarthEquipped || isChaosEquipped || isOrderEquipped))
			entityLiving.stepHeight = 1.0f;
		else
			entityLiving.stepHeight = 0.5f;

		if (isWindEquipped || isChaosEquipped || isOrderEquipped) {
			entityLiving.fallDistance = 0.0f;
			if (entityLiving.isSneaking()) {
				entityLiving.jumpMovementFactor = .25F;
			}
		} else {
			entityLiving.jumpMovementFactor = .02F;
		}

		IAttributeInstance atinst = entityLiving
				.getEntityAttribute(SharedMonsterAttributes.movementSpeed);
		if (isEarthEquipped) {
			if (atinst.getModifier(wtvID) == null) {
				atinst.applyModifier(new AttributeModifier(wtvID, "Gaia", 0.4,
						2));
			}
		} else {
			AttributeModifier mod;
			if ((mod = atinst.getModifier(wtvID)) != null) {
				atinst.removeModifier(mod);
			}
		}

		if (entityLiving instanceof EntityPlayer) {
			EntityPlayer player = (EntityPlayer) entityLiving;

			if (isWaterEquipped || isChaosEquipped || isOrderEquipped)
				player.setAir(300);

			boolean flyingInWater = player.isInWater() && isWaterEquipped;
			boolean flyingInLava = player.isInsideOfMaterial(Material.lava)
					&& isFireEquipped;
			boolean flyingWithPower = isChaosEquipped || isOrderEquipped;

			player.capabilities.allowFlying = flyingInLava || flyingInWater
					|| flyingWithPower || player.capabilities.isCreativeMode;

			if (flyingInLava || flyingInWater)
				setPlayerFlySpeed(player.capabilities, flyingInWater ? 0.03f
						: 0.02f);
			else
				setPlayerFlySpeed(player.capabilities, 0.05f);

			if (!player.capabilities.allowFlying)
				player.capabilities.isFlying = false;

			if (isHeartEquipped || isChaosEquipped || isOrderEquipped) {
				player.getFoodStats().addStats(20, 5.0f);
			}
		}
	}

	@SubscribeEvent
	public void onLivingAttack(LivingAttackEvent event) {
		EntityLivingBase entityLiving = event.entityLiving;

		if ((event.source != null && event.source == DamageSource.lava
				|| event.source == DamageSource.inFire || event.source == DamageSource.onFire)
				&& (hasEquippedSet(entityLiving, ModArmor.fireHelmet,
						ModArmor.fireChest, ModArmor.fireLeggings,
						ModArmor.fireBoots)
						|| hasEquippedSet(entityLiving, ModArmor.chaosHelmet,
								ModArmor.chaosChest, ModArmor.chaosLeggings,
								ModArmor.chaosBoots) || hasEquippedSet(
							entityLiving, ModArmor.orderHelmet,
							ModArmor.orderChest, ModArmor.orderLeggings,
							ModArmor.orderBoots))) {
			event.setCanceled(true);
			entityLiving.extinguish();
		}
	}

	@SubscribeEvent
	public void onLightningStrike(EntityStruckByLightningEvent event) {
		Entity entityLiving = event.entity;

		if (hasEquippedSet(entityLiving, ModArmor.stormHelmet,
				ModArmor.stormChest, ModArmor.stormLeggings,
				ModArmor.stormBoots)
				|| hasEquippedSet(entityLiving, ModArmor.chaosHelmet,
						ModArmor.chaosChest, ModArmor.chaosLeggings,
						ModArmor.chaosBoots)
				|| hasEquippedSet(entityLiving, ModArmor.orderHelmet,
						ModArmor.orderChest, ModArmor.orderLeggings,
						ModArmor.orderBoots)) {
			event.setCanceled(true);
		}
	}

	@SubscribeEvent
	public void onLivingHurt(LivingHurtEvent event) {
		EntityLivingBase attackedEntity = event.entityLiving;
		Entity attackerEntity = event.source.getEntity();

		if (event.source.getSourceOfDamage() instanceof EntityArrow
				&& ((hasEquippedSet(attackerEntity, ModArmor.stormHelmet,
						ModArmor.stormChest, ModArmor.stormLeggings,
						ModArmor.stormBoots))
						|| (hasEquippedSet(attackerEntity,
								ModArmor.chaosHelmet, ModArmor.chaosChest,
								ModArmor.chaosLeggings, ModArmor.chaosBoots)) || (hasEquippedSet(
							attackerEntity, ModArmor.orderHelmet,
							ModArmor.orderChest, ModArmor.orderLeggings,
							ModArmor.orderBoots)))) {
			double i = attackedEntity.posX;
			double j = attackedEntity.posY;
			double k = attackedEntity.posZ;

			EntityLightningBolt entityLightningBolt = new EntityLightningBolt(
					attackerEntity.worldObj, i, j, k);
			attackerEntity.worldObj.addWeatherEffect(entityLightningBolt);
		}
	}

	@SubscribeEvent
	public void onLivingJumpEvent(LivingJumpEvent event) {
		EntityLivingBase entityLiving = event.entityLiving;

		if (entityLiving.isSneaking()
				&& ((hasEquippedSet(entityLiving, ModArmor.windHelmet,
						ModArmor.windChest, ModArmor.windLeggings,
						ModArmor.windBoots))
						|| (hasEquippedSet(entityLiving, ModArmor.chaosHelmet,
								ModArmor.chaosChest, ModArmor.chaosLeggings,
								ModArmor.chaosBoots)) || (hasEquippedSet(
							entityLiving, ModArmor.orderHelmet,
							ModArmor.orderChest, ModArmor.orderLeggings,
							ModArmor.orderBoots)))) {
			entityLiving.motionY += 0.5;
			entityLiving.velocityChanged = true;
		}
	}

	private static void setPlayerFlySpeed(PlayerCapabilities capabilities,
			float flySpeed) {
		if (flySpeedField == null) {
			flySpeedField = ReflectionHelper.findField(
					PlayerCapabilities.class, "flySpeed", "field_75096_f");
			flySpeedField.setAccessible(true);
		}

		try {
			flySpeedField.set(capabilities, flySpeed);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
	}

	private static boolean hasEquippedSet(Entity entity, Item... setItems) {
		if (!(entity instanceof EntityLivingBase))
			return false;

		EntityLivingBase entityLivingBase = (EntityLivingBase) entity;

		for (Item item : setItems) {
			int slot = EntityLiving.getArmorPosition(new ItemStack(item));
			ItemStack equippedItem = entityLivingBase.getEquipmentInSlot(slot);
			if (equippedItem == null || equippedItem.getItem() != item)
				return false;
		}

		return true;
	}
}
