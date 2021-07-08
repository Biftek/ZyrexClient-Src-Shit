/*    */ package ZyrexClient.mods.impl;
/*    */ 
/*    */ import java.awt.Color;
/*    */ import net.minecraft.client.Minecraft;
/*    */ 
/*    */ 
/*    */ public class SmoothColorLerping
/*    */ {
/*    */   public static Color rainbowEffect(long offset, float fade) {
/* 10 */     float hue = (float)(System.nanoTime() + offset) / 1.0E10F % 1.0F;
/* 11 */     long color = Long.parseLong(Integer.toHexString(Integer.valueOf(Color.HSBtoRGB(hue, 1.0F, 1.0F)).intValue()), 16);
/* 12 */     Color c = new Color((int)color);
/* 13 */     return new Color(c.getRed() / 255.0F * fade, c.getGreen() / 255.0F * fade, c.getBlue() / 255.0F * fade, c.getAlpha() / 255.0F);
/*    */   }
/*    */   
/*    */   public static Color rainbowEffectFast(long offset, float fade) {
/* 17 */     float hue = (float)(System.nanoTime() + offset) / 1.0E10F % 1.0F;
/* 18 */     long color = Long.parseLong(Integer.toHexString(Integer.valueOf(Color.HSBtoRGB(hue, 1.0F, 1.0F)).intValue()), 19);
/* 19 */     Color c = new Color((int)color);
/* 20 */     return new Color(c.getRed() / 255.0F * fade, c.getGreen() / 255.0F * fade, c.getBlue() / 255.0F * fade, c.getAlpha() / 255.0F);
/*    */   }
/*    */   
/*    */   public static class RainbowColor
/*    */   {
/*    */     public static int getColor() {
/* 26 */       long l = System.currentTimeMillis();
/* 27 */       return Color.HSBtoRGB((float)(l % 2000L) / 2000.0F, 0.8F, 0.8F);
/*    */     }
/*    */   }
/*    */   
/*    */   public static Color colorLerpv2(Color start, Color end, float ratio) {
/* 32 */     int red = (int)Math.abs(ratio * start.getRed() + (1.0F - ratio) * end.getRed());
/* 33 */     int green = (int)Math.abs(ratio * start.getGreen() + (1.0F - ratio) * end.getGreen());
/* 34 */     int blue = (int)Math.abs(ratio * start.getBlue() + (1.0F - ratio) * end.getBlue());
/*    */     
/* 36 */     return new Color(red, green, blue);
/*    */   }
/*    */   
/*    */   public static void drawChromaString(String string, int x, int y, boolean shadow) {
/* 40 */     Minecraft mc = Minecraft.getMinecraft();
/*    */     
/* 42 */     int xTmp = x; byte b; int i; char[] arrayOfChar;
/* 43 */     for (i = (arrayOfChar = string.toCharArray()).length, b = 0; b < i; ) { char textChar = arrayOfChar[b];
/* 44 */       long l = System.currentTimeMillis() - (xTmp * 10 - y * 10);
/* 45 */       int j = Color.HSBtoRGB((float)(l % 2000L) / 2000.0F, 0.8F, 0.8F);
/* 46 */       String tmp = String.valueOf(textChar);
/* 47 */       mc.fontRendererObj.drawString(tmp, xTmp, y, j, shadow);
/* 48 */       xTmp += mc.fontRendererObj.getCharWidth(textChar);
/*    */       b++; }
/*    */   
/*    */   }
/*    */   public static int getChromaColor() {
/* 53 */     Minecraft mc = Minecraft.getMinecraft();
/*    */     
/* 55 */     int xTmp = 1;
/* 56 */     long l = System.currentTimeMillis() - (xTmp * 10 - 10);
/* 57 */     int i = Color.HSBtoRGB((float)(l % 2000L) / 2000.0F, 0.8F, 0.8F);
/* 58 */     return i;
/*    */   }
/*    */ }


/* Location:              C:\Users\Lenovo\Downloads\ZyrexClientV1 (1).jar!\ZyrexClient\mods\impl\SmoothColorLerping.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */