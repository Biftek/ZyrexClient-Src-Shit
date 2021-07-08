/*     */ package ZyrexClient.mods.impl;
/*     */ 
/*     */ import ZyrexClient.Client;
/*     */ import ZyrexClient.Gui.ScreenPosition;
/*     */ import ZyrexClient.mods.ModDraggable;
/*     */ import net.minecraft.client.gui.FontRenderer;
/*     */ import net.minecraft.client.gui.Gui;
/*     */ import net.minecraft.client.gui.ScaledResolution;
/*     */ import net.minecraft.client.renderer.GlStateManager;
/*     */ import net.minecraft.client.renderer.Tessellator;
/*     */ import net.minecraft.client.renderer.WorldRenderer;
/*     */ import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
/*     */ import net.minecraft.entity.boss.BossStatus;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ZyrexModBossbar
/*     */   extends ModDraggable
/*     */ {
/*     */   protected float zLevelFloat;
/*     */   
/*     */   public int getWidth() {
/*  29 */     return 182;
/*     */   }
/*     */   
/*     */   public int getX() {
/*  33 */     return this.pos.getAbsoluteX();
/*     */   }
/*     */ 
/*     */   
/*     */   public int getHeight() {
/*  38 */     return 18;
/*     */   }
/*     */   
/*  41 */   int offset = 13;
/*     */ 
/*     */   
/*     */   public void renderDummy(ScreenPosition pos) {
/*  45 */     this.mc.getTextureManager().bindTexture(Gui.icons);
/*  46 */     BossStatus.statusBarTime--;
/*  47 */     FontRenderer fontrenderer = this.mc.fontRendererObj;
/*  48 */     this.mc.getTextureManager().bindTexture(Gui.icons);
/*  49 */     ScaledResolution scaledresolution = new ScaledResolution(this.mc);
/*  50 */     int i = scaledresolution.getScaledWidth();
/*  51 */     int j = 182;
/*  52 */     this.mc.getTextureManager().bindTexture(Gui.icons);
/*  53 */     int k = i / 2 - j / 2;
/*  54 */     int l = (int)(BossStatus.healthScale * (j + 1));
/*  55 */     int i1 = 12;
/*  56 */     drawTexturedModalRect(pos.getAbsoluteX(), pos.getAbsoluteY() + this.offset + 1, 0, 74, j, 5);
/*  57 */     drawTexturedModalRect(pos.getAbsoluteX(), pos.getAbsoluteY() + this.offset + 1, 0, 74, j, 5);
/*  58 */     if (l > 0)
/*     */     {
/*  60 */       drawTexturedModalRect(pos.getAbsoluteX(), pos.getAbsoluteY() + this.offset + 1, 0, 79, l, 5);
/*     */     }
/*  62 */     this.mc.getTextureManager().bindTexture(Gui.icons);
/*     */     
/*  64 */     String s = "§3Zyrex §7- §3Bossbar";
/*     */     
/*  66 */     this.font.drawString(s, (getWidth() / 2 - this.font.getStringWidth(s) / 2 + pos.getAbsoluteX()), (pos.getAbsoluteY() - 10 + this.offset), 16777215);
/*  67 */     GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
/*  68 */     this.mc.getTextureManager().bindTexture(Gui.icons);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void drawTexturedModalRect(int x, int y, int textureX, int textureY, int width, int height) {
/*  74 */     float f = 0.00390625F;
/*  75 */     float f1 = 0.00390625F;
/*  76 */     Tessellator tessellator = Tessellator.getInstance();
/*  77 */     WorldRenderer worldrenderer = tessellator.getWorldRenderer();
/*  78 */     worldrenderer.begin(7, DefaultVertexFormats.POSITION_TEX);
/*  79 */     worldrenderer.pos((x + 0), (y + height), this.zLevelFloat).tex(((textureX + 0) * f), ((textureY + height) * f1)).endVertex();
/*  80 */     worldrenderer.pos((x + width), (y + height), this.zLevelFloat).tex(((textureX + width) * f), ((textureY + height) * f1)).endVertex();
/*  81 */     worldrenderer.pos((x + width), (y + 0), this.zLevelFloat).tex(((textureX + width) * f), ((textureY + 0) * f1)).endVertex();
/*  82 */     worldrenderer.pos((x + 0), (y + 0), this.zLevelFloat).tex(((textureX + 0) * f), ((textureY + 0) * f1)).endVertex();
/*  83 */     tessellator.draw();
/*     */   }
/*     */ 
/*     */   
/*     */   public FontRenderer getFontRenderer() {
/*  88 */     return this.mc.fontRendererObj;
/*     */   }
/*     */ 
/*     */   
/*     */   public void render(ScreenPosition pos) {
/*  93 */     if (Client.ModBossbar && BossStatus.bossName != null && BossStatus.statusBarTime > 0) {
/*     */       
/*  95 */       this.mc.getTextureManager().bindTexture(Gui.icons);
/*  96 */       BossStatus.statusBarTime--;
/*  97 */       FontRenderer fontrenderer = this.mc.fontRendererObj;
/*  98 */       this.mc.getTextureManager().bindTexture(Gui.icons);
/*  99 */       ScaledResolution scaledresolution = new ScaledResolution(this.mc);
/* 100 */       int i = scaledresolution.getScaledWidth();
/* 101 */       int j = 182;
/* 102 */       this.mc.getTextureManager().bindTexture(Gui.icons);
/* 103 */       int k = i / 2 - j / 2, l = (int)(BossStatus.healthScale * (j + 1));
/* 104 */       int i1 = 12;
/* 105 */       drawTexturedModalRect(pos.getAbsoluteX(), pos.getAbsoluteY() + this.offset, 0, 74, j, 5);
/* 106 */       drawTexturedModalRect(pos.getAbsoluteX(), pos.getAbsoluteY() + this.offset, 0, 74, j, 5);
/* 107 */       if (l > 0)
/*     */       {
/* 109 */         drawTexturedModalRect(pos.getAbsoluteX(), pos.getAbsoluteY() + this.offset, 0, 79, l, 5);
/*     */       }
/* 111 */       this.mc.getTextureManager().bindTexture(Gui.icons);
/*     */       
/* 113 */       String s = BossStatus.bossName;
/*     */       
/* 115 */       this.font.drawStringWithShadow(s, (getWidth() / 2 - this.font.getStringWidth(s) / 2 + pos.getAbsoluteX()), (pos.getAbsoluteY() - 10 + this.offset), 16777215);
/* 116 */       GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
/* 117 */       this.mc.getTextureManager().bindTexture(Gui.icons);
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Lenovo\Downloads\ZyrexClientV1 (1).jar!\ZyrexClient\mods\impl\ZyrexModBossbar.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */