package com.testmad.gaiamod.gui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;

import org.lwjgl.opengl.GL11;

import com.testmad.gaiamod.blocks.ModBlocks;
import com.testmad.gaiamod.containers.ContainerOrderShrine;
import com.testmad.gaiamod.tileentities.TileEntityOrderShrine;
import com.testmad.gaiamod.util.References;

public class GuiOrderShrine extends GuiContainer {

	private ResourceLocation texture = new ResourceLocation(
			References.MODIDLOCAL + ":"
					+ "textures/gui/GuiOrderShrineBlock.png");
	private TileEntityOrderShrine orderShrine;

	public GuiOrderShrine(InventoryPlayer invPlayer,
			TileEntityOrderShrine entity) {
		super(new ContainerOrderShrine(invPlayer, entity));
		orderShrine = entity;

		this.xSize = 176;
		this.ySize = 166;
	}

	@Override
	protected void drawGuiContainerForegroundLayer(int par1, int par2) {

		String name = StatCollector
				.translateToLocal(ModBlocks.orderShrineBlockIdle
						.getLocalizedName());
		this.fontRendererObj.drawString(name, this.xSize / 2
				- this.fontRendererObj.getStringWidth(name) / 2, 6, 4210752);
		this.fontRendererObj.drawString(
				I18n.format("container.inventory", new Object[0]),
				this.xSize
						/ 2
						- this.fontRendererObj.getStringWidth(I18n.format(
								"container.inventory", new Object[0])) / 2,
				this.ySize - 96 + 2, 4210752);

	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float var1, int var2,
			int var3) {

		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		Minecraft.getMinecraft().getTextureManager().bindTexture(texture);
		drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);

		// do power
		if (orderShrine.hasEssencePower()) {
			int i1 = orderShrine.getEssenceRemainingScaled(43);
			drawTexturedModalRect(guiLeft + 77, guiTop + 63 - i1, 176, 43 - i1,
					14, i1);
		}
	}
}
