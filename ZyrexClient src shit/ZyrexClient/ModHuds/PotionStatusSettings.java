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
/*     */ public class PotionStatusSettings
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
/*  81 */     buttonList.add(new SettingsButtonToggle(1, width / 2 - 29, height / 2 - 45, 60, 15, "PotionStatusChroma"));
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
/*  97 */     Minecraft.getMinecraft().getTextureManager().bindTexture(new ResourceLocation("zyrex_logo.png"));
/*     */     
/*  99 */     ScaledResolution sr = new ScaledResolution(mc);
/*     */     
/* 101 */     drawDefaultBackground();
/*     */     
/* 103 */     NewRoundedRect.drawBorderedRoundedRect((sr.getScaledWidth() / 2 - 200), (sr.getScaledHeight() / 2 - 116), (sr.getScaledWidth() / 2 + 205), (sr.getScaledHeight() / 2 + 116), 10.0F, 1.0F, 100, (new Color(17, 18, 19, 200)).getRGB());
/*     */     
/* 105 */     FontUtil.renderCenteredString("Potion Status Settings", width / 2 + 1, height / 2 - 110, (new Color(255, 255, 255)).getRGB(), 1.0F);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 110 */     FontUtil.renderCenteredString("Chroma", width / 2 - 1, height / 2 - 67, (new Color(255, 255, 255)).getRGB(), 1.0F);
/* 111 */     FontUtil.renderCenteredString("[ Rainbow Potion Status ]", width / 2 + 1, height / 2 - 55, (new Color(155, 155, 155)).getRGB(), 0.6F);
/*     */     
/* 113 */     super.drawScreen(mouseX, mouseY, partialTicks);
/*     */   }
/*     */ 
/*     */   
/*     */   public void drawPlayerHead(int x, int y, int width) {
/* 118 */     GlStateManager.pushMatrix();
/* 119 */     float scale = (width / 32);
/* 120 */     GlStateManager.scale(scale, scale, scale);
/* 121 */     mc.getTextureManager().bindTexture(Minecraft.thePlayer.getLocationSkin());
/* 122 */     GL11.glEnable(3042);
/* 123 */     drawTexturedModalRect(x / scale, y / scale, 32, 32, 32, 32);
/* 124 */     GL11.glDisable(3042);
/* 125 */     GlStateManager.popMatrix();
/*     */   }
/*     */ 
/*     */   
/*     */   private int getCPS() {
/* 130 */     long time = System.currentTimeMillis();
/* 131 */     this.clicks.removeIf(aLong -> (aLong.longValue() + 1000L < paramLong));
/* 132 */     return this.clicks.size();
/*     */   }
/*     */ 
/*     */   
/*     */   private int getCPS2() {
/* 137 */     long time2 = System.currentTimeMillis();
/* 138 */     this.clicks2.removeIf(aLong2 -> (aLong2.longValue() + 1000L < paramLong));
/* 139 */     return this.clicks2.size();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void actionPerformed(GuiButton button) throws IOException {
/* 145 */     if (button.id == 50) {
/* 146 */       mc.displayGuiScreen(new ModHud5());
/*     */     }
/*     */     
/* 149 */     if (button.id == 1) {
/* 150 */       SettingsButtonToggle.save("PotionStatusChroma", Boolean.valueOf(!SettingsButtonToggle.load("PotionStatusChroma").booleanValue()));
/* 151 */       if (ModToggle.loadEnabledFromFile("Mods/ZyrexModPotionStatus/isChromaDisabled").booleanValue()) {
/* 152 */         Client.PotionStatusChroma = !Client.PotionStatusChroma;
/* 153 */         ModToggle.saveIsEnabledToFile("Mods/ZyrexModPotionStatus/isChromaDisabled", Boolean.valueOf(Client.PotionStatusChroma));
/*     */       } else {
/* 155 */         Client.PotionStatusChroma = !Client.PotionStatusChroma;
/* 156 */         ModToggle.saveIsEnabledToFile("Mods/ZyrexModPotionStatus/isChromaDisabled", Boolean.valueOf(Client.PotionStatusChroma));
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Lenovo\Downloads\ZyrexClientV1 (1).jar!\ZyrexClient\ModHuds\PotionStatusSettings.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */