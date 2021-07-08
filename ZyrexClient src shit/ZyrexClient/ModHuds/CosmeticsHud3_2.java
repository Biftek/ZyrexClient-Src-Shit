/*     */ package ZyrexClient.ModHuds;
/*     */ 
/*     */ import ZyrexClient.Client;
/*     */ import ZyrexClient.Gui.UnicodeFontRenderer;
/*     */ import ZyrexClient.ModToggle.ModToggle;
/*     */ import ZyrexClient.NewRoundedRect;
/*     */ import ZyrexClient.clickgui.FontUtil;
/*     */ import ZyrexClient.clickgui.RoundedButtons.ButtonCosmetics;
/*     */ import ZyrexClient.clickgui.RoundedButtons.ButtonMainMenuZ;
/*     */ import ZyrexClient.clickgui.ScrollListModToggle;
/*     */ import ZyrexClient.clickguitest.RenderPlayerOnScreen;
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
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.util.ResourceLocation;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ public class CosmeticsHud3_2
/*     */   extends GuiScreen
/*     */ {
/*     */   public static UnicodeFontRenderer ufr;
/*  69 */   public static ZyrexModFPS modFPS = new ZyrexModFPS();
/*     */   
/*     */   private ScrollListModToggle scrollPanel;
/*     */ 
/*     */   
/*     */   public void initGui() {
/*  75 */     int i = 24;
/*  76 */     int j = height / 4 + 48;
/*     */     
/*  78 */     ScaledResolution sr = new ScaledResolution(mc);
/*     */     
/*  80 */     buttonList.add(new ButtonMainMenuZ(50, width / 2 - 350, height / 2 - 20, 70, 12, I18n.format("Modules", new Object[0])));
/*  81 */     buttonList.add(new ButtonMainMenuZ(0, width / 2 - 350, height / 2 - 5, 70, 12, I18n.format("§8Cosmetics", new Object[0])));
/*  82 */     buttonList.add(new ButtonMainMenuZ(90, width / 2 - 350, height / 2 + 110, 70, 12, I18n.format("Settings", new Object[0])));
/*     */     
/*  84 */     buttonList.add(new ButtonMainMenuZ(60, width / 2 - 260, height / 2 - 20, 140, 12, I18n.format("Capes", new Object[0])));
/*  85 */     buttonList.add(new ButtonMainMenuZ(0, width / 2 - 260, height / 2 - 5, 140, 12, I18n.format("§8Dragon Wings", new Object[0])));
/*  86 */     buttonList.add(new ButtonMainMenuZ(80, width / 2 - 260, height / 2 + 10, 140, 12, I18n.format("Head Wears", new Object[0])));
/*     */     
/*  88 */     buttonList.add(new ButtonCosmetics(1, width / 2 - 95, height / 2 - 60, 208, 20, "Default Wings"));
/*  89 */     buttonList.add(new ButtonCosmetics(2, width / 2 - 95, height / 2 - 10, 208, 20, "Red Wings"));
/*  90 */     buttonList.add(new ButtonCosmetics(3, width / 2 - 95, height / 2 - 35, 208, 20, "Black Wings"));
/*     */     
/*  92 */     drawDefaultBackground();
/*     */   }
/*     */ 
/*     */   
/*     */   public void onGuiClosed() {
/*  97 */     (Minecraft.getMinecraft()).entityRenderer.loadEntityShader(null);
/*  98 */     super.onGuiClosed();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void drawScreen(int mouseX, int mouseY, float partialTicks) {
/* 106 */     Minecraft.getMinecraft().getTextureManager().bindTexture(new ResourceLocation("Logo/Zyrex_Logo.png"));
/*     */     
/* 108 */     ScaledResolution sr = new ScaledResolution(mc);
/*     */     
/* 110 */     drawDefaultBackground();
/*     */     
/* 112 */     RenderPlayerOnScreen.drawEntityOnScreen(sr.getScaledWidth() / 2 + 205, sr.getScaledHeight() / 2 + 90, 80, 195.0F, (EntityLivingBase)Minecraft.thePlayer);
/*     */ 
/*     */     
/* 115 */     NewRoundedRect.drawBorderedRoundedRect((sr.getScaledWidth() / 2 - 251), (sr.getScaledHeight() / 2 - 146), (sr.getScaledWidth() / 2 + 268), (sr.getScaledHeight() / 2 - 119), 16.0F, 1.0F, 100, (new Color(100, 100, 100, 80)).getRGB());
/* 116 */     NewRoundedRect.drawBorderedRoundedRect((sr.getScaledWidth() / 2 - 250), (sr.getScaledHeight() / 2 - 145), (sr.getScaledWidth() / 2 + 267), (sr.getScaledHeight() / 2 - 120), 15.0F, 1.0F, 100, (new Color(20, 20, 20)).getRGB());
/*     */ 
/*     */     
/* 119 */     NewRoundedRect.drawBorderedRoundedRect((sr.getScaledWidth() / 2 - 351), (sr.getScaledHeight() / 2 - 117), (sr.getScaledWidth() / 2 - 279), (sr.getScaledHeight() / 2 + 151), 10.0F, 1.0F, 100, (new Color(100, 100, 100, 80)).getRGB());
/* 120 */     NewRoundedRect.drawBorderedRoundedRect((sr.getScaledWidth() / 2 - 350), (sr.getScaledHeight() / 2 - 116), (sr.getScaledWidth() / 2 - 280), (sr.getScaledHeight() / 2 + 150), 10.0F, 1.0F, 100, (new Color(20, 20, 20)).getRGB());
/*     */     
/* 122 */     NewRoundedRect.drawBorderedRoundedRect((sr.getScaledWidth() / 2 + 140), (sr.getScaledHeight() / 2 - 117), (sr.getScaledWidth() / 2 + 266), (sr.getScaledHeight() / 2 + 151), 10.0F, 1.0F, 100, (new Color(100, 100, 100, 80)).getRGB());
/* 123 */     NewRoundedRect.drawBorderedRoundedRect((sr.getScaledWidth() / 2 + 141), (sr.getScaledHeight() / 2 - 116), (sr.getScaledWidth() / 2 + 265), (sr.getScaledHeight() / 2 + 150), 10.0F, 1.0F, 100, (new Color(20, 20, 20)).getRGB());
/*     */     
/* 125 */     NewRoundedRect.drawBorderedRoundedRect((sr.getScaledWidth() / 2 - 251), (sr.getScaledHeight() / 2 - 117), (sr.getScaledWidth() / 2 - 123), (sr.getScaledHeight() / 2 + 151), 10.0F, 1.0F, 100, (new Color(100, 100, 100, 80)).getRGB());
/*     */     
/* 127 */     NewRoundedRect.drawBorderedRoundedRect((sr.getScaledWidth() / 2 - 250), (sr.getScaledHeight() / 2 - 116), (sr.getScaledWidth() / 2 - 124), (sr.getScaledHeight() / 2 + 150), 10.0F, 1.0F, 100, (new Color(20, 20, 20)).getRGB());
/*     */     
/* 129 */     NewRoundedRect.drawBorderedRoundedRect((sr.getScaledWidth() / 2 - 121), (sr.getScaledHeight() / 2 - 117), (sr.getScaledWidth() / 2 + 136), (sr.getScaledHeight() / 2 + 151), 10.0F, 1.0F, 100, (new Color(100, 100, 100, 80)).getRGB());
/* 130 */     NewRoundedRect.drawBorderedRoundedRect((sr.getScaledWidth() / 2 - 120), (sr.getScaledHeight() / 2 - 116), (sr.getScaledWidth() / 2 + 135), (sr.getScaledHeight() / 2 + 150), 10.0F, 1.0F, 100, (new Color(20, 20, 20)).getRGB());
/*     */ 
/*     */     
/* 133 */     GlStateManager.color(1.0F, 1.0F, 51.0F);
/* 134 */     mc.getTextureManager().bindTexture(new ResourceLocation("zyrex_logo.png"));
/* 135 */     Gui.drawModalRectWithCustomSizedTexture(width / 2 - 340, height / 2 - 115, 0.0F, 0.0F, 50, 50, 50.0F, 50.0F);
/*     */     
/* 137 */     FontUtil.renderCenteredString("Cosmetics", width / 2 + 7, height / 2 - 139, (new Color(255, 255, 255)).getRGB(), 1.0F);
/*     */     
/* 139 */     FontUtil.renderCenteredString("Category", width / 2 - 188, height / 2 - 109, (new Color(255, 255, 255)).getRGB(), 1.0F);
/*     */     
/* 141 */     FontUtil.renderCenteredString("Zyrex Client", width / 2 - 315, height / 2 + 132, (new Color(100, 100, 100)).getRGB(), 1.0F);
/*     */     
/* 143 */     FontUtil.renderCenteredString("Preview", width / 2 + 205, height / 2 - 100, -1, 1.0F);
/*     */ 
/*     */     
/* 146 */     FontUtil.renderCenteredString("_________________", width / 2 + 8, height / 2 - 105, -1, 1.0F);
/* 147 */     FontUtil.renderCenteredString("Avaliable Wings", width / 2 + 8, height / 2 - 107, -1, 1.0F);
/*     */     
/* 149 */     super.drawScreen(mouseX, mouseY, partialTicks);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void actionPerformed(GuiButton button) throws IOException {
/* 156 */     if (button.id == 90) {
/* 157 */       mc.displayGuiScreen(new ModHud5_Settings());
/*     */     }
/*     */     
/* 160 */     if (button.id == 50) {
/* 161 */       mc.displayGuiScreen(new ModHud5());
/*     */     }
/*     */     
/* 164 */     if (button.id == 60) {
/* 165 */       mc.displayGuiScreen(new CosmeticsHud3());
/*     */     }
/*     */     
/* 168 */     if (button.id == 80) {
/* 169 */       mc.displayGuiScreen(new CosmeticsHud3_3());
/*     */     }
/*     */     
/* 172 */     if (button.id == 1) {
/* 173 */       ButtonCosmetics.save("Default Wings", Boolean.valueOf(!ButtonCosmetics.load("Default Wings").booleanValue()));
/* 174 */       if (!ModToggle.loadEnabledFromFile("Cosmetics/Wings/DefaultWings").booleanValue()) {
/* 175 */         Client.CosmeticWings = !Client.CosmeticWings;
/* 176 */         ModToggle.saveIsEnabledToFile("Cosmetics/Wings/DefaultWings", Boolean.valueOf(Client.CosmeticWings));
/*     */       } else {
/* 178 */         Client.CosmeticWings = !Client.CosmeticWings;
/* 179 */         ModToggle.saveIsEnabledToFile("Cosmetics/Wings/DefaultWings", Boolean.valueOf(Client.CosmeticWings));
/*     */       } 
/*     */     } 
/* 182 */     if (button.id == 2) {
/* 183 */       ButtonCosmetics.save("Red Wings", Boolean.valueOf(!ButtonCosmetics.load("Red Wings").booleanValue()));
/* 184 */       if (!ModToggle.loadEnabledFromFile("Cosmetics/Wings/RedWings").booleanValue()) {
/* 185 */         Client.CosmeticWingsRed = !Client.CosmeticWingsRed;
/* 186 */         ModToggle.saveIsEnabledToFile("Cosmetics/Wings/RedWings", Boolean.valueOf(Client.CosmeticWingsRed));
/*     */       } else {
/* 188 */         Client.CosmeticWingsRed = !Client.CosmeticWingsRed;
/* 189 */         ModToggle.saveIsEnabledToFile("Cosmetics/Wings/RedWings", Boolean.valueOf(Client.CosmeticWingsRed));
/*     */       } 
/*     */     } 
/* 192 */     if (button.id == 3) {
/* 193 */       ButtonCosmetics.save("Black Wings", Boolean.valueOf(!ButtonCosmetics.load("Black Wings").booleanValue()));
/* 194 */       if (!ModToggle.loadEnabledFromFile("Cosmetics/Wings/BlackWings").booleanValue()) {
/* 195 */         Client.CosmeticWingsBlack = !Client.CosmeticWingsBlack;
/* 196 */         ModToggle.saveIsEnabledToFile("Cosmetics/Wings/BlackWings", Boolean.valueOf(Client.CosmeticWingsBlack));
/*     */       } else {
/* 198 */         Client.CosmeticWingsBlack = !Client.CosmeticWingsBlack;
/* 199 */         ModToggle.saveIsEnabledToFile("Cosmetics/Wings/BlackWings", Boolean.valueOf(Client.CosmeticWingsBlack));
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Lenovo\Downloads\ZyrexClientV1 (1).jar!\ZyrexClient\ModHuds\CosmeticsHud3_2.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */