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
/*     */ 
/*     */ public class ButtonMainMenu
/*     */   extends GuiButton
/*     */ {
/*     */   private int j6;
/*     */   private int j10;
/*     */   int speed;
/*     */   int fade;
/*     */   int fade2;
/*     */   
/*     */   public ButtonMainMenu(int i, int j, int k, String s) {
/*  31 */     this(i, j, k, 120, k, s);
/*     */   }
/*     */ 
/*     */   
/*     */   public ButtonMainMenu(int i, int j, int k, int l, int i1, String s) {
/*  36 */     super(i, j, k, l, i1, s);
/*  37 */     this.enabled = true;
/*  38 */     this.visible = true;
/*     */   }
/*     */ 
/*     */   
/*     */   protected int getHoverState(boolean flag) {
/*  43 */     byte byte0 = 1;
/*  44 */     if (!this.enabled) {
/*     */       
/*  46 */       byte0 = 0;
/*     */     }
/*  48 */     else if (flag) {
/*     */       
/*  50 */       byte0 = 2;
/*     */     } 
/*  52 */     return byte0;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void drawButton(Minecraft mc, int mouseX, int mouseY) {
/*  62 */     this.hovered = (mouseX >= this.xPosition && mouseY >= this.yPosition && mouseX < this.xPosition + this.width && mouseY < this.yPosition + this.height);
/*  63 */     int j = (new Color(200, 200, 200)).getRGB();
/*  64 */     if (this.hovered) {
/*  65 */       j = -1;
/*     */     }
/*  67 */     if (!this.hovered) {
/*  68 */       this.fade = 230;
/*     */     } else {
/*     */       
/*  71 */       if (this.fade <= 50) {
/*     */         return;
/*     */       }
/*  74 */       if (this.fade != 160) {
/*  75 */         this.fade -= 10;
/*     */       }
/*     */     } 
/*     */     
/*  79 */     if (!this.hovered) {
/*  80 */       this.fade2 = 200;
/*     */     } else {
/*     */       
/*  83 */       if (this.fade2 <= 30) {
/*     */         return;
/*     */       }
/*  86 */       if (this.fade2 != 200) {
/*  87 */         this.fade2 += 10;
/*     */       }
/*     */     } 
/*     */     
/*  91 */     float b = (this.hovered ? (new Color(30, 30, 30, 100)).getRGB() : (new Color(30, 30, 30, 30)).getRGB());
/*  92 */     Color a = new Color(15, 15, 15, this.fade);
/*  93 */     Color a2 = new Color(100, 100, 100, this.fade2);
/*  94 */     Color a3 = new Color(80, 80, 80, this.fade);
/*     */     
/*  96 */     if (this.xPosition >= this.xPosition && this.yPosition >= this.yPosition && this.xPosition < this.xPosition + this.width && this.yPosition < this.yPosition + this.height) {
/*  97 */       int n = 5;
/*     */       
/*  99 */       FontRenderer fr = mc.clientFont;
/* 100 */       this.hovered = (mouseX >= this.xPosition && mouseY >= this.yPosition && mouseX < this.xPosition + this.width && mouseY < this.yPosition + this.height);
/* 101 */       drawRoundedRect(this.xPosition - 1, this.yPosition - 1, this.width + 2, this.height + 2, 3, a2);
/* 102 */       drawRoundedRect(this.xPosition, this.yPosition, this.width, this.height, 3, a3);
/* 103 */       drawRoundedRect(this.xPosition, this.yPosition, this.width, this.height, 3, a);
/*     */       
/* 105 */       FontUtil.renderCenteredString(this.displayString, this.xPosition + this.width / 2, this.yPosition + (this.height - 12) / 2, j, 1.05F);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static File getFolder(String toggle) {
/* 112 */     File file = new File(FileManager.MODS_DIR, toggle);
/* 113 */     file.mkdirs();
/* 114 */     return file;
/*     */   }
/*     */   
/*     */   public static void save(String toggle, Boolean b) {
/* 118 */     FileManager.writeJsonToFile(new File(getFolder(toggle), "Toggle.json"), b);
/*     */   }
/*     */   public static Boolean load(String toggle) {
/* 121 */     Boolean b = (Boolean)FileManager.readFromJson(new File(getFolder(toggle), "Toggle.json"), Boolean.class);
/*     */     
/* 123 */     if (b == null) {
/* 124 */       b = Boolean.valueOf(true);
/* 125 */       save(toggle, b);
/*     */     } 
/* 127 */     return b;
/*     */   }
/*     */   
/*     */   private void drawRoundedRect(int x, int y, int width, int height, int cornerRadius, Color color) {
/* 131 */     drawRect(x, y + cornerRadius, x + cornerRadius, y + height - cornerRadius, color.getRGB());
/* 132 */     drawRect(x + cornerRadius, y, x + width - cornerRadius, y + height, color.getRGB());
/* 133 */     drawRect(x + width - cornerRadius, y + cornerRadius, x + width, y + height - cornerRadius, color.getRGB());
/* 134 */     drawArc(x + cornerRadius, y + cornerRadius, cornerRadius, 0, 90, color);
/* 135 */     drawArc(x + width - cornerRadius, y + cornerRadius, cornerRadius, 270, 360, color);
/* 136 */     drawArc(x + width - cornerRadius, y + height - cornerRadius, cornerRadius, 180, 270, color);
/* 137 */     drawArc(x + cornerRadius, y + height - cornerRadius, cornerRadius, 90, 180, color);
/*     */   }
/*     */   
/*     */   private void drawBackgroundRect(int x, int y, int width, int height, int cornerRadius, Color color) {
/* 141 */     NewRoundedRect.drawRoundedRect(x, y, x, y, cornerRadius, cornerRadius);
/*     */   }
/*     */   
/*     */   private void drawArc(int x, int y, int radius, int startAngle, int endAngle, Color color) {
/* 145 */     GL11.glPushMatrix();
/* 146 */     GL11.glEnable(3042);
/* 147 */     GL11.glDisable(3553);
/* 148 */     GL11.glBlendFunc(770, 771);
/* 149 */     GL11.glColor4f(color.getRed() / 255.0F, color.getGreen() / 255.0F, color.getBlue() / 255.0F, color.getAlpha() / 255.0F);
/*     */     
/* 151 */     WorldRenderer worldRenderer = Tessellator.getInstance().getWorldRenderer();
/*     */     
/* 153 */     worldRenderer.begin(6, DefaultVertexFormats.POSITION);
/* 154 */     worldRenderer.pos(x, y, 0.0D).endVertex();
/*     */     
/* 156 */     for (int i = (int)(startAngle / 360.0D * 100.0D); i <= (int)(endAngle / 360.0D * 100.0D); i++) {
/* 157 */       double angle = 6.283185307179586D * i / 100.0D + Math.toRadians(180.0D);
/* 158 */       worldRenderer.pos(x + Math.sin(angle) * radius, y + Math.cos(angle) * radius, 0.0D).endVertex();
/*     */     } 
/*     */     
/* 161 */     Tessellator.getInstance().draw();
/*     */     
/* 163 */     GL11.glEnable(3553);
/* 164 */     GL11.glDisable(3042);
/* 165 */     GL11.glPopMatrix();
/*     */   }
/*     */   
/*     */   private void drawCircle(int x, int y, int width, int height, Color color) {
/* 169 */     drawArc(x + width / 2, y + height / 2, width / 2, 0, 360, color);
/*     */   }
/*     */ }


/* Location:              C:\Users\Lenovo\Downloads\ZyrexClientV1 (1).jar!\ZyrexClient\clickgui\RoundedButtons\ButtonMainMenu.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */