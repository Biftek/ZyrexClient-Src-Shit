/*    */ package ZyrexClient.Gui.buttons;
/*    */ 
/*    */ import net.minecraft.client.Minecraft;
/*    */ import net.minecraft.client.gui.GuiButton;
/*    */ import net.minecraft.client.renderer.GlStateManager;
/*    */ import net.minecraft.util.ResourceLocation;
/*    */ 
/*    */ public class GuiButtonName
/*    */   extends GuiButton
/*    */ {
/* 11 */   protected static final ResourceLocation CustomButtons = new ResourceLocation("directory/template.png");
/*    */ 
/*    */   
/*    */   public GuiButtonName(int buttonID, int xPos, int yPos) {
/* 15 */     super(buttonID, xPos, yPos, 73, 20, "");
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void drawButton(Minecraft mc, int mouseX, int mouseY) {
/* 23 */     if (this.visible) {
/*    */       
/* 25 */       mc.getTextureManager().bindTexture(CustomButtons);
/* 26 */       GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
/* 27 */       boolean flag = (mouseX >= this.xPosition && mouseY >= this.yPosition && mouseX < this.xPosition + this.width && mouseY < this.yPosition + this.height);
/*    */       
/* 29 */       int i = 0;
/*    */       
/* 31 */       if (flag)
/*    */       {
/* 33 */         i += this.height;
/*    */       }
/*    */       
/* 36 */       drawTexturedModalRect(this.xPosition, this.yPosition, 0, i, this.width, this.height);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\Lenovo\Downloads\ZyrexClientV1 (1).jar!\ZyrexClient\Gui\buttons\GuiButtonName.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */