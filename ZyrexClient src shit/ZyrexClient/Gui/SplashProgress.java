/*     */ package ZyrexClient.Gui;
/*     */ 
/*     */ import java.awt.Color;
/*     */ import net.minecraft.client.Minecraft;
/*     */ import net.minecraft.client.gui.Gui;
/*     */ import net.minecraft.client.gui.ScaledResolution;
/*     */ import net.minecraft.client.renderer.GlStateManager;
/*     */ import net.minecraft.client.renderer.texture.TextureManager;
/*     */ import net.minecraft.client.shader.Framebuffer;
/*     */ import net.minecraft.util.ResourceLocation;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SplashProgress
/*     */ {
/*     */   private static final int MAX = 8;
/*  18 */   private static int PROGRESS = 0;
/*  19 */   private static String CURRENT = "";
/*     */   private static ResourceLocation splash;
/*     */   private static UnicodeFontRenderer ufr;
/*     */   
/*     */   public static void update() {
/*  24 */     if (Minecraft.getMinecraft() == null || Minecraft.getMinecraft().getLanguageManager() == null) {
/*     */       return;
/*     */     }
/*  27 */     drawSplash(Minecraft.getMinecraft().getTextureManager());
/*     */   }
/*     */   
/*     */   public static void setProgress(int givenProgress, String givenText) {
/*  31 */     PROGRESS = givenProgress;
/*  32 */     CURRENT = givenText;
/*  33 */     update();
/*     */   }
/*     */ 
/*     */   
/*     */   public static void drawSplash(TextureManager tm) {
/*  38 */     ScaledResolution scaledResolution = new ScaledResolution(Minecraft.getMinecraft());
/*  39 */     int scaleFactor = scaledResolution.getScaleFactor();
/*     */     
/*  41 */     Framebuffer framebuffer = new Framebuffer(scaledResolution.getScaledWidth() * scaleFactor, scaledResolution.getScaledHeight() * scaleFactor, true);
/*  42 */     framebuffer.bindFramebuffer(false);
/*     */     
/*  44 */     GlStateManager.matrixMode(5889);
/*  45 */     GlStateManager.ortho(0.0D, scaledResolution.getScaledWidth(), scaledResolution.getScaledHeight(), 0.0D, 1000.0D, 3000.0D);
/*  46 */     GlStateManager.matrixMode(5888);
/*  47 */     GlStateManager.loadIdentity();
/*  48 */     GlStateManager.translate(0.0F, 0.0F, -2000.0F);
/*  49 */     GlStateManager.disableLighting();
/*  50 */     GlStateManager.disableFog();
/*  51 */     GlStateManager.disableDepth();
/*  52 */     GlStateManager.enableTexture2D();
/*     */     
/*  54 */     if (splash == null) {
/*  55 */       splash = new ResourceLocation("hatterkepek/toltokepernyo.jpg");
/*     */     }
/*     */     
/*  58 */     tm.bindTexture(splash);
/*     */     
/*  60 */     GlStateManager.resetColor();
/*  61 */     GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
/*     */     
/*  63 */     Gui.drawScaledCustomSizeModalRect(0, 0, 0.0F, 0.0F, 1920, 1080, scaledResolution.getScaledWidth(), scaledResolution.getScaledHeight(), 1920.0F, 1080.0F);
/*  64 */     drawProgress();
/*  65 */     framebuffer.unbindFramebuffer();
/*  66 */     framebuffer.framebufferRender(scaledResolution.getScaledWidth() * scaleFactor, scaledResolution.getScaledHeight() * scaleFactor);
/*     */     
/*  68 */     GlStateManager.enableAlpha();
/*  69 */     GlStateManager.alphaFunc(516, 0.1F);
/*     */     
/*  71 */     Minecraft.getMinecraft().updateDisplay();
/*     */   }
/*     */ 
/*     */   
/*     */   private static void drawProgress() {
/*  76 */     if ((Minecraft.getMinecraft()).gameSettings == null || Minecraft.getMinecraft().getTextureManager() == null) {
/*     */       return;
/*     */     }
/*     */     
/*  80 */     if (ufr == null) {
/*  81 */       ufr = UnicodeFontRenderer.getFontOnPC("Arial", 20);
/*     */     }
/*     */     
/*  84 */     ScaledResolution sr = new ScaledResolution(Minecraft.getMinecraft());
/*     */     
/*  86 */     double nProgress = PROGRESS;
/*  87 */     double calc = nProgress / 8.0D * sr.getScaledWidth();
/*     */     
/*  89 */     Gui.drawRect(0, sr.getScaledHeight() - 35, sr.getScaledWidth(), sr.getScaledHeight(), (new Color(0, 0, 0, 50)).getRGB());
/*     */     
/*  91 */     GlStateManager.resetColor();
/*  92 */     resetTextureState();
/*     */     
/*  94 */     ufr.drawString(CURRENT, 20.0F, (sr.getScaledHeight() - 25), -1);
/*     */     
/*  96 */     String step = String.valueOf(PROGRESS) + "/" + '\b';
/*  97 */     ufr.drawString(step, (sr.getScaledWidth() - 20 - ufr.getStringWidth(step)), (sr.getScaledHeight() - 25), -505290241);
/*     */     
/*  99 */     GlStateManager.resetColor();
/* 100 */     resetTextureState();
/* 101 */     Gui.drawRect(0, sr.getScaledHeight() - 2, (int)calc, sr.getScaledHeight(), (new Color(149, 201, 144)).getRGB());
/*     */     
/* 103 */     Gui.drawRect(0, sr.getScaledHeight() - 2, sr.getScaledWidth(), sr.getScaledHeight(), (new Color(0, 0, 0, 10)).getRGB());
/*     */   }
/*     */   
/*     */   private static void resetTextureState() {
/* 107 */     (GlStateManager.textureState[GlStateManager.activeTextureUnit]).textureName = -1;
/*     */   }
/*     */ }


/* Location:              C:\Users\Lenovo\Downloads\ZyrexClientV1 (1).jar!\ZyrexClient\Gui\SplashProgress.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */