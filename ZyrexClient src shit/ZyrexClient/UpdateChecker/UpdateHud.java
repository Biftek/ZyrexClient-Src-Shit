/*     */ package ZyrexClient.UpdateChecker;
/*     */ 
/*     */ import ZyrexClient.NewRoundedRect;
/*     */ import ZyrexClient.clickgui.FontUtil;
/*     */ import ZyrexClient.clickgui.RoundedButtons.ButtonMainMenu;
/*     */ import java.awt.Color;
/*     */ import java.io.IOException;
/*     */ import java.net.URI;
/*     */ import net.minecraft.client.Minecraft;
/*     */ import net.minecraft.client.gui.GuiButton;
/*     */ import net.minecraft.client.gui.GuiScreen;
/*     */ import net.minecraft.client.gui.ScaledResolution;
/*     */ import net.minecraft.client.renderer.GlStateManager;
/*     */ import net.minecraft.client.renderer.Tessellator;
/*     */ import net.minecraft.client.renderer.WorldRenderer;
/*     */ import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
/*     */ import net.minecraft.client.resources.I18n;
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
/*     */ public class UpdateHud
/*     */   extends GuiScreen
/*     */ {
/*     */   public void initGui() {
/*  32 */     ScaledResolution sr = new ScaledResolution(mc);
/*  33 */     buttonList.add(new ButtonMainMenu(1, width / 2 - 90, 195, 180, 20, I18n.format("Close Game", new Object[0])));
/*  34 */     buttonList.add(new ButtonMainMenu(2, width / 2 - 90, 170, 180, 20, I18n.format("Open Discord", new Object[0])));
/*     */   }
/*     */   
/*     */   private void drawBackgroundRect(int x, int y, int width, int height, int cornerRadius, Color color) {
/*  38 */     NewRoundedRect.drawRoundedRect(x, y, x, y, cornerRadius, cornerRadius);
/*     */   }
/*     */ 
/*     */   
/*     */   public void onGuiClosed() {
/*  43 */     super.onGuiClosed();
/*     */   }
/*     */   public void openConfigScreen() {
/*  46 */     mc.displayGuiScreen(this);
/*     */   }
/*     */ 
/*     */   
/*     */   public void drawScreen(int mouseX, int mouseY, float partialTicks) {
/*  51 */     ScaledResolution sr = new ScaledResolution(mc);
/*     */     
/*  53 */     drawDefaultBackground();
/*  54 */     drawRoundedRect(-3000, -3000, 6000, 6000, 0, new Color(15, 15, 15));
/*  55 */     FontUtil.renderString(I18n.format("Update Found", new Object[0]), width / 2 - 30, 38, 16777215, 1.0F);
/*  56 */     if (UpdateChecker.shouldUpdate()) {
/*  57 */       FontUtil.renderCenteredString(I18n.format("§fHey, §b" + mc.session.getUsername() + "§f looks like you have an Older Version of the client!", new Object[0]), width / 2, 120, 16777215, 1.0F);
/*  58 */       FontUtil.renderCenteredString(I18n.format("Please download the newest version from the §bDiscord Server!", new Object[0]), width / 2, 140, 16777215, 1.0F);
/*     */     } 
/*     */     
/*  61 */     super.drawScreen(mouseX, mouseY, partialTicks);
/*     */   }
/*     */   
/*     */   public void actionPerformed(GuiButton button) throws IOException {
/*  65 */     if (button.id == 1) {
/*  66 */       mc.shutdown();
/*     */     }
/*     */     
/*  69 */     if (button.id == 2) {
/*  70 */       GuiScreen.openWebLink(URI.create("https://discord.gg/DRhcfqRTrJ"));
/*     */     }
/*     */   }
/*     */   
/*     */   private void drawRoundedRect(int x, int y, int width, int height, int cornerRadius, Color color) {
/*  75 */     drawRect(x, y + cornerRadius, x + cornerRadius, y + height - cornerRadius, color.getRGB());
/*  76 */     drawRect(x + cornerRadius, y, x + width - cornerRadius, y + height, color.getRGB());
/*  77 */     drawRect(x + width - cornerRadius, y + cornerRadius, x + width, y + height - cornerRadius, color.getRGB());
/*  78 */     drawArc(x + cornerRadius, y + cornerRadius, cornerRadius, 0, 90, color);
/*  79 */     drawArc(x + width - cornerRadius, y + cornerRadius, cornerRadius, 270, 360, color);
/*  80 */     drawArc(x + width - cornerRadius, y + height - cornerRadius, cornerRadius, 180, 270, color);
/*  81 */     drawArc(x + cornerRadius, y + height - cornerRadius, cornerRadius, 90, 180, color);
/*     */   }
/*     */   
/*     */   private void drawArc(int x, int y, int radius, int startAngle, int endAngle, Color color) {
/*  85 */     GL11.glPushMatrix();
/*  86 */     GL11.glEnable(3042);
/*  87 */     GL11.glDisable(3553);
/*  88 */     GL11.glBlendFunc(770, 771);
/*  89 */     GL11.glColor4f(color.getRed() / 255.0F, color.getGreen() / 255.0F, color.getBlue() / 255.0F, color.getAlpha() / 255.0F);
/*     */     
/*  91 */     WorldRenderer worldRenderer = Tessellator.getInstance().getWorldRenderer();
/*     */     
/*  93 */     worldRenderer.begin(6, DefaultVertexFormats.POSITION);
/*  94 */     worldRenderer.pos(x, y, 0.0D).endVertex();
/*     */     
/*  96 */     for (int i = (int)(startAngle / 360.0D * 100.0D); i <= (int)(endAngle / 360.0D * 100.0D); i++) {
/*  97 */       double angle = 6.283185307179586D * i / 100.0D + Math.toRadians(180.0D);
/*  98 */       worldRenderer.pos(x + Math.sin(angle) * radius, y + Math.cos(angle) * radius, 0.0D).endVertex();
/*     */     } 
/*     */     
/* 101 */     Tessellator.getInstance().draw();
/*     */     
/* 103 */     GL11.glEnable(3553);
/* 104 */     GL11.glDisable(3042);
/* 105 */     GL11.glPopMatrix();
/*     */   }
/*     */   
/*     */   private void drawCircle(int x, int y, int width, int height, Color color) {
/* 109 */     drawArc(x + width / 2, y + height / 2, width / 2, 0, 360, color);
/*     */   }
/*     */   
/*     */   public void drawPlayerHead(int x, int y, int width) {
/* 113 */     GlStateManager.pushMatrix();
/* 114 */     float scale = (width / 32);
/* 115 */     GlStateManager.scale(scale, scale, scale);
/* 116 */     Minecraft.getMinecraft(); mc.getTextureManager().bindTexture(Minecraft.thePlayer.getLocationSkin());
/* 117 */     GL11.glEnable(3042);
/* 118 */     drawTexturedModalRect(x / scale, y / scale, 32, 32, 32, 32);
/* 119 */     GL11.glDisable(3042);
/* 120 */     GlStateManager.popMatrix();
/*     */   }
/*     */ }


/* Location:              C:\Users\Lenovo\Downloads\ZyrexClientV1 (1).jar!\ZyrexClient\UpdateChecker\UpdateHud.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */