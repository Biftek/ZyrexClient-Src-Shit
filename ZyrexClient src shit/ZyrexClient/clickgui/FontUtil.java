/*    */ package ZyrexClient.clickgui;
/*    */ 
/*    */ import ZyrexClient.Gui.UnicodeFontRenderer;
/*    */ import java.awt.Color;
/*    */ import net.minecraft.client.Minecraft;
/*    */ import net.minecraft.client.gui.FontRenderer;
/*    */ import org.lwjgl.opengl.GL11;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class FontUtil
/*    */ {
/* 14 */   public static Minecraft mc = Minecraft.getMinecraft();
/* 15 */   public static FontRenderer fr = mc.clientFont;
/*    */   
/*    */   private static UnicodeFontRenderer ufr;
/*    */   
/*    */   public static void renderString(String text, int x, int y, int color, float fontSize) {
/* 20 */     if (ufr == null) {
/* 21 */       ufr = UnicodeFontRenderer.getFontOnPC("Arial", 20);
/*    */     }
/*    */     
/* 24 */     GL11.glPushMatrix();
/* 25 */     GL11.glScalef(fontSize, fontSize, 100.0F);
/* 26 */     ufr.drawString(text, x / fontSize, y / fontSize, color);
/* 27 */     GL11.glPopMatrix();
/*    */   }
/*    */ 
/*    */   
/*    */   public static int renderCenteredString(String text, int var7, int var8, int var1, float fontSize) {
/* 32 */     if (ufr == null) {
/* 33 */       ufr = UnicodeFontRenderer.getFontOnPC("Arial", 20);
/*    */     }
/*    */     
/* 36 */     GL11.glPushMatrix();
/* 37 */     GL11.glScalef(fontSize, fontSize, 100.0F);
/* 38 */     ufr.drawCenteredString(text, var7 / fontSize, var8 / fontSize, var1);
/* 39 */     GL11.glPopMatrix();
/* 40 */     return var1;
/*    */   }
/*    */ 
/*    */   
/*    */   public static int renderCenteredStringAnimated(String text, float f, float g, int var1, float fontSize) {
/* 45 */     if (ufr == null) {
/* 46 */       ufr = UnicodeFontRenderer.getFontOnPC("Arial", 20);
/*    */     }
/*    */     
/* 49 */     GL11.glPushMatrix();
/* 50 */     GL11.glScalef(fontSize, fontSize, 100.0F);
/* 51 */     ufr.drawCenteredString(text, f / fontSize, g / fontSize, var1);
/* 52 */     GL11.glPopMatrix();
/* 53 */     return var1;
/*    */   }
/*    */ 
/*    */   
/*    */   public static int renderStringThing(String text, int var7, int var8, int var1, int i, Color color, float fontSize) {
/* 58 */     if (ufr == null) {
/* 59 */       ufr = UnicodeFontRenderer.getFontOnPC("Arial", 20);
/*    */     }
/*    */     
/* 62 */     GL11.glPushMatrix();
/* 63 */     GL11.glScalef(fontSize, fontSize, 100.0F);
/* 64 */     ufr.drawCenteredString(text, var7 / fontSize, var8 / fontSize, var1);
/* 65 */     GL11.glPopMatrix();
/* 66 */     return var1;
/*    */   }
/*    */ 
/*    */   
/*    */   public static void renderStringWithShadow(String text, int x, int y, int color, float fontSize) {
/* 71 */     GL11.glPushMatrix();
/* 72 */     GL11.glScalef(fontSize, fontSize, 100.0F);
/* 73 */     fr.drawStringWithShadow(text, x / fontSize, y / fontSize, color);
/* 74 */     GL11.glPopMatrix();
/*    */   }
/*    */ 
/*    */   
/*    */   public static void renderString2a(String text, Object object, int x, Object object2, int y, int color, float fontSize, int i, int i2) {
/* 79 */     if (ufr == null) {
/* 80 */       ufr = UnicodeFontRenderer.getFontOnPC("Arial", 20);
/*    */     }
/*    */     
/* 83 */     GL11.glPushMatrix();
/* 84 */     GL11.glScalef(fontSize, fontSize, 100.0F);
/* 85 */     ufr.drawString(text, x / fontSize, y / fontSize, color);
/* 86 */     GL11.glPopMatrix();
/*    */   }
/*    */ }


/* Location:              C:\Users\Lenovo\Downloads\ZyrexClientV1 (1).jar!\ZyrexClient\clickgui\FontUtil.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */