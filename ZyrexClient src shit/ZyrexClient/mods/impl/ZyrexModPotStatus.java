/*     */ package ZyrexClient.mods.impl;
/*     */ 
/*     */ import ZyrexClient.Client;
/*     */ import ZyrexClient.Gui.ScreenPosition;
/*     */ import ZyrexClient.ModHuds.Rainbow;
/*     */ import ZyrexClient.mods.ModDraggable;
/*     */ import java.util.Collection;
/*     */ import net.minecraft.client.Minecraft;
/*     */ import net.minecraft.client.gui.FontRenderer;
/*     */ import net.minecraft.client.renderer.GlStateManager;
/*     */ import net.minecraft.client.renderer.Tessellator;
/*     */ import net.minecraft.client.renderer.WorldRenderer;
/*     */ import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
/*     */ import net.minecraft.client.resources.I18n;
/*     */ import net.minecraft.potion.Potion;
/*     */ import net.minecraft.potion.PotionEffect;
/*     */ import net.minecraft.util.ResourceLocation;
/*     */ 
/*     */ 
/*     */ public class ZyrexModPotStatus
/*     */   extends ModDraggable
/*     */ {
/*     */   protected FontRenderer fontRendererObj;
/*     */   protected float zLevelFloat;
/*     */   
/*     */   public int getWidth() {
/*  27 */     if (Client.ModPotionStatus) {
/*  28 */       return 101;
/*     */     }
/*  30 */     return 0;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getHeight() {
/*  35 */     if (Client.ModPotionStatus) {
/*  36 */       return 86;
/*     */     }
/*  38 */     return 0;
/*     */   }
/*     */ 
/*     */   
/*     */   public void drawTexturedModalRect(int x, int y, int textureX, int textureY, int width, int height) {
/*  43 */     float f = 0.00390625F;
/*  44 */     float f1 = 0.00390625F;
/*  45 */     Tessellator tessellator = Tessellator.getInstance();
/*  46 */     WorldRenderer worldrenderer = tessellator.getWorldRenderer();
/*  47 */     worldrenderer.begin(7, DefaultVertexFormats.POSITION_TEX);
/*  48 */     worldrenderer.pos((x + 0), (y + height), this.zLevelFloat).tex(((textureX + 0) * f), ((textureY + height) * f1)).endVertex();
/*  49 */     worldrenderer.pos((x + width), (y + height), this.zLevelFloat).tex(((textureX + width) * f), ((textureY + height) * f1)).endVertex();
/*  50 */     worldrenderer.pos((x + width), (y + 0), this.zLevelFloat).tex(((textureX + width) * f), ((textureY + 0) * f1)).endVertex();
/*  51 */     worldrenderer.pos((x + 0), (y + 0), this.zLevelFloat).tex(((textureX + 0) * f), ((textureY + 0) * f1)).endVertex();
/*  52 */     tessellator.draw();
/*     */   }
/*     */   
/*     */   public void render(ScreenPosition pos) {
/*  56 */     if (Client.ModPotionStatus) {
/*  57 */       int offsetX = 21;
/*  58 */       int offsetY = 14;
/*  59 */       int i = 80;
/*  60 */       int i2 = 16;
/*  61 */       Collection<PotionEffect> collection = Minecraft.thePlayer.getActivePotionEffects();
/*  62 */       if (!collection.isEmpty()) {
/*  63 */         GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
/*  64 */         GlStateManager.disableLighting();
/*  65 */         int l = 33;
/*  66 */         if (collection.size() > 5)
/*  67 */           l = 132 / (collection.size() - 1); 
/*  68 */         for (PotionEffect potioneffect : Minecraft.thePlayer.getActivePotionEffects()) {
/*  69 */           Potion potion = Potion.potionTypes[potioneffect.getPotionID()];
/*  70 */           GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
/*  71 */           if (potion.hasStatusIcon()) {
/*  72 */             Minecraft.getMinecraft().getTextureManager().bindTexture(new ResourceLocation("textures/gui/container/inventory.png"));
/*  73 */             int i1 = potion.getStatusIconIndex();
/*  74 */             drawTexturedModalRect(pos.getAbsoluteX() + offsetX - 20, pos.getAbsoluteY() + i2 - offsetY, 0 + i1 % 8 * 18, 198 + i1 / 8 * 18, 18, 18);
/*     */           } 
/*  76 */           String s1 = I18n.format(potion.getName(), new Object[0]);
/*  77 */           if (potioneffect.getAmplifier() == 1) {
/*  78 */             s1 = String.valueOf(s1) + " " + I18n.format("enchantment.level.2", new Object[0]);
/*  79 */           } else if (potioneffect.getAmplifier() == 2) {
/*  80 */             s1 = String.valueOf(s1) + " " + I18n.format("enchantment.level.3", new Object[0]);
/*  81 */           } else if (potioneffect.getAmplifier() == 3) {
/*  82 */             s1 = String.valueOf(s1) + " " + I18n.format("enchantment.level.4", new Object[0]);
/*     */           } 
/*  84 */           if (Client.PotionStatusChroma) {
/*  85 */             this.font.drawString(s1, (pos.getAbsoluteX() + offsetX), (pos.getAbsoluteY() + i2 - offsetY), 16777215, true);
/*  86 */             String str = Potion.getDurationString(potioneffect);
/*  87 */             this.font.drawString(str, (pos.getAbsoluteX() + offsetX), (pos.getAbsoluteY() + i2 + 10 - offsetY), 8355711, true);
/*  88 */             i2 += l; continue;
/*     */           } 
/*  90 */           Rainbow.drawChromaString(s1, pos.getAbsoluteX() + offsetX, pos.getAbsoluteY() + i2 - offsetY, true);
/*  91 */           String s = Potion.getDurationString(potioneffect);
/*  92 */           Rainbow.drawChromaString(s, pos.getAbsoluteX() + offsetX, pos.getAbsoluteY() + i2 + 10 - offsetY, true);
/*  93 */           i2 += l;
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void renderDummy(ScreenPosition pos) {
/* 103 */     if (Client.ModPotionStatus) {
/* 104 */       int offsetX = 21;
/* 105 */       int offsetY = 14;
/* 106 */       int i = 80;
/* 107 */       int i2 = 16;
/* 108 */       PotionEffect[] potionEffects = { new PotionEffect(Potion.moveSpeed.id, 1200, 0), new PotionEffect(Potion.damageBoost.id, 1200, 0), new PotionEffect(Potion.fireResistance.id, 1200, 0) };
/* 109 */       int l = 33;
/* 110 */       if (potionEffects.length > 5)
/* 111 */         l = 132 / (potionEffects.length - 1);  byte b; int j; PotionEffect[] arrayOfPotionEffect1;
/* 112 */       for (j = (arrayOfPotionEffect1 = potionEffects).length, b = 0; b < j; ) { PotionEffect potioneffect = arrayOfPotionEffect1[b];
/* 113 */         Potion potion = Potion.potionTypes[potioneffect.getPotionID()];
/* 114 */         GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
/* 115 */         if (potion.hasStatusIcon()) {
/* 116 */           Minecraft.getMinecraft().getTextureManager().bindTexture(new ResourceLocation("textures/gui/container/inventory.png"));
/* 117 */           int i1 = potion.getStatusIconIndex();
/* 118 */           drawTexturedModalRect(pos.getAbsoluteX() + offsetX - 20, pos.getAbsoluteY() + i2 - offsetY, 0 + i1 % 8 * 18, 198 + i1 / 8 * 18, 18, 18);
/*     */         } 
/* 120 */         if (Client.PotionStatusChroma) {
/* 121 */           String s1 = I18n.format(potion.getName(), new Object[0]);
/* 122 */           if (potioneffect.getAmplifier() == 1) {
/* 123 */             s1 = String.valueOf(s1) + " " + I18n.format("enchantment.level.2", new Object[0]);
/* 124 */           } else if (potioneffect.getAmplifier() == 2) {
/* 125 */             s1 = String.valueOf(s1) + " " + I18n.format("enchantment.level.3", new Object[0]);
/* 126 */           } else if (potioneffect.getAmplifier() == 3) {
/* 127 */             s1 = String.valueOf(s1) + " " + I18n.format("enchantment.level.4", new Object[0]);
/*     */           } 
/* 129 */           this.font.drawString(s1, (pos.getAbsoluteX() + offsetX), (pos.getAbsoluteY() + i2 - offsetY), 16777215, true);
/* 130 */           String s = Potion.getDurationString(potioneffect);
/* 131 */           this.font.drawString(s, (pos.getAbsoluteX() + offsetX), (pos.getAbsoluteY() + i2 + 10 - offsetY), 8355711, true);
/* 132 */           i2 += l;
/*     */         } 
/*     */         b++; }
/*     */     
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Lenovo\Downloads\ZyrexClientV1 (1).jar!\ZyrexClient\mods\impl\ZyrexModPotStatus.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */