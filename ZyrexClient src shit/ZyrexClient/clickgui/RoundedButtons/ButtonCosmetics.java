/*     */ package ZyrexClient.clickgui.RoundedButtons;
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
/*     */ public class ButtonCosmetics
/*     */   extends GuiButton
/*     */ {
/*  19 */   Color off = new Color(-4342339);
/*  20 */   Color on = new Color(-16711936);
/*  21 */   Color c = new Color(-1);
/*     */   
/*     */   private int j2;
/*     */   
/*     */   public ButtonCosmetics(int i, int j, int k, String s) {
/*  26 */     this(i, j, k, 120, 20, s);
/*     */   }
/*     */ 
/*     */   
/*     */   public ButtonCosmetics(int i, int j, int k, int l, int i1, String s) {
/*  31 */     super(i, j, k, l, i1, s);
/*  32 */     this.enabled = true;
/*  33 */     this.visible = true;
/*     */   }
/*     */ 
/*     */   
/*     */   protected int getHoverState(boolean flag) {
/*  38 */     byte byte0 = 1;
/*  39 */     if (!this.enabled) {
/*     */       
/*  41 */       byte0 = 0;
/*     */     }
/*  43 */     else if (flag) {
/*     */       
/*  45 */       byte0 = 2;
/*     */     } 
/*  47 */     return byte0;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void drawButton(Minecraft mc, int mx, int my) {
/*  56 */     GlStateManager.color(1.0F, 1.0F, 1.0F);
/*  57 */     if (load(this.displayString).booleanValue()) {
/*  58 */       drawRoundedRect(this.xPosition, this.yPosition, this.width, this.height, 3, new Color(30, 30, 30, 180));
/*     */       
/*  60 */       FontUtil.renderCenteredString(this.displayString, this.xPosition + this.width / 2, this.yPosition + (this.height - 12) / 2, (new Color(255, 50, 60, 130)).getRGB(), 1.05F);
/*     */     } else {
/*  62 */       drawRoundedRect(this.xPosition, this.yPosition, this.width, this.height, 3, new Color(30, 30, 30));
/*     */       
/*  64 */       FontUtil.renderCenteredString(this.displayString, this.xPosition + this.width / 2, this.yPosition + (this.height - 12) / 2, (new Color(50, 150, 255)).getRGB(), 1.05F);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static File getFolder(String toggle) {
/*  71 */     File file = new File(FileManager.BUTTON_DIR, toggle);
/*  72 */     file.mkdirs();
/*  73 */     return file;
/*     */   }
/*     */   
/*     */   public static void save(String toggle, Boolean b) {
/*  77 */     FileManager.writeJsonToFile(new File(getFolder(toggle), "Toggle.json"), b);
/*     */   }
/*     */   public static Boolean load(String toggle) {
/*  80 */     Boolean b = (Boolean)FileManager.readFromJson(new File(getFolder(toggle), "Toggle.json"), Boolean.class);
/*     */     
/*  82 */     if (b == null) {
/*  83 */       b = Boolean.valueOf(true);
/*  84 */       save(toggle, b);
/*     */     } 
/*  86 */     return b;
/*     */   }
/*     */   
/*     */   private void drawRoundedRect(int x, int y, int width, int height, int cornerRadius, Color color) {
/*  90 */     drawRect(x, y + cornerRadius, x + cornerRadius, y + height - cornerRadius, color.getRGB());
/*  91 */     drawRect(x + cornerRadius, y, x + width - cornerRadius, y + height, color.getRGB());
/*  92 */     drawRect(x + width - cornerRadius, y + cornerRadius, x + width, y + height - cornerRadius, color.getRGB());
/*  93 */     drawArc(x + cornerRadius, y + cornerRadius, cornerRadius, 0, 90, color);
/*  94 */     drawArc(x + width - cornerRadius, y + cornerRadius, cornerRadius, 270, 360, color);
/*  95 */     drawArc(x + width - cornerRadius, y + height - cornerRadius, cornerRadius, 180, 270, color);
/*  96 */     drawArc(x + cornerRadius, y + height - cornerRadius, cornerRadius, 90, 180, color);
/*     */   }
/*     */   
/*     */   private void drawArc(int x, int y, int radius, int startAngle, int endAngle, Color color) {
/* 100 */     GL11.glPushMatrix();
/* 101 */     GL11.glEnable(3042);
/* 102 */     GL11.glDisable(3553);
/* 103 */     GL11.glBlendFunc(770, 771);
/* 104 */     GL11.glColor4f(color.getRed() / 255.0F, color.getGreen() / 255.0F, color.getBlue() / 255.0F, color.getAlpha() / 255.0F);
/*     */     
/* 106 */     WorldRenderer worldRenderer = Tessellator.getInstance().getWorldRenderer();
/*     */     
/* 108 */     worldRenderer.begin(6, DefaultVertexFormats.POSITION);
/* 109 */     worldRenderer.pos(x, y, 0.0D).endVertex();
/*     */     
/* 111 */     for (int i = (int)(startAngle / 360.0D * 100.0D); i <= (int)(endAngle / 360.0D * 100.0D); i++) {
/* 112 */       double angle = 6.283185307179586D * i / 100.0D + Math.toRadians(180.0D);
/* 113 */       worldRenderer.pos(x + Math.sin(angle) * radius, y + Math.cos(angle) * radius, 0.0D).endVertex();
/*     */     } 
/*     */     
/* 116 */     Tessellator.getInstance().draw();
/*     */     
/* 118 */     GL11.glEnable(3553);
/* 119 */     GL11.glDisable(3042);
/* 120 */     GL11.glPopMatrix();
/*     */   }
/*     */   
/*     */   private void drawCircle(int x, int y, int width, int height, Color color) {
/* 124 */     drawArc(x + width / 2, y + height / 2, width / 2, 0, 360, color);
/*     */   }
/*     */ }


/* Location:              C:\Users\Lenovo\Downloads\ZyrexClientV1 (1).jar!\ZyrexClient\clickgui\RoundedButtons\ButtonCosmetics.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */