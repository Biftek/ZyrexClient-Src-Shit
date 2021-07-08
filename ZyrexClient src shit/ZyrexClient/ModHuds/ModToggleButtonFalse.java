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
/*     */ public class ModToggleButtonFalse
/*     */   extends GuiButton
/*     */ {
/*  21 */   Color off = new Color(-4342339);
/*  22 */   Color on = new Color(-16711936);
/*  23 */   Color c = new Color(-1);
/*     */ 
/*     */   
/*     */   public ModToggleButtonFalse(int i, int j, int k, String s) {
/*  27 */     this(i, j, k, 120, 20, s);
/*     */   }
/*     */ 
/*     */   
/*     */   public ModToggleButtonFalse(int i, int j, int k, int l, int i1, String s) {
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
/*  54 */     if (load(this.displayString).booleanValue()) {
/*  55 */       drawRoundedRect(this.xPosition - 32, this.yPosition - 81, this.width + 64, this.height + 96, this.height / 2 - 4, new Color(30, 32, 34));
/*  56 */       drawRoundedRect(this.xPosition - 30, this.yPosition - 79, this.width + 60, this.height + 92, this.height / 2 - 4, new Color(24, 26, 28));
/*     */ 
/*     */       
/*  59 */       drawRoundedRect(this.xPosition, this.yPosition, this.width, this.height, this.height / 2, new Color(50, 100, 255));
/*  60 */       drawCircle(this.xPosition + this.width - this.height + 1, this.yPosition + 1, this.height - 2, this.height - 2, this.c);
/*     */ 
/*     */       
/*  63 */       FontUtil.renderCenteredString(this.displayString, this.xPosition + 12, this.yPosition - 75, -1, 1.0F);
/*     */     } else {
/*     */       
/*  66 */       drawRoundedRect(this.xPosition - 32, this.yPosition - 81, this.width + 64, this.height + 96, this.height / 2 - 4, new Color(30, 32, 34));
/*  67 */       drawRoundedRect(this.xPosition - 30, this.yPosition - 79, this.width + 60, this.height + 92, this.height / 2 - 4, new Color(24, 26, 28));
/*     */       
/*  69 */       drawRoundedRect(this.xPosition, this.yPosition, this.width, this.height, this.height / 2, new Color(255, 80, 80));
/*  70 */       drawCircle(this.xPosition + 1, this.yPosition + 1, this.height - 2, this.height - 2, this.c);
/*     */       
/*  72 */       FontUtil.renderCenteredString(this.displayString, this.xPosition + 12, this.yPosition - 75, -1, 1.0F);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static File getFolder(String toggle) {
/*  79 */     File file = new File(FileManager.BUTTON_DIR, toggle);
/*  80 */     file.mkdirs();
/*  81 */     return file;
/*     */   }
/*     */   
/*     */   public static void save(String toggle, Boolean b) {
/*  85 */     FileManager.writeJsonToFile(new File(getFolder(toggle), "Toggle.json"), b);
/*     */   }
/*     */   public static Boolean load(String toggle) {
/*  88 */     Boolean b = (Boolean)FileManager.readFromJson(new File(getFolder(toggle), "Toggle.json"), Boolean.class);
/*     */     
/*  90 */     if (b == null) {
/*  91 */       b = Boolean.valueOf(false);
/*  92 */       save(toggle, b);
/*     */     } 
/*  94 */     return b;
/*     */   }
/*     */   
/*     */   private void drawRoundedRect(int x, int y, int width, int height, int cornerRadius, Color color) {
/*  98 */     drawRect(x, y + cornerRadius, x + cornerRadius, y + height - cornerRadius, color.getRGB());
/*  99 */     drawRect(x + cornerRadius, y, x + width - cornerRadius, y + height, color.getRGB());
/* 100 */     drawRect(x + width - cornerRadius, y + cornerRadius, x + width, y + height - cornerRadius, color.getRGB());
/* 101 */     drawArc(x + cornerRadius, y + cornerRadius, cornerRadius, 0, 90, color);
/* 102 */     drawArc(x + width - cornerRadius, y + cornerRadius, cornerRadius, 270, 360, color);
/* 103 */     drawArc(x + width - cornerRadius, y + height - cornerRadius, cornerRadius, 180, 270, color);
/* 104 */     drawArc(x + cornerRadius, y + height - cornerRadius, cornerRadius, 90, 180, color);
/*     */   }
/*     */   
/*     */   private void drawArc(int x, int y, int radius, int startAngle, int endAngle, Color color) {
/* 108 */     GL11.glPushMatrix();
/* 109 */     GL11.glEnable(3042);
/* 110 */     GL11.glDisable(3553);
/* 111 */     GL11.glBlendFunc(770, 771);
/* 112 */     GL11.glColor4f(color.getRed() / 255.0F, color.getGreen() / 255.0F, color.getBlue() / 255.0F, color.getAlpha() / 255.0F);
/*     */     
/* 114 */     WorldRenderer worldRenderer = Tessellator.getInstance().getWorldRenderer();
/*     */     
/* 116 */     worldRenderer.begin(6, DefaultVertexFormats.POSITION);
/* 117 */     worldRenderer.pos(x, y, 0.0D).endVertex();
/*     */     
/* 119 */     for (int i = (int)(startAngle / 360.0D * 100.0D); i <= (int)(endAngle / 360.0D * 100.0D); i++) {
/* 120 */       double angle = 6.283185307179586D * i / 100.0D + Math.toRadians(180.0D);
/* 121 */       worldRenderer.pos(x + Math.sin(angle) * radius, y + Math.cos(angle) * radius, 0.0D).endVertex();
/*     */     } 
/*     */     
/* 124 */     Tessellator.getInstance().draw();
/*     */     
/* 126 */     GL11.glEnable(3553);
/* 127 */     GL11.glDisable(3042);
/* 128 */     GL11.glPopMatrix();
/*     */   }
/*     */   
/*     */   private void drawCircle(int x, int y, int width, int height, Color color) {
/* 132 */     drawArc(x + width / 2, y + height / 2, width / 2, 0, 360, color);
/*     */   }
/*     */ }


/* Location:              C:\Users\Lenovo\Downloads\ZyrexClientV1 (1).jar!\ZyrexClient\ModHuds\ModToggleButtonFalse.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */