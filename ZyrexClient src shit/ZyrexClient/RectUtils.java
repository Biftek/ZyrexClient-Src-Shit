/*     */ package ZyrexClient;
/*     */ 
/*     */ import java.awt.Color;
/*     */ import net.minecraft.client.Minecraft;
/*     */ import net.minecraft.client.gui.Gui;
/*     */ import net.minecraft.client.renderer.GlStateManager;
/*     */ import net.minecraft.client.renderer.Tessellator;
/*     */ import net.minecraft.client.renderer.WorldRenderer;
/*     */ import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ 
/*     */ public class RectUtils
/*     */   extends Gui
/*     */ {
/*     */   public static RectUtils instance;
/*  16 */   private static final Minecraft mc = Minecraft.getMinecraft();
/*     */   
/*     */   public RectUtils() {
/*  19 */     instance = this;
/*     */   }
/*     */   
/*     */   public static int drawString(String text, float x, float y, int color, boolean shadow) {
/*  23 */     GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
/*  24 */     return mc.fontRendererObj.drawString(text, x, y, color, shadow);
/*     */   }
/*     */   
/*     */   public static int drawString(String text, int x, int y) {
/*  28 */     GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
/*  29 */     return drawString(text, x, y, 16777215);
/*     */   }
/*     */   
/*     */   public static int drawString(String text, int x, int y, boolean shadow) {
/*  33 */     GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
/*  34 */     return drawString(text, x, y, 16777215, shadow);
/*     */   }
/*     */   
/*     */   public static int drawString(String text, int x, int y, int color) {
/*  38 */     GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
/*  39 */     return drawString(text, x, y, color, false);
/*     */   }
/*     */   
/*     */   public static int drawString(String text, int x, int y, int color, boolean shadow) {
/*  43 */     GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
/*  44 */     String[] lines = text.split("\n");
/*  45 */     if (lines.length > 1) {
/*  46 */       int j = 0;
/*  47 */       for (int i = 0; i < lines.length; i++)
/*  48 */         j += mc.fontRendererObj.drawString(lines[i], x, (y + i * (mc.fontRendererObj.FONT_HEIGHT + 2)), color, shadow); 
/*  49 */       return j;
/*     */     } 
/*  51 */     return mc.fontRendererObj.drawString(text, x, y, color, shadow);
/*     */   }
/*     */   
/*     */   public static int drawScaledString(String text, int x, int y, boolean shadow, float scale) {
/*  55 */     GlStateManager.pushMatrix();
/*  56 */     GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
/*  57 */     GlStateManager.scale(scale, scale, 1.0F);
/*  58 */     int i = drawString(text, (int)(x / scale), (int)(y / scale), shadow);
/*  59 */     GlStateManager.scale(Math.pow(scale, -1.0D), Math.pow(scale, -1.0D), 1.0D);
/*  60 */     GlStateManager.popMatrix();
/*  61 */     return i;
/*     */   }
/*     */   
/*     */   public static void drawChromaString(String textIn, int xIn, int y, boolean shadow) {
/*  65 */     GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
/*  66 */     for (int j = 0; j < (textIn.split("\n")).length; j++) {
/*  67 */       int x = xIn; byte b; int i; char[] arrayOfChar;
/*  68 */       for (i = (arrayOfChar = textIn.split("\n")[j].toCharArray()).length, b = 0; b < i; ) { char c = arrayOfChar[b];
/*  69 */         long l = System.currentTimeMillis() - x * 10L - (y - j * 10L) * 10L;
/*  70 */         float speed = 2000.0F;
/*  71 */         int color = Color.HSBtoRGB((float)(l % (int)speed) / speed, 0.8F, 0.8F);
/*  72 */         drawString(String.valueOf(c), x, y + j * (mc.fontRendererObj.FONT_HEIGHT + 2), color, shadow);
/*  73 */         x += mc.fontRendererObj.getStringWidth(String.valueOf(c));
/*     */         b++; }
/*     */     
/*     */     } 
/*     */   }
/*     */   public static int drawCenteredString(String text, int x, int y) {
/*  79 */     return drawString(text, x - mc.fontRendererObj.getStringWidth(text) / 2, y);
/*     */   }
/*     */   
/*     */   public static int drawCenteredString(String text, int x, int y, int color) {
/*  83 */     return drawString(text, x - mc.fontRendererObj.getStringWidth(text) / 2, y, color);
/*     */   }
/*     */   
/*     */   public static int drawCenteredString(String text, int x, int y, int color, boolean shadow) {
/*  87 */     return drawString(text, x - mc.fontRendererObj.getStringWidth(text) / 2, y, color, shadow);
/*     */   }
/*     */   
/*     */   public static int drawScaledCenteredString(String text, int x, int y, boolean shadow, float scale) {
/*  91 */     return drawScaledString(text, x - mc.fontRendererObj.getStringWidth(text) / 2, y, shadow, scale);
/*     */   }
/*     */   
/*     */   public static void drawRectOutline(int left, int top, int right, int bottom, int color) {
/*  95 */     drawRect(left - 1, top - 1, right + 1, top, color);
/*  96 */     drawRect(right, top, right + 1, bottom, color);
/*  97 */     drawRect(left - 1, bottom, right + 1, bottom + 1, color);
/*  98 */     drawRect(left - 1, top, left, bottom, color);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void drawGradientRect(int left, int top, int right, int bottom, int startColor, int endColor) {
/* 103 */     float f = (startColor >> 24 & 0xFF) / 255.0F;
/* 104 */     float f1 = (startColor >> 16 & 0xFF) / 255.0F;
/* 105 */     float f2 = (startColor >> 8 & 0xFF) / 255.0F;
/* 106 */     float f3 = (startColor & 0xFF) / 255.0F;
/* 107 */     float f4 = (endColor >> 24 & 0xFF) / 255.0F;
/* 108 */     float f5 = (endColor >> 16 & 0xFF) / 255.0F;
/* 109 */     float f6 = (endColor >> 8 & 0xFF) / 255.0F;
/* 110 */     float f7 = (endColor & 0xFF) / 255.0F;
/* 111 */     GlStateManager.disableTexture2D();
/* 112 */     GlStateManager.enableBlend();
/* 113 */     GlStateManager.disableAlpha();
/* 114 */     GlStateManager.tryBlendFuncSeparate(770, 771, 1, 0);
/* 115 */     GlStateManager.shadeModel(7425);
/* 116 */     Tessellator tessellator = Tessellator.getInstance();
/* 117 */     WorldRenderer worldrenderer = tessellator.getWorldRenderer();
/* 118 */     worldrenderer.begin(7, DefaultVertexFormats.POSITION_COLOR);
/* 119 */     worldrenderer.pos(right, top, zLevel).color(f1, f2, f3, f).endVertex();
/* 120 */     worldrenderer.pos(left, top, zLevel).color(f1, f2, f3, f).endVertex();
/* 121 */     worldrenderer.pos(left, bottom, zLevel).color(f5, f6, f7, f4).endVertex();
/* 122 */     worldrenderer.pos(right, bottom, zLevel).color(f5, f6, f7, f4).endVertex();
/* 123 */     tessellator.draw();
/* 124 */     GlStateManager.shadeModel(7424);
/* 125 */     GlStateManager.disableBlend();
/* 126 */     GlStateManager.enableAlpha();
/* 127 */     GlStateManager.enableTexture2D();
/*     */   }
/*     */   
/*     */   public static void drawRoundedRect(int paramInt1, int paramInt2, int paramInt3, int paramInt4, float radius, int color) {
/* 131 */     float f1 = (color >> 24 & 0xFF) / 255.0F;
/* 132 */     float f2 = (color >> 16 & 0xFF) / 255.0F;
/* 133 */     float f3 = (color >> 8 & 0xFF) / 255.0F;
/* 134 */     float f4 = (color & 0xFF) / 255.0F;
/* 135 */     GlStateManager.color(f2, f3, f4, f1);
/* 136 */     drawRoundedRect(paramInt1, paramInt2, paramInt3, paramInt4, radius);
/*     */   }
/*     */   
/*     */   public static void drawRoundedRect(float paramInt1, float paramInt2, float paramInt3, float paramInt4, float radius, int color) {
/* 140 */     float f1 = (color >> 24 & 0xFF) / 255.0F;
/* 141 */     float f2 = (color >> 16 & 0xFF) / 255.0F;
/* 142 */     float f3 = (color >> 8 & 0xFF) / 255.0F;
/* 143 */     float f4 = (color & 0xFF) / 255.0F;
/* 144 */     GlStateManager.color(f2, f3, f4, f1);
/* 145 */     drawRoundedRect(paramInt1, paramInt2, paramInt3, paramInt4, radius);
/*     */   }
/*     */   
/*     */   private static void drawRoundedRect(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5) {
/* 149 */     int i = 18;
/* 150 */     float f1 = 90.0F / i;
/* 151 */     GlStateManager.disableTexture2D();
/* 152 */     GlStateManager.enableBlend();
/* 153 */     GlStateManager.disableCull();
/* 154 */     GlStateManager.enableColorMaterial();
/* 155 */     GlStateManager.blendFunc(770, 771);
/* 156 */     GlStateManager.tryBlendFuncSeparate(770, 771, 1, 0);
/* 157 */     GL11.glBegin(5);
/* 158 */     GL11.glVertex2f(paramFloat1 + paramFloat5, paramFloat2);
/* 159 */     GL11.glVertex2f(paramFloat1 + paramFloat5, paramFloat4);
/* 160 */     GL11.glVertex2f(paramFloat3 - paramFloat5, paramFloat2);
/* 161 */     GL11.glVertex2f(paramFloat3 - paramFloat5, paramFloat4);
/* 162 */     GL11.glEnd();
/* 163 */     GL11.glBegin(5);
/* 164 */     GL11.glVertex2f(paramFloat1, paramFloat2 + paramFloat5);
/* 165 */     GL11.glVertex2f(paramFloat1 + paramFloat5, paramFloat2 + paramFloat5);
/* 166 */     GL11.glVertex2f(paramFloat1, paramFloat4 - paramFloat5);
/* 167 */     GL11.glVertex2f(paramFloat1 + paramFloat5, paramFloat4 - paramFloat5);
/* 168 */     GL11.glEnd();
/* 169 */     GL11.glBegin(5);
/* 170 */     GL11.glVertex2f(paramFloat3, paramFloat2 + paramFloat5);
/* 171 */     GL11.glVertex2f(paramFloat3 - paramFloat5, paramFloat2 + paramFloat5);
/* 172 */     GL11.glVertex2f(paramFloat3, paramFloat4 - paramFloat5);
/* 173 */     GL11.glVertex2f(paramFloat3 - paramFloat5, paramFloat4 - paramFloat5);
/* 174 */     GL11.glEnd();
/* 175 */     GL11.glBegin(6);
/* 176 */     float f2 = paramFloat3 - paramFloat5;
/* 177 */     float f3 = paramFloat2 + paramFloat5;
/* 178 */     GL11.glVertex2f(f2, f3);
/*     */     int j;
/* 180 */     for (j = 0; j <= i; j++) {
/* 181 */       float f4 = j * f1;
/* 182 */       GL11.glVertex2f((float)(f2 + paramFloat5 * Math.cos(Math.toRadians(f4))), (float)(f3 - paramFloat5 * Math.sin(Math.toRadians(f4))));
/*     */     } 
/* 184 */     GL11.glEnd();
/* 185 */     GL11.glBegin(6);
/* 186 */     f2 = paramFloat1 + paramFloat5;
/* 187 */     f3 = paramFloat2 + paramFloat5;
/* 188 */     GL11.glVertex2f(f2, f3);
/* 189 */     for (j = 0; j <= i; j++) {
/* 190 */       float f4 = j * f1;
/* 191 */       GL11.glVertex2f((float)(f2 - paramFloat5 * Math.cos(Math.toRadians(f4))), (float)(f3 - paramFloat5 * Math.sin(Math.toRadians(f4))));
/*     */     } 
/* 193 */     GL11.glEnd();
/* 194 */     GL11.glBegin(6);
/* 195 */     f2 = paramFloat1 + paramFloat5;
/* 196 */     f3 = paramFloat4 - paramFloat5;
/* 197 */     GL11.glVertex2f(f2, f3);
/* 198 */     for (j = 0; j <= i; j++) {
/* 199 */       float f4 = j * f1;
/* 200 */       GL11.glVertex2f((float)(f2 - paramFloat5 * Math.cos(Math.toRadians(f4))), (float)(f3 + paramFloat5 * Math.sin(Math.toRadians(f4))));
/*     */     } 
/* 202 */     GL11.glEnd();
/* 203 */     GL11.glBegin(6);
/* 204 */     f2 = paramFloat3 - paramFloat5;
/* 205 */     f3 = paramFloat4 - paramFloat5;
/* 206 */     GL11.glVertex2f(f2, f3);
/* 207 */     for (j = 0; j <= i; j++) {
/* 208 */       float f4 = j * f1;
/* 209 */       GL11.glVertex2f((float)(f2 + paramFloat5 * Math.cos(Math.toRadians(f4))), (float)(f3 + paramFloat5 * Math.sin(Math.toRadians(f4))));
/*     */     } 
/* 211 */     GL11.glEnd();
/* 212 */     GlStateManager.enableCull();
/* 213 */     GlStateManager.disableBlend();
/* 214 */     GlStateManager.disableColorMaterial();
/* 215 */     GlStateManager.enableTexture2D();
/*     */   }
/*     */   
/*     */   public static void drawRoundedOutline(int x, int y, int x2, int y2, float radius, float width, int color) {
/* 219 */     float f1 = (color >> 24 & 0xFF) / 255.0F;
/* 220 */     float f2 = (color >> 16 & 0xFF) / 255.0F;
/* 221 */     float f3 = (color >> 8 & 0xFF) / 255.0F;
/* 222 */     float f4 = (color & 0xFF) / 255.0F;
/* 223 */     GlStateManager.color(f2, f3, f4, f1);
/* 224 */     drawRoundedOutline(x, y, x2, y2, radius, width);
/*     */   }
/*     */   
/*     */   public static void drawRoundedOutline(float x, float y, float x2, float y2, float radius, float width) {
/* 228 */     int i = 18;
/* 229 */     int j = 90 / i;
/* 230 */     GlStateManager.disableTexture2D();
/* 231 */     GlStateManager.enableBlend();
/* 232 */     GlStateManager.disableCull();
/* 233 */     GlStateManager.enableColorMaterial();
/* 234 */     GlStateManager.blendFunc(770, 771);
/* 235 */     GlStateManager.tryBlendFuncSeparate(770, 771, 1, 0);
/* 236 */     if (width != 1.0F)
/* 237 */       GL11.glLineWidth(width); 
/* 238 */     GL11.glBegin(3);
/* 239 */     GL11.glVertex2f(x + radius, y);
/* 240 */     GL11.glVertex2f(x2 - radius, y);
/* 241 */     GL11.glEnd();
/* 242 */     GL11.glBegin(3);
/* 243 */     GL11.glVertex2f(x2, y + radius);
/* 244 */     GL11.glVertex2f(x2, y2 - radius);
/* 245 */     GL11.glEnd();
/* 246 */     GL11.glBegin(3);
/* 247 */     GL11.glVertex2f(x2 - radius, y2 - 0.1F);
/* 248 */     GL11.glVertex2f(x + radius, y2 - 0.1F);
/* 249 */     GL11.glEnd();
/* 250 */     GL11.glBegin(3);
/* 251 */     GL11.glVertex2f(x + 0.1F, y2 - radius);
/* 252 */     GL11.glVertex2f(x + 0.1F, y + radius);
/* 253 */     GL11.glEnd();
/* 254 */     float f1 = x2 - radius;
/* 255 */     float f2 = y + radius;
/* 256 */     GL11.glBegin(3);
/*     */     int k;
/* 258 */     for (k = 0; k <= i; k++) {
/* 259 */       int m = 90 - k * j;
/* 260 */       GL11.glVertex2f((float)(f1 + radius * MathUtil.getRightAngle(m)), (float)(f2 - radius * MathUtil.getAngle(m)));
/*     */     } 
/* 262 */     GL11.glEnd();
/* 263 */     f1 = x2 - radius;
/* 264 */     f2 = y2 - radius;
/* 265 */     GL11.glBegin(3);
/* 266 */     for (k = 0; k <= i; k++) {
/* 267 */       int m = k * j + 270;
/* 268 */       GL11.glVertex2f((float)(f1 + radius * MathUtil.getRightAngle(m)), (float)(f2 - radius * MathUtil.getAngle(m)));
/*     */     } 
/* 270 */     GL11.glEnd();
/* 271 */     GL11.glBegin(3);
/* 272 */     f1 = x + radius;
/* 273 */     f2 = y2 - radius;
/* 274 */     for (k = 0; k <= i; k++) {
/* 275 */       int m = k * j + 90;
/* 276 */       GL11.glVertex2f((float)(f1 + radius * MathUtil.getRightAngle(m)), (float)(f2 + radius * MathUtil.getAngle(m)));
/*     */     } 
/* 278 */     GL11.glEnd();
/* 279 */     GL11.glBegin(3);
/* 280 */     f1 = x + radius;
/* 281 */     f2 = y + radius;
/* 282 */     for (k = 0; k <= i; k++) {
/* 283 */       int m = 270 - k * j;
/* 284 */       GL11.glVertex2f((float)(f1 + radius * MathUtil.getRightAngle(m)), (float)(f2 + radius * MathUtil.getAngle(m)));
/*     */     } 
/* 286 */     GL11.glEnd();
/* 287 */     if (width != 1.0F)
/* 288 */       GL11.glLineWidth(1.0F); 
/* 289 */     GlStateManager.enableCull();
/* 290 */     GlStateManager.disableBlend();
/* 291 */     GlStateManager.disableColorMaterial();
/* 292 */     GlStateManager.enableTexture2D();
/*     */   }
/*     */   
/*     */   public static void drawCircle(float x, float y, float radius, float thickness, Color color, boolean smooth) {
/* 296 */     drawPartialCircle(x, y, radius, 0, 360, thickness, color, smooth);
/*     */   }
/*     */   
/*     */   public static void drawPartialCircle(int x, int y, float radius, int startAngle, int endAngle, float thickness, Color color, boolean smooth) {
/* 300 */     drawPartialCircle(x, y, radius, startAngle, endAngle, thickness, color, smooth);
/*     */   }
/*     */   
/*     */   public static void drawPartialCircle(float x, float y, float radius, int startAngle, int endAngle, float thickness, Color colour, boolean smooth) {
/* 304 */     GL11.glDisable(3553);
/* 305 */     GL11.glBlendFunc(770, 771);
/* 306 */     if (startAngle > endAngle) {
/* 307 */       int temp = startAngle;
/* 308 */       startAngle = endAngle;
/* 309 */       endAngle = temp;
/*     */     } 
/* 311 */     if (startAngle < 0)
/* 312 */       startAngle = 0; 
/* 313 */     if (endAngle > 360)
/* 314 */       endAngle = 360; 
/* 315 */     if (smooth) {
/* 316 */       GL11.glEnable(2848);
/*     */     } else {
/* 318 */       GL11.glDisable(2848);
/*     */     } 
/* 320 */     GL11.glLineWidth(thickness);
/* 321 */     GL11.glColor4f(colour.getRed() / 255.0F, colour.getGreen() / 255.0F, colour.getBlue() / 255.0F, colour.getAlpha() / 255.0F);
/* 322 */     GL11.glBegin(3);
/* 323 */     float ratio = 0.017453292F;
/* 324 */     for (int i = startAngle; i <= endAngle; i++) {
/* 325 */       float radians = (i - 90) * ratio;
/* 326 */       GL11.glVertex2f(x + (float)Math.cos(radians) * radius, y + (float)Math.sin(radians) * radius);
/*     */     } 
/* 328 */     GL11.glEnd();
/* 329 */     GL11.glEnable(3553);
/* 330 */     GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/*     */   }
/*     */   
/*     */   public static void drawFilledRect(float x1, float y1, float x2, float y2, int colour, boolean smooth) {
/* 334 */     drawFilledShape(new float[] { x1, y1, x1, y2, x2, y2, x2, y1 }, new Color(colour, true), smooth);
/*     */   }
/*     */   
/*     */   public static void drawFilledShape(float[] points, Color colour, boolean smooth) {
/* 338 */     GL11.glPushMatrix();
/* 339 */     GL11.glDisable(3553);
/* 340 */     GL11.glBlendFunc(770, 771);
/* 341 */     if (smooth) {
/* 342 */       GL11.glEnable(2848);
/*     */     } else {
/* 344 */       GL11.glDisable(2848);
/*     */     } 
/* 346 */     GL11.glLineWidth(1.0F);
/* 347 */     GL11.glColor4f(colour.getRed() / 255.0F, colour.getGreen() / 255.0F, colour.getBlue() / 255.0F, colour.getAlpha() / 255.0F);
/* 348 */     GL11.glBegin(9);
/* 349 */     for (int i = 0; i < points.length; i += 2)
/* 350 */       GL11.glVertex2f(points[i], points[i + 1]); 
/* 351 */     GL11.glEnd();
/* 352 */     GL11.glEnable(3553);
/* 353 */     GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/* 354 */     GL11.glPopMatrix();
/*     */   }
/*     */   
/*     */   public static void drawLine(float x, float x1, float y, float thickness, int colour, boolean smooth) {
/* 358 */     drawLines(new float[] { x, y, x1, y }, thickness, new Color(colour, true), smooth);
/*     */   }
/*     */   
/*     */   public static void drawVerticalLine(float x, float y, float y1, float thickness, int colour, boolean smooth) {
/* 362 */     drawLines(new float[] { x, y, x, y1 }, thickness, new Color(colour, true), smooth);
/*     */   }
/*     */   
/*     */   public static void drawLines(float[] points, float thickness, Color colour, boolean smooth) {
/* 366 */     GL11.glPushMatrix();
/* 367 */     GL11.glDisable(3553);
/* 368 */     GL11.glBlendFunc(770, 771);
/* 369 */     if (smooth) {
/* 370 */       GL11.glEnable(2848);
/*     */     } else {
/* 372 */       GL11.glDisable(2848);
/*     */     } 
/* 374 */     GL11.glLineWidth(thickness);
/* 375 */     GL11.glColor4f(colour.getRed() / 255.0F, colour.getGreen() / 255.0F, colour.getBlue() / 255.0F, colour.getAlpha() / 255.0F);
/* 376 */     GL11.glBegin(1);
/* 377 */     for (int i = 0; i < points.length; i += 2)
/* 378 */       GL11.glVertex2f(points[i], points[i + 1]); 
/* 379 */     GL11.glEnd();
/* 380 */     GL11.glEnable(2848);
/* 381 */     GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/* 382 */     GL11.glEnable(3553);
/* 383 */     GL11.glPopMatrix();
/*     */   }
/*     */ }


/* Location:              C:\Users\Lenovo\Downloads\ZyrexClientV1 (1).jar!\ZyrexClient\RectUtils.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */