/*    */ package ZyrexClient.mods.impl;
/*    */ 
/*    */ import ZyrexClient.Client;
/*    */ import ZyrexClient.Gui.ScreenPosition;
/*    */ import ZyrexClient.mods.ModDraggable;
/*    */ import net.minecraft.client.Minecraft;
/*    */ import org.lwjgl.opengl.GL11;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ZyrexModMotionBlur
/*    */   extends ModDraggable
/*    */ {
/*    */   public int getWidth() {
/* 15 */     if (Client.MotionBlurHideFromHud) {
/* 16 */       return 106;
/*    */     }
/* 18 */     return 0;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public int getHeight() {
/* 24 */     if (Client.MotionBlurHideFromHud) {
/* 25 */       return 10;
/*    */     }
/* 27 */     return 0;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void render(ScreenPosition pos) {
/* 33 */     if (Client.MotionBlurHideFromHud) {
/* 34 */       this.font.drawString("[Motion Blur Toggled]", (pos.getAbsoluteX() + 2), (pos.getAbsoluteY() + 2), -1);
/*    */     }
/*    */   }
/*    */ 
/*    */   
/*    */   public static class MotionBlur
/*    */   {
/*    */     private static final int multiplier = 10;
/*    */     
/*    */     private static long lastTimestampInGame;
/*    */     
/*    */     public static void createAccumulation() {
/* 46 */       if (Client.MotionBlur) {
/* 47 */         float value = getAccumulationValue();
/* 48 */         GL11.glAccum(259, value);
/* 49 */         GL11.glAccum(256, 1.0F - value);
/* 50 */         GL11.glAccum(258, 1.0F);
/*    */       } 
/*    */     }
/*    */ 
/*    */ 
/*    */     
/*    */     public static int getFps() {
/* 57 */       Minecraft.getMinecraft(); return Minecraft.getDebugFPS();
/*    */     }
/*    */     
/*    */     public static float getMultiplier() {
/* 61 */       return (getFps() > 120) ? ((getFps() > 200) ? 50.0F : 30.0F) : 0.0F;
/*    */     }
/*    */     
/*    */     public static float getAccumulationValue() {
/* 65 */       float percent = getMultiplier() * 10.0F;
/* 66 */       lastTimestampInGame = System.currentTimeMillis();
/* 67 */       if (percent > 996.0F) {
/* 68 */         percent = 996.0F;
/*    */       }
/* 70 */       if (percent > 990.0F) {
/* 71 */         percent = 990.0F;
/*    */       }
/* 73 */       long fadeOut = System.currentTimeMillis() - lastTimestampInGame;
/* 74 */       if (fadeOut > 10000L) {
/* 75 */         return 0.0F;
/*    */       }
/* 77 */       if (percent < 0.0F) {
/* 78 */         percent = 0.0F;
/*    */       }
/* 80 */       return percent / 1000.0F;
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Users\Lenovo\Downloads\ZyrexClientV1 (1).jar!\ZyrexClient\mods\impl\ZyrexModMotionBlur.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */