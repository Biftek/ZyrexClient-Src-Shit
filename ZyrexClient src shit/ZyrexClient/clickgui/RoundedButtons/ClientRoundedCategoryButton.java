/*     */ package ZyrexClient.clickgui.RoundedButtons;
/*     */ 
/*     */ import ZyrexClient.FileManager;
/*     */ import ZyrexClient.NewRoundedRect;
/*     */ import ZyrexClient.clickgui.FontUtil;
/*     */ import java.awt.Color;
/*     */ import java.io.File;
/*     */ import net.minecraft.client.Minecraft;
/*     */ import net.minecraft.client.gui.FontRenderer;
/*     */ import net.minecraft.client.gui.GuiButton;
/*     */ import net.minecraft.client.gui.ScaledResolution;
/*     */ import net.minecraft.client.renderer.GlStateManager;
/*     */ import net.minecraft.client.renderer.Tessellator;
/*     */ import net.minecraft.client.renderer.WorldRenderer;
/*     */ import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ClientRoundedCategoryButton
/*     */   extends GuiButton
/*     */ {
/*     */   public ClientRoundedCategoryButton(int i, int j, int k, String s) {
/*  28 */     this(i, j, k, 120, 20, s);
/*     */   }
/*     */ 
/*     */   
/*     */   public ClientRoundedCategoryButton(int i, int j, int k, int l, int i1, String s) {
/*  33 */     super(i, j, k, l, i1, s);
/*  34 */     this.enabled = true;
/*  35 */     this.visible = true;
/*     */   }
/*     */ 
/*     */   
/*     */   protected int getHoverState(boolean flag) {
/*  40 */     byte byte0 = 1;
/*  41 */     if (!this.enabled) {
/*     */       
/*  43 */       byte0 = 0;
/*     */     }
/*  45 */     else if (flag) {
/*     */       
/*  47 */       byte0 = 2;
/*     */     } 
/*  49 */     return byte0;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void drawButton(Minecraft mc, int mx, int my) {
/*  58 */     FontRenderer fr = mc.fontRendererObj;
/*     */     
/*  60 */     ScaledResolution sr = new ScaledResolution(mc);
/*     */     
/*  62 */     GlStateManager.color(1.0F, 1.0F, 1.0F);
/*  63 */     if (load(this.displayString).booleanValue()) {
/*     */       
/*  65 */       drawRoundedRect(this.xPosition, this.yPosition, this.width, this.height, this.height / 2, new Color(6, 127, 241));
/*  66 */       FontUtil.renderString("ENABLED", this.xPosition + this.width / 2 - 21, this.yPosition + (this.height - 10) / 2, -1, 1.0F);
/*  67 */       FontUtil.renderString(this.displayString, this.xPosition + 25, this.width + 120, (new Color(255, 255, 255)).getRGB(), 1.2F);
/*     */     }
/*     */     else {
/*     */       
/*  71 */       drawRoundedRect(this.xPosition, this.yPosition, this.width, this.height, this.height / 2, new Color(248, 91, 73));
/*  72 */       FontUtil.renderString(this.displayString, this.xPosition + 25, this.width + 120, (new Color(105, 105, 105)).getRGB(), 1.2F);
/*  73 */       FontUtil.renderString("DISABLED", this.xPosition + this.width / 2 - 22, this.yPosition + (this.height - 11) / 2, -1, 1.0F);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static File getFolder(String toggle) {
/*  80 */     File file = new File(FileManager.MODS_DIR, toggle);
/*  81 */     file.mkdirs();
/*  82 */     return file;
/*     */   }
/*     */   
/*     */   public static void save(String toggle, Boolean b) {
/*  86 */     FileManager.writeJsonToFile(new File(getFolder(toggle), "Toggle.json"), b);
/*     */   }
/*     */   public static Boolean load(String toggle) {
/*  89 */     Boolean b = (Boolean)FileManager.readFromJson(new File(getFolder(toggle), "Toggle.json"), Boolean.class);
/*     */     
/*  91 */     if (b == null) {
/*  92 */       b = Boolean.valueOf(true);
/*  93 */       save(toggle, b);
/*     */     } 
/*  95 */     return b;
/*     */   }
/*     */   
/*     */   private void drawRoundedRect(int x, int y, int width, int height, int cornerRadius, Color color) {
/*  99 */     drawRect(x, y + cornerRadius, x + cornerRadius, y + height - cornerRadius, color.getRGB());
/* 100 */     drawRect(x + cornerRadius, y, x + width - cornerRadius, y + height, color.getRGB());
/* 101 */     drawRect(x + width - cornerRadius, y + cornerRadius, x + width, y + height - cornerRadius, color.getRGB());
/* 102 */     drawArc(x + cornerRadius, y + cornerRadius, cornerRadius, 0, 90, color);
/* 103 */     drawArc(x + width - cornerRadius, y + cornerRadius, cornerRadius, 270, 360, color);
/* 104 */     drawArc(x + width - cornerRadius, y + height - cornerRadius, cornerRadius, 180, 270, color);
/* 105 */     drawArc(x + cornerRadius, y + height - cornerRadius, cornerRadius, 90, 180, color);
/*     */   }
/*     */   
/*     */   private void drawBackgroundRect(int x, int y, int width, int height, int cornerRadius, Color color) {
/* 109 */     NewRoundedRect.drawRoundedRect(x, y, x, y, cornerRadius, cornerRadius);
/*     */   }
/*     */   
/*     */   private void drawArc(int x, int y, int radius, int startAngle, int endAngle, Color color) {
/* 113 */     GL11.glPushMatrix();
/* 114 */     GL11.glEnable(3042);
/* 115 */     GL11.glDisable(3553);
/* 116 */     GL11.glBlendFunc(770, 771);
/* 117 */     GL11.glColor4f(color.getRed() / 255.0F, color.getGreen() / 255.0F, color.getBlue() / 255.0F, color.getAlpha() / 255.0F);
/*     */     
/* 119 */     WorldRenderer worldRenderer = Tessellator.getInstance().getWorldRenderer();
/*     */     
/* 121 */     worldRenderer.begin(6, DefaultVertexFormats.POSITION);
/* 122 */     worldRenderer.pos(x, y, 0.0D).endVertex();
/*     */     
/* 124 */     for (int i = (int)(startAngle / 360.0D * 100.0D); i <= (int)(endAngle / 360.0D * 100.0D); i++) {
/* 125 */       double angle = 6.283185307179586D * i / 100.0D + Math.toRadians(180.0D);
/* 126 */       worldRenderer.pos(x + Math.sin(angle) * radius, y + Math.cos(angle) * radius, 0.0D).endVertex();
/*     */     } 
/*     */     
/* 129 */     Tessellator.getInstance().draw();
/*     */     
/* 131 */     GL11.glEnable(3553);
/* 132 */     GL11.glDisable(3042);
/* 133 */     GL11.glPopMatrix();
/*     */   }
/*     */   
/*     */   private void drawCircle(int x, int y, int width, int height, Color color) {
/* 137 */     drawArc(x + width / 2, y + height / 2, width / 2, 0, 360, color);
/*     */   }
/*     */ }


/* Location:              C:\Users\Lenovo\Downloads\ZyrexClientV1 (1).jar!\ZyrexClient\clickgui\RoundedButtons\ClientRoundedCategoryButton.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */