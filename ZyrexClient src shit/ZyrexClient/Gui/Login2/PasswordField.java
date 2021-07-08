/*     */ package ZyrexClient.Gui.Login2;
/*     */ 
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
/*  37 */     this.text = "";
/*  38 */     this.maxStringLength = 50;
/*  39 */     this.enableBackgroundDrawing = true;
/*  40 */     this.canLoseFocus = true;
/*  41 */     this.isFocused = false;
/*  42 */     this.isEnabled = true;
/*  43 */     this.i = 0;
/*  44 */     this.cursorPosition = 0;
/*  45 */     this.selectionEnd = 0;
/*  46 */     this.enabledColor = 14737632;
/*  47 */     this.disabledColor = 7368816;
/*  48 */     this.b = true;
/*  49 */     this.fontRenderer = par1FontRenderer;
/*  50 */     this.xPos = par2;
/*  51 */     this.yPos = par3;
/*  52 */     this.width = par4;
/*  53 */     this.height = par5;
/*     */   }
/*     */   
/*     */   public void updateCursorCounter() {
/*  57 */     this.cursorCounter++;
/*     */   }
/*     */   
/*     */   public void setText(String par1Str) {
/*  61 */     if (par1Str.length() > this.maxStringLength) {
/*  62 */       this.text = par1Str.substring(0, this.maxStringLength);
/*     */     } else {
/*     */       
/*  65 */       this.text = par1Str;
/*     */     } 
/*  67 */     setCursorPositionEnd();
/*     */   }
/*     */   
/*     */   public String getText() {
/*  71 */     String newtext = this.text.replaceAll(" ", "");
/*  72 */     return newtext;
/*     */   }
/*     */   
/*     */   public String getSelectedtext() {
/*  76 */     int var1 = (this.cursorPosition < this.selectionEnd) ? this.cursorPosition : this.selectionEnd;
/*  77 */     int var2 = (this.cursorPosition < this.selectionEnd) ? this.selectionEnd : this.cursorPosition;
/*  78 */     return this.text.substring(var1, var2);
/*     */   }
/*     */   public void writeText(String par1Str) {
/*     */     int var8;
/*  82 */     String var2 = "";
/*  83 */     String var3 = ChatAllowedCharacters.filterAllowedCharacters(par1Str);
/*  84 */     int var4 = (this.cursorPosition < this.selectionEnd) ? this.cursorPosition : this.selectionEnd;
/*  85 */     int var5 = (this.cursorPosition < this.selectionEnd) ? this.selectionEnd : this.cursorPosition;
/*  86 */     int var6 = this.maxStringLength - this.text.length() - var4 - this.selectionEnd;
/*  87 */     boolean var7 = false;
/*  88 */     if (this.text.length() > 0) {
/*  89 */       var2 = String.valueOf(String.valueOf(String.valueOf(var2))) + this.text.substring(0, var4);
/*     */     }
/*     */     
/*  92 */     if (var6 < var3.length()) {
/*  93 */       var2 = String.valueOf(String.valueOf(String.valueOf(var2))) + var3.substring(0, var6);
/*  94 */       var8 = var6;
/*     */     } else {
/*     */       
/*  97 */       var2 = String.valueOf(String.valueOf(String.valueOf(var2))) + var3;
/*  98 */       var8 = var3.length();
/*     */     } 
/* 100 */     if (this.text.length() > 0 && var5 < this.text.length()) {
/* 101 */       var2 = String.valueOf(String.valueOf(String.valueOf(var2))) + this.text.substring(var5);
/*     */     }
/* 103 */     this.text = var2.replaceAll(" ", "");
/* 104 */     cursorPos(var4 - this.selectionEnd + var8);
/*     */   }
/*     */   
/*     */   public void func_73779_a(int par1) {
/* 108 */     if (this.text.length() != 0) {
/* 109 */       if (this.selectionEnd != this.cursorPosition) {
/* 110 */         writeText("");
/*     */       } else {
/*     */         
/* 113 */         deleteFromCursor(getNthWordFromCursor(par1) - this.cursorPosition);
/*     */       } 
/*     */     }
/*     */   }
/*     */   
/*     */   public void deleteFromCursor(int par1) {
/* 119 */     if (this.text.length() != 0) {
/* 120 */       if (this.selectionEnd != this.cursorPosition) {
/* 121 */         writeText("");
/*     */       } else {
/*     */         
/* 124 */         boolean var2 = (par1 < 0);
/* 125 */         int var3 = var2 ? (this.cursorPosition + par1) : this.cursorPosition;
/* 126 */         int var4 = var2 ? this.cursorPosition : (this.cursorPosition + par1);
/* 127 */         String var5 = "";
/* 128 */         if (var3 >= 0) {
/* 129 */           var5 = this.text.substring(0, var3);
/*     */         }
/* 131 */         if (var4 < this.text.length()) {
/* 132 */           var5 = String.valueOf(String.valueOf(String.valueOf(var5))) + this.text.substring(var4);
/*     */         }
/* 134 */         this.text = var5;
/* 135 */         if (var2) {
/* 136 */           cursorPos(par1);
/*     */         }
/*     */       } 
/*     */     }
/*     */   }
/*     */   
/*     */   public int getNthWordFromCursor(int par1) {
/* 143 */     return getNthWordFromPos(par1, getCursorPosition());
/*     */   }
/*     */   
/*     */   public int getNthWordFromPos(int par1, int par2) {
/* 147 */     return type(par1, getCursorPosition(), true);
/*     */   }
/*     */   
/*     */   public int type(int par1, int par2, boolean par3) {
/* 151 */     int var4 = par2;
/* 152 */     boolean var5 = (par1 < 0);
/* 153 */     for (int var6 = Math.abs(par1), var7 = 0; var7 < var6; var7++) {
/* 154 */       if (!var5) {
/* 155 */         int var8 = this.text.length();
/* 156 */         var4 = this.text.indexOf(' ', var4);
/* 157 */         if (var4 == -1) {
/* 158 */           var4 = var8;
/*     */         } else {
/*     */           
/* 161 */           while (par3 && 
/* 162 */             var4 < var8) {
/*     */ 
/*     */             
/* 165 */             if (this.text.charAt(var4) != ' ') {
/*     */               break;
/*     */             }
/* 168 */             var4++;
/*     */           } 
/*     */         } 
/*     */       } else {
/*     */         
/* 173 */         while (par3 && 
/* 174 */           var4 > 0) {
/*     */ 
/*     */           
/* 177 */           if (this.text.charAt(var4 - 1) != ' ') {
/*     */             break;
/*     */           }
/* 180 */           var4--;
/*     */         } 
/* 182 */         while (var4 > 0 && this.text.charAt(var4 - 1) != ' ') {
/* 183 */           var4--;
/*     */         }
/*     */       } 
/*     */     } 
/* 187 */     return var4;
/*     */   }
/*     */   
/*     */   public void cursorPos(int par1) {
/* 191 */     setCursorPosition(this.selectionEnd + par1);
/*     */   }
/*     */   
/*     */   public void setCursorPosition(int par1) {
/* 195 */     this.cursorPosition = par1;
/* 196 */     int var2 = this.text.length();
/* 197 */     if (this.cursorPosition < 0) {
/* 198 */       this.cursorPosition = 0;
/*     */     }
/* 200 */     if (this.cursorPosition > var2) {
/* 201 */       this.cursorPosition = var2;
/*     */     }
/* 203 */     func_73800_i(this.cursorPosition);
/*     */   }
/*     */   
/*     */   public void setCursorPositionZero() {
/* 207 */     setCursorPosition(0);
/*     */   }
/*     */   
/*     */   public void setCursorPositionEnd() {
/* 211 */     setCursorPosition(this.text.length());
/*     */   }
/*     */   
/*     */   public boolean textboxKeyTyped(char par1, int par2) {
/* 215 */     if (!this.isEnabled || !this.isFocused) {
/* 216 */       return false;
/*     */     }
/* 218 */     switch (par1) {
/*     */       case '\001':
/* 220 */         setCursorPositionEnd();
/* 221 */         func_73800_i(0);
/* 222 */         return true;
/*     */       
/*     */       case '\003':
/* 225 */         GuiScreen.setClipboardString(getSelectedtext());
/* 226 */         return true;
/*     */       
/*     */       case '\026':
/* 229 */         writeText(GuiScreen.getClipboardString());
/* 230 */         return true;
/*     */       
/*     */       case '\030':
/* 233 */         GuiScreen.setClipboardString(getSelectedtext());
/* 234 */         writeText("");
/* 235 */         return true;
/*     */     } 
/*     */     
/* 238 */     switch (par2) {
/*     */       case 14:
/* 240 */         if (GuiScreen.isCtrlKeyDown()) {
/* 241 */           func_73779_a(-1);
/*     */         } else {
/*     */           
/* 244 */           deleteFromCursor(-1);
/*     */         } 
/* 246 */         return true;
/*     */       
/*     */       case 199:
/* 249 */         if (GuiScreen.isShiftKeyDown()) {
/* 250 */           func_73800_i(0);
/*     */         } else {
/*     */           
/* 253 */           setCursorPositionZero();
/*     */         } 
/* 255 */         return true;
/*     */       
/*     */       case 203:
/* 258 */         if (GuiScreen.isShiftKeyDown()) {
/* 259 */           if (GuiScreen.isCtrlKeyDown()) {
/* 260 */             func_73800_i(getNthWordFromPos(-1, getSelectionEnd()));
/*     */           } else {
/*     */             
/* 263 */             func_73800_i(getSelectionEnd() - 1);
/*     */           }
/*     */         
/* 266 */         } else if (GuiScreen.isCtrlKeyDown()) {
/* 267 */           setCursorPosition(getNthWordFromCursor(-1));
/*     */         } else {
/*     */           
/* 270 */           cursorPos(-1);
/*     */         } 
/* 272 */         return true;
/*     */       
/*     */       case 205:
/* 275 */         if (GuiScreen.isShiftKeyDown()) {
/* 276 */           if (GuiScreen.isCtrlKeyDown()) {
/* 277 */             func_73800_i(getNthWordFromPos(1, getSelectionEnd()));
/*     */           } else {
/*     */             
/* 280 */             func_73800_i(getSelectionEnd() + 1);
/*     */           }
/*     */         
/* 283 */         } else if (GuiScreen.isCtrlKeyDown()) {
/* 284 */           setCursorPosition(getNthWordFromCursor(1));
/*     */         } else {
/*     */           
/* 287 */           cursorPos(1);
/*     */         } 
/* 289 */         return true;
/*     */       
/*     */       case 207:
/* 292 */         if (GuiScreen.isShiftKeyDown()) {
/* 293 */           func_73800_i(this.text.length());
/*     */         } else {
/*     */           
/* 296 */           setCursorPositionEnd();
/*     */         } 
/* 298 */         return true;
/*     */       
/*     */       case 211:
/* 301 */         if (GuiScreen.isCtrlKeyDown()) {
/* 302 */           func_73779_a(1);
/*     */         } else {
/*     */           
/* 305 */           deleteFromCursor(1);
/*     */         } 
/* 307 */         return true;
/*     */     } 
/*     */     
/* 310 */     if (ChatAllowedCharacters.isAllowedCharacter(par1)) {
/* 311 */       writeText(Character.toString(par1));
/* 312 */       return true;
/*     */     } 
/* 314 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void mouseClicked(int par1, int par2, int par3) {
/* 322 */     boolean var4 = (par1 >= this.xPos && par1 < this.xPos + this.width && par2 >= this.yPos && par2 < this.yPos + this.height);
/* 323 */     if (this.canLoseFocus) {
/* 324 */       setFocused((this.isEnabled && var4));
/*     */     }
/* 326 */     if (this.isFocused && par3 == 0) {
/* 327 */       int var5 = par1 - this.xPos;
/* 328 */       if (this.enableBackgroundDrawing) {
/* 329 */         var5 -= 4;
/*     */       }
/* 331 */       String var6 = this.fontRenderer.trimStringToWidth(this.text.substring(this.i), getWidth());
/* 332 */       setCursorPosition(this.fontRenderer.trimStringToWidth(var6, var5).length() + this.i);
/*     */     } 
/*     */   }
/*     */   
/*     */   public void drawTextBox() {
/* 337 */     if (func_73778_q()) {
/* 338 */       if (getEnableBackgroundDrawing()) {
/* 339 */         Gui.drawRect(this.xPos - 1, this.yPos - 1, this.xPos + this.width + 1, this.yPos + this.height + 1, -6250336);
/* 340 */         Gui.drawRect(this.xPos, this.yPos, this.xPos + this.width, this.yPos + this.height, -16777216);
/*     */       } 
/* 342 */       int var1 = this.isEnabled ? this.enabledColor : this.disabledColor;
/* 343 */       int var2 = this.cursorPosition - this.i;
/* 344 */       int var3 = this.selectionEnd - this.i;
/* 345 */       String var4 = this.fontRenderer.trimStringToWidth(this.text.substring(this.i), getWidth());
/* 346 */       boolean var5 = (var2 >= 0 && var2 <= var4.length());
/* 347 */       boolean var6 = (this.isFocused && this.cursorCounter / 6 % 2 == 0 && var5);
/* 348 */       int var7 = this.enableBackgroundDrawing ? (this.xPos + 4) : this.xPos;
/* 349 */       int var8 = this.enableBackgroundDrawing ? (this.yPos + (this.height - 8) / 2) : this.yPos;
/* 350 */       int var9 = var7;
/* 351 */       if (var3 > var4.length()) {
/* 352 */         var3 = var4.length();
/*     */       }
/* 354 */       if (var4.length() > 0) {
/* 355 */         if (var5) {
/* 356 */           var4.substring(0, var2);
/*     */         }
/* 358 */         var9 = (Minecraft.getMinecraft()).fontRendererObj.drawStringWithShadow(this.text.replaceAll("(?s).", "*"), var7, var8, var1);
/*     */       } 
/* 360 */       boolean var10 = !(this.cursorPosition >= this.text.length() && this.text.length() < getMaxStringLength());
/* 361 */       int var11 = var9;
/* 362 */       if (!var5) {
/* 363 */         var11 = (var2 > 0) ? (var7 + this.width) : var7;
/*     */       }
/* 365 */       else if (var10) {
/* 366 */         var11 = var9 - 1;
/* 367 */         var9--;
/*     */       } 
/* 369 */       if (var4.length() > 0 && var5 && var2 < var4.length()) {
/* 370 */         (Minecraft.getMinecraft()).fontRendererObj.drawStringWithShadow(var4.substring(var2), var9, var8, var1);
/*     */       }
/* 372 */       if (var6) {
/* 373 */         if (var10) {
/* 374 */           Gui.drawRect(var11, var8 - 1, var11 + 1, var8 + 1 + this.fontRenderer.FONT_HEIGHT, -3092272);
/*     */         } else {
/*     */           
/* 377 */           (Minecraft.getMinecraft()).fontRendererObj.drawStringWithShadow("_", var11, var8, var1);
/*     */         } 
/*     */       }
/* 380 */       if (var3 != var2) {
/* 381 */         int var12 = var7 + this.fontRenderer.getStringWidth(var4.substring(0, var3));
/* 382 */         drawCursorVertical(var11, var8 - 1, var12 - 1, var8 + 1 + this.fontRenderer.FONT_HEIGHT);
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   private void drawCursorVertical(int par1, int par2, int par3, int par4) {
/* 388 */     if (par1 < par3) {
/* 389 */       int var5 = par1;
/* 390 */       par1 = par3;
/* 391 */       par3 = var5;
/*     */     } 
/* 393 */     if (par2 < par4) {
/* 394 */       int var5 = par2;
/* 395 */       par2 = par4;
/* 396 */       par4 = var5;
/*     */     } 
/* 398 */     Tessellator var6 = Tessellator.getInstance();
/* 399 */     WorldRenderer var7 = var6.getWorldRenderer();
/* 400 */     GL11.glColor4f(0.0F, 0.0F, 255.0F, 255.0F);
/* 401 */     GL11.glDisable(3553);
/* 402 */     GL11.glEnable(3058);
/* 403 */     GL11.glLogicOp(5387);
/* 404 */     var7.begin(7, var7.getVertexFormat());
/* 405 */     var7.pos(par1, par4, 0.0D);
/* 406 */     var7.pos(par3, par4, 0.0D);
/* 407 */     var7.pos(par3, par2, 0.0D);
/* 408 */     var7.pos(par1, par2, 0.0D);
/* 409 */     var7.finishDrawing();
/* 410 */     GL11.glDisable(3058);
/* 411 */     GL11.glEnable(3553);
/*     */   }
/*     */   
/*     */   public void setMaxStringLength(int par1) {
/* 415 */     this.maxStringLength = par1;
/* 416 */     if (this.text.length() > par1) {
/* 417 */       this.text = this.text.substring(0, par1);
/*     */     }
/*     */   }
/*     */   
/*     */   public int getMaxStringLength() {
/* 422 */     return this.maxStringLength;
/*     */   }
/*     */   
/*     */   public int getCursorPosition() {
/* 426 */     return this.cursorPosition;
/*     */   }
/*     */   
/*     */   public boolean getEnableBackgroundDrawing() {
/* 430 */     return this.enableBackgroundDrawing;
/*     */   }
/*     */   
/*     */   public void setEnableBackgroundDrawing(boolean par1) {
/* 434 */     this.enableBackgroundDrawing = par1;
/*     */   }
/*     */   
/*     */   public void func_73794_g(int par1) {
/* 438 */     this.enabledColor = par1;
/*     */   }
/*     */   
/*     */   public void setFocused(boolean par1) {
/* 442 */     if (par1 && !this.isFocused) {
/* 443 */       this.cursorCounter = 0;
/*     */     }
/* 445 */     this.isFocused = par1;
/*     */   }
/*     */   
/*     */   public boolean isFocused() {
/* 449 */     return this.isFocused;
/*     */   }
/*     */   
/*     */   public int getSelectionEnd() {
/* 453 */     return this.selectionEnd;
/*     */   }
/*     */   
/*     */   public int getWidth() {
/* 457 */     return getEnableBackgroundDrawing() ? (this.width - 8) : this.width;
/*     */   }
/*     */   
/*     */   public void func_73800_i(int par1) {
/* 461 */     int var2 = this.text.length();
/* 462 */     if (par1 > var2) {
/* 463 */       par1 = var2;
/*     */     }
/* 465 */     if (par1 < 0) {
/* 466 */       par1 = 0;
/*     */     }
/* 468 */     this.selectionEnd = par1;
/* 469 */     if (this.fontRenderer != null) {
/* 470 */       if (this.i > var2) {
/* 471 */         this.i = var2;
/*     */       }
/* 473 */       int var3 = getWidth();
/* 474 */       String var4 = this.fontRenderer.trimStringToWidth(this.text.substring(this.i), var3);
/* 475 */       int var5 = var4.length() + this.i;
/* 476 */       if (par1 == this.i) {
/* 477 */         this.i -= this.fontRenderer.trimStringToWidth(this.text, var3, true).length();
/*     */       }
/* 479 */       if (par1 > var5) {
/* 480 */         this.i += par1 - var5;
/*     */       }
/* 482 */       else if (par1 <= this.i) {
/* 483 */         this.i -= this.i - par1;
/*     */       } 
/* 485 */       if (this.i < 0) {
/* 486 */         this.i = 0;
/*     */       }
/* 488 */       if (this.i > var2) {
/* 489 */         this.i = var2;
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public void setCanLoseFocus(boolean par1) {
/* 495 */     this.canLoseFocus = par1;
/*     */   }
/*     */   
/*     */   public boolean func_73778_q() {
/* 499 */     return this.b;
/*     */   }
/*     */   
/*     */   public void func_73790_e(boolean par1) {
/* 503 */     this.b = par1;
/*     */   }
/*     */ }


/* Location:              C:\Users\Lenovo\Downloads\ZyrexClientV1 (1).jar!\ZyrexClient\Gui\Login2\PasswordField.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */