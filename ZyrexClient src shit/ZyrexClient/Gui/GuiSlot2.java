/*     */ package ZyrexClient.Gui;
/*     */ 
/*     */ import net.minecraft.client.Minecraft;
/*     */ import net.minecraft.client.gui.Gui;
/*     */ import net.minecraft.client.gui.GuiButton;
/*     */ import net.minecraft.client.renderer.GlStateManager;
/*     */ import net.minecraft.client.renderer.Tessellator;
/*     */ import net.minecraft.client.renderer.WorldRenderer;
/*     */ import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
/*     */ import net.minecraft.util.MathHelper;
/*     */ import net.minecraft.util.ResourceLocation;
/*     */ import org.lwjgl.input.Mouse;
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
/*     */ public abstract class GuiSlot2
/*     */ {
/*     */   protected final Minecraft mc;
/*     */   protected int width;
/*     */   protected int height;
/*     */   protected int top;
/*     */   protected int bottom;
/*     */   protected int right;
/*     */   protected int left;
/*     */   protected final int slotHeight;
/*     */   private int scrollUpButtonID;
/*     */   private int scrollDownButtonID;
/*     */   protected int mouseX;
/*     */   protected int mouseY;
/*     */   protected boolean field_148163_i = true;
/*  42 */   protected int initialClickY = -2;
/*     */ 
/*     */ 
/*     */   
/*     */   protected float scrollMultiplier;
/*     */ 
/*     */ 
/*     */   
/*     */   protected float amountScrolled;
/*     */ 
/*     */ 
/*     */   
/*  54 */   protected int selectedElement = -1;
/*     */   
/*     */   protected long lastClicked;
/*     */   
/*     */   protected boolean field_178041_q = true;
/*     */   
/*     */   protected boolean showSelectionBox = true;
/*     */   
/*     */   protected boolean hasListHeader;
/*     */   
/*     */   protected int headerPadding;
/*     */   
/*     */   private boolean enabled = true;
/*     */ 
/*     */   
/*     */   public GuiSlot2(Minecraft mcIn, int width, int height, int topIn, int bottomIn, int slotHeightIn) {
/*  70 */     this.mc = mcIn;
/*  71 */     this.width = width;
/*  72 */     this.height = height;
/*  73 */     this.top = topIn;
/*  74 */     this.bottom = bottomIn;
/*  75 */     this.slotHeight = slotHeightIn;
/*  76 */     this.left = 0;
/*  77 */     this.right = width;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setDimensions(int widthIn, int heightIn, int topIn, int bottomIn) {
/*  82 */     this.width = widthIn;
/*  83 */     this.height = heightIn;
/*  84 */     this.top = topIn;
/*  85 */     this.bottom = bottomIn;
/*  86 */     this.left = 0;
/*  87 */     this.right = widthIn;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setShowSelectionBox(boolean showSelectionBoxIn) {
/*  92 */     this.showSelectionBox = showSelectionBoxIn;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void setHasListHeader(boolean hasListHeaderIn, int headerPaddingIn) {
/* 101 */     this.hasListHeader = hasListHeaderIn;
/* 102 */     this.headerPadding = headerPaddingIn;
/*     */     
/* 104 */     if (!hasListHeaderIn)
/*     */     {
/* 106 */       this.headerPadding = 0;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected abstract int getSize();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected abstract void elementClicked(int paramInt1, boolean paramBoolean, int paramInt2, int paramInt3);
/*     */ 
/*     */ 
/*     */   
/*     */   protected abstract boolean isSelected(int paramInt);
/*     */ 
/*     */ 
/*     */   
/*     */   protected int getContentHeight() {
/* 127 */     return getSize() * this.slotHeight + this.headerPadding;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected abstract void drawBackground();
/*     */ 
/*     */ 
/*     */   
/*     */   protected void func_178040_a(int p_178040_1_, int p_178040_2_, int p_178040_3_) {}
/*     */ 
/*     */ 
/*     */   
/*     */   protected abstract void drawSlot(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6);
/*     */ 
/*     */ 
/*     */   
/*     */   protected void drawListHeader(int p_148129_1_, int p_148129_2_, Tessellator p_148129_3_) {}
/*     */ 
/*     */ 
/*     */   
/*     */   protected void func_148132_a(int p_148132_1_, int p_148132_2_) {}
/*     */ 
/*     */   
/*     */   protected void func_148142_b(int p_148142_1_, int p_148142_2_) {}
/*     */ 
/*     */   
/*     */   public int getSlotIndexFromScreenCoords(int p_148124_1_, int p_148124_2_) {
/* 155 */     int i = this.left + this.width / 2 - getListWidth() / 2;
/* 156 */     int j = this.left + this.width / 2 + getListWidth() / 2;
/* 157 */     int k = p_148124_2_ - this.top - this.headerPadding + (int)this.amountScrolled - 4;
/* 158 */     int l = k / this.slotHeight;
/* 159 */     return (p_148124_1_ < getScrollBarX() && p_148124_1_ >= i && p_148124_1_ <= j && l >= 0 && k >= 0 && l < getSize()) ? l : -1;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void registerScrollButtons(int scrollUpButtonIDIn, int scrollDownButtonIDIn) {
/* 167 */     this.scrollUpButtonID = scrollUpButtonIDIn;
/* 168 */     this.scrollDownButtonID = scrollDownButtonIDIn;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void bindAmountScrolled() {
/* 176 */     this.amountScrolled = MathHelper.clamp_float(this.amountScrolled, 0.0F, func_148135_f());
/*     */   }
/*     */ 
/*     */   
/*     */   public int func_148135_f() {
/* 181 */     return Math.max(0, getContentHeight() - this.bottom - this.top - 4);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getAmountScrolled() {
/* 189 */     return (int)this.amountScrolled;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isMouseYWithinSlotBounds(int p_148141_1_) {
/* 194 */     return (p_148141_1_ >= this.top && p_148141_1_ <= this.bottom && this.mouseX >= this.left && this.mouseX <= this.right);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void scrollBy(int amount) {
/* 202 */     this.amountScrolled += amount;
/* 203 */     bindAmountScrolled();
/* 204 */     this.initialClickY = -2;
/*     */   }
/*     */ 
/*     */   
/*     */   public void actionPerformed(GuiButton button) {
/* 209 */     if (button.enabled)
/*     */     {
/* 211 */       if (button.id == this.scrollUpButtonID) {
/*     */         
/* 213 */         this.amountScrolled -= (this.slotHeight * 2 / 3);
/* 214 */         this.initialClickY = -2;
/* 215 */         bindAmountScrolled();
/*     */       }
/* 217 */       else if (button.id == this.scrollDownButtonID) {
/*     */         
/* 219 */         this.amountScrolled += (this.slotHeight * 2 / 3);
/* 220 */         this.initialClickY = -2;
/* 221 */         bindAmountScrolled();
/*     */       } 
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public void drawScreen(int mouseXIn, int mouseYIn, float p_148128_3_) {
/* 228 */     if (this.field_178041_q) {
/*     */       
/* 230 */       this.mouseX = mouseXIn;
/* 231 */       this.mouseY = mouseYIn;
/* 232 */       drawBackground();
/* 233 */       int i = getScrollBarX();
/* 234 */       int j = i + 6;
/* 235 */       bindAmountScrolled();
/* 236 */       GlStateManager.disableLighting();
/* 237 */       GlStateManager.disableFog();
/* 238 */       Tessellator tessellator = Tessellator.getInstance();
/* 239 */       WorldRenderer worldrenderer = tessellator.getWorldRenderer();
/* 240 */       this.mc.getTextureManager().bindTexture(Gui.optionsBackground);
/* 241 */       GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
/* 242 */       float f = 32.0F;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 250 */       this.mc.getTextureManager().bindTexture(new ResourceLocation("Images/szialajkos.png"));
/* 251 */       Gui.drawScaledCustomSizeModalRect(0, 0, 0.0F, 0.0F, this.width, this.height, this.width, this.height, this.width, this.height);
/*     */       
/* 253 */       int k = this.left + this.width / 2 - getListWidth() / 2 + 2;
/* 254 */       int l = this.top + 4 - (int)this.amountScrolled;
/*     */       
/* 256 */       if (this.hasListHeader)
/*     */       {
/* 258 */         drawListHeader(k, l, tessellator);
/*     */       }
/*     */       
/* 261 */       drawSelectionBox(k, l, mouseXIn, mouseYIn);
/* 262 */       GlStateManager.disableDepth();
/* 263 */       int i1 = 4;
/* 264 */       GlStateManager.enableBlend();
/* 265 */       GlStateManager.tryBlendFuncSeparate(770, 771, 0, 1);
/* 266 */       GlStateManager.disableAlpha();
/* 267 */       GlStateManager.shadeModel(7425);
/* 268 */       GlStateManager.disableTexture2D();
/* 269 */       worldrenderer.begin(7, DefaultVertexFormats.POSITION_TEX_COLOR);
/* 270 */       worldrenderer.pos(this.left, (this.top + i1), 0.0D).tex(0.0D, 1.0D).color(0, 0, 0, 0).endVertex();
/* 271 */       worldrenderer.pos(this.right, (this.top + i1), 0.0D).tex(1.0D, 1.0D).color(0, 0, 0, 0).endVertex();
/* 272 */       worldrenderer.pos(this.right, this.top, 0.0D).tex(1.0D, 0.0D).color(0, 0, 0, 255).endVertex();
/* 273 */       worldrenderer.pos(this.left, this.top, 0.0D).tex(0.0D, 0.0D).color(0, 0, 0, 255).endVertex();
/* 274 */       tessellator.draw();
/* 275 */       worldrenderer.begin(7, DefaultVertexFormats.POSITION_TEX_COLOR);
/* 276 */       worldrenderer.pos(this.left, this.bottom, 0.0D).tex(0.0D, 1.0D).color(0, 0, 0, 255).endVertex();
/* 277 */       worldrenderer.pos(this.right, this.bottom, 0.0D).tex(1.0D, 1.0D).color(0, 0, 0, 255).endVertex();
/* 278 */       worldrenderer.pos(this.right, (this.bottom - i1), 0.0D).tex(1.0D, 0.0D).color(0, 0, 0, 0).endVertex();
/* 279 */       worldrenderer.pos(this.left, (this.bottom - i1), 0.0D).tex(0.0D, 0.0D).color(0, 0, 0, 0).endVertex();
/* 280 */       tessellator.draw();
/* 281 */       int j1 = func_148135_f();
/*     */       
/* 283 */       if (j1 > 0) {
/*     */         
/* 285 */         int k1 = (this.bottom - this.top) * (this.bottom - this.top) / getContentHeight();
/* 286 */         k1 = MathHelper.clamp_int(k1, 32, this.bottom - this.top - 8);
/* 287 */         int l1 = (int)this.amountScrolled * (this.bottom - this.top - k1) / j1 + this.top;
/*     */         
/* 289 */         if (l1 < this.top)
/*     */         {
/* 291 */           l1 = this.top;
/*     */         }
/*     */         
/* 294 */         worldrenderer.begin(7, DefaultVertexFormats.POSITION_TEX_COLOR);
/* 295 */         worldrenderer.pos(i, this.bottom, 0.0D).tex(0.0D, 1.0D).color(0, 0, 0, 255).endVertex();
/* 296 */         worldrenderer.pos(j, this.bottom, 0.0D).tex(1.0D, 1.0D).color(0, 0, 0, 255).endVertex();
/* 297 */         worldrenderer.pos(j, this.top, 0.0D).tex(1.0D, 0.0D).color(0, 0, 0, 255).endVertex();
/* 298 */         worldrenderer.pos(i, this.top, 0.0D).tex(0.0D, 0.0D).color(0, 0, 0, 255).endVertex();
/* 299 */         tessellator.draw();
/* 300 */         worldrenderer.begin(7, DefaultVertexFormats.POSITION_TEX_COLOR);
/* 301 */         worldrenderer.pos(i, (l1 + k1), 0.0D).tex(0.0D, 1.0D).color(128, 128, 128, 255).endVertex();
/* 302 */         worldrenderer.pos(j, (l1 + k1), 0.0D).tex(1.0D, 1.0D).color(128, 128, 128, 255).endVertex();
/* 303 */         worldrenderer.pos(j, l1, 0.0D).tex(1.0D, 0.0D).color(128, 128, 128, 255).endVertex();
/* 304 */         worldrenderer.pos(i, l1, 0.0D).tex(0.0D, 0.0D).color(128, 128, 128, 255).endVertex();
/* 305 */         tessellator.draw();
/* 306 */         worldrenderer.begin(7, DefaultVertexFormats.POSITION_TEX_COLOR);
/* 307 */         worldrenderer.pos(i, (l1 + k1 - 1), 0.0D).tex(0.0D, 1.0D).color(192, 192, 192, 255).endVertex();
/* 308 */         worldrenderer.pos((j - 1), (l1 + k1 - 1), 0.0D).tex(1.0D, 1.0D).color(192, 192, 192, 255).endVertex();
/* 309 */         worldrenderer.pos((j - 1), l1, 0.0D).tex(1.0D, 0.0D).color(192, 192, 192, 255).endVertex();
/* 310 */         worldrenderer.pos(i, l1, 0.0D).tex(0.0D, 0.0D).color(192, 192, 192, 255).endVertex();
/* 311 */         tessellator.draw();
/*     */       } 
/*     */       
/* 314 */       func_148142_b(mouseXIn, mouseYIn);
/* 315 */       GlStateManager.enableTexture2D();
/* 316 */       GlStateManager.shadeModel(7424);
/* 317 */       GlStateManager.enableAlpha();
/* 318 */       GlStateManager.disableBlend();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void handleMouseInput() {
/* 324 */     if (isMouseYWithinSlotBounds(this.mouseY)) {
/*     */       
/* 326 */       if (Mouse.getEventButton() == 0 && Mouse.getEventButtonState() && this.mouseY >= this.top && this.mouseY <= this.bottom) {
/*     */         
/* 328 */         int i = (this.width - getListWidth()) / 2;
/* 329 */         int j = (this.width + getListWidth()) / 2;
/* 330 */         int k = this.mouseY - this.top - this.headerPadding + (int)this.amountScrolled - 4;
/* 331 */         int l = k / this.slotHeight;
/*     */         
/* 333 */         if (l < getSize() && this.mouseX >= i && this.mouseX <= j && l >= 0 && k >= 0) {
/*     */           
/* 335 */           elementClicked(l, false, this.mouseX, this.mouseY);
/* 336 */           this.selectedElement = l;
/*     */         }
/* 338 */         else if (this.mouseX >= i && this.mouseX <= j && k < 0) {
/*     */           
/* 340 */           func_148132_a(this.mouseX - i, this.mouseY - this.top + (int)this.amountScrolled - 4);
/*     */         } 
/*     */       } 
/*     */       
/* 344 */       if (Mouse.isButtonDown(0) && getEnabled()) {
/*     */         
/* 346 */         if (this.initialClickY == -1) {
/*     */           
/* 348 */           boolean flag1 = true;
/*     */           
/* 350 */           if (this.mouseY >= this.top && this.mouseY <= this.bottom) {
/*     */             
/* 352 */             int j2 = (this.width - getListWidth()) / 2;
/* 353 */             int k2 = (this.width + getListWidth()) / 2;
/* 354 */             int l2 = this.mouseY - this.top - this.headerPadding + (int)this.amountScrolled - 4;
/* 355 */             int i1 = l2 / this.slotHeight;
/*     */             
/* 357 */             if (i1 < getSize() && this.mouseX >= j2 && this.mouseX <= k2 && i1 >= 0 && l2 >= 0) {
/*     */               
/* 359 */               boolean flag = (i1 == this.selectedElement && Minecraft.getSystemTime() - this.lastClicked < 250L);
/* 360 */               elementClicked(i1, flag, this.mouseX, this.mouseY);
/* 361 */               this.selectedElement = i1;
/* 362 */               this.lastClicked = Minecraft.getSystemTime();
/*     */             }
/* 364 */             else if (this.mouseX >= j2 && this.mouseX <= k2 && l2 < 0) {
/*     */               
/* 366 */               func_148132_a(this.mouseX - j2, this.mouseY - this.top + (int)this.amountScrolled - 4);
/* 367 */               flag1 = false;
/*     */             } 
/*     */             
/* 370 */             int i3 = getScrollBarX();
/* 371 */             int j1 = i3 + 6;
/*     */             
/* 373 */             if (this.mouseX >= i3 && this.mouseX <= j1) {
/*     */               
/* 375 */               this.scrollMultiplier = -1.0F;
/* 376 */               int k1 = func_148135_f();
/*     */               
/* 378 */               if (k1 < 1)
/*     */               {
/* 380 */                 k1 = 1;
/*     */               }
/*     */               
/* 383 */               int l1 = (int)(((this.bottom - this.top) * (this.bottom - this.top)) / getContentHeight());
/* 384 */               l1 = MathHelper.clamp_int(l1, 32, this.bottom - this.top - 8);
/* 385 */               this.scrollMultiplier /= (this.bottom - this.top - l1) / k1;
/*     */             }
/*     */             else {
/*     */               
/* 389 */               this.scrollMultiplier = 1.0F;
/*     */             } 
/*     */             
/* 392 */             if (flag1)
/*     */             {
/* 394 */               this.initialClickY = this.mouseY;
/*     */             }
/*     */             else
/*     */             {
/* 398 */               this.initialClickY = -2;
/*     */             }
/*     */           
/*     */           } else {
/*     */             
/* 403 */             this.initialClickY = -2;
/*     */           }
/*     */         
/* 406 */         } else if (this.initialClickY >= 0) {
/*     */           
/* 408 */           this.amountScrolled -= (this.mouseY - this.initialClickY) * this.scrollMultiplier;
/* 409 */           this.initialClickY = this.mouseY;
/*     */         }
/*     */       
/*     */       } else {
/*     */         
/* 414 */         this.initialClickY = -1;
/*     */       } 
/*     */       
/* 417 */       int i2 = Mouse.getEventDWheel();
/*     */       
/* 419 */       if (i2 != 0) {
/*     */         
/* 421 */         if (i2 > 0) {
/*     */           
/* 423 */           i2 = -1;
/*     */         }
/* 425 */         else if (i2 < 0) {
/*     */           
/* 427 */           i2 = 1;
/*     */         } 
/*     */         
/* 430 */         this.amountScrolled += (i2 * this.slotHeight / 2);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void setEnabled(boolean enabledIn) {
/* 437 */     this.enabled = enabledIn;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean getEnabled() {
/* 442 */     return this.enabled;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getListWidth() {
/* 450 */     return 220;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void drawSelectionBox(int p_148120_1_, int p_148120_2_, int mouseXIn, int mouseYIn) {
/* 458 */     int i = getSize();
/* 459 */     Tessellator tessellator = Tessellator.getInstance();
/* 460 */     WorldRenderer worldrenderer = tessellator.getWorldRenderer();
/*     */     
/* 462 */     for (int j = 0; j < i; j++) {
/*     */       
/* 464 */       int k = p_148120_2_ + j * this.slotHeight + this.headerPadding;
/* 465 */       int l = this.slotHeight - 4;
/*     */       
/* 467 */       if (k > this.bottom || k + l < this.top)
/*     */       {
/* 469 */         func_178040_a(j, p_148120_1_, k);
/*     */       }
/*     */       
/* 472 */       if (this.showSelectionBox && isSelected(j)) {
/*     */         
/* 474 */         int i1 = this.left + this.width / 2 - getListWidth() / 2;
/* 475 */         int j1 = this.left + this.width / 2 + getListWidth() / 2;
/* 476 */         GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
/* 477 */         GlStateManager.disableTexture2D();
/* 478 */         worldrenderer.begin(7, DefaultVertexFormats.POSITION_TEX_COLOR);
/* 479 */         worldrenderer.pos(i1, (k + l + 2), 0.0D).tex(0.0D, 1.0D).color(128, 128, 128, 255).endVertex();
/* 480 */         worldrenderer.pos(j1, (k + l + 2), 0.0D).tex(1.0D, 1.0D).color(128, 128, 128, 255).endVertex();
/* 481 */         worldrenderer.pos(j1, (k - 2), 0.0D).tex(1.0D, 0.0D).color(128, 128, 128, 255).endVertex();
/* 482 */         worldrenderer.pos(i1, (k - 2), 0.0D).tex(0.0D, 0.0D).color(128, 128, 128, 255).endVertex();
/* 483 */         worldrenderer.pos((i1 + 1), (k + l + 1), 0.0D).tex(0.0D, 1.0D).color(0, 0, 0, 255).endVertex();
/* 484 */         worldrenderer.pos((j1 - 1), (k + l + 1), 0.0D).tex(1.0D, 1.0D).color(0, 0, 0, 255).endVertex();
/* 485 */         worldrenderer.pos((j1 - 1), (k - 1), 0.0D).tex(1.0D, 0.0D).color(0, 0, 0, 255).endVertex();
/* 486 */         worldrenderer.pos((i1 + 1), (k - 1), 0.0D).tex(0.0D, 0.0D).color(0, 0, 0, 255).endVertex();
/* 487 */         tessellator.draw();
/* 488 */         GlStateManager.enableTexture2D();
/*     */       } 
/*     */       
/* 491 */       drawSlot(j, p_148120_1_, k, l, mouseXIn, mouseYIn);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   protected int getScrollBarX() {
/* 497 */     return this.width / 2 + 124;
/*     */   }
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
/*     */   protected void overlayBackground(int startY, int endY, int startAlpha, int endAlpha) {}
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
/*     */   public void setSlotXBoundsFromLeft(int leftIn) {
/* 523 */     this.left = leftIn;
/* 524 */     this.right = leftIn + this.width;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getSlotHeight() {
/* 529 */     return this.slotHeight;
/*     */   }
/*     */ }


/* Location:              C:\Users\Lenovo\Downloads\ZyrexClientV1 (1).jar!\ZyrexClient\Gui\GuiSlot2.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */