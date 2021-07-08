/*     */ package ZyrexClient.clickguitest;
/*     */ 
/*     */ import ZyrexClient.FileManager;
/*     */ import ZyrexClient.NewRoundedRect;
/*     */ import ZyrexClient.clickgui.FontUtil;
/*     */ import java.awt.Color;
/*     */ import java.io.File;
/*     */ import net.minecraft.client.Minecraft;
/*     */ import net.minecraft.client.gui.FontRenderer;
/*     */ import net.minecraft.client.gui.GuiButton;
/*     */ import net.minecraft.client.renderer.Tessellator;
/*     */ import net.minecraft.client.renderer.WorldRenderer;
/*     */ import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SwitchPageButton
/*     */   extends GuiButton
/*     */ {
/*     */   private int j6;
/*     */   private int j10;
/*     */   float speed;
/*     */   int fade;
/*     */   int fade2;
/*     */   
/*     */   public SwitchPageButton(int i, int j, int k, String s) {
/*  30 */     this(i, j, k, 120, k, s);
/*     */   }
/*     */ 
/*     */   
/*     */   public SwitchPageButton(int i, int j, int k, int l, int i1, String s) {
/*  35 */     super(i, j, k, l, i1, s);
/*  36 */     this.enabled = true;
/*  37 */     this.visible = true;
/*     */   }
/*     */ 
/*     */   
/*     */   protected int getHoverState(boolean flag) {
/*  42 */     byte byte0 = 1;
/*  43 */     if (!this.enabled) {
/*     */       
/*  45 */       byte0 = 0;
/*     */     }
/*  47 */     else if (flag) {
/*     */       
/*  49 */       byte0 = 2;
/*     */     } 
/*  51 */     return byte0;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void drawButton(Minecraft mc, int mouseX, int mouseY) {
/*  61 */     this.hovered = (mouseX >= this.xPosition && mouseY >= this.yPosition && mouseX < this.xPosition + this.width && mouseY < this.yPosition + this.height);
/*  62 */     int j = (new Color(110, 110, 110)).getRGB();
/*  63 */     if (this.hovered) {
/*  64 */       j = 35071;
/*     */     }
/*  66 */     if (this.xPosition >= this.xPosition && this.yPosition >= this.yPosition && this.xPosition < this.xPosition + this.width && this.yPosition < this.yPosition + this.height) {
/*  67 */       int n = 5;
/*     */       
/*  69 */       drawRoundedRect(this.xPosition, this.yPosition, this.width, this.height, this.height / 2 - 4, new Color(30, 30, 30));
/*     */       
/*  71 */       FontRenderer fr = mc.clientFont;
/*  72 */       this.hovered = (mouseX >= this.xPosition && mouseY >= this.yPosition && mouseX < this.xPosition + this.width && mouseY < this.yPosition + this.height);
/*     */       
/*  74 */       FontUtil.renderCenteredStringAnimated(this.displayString, (this.xPosition + this.width / 2), (this.yPosition + (this.height - 12) / 2), (new Color(255, 255, 255)).getRGB(), 1.05F);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static File getFolder(String toggle) {
/*  82 */     File file = new File(FileManager.MODS_DIR, toggle);
/*  83 */     file.mkdirs();
/*  84 */     return file;
/*     */   }
/*     */   
/*     */   public static void save(String toggle, Boolean b) {
/*  88 */     FileManager.writeJsonToFile(new File(getFolder(toggle), "Toggle.json"), b);
/*     */   }
/*     */   public static Boolean load(String toggle) {
/*  91 */     Boolean b = (Boolean)FileManager.readFromJson(new File(getFolder(toggle), "Toggle.json"), Boolean.class);
/*     */     
/*  93 */     if (b == null) {
/*  94 */       b = Boolean.valueOf(true);
/*  95 */       save(toggle, b);
/*     */     } 
/*  97 */     return b;
/*     */   }
/*     */   
/*     */   private void drawRoundedRect(int x, int y, int width, int height, int cornerRadius, Color color) {
/* 101 */     drawRect(x, y + cornerRadius, x + cornerRadius, y + height - cornerRadius, color.getRGB());
/* 102 */     drawRect(x + cornerRadius, y, x + width - cornerRadius, y + height, color.getRGB());
/* 103 */     drawRect(x + width - cornerRadius, y + cornerRadius, x + width, y + height - cornerRadius, color.getRGB());
/* 104 */     drawArc(x + cornerRadius, y + cornerRadius, cornerRadius, 0, 90, color);
/* 105 */     drawArc(x + width - cornerRadius, y + cornerRadius, cornerRadius, 270, 360, color);
/* 106 */     drawArc(x + width - cornerRadius, y + height - cornerRadius, cornerRadius, 180, 270, color);
/* 107 */     drawArc(x + cornerRadius, y + height - cornerRadius, cornerRadius, 90, 180, color);
/*     */   }
/*     */   
/*     */   private void drawBackgroundRect(int x, int y, int width, int height, int cornerRadius, Color color) {
/* 111 */     NewRoundedRect.drawRoundedRect(x, y, x, y, cornerRadius, cornerRadius);
/*     */   }
/*     */   
/*     */   private void drawArc(int x, int y, int radius, int startAngle, int endAngle, Color color) {
/* 115 */     GL11.glPushMatrix();
/* 116 */     GL11.glEnable(3042);
/* 117 */     GL11.glDisable(3553);
/* 118 */     GL11.glBlendFunc(770, 771);
/* 119 */     GL11.glColor4f(color.getRed() / 255.0F, color.getGreen() / 255.0F, color.getBlue() / 255.0F, color.getAlpha() / 255.0F);
/*     */     
/* 121 */     WorldRenderer worldRenderer = Tessellator.getInstance().getWorldRenderer();
/*     */     
/* 123 */     worldRenderer.begin(6, DefaultVertexFormats.POSITION);
/* 124 */     worldRenderer.pos(x, y, 0.0D).endVertex();
/*     */     
/* 126 */     for (int i = (int)(startAngle / 360.0D * 100.0D); i <= (int)(endAngle / 360.0D * 100.0D); i++) {
/* 127 */       double angle = 6.283185307179586D * i / 100.0D + Math.toRadians(180.0D);
/* 128 */       worldRenderer.pos(x + Math.sin(angle) * radius, y + Math.cos(angle) * radius, 0.0D).endVertex();
/*     */     } 
/*     */     
/* 131 */     Tessellator.getInstance().draw();
/*     */     
/* 133 */     GL11.glEnable(3553);
/* 134 */     GL11.glDisable(3042);
/* 135 */     GL11.glPopMatrix();
/*     */   }
/*     */   
/*     */   private void drawCircle(int x, int y, int width, int height, Color color) {
/* 139 */     drawArc(x + width / 2, y + height / 2, width / 2, 0, 360, color);
/*     */   }
/*     */ }


/* Location:              C:\Users\Lenovo\Downloads\ZyrexClientV1 (1).jar!\ZyrexClient\clickguitest\SwitchPageButton.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */