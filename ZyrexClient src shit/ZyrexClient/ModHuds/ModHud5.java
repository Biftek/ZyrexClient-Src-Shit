/*     */ package ZyrexClient.ModHuds;
/*     */ 
/*     */ import ZyrexClient.Client;
/*     */ import ZyrexClient.Gui.UnicodeFontRenderer;
/*     */ import ZyrexClient.ModToggle.ModToggle;
/*     */ import ZyrexClient.NewRoundedRect;
/*     */ import ZyrexClient.clickgui.FontUtil;
/*     */ import ZyrexClient.clickgui.RoundedButtons.ButtonMainMenuZ;
/*     */ import ZyrexClient.clickgui.ScrollListModToggle;
/*     */ import ZyrexClient.clickguitest.ModToggleButton;
/*     */ import ZyrexClient.clickguitest.SwitchPageButton;
/*     */ import ZyrexClient.mods.impl.ModSettingsButton;
/*     */ import ZyrexClient.mods.impl.ZyrexModFPS;
/*     */ import java.awt.Color;
/*     */ import java.io.IOException;
/*     */ import net.minecraft.client.Minecraft;
/*     */ import net.minecraft.client.gui.Gui;
/*     */ import net.minecraft.client.gui.GuiButton;
/*     */ import net.minecraft.client.gui.GuiScreen;
/*     */ import net.minecraft.client.gui.ScaledResolution;
/*     */ import net.minecraft.client.renderer.GlStateManager;
/*     */ import net.minecraft.client.resources.I18n;
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
/*     */ public class ModHud5
/*     */   extends GuiScreen
/*     */ {
/*     */   public static UnicodeFontRenderer ufr;
/*  66 */   public static ZyrexModFPS modFPS = new ZyrexModFPS();
/*     */   
/*     */   private ScrollListModToggle scrollPanel;
/*     */ 
/*     */   
/*     */   public void initGui() {
/*  72 */     int i = 24;
/*  73 */     int j = height / 4 + 48;
/*     */     
/*  75 */     ScaledResolution sr = new ScaledResolution(mc);
/*     */ 
/*     */     
/*  78 */     buttonList.add(new ModToggleButton(9, width / 2 - 205, height / 2 - 15, 26, 12, I18n.format("Old Animations", new Object[0])));
/*  79 */     buttonList.add(new ModToggleButtonFalse(7, width / 2 - 105, height / 2 - 15, 26, 12, I18n.format("Motion Blur", new Object[0])));
/*  80 */     buttonList.add(new ModToggleButton(2, width / 2 - 5, height / 2 - 15, 26, 12, I18n.format("FPS", new Object[0])));
/*  81 */     buttonList.add(new ModToggleButton(4, width / 2 + 195, height / 2 - 15, 26, 12, I18n.format("Keystrokes", new Object[0])));
/*  82 */     buttonList.add(new ModToggleButton(1, width / 2 + 95, height / 2 - 15, 26, 12, I18n.format("CPS", new Object[0])));
/*     */ 
/*     */     
/*  85 */     buttonList.add(new ButtonMainMenuZ(0, width / 2 - 350, height / 2 - 20, 70, 12, I18n.format("§8Modules", new Object[0])));
/*  86 */     buttonList.add(new ButtonMainMenuZ(101, width / 2 - 350, height / 2 - 5, 70, 12, I18n.format("Cosmetics", new Object[0])));
/*  87 */     buttonList.add(new ButtonMainMenuZ(90, width / 2 - 350, height / 2 + 110, 70, 12, I18n.format("Settings", new Object[0])));
/*     */ 
/*     */     
/*  90 */     buttonList.add(new ModToggleButton(8, width / 2 - 205, height / 2 + 105, 26, 12, I18n.format("Coordinates", new Object[0])));
/*  91 */     buttonList.add(new ButtonUnavaliable(0, width / 2 - 105, height / 2 + 105, 26, 12, I18n.format("Freelook", new Object[0])));
/*  92 */     buttonList.add(new ModToggleButton(3, width / 2 - 5, height / 2 + 105, 26, 12, I18n.format("Ping", new Object[0])));
/*  93 */     buttonList.add(new ModToggleButton(5, width / 2 + 195, height / 2 + 105, 26, 12, I18n.format("Armor Status", new Object[0])));
/*  94 */     buttonList.add(new ModToggleButton(6, width / 2 + 95, height / 2 + 105, 26, 12, I18n.format("Potion Status", new Object[0])));
/*     */ 
/*     */     
/*  97 */     buttonList.add(new SwitchPageButton(50, width / 2 + 275, height / 2 + 8, 20, 20, I18n.format(">", new Object[0])));
/*  98 */     buttonList.add(new ModSettingsButton(60, width / 2 + 130, height / 2 - 11, 20, 20, "CPS"));
/*  99 */     buttonList.add(new ModSettingsButton(61, width / 2 + 30, height / 2 - 11, 20, 20, "FPS"));
/* 100 */     buttonList.add(new ModSettingsButton(62, width / 2 + 30, height / 2 + 109, 20, 20, "Ping"));
/* 101 */     buttonList.add(new ModSettingsButton(63, width / 2 + 230, height / 2 - 11, 20, 20, "Keystrokes"));
/* 102 */     buttonList.add(new ModSettingsButton(64, width / 2 + 230, height / 2 + 109, 20, 20, "ArmorStatus"));
/* 103 */     buttonList.add(new ModSettingsButton(65, width / 2 + 130, height / 2 + 109, 20, 20, "PotionStatus"));
/* 104 */     buttonList.add(new ModSettingsButton(66, width / 2 - 170, height / 2 + 109, 20, 20, "Coordinates"));
/* 105 */     buttonList.add(new ModSettingsButton(67, width / 2 - 70, height / 2 - 11, 20, 20, "MotionBlur"));
/* 106 */     buttonList.add(new ModSettingsButton(68, width / 2 - 170, height / 2 - 11, 20, 20, "MotionBlur"));
/* 107 */     drawDefaultBackground();
/*     */   }
/*     */ 
/*     */   
/*     */   public void onGuiClosed() {
/* 112 */     (Minecraft.getMinecraft()).entityRenderer.loadEntityShader(null);
/* 113 */     super.onGuiClosed();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void drawScreen(int mouseX, int mouseY, float partialTicks) {
/* 120 */     if (ufr == null) {
/* 121 */       ufr = UnicodeFontRenderer.getFontOnPC("Arial", 20);
/*     */     }
/*     */     
/* 124 */     Minecraft.getMinecraft().getTextureManager().bindTexture(new ResourceLocation("zyrex_logo.png"));
/*     */     
/* 126 */     ScaledResolution sr = new ScaledResolution(mc);
/*     */ 
/*     */     
/* 129 */     drawDefaultBackground();
/*     */ 
/*     */     
/* 132 */     NewRoundedRect.drawBorderedRoundedRect((sr.getScaledWidth() / 2 - 251), (sr.getScaledHeight() / 2 - 146), (sr.getScaledWidth() / 2 + 268), (sr.getScaledHeight() / 2 - 119), 16.0F, 1.0F, 100, (new Color(100, 100, 100, 80)).getRGB());
/* 133 */     NewRoundedRect.drawBorderedRoundedRect((sr.getScaledWidth() / 2 - 250), (sr.getScaledHeight() / 2 - 145), (sr.getScaledWidth() / 2 + 267), (sr.getScaledHeight() / 2 - 120), 15.0F, 1.0F, 100, (new Color(20, 20, 20)).getRGB());
/*     */ 
/*     */     
/* 136 */     NewRoundedRect.drawBorderedRoundedRect((sr.getScaledWidth() / 2 - 35), (sr.getScaledHeight() / 2 + 155), (sr.getScaledWidth() / 2 + 50), (sr.getScaledHeight() / 2 + 180), 16.0F, 1.0F, 100, (new Color(20, 20, 20)).getRGB());
/*     */     
/* 138 */     NewRoundedRect.drawBorderedRoundedRect((sr.getScaledWidth() / 2 - 351), (sr.getScaledHeight() / 2 - 117), (sr.getScaledWidth() / 2 - 279), (sr.getScaledHeight() / 2 + 151), 10.0F, 1.0F, 100, (new Color(100, 100, 100, 80)).getRGB());
/* 139 */     NewRoundedRect.drawBorderedRoundedRect((sr.getScaledWidth() / 2 - 350), (sr.getScaledHeight() / 2 - 116), (sr.getScaledWidth() / 2 - 280), (sr.getScaledHeight() / 2 + 150), 10.0F, 1.0F, 100, (new Color(20, 20, 20)).getRGB());
/*     */     
/* 141 */     NewRoundedRect.drawBorderedRoundedRect((sr.getScaledWidth() / 2 - 251), (sr.getScaledHeight() / 2 - 117), (sr.getScaledWidth() / 2 + 266), (sr.getScaledHeight() / 2 + 151), 10.0F, 1.0F, 100, (new Color(100, 100, 100, 80)).getRGB());
/* 142 */     NewRoundedRect.drawBorderedRoundedRect((sr.getScaledWidth() / 2 - 250), (sr.getScaledHeight() / 2 - 116), (sr.getScaledWidth() / 2 + 265), (sr.getScaledHeight() / 2 + 150), 10.0F, 1.0F, 100, (new Color(20, 20, 20)).getRGB());
/*     */     
/* 144 */     GlStateManager.color(1.0F, 1.0F, 1.0F);
/* 145 */     mc.getTextureManager().bindTexture(new ResourceLocation("zyrex_logo.png"));
/* 146 */     Gui.drawModalRectWithCustomSizedTexture(width / 2 - 340, height / 2 - 115, 0.0F, 0.0F, 50, 50, 50.0F, 50.0F);
/*     */     
/* 148 */     FontUtil.renderCenteredString("Modules", width / 2 + 7, height / 2 - 139, (new Color(255, 255, 255)).getRGB(), 1.0F);
/*     */     
/* 150 */     FontUtil.renderCenteredString("Page 1/2", width / 2 + 7, height / 2 + 161, (new Color(255, 255, 255)).getRGB(), 1.0F);
/*     */     
/* 152 */     FontUtil.renderCenteredString("Zyrex Client", width / 2 - 315, height / 2 + 132, (new Color(100, 100, 100)).getRGB(), 1.0F);
/*     */     
/* 154 */     super.drawScreen(mouseX, mouseY, partialTicks);
/*     */   }
/*     */ 
/*     */   
/*     */   public void drawPlayerHead(int x, int y, int width) {
/* 159 */     GlStateManager.pushMatrix();
/* 160 */     float scale = (width / 32);
/* 161 */     GlStateManager.scale(scale, scale, scale);
/* 162 */     mc.getTextureManager().bindTexture(Minecraft.thePlayer.getLocationSkin());
/* 163 */     GL11.glEnable(3042);
/* 164 */     drawTexturedModalRect(x / scale, y / scale, 32, 32, 32, 32);
/* 165 */     GL11.glDisable(3042);
/* 166 */     GlStateManager.popMatrix();
/*     */   }
/*     */ 
/*     */   
/*     */   public void actionPerformed(GuiButton button) throws IOException {
/* 171 */     if (button.id == 90) {
/* 172 */       mc.displayGuiScreen(new ModHud5_Settings());
/*     */     }
/*     */     
/* 175 */     if (button.id == 60) {
/* 176 */       mc.displayGuiScreen(new CPSSettings());
/*     */     }
/*     */     
/* 179 */     if (button.id == 61) {
/* 180 */       mc.displayGuiScreen(new FPSSettings());
/*     */     }
/*     */     
/* 183 */     if (button.id == 62) {
/* 184 */       mc.displayGuiScreen(new PingSettings());
/*     */     }
/*     */     
/* 187 */     if (button.id == 63) {
/* 188 */       mc.displayGuiScreen(new KeystrokesSettings());
/*     */     }
/*     */     
/* 191 */     if (button.id == 64) {
/* 192 */       mc.displayGuiScreen(new ArmorStatusSettings());
/*     */     }
/*     */     
/* 195 */     if (button.id == 65) {
/* 196 */       mc.displayGuiScreen(new PotionStatusSettings());
/*     */     }
/*     */     
/* 199 */     if (button.id == 66) {
/* 200 */       mc.displayGuiScreen(new CoordinatesSettings());
/*     */     }
/*     */     
/* 203 */     if (button.id == 67) {
/* 204 */       mc.displayGuiScreen(new MotionBlurSettings());
/*     */     }
/*     */     
/* 207 */     if (button.id == 68) {
/* 208 */       mc.displayGuiScreen(new AnimSettings());
/*     */     }
/*     */ 
/*     */     
/* 212 */     if (button.id == 50) {
/* 213 */       mc.displayGuiScreen(new ModHud5_Page2());
/*     */     }
/*     */     
/* 216 */     if (button.id == 101) {
/* 217 */       mc.displayGuiScreen(new CosmeticsHud3());
/*     */     }
/*     */     
/* 220 */     if (button.id == 1) {
/* 221 */       ModToggleButton.save("CPS", Boolean.valueOf(!ModToggleButton.load("CPS").booleanValue()));
/* 222 */       if (ModToggle.loadEnabledFromFile("Mods/ZyrexModCPS/ModCPS").booleanValue()) {
/* 223 */         Client.ModCPS = !Client.ModCPS;
/* 224 */         ModToggle.saveIsEnabledToFile("Mods/ZyrexModCPS/ModCPS", Boolean.valueOf(Client.ModCPS));
/*     */       } else {
/* 226 */         Client.ModCPS = !Client.ModCPS;
/* 227 */         ModToggle.saveIsEnabledToFile("Mods/ZyrexModCPS/ModCPS", Boolean.valueOf(Client.ModCPS));
/*     */       } 
/*     */     } 
/*     */     
/* 231 */     if (button.id == 2) {
/* 232 */       ModToggleButton.save("FPS", Boolean.valueOf(!ModToggleButton.load("FPS").booleanValue()));
/* 233 */       if (ModToggle.loadEnabledFromFile("Mods/ZyrexModFPS/ModFPS").booleanValue()) {
/* 234 */         Client.ModFPS = !Client.ModFPS;
/* 235 */         ModToggle.saveIsEnabledToFile("Mods/ZyrexModFPS/ModFPS", Boolean.valueOf(Client.ModFPS));
/*     */       } else {
/* 237 */         Client.ModFPS = !Client.ModFPS;
/* 238 */         ModToggle.saveIsEnabledToFile("Mods/ZyrexModFPS/ModFPS", Boolean.valueOf(Client.ModFPS));
/*     */       } 
/*     */     } 
/*     */     
/* 242 */     if (button.id == 3) {
/* 243 */       ModToggleButton.save("Ping", Boolean.valueOf(!ModToggleButton.load("Ping").booleanValue()));
/* 244 */       if (ModToggle.loadEnabledFromFile("Mods/ZyrexModPing/ModPing").booleanValue()) {
/* 245 */         Client.ModPing = !Client.ModPing;
/* 246 */         ModToggle.saveIsEnabledToFile("Mods/ZyrexModPing/ModPing", Boolean.valueOf(Client.ModPing));
/*     */       } else {
/* 248 */         Client.ModPing = !Client.ModPing;
/* 249 */         ModToggle.saveIsEnabledToFile("Mods/ZyrexModPing/ModPing", Boolean.valueOf(Client.ModPing));
/*     */       } 
/*     */     } 
/*     */     
/* 253 */     if (button.id == 4) {
/* 254 */       ModToggleButton.save("Keystrokes", Boolean.valueOf(!ModToggleButton.load("Keystrokes").booleanValue()));
/* 255 */       if (ModToggle.loadEnabledFromFile("Mods/ZyrexModKeystrokes/ModKeystrokes").booleanValue()) {
/* 256 */         Client.ModKeystrokes = !Client.ModKeystrokes;
/* 257 */         ModToggle.saveIsEnabledToFile("Mods/ZyrexModKeystrokes/ModKeystrokes", Boolean.valueOf(Client.ModKeystrokes));
/*     */       } else {
/* 259 */         Client.ModKeystrokes = !Client.ModKeystrokes;
/* 260 */         ModToggle.saveIsEnabledToFile("Mods/ZyrexModKeystrokes/ModKeystrokes", Boolean.valueOf(Client.ModKeystrokes));
/*     */       } 
/*     */     } 
/*     */     
/* 264 */     if (button.id == 5) {
/* 265 */       ModToggleButton.save("Armor Status", Boolean.valueOf(!ModToggleButton.load("Armor Status").booleanValue()));
/* 266 */       if (ModToggle.loadEnabledFromFile("Mods/ZyrexModArmorStatus/ArmorStatus").booleanValue()) {
/* 267 */         Client.ModArmorStatus = !Client.ModArmorStatus;
/* 268 */         ModToggle.saveIsEnabledToFile("Mods/ZyrexModArmorStatus/ArmorStatus", Boolean.valueOf(Client.ModArmorStatus));
/*     */       } else {
/* 270 */         Client.ModArmorStatus = !Client.ModArmorStatus;
/* 271 */         ModToggle.saveIsEnabledToFile("Mods/ZyrexModArmorStatus/ArmorStatus", Boolean.valueOf(Client.ModArmorStatus));
/*     */       } 
/*     */     } 
/*     */     
/* 275 */     if (button.id == 6) {
/* 276 */       ModToggleButton.save("Potion Status", Boolean.valueOf(!ModToggleButton.load("Potion Status").booleanValue()));
/* 277 */       if (ModToggle.loadEnabledFromFile("Mods/ZyrexModPotStatus/PotionStatus").booleanValue()) {
/* 278 */         Client.ModPotionStatus = !Client.ModPotionStatus;
/* 279 */         ModToggle.saveIsEnabledToFile("Mods/ZyrexModPotStatus/PotionStatus", Boolean.valueOf(Client.ModPotionStatus));
/*     */       } else {
/* 281 */         Client.ModPotionStatus = !Client.ModPotionStatus;
/* 282 */         ModToggle.saveIsEnabledToFile("Mods/ZyrexModPotStatus/PotionStatus", Boolean.valueOf(Client.ModPotionStatus));
/*     */       } 
/*     */     } 
/*     */     
/* 286 */     if (button.id == 7) {
/* 287 */       ModToggleButton.save("Motion Blur", Boolean.valueOf(!ModToggleButton.load("Motion Blur").booleanValue()));
/* 288 */       if (ModToggle.loadEnabledFromFile("Mods/ZyrexModMotionBlur/MotionBlur").booleanValue()) {
/* 289 */         Client.MotionBlur = !Client.MotionBlur;
/* 290 */         ModToggle.saveIsEnabledToFile("Mods/ZyrexModMotionBlur/MotionBlur", Boolean.valueOf(Client.MotionBlur));
/*     */       } else {
/* 292 */         Client.MotionBlur = !Client.MotionBlur;
/* 293 */         ModToggle.saveIsEnabledToFile("Mods/ZyrexModMotionBlur/MotionBlur", Boolean.valueOf(Client.MotionBlur));
/*     */       } 
/*     */     } 
/*     */     
/* 297 */     if (button.id == 8) {
/* 298 */       ModToggleButton.save("Coordinates", Boolean.valueOf(!ModToggleButton.load("Coordinates").booleanValue()));
/* 299 */       if (ModToggle.loadEnabledFromFile("Mods/ZyrexModCoordinates/ModCoordinates").booleanValue()) {
/* 300 */         Client.ModCoordinates = !Client.ModCoordinates;
/* 301 */         ModToggle.saveIsEnabledToFile("Mods/ZyrexModCoordinates/ModCoordinates", Boolean.valueOf(Client.ModCoordinates));
/*     */       } else {
/* 303 */         Client.ModCoordinates = !Client.ModCoordinates;
/* 304 */         ModToggle.saveIsEnabledToFile("Mods/ZyrexModCoordinates/ModCoordinates", Boolean.valueOf(Client.ModCoordinates));
/*     */       } 
/*     */     } 
/*     */     
/* 308 */     if (button.id == 9) {
/* 309 */       ModToggleButton.save("Old Animations", Boolean.valueOf(!ModToggleButton.load("Old Animations").booleanValue()));
/* 310 */       if (!ModToggle.loadEnabledFromFile("Mods/ZyrexModOldAnims/ModOldAnims").booleanValue()) {
/* 311 */         Client.oldAnimations = !Client.oldAnimations;
/* 312 */         ModToggle.saveIsEnabledToFile("Mods/ZyrexModOldAnims/ModOldAnims", Boolean.valueOf(Client.oldAnimations));
/*     */       } else {
/* 314 */         Client.oldAnimations = !Client.oldAnimations;
/* 315 */         ModToggle.saveIsEnabledToFile("Mods/ZyrexModOldAnims/ModOldAnims", Boolean.valueOf(Client.oldAnimations));
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Lenovo\Downloads\ZyrexClientV1 (1).jar!\ZyrexClient\ModHuds\ModHud5.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */