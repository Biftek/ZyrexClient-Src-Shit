/*    */ package ZyrexClient.clickgui.RoundedButtons;
/*    */ 
/*    */ import java.awt.Color;
/*    */ import net.minecraft.client.Minecraft;
/*    */ import net.minecraft.client.gui.FontRenderer;
/*    */ import net.minecraft.client.gui.GuiButton;
/*    */ import net.minecraft.client.renderer.Tessellator;
/*    */ import net.minecraft.client.renderer.WorldRenderer;
/*    */ import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
/*    */ import org.lwjgl.opengl.GL11;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ClientRoundedButton
/*    */   extends GuiButton
/*    */ {
/*    */   public ClientRoundedButton(int buttonId, int x, int y, int widthIn, int heightIn, String buttonText) {
/* 22 */     super(buttonId, x, y, widthIn, heightIn, buttonText);
/*    */   }
/*    */   
/*    */   public void drawButton(Minecraft mc, int mouseX, int mouseY) {
/* 26 */     if (this.visible) {
/* 27 */       FontRenderer fr = mc.fontRendererObj;
/* 28 */       this.hovered = (mouseX >= this.xPosition && mouseY >= this.yPosition && mouseX < this.xPosition + this.width && mouseY < this.yPosition + this.height);
/* 29 */       int j = -1;
/* 30 */       if (this.hovered) {
/* 31 */         j = -11184641;
/*    */       }
/* 33 */       drawRoundedRect(this.xPosition + this.width, this.yPosition + this.height, this.xPosition, this.yPosition, 3, new Color(20, 20, 20));
/*    */       
/* 35 */       drawCenteredString(fr, this.displayString, this.xPosition + this.width / 2, this.yPosition + (this.height - 8) / 2, j);
/*    */     } 
/*    */   }
/*    */   
/*    */   private void drawRoundedRect(int x, int y, int width, int height, int cornerRadius, Color color) {
/* 40 */     drawRect(x, y + cornerRadius, x + cornerRadius, y + height - cornerRadius, color.getRGB());
/* 41 */     drawRect(x + cornerRadius, y, x + width - cornerRadius, y + height, color.getRGB());
/* 42 */     drawRect(x + width - cornerRadius, y + cornerRadius, x + width, y + height - cornerRadius, color.getRGB());
/* 43 */     drawArc(x + cornerRadius, y + cornerRadius, cornerRadius, 0, 90, color);
/* 44 */     drawArc(x + width - cornerRadius, y + cornerRadius, cornerRadius, 270, 360, color);
/* 45 */     drawArc(x + width - cornerRadius, y + height - cornerRadius, cornerRadius, 180, 270, color);
/* 46 */     drawArc(x + cornerRadius, y + height - cornerRadius, cornerRadius, 90, 180, color);
/*    */   }
/*    */   
/*    */   private void drawArc(int x, int y, int radius, int startAngle, int endAngle, Color color) {
/* 50 */     GL11.glPushMatrix();
/* 51 */     GL11.glEnable(3042);
/* 52 */     GL11.glDisable(3553);
/* 53 */     GL11.glBlendFunc(770, 771);
/* 54 */     GL11.glColor4f(color.getRed() / 255.0F, color.getGreen() / 255.0F, color.getBlue() / 255.0F, color.getAlpha() / 255.0F);
/*    */     
/* 56 */     WorldRenderer worldRenderer = Tessellator.getInstance().getWorldRenderer();
/*    */     
/* 58 */     worldRenderer.begin(6, DefaultVertexFormats.POSITION);
/* 59 */     worldRenderer.pos(x, y, 0.0D).endVertex();
/*    */     
/* 61 */     for (int i = (int)(startAngle / 360.0D * 100.0D); i <= (int)(endAngle / 360.0D * 100.0D); i++) {
/* 62 */       double angle = 6.283185307179586D * i / 100.0D + Math.toRadians(180.0D);
/* 63 */       worldRenderer.pos(x + Math.sin(angle) * radius, y + Math.cos(angle) * radius, 0.0D).endVertex();
/*    */     } 
/*    */     
/* 66 */     Tessellator.getInstance().draw();
/*    */     
/* 68 */     GL11.glEnable(3553);
/* 69 */     GL11.glDisable(3042);
/* 70 */     GL11.glPopMatrix();
/*    */   }
/*    */ }


/* Location:              C:\Users\Lenovo\Downloads\ZyrexClientV1 (1).jar!\ZyrexClient\clickgui\RoundedButtons\ClientRoundedButton.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */