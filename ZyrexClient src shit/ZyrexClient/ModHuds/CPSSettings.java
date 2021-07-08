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
/*     */ public class CPSSettings
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
/*  81 */     buttonList.add(new SettingsButtonToggle(1, width / 2 - 29, height / 2 - 45, 60, 15, "CPSChroma"));
/*  82 */     buttonList.add(new SettingsButtonToggleBG(2, width / 2 - 29, height / 2, 60, 15, "CPSBackground"));
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
/*  98 */     if (ufr == null) {
/*  99 */       ufr = UnicodeFontRenderer.getFontOnPC("Arial", 20);
/*     */     }
/*     */     
/* 102 */     Minecraft.getMinecraft().getTextureManager().bindTexture(new ResourceLocation("zyrex_logo.png"));
/*     */     
/* 104 */     ScaledResolution sr = new ScaledResolution(mc);
/*     */     
/* 106 */     drawDefaultBackground();
/*     */     
/* 108 */     NewRoundedRect.drawBorderedRoundedRect((sr.getScaledWidth() / 2 - 200), (sr.getScaledHeight() / 2 - 116), (sr.getScaledWidth() / 2 + 205), (sr.getScaledHeight() / 2 + 116), 10.0F, 1.0F, 100, (new Color(17, 18, 19, 200)).getRGB());
/*     */     
/* 110 */     FontUtil.renderCenteredString("CPS Settings", width / 2 + 1, height / 2 - 110, (new Color(255, 255, 255)).getRGB(), 1.0F);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 115 */     FontUtil.renderCenteredString("Chroma", width / 2 - 1, height / 2 - 67, (new Color(255, 255, 255)).getRGB(), 1.0F);
/* 116 */     FontUtil.renderCenteredString("[ Rainbow CPS counter ]", width / 2 + 1, height / 2 - 55, (new Color(155, 155, 155)).getRGB(), 0.6F);
/*     */ 
/*     */     
/* 119 */     FontUtil.renderCenteredString("Background", width / 2 - 1, height / 2 - 22, (new Color(255, 255, 255)).getRGB(), 1.0F);
/* 120 */     FontUtil.renderCenteredString("[ Background for the mod ]", width / 2 + 1, height / 2 - 10, (new Color(155, 155, 155)).getRGB(), 0.6F);
/*     */     
/* 122 */     super.drawScreen(mouseX, mouseY, partialTicks);
/*     */   }
/*     */ 
/*     */   
/*     */   public void drawPlayerHead(int x, int y, int width) {
/* 127 */     GlStateManager.pushMatrix();
/* 128 */     float scale = (width / 32);
/* 129 */     GlStateManager.scale(scale, scale, scale);
/* 130 */     mc.getTextureManager().bindTexture(Minecraft.thePlayer.getLocationSkin());
/* 131 */     GL11.glEnable(3042);
/* 132 */     drawTexturedModalRect(x / scale, y / scale, 32, 32, 32, 32);
/* 133 */     GL11.glDisable(3042);
/* 134 */     GlStateManager.popMatrix();
/*     */   }
/*     */ 
/*     */   
/*     */   private int getCPS() {
/* 139 */     long time = System.currentTimeMillis();
/* 140 */     this.clicks.removeIf(aLong -> (aLong.longValue() + 1000L < paramLong));
/* 141 */     return this.clicks.size();
/*     */   }
/*     */ 
/*     */   
/*     */   private int getCPS2() {
/* 146 */     long time2 = System.currentTimeMillis();
/* 147 */     this.clicks2.removeIf(aLong2 -> (aLong2.longValue() + 1000L < paramLong));
/* 148 */     return this.clicks2.size();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void actionPerformed(GuiButton button) throws IOException {
/* 154 */     if (button.id == 50) {
/* 155 */       mc.displayGuiScreen(new ModHud5());
/*     */     }
/*     */     
/* 158 */     if (button.id == 1) {
/* 159 */       SettingsButtonToggle.save("CPSChroma", Boolean.valueOf(!SettingsButtonToggle.load("CPSChroma").booleanValue()));
/* 160 */       if (ModToggle.loadEnabledFromFile("Mods/ZyrexModCPS/isChromaDisabled").booleanValue()) {
/* 161 */         Client.CPSChroma = !Client.CPSChroma;
/* 162 */         ModToggle.saveIsEnabledToFile("Mods/ZyrexModCPS/isChromaDisabled", Boolean.valueOf(Client.CPSChroma));
/*     */       } else {
/* 164 */         Client.CPSChroma = !Client.CPSChroma;
/* 165 */         ModToggle.saveIsEnabledToFile("Mods/ZyrexModCPS/isChromaDisabled", Boolean.valueOf(Client.CPSChroma));
/*     */       } 
/*     */     } 
/*     */     
/* 169 */     if (button.id == 2) {
/* 170 */       SettingsButtonToggle.save("CPSBackground", Boolean.valueOf(!SettingsButtonToggle.load("CPSBackground").booleanValue()));
/* 171 */       if (ModToggle.loadEnabledFromFile("Mods/ZyrexModCPS/CPSBackground").booleanValue()) {
/* 172 */         Client.CPSBackground = !Client.CPSBackground;
/* 173 */         ModToggle.saveIsEnabledToFile("Mods/ZyrexModCPS/CPSBackground", Boolean.valueOf(Client.CPSBackground));
/*     */       } else {
/* 175 */         Client.CPSBackground = !Client.CPSBackground;
/* 176 */         ModToggle.saveIsEnabledToFile("Mods/ZyrexModCPS/CPSBackground", Boolean.valueOf(Client.CPSBackground));
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Lenovo\Downloads\ZyrexClientV1 (1).jar!\ZyrexClient\ModHuds\CPSSettings.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */