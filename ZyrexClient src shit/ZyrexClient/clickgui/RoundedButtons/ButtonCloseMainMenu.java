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
/*     */ public class ButtonCloseMainMenu
/*     */   extends GuiButton
/*     */ {
/*     */   private int j6;
/*     */   private int j10;
/*     */   int fade;
/*     */   int fade2;
/*     */   int color2;
/*     */   
/*     */   public ButtonCloseMainMenu(int i, int j, int k, String s) {
/*  30 */     this(i, j, k, 120, k, s);
/*     */   }
/*     */ 
/*     */   
/*     */   public ButtonCloseMainMenu(int i, int j, int k, int l, int i1, String s) {
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
/*     */   
/*     */   public void drawButton(Minecraft mc, int mouseX, int mouseY) {
/*  62 */     this.hovered = (mouseX >= this.xPosition && mouseY >= this.yPosition && mouseX < this.xPosition + this.width && mouseY < this.yPosition + this.height);
/*  63 */     int j = -1;
/*  64 */     if (this.hovered) {
/*  65 */       j = 35071;
/*     */     }
/*  67 */     if (!this.hovered) {
/*  68 */       this.fade = 200;
/*     */     } else {
/*     */       
/*  71 */       if (this.fade <= 30) {
/*     */         return;
/*     */       }
/*  74 */       if (this.fade != 230) {
/*  75 */         this.fade += 5;
/*     */       }
/*     */     } 
/*     */     
/*  79 */     if (!this.hovered) {
/*  80 */       this.fade2 = 10;
/*     */     } else {
/*     */       
/*  83 */       if (this.fade2 <= 0) {
/*     */         return;
/*     */       }
/*  86 */       if (this.fade2 != 200) {
/*  87 */         this.fade2 += 10;
/*     */       }
/*     */     } 
/*     */     
/*  91 */     float b = (this.hovered ? (new Color(30, 30, 30, 100)).getRGB() : (new Color(30, 30, 30, 30)).getRGB());
/*  92 */     Color a = new Color(255, 100, 100, this.fade);
/*  93 */     Color a2 = new Color(255, 0, 0, this.fade2);
/*     */     
/*  95 */     if (this.xPosition >= this.xPosition && this.yPosition >= this.yPosition && this.xPosition < this.xPosition + this.width && this.yPosition < this.yPosition + this.height) {
/*  96 */       int n = 5;
/*     */       
/*  98 */       FontRenderer fr = mc.fontRendererObj;
/*  99 */       this.hovered = (mouseX >= this.xPosition && mouseY >= this.yPosition && mouseX < this.xPosition + this.width && mouseY < this.yPosition + this.height);
/* 100 */       drawRoundedRect(this.xPosition - 1, this.yPosition - 1, this.width + 2, this.height + 2, 2, a2);
/* 101 */       drawRoundedRect(this.xPosition, this.yPosition, this.width, this.height, 2, a);
/*     */       
/* 103 */       GlStateManager.color(1.0F, 1.0F, 1.0F);
/* 104 */       Minecraft.getMinecraft().getTextureManager().bindTexture(new ResourceLocation("quit_icon.png"));
/* 105 */       Gui.drawModalRectWithCustomSizedTexture(this.xPosition + 2, this.yPosition + 1, 0.0F, 0.0F, 14, 14, 14.0F, 14.0F);
/*     */       
/* 107 */       drawCenteredString(fr, this.displayString, this.xPosition + this.width / 2, this.yPosition + (this.height - 8) / 2, j);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public static File getFolder(String toggle) {
/* 113 */     File file = new File(FileManager.MODS_DIR, toggle);
/* 114 */     file.mkdirs();
/* 115 */     return file;
/*     */   }
/*     */   
/*     */   public static void save(String toggle, Boolean b) {
/* 119 */     FileManager.writeJsonToFile(new File(getFolder(toggle), "Toggle.json"), b);
/*     */   }
/*     */   public static Boolean load(String toggle) {
/* 122 */     Boolean b = (Boolean)FileManager.readFromJson(new File(getFolder(toggle), "Toggle.json"), Boolean.class);
/*     */     
/* 124 */     if (b == null) {
/* 125 */       b = Boolean.valueOf(true);
/* 126 */       save(toggle, b);
/*     */     } 
/* 128 */     return b;
/*     */   }
/*     */   
/*     */   private void drawRoundedRect(int x, int y, int width, int height, int cornerRadius, Color color) {
/* 132 */     drawRect(x, y + cornerRadius, x + cornerRadius, y + height - cornerRadius, color.getRGB());
/* 133 */     drawRect(x + cornerRadius, y, x + width - cornerRadius, y + height, color.getRGB());
/* 134 */     drawRect(x + width - cornerRadius, y + cornerRadius, x + width, y + height - cornerRadius, color.getRGB());
/* 135 */     drawArc(x + cornerRadius, y + cornerRadius, cornerRadius, 0, 90, color);
/* 136 */     drawArc(x + width - cornerRadius, y + cornerRadius, cornerRadius, 270, 360, color);
/* 137 */     drawArc(x + width - cornerRadius, y + height - cornerRadius, cornerRadius, 180, 270, color);
/* 138 */     drawArc(x + cornerRadius, y + height - cornerRadius, cornerRadius, 90, 180, color);
/*     */   }
/*     */   
/*     */   private void drawBackgroundRect(int x, int y, int width, int height, int cornerRadius, Color color) {
/* 142 */     NewRoundedRect.drawRoundedRect(x, y, x, y, cornerRadius, cornerRadius);
/*     */   }
/*     */   
/*     */   private void drawArc(int x, int y, int radius, int startAngle, int endAngle, Color color) {
/* 146 */     GL11.glPushMatrix();
/* 147 */     GL11.glEnable(3042);
/* 148 */     GL11.glDisable(3553);
/* 149 */     GL11.glBlendFunc(770, 771);
/* 150 */     GL11.glColor4f(color.getRed() / 255.0F, color.getGreen() / 255.0F, color.getBlue() / 255.0F, color.getAlpha() / 255.0F);
/*     */     
/* 152 */     WorldRenderer worldRenderer = Tessellator.getInstance().getWorldRenderer();
/*     */     
/* 154 */     worldRenderer.begin(6, DefaultVertexFormats.POSITION);
/* 155 */     worldRenderer.pos(x, y, 0.0D).endVertex();
/*     */     
/* 157 */     for (int i = (int)(startAngle / 360.0D * 100.0D); i <= (int)(endAngle / 360.0D * 100.0D); i++) {
/* 158 */       double angle = 6.283185307179586D * i / 100.0D + Math.toRadians(180.0D);
/* 159 */       worldRenderer.pos(x + Math.sin(angle) * radius, y + Math.cos(angle) * radius, 0.0D).endVertex();
/*     */     } 
/*     */     
/* 162 */     Tessellator.getInstance().draw();
/*     */     
/* 164 */     GL11.glEnable(3553);
/* 165 */     GL11.glDisable(3042);
/* 166 */     GL11.glPopMatrix();
/*     */   }
/*     */   
/*     */   private void drawCircle(int x, int y, int width, int height, Color color) {
/* 170 */     drawArc(x + width / 2, y + height / 2, width / 2, 0, 360, color);
/*     */   }
/*     */ }


/* Location:              C:\Users\Lenovo\Downloads\ZyrexClientV1 (1).jar!\ZyrexClient\clickgui\RoundedButtons\ButtonCloseMainMenu.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */