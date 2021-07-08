/*    */ package ZyrexClient.Gui;
/*    */ 
/*    */ import net.minecraft.client.Minecraft;
/*    */ import net.minecraft.client.gui.ScaledResolution;
/*    */ 
/*    */ public class ScreenPosition
/*    */ {
/*  8 */   private static final Minecraft mc = Minecraft.getMinecraft();
/*    */   private int x;
/*    */   private int y;
/*    */   
/*    */   public ScreenPosition(double x, double y) {
/* 13 */     setRelative(x, y);
/*    */   }
/*    */   
/*    */   public ScreenPosition(int x, int y) {
/* 17 */     setAbsolute(x, y);
/*    */   }
/*    */   
/*    */   public static ScreenPosition fromRelativePosition(double x, double y) {
/* 21 */     return new ScreenPosition(x, y);
/*    */   }
/*    */   
/*    */   public static ScreenPosition fromAbsolute(int x, int y) {
/* 25 */     return new ScreenPosition(x, y);
/*    */   }
/*    */   
/*    */   public int getAbsoluteX() {
/* 29 */     return this.x;
/*    */   }
/*    */   
/*    */   public int getAbsoluteY() {
/* 33 */     return this.y;
/*    */   }
/*    */   
/*    */   public double getRelativeX() {
/* 37 */     ScaledResolution sr = new ScaledResolution(mc);
/* 38 */     return this.x / sr.getScaledWidth_double();
/*    */   }
/*    */   
/*    */   public double getRelativeY() {
/* 42 */     ScaledResolution sr = new ScaledResolution(mc);
/* 43 */     return this.y / sr.getScaledHeight_double();
/*    */   }
/*    */   
/*    */   public void setAbsolute(int x, int y) {
/* 47 */     this.x = x;
/* 48 */     this.y = y;
/*    */   }
/*    */   
/*    */   public void setRelative(double x, double y) {
/* 52 */     ScaledResolution sr = new ScaledResolution(mc);
/* 53 */     this.x = (int)(sr.getScaledWidth() / x);
/* 54 */     this.y = (int)(sr.getScaledHeight() / y);
/*    */   }
/*    */ }


/* Location:              C:\Users\Lenovo\Downloads\ZyrexClientV1 (1).jar!\ZyrexClient\Gui\ScreenPosition.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */