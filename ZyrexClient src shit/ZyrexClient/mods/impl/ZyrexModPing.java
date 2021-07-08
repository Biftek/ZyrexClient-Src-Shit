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
/*    */ public class ZyrexModPing
/*    */   extends ModDraggable
/*    */ {
/*    */   public int getWidth() {
/* 16 */     if (Client.ModPing) {
/* 17 */       return 59;
/*    */     }
/* 19 */     return 0;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public int getHeight() {
/* 26 */     if (Client.ModPing) {
/* 27 */       return 15;
/*    */     }
/* 29 */     return 0;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void render(ScreenPosition pos) {
/* 35 */     if (Client.ModPing) {
/* 36 */       if (Client.PingChroma) {
/* 37 */         if (Client.PingBackground) {
/* 38 */           GuiScreen.drawRect(pos.getAbsoluteX() / 1 + 1, pos.getAbsoluteY() / 1 + 15, pos.getAbsoluteX() + 59, pos.getAbsoluteY() + 1, (new Color(0, 0, 0, 130)).getRGB());
/*    */         }
/*    */ 
/*    */         
/* 42 */         Minecraft.getMinecraft(); this.font.drawString(String.valueOf(Minecraft.getMinecraft().getNetHandler().getPlayerInfo(Minecraft.thePlayer.getUniqueID()).getResponseTime()) + " ms", (pos.getAbsoluteX() + 18), (pos.getAbsoluteY() + 4), -1);
/*    */       } else {
/* 44 */         if (Client.PingBackground) {
/* 45 */           GuiScreen.drawRect(pos.getAbsoluteX() / 1 + 1, pos.getAbsoluteY() / 1 + 15, pos.getAbsoluteX() + 59, pos.getAbsoluteY() + 1, (new Color(0, 0, 0, 130)).getRGB());
/*    */         }
/*    */ 
/*    */         
/* 49 */         Minecraft.getMinecraft(); Rainbow.drawChromaString(String.valueOf(Minecraft.getMinecraft().getNetHandler().getPlayerInfo(Minecraft.thePlayer.getUniqueID()).getResponseTime()) + " ms", pos.getAbsoluteX() + 18, pos.getAbsoluteY() + 4, true);
/*    */       } 
/*    */     }
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void renderDummy(ScreenPosition pos) {
/* 58 */     if (Client.ModPing)
/* 59 */       if (Client.PingChroma) {
/* 60 */         if (Client.PingBackground) {
/* 61 */           GuiScreen.drawRect(pos.getAbsoluteX() / 1 + 1, pos.getAbsoluteY() / 1 + 15, pos.getAbsoluteX() + 59, pos.getAbsoluteY() + 1, (new Color(0, 0, 0, 130)).getRGB());
/*    */         }
/*    */ 
/*    */         
/* 65 */         Minecraft.getMinecraft(); this.font.drawString(String.valueOf(Minecraft.getMinecraft().getNetHandler().getPlayerInfo(Minecraft.thePlayer.getUniqueID()).getResponseTime()) + " ms", (pos.getAbsoluteX() + 18), (pos.getAbsoluteY() + 4), -1);
/*    */       } else {
/* 67 */         if (Client.PingBackground) {
/* 68 */           GuiScreen.drawRect(pos.getAbsoluteX() / 1 + 1, pos.getAbsoluteY() / 1 + 15, pos.getAbsoluteX() + 59, pos.getAbsoluteY() + 1, (new Color(0, 0, 0, 130)).getRGB());
/*    */         }
/*    */ 
/*    */         
/* 72 */         Minecraft.getMinecraft(); Rainbow.drawChromaString(String.valueOf(Minecraft.getMinecraft().getNetHandler().getPlayerInfo(Minecraft.thePlayer.getUniqueID()).getResponseTime()) + " ms", pos.getAbsoluteX() + 18, pos.getAbsoluteY() + 4, true);
/*    */       }  
/*    */   }
/*    */ }


/* Location:              C:\Users\Lenovo\Downloads\ZyrexClientV1 (1).jar!\ZyrexClient\mods\impl\ZyrexModPing.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */