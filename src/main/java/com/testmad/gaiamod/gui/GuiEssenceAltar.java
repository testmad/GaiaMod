package com.testmad.gaiamod.gui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;

import org.lwjgl.opengl.GL11;

import com.testmad.gaiamod.blocks.ModBlocks;
import com.testmad.gaiamod.containers.ContainerEssenceAltar;
import com.testmad.gaiamod.tileentities.TileEntityEssenceAltar;
import com.testmad.gaiamod.util.References;

public class GuiEssenceAltar extends GuiContainer{
	
	private ResourceLocation texture = new ResourceLocation(References.MODIDLOCAL + ":" + "textures/gui/GuiEssenceAltarBlock.png");
	private TileEntityEssenceAltar essenceAltar;
	
	public GuiEssenceAltar(InventoryPlayer invPlayer, TileEntityEssenceAltar entity) {
		super(new ContainerEssenceAltar(invPlayer, entity));
		essenceAltar = entity;
		
		this.xSize = 176;
		this.ySize = 166;
	}

	protected void drawGuiContainerForegroundLayer(int par1, int par2){
		
		String name = StatCollector.translateToLocal(ModBlocks.essenceAltarBlockIdle.getLocalizedName());
		this.fontRendererObj.drawString(name, this.xSize / 2 - this.fontRendererObj.getStringWidth(name) / 2, 6, 4210752);
		this.fontRendererObj.drawString(I18n.format("container.inventory", new Object[0]), this.xSize /2 - this.fontRendererObj.getStringWidth(I18n.format("container.inventory", new Object[0])) / 2, this.ySize - 96 +2, 4210752);
		
	}
	
	@Override
	protected void drawGuiContainerBackgroundLayer(float var1, int var2, int var3) {
		
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		Minecraft.getMinecraft().getTextureManager().bindTexture(texture);
		drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);
		
		//do power
		if(essenceAltar.hasWaterPower()){
			int i1 = essenceAltar.getWaterRemainingScaled(43);
			drawTexturedModalRect(guiLeft + 11, guiTop + 53 - i1, 176, 43-i1,14,i1 );
		}
		
		if(essenceAltar.hasLavaPower()){
			int i1 = essenceAltar.getLavaRemainingScaled(43);
			drawTexturedModalRect(guiLeft + 151, guiTop + 53 - i1, 190, 43-i1,14,i1 );
		}
		
		if(essenceAltar.hasChanceLevel()){
			int i1 = essenceAltar.getChanceProgressScaled(43);
			drawTexturedModalRect(guiLeft + 86, guiTop + 64 - i1, 204, 43 - i1,6,i1);
		}
		
		if(essenceAltar.hasEssenceLevel()){
			int i1 = essenceAltar.getEssenceProgressScaled(43);
			drawTexturedModalRect(guiLeft + 102, guiTop + 64 - i1, 210, 43 - i1,6,i1);
		}
		//do cooking
					
			
			
			
		
	}

}
