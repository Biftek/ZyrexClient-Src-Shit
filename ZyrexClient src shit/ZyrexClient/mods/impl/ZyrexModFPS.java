/*     */ package ZyrexClient.mods.impl;
/*     */ 
/*     */ import ZyrexClient.Client;
/*     */ import ZyrexClient.Gui.ScreenPosition;
/*     */ import ZyrexClient.ModHuds.Rainbow;
/*     */ import ZyrexClient.mods.ModDraggable;
/*     */ import java.awt.Color;
/*     */ import net.minecraft.client.Minecraft;
/*     */ import net.minecraft.client.gui.GuiScreen;
/*     */ import net.minecraft.client.gui.ScaledResolution;
/*     */ 
/*     */ public class ZyrexModFPS
/*     */   extends ModDraggable
/*     */ {
/*  15 */   ScaledResolution sr = new ScaledResolution(this.mc);
/*     */ 
/*     */   
/*     */   public int getWidth() {
/*  19 */     if (Client.ModFPS) {
/*  20 */       return 59;
/*     */     }
/*  22 */     return 0;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getHeight() {
/*  29 */     if (Client.ModFPS) {
/*  30 */       return 15;
/*     */     }
/*  32 */     return 0;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void render(ScreenPosition pos) {
/*  38 */     int fps = Minecraft.getDebugFPS();
/*  39 */     if (Client.ModFPS) {
/*  40 */       if (Client.FPSChroma) {
/*  41 */         if (Client.FPSBackground) {
/*  42 */           GuiScreen.drawRect(pos.getAbsoluteX() / 1 + 1, pos.getAbsoluteY() / 1 + 15, pos.getAbsoluteX() + 59, pos.getAbsoluteY() + 1, (new Color(0, 0, 0, 130)).getRGB());
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*  47 */         if (fps <= 10) {
/*  48 */           this.font.drawString(String.valueOf(fps) + " FPS", (pos.getAbsoluteX() + getWidth() - 46), (pos.getAbsoluteY() + 4), -1); return;
/*     */         } 
/*  50 */         if (fps <= 20) {
/*  51 */           this.font.drawString(String.valueOf(fps) + " FPS", (pos.getAbsoluteX() + getWidth() - 46), (pos.getAbsoluteY() + 4), -1); return;
/*     */         } 
/*  53 */         if (fps <= 50) {
/*  54 */           this.font.drawString(String.valueOf(fps) + " FPS", (pos.getAbsoluteX() + getWidth() - 46), (pos.getAbsoluteY() + 4), -1); return;
/*     */         } 
/*  56 */         if (fps <= 99) {
/*  57 */           this.font.drawString(String.valueOf(fps) + " FPS", (pos.getAbsoluteX() + getWidth() - 46), (pos.getAbsoluteY() + 4), -1); return;
/*     */         } 
/*  59 */         if (fps <= 100) {
/*  60 */           this.font.drawString(String.valueOf(fps) + " FPS", (pos.getAbsoluteX() + getWidth() - 49), (pos.getAbsoluteY() + 4), -1); return;
/*     */         } 
/*  62 */         if (fps <= 150) {
/*  63 */           this.font.drawString(String.valueOf(fps) + " FPS", (pos.getAbsoluteX() + getWidth() - 49), (pos.getAbsoluteY() + 4), -1); return;
/*     */         } 
/*  65 */         if (fps <= 999) {
/*  66 */           this.font.drawString(String.valueOf(fps) + " FPS", (pos.getAbsoluteX() + getWidth() - 49), (pos.getAbsoluteY() + 4), -1);
/*     */           return;
/*     */         } 
/*  69 */         this.font.drawString(String.valueOf(fps) + " FPS", (pos.getAbsoluteX() + getWidth() - 52), (pos.getAbsoluteY() + 4), -1);
/*     */         
/*     */         return;
/*     */       } 
/*  73 */       if (Client.FPSBackground) {
/*  74 */         GuiScreen.drawRect(pos.getAbsoluteX() / 1 + 1, pos.getAbsoluteY() / 1 + 15, pos.getAbsoluteX() + 59, pos.getAbsoluteY() + 1, (new Color(0, 0, 0, 130)).getRGB());
/*     */       }
/*     */ 
/*     */       
/*  78 */       if (fps <= 10) {
/*  79 */         Rainbow.drawChromaString(String.valueOf(fps) + " FPS", pos.getAbsoluteX() + getWidth() - 46, pos.getAbsoluteY() + 4, true); return;
/*     */       } 
/*  81 */       if (fps <= 20) {
/*  82 */         Rainbow.drawChromaString(String.valueOf(fps) + " FPS", pos.getAbsoluteX() + getWidth() - 46, pos.getAbsoluteY() + 4, true); return;
/*     */       } 
/*  84 */       if (fps <= 50) {
/*  85 */         Rainbow.drawChromaString(String.valueOf(fps) + " FPS", pos.getAbsoluteX() + getWidth() - 46, pos.getAbsoluteY() + 4, true); return;
/*     */       } 
/*  87 */       if (fps <= 99) {
/*  88 */         Rainbow.drawChromaString(String.valueOf(fps) + " FPS", pos.getAbsoluteX() + getWidth() - 46, pos.getAbsoluteY() + 4, true); return;
/*     */       } 
/*  90 */       if (fps <= 100) {
/*  91 */         Rainbow.drawChromaString(String.valueOf(fps) + " FPS", pos.getAbsoluteX() + getWidth() - 49, pos.getAbsoluteY() + 4, true); return;
/*     */       } 
/*  93 */       if (fps <= 150) {
/*  94 */         Rainbow.drawChromaString(String.valueOf(fps) + " FPS", pos.getAbsoluteX() + getWidth() - 49, pos.getAbsoluteY() + 4, true); return;
/*     */       } 
/*  96 */       if (fps <= 999) {
/*  97 */         Rainbow.drawChromaString(String.valueOf(fps) + " FPS", pos.getAbsoluteX() + getWidth() - 49, pos.getAbsoluteY() + 4, true);
/*     */         return;
/*     */       } 
/* 100 */       Rainbow.drawChromaString(String.valueOf(fps) + " FPS", pos.getAbsoluteX() + getWidth() - 52, pos.getAbsoluteY() + 4, true);
/*     */       return;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void renderDummy(ScreenPosition pos) {
/* 112 */     int fps = Minecraft.getDebugFPS();
/* 113 */     if (Client.ModFPS) {
/* 114 */       if (Client.FPSChroma) {
/* 115 */         if (Client.FPSBackground) {
/* 116 */           GuiScreen.drawRect(pos.getAbsoluteX() / 1 + 1, pos.getAbsoluteY() / 1 + 15, pos.getAbsoluteX() + 59, pos.getAbsoluteY() + 1, (new Color(0, 0, 0, 130)).getRGB());
/*     */         }
/*     */ 
/*     */ 
/*     */         
/* 121 */         if (fps <= 10) {
/* 122 */           this.font.drawString(String.valueOf(fps) + " FPS", (pos.getAbsoluteX() + getWidth() - 46), (pos.getAbsoluteY() + 4), -1); return;
/*     */         } 
/* 124 */         if (fps <= 20) {
/* 125 */           this.font.drawString(String.valueOf(fps) + " FPS", (pos.getAbsoluteX() + getWidth() - 46), (pos.getAbsoluteY() + 4), -1); return;
/*     */         } 
/* 127 */         if (fps <= 50) {
/* 128 */           this.font.drawString(String.valueOf(fps) + " FPS", (pos.getAbsoluteX() + getWidth() - 46), (pos.getAbsoluteY() + 4), -1); return;
/*     */         } 
/* 130 */         if (fps <= 99) {
/* 131 */           this.font.drawString(String.valueOf(fps) + " FPS", (pos.getAbsoluteX() + getWidth() - 46), (pos.getAbsoluteY() + 4), -1); return;
/*     */         } 
/* 133 */         if (fps <= 100) {
/* 134 */           this.font.drawString(String.valueOf(fps) + " FPS", (pos.getAbsoluteX() + getWidth() - 49), (pos.getAbsoluteY() + 4), -1); return;
/*     */         } 
/* 136 */         if (fps <= 150) {
/* 137 */           this.font.drawString(String.valueOf(fps) + " FPS", (pos.getAbsoluteX() + getWidth() - 49), (pos.getAbsoluteY() + 4), -1); return;
/*     */         } 
/* 139 */         if (fps <= 999) {
/* 140 */           this.font.drawString(String.valueOf(fps) + " FPS", (pos.getAbsoluteX() + getWidth() - 49), (pos.getAbsoluteY() + 4), -1);
/*     */           return;
/*     */         } 
/* 143 */         this.font.drawString(String.valueOf(fps) + " FPS", (pos.getAbsoluteX() + getWidth() - 52), (pos.getAbsoluteY() + 4), -1);
/*     */         
/*     */         return;
/*     */       } 
/*     */       
/* 148 */       if (Client.FPSBackground) {
/* 149 */         GuiScreen.drawRect(pos.getAbsoluteX() / 1 + 1, pos.getAbsoluteY() / 1 + 15, pos.getAbsoluteX() + 59, pos.getAbsoluteY() + 1, (new Color(0, 0, 0, 130)).getRGB());
/*     */       }
/*     */ 
/*     */       
/* 153 */       if (fps <= 10) {
/* 154 */         Rainbow.drawChromaString(String.valueOf(fps) + " FPS", pos.getAbsoluteX() + getWidth() - 46, pos.getAbsoluteY() + 4, true); return;
/*     */       } 
/* 156 */       if (fps <= 20) {
/* 157 */         Rainbow.drawChromaString(String.valueOf(fps) + " FPS", pos.getAbsoluteX() + getWidth() - 46, pos.getAbsoluteY() + 4, true); return;
/*     */       } 
/* 159 */       if (fps <= 50) {
/* 160 */         Rainbow.drawChromaString(String.valueOf(fps) + " FPS", pos.getAbsoluteX() + getWidth() - 46, pos.getAbsoluteY() + 4, true); return;
/*     */       } 
/* 162 */       if (fps <= 99) {
/* 163 */         Rainbow.drawChromaString(String.valueOf(fps) + " FPS", pos.getAbsoluteX() + getWidth() - 46, pos.getAbsoluteY() + 4, true); return;
/*     */       } 
/* 165 */       if (fps <= 100) {
/* 166 */         Rainbow.drawChromaString(String.valueOf(fps) + " FPS", pos.getAbsoluteX() + getWidth() - 49, pos.getAbsoluteY() + 4, true); return;
/*     */       } 
/* 168 */       if (fps <= 150) {
/* 169 */         Rainbow.drawChromaString(String.valueOf(fps) + " FPS", pos.getAbsoluteX() + getWidth() - 49, pos.getAbsoluteY() + 4, true); return;
/*     */       } 
/* 171 */       if (fps <= 999) {
/* 172 */         Rainbow.drawChromaString(String.valueOf(fps) + " FPS", pos.getAbsoluteX() + getWidth() - 49, pos.getAbsoluteY() + 4, true);
/*     */         return;
/*     */       } 
/* 175 */       Rainbow.drawChromaString(String.valueOf(fps) + " FPS", pos.getAbsoluteX() + getWidth() - 52, pos.getAbsoluteY() + 4, true);
/*     */       return;
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Lenovo\Downloads\ZyrexClientV1 (1).jar!\ZyrexClient\mods\impl\ZyrexModFPS.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */