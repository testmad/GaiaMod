package gaiamod.handlers;

import gaiamod.armor.ModArmor;

import java.util.UUID;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraftforge.client.event.FOVUpdateEvent;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.event.entity.living.LivingEvent.LivingJumpEvent;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import cpw.mods.fml.common.eventhandler.Event.Result;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class GaiaModEventHandler {
	
	private static final UUID wtvID = UUID.fromString("641470a0-ff51-4598-bdae-210184bbe083");
	
	@SubscribeEvent
	public void onFOVUpdate(FOVUpdateEvent event){
		event.setResult(Result.DEFAULT);
	}

	@SubscribeEvent
	public void onEntityUpdate(LivingUpdateEvent event){
		EntityLivingBase entityLiving = event.entityLiving;
		
		if(entityLiving instanceof EntityPlayer && entityLiving.worldObj.isRemote){
			EntityPlayer entityPlayer = (EntityPlayer) entityLiving;
			
			ItemStack helm = entityPlayer.getCurrentArmor(3);
			ItemStack chest = entityPlayer.getCurrentArmor(2);
			ItemStack legs = entityPlayer.getCurrentArmor(1);
			ItemStack boots = entityPlayer.getCurrentArmor(0);
			
			if(helm !=null && chest !=null & legs !=null && boots !=null && !entityPlayer.capabilities.isCreativeMode){
				if (helm.getItem() == ModArmor.earthHelmet && chest.getItem() == ModArmor.earthChest && legs.getItem() == ModArmor.earthLeggings && boots.getItem() == ModArmor.earthBoots && !entityPlayer.capabilities.isCreativeMode){
					
					if(!entityPlayer.isSneaking()){
						entityPlayer.stepHeight = 1.0f;
					}else{
					entityPlayer.stepHeight = 0.5f;
					} 
					
				}
				
				if (helm.getItem() == ModArmor.chaosHelmet && chest.getItem() == ModArmor.chaosChest && legs.getItem() == ModArmor.chaosLeggings && boots.getItem() == ModArmor.chaosBoots && !entityPlayer.capabilities.isCreativeMode){
					
					if(!entityPlayer.isSneaking()){
						entityPlayer.stepHeight = 1.0f;
					}else{
					entityPlayer.stepHeight = 0.5f;
					} 
					
				}
				
				if (helm.getItem() == ModArmor.orderHelmet && chest.getItem() == ModArmor.orderChest && legs.getItem() == ModArmor.orderLeggings && boots.getItem() == ModArmor.orderBoots && !entityPlayer.capabilities.isCreativeMode){
					
					if(!entityPlayer.isSneaking()){
						entityPlayer.stepHeight = 1.0f;
					}else{
					entityPlayer.stepHeight = 0.5f;
					} 
					
				}
			}else{
				entityPlayer.stepHeight = 0.5f;
				
			}
		}
		
		if(entityLiving instanceof EntityPlayer){
			EntityPlayer entityPlayer = (EntityPlayer) entityLiving;
			
			ItemStack helm = entityPlayer.getCurrentArmor(3);
			ItemStack chest = entityPlayer.getCurrentArmor(2);
			ItemStack legs = entityPlayer.getCurrentArmor(1);
			ItemStack boots = entityPlayer.getCurrentArmor(0);
			
			if(helm !=null && chest !=null & legs !=null && boots !=null){
				if (helm.getItem() == ModArmor.earthHelmet && chest.getItem() == ModArmor.earthChest && legs.getItem() == ModArmor.earthLeggings && boots.getItem() == ModArmor.earthBoots && !entityPlayer.capabilities.isCreativeMode){
					
					entityPlayer.capabilities.setPlayerWalkSpeed(0.2f);
					entityPlayer.sendPlayerAbilities();
				}
				
				if (helm.getItem() == ModArmor.fireHelmet && chest.getItem() == ModArmor.fireChest && legs.getItem() == ModArmor.fireLeggings && boots.getItem() == ModArmor.fireBoots && !entityPlayer.capabilities.isCreativeMode){

				}
				
				if (helm.getItem() == ModArmor.windHelmet && chest.getItem() == ModArmor.windChest && legs.getItem() == ModArmor.windLeggings && boots.getItem() == ModArmor.windBoots && !entityPlayer.capabilities.isCreativeMode){
					
					entityPlayer.fallDistance = 0.0f;
					entityPlayer.jumpMovementFactor = .05F;
				}
				
				if (helm.getItem() == ModArmor.waterHelmet && chest.getItem() == ModArmor.waterChest && legs.getItem() == ModArmor.waterLeggings && boots.getItem() == ModArmor.waterBoots && !entityPlayer.capabilities.isCreativeMode){
					entityPlayer.setAir(300);
				}
				
				if (helm.getItem() == ModArmor.heartHelmet && chest.getItem() == ModArmor.heartChest && legs.getItem() == ModArmor.heartLeggings && boots.getItem() == ModArmor.heartBoots && !entityPlayer.capabilities.isCreativeMode){
					
					entityPlayer.getFoodStats().addStats(20, 5.0f);
				}
				
				if (helm.getItem() == ModArmor.stormHelmet && chest.getItem() == ModArmor.stormChest && legs.getItem() == ModArmor.stormLeggings && boots.getItem() == ModArmor.stormBoots && !entityPlayer.capabilities.isCreativeMode){

					
				}
				
				if (helm.getItem() == ModArmor.chaosHelmet && chest.getItem() == ModArmor.chaosChest && legs.getItem() == ModArmor.chaosLeggings && boots.getItem() == ModArmor.chaosBoots && !entityPlayer.capabilities.isCreativeMode){
					
					entityPlayer.getFoodStats().addStats(20, 5.0f);
					entityPlayer.setAir(300);
					entityPlayer.fallDistance = 0.0f;
					entityPlayer.jumpMovementFactor = .05F;
					entityPlayer.capabilities.setPlayerWalkSpeed(0.2f);
					entityPlayer.capabilities.allowFlying = true;
					entityPlayer.sendPlayerAbilities();
					
				}
				
				if (helm.getItem() == ModArmor.orderHelmet && chest.getItem() == ModArmor.orderChest && legs.getItem() == ModArmor.orderLeggings && boots.getItem() == ModArmor.orderBoots && !entityPlayer.capabilities.isCreativeMode){

					entityPlayer.getFoodStats().addStats(20, 5.0f);
					entityPlayer.setAir(300);
					entityPlayer.fallDistance = 0.0f;
					entityPlayer.jumpMovementFactor = .05F;
					entityPlayer.capabilities.setPlayerWalkSpeed(0.2f);
					entityPlayer.capabilities.allowFlying = true;
					entityPlayer.sendPlayerAbilities();
				}
				
			}else{
				entityPlayer.capabilities.setPlayerWalkSpeed(0.1f);
				entityPlayer.capabilities.setFlySpeed(.05f);
				entityPlayer.capabilities.allowFlying = false;
				entityPlayer.capabilities.isFlying = false;
				entityPlayer.sendPlayerAbilities();
				
			}
		}
	}
	
	@SubscribeEvent
	public void onLivingAttack(LivingAttackEvent event){
		EntityLivingBase entityLiving = event.entityLiving;
		if(entityLiving instanceof EntityPlayer){
			EntityPlayer entityPlayer = (EntityPlayer) entityLiving;
			
			ItemStack helm = entityPlayer.getCurrentArmor(3);
			ItemStack chest = entityPlayer.getCurrentArmor(2);
			ItemStack legs = entityPlayer.getCurrentArmor(1);
			ItemStack boots = entityPlayer.getCurrentArmor(0);
			
			if(helm !=null && chest !=null & legs !=null && boots !=null){
				
				if (helm.getItem() == ModArmor.fireHelmet && chest.getItem() == ModArmor.fireChest && legs.getItem() == ModArmor.fireLeggings && boots.getItem() == ModArmor.fireBoots && !entityPlayer.capabilities.isCreativeMode){
					if(event.source != null && event.source == DamageSource.lava || event.source == DamageSource.inFire || event.source == DamageSource.onFire){
						event.setCanceled(true);
						entityPlayer.extinguish();

					}
				}
				
				if (helm.getItem() == ModArmor.chaosHelmet && chest.getItem() == ModArmor.chaosChest && legs.getItem() == ModArmor.chaosLeggings && boots.getItem() == ModArmor.chaosBoots && !entityPlayer.capabilities.isCreativeMode){
					if(event.source != null && event.source == DamageSource.lava || event.source == DamageSource.inFire || event.source == DamageSource.onFire){
						event.setCanceled(true);
						entityPlayer.extinguish();

					}
				}
				
				if (helm.getItem() == ModArmor.orderHelmet && chest.getItem() == ModArmor.orderChest && legs.getItem() == ModArmor.orderLeggings && boots.getItem() == ModArmor.orderBoots && !entityPlayer.capabilities.isCreativeMode){
					if(event.source != null && event.source == DamageSource.lava || event.source == DamageSource.inFire || event.source == DamageSource.onFire){
						event.setCanceled(true);
						entityPlayer.extinguish();

					}
				}
			}
		}
	}
	
	@SubscribeEvent
	public void onLivingHurt(LivingHurtEvent event){
		EntityLivingBase attackedEntity = event.entityLiving;
		DamageSource attackerEntity = event.source;
		
		if(attackerEntity.getEntity() instanceof EntityPlayer){
			EntityPlayer entityPlayer = (EntityPlayer) attackerEntity.getEntity();
			ItemStack itemHeld = entityPlayer.getHeldItem();
			if(itemHeld.getItem() == Items.bow){
				double i = attackedEntity.posX;
				double j = attackedEntity.posY;
				double k = attackedEntity.posZ;
				
				EntityLightningBolt entityLightningBolt = new EntityLightningBolt(entityPlayer.worldObj, i, j, k);
				
				entityPlayer.worldObj.addWeatherEffect(entityLightningBolt);
			}
		}
	}
	
	@SubscribeEvent
	public void onLivingJumpEvent(LivingJumpEvent event){
		EntityLivingBase entityLiving = event.entityLiving;
		if (entityLiving instanceof EntityPlayer)
		{
			double addY = 0.3D;
			EntityPlayer entityPlayer = (EntityPlayer) entityLiving;
			
			ItemStack helm = entityPlayer.getCurrentArmor(3);
			ItemStack chest = entityPlayer.getCurrentArmor(2);
			ItemStack legs = entityPlayer.getCurrentArmor(1);
			ItemStack boots = entityPlayer.getCurrentArmor(0);
			
			if(helm !=null && chest !=null & legs !=null && boots !=null){
				if (helm.getItem() == ModArmor.windHelmet && chest.getItem() == ModArmor.windChest && legs.getItem() == ModArmor.windLeggings && boots.getItem() == ModArmor.windBoots && !entityPlayer.capabilities.isCreativeMode){

					entityPlayer.motionY +=addY;
					entityPlayer.velocityChanged = true;
				}
				
				if (helm.getItem() == ModArmor.chaosHelmet && chest.getItem() == ModArmor.chaosChest && legs.getItem() == ModArmor.chaosLeggings && boots.getItem() == ModArmor.chaosBoots && !entityPlayer.capabilities.isCreativeMode){

					entityPlayer.motionY +=addY;
					entityPlayer.velocityChanged = true;
				}
				
				if (helm.getItem() == ModArmor.orderHelmet && chest.getItem() == ModArmor.orderChest && legs.getItem() == ModArmor.orderLeggings && boots.getItem() == ModArmor.orderBoots && !entityPlayer.capabilities.isCreativeMode){

					entityPlayer.motionY +=addY;
					entityPlayer.velocityChanged = true;
				}
			}
		}
	}
}
