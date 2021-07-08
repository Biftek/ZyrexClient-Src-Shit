/*    */ package ZyrexClient;
/*    */ 
/*    */ import net.minecraft.client.gui.Gui;
/*    */ import org.lwjgl.opengl.GL11;
/*    */ 
/*    */ public class NewRoundedRect
/*    */ {
/*    */   public static void drawHollowRect(int x, int y, int w, int h, int color) {
/*  9 */     drawHorizontalLine(x, x + w, y, color);
/* 10 */     drawHorizontalLine(x, x + w, y + h, color);
/* 11 */     drawVerticalLine(x, y + h, y, color);
/* 12 */     drawVerticalLine(x + w, y + h, y, color);
/*    */   }
/*    */ 
/*    */   
/*    */   public static void drawHorizontalLine(int startX, int endX, int y, int color) {
/* 17 */     if (endX < startX) {
/*    */       
/* 19 */       int i = startX;
/* 20 */       startX = endX;
/* 21 */       endX = i;
/*    */     } 
/*    */     
/* 24 */     Gui.drawRect(startX, y, endX + 1, y + 1, color);
/*    */   }
/*    */ 
/*    */   
/*    */   public static void drawVerticalLine(int x, int startY, int endY, int color) {
/* 29 */     if (endY < startY) {
/*    */       
/* 31 */       int i = startY;
/* 32 */       startY = endY;
/* 33 */       endY = i;
/*    */     } 
/*    */     
/* 36 */     Gui.drawRect(x, startY + 1, x + 1, endY, color);
/*    */   }
/*    */   
/*    */   public static void drawRoundedRect(double x, double y, double x1, double y1, double radius, int color) {
/* 40 */     GL11.glPushAttrib(0);
/* 41 */     GL11.glScaled(0.5D, 0.5D, 0.5D);
/* 42 */     x *= 2.0D;
/* 43 */     y *= 2.0D;
/* 44 */     x1 *= 2.0D;
/* 45 */     y1 *= 2.0D;
/* 46 */     GL11.glEnable(3042);
/* 47 */     GL11.glDisable(3553);
/* 48 */     setColor(color);
/* 49 */     GL11.glEnable(2848);
/* 50 */     GL11.glBegin(9); int i;
/* 51 */     for (i = 0; i <= 90; i += 3) {
/* 52 */       GL11.glVertex2d(x + radius + Math.sin(i * Math.PI / 180.0D) * radius * -1.0D, y + radius + Math.cos(i * Math.PI / 180.0D) * radius * -1.0D);
/*    */     }
/* 54 */     for (i = 90; i <= 180; i += 3) {
/* 55 */       GL11.glVertex2d(x + radius + Math.sin(i * Math.PI / 180.0D) * radius * -1.0D, y1 - radius + Math.cos(i * Math.PI / 180.0D) * radius * -1.0D);
/*    */     }
/*    */     
/* 58 */     for (i = 0; i <= 90; i += 3) {
/* 59 */       GL11.glVertex2d(x1 - radius + Math.sin(i * Math.PI / 180.0D) * radius, y1 - radius + Math.cos(i * Math.PI / 180.0D) * radius);
/*    */     }
/*    */     
/* 62 */     for (i = 90; i <= 180; i += 3) {
/* 63 */       GL11.glVertex2d(x1 - radius + Math.sin(i * Math.PI / 180.0D) * radius, y + radius + Math.cos(i * Math.PI / 180.0D) * radius);
/*    */     }
/*    */     
/* 66 */     GL11.glEnd();
/*    */     
/* 68 */     GL11.glEnable(3553);
/* 69 */     GL11.glDisable(3042);
/* 70 */     GL11.glDisable(2848);
/* 71 */     GL11.glDisable(3042);
/* 72 */     GL11.glEnable(3553);
/*    */     
/* 74 */     GL11.glScaled(2.0D, 2.0D, 2.0D);
/*    */     
/* 76 */     GL11.glPopAttrib();
/*    */   }
/*    */   
/*    */   public static void drawBorderedRoundedRect(float x, float y, float x1, float y1, float borderSize, int borderC, int insideC) {
/* 80 */     drawRoundedRect(x, y, x1, y1, borderSize, borderC);
/* 81 */     drawRoundedRect((x + 0.5F), (y + 0.5F), (x1 - 0.5F), (y1 - 0.5F), borderSize, insideC);
/*    */   }
/*    */   
/*    */   public static void drawBorderedRoundedRect2(float x, float y, float x1, float y1, float borderSize, int insideC) {
/* 85 */     drawRoundedRect((x + 0.5F), (y + 0.5F), (x1 - 0.5F), (y1 - 0.5F), borderSize, insideC);
/*    */   }
/*    */   
/*    */   public static void drawBorderedRoundedRect(float x, float y, float x1, float y1, float radius, float borderSize, int borderC, int insideC) {
/* 89 */     drawRoundedRect(x, y, x1, y1, radius, borderC);
/* 90 */     drawRoundedRect((x + borderSize), (y + borderSize), (x1 - borderSize), (y1 - borderSize), radius, insideC);
/*    */   }
/*    */   
/*    */   public static void setColor(int color) {
/* 94 */     float a = (color >> 24 & 0xFF) / 255.0F;
/* 95 */     float r = (color >> 16 & 0xFF) / 255.0F;
/* 96 */     float g = (color >> 8 & 0xFF) / 255.0F;
/* 97 */     float b = (color & 0xFF) / 255.0F;
/* 98 */     GL11.glColor4f(r, g, b, a);
/*    */   }
/*    */ }


/* Location:              C:\Users\Lenovo\Downloads\ZyrexClientV1 (1).jar!\ZyrexClient\NewRoundedRect.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */