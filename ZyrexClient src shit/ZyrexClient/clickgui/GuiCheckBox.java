/*    */ package ZyrexClient.clickgui;
/*    */ 
/*    */ import java.awt.Color;
/*    */ import net.minecraft.client.Minecraft;
/*    */ import net.minecraft.client.gui.FontRenderer;
/*    */ import net.minecraft.client.gui.GuiButton;
/*    */ import net.minecraft.client.renderer.GlStateManager;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class GuiCheckBox
/*    */   extends GuiButton
/*    */ {
/*    */   private boolean checked;
/*    */   private static final String X = "✗";
/*    */   private static final String CHECK = "✔";
/* 17 */   private static final Color X_COLOR = Color.RED;
/* 18 */   private static final Color CHECK_COLOR = Color.GREEN;
/*    */   
/*    */   public GuiCheckBox(int buttonId, int x, int y) {
/* 21 */     this(buttonId, x, y, false);
/*    */   }
/*    */   
/*    */   public GuiCheckBox(int buttonId, int x, int y, boolean checked) {
/* 25 */     super(buttonId, x, y, 20, 20, "");
/* 26 */     this.checked = checked;
/*    */   }
/*    */ 
/*    */   
/*    */   public void drawButton(Minecraft mc, int mouseX, int mouseY) {
/* 31 */     if (this.visible) {
/* 32 */       FontRenderer fontrenderer = mc.fontRendererObj;
/* 33 */       mc.getTextureManager().bindTexture(buttonTextures);
/* 34 */       GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
/* 35 */       this.hovered = (mouseX >= this.xPosition && mouseY >= this.yPosition && mouseX < this.xPosition + this.width && mouseY < this.yPosition + this.height);
/* 36 */       int i = getHoverState(this.hovered);
/* 37 */       GlStateManager.enableBlend();
/* 38 */       GlStateManager.tryBlendFuncSeparate(770, 771, 1, 0);
/* 39 */       GlStateManager.blendFunc(770, 771);
/* 40 */       drawTexturedModalRect(this.xPosition, this.yPosition, 0, 46 + i * 20, this.width / 2, this.height);
/* 41 */       drawTexturedModalRect(this.xPosition + this.width / 2, this.yPosition, 200 - this.width / 2, 46 + i * 20, this.width / 2, this.height);
/* 42 */       mouseDragged(mc, mouseX, mouseY);
/*    */       
/* 44 */       this.displayString = "✗";
/* 45 */       int color = X_COLOR.getRGB();
/*    */       
/* 47 */       if (this.checked) {
/* 48 */         this.displayString = "✔";
/* 49 */         color = CHECK_COLOR.getRGB();
/*    */       } 
/*    */       
/* 52 */       drawCenteredString(fontrenderer, this.displayString, this.xPosition + this.width / 2, this.yPosition + (this.height - 8) / 2, color);
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean mousePressed(Minecraft mc, int mouseX, int mouseY) {
/* 60 */     if (super.mousePressed(mc, mouseX, mouseY)) {
/* 61 */       this.checked = !this.checked;
/* 62 */       return true;
/*    */     } 
/*    */     
/* 65 */     return false;
/*    */   }
/*    */   
/*    */   public boolean isChecked() {
/* 69 */     return this.checked;
/*    */   }
/*    */   
/*    */   public void setChecked(boolean checked) {
/* 73 */     this.checked = checked;
/*    */   }
/*    */ }


/* Location:              C:\Users\Lenovo\Downloads\ZyrexClientV1 (1).jar!\ZyrexClient\clickgui\GuiCheckBox.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */