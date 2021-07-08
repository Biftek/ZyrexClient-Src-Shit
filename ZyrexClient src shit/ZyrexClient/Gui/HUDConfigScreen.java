/*     */ package ZyrexClient.Gui;
/*     */ 
/*     */ import ZyrexClient.ModHuds.CosmeticsHud3;
/*     */ import ZyrexClient.ModHuds.ModHud5;
/*     */ import ZyrexClient.ModHuds.ModHud5_Settings;
/*     */ import ZyrexClient.ModHuds.SettingsButtonHud;
/*     */ import ZyrexClient.clickgui.RoundedButtons.ButtonMainMenu;
/*     */ import ZyrexClient.clickgui.RoundedButtons.ClientRoundedCosmeticsButton;
/*     */ import java.io.IOException;
/*     */ import java.util.Collection;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import java.util.Optional;
/*     */ import java.util.function.Predicate;
/*     */ import net.minecraft.client.Minecraft;
/*     */ import net.minecraft.client.gui.Gui;
/*     */ import net.minecraft.client.gui.GuiButton;
/*     */ import net.minecraft.client.gui.GuiScreen;
/*     */ import net.minecraft.client.gui.ScaledResolution;
/*     */ import net.minecraft.util.ResourceLocation;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class HUDConfigScreen
/*     */   extends GuiScreen
/*     */ {
/*  33 */   int i = 0;
/*     */   
/*     */   private int smX;
/*     */   
/*     */   private int smY;
/*     */   
/*     */   private boolean dragged = false;
/*     */   
/*     */   protected boolean hovered;
/*  42 */   private final HashMap<IRenderer, ScreenPosition> renderers = new HashMap<>();
/*     */   
/*  44 */   private Optional<IRenderer> selectedRenderer = Optional.empty();
/*     */   
/*     */   private int prevX;
/*     */   private int prevY;
/*     */   int fade;
/*     */   
/*     */   public void initGui() {
/*  51 */     ScaledResolution sr = new ScaledResolution(mc);
/*     */     
/*  53 */     buttonList.add(new ButtonMainMenu(50, sr.getScaledWidth() / 2 - 50, sr.getScaledHeight() / 2 + 10, 100, 22, "Settings"));
/*  54 */     buttonList.add(new SettingsButtonHud(52, sr.getScaledWidth() / 2 - 76, sr.getScaledHeight() / 2 + 10, 22, 22, ""));
/*  55 */     buttonList.add(new ClientRoundedCosmeticsButton(51, sr.getScaledWidth() / 2 + 54, sr.getScaledHeight() / 2 + 10, 22, 22, ""));
/*     */     
/*  57 */     super.initGui();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void actionPerformed(GuiButton button) throws IOException {
/*  63 */     if (button.id == 50) {
/*  64 */       mc.displayGuiScreen((GuiScreen)new ModHud5());
/*     */     }
/*     */     
/*  67 */     if (button.id == 51) {
/*  68 */       mc.displayGuiScreen((GuiScreen)new CosmeticsHud3());
/*     */     }
/*     */     
/*  71 */     if (button.id == 52) {
/*  72 */       mc.displayGuiScreen((GuiScreen)new ModHud5_Settings());
/*     */     }
/*     */     
/*  75 */     super.actionPerformed(button);
/*     */   }
/*     */ 
/*     */   
/*     */   public HUDConfigScreen(HUDManager api) {
/*  80 */     Collection<IRenderer> registeredRenderers = api.getRegisteredRenderers();
/*     */     
/*  82 */     for (IRenderer ren : registeredRenderers) {
/*  83 */       if (!ren.isEnabled()) {
/*     */         continue;
/*     */       }
/*     */       
/*  87 */       ScreenPosition pos = ren.load();
/*  88 */       if (pos == null) {
/*  89 */         pos = ScreenPosition.fromRelativePosition(0.5D, 0.5D);
/*     */       }
/*     */       
/*  92 */       adjustBounds(ren, pos);
/*  93 */       this.renderers.put(ren, pos);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void drawScreen(int mouseX, int mouseY, float partialTicks) {
/* 102 */     drawDefaultBackground();
/*     */     
/* 104 */     float zBackup = zLevel;
/* 105 */     zLevel = 200.0F;
/*     */     
/* 107 */     ScaledResolution sr = new ScaledResolution(mc);
/*     */     
/* 109 */     mc.getTextureManager().bindTexture(new ResourceLocation("zyrex_logo.png"));
/* 110 */     Gui.drawModalRectWithCustomSizedTexture(width / 2 - 34, height / 2 - 55, 0.0F, 0.0F, 70, 70, 70.0F, 70.0F);
/*     */ 
/*     */     
/* 113 */     for (IRenderer renderer : this.renderers.keySet()) {
/*     */       
/* 115 */       ScreenPosition pos = this.renderers.get(renderer);
/*     */       
/* 117 */       Gui.drawRect(pos.getAbsoluteX(), pos.getAbsoluteY(), pos.getAbsoluteX() + renderer.getWidth(), pos.getAbsoluteY() + renderer.getHeight(), 872415231);
/* 118 */       drawHollowRect(pos.getAbsoluteX(), pos.getAbsoluteY(), renderer.getWidth(), renderer.getHeight(), 1946157055);
/*     */ 
/*     */       
/* 121 */       renderer.renderDummy(pos);
/*     */       
/* 123 */       int absoluteX = pos.getAbsoluteX();
/* 124 */       int absoluteY = pos.getAbsoluteY();
/*     */       
/* 126 */       this.hovered = (mouseX >= absoluteX && mouseX <= absoluteX + renderer.getWidth() && mouseY >= absoluteY && mouseY <= absoluteY + renderer.getHeight());
/*     */       
/* 128 */       if (this.hovered) {
/* 129 */         if (this.dragged) {
/* 130 */           pos.setAbsolute(pos.getAbsoluteX() + mouseX - this.prevX, pos.getAbsoluteY() + mouseY - this.prevY);
/*     */           
/* 132 */           adjustBounds(renderer, pos);
/*     */           
/* 134 */           this.prevX = mouseX;
/* 135 */           this.prevY = mouseY;
/*     */         } 
/*     */         
/* 138 */         zLevel = zBackup;
/*     */       } 
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 145 */     this.smX = mouseX;
/* 146 */     this.smY = mouseY;
/*     */     
/* 148 */     zLevel = zBackup;
/* 149 */     super.drawScreen(mouseX, mouseY, partialTicks);
/*     */   }
/*     */ 
/*     */   
/*     */   private void drawHollowRect(int x, int y, int w, int h, int color) {
/* 154 */     drawHorizontalLine(x, x + w, y, color);
/* 155 */     drawHorizontalLine(x, x + w, y + h, color);
/*     */     
/* 157 */     drawVerticalLine(x, y + h, y, color);
/* 158 */     drawVerticalLine(x + w, y + h, y, color);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void keyTyped(char typedChar, int keyCode) throws IOException {
/* 164 */     if (keyCode == 1) {
/* 165 */       this.renderers.entrySet().forEach(entry -> ((IRenderer)entry.getKey()).save(entry.getValue()));
/*     */ 
/*     */       
/* 168 */       mc.displayGuiScreen(null);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   protected void mouseClickMove(int x, int y, int button, long time) {
/* 174 */     if (this.selectedRenderer.isPresent()) {
/* 175 */       moveSelectedRenderBy(x - this.prevX, y - this.prevY);
/*     */     }
/*     */     
/* 178 */     this.prevX = x;
/* 179 */     this.prevY = y;
/*     */   }
/*     */   
/*     */   private void moveSelectedRenderBy(int offsetX, int offsetY) {
/* 183 */     IRenderer renderer = this.selectedRenderer.get();
/* 184 */     ScreenPosition pos = this.renderers.get(renderer);
/*     */     
/* 186 */     pos.setAbsolute(pos.getAbsoluteX() + offsetX, pos.getAbsoluteY() + offsetY);
/*     */     
/* 188 */     if (pos.getAbsoluteX() == 0) {
/* 189 */       pos.setAbsolute(1, pos.getAbsoluteY());
/*     */     }
/*     */     
/* 192 */     if (pos.getAbsoluteY() == 0) {
/* 193 */       pos.setAbsolute(pos.getAbsoluteX(), 1);
/*     */     }
/*     */     
/* 196 */     adjustBounds(renderer, pos);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void onGuiClosed() {
/* 202 */     for (IRenderer renderer : this.renderers.keySet()) {
/* 203 */       renderer.save(this.renderers.get(renderer));
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean doesGuiPauseGame() {
/* 209 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   private void adjustBounds(IRenderer renderer, ScreenPosition pos) {
/* 214 */     ScaledResolution res = new ScaledResolution(Minecraft.getMinecraft());
/*     */     
/* 216 */     int screenWidth = res.getScaledWidth();
/* 217 */     int screenHeight = res.getScaledHeight();
/*     */     
/* 219 */     int absoluteX = Math.max(0, Math.min(pos.getAbsoluteX(), Math.max(screenWidth - renderer.getWidth(), 0)));
/* 220 */     int absoluteY = Math.max(0, Math.min(pos.getAbsoluteY(), Math.max(screenHeight - renderer.getHeight(), 0)));
/*     */     
/* 222 */     pos.setAbsolute(absoluteX, absoluteY);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void mouseClicked(int x, int y, int button) throws IOException {
/* 227 */     this.prevX = x;
/* 228 */     this.prevY = y;
/*     */     
/* 230 */     this.dragged = true;
/*     */     
/* 232 */     loadMouseOver(x, y);
/* 233 */     super.mouseClicked(x, y, button);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void mouseReleased(int mouseX, int mouseY, int state) {
/* 239 */     this.dragged = false;
/*     */     
/* 241 */     super.mouseReleased(mouseX, mouseY, state);
/*     */   }
/*     */   
/*     */   private void loadMouseOver(int x, int y) {
/* 245 */     this.selectedRenderer = this.renderers.keySet().stream().filter(new MouseOverFinder(x, y)).findFirst();
/*     */   }
/*     */   
/*     */   private class MouseOverFinder implements Predicate<IRenderer> {
/*     */     private int mouseX;
/*     */     private int mouseY;
/*     */     
/*     */     public MouseOverFinder(int x, int y) {
/* 253 */       this.mouseX = x;
/* 254 */       this.mouseY = y;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public boolean test(IRenderer renderer) {
/* 260 */       ScreenPosition pos = (ScreenPosition)HUDConfigScreen.this.renderers.get(renderer);
/*     */       
/* 262 */       int absoluteX = pos.getAbsoluteX();
/* 263 */       int absoluteY = pos.getAbsoluteY();
/*     */       
/* 265 */       if (this.mouseX >= absoluteX && this.mouseX <= absoluteX + renderer.getWidth())
/*     */       {
/* 267 */         if (this.mouseY >= absoluteY && this.mouseY <= absoluteY + renderer.getHeight())
/*     */         {
/* 269 */           return true;
/*     */         }
/*     */       }
/*     */ 
/*     */ 
/*     */       
/* 275 */       return false;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Lenovo\Downloads\ZyrexClientV1 (1).jar!\ZyrexClient\Gui\HUDConfigScreen.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */