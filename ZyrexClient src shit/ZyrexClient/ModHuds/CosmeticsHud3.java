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
/*     */ public class CosmeticsHud3
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
/*  84 */     buttonList.add(new ButtonMainMenuZ(0, width / 2 - 260, height / 2 - 20, 140, 12, I18n.format("§8Capes", new Object[0])));
/*  85 */     buttonList.add(new ButtonMainMenuZ(70, width / 2 - 260, height / 2 - 5, 140, 12, I18n.format("Dragon Wings", new Object[0])));
/*  86 */     buttonList.add(new ButtonMainMenuZ(80, width / 2 - 260, height / 2 + 10, 140, 12, I18n.format("Head Wears", new Object[0])));
/*     */     
/*  88 */     buttonList.add(new ButtonCosmetics(1, width / 2 - 95, height / 2 - 60, 208, 20, "White Cape"));
/*  89 */     buttonList.add(new ButtonCosmetics(2, width / 2 - 95, height / 2 - 35, 208, 20, "Black Cape"));
/*  90 */     buttonList.add(new ButtonCosmetics(3, width / 2 - 95, height / 2 + 15, 208, 20, "Purple Cape"));
/*  91 */     buttonList.add(new ButtonCosmetics(4, width / 2 - 95, height / 2 - 10, 208, 20, "Blue Cape"));
/*  92 */     buttonList.add(new ButtonCosmetics(5, width / 2 - 95, height / 2 + 65, 208, 20, "Stripped Cyan Cape"));
/*     */     
/*  94 */     drawDefaultBackground();
/*     */   }
/*     */ 
/*     */   
/*     */   public void onGuiClosed() {
/*  99 */     (Minecraft.getMinecraft()).entityRenderer.loadEntityShader(null);
/* 100 */     super.onGuiClosed();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void drawScreen(int mouseX, int mouseY, float partialTicks) {
/* 108 */     Minecraft.getMinecraft().getTextureManager().bindTexture(new ResourceLocation("zyrex_logo.png"));
/*     */     
/* 110 */     ScaledResolution sr = new ScaledResolution(mc);
/*     */     
/* 112 */     drawDefaultBackground();
/*     */     
/* 114 */     RenderPlayerOnScreen.drawEntityOnScreen(sr.getScaledWidth() / 2 + 205, sr.getScaledHeight() / 2 + 90, 80, 195.0F, (EntityLivingBase)Minecraft.thePlayer);
/*     */ 
/*     */     
/* 117 */     NewRoundedRect.drawBorderedRoundedRect((sr.getScaledWidth() / 2 - 251), (sr.getScaledHeight() / 2 - 146), (sr.getScaledWidth() / 2 + 268), (sr.getScaledHeight() / 2 - 119), 16.0F, 1.0F, 100, (new Color(100, 100, 100, 80)).getRGB());
/* 118 */     NewRoundedRect.drawBorderedRoundedRect((sr.getScaledWidth() / 2 - 250), (sr.getScaledHeight() / 2 - 145), (sr.getScaledWidth() / 2 + 267), (sr.getScaledHeight() / 2 - 120), 15.0F, 1.0F, 100, (new Color(20, 20, 20)).getRGB());
/*     */ 
/*     */     
/* 121 */     NewRoundedRect.drawBorderedRoundedRect((sr.getScaledWidth() / 2 - 351), (sr.getScaledHeight() / 2 - 117), (sr.getScaledWidth() / 2 - 279), (sr.getScaledHeight() / 2 + 151), 10.0F, 1.0F, 100, (new Color(100, 100, 100, 80)).getRGB());
/* 122 */     NewRoundedRect.drawBorderedRoundedRect((sr.getScaledWidth() / 2 - 350), (sr.getScaledHeight() / 2 - 116), (sr.getScaledWidth() / 2 - 280), (sr.getScaledHeight() / 2 + 150), 10.0F, 1.0F, 100, (new Color(20, 20, 20)).getRGB());
/*     */     
/* 124 */     NewRoundedRect.drawBorderedRoundedRect((sr.getScaledWidth() / 2 + 140), (sr.getScaledHeight() / 2 - 117), (sr.getScaledWidth() / 2 + 266), (sr.getScaledHeight() / 2 + 151), 10.0F, 1.0F, 100, (new Color(100, 100, 100, 80)).getRGB());
/* 125 */     NewRoundedRect.drawBorderedRoundedRect((sr.getScaledWidth() / 2 + 141), (sr.getScaledHeight() / 2 - 116), (sr.getScaledWidth() / 2 + 265), (sr.getScaledHeight() / 2 + 150), 10.0F, 1.0F, 100, (new Color(20, 20, 20)).getRGB());
/*     */     
/* 127 */     NewRoundedRect.drawBorderedRoundedRect((sr.getScaledWidth() / 2 - 251), (sr.getScaledHeight() / 2 - 117), (sr.getScaledWidth() / 2 - 123), (sr.getScaledHeight() / 2 + 151), 10.0F, 1.0F, 100, (new Color(100, 100, 100, 80)).getRGB());
/*     */     
/* 129 */     NewRoundedRect.drawBorderedRoundedRect((sr.getScaledWidth() / 2 - 250), (sr.getScaledHeight() / 2 - 116), (sr.getScaledWidth() / 2 - 124), (sr.getScaledHeight() / 2 + 150), 10.0F, 1.0F, 100, (new Color(20, 20, 20)).getRGB());
/*     */     
/* 131 */     NewRoundedRect.drawBorderedRoundedRect((sr.getScaledWidth() / 2 - 121), (sr.getScaledHeight() / 2 - 117), (sr.getScaledWidth() / 2 + 136), (sr.getScaledHeight() / 2 + 151), 10.0F, 1.0F, 100, (new Color(100, 100, 100, 80)).getRGB());
/* 132 */     NewRoundedRect.drawBorderedRoundedRect((sr.getScaledWidth() / 2 - 120), (sr.getScaledHeight() / 2 - 116), (sr.getScaledWidth() / 2 + 135), (sr.getScaledHeight() / 2 + 150), 10.0F, 1.0F, 100, (new Color(20, 20, 20)).getRGB());
/*     */     
/* 134 */     GlStateManager.color(1.0F, 1.0F, 51.0F);
/* 135 */     mc.getTextureManager().bindTexture(new ResourceLocation("zyrex_logo.png"));
/* 136 */     Gui.drawModalRectWithCustomSizedTexture(width / 2 - 340, height / 2 - 115, 0.0F, 0.0F, 50, 50, 50.0F, 50.0F);
/*     */     
/* 138 */     FontUtil.renderCenteredString("Cosmetics", width / 2 + 7, height / 2 - 139, (new Color(255, 255, 255)).getRGB(), 1.0F);
/*     */     
/* 140 */     FontUtil.renderCenteredString("Category", width / 2 - 188, height / 2 - 109, (new Color(255, 255, 255)).getRGB(), 1.0F);
/*     */     
/* 142 */     FontUtil.renderCenteredString("Zyrex Client", width / 2 - 315, height / 2 + 132, (new Color(100, 100, 100)).getRGB(), 1.0F);
/*     */     
/* 144 */     FontUtil.renderCenteredString("Preview", width / 2 + 205, height / 2 - 100, -1, 1.0F);
/*     */ 
/*     */     
/* 147 */     FontUtil.renderCenteredString("_________________", width / 2 + 8, height / 2 - 105, -1, 1.0F);
/* 148 */     FontUtil.renderCenteredString("Avaliable Capes", width / 2 + 8, height / 2 - 107, -1, 1.0F);
/*     */     
/* 150 */     super.drawScreen(mouseX, mouseY, partialTicks);
/*     */   }
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
/* 164 */     if (button.id == 70) {
/* 165 */       mc.displayGuiScreen(new CosmeticsHud3_2());
/*     */     }
/*     */     
/* 168 */     if (button.id == 80) {
/* 169 */       mc.displayGuiScreen(new CosmeticsHud3_3());
/*     */     }
/*     */ 
/*     */     
/* 173 */     if (button.id == 1) {
/* 174 */       ButtonCosmetics.save("White Cape", Boolean.valueOf(!ButtonCosmetics.load("White Cape").booleanValue()));
/* 175 */       if (!ModToggle.loadEnabledFromFile("Cosmetics/Capes/WhiteCape").booleanValue()) {
/* 176 */         Client.WhiteCape = !Client.WhiteCape;
/* 177 */         ModToggle.saveIsEnabledToFile("Cosmetics/Capes/WhiteCape", Boolean.valueOf(Client.WhiteCape));
/*     */       } else {
/* 179 */         Client.WhiteCape = !Client.WhiteCape;
/* 180 */         ModToggle.saveIsEnabledToFile("Cosmetics/Capes/WhiteCape", Boolean.valueOf(Client.WhiteCape));
/*     */       } 
/*     */     } 
/*     */     
/* 184 */     if (button.id == 2) {
/* 185 */       ButtonCosmetics.save("Black Cape", Boolean.valueOf(!ButtonCosmetics.load("Black Cape").booleanValue()));
/* 186 */       if (!ModToggle.loadEnabledFromFile("Cosmetics/Capes/BlackCape").booleanValue()) {
/* 187 */         Client.BlackCape = !Client.BlackCape;
/* 188 */         ModToggle.saveIsEnabledToFile("Cosmetics/Capes/BlackCape", Boolean.valueOf(Client.BlackCape));
/*     */       } else {
/* 190 */         Client.BlackCape = !Client.BlackCape;
/* 191 */         ModToggle.saveIsEnabledToFile("Cosmetics/Capes/BlackCape", Boolean.valueOf(Client.BlackCape));
/*     */       } 
/*     */     } 
/* 194 */     if (button.id == 3) {
/* 195 */       ButtonCosmetics.save("Purple Cape", Boolean.valueOf(!ButtonCosmetics.load("Purple Cape").booleanValue()));
/* 196 */       if (!ModToggle.loadEnabledFromFile("Cosmetics/Capes/PurpleCape").booleanValue()) {
/* 197 */         Client.PurpleCape = !Client.PurpleCape;
/* 198 */         ModToggle.saveIsEnabledToFile("Cosmetics/Capes/PurpleCape", Boolean.valueOf(Client.PurpleCape));
/*     */       } else {
/* 200 */         Client.PurpleCape = !Client.PurpleCape;
/* 201 */         ModToggle.saveIsEnabledToFile("Cosmetics/Capes/PurpleCape", Boolean.valueOf(Client.PurpleCape));
/*     */       } 
/*     */     } 
/* 204 */     if (button.id == 4) {
/* 205 */       ButtonCosmetics.save("Blue Cape", Boolean.valueOf(!ButtonCosmetics.load("Blue Cape").booleanValue()));
/* 206 */       if (!ModToggle.loadEnabledFromFile("Cosmetics/Capes/BlueCape").booleanValue()) {
/* 207 */         Client.BlueCape = !Client.BlueCape;
/* 208 */         ModToggle.saveIsEnabledToFile("Cosmetics/Capes/BlueCape", Boolean.valueOf(Client.PurpleCape));
/*     */       } else {
/* 210 */         Client.BlueCape = !Client.BlueCape;
/* 211 */         ModToggle.saveIsEnabledToFile("Cosmetics/Capes/BlueCape", Boolean.valueOf(Client.PurpleCape));
/*     */       } 
/* 213 */       if (button.id == 5) {
/* 214 */         ButtonCosmetics.save("Cyan Cape", Boolean.valueOf(!ButtonCosmetics.load("Cyan Cape").booleanValue()));
/* 215 */         if (ModToggle.loadEnabledFromFile("Cosmetics/Capes/CyanCape").booleanValue()) {
/* 216 */           Client.CyanCape = !Client.CyanCape;
/* 217 */           ModToggle.saveIsEnabledToFile("Cosmetics/Capes/CyanCape", Boolean.valueOf(Client.CyanCape));
/*     */         } else {
/* 219 */           Client.CyanCape = !Client.CyanCape;
/* 220 */           ModToggle.saveIsEnabledToFile("Cosmetics/Capes/CyanCape", Boolean.valueOf(Client.CyanCape));
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Lenovo\Downloads\ZyrexClientV1 (1).jar!\ZyrexClient\ModHuds\CosmeticsHud3.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */