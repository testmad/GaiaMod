package gaiamod.gui;

import gaiamod.containers.ContainerGaiaAltarBlock;
import gaiamod.tileentities.TileEntityGaiaAltarBlock;
import gaiamod.util.References;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

public class GuiGaiaAltarBlock extends GuiContainer{
	
	public static final ResourceLocation texture = new ResourceLocation(References.MODID + ":" + "textures/gui/GuiGaiaAltarBlock.png");

	public TileEntityGaiaAltarBlock gaiaAltarBlock;
	
	public GuiGaiaAltarBlock(InventoryPlayer inventoryPlayer, TileEntityGaiaAltarBlock entity) {
		super(new ContainerGaiaAltarBlock(inventoryPlayer, entity));

		this.gaiaAltarBlock = entity;
		
		this.xSize = 176;
		this.ySize = 166;
	}

	protected void drawGuiContainerForegroundLayer(int par1, int par2){
		String name = this.gaiaAltarBlock.hasCustomInventoryName() ? this.gaiaAltarBlock.getInventoryName() : I18n.format(this.gaiaAltarBlock.getInventoryName(), new Object[0]);
		this.fontRendererObj.drawString(name, this.xSize / 2 - this.fontRendererObj.getStringWidth(name) / 2, 6, 4210752);
		this.fontRendererObj.drawString(I18n.format("container.inventory", new Object[0]), this.xSize /2 - this.fontRendererObj.getStringWidth(I18n.format("container.inventory", new Object[0])) / 2, this.ySize - 96 +2, 4210752);
		
	}
	
	@Override
	protected void drawGuiContainerBackgroundLayer(float var1, int var2, int var3) {
		
		GL11.glColor4f(1f, 1f, 1f, 1f);
		
		Minecraft.getMinecraft().getTextureManager().bindTexture(texture);
		
		drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);
	}

}
