/*     */ package ZyrexClient.Gui.Login.teszt;
/*     */ 
/*     */ import java.awt.Color;
/*     */ import net.minecraft.client.Minecraft;
/*     */ import net.minecraft.client.gui.FontRenderer;
/*     */ import net.minecraft.client.gui.Gui;
/*     */ import net.minecraft.client.gui.GuiScreen;
/*     */ import net.minecraft.client.renderer.Tessellator;
/*     */ import net.minecraft.client.renderer.WorldRenderer;
/*     */ import net.minecraft.util.ChatAllowedCharacters;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class PasswordField
/*     */   extends Gui
/*     */ {
/*     */   private final FontRenderer fontRenderer;
/*     */   private final int xPos;
/*     */   private final int yPos;
/*     */   private final int width;
/*     */   private final int height;
/*     */   private String text;
/*     */   private int maxStringLength;
/*     */   private int cursorCounter;
/*     */   private boolean enableBackgroundDrawing;
/*     */   private boolean canLoseFocus;
/*     */   public boolean isFocused;
/*     */   private boolean isEnabled;
/*     */   private int i;
/*     */   private int cursorPosition;
/*     */   private int selectionEnd;
/*     */   private int enabledColor;
/*     */   private int disabledColor;
/*     */   private boolean b;
/*     */   
/*     */   public PasswordField(FontRenderer par1FontRenderer, int par2, int par3, int par4, int par5) {
/*  42 */     this.text = "";
/*  43 */     this.maxStringLength = 50;
/*  44 */     this.enableBackgroundDrawing = true;
/*  45 */     this.canLoseFocus = true;
/*  46 */     this.isFocused = false;
/*  47 */     this.isEnabled = true;
/*  48 */     this.i = 0;
/*  49 */     this.cursorPosition = 0;
/*  50 */     this.selectionEnd = 0;
/*  51 */     this.enabledColor = 14737632;
/*  52 */     this.disabledColor = 7368816;
/*  53 */     this.b = true;
/*  54 */     this.fontRenderer = par1FontRenderer;
/*  55 */     this.xPos = par2;
/*  56 */     this.yPos = par3;
/*  57 */     this.width = par4;
/*  58 */     this.height = par5;
/*     */   }
/*     */   
/*     */   public void updateCursorCounter() {
/*  62 */     this.cursorCounter++;
/*     */   }
/*     */   
/*     */   public void setText(String par1Str) {
/*  66 */     if (par1Str.length() > this.maxStringLength) {
/*  67 */       this.text = par1Str.substring(0, this.maxStringLength);
/*     */     } else {
/*     */       
/*  70 */       this.text = par1Str;
/*     */     } 
/*  72 */     setCursorPositionEnd();
/*     */   }
/*     */   
/*     */   public String getText() {
/*  76 */     String newtext = this.text.replaceAll(" ", "");
/*  77 */     return newtext;
/*     */   }
/*     */   
/*     */   public String getSelectedtext() {
/*  81 */     int var1 = (this.cursorPosition < this.selectionEnd) ? this.cursorPosition : this.selectionEnd;
/*  82 */     int var2 = (this.cursorPosition < this.selectionEnd) ? this.selectionEnd : this.cursorPosition;
/*  83 */     return this.text.substring(var1, var2);
/*     */   }
/*     */   public void writeText(String par1Str) {
/*     */     int var8;
/*  87 */     String var2 = "";
/*  88 */     String var3 = ChatAllowedCharacters.filterAllowedCharacters(par1Str);
/*  89 */     int var4 = (this.cursorPosition < this.selectionEnd) ? this.cursorPosition : this.selectionEnd;
/*  90 */     int var5 = (this.cursorPosition < this.selectionEnd) ? this.selectionEnd : this.cursorPosition;
/*  91 */     int var6 = this.maxStringLength - this.text.length() - var4 - this.selectionEnd;
/*  92 */     boolean var7 = false;
/*  93 */     if (this.text.length() > 0) {
/*  94 */       var2 = String.valueOf(String.valueOf(String.valueOf(var2))) + this.text.substring(0, var4);
/*     */     }
/*     */     
/*  97 */     if (var6 < var3.length()) {
/*  98 */       var2 = String.valueOf(String.valueOf(String.valueOf(var2))) + var3.substring(0, var6);
/*  99 */       var8 = var6;
/*     */     } else {
/*     */       
/* 102 */       var2 = String.valueOf(String.valueOf(String.valueOf(var2))) + var3;
/* 103 */       var8 = var3.length();
/*     */     } 
/* 105 */     if (this.text.length() > 0 && var5 < this.text.length()) {
/* 106 */       var2 = String.valueOf(String.valueOf(String.valueOf(var2))) + this.text.substring(var5);
/*     */     }
/* 108 */     this.text = var2.replaceAll(" ", "");
/* 109 */     cursorPos(var4 - this.selectionEnd + var8);
/*     */   }
/*     */   
/*     */   public void func_73779_a(int par1) {
/* 113 */     if (this.text.length() != 0) {
/* 114 */       if (this.selectionEnd != this.cursorPosition) {
/* 115 */         writeText("");
/*     */       } else {
/*     */         
/* 118 */         deleteFromCursor(getNthWordFromCursor(par1) - this.cursorPosition);
/*     */       } 
/*     */     }
/*     */   }
/*     */   
/*     */   public void deleteFromCursor(int par1) {
/* 124 */     if (this.text.length() != 0) {
/* 125 */       if (this.selectionEnd != this.cursorPosition) {
/* 126 */         writeText("");
/*     */       } else {
/*     */         
/* 129 */         boolean var2 = (par1 < 0);
/* 130 */         int var3 = var2 ? (this.cursorPosition + par1) : this.cursorPosition;
/* 131 */         int var4 = var2 ? this.cursorPosition : (this.cursorPosition + par1);
/* 132 */         String var5 = "";
/* 133 */         if (var3 >= 0) {
/* 134 */           var5 = this.text.substring(0, var3);
/*     */         }
/* 136 */         if (var4 < this.text.length()) {
/* 137 */           var5 = String.valueOf(String.valueOf(String.valueOf(var5))) + this.text.substring(var4);
/*     */         }
/* 139 */         this.text = var5;
/* 140 */         if (var2) {
/* 141 */           cursorPos(par1);
/*     */         }
/*     */       } 
/*     */     }
/*     */   }
/*     */   
/*     */   public int getNthWordFromCursor(int par1) {
/* 148 */     return getNthWordFromPos(par1, getCursorPosition());
/*     */   }
/*     */   
/*     */   public int getNthWordFromPos(int par1, int par2) {
/* 152 */     return type(par1, getCursorPosition(), true);
/*     */   }
/*     */   
/*     */   public int type(int par1, int par2, boolean par3) {
/* 156 */     int var4 = par2;
/* 157 */     boolean var5 = (par1 < 0);
/* 158 */     for (int var6 = Math.abs(par1), var7 = 0; var7 < var6; var7++) {
/* 159 */       if (!var5) {
/* 160 */         int var8 = this.text.length();
/* 161 */         var4 = this.text.indexOf(' ', var4);
/* 162 */         if (var4 == -1) {
/* 163 */           var4 = var8;
/*     */         } else {
/*     */           
/* 166 */           while (par3 && 
/* 167 */             var4 < var8) {
/*     */ 
/*     */             
/* 170 */             if (this.text.charAt(var4) != ' ') {
/*     */               break;
/*     */             }
/* 173 */             var4++;
/*     */           } 
/*     */         } 
/*     */       } else {
/*     */         
/* 178 */         while (par3 && 
/* 179 */           var4 > 0) {
/*     */ 
/*     */           
/* 182 */           if (this.text.charAt(var4 - 1) != ' ') {
/*     */             break;
/*     */           }
/* 185 */           var4--;
/*     */         } 
/* 187 */         while (var4 > 0 && this.text.charAt(var4 - 1) != ' ') {
/* 188 */           var4--;
/*     */         }
/*     */       } 
/*     */     } 
/* 192 */     return var4;
/*     */   }
/*     */   
/*     */   public void cursorPos(int par1) {
/* 196 */     setCursorPosition(this.selectionEnd + par1);
/*     */   }
/*     */   
/*     */   public void setCursorPosition(int par1) {
/* 200 */     this.cursorPosition = par1;
/* 201 */     int var2 = this.text.length();
/* 202 */     if (this.cursorPosition < 0) {
/* 203 */       this.cursorPosition = 0;
/*     */     }
/* 205 */     if (this.cursorPosition > var2) {
/* 206 */       this.cursorPosition = var2;
/*     */     }
/* 208 */     func_73800_i(this.cursorPosition);
/*     */   }
/*     */   
/*     */   public void setCursorPositionZero() {
/* 212 */     setCursorPosition(0);
/*     */   }
/*     */   
/*     */   public void setCursorPositionEnd() {
/* 216 */     setCursorPosition(this.text.length());
/*     */   }
/*     */   
/*     */   public boolean textboxKeyTyped(char par1, int par2) {
/* 220 */     if (!this.isEnabled || !this.isFocused) {
/* 221 */       return false;
/*     */     }
/* 223 */     switch (par1) {
/*     */       case '\001':
/* 225 */         setCursorPositionEnd();
/* 226 */         func_73800_i(0);
/* 227 */         return true;
/*     */       
/*     */       case '\003':
/* 230 */         GuiScreen.setClipboardString(getSelectedtext());
/* 231 */         return true;
/*     */       
/*     */       case '\026':
/* 234 */         writeText(GuiScreen.getClipboardString());
/* 235 */         return true;
/*     */       
/*     */       case '\030':
/* 238 */         GuiScreen.setClipboardString(getSelectedtext());
/* 239 */         writeText("");
/* 240 */         return true;
/*     */     } 
/*     */     
/* 243 */     switch (par2) {
/*     */       case 14:
/* 245 */         if (GuiScreen.isCtrlKeyDown()) {
/* 246 */           func_73779_a(-1);
/*     */         } else {
/*     */           
/* 249 */           deleteFromCursor(-1);
/*     */         } 
/* 251 */         return true;
/*     */       
/*     */       case 199:
/* 254 */         if (GuiScreen.isShiftKeyDown()) {
/* 255 */           func_73800_i(0);
/*     */         } else {
/*     */           
/* 258 */           setCursorPositionZero();
/*     */         } 
/* 260 */         return true;
/*     */       
/*     */       case 203:
/* 263 */         if (GuiScreen.isShiftKeyDown()) {
/* 264 */           if (GuiScreen.isCtrlKeyDown()) {
/* 265 */             func_73800_i(getNthWordFromPos(-1, getSelectionEnd()));
/*     */           } else {
/*     */             
/* 268 */             func_73800_i(getSelectionEnd() - 1);
/*     */           }
/*     */         
/* 271 */         } else if (GuiScreen.isCtrlKeyDown()) {
/* 272 */           setCursorPosition(getNthWordFromCursor(-1));
/*     */         } else {
/*     */           
/* 275 */           cursorPos(-1);
/*     */         } 
/* 277 */         return true;
/*     */       
/*     */       case 205:
/* 280 */         if (GuiScreen.isShiftKeyDown()) {
/* 281 */           if (GuiScreen.isCtrlKeyDown()) {
/* 282 */             func_73800_i(getNthWordFromPos(1, getSelectionEnd()));
/*     */           } else {
/*     */             
/* 285 */             func_73800_i(getSelectionEnd() + 1);
/*     */           }
/*     */         
/* 288 */         } else if (GuiScreen.isCtrlKeyDown()) {
/* 289 */           setCursorPosition(getNthWordFromCursor(1));
/*     */         } else {
/*     */           
/* 292 */           cursorPos(1);
/*     */         } 
/* 294 */         return true;
/*     */       
/*     */       case 207:
/* 297 */         if (GuiScreen.isShiftKeyDown()) {
/* 298 */           func_73800_i(this.text.length());
/*     */         } else {
/*     */           
/* 301 */           setCursorPositionEnd();
/*     */         } 
/* 303 */         return true;
/*     */       
/*     */       case 211:
/* 306 */         if (GuiScreen.isCtrlKeyDown()) {
/* 307 */           func_73779_a(1);
/*     */         } else {
/*     */           
/* 310 */           deleteFromCursor(1);
/*     */         } 
/* 312 */         return true;
/*     */     } 
/*     */     
/* 315 */     if (ChatAllowedCharacters.isAllowedCharacter(par1)) {
/* 316 */       writeText(Character.toString(par1));
/* 317 */       return true;
/*     */     } 
/* 319 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void mouseClicked(int par1, int par2, int par3) {
/* 327 */     boolean var4 = (par1 >= this.xPos && par1 < this.xPos + this.width && par2 >= this.yPos && par2 < this.yPos + this.height);
/* 328 */     if (this.canLoseFocus) {
/* 329 */       setFocused((this.isEnabled && var4));
/*     */     }
/* 331 */     if (this.isFocused && par3 == 0) {
/* 332 */       int var5 = par1 - this.xPos;
/* 333 */       if (this.enableBackgroundDrawing) {
/* 334 */         var5 -= 4;
/*     */       }
/* 336 */       String var6 = this.fontRenderer.trimStringToWidth(this.text.substring(this.i), getWidth());
/* 337 */       setCursorPosition(this.fontRenderer.trimStringToWidth(var6, var5).length() + this.i);
/*     */     } 
/*     */   }
/*     */   
/*     */   public void drawTextBox() {
/* 342 */     if (func_73778_q()) {
/* 343 */       if (getEnableBackgroundDrawing())
/*     */       {
/* 345 */         Gui.drawRect(this.xPos, this.yPos, this.xPos + this.width, this.yPos + this.height, (new Color(0, 0, 0, 100)).getRGB());
/*     */       }
/* 347 */       int var1 = this.isEnabled ? this.enabledColor : this.disabledColor;
/* 348 */       int var2 = this.cursorPosition - this.i;
/* 349 */       int var3 = this.selectionEnd - this.i;
/* 350 */       String var4 = this.fontRenderer.trimStringToWidth(this.text.substring(this.i), getWidth());
/* 351 */       boolean var5 = (var2 >= 0 && var2 <= var4.length());
/* 352 */       boolean var6 = (this.isFocused && this.cursorCounter / 6 % 2 == 0 && var5);
/* 353 */       int var7 = this.enableBackgroundDrawing ? (this.xPos + 4) : this.xPos;
/* 354 */       int var8 = this.enableBackgroundDrawing ? (this.yPos + (this.height - 8) / 2) : this.yPos;
/* 355 */       int var9 = var7;
/* 356 */       if (var3 > var4.length()) {
/* 357 */         var3 = var4.length();
/*     */       }
/* 359 */       if (var4.length() > 0) {
/* 360 */         if (var5) {
/* 361 */           var4.substring(0, var2);
/*     */         }
/* 363 */         var9 = (Minecraft.getMinecraft()).fontRendererObj.drawStringWithShadow(this.text.replaceAll("(?s).", "*"), var7, var8, var1);
/*     */       } 
/* 365 */       boolean var10 = !(this.cursorPosition >= this.text.length() && this.text.length() < getMaxStringLength());
/* 366 */       int var11 = var9;
/* 367 */       if (!var5) {
/* 368 */         var11 = (var2 > 0) ? (var7 + this.width) : var7;
/*     */       }
/* 370 */       else if (var10) {
/* 371 */         var11 = var9 - 1;
/* 372 */         var9--;
/*     */       } 
/* 374 */       if (var4.length() > 0 && var5 && var2 < var4.length()) {
/* 375 */         (Minecraft.getMinecraft()).fontRendererObj.drawStringWithShadow(var4.substring(var2), var9, var8, var1);
/*     */       }
/* 377 */       if (var6) {
/* 378 */         if (var10) {
/* 379 */           Gui.drawRect(var11, var8 - 1, var11 + 1, var8 + 1 + this.fontRenderer.FONT_HEIGHT, -3092272);
/*     */         } else {
/*     */           
/* 382 */           (Minecraft.getMinecraft()).fontRendererObj.drawStringWithShadow("_", var11, var8, var1);
/*     */         } 
/*     */       }
/* 385 */       if (var3 != var2) {
/* 386 */         int var12 = var7 + this.fontRenderer.getStringWidth(var4.substring(0, var3));
/* 387 */         drawCursorVertical(var11, var8 - 1, var12 - 1, var8 + 1 + this.fontRenderer.FONT_HEIGHT);
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   private void drawCursorVertical(int par1, int par2, int par3, int par4) {
/* 393 */     if (par1 < par3) {
/* 394 */       int var5 = par1;
/* 395 */       par1 = par3;
/* 396 */       par3 = var5;
/*     */     } 
/* 398 */     if (par2 < par4) {
/* 399 */       int var5 = par2;
/* 400 */       par2 = par4;
/* 401 */       par4 = var5;
/*     */     } 
/* 403 */     Tessellator var6 = Tessellator.getInstance();
/* 404 */     WorldRenderer var7 = var6.getWorldRenderer();
/* 405 */     GL11.glColor4f(0.0F, 0.0F, 255.0F, 255.0F);
/* 406 */     GL11.glDisable(3553);
/* 407 */     GL11.glEnable(3058);
/* 408 */     GL11.glLogicOp(5387);
/* 409 */     var7.begin(7, var7.getVertexFormat());
/* 410 */     var7.pos(par1, par4, 0.0D);
/* 411 */     var7.pos(par3, par4, 0.0D);
/* 412 */     var7.pos(par3, par2, 0.0D);
/* 413 */     var7.pos(par1, par2, 0.0D);
/* 414 */     var7.finishDrawing();
/* 415 */     GL11.glDisable(3058);
/* 416 */     GL11.glEnable(3553);
/*     */   }
/*     */   
/*     */   public void setMaxStringLength(int par1) {
/* 420 */     this.maxStringLength = par1;
/* 421 */     if (this.text.length() > par1) {
/* 422 */       this.text = this.text.substring(0, par1);
/*     */     }
/*     */   }
/*     */   
/*     */   public int getMaxStringLength() {
/* 427 */     return this.maxStringLength;
/*     */   }
/*     */   
/*     */   public int getCursorPosition() {
/* 431 */     return this.cursorPosition;
/*     */   }
/*     */   
/*     */   public boolean getEnableBackgroundDrawing() {
/* 435 */     return this.enableBackgroundDrawing;
/*     */   }
/*     */   
/*     */   public void setEnableBackgroundDrawing(boolean par1) {
/* 439 */     this.enableBackgroundDrawing = par1;
/*     */   }
/*     */   
/*     */   public void func_73794_g(int par1) {
/* 443 */     this.enabledColor = par1;
/*     */   }
/*     */   
/*     */   public void setFocused(boolean par1) {
/* 447 */     if (par1 && !this.isFocused) {
/* 448 */       this.cursorCounter = 0;
/*     */     }
/* 450 */     this.isFocused = par1;
/*     */   }
/*     */   
/*     */   public boolean isFocused() {
/* 454 */     return this.isFocused;
/*     */   }
/*     */   
/*     */   public int getSelectionEnd() {
/* 458 */     return this.selectionEnd;
/*     */   }
/*     */   
/*     */   public int getWidth() {
/* 462 */     return getEnableBackgroundDrawing() ? (this.width - 8) : this.width;
/*     */   }
/*     */   
/*     */   public void func_73800_i(int par1) {
/* 466 */     int var2 = this.text.length();
/* 467 */     if (par1 > var2) {
/* 468 */       par1 = var2;
/*     */     }
/* 470 */     if (par1 < 0) {
/* 471 */       par1 = 0;
/*     */     }
/* 473 */     this.selectionEnd = par1;
/* 474 */     if (this.fontRenderer != null) {
/* 475 */       if (this.i > var2) {
/* 476 */         this.i = var2;
/*     */       }
/* 478 */       int var3 = getWidth();
/* 479 */       String var4 = this.fontRenderer.trimStringToWidth(this.text.substring(this.i), var3);
/* 480 */       int var5 = var4.length() + this.i;
/* 481 */       if (par1 == this.i) {
/* 482 */         this.i -= this.fontRenderer.trimStringToWidth(this.text, var3, true).length();
/*     */       }
/* 484 */       if (par1 > var5) {
/* 485 */         this.i += par1 - var5;
/*     */       }
/* 487 */       else if (par1 <= this.i) {
/* 488 */         this.i -= this.i - par1;
/*     */       } 
/* 490 */       if (this.i < 0) {
/* 491 */         this.i = 0;
/*     */       }
/* 493 */       if (this.i > var2) {
/* 494 */         this.i = var2;
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public void setCanLoseFocus(boolean par1) {
/* 500 */     this.canLoseFocus = par1;
/*     */   }
/*     */   
/*     */   public boolean func_73778_q() {
/* 504 */     return this.b;
/*     */   }
/*     */   
/*     */   public void func_73790_e(boolean par1) {
/* 508 */     this.b = par1;
/*     */   }
/*     */ }


/* Location:              C:\Users\Lenovo\Downloads\ZyrexClientV1 (1).jar!\ZyrexClient\Gui\Login\teszt\PasswordField.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */