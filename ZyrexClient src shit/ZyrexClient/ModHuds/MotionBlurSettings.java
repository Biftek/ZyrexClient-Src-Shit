/*     */ package ZyrexClient.ModHuds;
/*     */ 
/*     */ import ZyrexClient.Client;
/*     */ import ZyrexClient.Gui.UnicodeFontRenderer;
/*     */ import ZyrexClient.ModToggle.ModToggle;
/*     */ import ZyrexClient.NewRoundedRect;
/*     */ import ZyrexClient.clickgui.FontUtil;
/*     */ import ZyrexClient.clickgui.RoundedButtons.ButtonMainMenuZ;
/*     */ import ZyrexClient.mods.impl.ZyrexModFPS;
/*     */ import java.awt.Color;
/*     */ import java.io.IOException;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import net.minecraft.client.Minecraft;
/*     */ import net.minecraft.client.gui.GuiButton;
/*     */ import net.minecraft.client.gui.GuiScreen;
/*     */ import net.minecraft.client.gui.ScaledResolution;
/*     */ import net.minecraft.client.renderer.GlStateManager;
/*     */ import net.minecraft.util.ResourceLocation;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class MotionBlurSettings
/*     */   extends GuiScreen
/*     */ {
/*     */   public static UnicodeFontRenderer ufr;
/*  63 */   public static ZyrexModFPS modFPS = new ZyrexModFPS();
/*     */   
/*  65 */   private List<Long> clicks = new ArrayList<>();
/*     */   
/*     */   private boolean wasPressed;
/*     */   private long lastPressed;
/*  69 */   private List<Long> clicks2 = new ArrayList<>();
/*     */   
/*     */   private boolean wasPressed2;
/*     */   private long lastPressed2;
/*     */   
/*     */   public void initGui() {
/*  75 */     int i = 24;
/*  76 */     int j = height / 4 + 48;
/*     */     
/*  78 */     ScaledResolution sr = new ScaledResolution(mc);
/*     */ 
/*     */     
/*  81 */     buttonList.add(new SettingsButtonToggle(1, width / 2 - 29, height / 2 - 45, 60, 15, "MotionBlurHud"));
/*  82 */     buttonList.add(new ButtonMainMenuZ(50, width / 2 - 200, height / 2 - 115, 20, 20, "<"));
/*     */     
/*  84 */     drawDefaultBackground();
/*     */   }
/*     */ 
/*     */   
/*     */   public void onGuiClosed() {
/*  89 */     (Minecraft.getMinecraft()).entityRenderer.loadEntityShader(null);
/*  90 */     super.onGuiClosed();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void drawScreen(int mouseX, int mouseY, float partialTicks) {
/*  97 */     if (ufr == null) {
/*  98 */       ufr = UnicodeFontRenderer.getFontOnPC("Arial", 20);
/*     */     }
/*     */     
/* 101 */     Minecraft.getMinecraft().getTextureManager().bindTexture(new ResourceLocation("zyrex_logo.png"));
/*     */     
/* 103 */     ScaledResolution sr = new ScaledResolution(mc);
/*     */     
/* 105 */     drawDefaultBackground();
/*     */     
/* 107 */     NewRoundedRect.drawBorderedRoundedRect((sr.getScaledWidth() / 2 - 200), (sr.getScaledHeight() / 2 - 116), (sr.getScaledWidth() / 2 + 205), (sr.getScaledHeight() / 2 + 116), 10.0F, 1.0F, 100, (new Color(17, 18, 19, 200)).getRGB());
/*     */     
/* 109 */     FontUtil.renderCenteredString("Motion Blur Settings", width / 2 + 1, height / 2 - 110, (new Color(255, 255, 255)).getRGB(), 1.0F);
/*     */ 
/*     */     
/* 112 */     FontUtil.renderCenteredString("Show Text", width / 2 - 1, height / 2 - 67, (new Color(255, 255, 255)).getRGB(), 1.0F);
/* 113 */     FontUtil.renderCenteredString("[ Shows the text on the hud ]", width / 2 + 1, height / 2 - 55, (new Color(155, 155, 155)).getRGB(), 0.6F);
/*     */     
/* 115 */     super.drawScreen(mouseX, mouseY, partialTicks);
/*     */   }
/*     */ 
/*     */   
/*     */   public void drawPlayerHead(int x, int y, int width) {
/* 120 */     GlStateManager.pushMatrix();
/* 121 */     float scale = (width / 32);
/* 122 */     GlStateManager.scale(scale, scale, scale);
/* 123 */     mc.getTextureManager().bindTexture(Minecraft.thePlayer.getLocationSkin());
/* 124 */     GL11.glEnable(3042);
/* 125 */     drawTexturedModalRect(x / scale, y / scale, 32, 32, 32, 32);
/* 126 */     GL11.glDisable(3042);
/* 127 */     GlStateManager.popMatrix();
/*     */   }
/*     */ 
/*     */   
/*     */   private int getCPS() {
/* 132 */     long time = System.currentTimeMillis();
/* 133 */     this.clicks.removeIf(aLong -> (aLong.longValue() + 1000L < paramLong));
/* 134 */     return this.clicks.size();
/*     */   }
/*     */ 
/*     */   
/*     */   private int getCPS2() {
/* 139 */     long time2 = System.currentTimeMillis();
/* 140 */     this.clicks2.removeIf(aLong2 -> (aLong2.longValue() + 1000L < paramLong));
/* 141 */     return this.clicks2.size();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void actionPerformed(GuiButton button) throws IOException {
/* 147 */     if (button.id == 50) {
/* 148 */       mc.displayGuiScreen(new ModHud5());
/*     */     }
/*     */     
/* 151 */     if (button.id == 1) {
/* 152 */       SettingsButtonToggle.save("MotionBlurHud", Boolean.valueOf(!SettingsButtonToggle.load("MotionBlurHud").booleanValue()));
/* 153 */       if (ModToggle.loadEnabledFromFile("Mods/ZyrexModMotionBlur/HideFromHud").booleanValue()) {
/* 154 */         Client.MotionBlurHideFromHud = !Client.MotionBlurHideFromHud;
/* 155 */         ModToggle.saveIsEnabledToFile("Mods/ZyrexModMotionBlur/HideFromHud", Boolean.valueOf(Client.FPSChroma));
/*     */       } else {
/* 157 */         Client.MotionBlurHideFromHud = !Client.MotionBlurHideFromHud;
/* 158 */         ModToggle.saveIsEnabledToFile("Mods/ZyrexModMotionBlur/HideFromHud", Boolean.valueOf(Client.MotionBlurHideFromHud));
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Lenovo\Downloads\ZyrexClientV1 (1).jar!\ZyrexClient\ModHuds\MotionBlurSettings.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */