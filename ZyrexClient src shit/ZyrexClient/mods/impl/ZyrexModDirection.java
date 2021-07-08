/*    */ package ZyrexClient.mods.impl;
/*    */ 
/*    */ import ZyrexClient.Client;
/*    */ import ZyrexClient.Gui.ScreenPosition;
/*    */ import ZyrexClient.mods.ModDraggable;
/*    */ import net.minecraft.client.Minecraft;
/*    */ import net.minecraft.client.gui.Gui;
/*    */ import net.minecraft.client.gui.ScaledResolution;
/*    */ import net.minecraft.util.MathHelper;
/*    */ import net.minecraft.util.ResourceLocation;
/*    */ 
/*    */ public class ZyrexModDirection
/*    */   extends ModDraggable {
/*    */   protected static ScaledResolution scaledResolution;
/* 15 */   public static String markerColor = "c";
/* 16 */   public static int compassIndex = 0;
/*    */ 
/*    */   
/*    */   public int getWidth() {
/* 20 */     if (Client.ModDirection) {
/* 21 */       return 102;
/*    */     }
/* 23 */     return 0;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public int getHeight() {
/* 29 */     if (Client.ModDirection) {
/* 30 */       return 15;
/*    */     }
/* 32 */     return 0;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void render(ScreenPosition pos) {
/* 38 */     if (Client.ModDirection) {
/* 39 */       int direction = MathHelper.floor_double((Minecraft.thePlayer.rotationYaw * 256.0F / 360.0F) + 0.5D) & 0xFF;
/* 40 */       int yBase = getY(1, 12);
/* 41 */       int xBase = getX(65);
/*    */       
/* 43 */       this.mc.getTextureManager().bindTexture(new ResourceLocation("Mods/Coordinates.png"));
/* 44 */       if (direction < 128) {
/* 45 */         Gui.drawTexturedModalRect(pos.getAbsoluteX() + xBase - 64, pos.getAbsoluteY() + yBase - 10, direction, compassIndex * 24, 100, 13);
/*    */       } else {
/* 47 */         Gui.drawTexturedModalRect(pos.getAbsoluteX() + xBase - 64, pos.getAbsoluteY() + yBase - 10, direction - 128, compassIndex * 24 + 12, 100, 13);
/*    */       } 
/*    */       
/* 50 */       this.mc.fontRendererObj.drawString("§" + markerColor.toLowerCase() + "|§r", (pos.getAbsoluteX() + xBase - 16), (pos.getAbsoluteY() + yBase - 7), 16777215);
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void renderDummy(ScreenPosition pos) {
/* 58 */     if (Client.ModDirection) {
/* 59 */       int direction = MathHelper.floor_double((Minecraft.thePlayer.rotationYaw * 256.0F / 360.0F) + 0.5D) & 0xFF;
/* 60 */       int yBase = getY(1, 12);
/* 61 */       int xBase = getX(65);
/*    */       
/* 63 */       this.mc.getTextureManager().bindTexture(new ResourceLocation("Mods/Coordinates.png"));
/* 64 */       if (direction < 128) {
/* 65 */         Gui.drawTexturedModalRect(pos.getAbsoluteX() + xBase - 64, pos.getAbsoluteY() + yBase - 10, direction, compassIndex * 24, 100, 13);
/*    */       } else {
/* 67 */         Gui.drawTexturedModalRect(pos.getAbsoluteX() + xBase - 64, pos.getAbsoluteY() + yBase - 10, direction - 128, compassIndex * 24 + 12, 100, 13);
/*    */       } 
/*    */       
/* 70 */       this.mc.fontRendererObj.drawString("§" + markerColor.toLowerCase() + "|§r", (pos.getAbsoluteX() + xBase - 16), (pos.getAbsoluteY() + yBase - 7), 16777215);
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   private static int getX(int width) {
/* 77 */     return width;
/*    */   }
/*    */   
/*    */   private static int getY(int rowCount, int height) {
/* 81 */     return height;
/*    */   }
/*    */   
/*    */   public enum Direction {
/* 85 */     S,
/* 86 */     SW,
/* 87 */     W,
/* 88 */     NW,
/* 89 */     N,
/* 90 */     NE,
/* 91 */     E,
/* 92 */     SE;
/*    */   }
/*    */ }


/* Location:              C:\Users\Lenovo\Downloads\ZyrexClientV1 (1).jar!\ZyrexClient\mods\impl\ZyrexModDirection.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */