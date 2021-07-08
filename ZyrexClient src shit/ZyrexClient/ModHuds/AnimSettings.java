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
/*     */ public class AnimSettings
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
/*  81 */     buttonList.add(new SettingsButtonToggleBG(1, width / 2 - 29, height / 2 - 45, 60, 15, "1.7 Eating"));
/*  82 */     buttonList.add(new SettingsButtonToggleBG(2, width / 2 - 29, height / 2, 60, 15, "1.7 Blockhit"));
/*  83 */     buttonList.add(new SettingsButtonToggleBG(3, width / 2 - 29, height / 2 + 45, 60, 15, "1.7 Bow"));
/*  84 */     buttonList.add(new ButtonMainMenuZ(50, width / 2 - 200, height / 2 - 115, 20, 20, "<"));
/*     */     
/*  86 */     drawDefaultBackground();
/*     */   }
/*     */ 
/*     */   
/*     */   public void onGuiClosed() {
/*  91 */     (Minecraft.getMinecraft()).entityRenderer.loadEntityShader(null);
/*  92 */     super.onGuiClosed();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void drawScreen(int mouseX, int mouseY, float partialTicks) {
/*  99 */     if (ufr == null) {
/* 100 */       ufr = UnicodeFontRenderer.getFontOnPC("Arial", 20);
/*     */     }
/*     */     
/* 103 */     Minecraft.getMinecraft().getTextureManager().bindTexture(new ResourceLocation("zyrex_logo.png"));
/*     */     
/* 105 */     ScaledResolution sr = new ScaledResolution(mc);
/*     */     
/* 107 */     drawDefaultBackground();
/*     */     
/* 109 */     NewRoundedRect.drawBorderedRoundedRect((sr.getScaledWidth() / 2 - 200), (sr.getScaledHeight() / 2 - 116), (sr.getScaledWidth() / 2 + 205), (sr.getScaledHeight() / 2 + 116), 10.0F, 1.0F, 100, (new Color(17, 18, 19, 200)).getRGB());
/*     */     
/* 111 */     FontUtil.renderCenteredString("Old Animations Settings", width / 2 + 1, height / 2 - 110, (new Color(255, 255, 255)).getRGB(), 1.0F);
/*     */     
/* 113 */     FontUtil.renderCenteredString("1.7 Eating", width / 2 - 1, height / 2 - 67, (new Color(255, 255, 255)).getRGB(), 1.0F);
/* 114 */     FontUtil.renderCenteredString("[ The old Eating ]", width / 2 + 1, height / 2 - 55, (new Color(155, 155, 155)).getRGB(), 0.6F);
/*     */     
/* 116 */     FontUtil.renderCenteredString("1.7 Blockhit", width / 2 - 1, height / 2 - 22, (new Color(255, 255, 255)).getRGB(), 1.0F);
/* 117 */     FontUtil.renderCenteredString("[ The old Blockhiting ]", width / 2 + 1, height / 2 - 10, (new Color(155, 155, 155)).getRGB(), 0.6F);
/*     */     
/* 119 */     FontUtil.renderCenteredString("1.7 Bow", width / 2 - 1, height / 2 + 22, (new Color(255, 255, 255)).getRGB(), 1.0F);
/* 120 */     FontUtil.renderCenteredString("[ The old Bow Animations ]", width / 2 + 1, height / 2 + 35, (new Color(155, 155, 155)).getRGB(), 0.6F);
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
/* 159 */       SettingsButtonToggle.save("1.7 Eating", Boolean.valueOf(!SettingsButtonToggle.load("1.7 Eating").booleanValue()));
/* 160 */       if (ModToggle.loadEnabledFromFile("Mods/ZyrexModOldAnims/EatingAnimation").booleanValue()) {
/* 161 */         Client.EatingAnimation = !Client.EatingAnimation;
/* 162 */         ModToggle.saveIsEnabledToFile("Mods/ZyrexModOldAnims/EatingAnimation", Boolean.valueOf(Client.EatingAnimation));
/*     */       } else {
/* 164 */         Client.EatingAnimation = !Client.EatingAnimation;
/* 165 */         ModToggle.saveIsEnabledToFile("Mods/ZyrexModOldAnims/EatingAnimation", Boolean.valueOf(Client.EatingAnimation));
/*     */       } 
/*     */     } 
/*     */     
/* 169 */     if (button.id == 2) {
/* 170 */       SettingsButtonToggle.save("1.7 Blockhit", Boolean.valueOf(!SettingsButtonToggle.load("1.7 Blockhit").booleanValue()));
/* 171 */       if (ModToggle.loadEnabledFromFile("Mods/ZyrexModOldAnims/SwordAnimation").booleanValue()) {
/* 172 */         Client.SwordAnimation = !Client.SwordAnimation;
/* 173 */         ModToggle.saveIsEnabledToFile("Mods/ZyrexModOldAnims/SwordAnimation", Boolean.valueOf(Client.SwordAnimation));
/*     */       } else {
/* 175 */         Client.SwordAnimation = !Client.SwordAnimation;
/* 176 */         ModToggle.saveIsEnabledToFile("Mods/ZyrexModOldAnims/SwordAnimation", Boolean.valueOf(Client.SwordAnimation));
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 181 */     if (button.id == 3) {
/* 182 */       SettingsButtonToggle.save("1.7 Bow", Boolean.valueOf(!SettingsButtonToggle.load("1.7 Bow").booleanValue()));
/* 183 */       if (ModToggle.loadEnabledFromFile("Mods/ZyrexModOldAnims/BowAnimation").booleanValue()) {
/* 184 */         Client.BowAnimation = !Client.BowAnimation;
/* 185 */         ModToggle.saveIsEnabledToFile("Mods/ZyrexModOldAnims/BowAnimation", Boolean.valueOf(Client.BowAnimation));
/*     */       } else {
/* 187 */         Client.BowAnimation = !Client.BowAnimation;
/* 188 */         ModToggle.saveIsEnabledToFile("Mods/ZyrexModOldAnims/BowAnimation", Boolean.valueOf(Client.BowAnimation));
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Lenovo\Downloads\ZyrexClientV1 (1).jar!\ZyrexClient\ModHuds\AnimSettings.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */