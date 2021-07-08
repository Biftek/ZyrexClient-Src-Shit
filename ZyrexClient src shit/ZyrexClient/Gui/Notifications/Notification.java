/*     */ package ZyrexClient.Gui.Notifications;
/*     */ 
/*     */ import java.awt.Color;
/*     */ import net.minecraft.client.Minecraft;
/*     */ import net.minecraft.client.gui.FontRenderer;
/*     */ import net.minecraft.client.gui.GuiScreen;
/*     */ import net.minecraft.client.renderer.GlStateManager;
/*     */ import net.minecraft.client.renderer.Tessellator;
/*     */ import net.minecraft.client.renderer.WorldRenderer;
/*     */ import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Notification
/*     */ {
/*     */   private NotificationType type;
/*     */   private String title;
/*     */   private String messsage;
/*     */   private long start;
/*     */   private long fadedIn;
/*     */   private long fadeOut;
/*     */   private long end;
/*     */   
/*     */   public Notification(NotificationType type, String title, String messsage, int length) {
/*  28 */     this.type = type;
/*  29 */     this.title = title;
/*  30 */     this.messsage = messsage;
/*     */     
/*  32 */     this.fadedIn = (200 * length);
/*  33 */     this.fadeOut = this.fadedIn + (500 * length);
/*  34 */     this.end = this.fadeOut + this.fadedIn;
/*     */   }
/*     */   
/*     */   public void show() {
/*  38 */     this.start = System.currentTimeMillis();
/*     */   }
/*     */   
/*     */   public boolean isShown() {
/*  42 */     return (getTime() <= this.end);
/*     */   }
/*     */   
/*     */   private long getTime() {
/*  46 */     return System.currentTimeMillis() - this.start;
/*     */   }
/*     */   public void render() {
/*     */     Color color1;
/*  50 */     double offset = 0.0D;
/*  51 */     int width = 120;
/*  52 */     int height = 30;
/*  53 */     long time = getTime();
/*     */     
/*  55 */     if (time < this.fadedIn) {
/*  56 */       offset = Math.tanh(time / this.fadedIn * 3.0D) * width;
/*  57 */     } else if (time > this.fadeOut) {
/*  58 */       offset = Math.tanh(3.0D - (time - this.fadeOut) / (this.end - this.fadeOut) * 3.0D) * width;
/*     */     } else {
/*  60 */       offset = width;
/*     */     } 
/*     */     
/*  63 */     Color color = new Color(0, 0, 0, 220);
/*     */ 
/*     */     
/*  66 */     if (this.type == NotificationType.INFO) {
/*  67 */       color1 = new Color(0, 26, 169);
/*  68 */     } else if (this.type == NotificationType.WARNING) {
/*  69 */       color1 = new Color(204, 193, 0);
/*     */     } else {
/*  71 */       color1 = new Color(204, 0, 18);
/*  72 */       int i = Math.max(0, Math.min(255, (int)(Math.sin(time / 100.0D) * 255.0D / 2.0D + 127.5D)));
/*  73 */       color = new Color(i, 0, 0, 220);
/*     */     } 
/*     */     
/*  76 */     FontRenderer fontRenderer = (Minecraft.getMinecraft()).fontRendererObj;
/*     */     
/*  78 */     drawRect(GuiScreen.width - offset, (GuiScreen.height - 5 - height), GuiScreen.width, (GuiScreen.height - 5), color.getRGB());
/*  79 */     drawRect(GuiScreen.width - offset, (GuiScreen.height - 5 - height), GuiScreen.width - offset + 4.0D, (GuiScreen.height - 5), color1.getRGB());
/*     */     
/*  81 */     fontRenderer.drawString(this.title, (int)(GuiScreen.width - offset + 8.0D), (GuiScreen.height - 2 - height), -1);
/*  82 */     fontRenderer.drawString(this.messsage, (int)(GuiScreen.width - offset + 8.0D), (GuiScreen.height - 15), -1);
/*     */   }
/*     */   
/*     */   public static void drawRect(double left, double top, double right, double bottom, int color) {
/*  86 */     if (left < right) {
/*  87 */       double i = left;
/*  88 */       left = right;
/*  89 */       right = i;
/*     */     } 
/*     */     
/*  92 */     if (top < bottom) {
/*  93 */       double j = top;
/*  94 */       top = bottom;
/*  95 */       bottom = j;
/*     */     } 
/*     */     
/*  98 */     float f3 = (color >> 24 & 0xFF) / 255.0F;
/*  99 */     float f = (color >> 16 & 0xFF) / 255.0F;
/* 100 */     float f1 = (color >> 8 & 0xFF) / 255.0F;
/* 101 */     float f2 = (color & 0xFF) / 255.0F;
/* 102 */     Tessellator tessellator = Tessellator.getInstance();
/* 103 */     WorldRenderer worldrenderer = tessellator.getWorldRenderer();
/* 104 */     GlStateManager.enableBlend();
/* 105 */     GlStateManager.disableTexture2D();
/* 106 */     GlStateManager.tryBlendFuncSeparate(770, 771, 1, 0);
/* 107 */     GlStateManager.color(f, f1, f2, f3);
/* 108 */     worldrenderer.begin(7, DefaultVertexFormats.POSITION);
/* 109 */     worldrenderer.pos(left, bottom, 0.0D).endVertex();
/* 110 */     worldrenderer.pos(right, bottom, 0.0D).endVertex();
/* 111 */     worldrenderer.pos(right, top, 0.0D).endVertex();
/* 112 */     worldrenderer.pos(left, top, 0.0D).endVertex();
/* 113 */     tessellator.draw();
/* 114 */     GlStateManager.enableTexture2D();
/* 115 */     GlStateManager.disableBlend();
/*     */   }
/*     */   
/*     */   public static void drawRect(int mode, double left, double top, double right, double bottom, int color) {
/* 119 */     if (left < right) {
/* 120 */       double i = left;
/* 121 */       left = right;
/* 122 */       right = i;
/*     */     } 
/*     */     
/* 125 */     if (top < bottom) {
/* 126 */       double j = top;
/* 127 */       top = bottom;
/* 128 */       bottom = j;
/*     */     } 
/*     */     
/* 131 */     float f3 = (color >> 24 & 0xFF) / 255.0F;
/* 132 */     float f = (color >> 16 & 0xFF) / 255.0F;
/* 133 */     float f1 = (color >> 8 & 0xFF) / 255.0F;
/* 134 */     float f2 = (color & 0xFF) / 255.0F;
/* 135 */     Tessellator tessellator = Tessellator.getInstance();
/* 136 */     WorldRenderer worldrenderer = tessellator.getWorldRenderer();
/* 137 */     GlStateManager.enableBlend();
/* 138 */     GlStateManager.disableTexture2D();
/* 139 */     GlStateManager.tryBlendFuncSeparate(770, 771, 1, 0);
/* 140 */     GlStateManager.color(f, f1, f2, f3);
/* 141 */     worldrenderer.begin(mode, DefaultVertexFormats.POSITION);
/* 142 */     worldrenderer.pos(left, bottom, 0.0D).endVertex();
/* 143 */     worldrenderer.pos(right, bottom, 0.0D).endVertex();
/* 144 */     worldrenderer.pos(right, top, 0.0D).endVertex();
/* 145 */     worldrenderer.pos(left, top, 0.0D).endVertex();
/* 146 */     tessellator.draw();
/* 147 */     GlStateManager.enableTexture2D();
/* 148 */     GlStateManager.disableBlend();
/*     */   }
/*     */ }


/* Location:              C:\Users\Lenovo\Downloads\ZyrexClientV1 (1).jar!\ZyrexClient\Gui\Notifications\Notification.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */