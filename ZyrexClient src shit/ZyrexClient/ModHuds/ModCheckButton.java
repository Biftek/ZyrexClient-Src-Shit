/*     */ package ZyrexClient.ModHuds;
/*     */ 
/*     */ import ZyrexClient.FileManager;
/*     */ import ZyrexClient.NewRoundedRect;
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
/*     */ public class ModCheckButton
/*     */   extends GuiButton
/*     */ {
/*     */   public boolean checked;
/*     */   private static final String X = "X";
/*     */   private static final String CHECK = "E P i K";
/*  25 */   private static final Color X_COLOR = Color.RED;
/*  26 */   private static final Color CHECK_COLOR = Color.GREEN;
/*  27 */   private static String text = "";
/*     */   
/*  29 */   Color off = new Color(-4342339);
/*  30 */   Color on = new Color(-16711936);
/*  31 */   Color c = new Color(-1);
/*     */   
/*     */   public ModCheckButton(int buttonId, int x, int y, String s) {
/*  34 */     this(buttonId, x, y, false, s);
/*     */   }
/*     */   int fade;
/*     */   public ModCheckButton(int buttonId, int x, int y, boolean checked, String s) {
/*  38 */     this(buttonId, x, y, 20, 20, checked, s);
/*     */   }
/*     */   
/*     */   public ModCheckButton(int buttonId, int x, int y, int width, int height, String s) {
/*  42 */     this(buttonId, x, y, width, height, false, s);
/*     */   }
/*     */   
/*     */   public ModCheckButton(int buttonId, int x, int y, int width, int height, boolean checked, String s) {
/*  46 */     super(buttonId, x, y, width, height, s);
/*  47 */     this.checked = checked;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void drawButton(Minecraft mc, int mouseX, int mouseY) {
/*  53 */     GlStateManager.color(1.0F, 1.0F, 1.0F);
/*  54 */     this.hovered = (mouseX >= this.xPosition && mouseY >= this.yPosition && mouseX < this.xPosition + this.width && mouseY < this.yPosition + this.height);
/*  55 */     if (load(this.displayString).booleanValue()) {
/*  56 */       GlStateManager.color(1.0F, 1.0F, 1.0F);
/*  57 */       drawRoundedRect(this.xPosition, this.yPosition, this.width, this.height, this.height / 2 - 6, new Color(255, 74, 74));
/*     */       
/*  59 */       FontUtil.renderString(this.displayString, this.xPosition + this.width / 2 + 13, this.yPosition + (this.height - 11) / 2, (new Color(255, 255, 255)).getRGB(), 1.0F);
/*  60 */       FontUtil.renderCenteredString("Off", this.xPosition + this.width / 2 - 1, this.yPosition + (this.height - 10) / 2, (new Color(255, 255, 255)).getRGB(), 1.0F);
/*     */     } else {
/*  62 */       drawRoundedRect(this.xPosition, this.yPosition, this.width, this.height, this.height / 2 - 6, new Color(22, 105, 245));
/*     */       
/*  64 */       FontUtil.renderString(this.displayString, this.xPosition + this.width / 2 + 13, this.yPosition + (this.height - 11) / 2, (new Color(255, 255, 255)).getRGB(), 1.0F);
/*  65 */       FontUtil.renderCenteredString("On", this.xPosition + this.width / 2 - 1, this.yPosition + (this.height - 10) / 2, (new Color(255, 255, 255)).getRGB(), 1.0F);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean mousePressed(Minecraft mc, int mouseX, int mouseY) {
/*  73 */     if (super.mousePressed(mc, mouseX, mouseY)) {
/*  74 */       this.checked = !this.checked;
/*  75 */       return true;
/*     */     } 
/*     */     
/*  78 */     System.out.println();
/*     */     
/*  80 */     return false;
/*     */   }
/*     */   
/*     */   public boolean isChecked() {
/*  84 */     return this.checked;
/*     */   }
/*     */   
/*     */   public void setChecked(boolean checked) {
/*  88 */     this.checked = checked;
/*     */   }
/*     */ 
/*     */   
/*     */   public static File getFolder(String toggle) {
/*  93 */     File file = new File(FileManager.BUTTON_DIR, toggle);
/*  94 */     file.mkdirs();
/*  95 */     return file;
/*     */   }
/*     */   
/*     */   public static void save(String toggle, Boolean b) {
/*  99 */     FileManager.writeJsonToFile(new File(getFolder(toggle), "Toggle.json"), b);
/*     */   }
/*     */   public static Boolean load(String toggle) {
/* 102 */     Boolean b = (Boolean)FileManager.readFromJson(new File(getFolder(toggle), "Toggle.json"), Boolean.class);
/*     */     
/* 104 */     if (b == null) {
/* 105 */       b = Boolean.valueOf(true);
/* 106 */       save(toggle, b);
/*     */     } 
/* 108 */     return b;
/*     */   }
/*     */   
/*     */   private void drawRoundedRect(int x, int y, int width, int height, int cornerRadius, Color color) {
/* 112 */     drawRect(x, y + cornerRadius, x + cornerRadius, y + height - cornerRadius, color.getRGB());
/* 113 */     drawRect(x + cornerRadius, y, x + width - cornerRadius, y + height, color.getRGB());
/* 114 */     drawRect(x + width - cornerRadius, y + cornerRadius, x + width, y + height - cornerRadius, color.getRGB());
/* 115 */     drawArc(x + cornerRadius, y + cornerRadius, cornerRadius, 0, 90, color);
/* 116 */     drawArc(x + width - cornerRadius, y + cornerRadius, cornerRadius, 270, 360, color);
/* 117 */     drawArc(x + width - cornerRadius, y + height - cornerRadius, cornerRadius, 180, 270, color);
/* 118 */     drawArc(x + cornerRadius, y + height - cornerRadius, cornerRadius, 90, 180, color);
/*     */   }
/*     */   
/*     */   private void drawBackgroundRect(int x, int y, int width, int height, int cornerRadius, Color color) {
/* 122 */     NewRoundedRect.drawRoundedRect(x, y, x, y, cornerRadius, cornerRadius);
/*     */   }
/*     */   
/*     */   private void drawArc(int x, int y, int radius, int startAngle, int endAngle, Color color) {
/* 126 */     GL11.glPushMatrix();
/* 127 */     GL11.glEnable(3042);
/* 128 */     GL11.glDisable(3553);
/* 129 */     GL11.glBlendFunc(770, 771);
/* 130 */     GL11.glColor4f(color.getRed() / 255.0F, color.getGreen() / 255.0F, color.getBlue() / 255.0F, color.getAlpha() / 255.0F);
/*     */     
/* 132 */     WorldRenderer worldRenderer = Tessellator.getInstance().getWorldRenderer();
/*     */     
/* 134 */     worldRenderer.begin(6, DefaultVertexFormats.POSITION);
/* 135 */     worldRenderer.pos(x, y, 0.0D).endVertex();
/*     */     
/* 137 */     for (int i = (int)(startAngle / 360.0D * 100.0D); i <= (int)(endAngle / 360.0D * 100.0D); i++) {
/* 138 */       double angle = 6.283185307179586D * i / 100.0D + Math.toRadians(180.0D);
/* 139 */       worldRenderer.pos(x + Math.sin(angle) * radius, y + Math.cos(angle) * radius, 0.0D).endVertex();
/*     */     } 
/*     */     
/* 142 */     Tessellator.getInstance().draw();
/*     */     
/* 144 */     GL11.glEnable(3553);
/* 145 */     GL11.glDisable(3042);
/* 146 */     GL11.glPopMatrix();
/*     */   }
/*     */   
/*     */   private void drawCircle(int x, int y, int width, int height, Color color) {
/* 150 */     drawArc(x + width / 2, y + height / 2, width / 2, 0, 360, color);
/*     */   }
/*     */ }


/* Location:              C:\Users\Lenovo\Downloads\ZyrexClientV1 (1).jar!\ZyrexClient\ModHuds\ModCheckButton.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */