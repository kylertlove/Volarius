package net.nerds.volarius.resourcePlants.farmer;

import com.mojang.blaze3d.platform.GlStateManager;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.gui.screen.ingame.AbstractContainerScreen;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.util.Identifier;
import net.nerds.volarius.Volarius;

@Environment(EnvType.CLIENT)
public class FarmingUnitGui extends AbstractContainerScreen {

    public Identifier farmerGui = new Identifier(Volarius.MODID, "textures/gui/farming_unit_gui.png");
    public FarmingUnitBlockEntity tile;
    public int guiLeft, guiTop;


    public FarmingUnitGui(FarmingUnitBlockEntity farmingUnitBlockEntity, FarmingUnitContainer farmingUnitContainer) {
        super(farmingUnitContainer, farmingUnitContainer.playerInventory, new TextComponent("farming_unit"));
        this.tile = farmingUnitBlockEntity;
    }

    @Override
    protected void init() {
        super.init();
        this.guiLeft = (this.width - this.containerWidth) / 2;
        this.guiTop = (this.height - this.containerHeight) / 2;
    }

    @Override
    public void render(int var1, int var2, float var3) {
        this.renderBackground();
        super.render(var1, var2, var3);
        this.drawMouseoverTooltip(var1, var2);
    }

    @Override
    public void drawForeground(int int_1, int int_2) {
        String string_1 = "Farmer";
        this.font.draw(string_1, (float) (this.containerWidth / 2 - this.font.getStringWidth(string_1) / 2), 6.0F, 4210752);
    }

    @Override
    public void drawBackground(float v, int i, int i1) {
        GlStateManager.color4f(1.0F, 1.0F, 1.0F, 1.0F);
        minecraft.getTextureManager().bindTexture(farmerGui);
        blit(guiLeft, guiTop, 0, 0, containerWidth, containerHeight);
    }
}
