/*     */ package ZyrexClient.mods.impl;
/*     */ 
/*     */ import ZyrexClient.Client;
/*     */ import ZyrexClient.Gui.ScreenPosition;
/*     */ import ZyrexClient.ModHuds.Rainbow;
/*     */ import ZyrexClient.mods.ModDraggable;
/*     */ import java.awt.Color;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import net.minecraft.client.Minecraft;
/*     */ import net.minecraft.client.gui.Gui;
/*     */ import net.minecraft.client.renderer.GlStateManager;
/*     */ import net.minecraft.client.settings.KeyBinding;
/*     */ import org.lwjgl.input.Mouse;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ 
/*     */ public class ZyrexModKeystrokes
/*     */   extends ModDraggable {
/*     */   private KeystrokesMode mode;
/*     */   private List<Long> clicks;
/*     */   private boolean wasPressed;
/*     */   private long lastPressed;
/*     */   private List<Long> clicks2;
/*     */   private boolean wasPressed2;
/*     */   private long lastPressed2;
/*     */   
/*     */   public enum KeystrokesMode {
/*     */     WASD((String)new ZyrexModKeystrokes.Key[] { ZyrexModKeystrokes.Key.access$0(), ZyrexModKeystrokes.Key.access$1(), ZyrexModKeystrokes.Key.access$2(), ZyrexModKeystrokes.Key.access$3() }),
/*     */     WASD_MOUSE((String)new ZyrexModKeystrokes.Key[] { ZyrexModKeystrokes.Key.access$0(), ZyrexModKeystrokes.Key.access$1(), ZyrexModKeystrokes.Key.access$2(), ZyrexModKeystrokes.Key.access$1(), ZyrexModKeystrokes.Key.access$4(), ZyrexModKeystrokes.Key.access$5() }),
/*     */     WASD_SNEAK((String)new ZyrexModKeystrokes.Key[] { ZyrexModKeystrokes.Key.access$0(), ZyrexModKeystrokes.Key.access$1(), ZyrexModKeystrokes.Key.access$2(), ZyrexModKeystrokes.Key.access$3(), ZyrexModKeystrokes.Key.access$4(), ZyrexModKeystrokes.Key.access$5(), new ZyrexModKeystrokes.Key("Sneak", (Minecraft.getMinecraft()).gameSettings.keyBindSneak, 1, 41, 58, 18, false) }),
/*     */     WASD_SNEAK_MOUSE((String)new ZyrexModKeystrokes.Key[] { ZyrexModKeystrokes.Key.access$0(), ZyrexModKeystrokes.Key.access$1(), ZyrexModKeystrokes.Key.access$2(), ZyrexModKeystrokes.Key.access$4(), ZyrexModKeystrokes.Key.access$5(), ZyrexModKeystrokes.Key.access$3(), new ZyrexModKeystrokes.Key("Sneak", (Minecraft.getMinecraft()).gameSettings.keyBindSneak, 1, 61, 58, 18, false) });
/*     */     private int width = 0;
/*     */     private int height = 0;
/*     */     private final ZyrexModKeystrokes.Key[] keys;
/*     */     
/*     */     KeystrokesMode(ZyrexModKeystrokes.Key... keysIn) {
/*     */       this.keys = keysIn;
/*     */       byte b;
/*     */       int i;
/*     */       ZyrexModKeystrokes.Key[] arrayOfKey;
/*     */       for (i = (arrayOfKey = this.keys).length, b = 0; b < i; ) {
/*     */         ZyrexModKeystrokes.Key key = arrayOfKey[b];
/*     */         this.width = Math.max(this.width, key.getX() + key.getWidth());
/*     */         this.height = Math.max(this.height, key.getY() + key.getHeight());
/*     */         b++;
/*     */       } 
/*     */     }
/*     */     
/*     */     public int getHeight() {
/*     */       return this.height;
/*     */     }
/*     */     
/*     */     public int getWidth() {
/*     */       return this.width;
/*     */     }
/*     */     
/*     */     public ZyrexModKeystrokes.Key[] getKeys() {
/*     */       return this.keys;
/*     */     }
/*     */   }
/*     */   
/*     */   private static class Key {
/*     */     private static final Key W = new Key("W", (Minecraft.getMinecraft()).gameSettings.keyBindForward, 21, 1, 18, 18, false);
/*     */     private static final Key A = new Key("A", (Minecraft.getMinecraft()).gameSettings.keyBindLeft, 1, 21, 18, 18, false);
/*     */     private static final Key S = new Key("S", (Minecraft.getMinecraft()).gameSettings.keyBindBack, 21, 21, 18, 18, false);
/*     */     private static final Key D = new Key("D", (Minecraft.getMinecraft()).gameSettings.keyBindRight, 41, 21, 18, 18, false);
/*     */     private static final Key LMB = new Key("LMB", (Minecraft.getMinecraft()).gameSettings.keyBindAttack, 1, 41, 28, 18, true);
/*     */     private static final Key RMB = new Key("RMB", (Minecraft.getMinecraft()).gameSettings.keyBindUseItem, 31, 41, 28, 18, true);
/*     */     private final String name;
/*     */     private final KeyBinding keyBind;
/*     */     private final int x;
/*     */     private final int y;
/*     */     private final int width;
/*     */     private final int height;
/*     */     private final boolean cps;
/*     */     
/*     */     public Key(String name, KeyBinding keyBind, int x, int y, int width, int height, boolean cps) {
/*     */       this.name = name;
/*     */       this.keyBind = keyBind;
/*     */       this.x = x;
/*     */       this.y = y;
/*     */       this.width = width;
/*     */       this.height = height;
/*     */       this.cps = cps;
/*     */     }
/*     */     
/*     */     public boolean isDown() {
/*     */       return this.keyBind.isKeyDown();
/*     */     }
/*     */     
/*     */     public int getHeight() {
/*     */       return this.height;
/*     */     }
/*     */     
/*     */     public String getName() {
/*     */       return this.name;
/*     */     }
/*     */     
/*     */     public int getWidth() {
/*     */       return this.width;
/*     */     }
/*     */     
/*     */     public int getX() {
/*     */       return this.x;
/*     */     }
/*     */     
/*     */     public int getY() {
/*     */       return this.y;
/*     */     }
/*     */   }
/*     */   
/*     */   public ZyrexModKeystrokes() {
/* 113 */     this.mode = KeystrokesMode.WASD_SNEAK_MOUSE;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 137 */     this.clicks = new ArrayList<>();
/*     */ 
/*     */ 
/*     */     
/* 141 */     this.clicks2 = new ArrayList<>();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void render(ScreenPosition pos) {
/* 147 */     if (Client.ModKeystrokes) {
/* 148 */       boolean lpressed = Mouse.isButtonDown(0);
/* 149 */       boolean rpressed = Mouse.isButtonDown(1);
/*     */       
/* 151 */       if (lpressed != this.wasPressed) {
/* 152 */         this.lastPressed = System.currentTimeMillis() + 10L;
/* 153 */         this.wasPressed = lpressed;
/* 154 */         if (lpressed) {
/* 155 */           this.clicks.add(Long.valueOf(this.lastPressed));
/*     */         }
/*     */       } 
/*     */       
/* 159 */       if (rpressed != this.wasPressed2) {
/* 160 */         this.lastPressed2 = System.currentTimeMillis() + 10L;
/* 161 */         this.wasPressed2 = rpressed;
/* 162 */         if (rpressed) {
/* 163 */           this.clicks2.add(Long.valueOf(this.lastPressed2));
/*     */         }
/*     */       } 
/*     */       
/* 167 */       GL11.glPushMatrix(); byte b; int i;
/*     */       Key[] arrayOfKey;
/* 169 */       for (i = (arrayOfKey = this.mode.getKeys()).length, b = 0; b < i; ) { Key key = arrayOfKey[b];
/*     */         
/* 171 */         int textWidth = this.font.getStringWidth(key.getName());
/*     */         
/* 173 */         if (Client.KeystrokesCPS) {
/* 174 */           if (Client.KeystrokesChroma) {
/* 175 */             if (key.cps) {
/* 176 */               GlStateManager.pushMatrix();
/* 177 */               GlStateManager.scale(0.5F, 0.5F, 0.5F);
/* 178 */               GlStateManager.translate((pos.getAbsoluteX() + key.getX() + key.getWidth() / 2) - textWidth / 2.0F, (pos.getAbsoluteY() + key.getY() + key.getHeight() / 2) + 4.0F, 1.0F);
/* 179 */               if (key.getName().matches(Key.LMB.getName())) {
/* 180 */                 this.font.drawString("CPS: " + getCPS(), (pos.getAbsoluteX() + key.getX() + key.getWidth() / 2 - textWidth / 2), (pos.getAbsoluteY() + key.getY() + key.getHeight() / 2 + 4), -1);
/*     */               }
/*     */               
/* 183 */               if (key.getName().matches(Key.RMB.getName())) {
/* 184 */                 this.font.drawString("CPS: " + getCPS2(), (pos.getAbsoluteX() + key.getX() + key.getWidth() / 2 - textWidth / 2), (pos.getAbsoluteY() + key.getY() + key.getHeight() / 2 + 4), -1);
/*     */               }
/* 186 */               GlStateManager.popMatrix();
/*     */             }
/*     */           
/* 189 */           } else if (key.cps) {
/* 190 */             GlStateManager.pushMatrix();
/* 191 */             GlStateManager.scale(0.5F, 0.5F, 0.5F);
/* 192 */             GlStateManager.translate((pos.getAbsoluteX() + key.getX() + key.getWidth() / 2) - textWidth / 2.0F, (pos.getAbsoluteY() + key.getY() + key.getHeight() / 2) + 4.0F, 1.0F);
/* 193 */             if (key.getName().matches(Key.LMB.getName())) {
/* 194 */               Rainbow.drawChromaString("CPS: " + getCPS(), pos.getAbsoluteX() + key.getX() + key.getWidth() / 2 - textWidth / 2, pos.getAbsoluteY() + key.getY() + key.getHeight() / 2 + 4, true);
/*     */             }
/*     */             
/* 197 */             if (key.getName().matches(Key.RMB.getName())) {
/* 198 */               Rainbow.drawChromaString("CPS: " + getCPS2(), pos.getAbsoluteX() + key.getX() + key.getWidth() / 2 - textWidth / 2, pos.getAbsoluteY() + key.getY() + key.getHeight() / 2 + 4, true);
/*     */             }
/* 200 */             GlStateManager.popMatrix();
/*     */           } 
/*     */         }
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 207 */         if (!this.wasPressed) {
/* 208 */           (new Color(255, 255, 255, 102)).getRGB();
/*     */         }
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 214 */         Gui.drawRect(
/* 215 */             pos.getAbsoluteX() + key.getX(), 
/* 216 */             pos.getAbsoluteY() + key.getY(), 
/* 217 */             pos.getAbsoluteX() + key.getX() + key.getWidth(), 
/* 218 */             pos.getAbsoluteY() + key.getY() + key.getHeight(), 
/* 219 */             key.isDown() ? (new Color(255, 255, 255, 102)).getRGB() : (new Color(0, 0, 0, 130)).getRGB());
/*     */ 
/*     */         
/* 222 */         if (Client.KeystrokesChroma) {
/* 223 */           this.font.drawString(
/* 224 */               key.getName(), (
/* 225 */               pos.getAbsoluteX() + key.getX() + key.getWidth() / 2 - textWidth / 2), (
/* 226 */               pos.getAbsoluteY() + key.getY() + key.getHeight() / 2 - 4), 
/* 227 */               key.isDown() ? Color.BLACK.getRGB() : Color.WHITE.getRGB());
/*     */         } else {
/*     */           
/* 230 */           Rainbow.drawChromaString(
/* 231 */               key.getName(), 
/* 232 */               pos.getAbsoluteX() + key.getX() + key.getWidth() / 2 - textWidth / 2, 
/* 233 */               pos.getAbsoluteY() + key.getY() + key.getHeight() / 2 - 4, 
/* 234 */               true);
/*     */         } 
/*     */         b++; }
/*     */       
/* 238 */       GL11.glPopMatrix();
/*     */     } 
/*     */   }
/*     */   
/*     */   public void setMode(KeystrokesMode mode) {
/*     */     this.mode = mode;
/*     */   }
/*     */   
/* 246 */   public void renderDummy(ScreenPosition pos) { if (Client.ModKeystrokes) {
/* 247 */       GL11.glPushMatrix(); byte b; int i;
/*     */       Key[] arrayOfKey;
/* 249 */       for (i = (arrayOfKey = this.mode.getKeys()).length, b = 0; b < i; ) { Key key = arrayOfKey[b];
/*     */         
/* 251 */         int textWidth = this.font.getStringWidth(key.getName());
/*     */         
/* 253 */         Gui.drawRect(
/* 254 */             pos.getAbsoluteX() + key.getX(), 
/* 255 */             pos.getAbsoluteY() + key.getY(), 
/* 256 */             pos.getAbsoluteX() + key.getX() + key.getWidth(), 
/* 257 */             pos.getAbsoluteY() + key.getY() + key.getHeight(), 
/* 258 */             key.isDown() ? (new Color(255, 255, 255, 102)).getRGB() : (new Color(0, 0, 0, 130)).getRGB());
/*     */ 
/*     */         
/* 261 */         if (Client.KeystrokesChroma) {
/* 262 */           this.font.drawString(
/* 263 */               key.getName(), (
/* 264 */               pos.getAbsoluteX() + key.getX() + key.getWidth() / 2 - textWidth / 2), (
/* 265 */               pos.getAbsoluteY() + key.getY() + key.getHeight() / 2 - 4), 
/* 266 */               key.isDown() ? Color.BLACK.getRGB() : Color.WHITE.getRGB());
/*     */         } else {
/*     */           
/* 269 */           Rainbow.drawChromaString(
/* 270 */               key.getName(), 
/* 271 */               pos.getAbsoluteX() + key.getX() + key.getWidth() / 2 - textWidth / 2, 
/* 272 */               pos.getAbsoluteY() + key.getY() + key.getHeight() / 2 - 4, 
/* 273 */               true);
/*     */         } 
/*     */         b++; }
/*     */       
/* 277 */       GL11.glPopMatrix();
/*     */     }  }
/*     */   
/*     */   public int getWidth() {
/*     */     if (Client.ModKeystrokes)
/*     */       return this.mode.getWidth(); 
/*     */     return 0;
/*     */   }
/* 285 */   private int getCPS() { long time = System.currentTimeMillis();
/* 286 */     this.clicks.removeIf(aLong -> (aLong.longValue() + 1000L < paramLong));
/* 287 */     return this.clicks.size(); }
/*     */   public int getHeight() { if (Client.ModKeystrokes)
/*     */       return this.mode.getHeight(); 
/*     */     return 0; } private int getCPS2() {
/* 291 */     long time2 = System.currentTimeMillis();
/* 292 */     this.clicks2.removeIf(aLong2 -> (aLong2.longValue() + 1000L < paramLong));
/* 293 */     return this.clicks2.size();
/*     */   }
/*     */ }


/* Location:              C:\Users\Lenovo\Downloads\ZyrexClientV1 (1).jar!\ZyrexClient\mods\impl\ZyrexModKeystrokes.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */