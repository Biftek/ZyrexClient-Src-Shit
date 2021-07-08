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
/*     */ public class KeystrokesSettings
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
/*  81 */     buttonList.add(new SettingsButtonToggleBG(2, width / 2 - 29, height / 2, 60, 15, "KeystrokesCPS"));
/*  82 */     buttonList.add(new SettingsButtonToggle(1, width / 2 - 29, height / 2 - 45, 60, 15, "KeystrokesChroma"));
/*  83 */     buttonList.add(new ButtonMainMenuZ(50, width / 2 - 200, height / 2 - 115, 20, 20, "<"));
/*     */     
/*  85 */     drawDefaultBackground();
/*     */   }
/*     */ 
/*     */   
/*     */   public void onGuiClosed() {
/*  90 */     (Minecraft.getMinecraft()).entityRenderer.loadEntityShader(null);
/*  91 */     super.onGuiClosed();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void drawScreen(int mouseX, int mouseY, float partialTicks) {
/*  98 */     Minecraft.getMinecraft().getTextureManager().bindTexture(new ResourceLocation("zyrex_logo.png"));
/*     */     
/* 100 */     ScaledResolution sr = new ScaledResolution(mc);
/*     */     
/* 102 */     drawDefaultBackground();
/*     */     
/* 104 */     NewRoundedRect.drawBorderedRoundedRect((sr.getScaledWidth() / 2 - 200), (sr.getScaledHeight() / 2 - 116), (sr.getScaledWidth() / 2 + 205), (sr.getScaledHeight() / 2 + 116), 10.0F, 1.0F, 100, (new Color(17, 18, 19, 200)).getRGB());
/*     */     
/* 106 */     FontUtil.renderCenteredString("Keystrokes Settings", width / 2 + 1, height / 2 - 110, (new Color(255, 255, 255)).getRGB(), 1.0F);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 111 */     FontUtil.renderCenteredString("Chroma", width / 2 - 1, height / 2 - 67, (new Color(255, 255, 255)).getRGB(), 1.0F);
/* 112 */     FontUtil.renderCenteredString("[ Rainbow Keystrokes ]", width / 2 + 1, height / 2 - 55, (new Color(155, 155, 155)).getRGB(), 0.6F);
/*     */     
/* 114 */     FontUtil.renderCenteredString("CPS", width / 2 - 1, height / 2 - 22, (new Color(255, 255, 255)).getRGB(), 1.0F);
/* 115 */     FontUtil.renderCenteredString("[ Shows the cps under RMB and LMB ]", width / 2 + 1, height / 2 - 10, (new Color(155, 155, 155)).getRGB(), 0.6F);
/*     */     
/* 117 */     super.drawScreen(mouseX, mouseY, partialTicks);
/*     */   }
/*     */ 
/*     */   
/*     */   public void drawPlayerHead(int x, int y, int width) {
/* 122 */     GlStateManager.pushMatrix();
/* 123 */     float scale = (width / 32);
/* 124 */     GlStateManager.scale(scale, scale, scale);
/* 125 */     mc.getTextureManager().bindTexture(Minecraft.thePlayer.getLocationSkin());
/* 126 */     GL11.glEnable(3042);
/* 127 */     drawTexturedModalRect(x / scale, y / scale, 32, 32, 32, 32);
/* 128 */     GL11.glDisable(3042);
/* 129 */     GlStateManager.popMatrix();
/*     */   }
/*     */ 
/*     */   
/*     */   private int getCPS() {
/* 134 */     long time = System.currentTimeMillis();
/* 135 */     this.clicks.removeIf(aLong -> (aLong.longValue() + 1000L < paramLong));
/* 136 */     return this.clicks.size();
/*     */   }
/*     */ 
/*     */   
/*     */   private int getCPS2() {
/* 141 */     long time2 = System.currentTimeMillis();
/* 142 */     this.clicks2.removeIf(aLong2 -> (aLong2.longValue() + 1000L < paramLong));
/* 143 */     return this.clicks2.size();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void actionPerformed(GuiButton button) throws IOException {
/* 149 */     if (button.id == 50) {
/* 150 */       mc.displayGuiScreen(new ModHud5());
/*     */     }
/*     */     
/* 153 */     if (button.id == 1) {
/* 154 */       SettingsButtonToggle.save("KeystrokesChroma", Boolean.valueOf(!SettingsButtonToggle.load("KeystrokesChroma").booleanValue()));
/* 155 */       if (ModToggle.loadEnabledFromFile("Mods/ZyrexModKeystrokes/isChromaDisabled").booleanValue()) {
/* 156 */         Client.KeystrokesChroma = !Client.KeystrokesChroma;
/* 157 */         ModToggle.saveIsEnabledToFile("Mods/ZyrexModKeystrokes/isChromaDisabled", Boolean.valueOf(Client.KeystrokesChroma));
/*     */       } else {
/* 159 */         Client.KeystrokesChroma = !Client.KeystrokesChroma;
/* 160 */         ModToggle.saveIsEnabledToFile("Mods/ZyrexModKeystrokes/isChromaDisabled", Boolean.valueOf(Client.KeystrokesChroma));
/*     */       } 
/*     */     } 
/*     */     
/* 164 */     if (button.id == 2) {
/* 165 */       SettingsButtonToggle.save("KeystrokesCPS", Boolean.valueOf(!SettingsButtonToggle.load("KeystrokesCPS").booleanValue()));
/* 166 */       if (ModToggle.loadEnabledFromFile("Mods/ZyrexModKeystrokes/KeystrokesCPS").booleanValue()) {
/* 167 */         Client.KeystrokesCPS = !Client.KeystrokesCPS;
/* 168 */         ModToggle.saveIsEnabledToFile("Mods/ZyrexModKeystrokes/KeystrokesCPS", Boolean.valueOf(Client.KeystrokesCPS));
/*     */       } else {
/* 170 */         Client.KeystrokesCPS = !Client.KeystrokesCPS;
/* 171 */         ModToggle.saveIsEnabledToFile("Mods/ZyrexModKeystrokes/KeystrokesCPS", Boolean.valueOf(Client.KeystrokesCPS));
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Lenovo\Downloads\ZyrexClientV1 (1).jar!\ZyrexClient\ModHuds\KeystrokesSettings.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */