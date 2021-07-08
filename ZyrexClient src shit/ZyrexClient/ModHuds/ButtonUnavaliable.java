/*     */ package ZyrexClient.ModHuds;
/*     */ 
/*     */ import ZyrexClient.FileManager;
/*     */ import ZyrexClient.clickgui.FontUtil;
/*     */ import java.awt.Color;
/*     */ import java.io.File;
/*     */ import net.minecraft.client.Minecraft;
/*     */ import net.minecraft.client.gui.GuiButton;
/*     */ import net.minecraft.client.renderer.GlStateManager;
/*     */ import net.minecraft.client.renderer.Tessellator;
/*     */ import net.minecraft.client.renderer.WorldRenderer;
/*     */ import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ButtonUnavaliable
/*     */   extends GuiButton
/*     */ {
/*  21 */   Color off = new Color(-4342339);
/*  22 */   Color on = new Color(-16711936);
/*  23 */   Color c = new Color(-1);
/*     */ 
/*     */   
/*     */   public ButtonUnavaliable(int i, int j, int k, String s) {
/*  27 */     this(i, j, k, 120, 20, s);
/*     */   }
/*     */ 
/*     */   
/*     */   public ButtonUnavaliable(int i, int j, int k, int l, int i1, String s) {
/*  32 */     super(i, j, k, l, i1, s);
/*  33 */     this.enabled = true;
/*  34 */     this.visible = true;
/*     */   }
/*     */ 
/*     */   
/*     */   protected int getHoverState(boolean flag) {
/*  39 */     byte byte0 = 1;
/*  40 */     if (!this.enabled) {
/*     */       
/*  42 */       byte0 = 0;
/*     */     }
/*  44 */     else if (flag) {
/*     */       
/*  46 */       byte0 = 2;
/*     */     } 
/*  48 */     return byte0;
/*     */   }
/*     */ 
/*     */   
/*     */   public void drawButton(Minecraft mc, int mx, int my) {
/*  53 */     GlStateManager.color(1.0F, 1.0F, 1.0F);
/*  54 */     drawRoundedRect(this.xPosition - 32, this.yPosition - 81, this.width + 64, this.height + 96, this.height / 2 - 4, new Color(30, 32, 34));
/*  55 */     drawRoundedRect(this.xPosition - 30, this.yPosition - 79, this.width + 60, this.height + 92, this.height / 2 - 4, new Color(24, 26, 28));
/*     */     
/*  57 */     drawRoundedRect(this.xPosition, this.yPosition, this.width, this.height, this.height / 2, new Color(60, 60, 60));
/*  58 */     drawCircle(this.xPosition + 1, this.yPosition + 1, this.height - 2, this.height - 2, new Color(60, 60, 60));
/*     */     
/*  60 */     FontUtil.renderCenteredString(this.displayString, this.xPosition + 12, this.yPosition - 75, -1, 1.0F);
/*  61 */     FontUtil.renderCenteredString("(Unavaliable)", this.xPosition + 12, this.yPosition - 65, (new Color(100, 100, 100)).getRGB(), 1.0F);
/*     */   }
/*     */ 
/*     */   
/*     */   public static File getFolder(String toggle) {
/*  66 */     File file = new File(FileManager.BUTTON_DIR, toggle);
/*  67 */     file.mkdirs();
/*  68 */     return file;
/*     */   }
/*     */   
/*     */   private void drawRoundedRect(int x, int y, int width, int height, int cornerRadius, Color color) {
/*  72 */     drawRect(x, y + cornerRadius, x + cornerRadius, y + height - cornerRadius, color.getRGB());
/*  73 */     drawRect(x + cornerRadius, y, x + width - cornerRadius, y + height, color.getRGB());
/*  74 */     drawRect(x + width - cornerRadius, y + cornerRadius, x + width, y + height - cornerRadius, color.getRGB());
/*  75 */     drawArc(x + cornerRadius, y + cornerRadius, cornerRadius, 0, 90, color);
/*  76 */     drawArc(x + width - cornerRadius, y + cornerRadius, cornerRadius, 270, 360, color);
/*  77 */     drawArc(x + width - cornerRadius, y + height - cornerRadius, cornerRadius, 180, 270, color);
/*  78 */     drawArc(x + cornerRadius, y + height - cornerRadius, cornerRadius, 90, 180, color);
/*     */   }
/*     */   
/*     */   private void drawArc(int x, int y, int radius, int startAngle, int endAngle, Color color) {
/*  82 */     GL11.glPushMatrix();
/*  83 */     GL11.glEnable(3042);
/*  84 */     GL11.glDisable(3553);
/*  85 */     GL11.glBlendFunc(770, 771);
/*  86 */     GL11.glColor4f(color.getRed() / 255.0F, color.getGreen() / 255.0F, color.getBlue() / 255.0F, color.getAlpha() / 255.0F);
/*     */     
/*  88 */     WorldRenderer worldRenderer = Tessellator.getInstance().getWorldRenderer();
/*     */     
/*  90 */     worldRenderer.begin(6, DefaultVertexFormats.POSITION);
/*  91 */     worldRenderer.pos(x, y, 0.0D).endVertex();
/*     */     
/*  93 */     for (int i = (int)(startAngle / 360.0D * 100.0D); i <= (int)(endAngle / 360.0D * 100.0D); i++) {
/*  94 */       double angle = 6.283185307179586D * i / 100.0D + Math.toRadians(180.0D);
/*  95 */       worldRenderer.pos(x + Math.sin(angle) * radius, y + Math.cos(angle) * radius, 0.0D).endVertex();
/*     */     } 
/*     */     
/*  98 */     Tessellator.getInstance().draw();
/*     */     
/* 100 */     GL11.glEnable(3553);
/* 101 */     GL11.glDisable(3042);
/* 102 */     GL11.glPopMatrix();
/*     */   }
/*     */   
/*     */   private void drawCircle(int x, int y, int width, int height, Color color) {
/* 106 */     drawArc(x + width / 2, y + height / 2, width / 2, 0, 360, color);
/*     */   }
/*     */ }


/* Location:              C:\Users\Lenovo\Downloads\ZyrexClientV1 (1).jar!\ZyrexClient\ModHuds\ButtonUnavaliable.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */