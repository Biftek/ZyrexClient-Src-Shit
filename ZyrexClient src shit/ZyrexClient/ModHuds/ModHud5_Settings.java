/*     */ package ZyrexClient.ModHuds;
/*     */ 
/*     */ import ZyrexClient.Client;
/*     */ import ZyrexClient.Gui.UnicodeFontRenderer;
/*     */ import ZyrexClient.ModToggle.ModToggle;
/*     */ import ZyrexClient.NewRoundedRect;
/*     */ import ZyrexClient.clickgui.FontUtil;
/*     */ import ZyrexClient.clickgui.RoundedButtons.ButtonMainMenuZ;
/*     */ import ZyrexClient.clickgui.ScrollListModToggle;
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
/*     */ 
/*     */ public class ModHud5_Settings
/*     */   extends GuiScreen
/*     */ {
/*     */   public static UnicodeFontRenderer ufr;
/*  64 */   public static ZyrexModFPS modFPS = new ZyrexModFPS();
/*     */   
/*     */   private ScrollListModToggle scrollPanel;
/*     */ 
/*     */   
/*     */   public void initGui() {
/*  70 */     int i = 24;
/*  71 */     int j = height / 4 + 48;
/*     */     
/*  73 */     ScaledResolution sr = new ScaledResolution(mc);
/*     */ 
/*     */     
/*  76 */     buttonList.add(new ButtonMainMenuZ(50, width / 2 - 350, height / 2 - 20, 70, 12, I18n.format("Modules", new Object[0])));
/*  77 */     buttonList.add(new ButtonMainMenuZ(101, width / 2 - 350, height / 2 - 5, 70, 12, I18n.format("Cosmetics", new Object[0])));
/*  78 */     buttonList.add(new ButtonMainMenuZ(1, width / 2 - 350, height / 2 + 110, 70, 12, I18n.format("§8Settings", new Object[0])));
/*     */     
/*  80 */     buttonList.add(new ModCheckButton(1, width / 2 - 230, height / 2 - 80, 16, 16, I18n.format("Inventory Blur", new Object[0])));
/*  81 */     buttonList.add(new ModCheckButton(3, width / 2 - 230, height / 2 - 60, 16, 16, I18n.format("Cleaner Buttons", new Object[0])));
/*     */ 
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
/*     */     
/* 106 */     drawDefaultBackground();
/*     */ 
/*     */     
/* 109 */     NewRoundedRect.drawBorderedRoundedRect((sr.getScaledWidth() / 2 - 251), (sr.getScaledHeight() / 2 - 146), (sr.getScaledWidth() / 2 + 268), (sr.getScaledHeight() / 2 - 119), 16.0F, 1.0F, 100, (new Color(100, 100, 100, 80)).getRGB());
/* 110 */     NewRoundedRect.drawBorderedRoundedRect((sr.getScaledWidth() / 2 - 250), (sr.getScaledHeight() / 2 - 145), (sr.getScaledWidth() / 2 + 267), (sr.getScaledHeight() / 2 - 120), 15.0F, 1.0F, 100, (new Color(20, 20, 20)).getRGB());
/*     */ 
/*     */     
/* 113 */     NewRoundedRect.drawBorderedRoundedRect((sr.getScaledWidth() / 2 - 351), (sr.getScaledHeight() / 2 - 117), (sr.getScaledWidth() / 2 - 279), (sr.getScaledHeight() / 2 + 151), 10.0F, 1.0F, 100, (new Color(100, 100, 100, 80)).getRGB());
/* 114 */     NewRoundedRect.drawBorderedRoundedRect((sr.getScaledWidth() / 2 - 350), (sr.getScaledHeight() / 2 - 116), (sr.getScaledWidth() / 2 - 280), (sr.getScaledHeight() / 2 + 150), 10.0F, 1.0F, 100, (new Color(20, 20, 20)).getRGB());
/*     */     
/* 116 */     NewRoundedRect.drawBorderedRoundedRect((sr.getScaledWidth() / 2 - 251), (sr.getScaledHeight() / 2 - 117), (sr.getScaledWidth() / 2 + 266), (sr.getScaledHeight() / 2 + 151), 10.0F, 1.0F, 100, (new Color(100, 100, 100, 80)).getRGB());
/* 117 */     NewRoundedRect.drawBorderedRoundedRect((sr.getScaledWidth() / 2 - 250), (sr.getScaledHeight() / 2 - 116), (sr.getScaledWidth() / 2 + 265), (sr.getScaledHeight() / 2 + 150), 10.0F, 1.0F, 100, (new Color(20, 20, 20)).getRGB());
/*     */     
/* 119 */     GlStateManager.color(1.0F, 1.0F, 51.0F);
/* 120 */     mc.getTextureManager().bindTexture(new ResourceLocation("zyrex_logo.png"));
/* 121 */     Gui.drawModalRectWithCustomSizedTexture(width / 2 - 340, height / 2 - 115, 0.0F, 0.0F, 50, 50, 50.0F, 50.0F);
/*     */     
/* 123 */     FontUtil.renderCenteredString("Settings", width / 2 + 7, height / 2 - 139, (new Color(255, 255, 255)).getRGB(), 1.0F);
/*     */     
/* 125 */     FontUtil.renderCenteredString("GUI Options", width / 2 - 215, height / 2 - 97, (new Color(100, 100, 100)).getRGB(), 1.0F);
/*     */     
/* 127 */     FontUtil.renderCenteredString("Zyrex Client", width / 2 - 315, height / 2 + 132, (new Color(100, 100, 100)).getRGB(), 1.0F);
/*     */     
/* 129 */     super.drawScreen(mouseX, mouseY, partialTicks);
/*     */   }
/*     */ 
/*     */   
/*     */   public void drawPlayerHead(int x, int y, int width) {
/* 134 */     GlStateManager.pushMatrix();
/* 135 */     float scale = (width / 32);
/* 136 */     GlStateManager.scale(scale, scale, scale);
/* 137 */     mc.getTextureManager().bindTexture(Minecraft.thePlayer.getLocationSkin());
/* 138 */     GL11.glEnable(3042);
/* 139 */     drawTexturedModalRect(x / scale, y / scale, 32, 32, 32, 32);
/* 140 */     GL11.glDisable(3042);
/* 141 */     GlStateManager.popMatrix();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void actionPerformed(GuiButton button) throws IOException {
/* 147 */     if (button.id == 60) {
/* 148 */       mc.displayGuiScreen(new CPSSettings());
/*     */     }
/*     */     
/* 151 */     if (button.id == 50) {
/* 152 */       mc.displayGuiScreen(new ModHud5());
/*     */     }
/*     */     
/* 155 */     if (button.id == 101) {
/* 156 */       mc.displayGuiScreen(new CosmeticsHud3());
/*     */     }
/*     */     
/* 159 */     if (button.id == 1) {
/* 160 */       SettingsButtonToggle.save("Inventory Blur", Boolean.valueOf(!SettingsButtonToggle.load("Inventory Blur").booleanValue()));
/* 161 */       if (ModToggle.loadEnabledFromFile("Mods/ZyrexModInventoryBlur/Blur").booleanValue()) {
/* 162 */         Client.InventoryBlur = !Client.InventoryBlur;
/* 163 */         ModToggle.saveIsEnabledToFile("Mods/ZyrexModInventoryBlur/Blur", Boolean.valueOf(Client.InventoryBlur));
/*     */       } else {
/* 165 */         Client.InventoryBlur = !Client.InventoryBlur;
/* 166 */         ModToggle.saveIsEnabledToFile("Mods/ZyrexModInventoryBlur/Blur", Boolean.valueOf(Client.InventoryBlur));
/*     */       } 
/*     */     } 
/*     */     
/* 170 */     if (button.id == 2) {
/* 171 */       SettingsButtonToggle.save("Red String", Boolean.valueOf(!SettingsButtonToggle.load("Red String").booleanValue()));
/* 172 */       if (ModToggle.loadEnabledFromFile("Mods/ZyrexModInventoryBlur/Blur").booleanValue()) {
/* 173 */         Client.InventoryBlur = !Client.InventoryBlur;
/* 174 */         ModToggle.saveIsEnabledToFile("Mods/ZyrexModInventoryBlur/Blur", Boolean.valueOf(Client.InventoryBlur));
/*     */       } else {
/* 176 */         Client.InventoryBlur = !Client.InventoryBlur;
/* 177 */         ModToggle.saveIsEnabledToFile("Mods/ZyrexModInventoryBlur/Blur", Boolean.valueOf(Client.InventoryBlur));
/*     */       } 
/*     */     } 
/*     */     
/* 181 */     if (button.id == 3) {
/* 182 */       SettingsButtonToggle.save("Cleaner Buttons", Boolean.valueOf(!SettingsButtonToggle.load("Cleaner Buttons").booleanValue()));
/* 183 */       if (ModToggle.loadEnabledFromFile("Buttons/CleanButton/isEnabled").booleanValue()) {
/* 184 */         Client.CleanButtons = !Client.CleanButtons;
/* 185 */         ModToggle.saveIsEnabledToFile("Buttons/CleanButton/isEnabled", Boolean.valueOf(Client.CleanButtons));
/*     */       } else {
/* 187 */         Client.CleanButtons = !Client.CleanButtons;
/* 188 */         ModToggle.saveIsEnabledToFile("Buttons/CleanButton/isEnabled", Boolean.valueOf(Client.CleanButtons));
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Lenovo\Downloads\ZyrexClientV1 (1).jar!\ZyrexClient\ModHuds\ModHud5_Settings.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */