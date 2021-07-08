/*     */ package ZyrexClient.clickgui.RoundedButtons;
/*     */ 
/*     */ import ZyrexClient.FileManager;
/*     */ import ZyrexClient.NewRoundedRect;
/*     */ import java.awt.Color;
/*     */ import java.io.File;
/*     */ import net.minecraft.client.Minecraft;
/*     */ import net.minecraft.client.gui.FontRenderer;
/*     */ import net.minecraft.client.gui.Gui;
/*     */ import net.minecraft.client.gui.GuiButton;
/*     */ import net.minecraft.client.renderer.GlStateManager;
/*     */ import net.minecraft.client.renderer.Tessellator;
/*     */ import net.minecraft.client.renderer.WorldRenderer;
/*     */ import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
/*     */ import net.minecraft.util.ResourceLocation;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ClientRoundedLanguageButton
/*     */   extends GuiButton
/*     */ {
/*     */   private int j6;
/*     */   private int j10;
/*     */   int fade;
/*     */   int fade2;
/*     */   
/*     */   public ClientRoundedLanguageButton(int i, int j, int k, String s) {
/*  30 */     this(i, j, k, 120, k, s);
/*     */   }
/*     */ 
/*     */   
/*     */   public ClientRoundedLanguageButton(int i, int j, int k, int l, int i1, String s) {
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
/*  62 */     int j = -1;
/*  63 */     if (this.hovered) {
/*  64 */       j = 35071;
/*     */     }
/*  66 */     if (!this.hovered) {
/*  67 */       this.fade = 230;
/*     */     } else {
/*     */       
/*  70 */       if (this.fade <= 50) {
/*     */         return;
/*     */       }
/*  73 */       if (this.fade != 160) {
/*  74 */         this.fade -= 10;
/*     */       }
/*     */     } 
/*     */     
/*  78 */     if (!this.hovered) {
/*  79 */       this.fade2 = 200;
/*     */     } else {
/*     */       
/*  82 */       if (this.fade2 <= 30) {
/*     */         return;
/*     */       }
/*  85 */       if (this.fade2 != 200) {
/*  86 */         this.fade2 += 10;
/*     */       }
/*     */     } 
/*     */     
/*  90 */     float b = (this.hovered ? (new Color(30, 30, 30, 100)).getRGB() : (new Color(30, 30, 30, 30)).getRGB());
/*  91 */     Color a = new Color(15, 15, 15, this.fade);
/*  92 */     Color a2 = new Color(100, 100, 100, this.fade2);
/*  93 */     Color a3 = new Color(80, 80, 80, this.fade);
/*     */     
/*  95 */     if (this.xPosition >= this.xPosition && this.yPosition >= this.yPosition && this.xPosition < this.xPosition + this.width && this.yPosition < this.yPosition + this.height) {
/*  96 */       int n = 5;
/*     */       
/*  98 */       FontRenderer fr = mc.fontRendererObj;
/*  99 */       this.hovered = (mouseX >= this.xPosition && mouseY >= this.yPosition && mouseX < this.xPosition + this.width && mouseY < this.yPosition + this.height);
/* 100 */       drawRoundedRect(this.xPosition - 1, this.yPosition - 1, this.width + 2, this.height + 2, 3, a2);
/* 101 */       drawRoundedRect(this.xPosition, this.yPosition, this.width, this.height, 3, a3);
/* 102 */       drawRoundedRect(this.xPosition, this.yPosition, this.width, this.height, 3, a);
/*     */       
/* 104 */       GlStateManager.color(1.0F, 1.0F, 1.0F);
/* 105 */       Minecraft.getMinecraft().getTextureManager().bindTexture(new ResourceLocation("language_icon.png"));
/* 106 */       Gui.drawModalRectWithCustomSizedTexture(this.xPosition + 2, this.yPosition + 2, 0.0F, 0.0F, 16, 16, 16.0F, 16.0F);
/*     */       
/* 108 */       drawCenteredString(fr, this.displayString, this.xPosition + this.width / 2, this.yPosition + (this.height - 8) / 2, j);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public static File getFolder(String toggle) {
/* 114 */     File file = new File(FileManager.MODS_DIR, toggle);
/* 115 */     file.mkdirs();
/* 116 */     return file;
/*     */   }
/*     */   
/*     */   public static void save(String toggle, Boolean b) {
/* 120 */     FileManager.writeJsonToFile(new File(getFolder(toggle), "Toggle.json"), b);
/*     */   }
/*     */   public static Boolean load(String toggle) {
/* 123 */     Boolean b = (Boolean)FileManager.readFromJson(new File(getFolder(toggle), "Toggle.json"), Boolean.class);
/*     */     
/* 125 */     if (b == null) {
/* 126 */       b = Boolean.valueOf(true);
/* 127 */       save(toggle, b);
/*     */     } 
/* 129 */     return b;
/*     */   }
/*     */   
/*     */   private void drawRoundedRect(int x, int y, int width, int height, int cornerRadius, Color color) {
/* 133 */     drawRect(x, y + cornerRadius, x + cornerRadius, y + height - cornerRadius, color.getRGB());
/* 134 */     drawRect(x + cornerRadius, y, x + width - cornerRadius, y + height, color.getRGB());
/* 135 */     drawRect(x + width - cornerRadius, y + cornerRadius, x + width, y + height - cornerRadius, color.getRGB());
/* 136 */     drawArc(x + cornerRadius, y + cornerRadius, cornerRadius, 0, 90, color);
/* 137 */     drawArc(x + width - cornerRadius, y + cornerRadius, cornerRadius, 270, 360, color);
/* 138 */     drawArc(x + width - cornerRadius, y + height - cornerRadius, cornerRadius, 180, 270, color);
/* 139 */     drawArc(x + cornerRadius, y + height - cornerRadius, cornerRadius, 90, 180, color);
/*     */   }
/*     */   
/*     */   private void drawBackgroundRect(int x, int y, int width, int height, int cornerRadius, Color color) {
/* 143 */     NewRoundedRect.drawRoundedRect(x, y, x, y, cornerRadius, cornerRadius);
/*     */   }
/*     */   
/*     */   private void drawArc(int x, int y, int radius, int startAngle, int endAngle, Color color) {
/* 147 */     GL11.glPushMatrix();
/* 148 */     GL11.glEnable(3042);
/* 149 */     GL11.glDisable(3553);
/* 150 */     GL11.glBlendFunc(770, 771);
/* 151 */     GL11.glColor4f(color.getRed() / 255.0F, color.getGreen() / 255.0F, color.getBlue() / 255.0F, color.getAlpha() / 255.0F);
/*     */     
/* 153 */     WorldRenderer worldRenderer = Tessellator.getInstance().getWorldRenderer();
/*     */     
/* 155 */     worldRenderer.begin(6, DefaultVertexFormats.POSITION);
/* 156 */     worldRenderer.pos(x, y, 0.0D).endVertex();
/*     */     
/* 158 */     for (int i = (int)(startAngle / 360.0D * 100.0D); i <= (int)(endAngle / 360.0D * 100.0D); i++) {
/* 159 */       double angle = 6.283185307179586D * i / 100.0D + Math.toRadians(180.0D);
/* 160 */       worldRenderer.pos(x + Math.sin(angle) * radius, y + Math.cos(angle) * radius, 0.0D).endVertex();
/*     */     } 
/*     */     
/* 163 */     Tessellator.getInstance().draw();
/*     */     
/* 165 */     GL11.glEnable(3553);
/* 166 */     GL11.glDisable(3042);
/* 167 */     GL11.glPopMatrix();
/*     */   }
/*     */   
/*     */   private void drawCircle(int x, int y, int width, int height, Color color) {
/* 171 */     drawArc(x + width / 2, y + height / 2, width / 2, 0, 360, color);
/*     */   }
/*     */ }


/* Location:              C:\Users\Lenovo\Downloads\ZyrexClientV1 (1).jar!\ZyrexClient\clickgui\RoundedButtons\ClientRoundedLanguageButton.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */