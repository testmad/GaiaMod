package gaiamod.gui;

import org.lwjgl.opengl.GL11;

import gaiamod.util.References;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;

public class GuiGaiaAltarBlock extends GuiContainer{

	private ResourceLocation texture = new ResourceLocation(References.MODID + ":" + "textures/gui/WorkSurface.png");
	public GuiGaiaAltarBlock(InventoryPlayer invPlayer, World world, int x, int y, int z) {
		super(new ContainerGaiaAltarBlock(invPlayer, x, y, z));

		this.xSize = 176;
		this.ySize = 166;
	}

	public void onGuiClosed() {
		super.onGuiClosed();
	}
	
	protected void drawGuiContainerForegroundLayer(int i, int j){
		
		this.fontRendererObj.drawString(StatCollector.translateToLocal("Work Surface"), 100, 5, 0x000000);
		
	}
	
	@Override
	protected void drawGuiContainerBackgroundLayer(float var1, int var2, int var3) {
		
		GL11.glColor4f(1f, 1f, 1f, 1f);
		
		Minecraft.getMinecraft().getTextureManager().bindTexture(texture);
		
		drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);
	}

}
