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
/*     */ import net.minecraft.client.renderer.Tessellator;
/*     */ import net.minecraft.client.renderer.WorldRenderer;
/*     */ import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class MultiplayerSelectionButton
/*     */   extends GuiButton
/*     */ {
/*     */   private int j6;
/*     */   private int j10;
/*     */   int fade;
/*     */   int fade2;
/*     */   
/*     */   public MultiplayerSelectionButton(int i, int j, int k, String s) {
/*  29 */     this(i, j, k, 120, k, s);
/*     */   }
/*     */ 
/*     */   
/*     */   public MultiplayerSelectionButton(int i, int j, int k, int l, int i1, String s) {
/*  34 */     super(i, j, k, l, i1, s);
/*  35 */     this.enabled = true;
/*  36 */     this.visible = true;
/*     */   }
/*     */ 
/*     */   
/*     */   protected int getHoverState(boolean flag) {
/*  41 */     byte byte0 = 1;
/*  42 */     if (!this.enabled) {
/*     */       
/*  44 */       byte0 = 0;
/*     */     }
/*  46 */     else if (flag) {
/*     */       
/*  48 */       byte0 = 2;
/*     */     } 
/*  50 */     return byte0;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void drawButton(Minecraft mc, int mouseX, int mouseY) {
/*  60 */     this.hovered = (mouseX >= this.xPosition && mouseY >= this.yPosition && mouseX < this.xPosition + this.width && mouseY < this.yPosition + this.height);
/*  61 */     int j = -1;
/*  62 */     if (this.hovered) {
/*  63 */       j = -1;
/*     */     }
/*  65 */     Color j2 = new Color(30, 100, 255);
/*  66 */     if (this.hovered) {
/*  67 */       j2 = new Color(10, 80, 215);
/*     */     }
/*  69 */     float b = (this.hovered ? (new Color(30, 30, 30, 100)).getRGB() : (new Color(30, 30, 30, 30)).getRGB());
/*  70 */     Color a = new Color(30, 30, 30, this.fade);
/*     */     
/*  72 */     if (this.xPosition >= this.xPosition && this.yPosition >= this.yPosition && this.xPosition < this.xPosition + this.width && this.yPosition < this.yPosition + this.height) {
/*  73 */       int n = 5;
/*     */       
/*  75 */       FontRenderer fr = mc.clientFont;
/*  76 */       this.hovered = (mouseX >= this.xPosition && mouseY >= this.yPosition && mouseX < this.xPosition + this.width && mouseY < this.yPosition + this.height);
/*  77 */       drawRoundedRect(this.xPosition, this.yPosition, this.width, this.height, 3, j2);
/*     */       
/*  79 */       FontUtil.renderCenteredString(this.displayString, this.xPosition + this.width / 2, this.yPosition + (this.height - 12) / 2, j, 1.05F);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static File getFolder(String toggle) {
/*  86 */     File file = new File(FileManager.MODS_DIR, toggle);
/*  87 */     file.mkdirs();
/*  88 */     return file;
/*     */   }
/*     */   
/*     */   public static void save(String toggle, Boolean b) {
/*  92 */     FileManager.writeJsonToFile(new File(getFolder(toggle), "Toggle.json"), b);
/*     */   }
/*     */   public static Boolean load(String toggle) {
/*  95 */     Boolean b = (Boolean)FileManager.readFromJson(new File(getFolder(toggle), "Toggle.json"), Boolean.class);
/*     */     
/*  97 */     if (b == null) {
/*  98 */       b = Boolean.valueOf(true);
/*  99 */       save(toggle, b);
/*     */     } 
/* 101 */     return b;
/*     */   }
/*     */   
/*     */   private void drawRoundedRect(int x, int y, int width, int height, int cornerRadius, Color color) {
/* 105 */     drawRect(x, y + cornerRadius, x + cornerRadius, y + height - cornerRadius, color.getRGB());
/* 106 */     drawRect(x + cornerRadius, y, x + width - cornerRadius, y + height, color.getRGB());
/* 107 */     drawRect(x + width - cornerRadius, y + cornerRadius, x + width, y + height - cornerRadius, color.getRGB());
/* 108 */     drawArc(x + cornerRadius, y + cornerRadius, cornerRadius, 0, 90, color);
/* 109 */     drawArc(x + width - cornerRadius, y + cornerRadius, cornerRadius, 270, 360, color);
/* 110 */     drawArc(x + width - cornerRadius, y + height - cornerRadius, cornerRadius, 180, 270, color);
/* 111 */     drawArc(x + cornerRadius, y + height - cornerRadius, cornerRadius, 90, 180, color);
/*     */   }
/*     */   
/*     */   private void drawBackgroundRect(int x, int y, int width, int height, int cornerRadius, Color color) {
/* 115 */     NewRoundedRect.drawRoundedRect(x, y, x, y, cornerRadius, cornerRadius);
/*     */   }
/*     */   
/*     */   private void drawArc(int x, int y, int radius, int startAngle, int endAngle, Color color) {
/* 119 */     GL11.glPushMatrix();
/* 120 */     GL11.glEnable(3042);
/* 121 */     GL11.glDisable(3553);
/* 122 */     GL11.glBlendFunc(770, 771);
/* 123 */     GL11.glColor4f(color.getRed() / 255.0F, color.getGreen() / 255.0F, color.getBlue() / 255.0F, color.getAlpha() / 255.0F);
/*     */     
/* 125 */     WorldRenderer worldRenderer = Tessellator.getInstance().getWorldRenderer();
/*     */     
/* 127 */     worldRenderer.begin(6, DefaultVertexFormats.POSITION);
/* 128 */     worldRenderer.pos(x, y, 0.0D).endVertex();
/*     */     
/* 130 */     for (int i = (int)(startAngle / 360.0D * 100.0D); i <= (int)(endAngle / 360.0D * 100.0D); i++) {
/* 131 */       double angle = 6.283185307179586D * i / 100.0D + Math.toRadians(180.0D);
/* 132 */       worldRenderer.pos(x + Math.sin(angle) * radius, y + Math.cos(angle) * radius, 0.0D).endVertex();
/*     */     } 
/*     */     
/* 135 */     Tessellator.getInstance().draw();
/*     */     
/* 137 */     GL11.glEnable(3553);
/* 138 */     GL11.glDisable(3042);
/* 139 */     GL11.glPopMatrix();
/*     */   }
/*     */   
/*     */   private void drawCircle(int x, int y, int width, int height, Color color) {
/* 143 */     drawArc(x + width / 2, y + height / 2, width / 2, 0, 360, color);
/*     */   }
/*     */ }


/* Location:              C:\Users\Lenovo\Downloads\ZyrexClientV1 (1).jar!\ZyrexClient\clickgui\RoundedButtons\MultiplayerSelectionButton.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */