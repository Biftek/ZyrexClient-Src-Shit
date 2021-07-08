/*     */ package ZyrexClient.mods.impl;
/*     */ 
/*     */ import ZyrexClient.Client;
/*     */ import ZyrexClient.Gui.ScreenPosition;
/*     */ import ZyrexClient.ModHuds.Rainbow;
/*     */ import ZyrexClient.mods.ModDraggable;
/*     */ import java.awt.Color;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import net.minecraft.client.gui.GuiScreen;
/*     */ import org.lwjgl.input.Mouse;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ZyrexModCPS
/*     */   extends ModDraggable
/*     */ {
/*     */   private boolean isModEnabled = true;
/*  21 */   private List<Long> clicks = new ArrayList<>();
/*     */   
/*     */   private boolean wasPressed;
/*     */   private long lastPressed;
/*  25 */   private List<Long> clicks2 = new ArrayList<>();
/*     */   
/*     */   private boolean wasPressed2;
/*     */   private long lastPressed2;
/*     */   
/*     */   public int getWidth() {
/*  31 */     if (Client.ModCPS) {
/*  32 */       return 59;
/*     */     }
/*  34 */     return 0;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int getHeight() {
/*  40 */     if (Client.ModCPS) {
/*  41 */       return 15;
/*     */     }
/*  43 */     return 0;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void render(ScreenPosition pos) {
/*  49 */     if (Client.ModCPS) {
/*  50 */       boolean lpressed = Mouse.isButtonDown(0);
/*  51 */       boolean rpressed = Mouse.isButtonDown(1);
/*     */ 
/*     */       
/*  54 */       if (lpressed != this.wasPressed) {
/*  55 */         this.lastPressed = System.currentTimeMillis() + 10L;
/*  56 */         this.wasPressed = lpressed;
/*  57 */         if (lpressed) {
/*  58 */           this.clicks.add(Long.valueOf(this.lastPressed));
/*     */         }
/*     */       } 
/*     */ 
/*     */       
/*  63 */       if (rpressed != this.wasPressed2) {
/*  64 */         this.lastPressed2 = System.currentTimeMillis() + 10L;
/*  65 */         this.wasPressed2 = rpressed;
/*  66 */         if (rpressed) {
/*  67 */           this.clicks2.add(Long.valueOf(this.lastPressed2));
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/*  72 */     if (Client.CPSChroma) {
/*  73 */       if (Client.CPSBackground) {
/*  74 */         GuiScreen.drawRect(pos.getAbsoluteX() / 1 + 1, pos.getAbsoluteY() / 1 + 15, pos.getAbsoluteX() + 59, pos.getAbsoluteY() + 1, (new Color(0, 0, 0, 130)).getRGB());
/*     */       }
/*     */ 
/*     */       
/*  78 */       this.font.drawString(String.valueOf(getCPS()) + " §7｜§f " + getCPS2() + " CPS", (pos.getAbsoluteX() + 8), (pos.getAbsoluteY() + 4), -1);
/*     */     } else {
/*  80 */       if (Client.CPSBackground) {
/*  81 */         GuiScreen.drawRect(pos.getAbsoluteX() / 1 + 1, pos.getAbsoluteY() / 1 + 15, pos.getAbsoluteX() + 59, pos.getAbsoluteY() + 1, (new Color(0, 0, 0, 130)).getRGB());
/*     */       }
/*     */ 
/*     */       
/*  85 */       Rainbow.drawChromaString(String.valueOf(getCPS()) + " ｜ " + getCPS2() + " CPS", pos.getAbsoluteX() + 8, pos.getAbsoluteY() + 4, true);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private int getCPS() {
/*  92 */     long time = System.currentTimeMillis();
/*  93 */     this.clicks.removeIf(aLong -> (aLong.longValue() + 1000L < paramLong));
/*  94 */     return this.clicks.size();
/*     */   }
/*     */ 
/*     */   
/*     */   private int getCPS2() {
/*  99 */     long time2 = System.currentTimeMillis();
/* 100 */     this.clicks2.removeIf(aLong2 -> (aLong2.longValue() + 1000L < paramLong));
/* 101 */     return this.clicks2.size();
/*     */   }
/*     */ 
/*     */   
/*     */   public void renderDummy(ScreenPosition pos) {
/* 106 */     if (Client.ModCPS) {
/* 107 */       boolean lpressed = Mouse.isButtonDown(0);
/* 108 */       boolean rpressed = Mouse.isButtonDown(1);
/*     */ 
/*     */       
/* 111 */       if (lpressed != this.wasPressed) {
/* 112 */         this.lastPressed = System.currentTimeMillis() + 10L;
/* 113 */         this.wasPressed = lpressed;
/* 114 */         if (lpressed) {
/* 115 */           this.clicks.add(Long.valueOf(this.lastPressed));
/*     */         }
/*     */       } 
/*     */ 
/*     */       
/* 120 */       if (rpressed != this.wasPressed2) {
/* 121 */         this.lastPressed2 = System.currentTimeMillis() + 10L;
/* 122 */         this.wasPressed2 = rpressed;
/* 123 */         if (rpressed) {
/* 124 */           this.clicks2.add(Long.valueOf(this.lastPressed2));
/*     */         }
/*     */       } 
/*     */       
/* 128 */       if (Client.CPSChroma) {
/* 129 */         if (Client.CPSBackground) {
/* 130 */           GuiScreen.drawRect(pos.getAbsoluteX() / 1 + 1, pos.getAbsoluteY() / 1 + 15, pos.getAbsoluteX() + 59, pos.getAbsoluteY() + 1, (new Color(0, 0, 0, 130)).getRGB());
/*     */         }
/*     */ 
/*     */         
/* 134 */         this.font.drawString(String.valueOf(getCPS()) + " §7︱§f " + getCPS2() + " CPS", (pos.getAbsoluteX() + 8), (pos.getAbsoluteY() + 4), -1);
/*     */       } else {
/* 136 */         if (Client.CPSBackground) {
/* 137 */           GuiScreen.drawRect(pos.getAbsoluteX() / 1 + 1, pos.getAbsoluteY() / 1 + 15, pos.getAbsoluteX() + 59, pos.getAbsoluteY() + 1, (new Color(0, 0, 0, 130)).getRGB());
/*     */         }
/*     */ 
/*     */         
/* 141 */         Rainbow.drawChromaString(String.valueOf(getCPS()) + " ︱ " + getCPS2() + " CPS", pos.getAbsoluteX() + 8, pos.getAbsoluteY() + 4, true);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Lenovo\Downloads\ZyrexClientV1 (1).jar!\ZyrexClient\mods\impl\ZyrexModCPS.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */