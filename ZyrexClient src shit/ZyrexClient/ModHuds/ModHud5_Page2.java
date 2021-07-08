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
/*     */ public class ModHud5_Page2
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
/*  78 */     buttonList.add(new ModToggleButtonFalse(2, width / 2 - 205, height / 2 - 15, 26, 12, I18n.format("Custom Chat", new Object[0])));
/*  79 */     buttonList.add(new ModToggleButtonFalse(3, width / 2 - 105, height / 2 - 15, 26, 12, I18n.format("Direction", new Object[0])));
/*  80 */     buttonList.add(new ModToggleButtonFalse(1, width / 2 - 5, height / 2 - 15, 26, 12, I18n.format("Nametag", new Object[0])));
/*     */ 
/*     */     
/*  83 */     buttonList.add(new ButtonMainMenuZ(0, width / 2 - 350, height / 2 - 20, 70, 12, I18n.format("§8Modules", new Object[0])));
/*  84 */     buttonList.add(new ButtonMainMenuZ(101, width / 2 - 350, height / 2 - 5, 70, 12, I18n.format("Cosmetics", new Object[0])));
/*  85 */     buttonList.add(new ButtonMainMenuZ(90, width / 2 - 350, height / 2 + 110, 70, 12, I18n.format("Settings", new Object[0])));
/*     */ 
/*     */     
/*  88 */     buttonList.add(new SwitchPageButton(50, width / 2 + 275, height / 2 + 8, 20, 20, I18n.format("<", new Object[0])));
/*  89 */     buttonList.add(new ModSettingsButton(68, width / 2 - 170, height / 2 - 11, 20, 20, "Custom Chat"));
/*  90 */     drawDefaultBackground();
/*     */   }
/*     */ 
/*     */   
/*     */   public void onGuiClosed() {
/*  95 */     (Minecraft.getMinecraft()).entityRenderer.loadEntityShader(null);
/*  96 */     super.onGuiClosed();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void drawScreen(int mouseX, int mouseY, float partialTicks) {
/* 103 */     if (ufr == null) {
/* 104 */       ufr = UnicodeFontRenderer.getFontOnPC("Arial", 20);
/*     */     }
/*     */     
/* 107 */     Minecraft.getMinecraft().getTextureManager().bindTexture(new ResourceLocation("zyrex_logo.png"));
/*     */     
/* 109 */     ScaledResolution sr = new ScaledResolution(mc);
/*     */ 
/*     */     
/* 112 */     drawDefaultBackground();
/*     */ 
/*     */     
/* 115 */     NewRoundedRect.drawBorderedRoundedRect((sr.getScaledWidth() / 2 - 251), (sr.getScaledHeight() / 2 - 146), (sr.getScaledWidth() / 2 + 268), (sr.getScaledHeight() / 2 - 119), 16.0F, 1.0F, 100, (new Color(100, 100, 100, 80)).getRGB());
/* 116 */     NewRoundedRect.drawBorderedRoundedRect((sr.getScaledWidth() / 2 - 250), (sr.getScaledHeight() / 2 - 145), (sr.getScaledWidth() / 2 + 267), (sr.getScaledHeight() / 2 - 120), 15.0F, 1.0F, 100, (new Color(20, 20, 20)).getRGB());
/*     */ 
/*     */     
/* 119 */     NewRoundedRect.drawBorderedRoundedRect((sr.getScaledWidth() / 2 - 35), (sr.getScaledHeight() / 2 + 155), (sr.getScaledWidth() / 2 + 50), (sr.getScaledHeight() / 2 + 180), 16.0F, 1.0F, 100, (new Color(20, 20, 20)).getRGB());
/*     */     
/* 121 */     NewRoundedRect.drawBorderedRoundedRect((sr.getScaledWidth() / 2 - 351), (sr.getScaledHeight() / 2 - 117), (sr.getScaledWidth() / 2 - 279), (sr.getScaledHeight() / 2 + 151), 10.0F, 1.0F, 100, (new Color(100, 100, 100, 80)).getRGB());
/* 122 */     NewRoundedRect.drawBorderedRoundedRect((sr.getScaledWidth() / 2 - 350), (sr.getScaledHeight() / 2 - 116), (sr.getScaledWidth() / 2 - 280), (sr.getScaledHeight() / 2 + 150), 10.0F, 1.0F, 100, (new Color(20, 20, 20)).getRGB());
/*     */     
/* 124 */     NewRoundedRect.drawBorderedRoundedRect((sr.getScaledWidth() / 2 - 251), (sr.getScaledHeight() / 2 - 117), (sr.getScaledWidth() / 2 + 266), (sr.getScaledHeight() / 2 + 151), 10.0F, 1.0F, 100, (new Color(100, 100, 100, 80)).getRGB());
/* 125 */     NewRoundedRect.drawBorderedRoundedRect((sr.getScaledWidth() / 2 - 250), (sr.getScaledHeight() / 2 - 116), (sr.getScaledWidth() / 2 + 265), (sr.getScaledHeight() / 2 + 150), 10.0F, 1.0F, 100, (new Color(20, 20, 20)).getRGB());
/*     */     
/* 127 */     GlStateManager.color(1.0F, 1.0F, 51.0F);
/* 128 */     mc.getTextureManager().bindTexture(new ResourceLocation("zyrex_logo.png"));
/* 129 */     Gui.drawModalRectWithCustomSizedTexture(width / 2 - 340, height / 2 - 115, 0.0F, 0.0F, 50, 50, 50.0F, 50.0F);
/*     */     
/* 131 */     FontUtil.renderCenteredString("Modules", width / 2 + 7, height / 2 - 139, (new Color(255, 255, 255)).getRGB(), 1.0F);
/*     */     
/* 133 */     FontUtil.renderCenteredString("Page 2/2", width / 2 + 7, height / 2 + 161, (new Color(255, 255, 255)).getRGB(), 1.0F);
/*     */     
/* 135 */     FontUtil.renderCenteredString("Zyrex Client", width / 2 - 315, height / 2 + 132, (new Color(100, 100, 100)).getRGB(), 1.0F);
/*     */     
/* 137 */     super.drawScreen(mouseX, mouseY, partialTicks);
/*     */   }
/*     */ 
/*     */   
/*     */   public void drawPlayerHead(int x, int y, int width) {
/* 142 */     GlStateManager.pushMatrix();
/* 143 */     float scale = (width / 32);
/* 144 */     GlStateManager.scale(scale, scale, scale);
/* 145 */     mc.getTextureManager().bindTexture(Minecraft.thePlayer.getLocationSkin());
/* 146 */     GL11.glEnable(3042);
/* 147 */     drawTexturedModalRect(x / scale, y / scale, 32, 32, 32, 32);
/* 148 */     GL11.glDisable(3042);
/* 149 */     GlStateManager.popMatrix();
/*     */   }
/*     */ 
/*     */   
/*     */   public void actionPerformed(GuiButton button) throws IOException {
/* 154 */     if (button.id == 90) {
/* 155 */       mc.displayGuiScreen(new ModHud5_Settings());
/*     */     }
/*     */     
/* 158 */     if (button.id == 60) {
/* 159 */       mc.displayGuiScreen(new CPSSettings());
/*     */     }
/*     */     
/* 162 */     if (button.id == 61) {
/* 163 */       mc.displayGuiScreen(new FPSSettings());
/*     */     }
/*     */     
/* 166 */     if (button.id == 62) {
/* 167 */       mc.displayGuiScreen(new PingSettings());
/*     */     }
/*     */     
/* 170 */     if (button.id == 63) {
/* 171 */       mc.displayGuiScreen(new KeystrokesSettings());
/*     */     }
/*     */     
/* 174 */     if (button.id == 64) {
/* 175 */       mc.displayGuiScreen(new ArmorStatusSettings());
/*     */     }
/*     */     
/* 178 */     if (button.id == 65) {
/* 179 */       mc.displayGuiScreen(new PotionStatusSettings());
/*     */     }
/*     */     
/* 182 */     if (button.id == 66) {
/* 183 */       mc.displayGuiScreen(new CoordinatesSettings());
/*     */     }
/*     */     
/* 186 */     if (button.id == 67) {
/* 187 */       mc.displayGuiScreen(new MotionBlurSettings());
/*     */     }
/*     */     
/* 190 */     if (button.id == 68) {
/* 191 */       mc.displayGuiScreen(new ChatSettings());
/*     */     }
/*     */     
/* 194 */     if (button.id == 50) {
/* 195 */       mc.displayGuiScreen(new ModHud5());
/*     */     }
/*     */     
/* 198 */     if (button.id == 101) {
/* 199 */       mc.displayGuiScreen(new CosmeticsHud3());
/*     */     }
/*     */     
/* 202 */     if (button.id == 1) {
/* 203 */       ModToggleButton.save("NameTag", Boolean.valueOf(!ModToggleButton.load("NameTag").booleanValue()));
/* 204 */       if (!ModToggle.loadEnabledFromFile("Mods/ZyrexModNameTag/ModNameTag").booleanValue()) {
/* 205 */         Client.Nametag = !Client.Nametag;
/* 206 */         ModToggle.saveIsEnabledToFile("Mods/ZyrexModNameTag/ModNameTag", Boolean.valueOf(Client.Nametag));
/*     */       } else {
/* 208 */         Client.Nametag = !Client.Nametag;
/* 209 */         ModToggle.saveIsEnabledToFile("Mods/ZyrexModNameTag/ModNameTag", Boolean.valueOf(Client.Nametag));
/*     */       } 
/*     */     } 
/*     */     
/* 213 */     if (button.id == 2) {
/* 214 */       ModToggleButton.save("Custom Chat", Boolean.valueOf(!ModToggleButton.load("Custom Chat").booleanValue()));
/* 215 */       if (!ModToggle.loadEnabledFromFile("Mods/ZyrexModCustomChat/ModCustomChat").booleanValue()) {
/* 216 */         Client.CustomChat = !Client.CustomChat;
/* 217 */         ModToggle.saveIsEnabledToFile("Mods/ZyrexModCustomChat/ModCustomChat", Boolean.valueOf(Client.CustomChat));
/*     */       } else {
/* 219 */         Client.CustomChat = !Client.CustomChat;
/* 220 */         ModToggle.saveIsEnabledToFile("Mods/ZyrexModCustomChat/ModCustomChat", Boolean.valueOf(Client.CustomChat));
/*     */       } 
/*     */     } 
/*     */     
/* 224 */     if (button.id == 3) {
/* 225 */       ModToggleButton.save("Direction", Boolean.valueOf(!ModToggleButton.load("Direction").booleanValue()));
/* 226 */       if (ModToggle.loadEnabledFromFile("Mods/ZyrexModCustomChat/ModDirection").booleanValue()) {
/* 227 */         Client.ModDirection = !Client.ModDirection;
/* 228 */         ModToggle.saveIsEnabledToFile("Mods/ZyrexModCustomChat/ModDirection", Boolean.valueOf(Client.ModDirection));
/*     */       } else {
/* 230 */         Client.ModDirection = !Client.ModDirection;
/* 231 */         ModToggle.saveIsEnabledToFile("Mods/ZyrexModCustomChat/ModDirection", Boolean.valueOf(Client.ModDirection));
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Lenovo\Downloads\ZyrexClientV1 (1).jar!\ZyrexClient\ModHuds\ModHud5_Page2.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */