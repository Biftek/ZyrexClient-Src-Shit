/*    */ package ZyrexClient.mods.impl;
/*    */ 
/*    */ import ZyrexClient.Client;
/*    */ import ZyrexClient.Gui.ScreenPosition;
/*    */ import ZyrexClient.ModHuds.Rainbow;
/*    */ import ZyrexClient.mods.ModDraggable;
/*    */ import java.awt.Color;
/*    */ import net.minecraft.client.Minecraft;
/*    */ import net.minecraft.client.gui.GuiScreen;
/*    */ 
/*    */ 
/*    */ public class ZyrexModCoordinates
/*    */   extends ModDraggable
/*    */ {
/*    */   int X;
/*    */   int Y;
/*    */   int Z;
/*    */   
/*    */   public int getHeight() {
/* 20 */     if (Client.ModCoordinates) {
/* 21 */       return 33;
/*    */     }
/* 23 */     return 0;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public int getWidth() {
/* 29 */     if (Client.ModCoordinates) {
/* 30 */       return 46;
/*    */     }
/* 32 */     return 0;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void renderDummy(ScreenPosition pos) {
/* 38 */     this.X = Minecraft.thePlayer.getPosition().getX();
/* 39 */     this.Y = Minecraft.thePlayer.getPosition().getY();
/* 40 */     this.Z = Minecraft.thePlayer.getPosition().getZ();
/*    */     
/* 42 */     if (Client.ModCoordinates) {
/* 43 */       if (Client.CoordinatesBackground) {
/* 44 */         GuiScreen.drawRect(pos.getAbsoluteX() / 1 + 1, pos.getAbsoluteY() / 1 + 33, pos.getAbsoluteX() + 46, pos.getAbsoluteY() + 1, (new Color(0, 0, 0, 100)).getRGB());
/*    */       }
/*    */ 
/*    */       
/* 48 */       if (Client.CoordinatesChroma) {
/* 49 */         this.font.drawString("X " + this.X, (pos.getAbsoluteX() + 3), (pos.getAbsoluteY() + 3), 16777215);
/* 50 */         this.font.drawString("Y " + this.Y, (pos.getAbsoluteX() + 3), (pos.getAbsoluteY() + 13), 16777215);
/* 51 */         this.font.drawString("Z " + this.Z, (pos.getAbsoluteX() + 3), (pos.getAbsoluteY() + 23), 16777215);
/*    */       } else {
/* 53 */         Rainbow.drawChromaString("X " + this.X, pos.getAbsoluteX() + 3, pos.getAbsoluteY() + 3, true);
/* 54 */         Rainbow.drawChromaString("Y " + this.Y, pos.getAbsoluteX() + 3, pos.getAbsoluteY() + 13, true);
/* 55 */         Rainbow.drawChromaString("Z " + this.Z, pos.getAbsoluteX() + 3, pos.getAbsoluteY() + 23, true);
/*    */       } 
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void render(ScreenPosition pos) {
/* 64 */     this.X = Minecraft.thePlayer.getPosition().getX();
/* 65 */     this.Y = Minecraft.thePlayer.getPosition().getY();
/* 66 */     this.Z = Minecraft.thePlayer.getPosition().getZ();
/*    */     
/* 68 */     if (Client.ModCoordinates) {
/* 69 */       if (Client.CoordinatesBackground) {
/* 70 */         GuiScreen.drawRect(pos.getAbsoluteX() / 1 + 1, pos.getAbsoluteY() / 1 + 33, pos.getAbsoluteX() + 46, pos.getAbsoluteY() + 1, (new Color(0, 0, 0, 130)).getRGB());
/*    */       }
/*    */ 
/*    */       
/* 74 */       if (Client.CoordinatesChroma) {
/* 75 */         this.font.drawString("X " + this.X, (pos.getAbsoluteX() + 3), (pos.getAbsoluteY() + 3), 16777215);
/* 76 */         this.font.drawString("Y " + this.Y, (pos.getAbsoluteX() + 3), (pos.getAbsoluteY() + 13), 16777215);
/* 77 */         this.font.drawString("Z " + this.Z, (pos.getAbsoluteX() + 3), (pos.getAbsoluteY() + 23), 16777215);
/*    */       } else {
/* 79 */         Rainbow.drawChromaString("X " + this.X, pos.getAbsoluteX() + 3, pos.getAbsoluteY() + 3, true);
/* 80 */         Rainbow.drawChromaString("Y " + this.Y, pos.getAbsoluteX() + 3, pos.getAbsoluteY() + 13, true);
/* 81 */         Rainbow.drawChromaString("Z " + this.Z, pos.getAbsoluteX() + 3, pos.getAbsoluteY() + 23, true);
/*    */       } 
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\Lenovo\Downloads\ZyrexClientV1 (1).jar!\ZyrexClient\mods\impl\ZyrexModCoordinates.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */