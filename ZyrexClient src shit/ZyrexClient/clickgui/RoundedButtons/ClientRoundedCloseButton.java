/*    */ package ZyrexClient.clickgui.RoundedButtons;
/*    */ 
/*    */ import java.awt.Color;
/*    */ import net.minecraft.client.Minecraft;
/*    */ import net.minecraft.client.gui.FontRenderer;
/*    */ import net.minecraft.client.gui.Gui;
/*    */ import net.minecraft.client.gui.GuiButton;
/*    */ import net.minecraft.client.gui.GuiScreen;
/*    */ import net.minecraft.client.renderer.Tessellator;
/*    */ import net.minecraft.client.renderer.WorldRenderer;
/*    */ import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
/*    */ import net.minecraft.util.ResourceLocation;
/*    */ import org.lwjgl.opengl.GL11;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ClientRoundedCloseButton
/*    */   extends GuiButton
/*    */ {
/*    */   public ClientRoundedCloseButton(int buttonId, int x, int y, int widthIn, int heightIn, String buttonText) {
/* 23 */     super(buttonId, x, y, widthIn, heightIn, buttonText);
/*    */   }
/*    */   
/*    */   public void drawButton(Minecraft mc, int mouseX, int mouseY) {
/* 27 */     if (this.visible) {
/* 28 */       FontRenderer fr = mc.fontRendererObj;
/*    */       
/* 30 */       GuiScreen.mc.getTextureManager().bindTexture(new ResourceLocation("zyrex_logo.png"));
/* 31 */       Gui.drawModalRectWithCustomSizedTexture(10, 10, 10.0F, 1.0F, this.width, this.height, this.width, this.height);
/*    */       
/* 33 */       this.hovered = (mouseX >= this.xPosition && mouseY >= this.yPosition && mouseX < this.xPosition + this.width && mouseY < this.yPosition + this.height);
/* 34 */       drawRoundedRect(this.xPosition + this.width, this.yPosition + this.height, this.xPosition, this.yPosition, 10, new Color(255, 84, 84));
/* 35 */       int j = -1;
/* 36 */       if (this.hovered) {
/* 37 */         j = -11184641;
/*    */       }
/* 39 */       drawCenteredString(fr, this.displayString, this.xPosition + this.width / 2, this.yPosition + (this.height - 8) / 2, j);
/*    */     } 
/*    */   }
/*    */   
/*    */   private void drawRoundedRect(int x, int y, int width, int height, int cornerRadius, Color color) {
/* 44 */     drawRect(x, y + cornerRadius, x + cornerRadius, y + height - cornerRadius, color.getRGB());
/* 45 */     drawRect(x + cornerRadius, y, x + width - cornerRadius, y + height, color.getRGB());
/* 46 */     drawRect(x + width - cornerRadius, y + cornerRadius, x + width, y + height - cornerRadius, color.getRGB());
/* 47 */     drawArc(x + cornerRadius, y + cornerRadius, cornerRadius, 0, 90, color);
/* 48 */     drawArc(x + width - cornerRadius, y + cornerRadius, cornerRadius, 270, 360, color);
/* 49 */     drawArc(x + width - cornerRadius, y + height - cornerRadius, cornerRadius, 180, 270, color);
/* 50 */     drawArc(x + cornerRadius, y + height - cornerRadius, cornerRadius, 90, 180, color);
/*    */   }
/*    */   
/*    */   private void drawArc(int x, int y, int radius, int startAngle, int endAngle, Color color) {
/* 54 */     GL11.glPushMatrix();
/* 55 */     GL11.glEnable(3042);
/* 56 */     GL11.glDisable(3553);
/* 57 */     GL11.glBlendFunc(770, 771);
/* 58 */     GL11.glColor4f(color.getRed() / 255.0F, color.getGreen() / 255.0F, color.getBlue() / 255.0F, color.getAlpha() / 255.0F);
/*    */     
/* 60 */     WorldRenderer worldRenderer = Tessellator.getInstance().getWorldRenderer();
/*    */     
/* 62 */     worldRenderer.begin(6, DefaultVertexFormats.POSITION);
/* 63 */     worldRenderer.pos(x, y, 0.0D).endVertex();
/*    */     
/* 65 */     for (int i = (int)(startAngle / 360.0D * 100.0D); i <= (int)(endAngle / 360.0D * 100.0D); i++) {
/* 66 */       double angle = 6.283185307179586D * i / 100.0D + Math.toRadians(180.0D);
/* 67 */       worldRenderer.pos(x + Math.sin(angle) * radius, y + Math.cos(angle) * radius, 0.0D).endVertex();
/*    */     } 
/*    */     
/* 70 */     Tessellator.getInstance().draw();
/*    */     
/* 72 */     GL11.glEnable(3553);
/* 73 */     GL11.glDisable(3042);
/* 74 */     GL11.glPopMatrix();
/*    */   }
/*    */ }


/* Location:              C:\Users\Lenovo\Downloads\ZyrexClientV1 (1).jar!\ZyrexClient\clickgui\RoundedButtons\ClientRoundedCloseButton.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */