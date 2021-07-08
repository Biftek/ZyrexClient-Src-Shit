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
/*     */ public class SettingsButtonToggle
/*     */   extends GuiButton
/*     */ {
/*     */   public boolean checked;
/*     */   private static final String X = "DISABLED";
/*     */   private static final String CHECK = "ENABLED";
/*  24 */   private static final Color X_COLOR = Color.RED;
/*  25 */   private static final Color CHECK_COLOR = Color.GREEN;
/*     */   
/*  27 */   Color off = new Color(-4342339);
/*  28 */   Color on = new Color(-16711936);
/*  29 */   Color c = new Color(-1);
/*     */   
/*     */   public SettingsButtonToggle(int buttonId, int x, int y, String s) {
/*  32 */     this(buttonId, x, y, false, s);
/*     */   }
/*     */   
/*     */   public SettingsButtonToggle(int buttonId, int x, int y, boolean checked, String s) {
/*  36 */     this(buttonId, x, y, 20, 20, checked, s);
/*     */   }
/*     */   
/*     */   public SettingsButtonToggle(int buttonId, int x, int y, int width, int height, String s) {
/*  40 */     this(buttonId, x, y, width, height, false, s);
/*     */   }
/*     */   
/*     */   public SettingsButtonToggle(int buttonId, int x, int y, int width, int height, boolean checked, String s) {
/*  44 */     super(buttonId, x, y, width, height, s);
/*  45 */     this.checked = checked;
/*     */   }
/*     */ 
/*     */   
/*     */   public void drawButton(Minecraft mc, int mouseX, int mouseY) {
/*  50 */     GlStateManager.color(1.0F, 1.0F, 1.0F);
/*  51 */     if (load(this.displayString).booleanValue()) {
/*  52 */       GlStateManager.color(1.0F, 1.0F, 1.0F);
/*  53 */       drawRoundedRect(this.xPosition, this.yPosition, this.width, this.height, this.height / 2 - 2, new Color(255, 74, 74));
/*     */       
/*  55 */       FontUtil.renderString("DISABLED", this.xPosition + this.width / 2 - 23, this.yPosition + (this.height - 11) / 2, (new Color(255, 255, 255)).getRGB(), 1.0F);
/*     */     } else {
/*  57 */       drawRoundedRect(this.xPosition, this.yPosition, this.width, this.height, this.height / 2 - 2, new Color(22, 105, 245));
/*     */       
/*  59 */       FontUtil.renderString("ENABLED", this.xPosition + this.width / 2 - 22, this.yPosition + (this.height - 11) / 2, (new Color(255, 255, 255)).getRGB(), 1.0F);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean mousePressed(Minecraft mc, int mouseX, int mouseY) {
/*  67 */     if (super.mousePressed(mc, mouseX, mouseY)) {
/*  68 */       this.checked = !this.checked;
/*  69 */       return true;
/*     */     } 
/*     */     
/*  72 */     System.out.println();
/*     */     
/*  74 */     return false;
/*     */   }
/*     */   
/*     */   public boolean isChecked() {
/*  78 */     return this.checked;
/*     */   }
/*     */   
/*     */   public void setChecked(boolean checked) {
/*  82 */     this.checked = checked;
/*     */   }
/*     */ 
/*     */   
/*     */   public static File getFolder(String toggle) {
/*  87 */     File file = new File(FileManager.BUTTON_DIR, toggle);
/*  88 */     file.mkdirs();
/*  89 */     return file;
/*     */   }
/*     */   
/*     */   public static void save(String toggle, Boolean b) {
/*  93 */     FileManager.writeJsonToFile(new File(getFolder(toggle), "Toggle.json"), b);
/*     */   }
/*     */   public static Boolean load(String toggle) {
/*  96 */     Boolean b = (Boolean)FileManager.readFromJson(new File(getFolder(toggle), "Toggle.json"), Boolean.class);
/*     */     
/*  98 */     if (b == null) {
/*  99 */       b = Boolean.valueOf(true);
/* 100 */       save(toggle, b);
/*     */     } 
/* 102 */     return b;
/*     */   }
/*     */   
/*     */   private void drawRoundedRect(int x, int y, int width, int height, int cornerRadius, Color color) {
/* 106 */     drawRect(x, y + cornerRadius, x + cornerRadius, y + height - cornerRadius, color.getRGB());
/* 107 */     drawRect(x + cornerRadius, y, x + width - cornerRadius, y + height, color.getRGB());
/* 108 */     drawRect(x + width - cornerRadius, y + cornerRadius, x + width, y + height - cornerRadius, color.getRGB());
/* 109 */     drawArc(x + cornerRadius, y + cornerRadius, cornerRadius, 0, 90, color);
/* 110 */     drawArc(x + width - cornerRadius, y + cornerRadius, cornerRadius, 270, 360, color);
/* 111 */     drawArc(x + width - cornerRadius, y + height - cornerRadius, cornerRadius, 180, 270, color);
/* 112 */     drawArc(x + cornerRadius, y + height - cornerRadius, cornerRadius, 90, 180, color);
/*     */   }
/*     */   
/*     */   private void drawBackgroundRect(int x, int y, int width, int height, int cornerRadius, Color color) {
/* 116 */     NewRoundedRect.drawRoundedRect(x, y, x, y, cornerRadius, cornerRadius);
/*     */   }
/*     */   
/*     */   private void drawArc(int x, int y, int radius, int startAngle, int endAngle, Color color) {
/* 120 */     GL11.glPushMatrix();
/* 121 */     GL11.glEnable(3042);
/* 122 */     GL11.glDisable(3553);
/* 123 */     GL11.glBlendFunc(770, 771);
/* 124 */     GL11.glColor4f(color.getRed() / 255.0F, color.getGreen() / 255.0F, color.getBlue() / 255.0F, color.getAlpha() / 255.0F);
/*     */     
/* 126 */     WorldRenderer worldRenderer = Tessellator.getInstance().getWorldRenderer();
/*     */     
/* 128 */     worldRenderer.begin(6, DefaultVertexFormats.POSITION);
/* 129 */     worldRenderer.pos(x, y, 0.0D).endVertex();
/*     */     
/* 131 */     for (int i = (int)(startAngle / 360.0D * 100.0D); i <= (int)(endAngle / 360.0D * 100.0D); i++) {
/* 132 */       double angle = 6.283185307179586D * i / 100.0D + Math.toRadians(180.0D);
/* 133 */       worldRenderer.pos(x + Math.sin(angle) * radius, y + Math.cos(angle) * radius, 0.0D).endVertex();
/*     */     } 
/*     */     
/* 136 */     Tessellator.getInstance().draw();
/*     */     
/* 138 */     GL11.glEnable(3553);
/* 139 */     GL11.glDisable(3042);
/* 140 */     GL11.glPopMatrix();
/*     */   }
/*     */   
/*     */   private void drawCircle(int x, int y, int width, int height, Color color) {
/* 144 */     drawArc(x + width / 2, y + height / 2, width / 2, 0, 360, color);
/*     */   }
/*     */ }


/* Location:              C:\Users\Lenovo\Downloads\ZyrexClientV1 (1).jar!\ZyrexClient\ModHuds\SettingsButtonToggle.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */