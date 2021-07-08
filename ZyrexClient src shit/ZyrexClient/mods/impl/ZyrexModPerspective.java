/*     */ package ZyrexClient.mods.impl;
/*     */ 
/*     */ import ZyrexClient.EventTarget;
/*     */ import ZyrexClient.Gui.ScreenPosition;
/*     */ import ZyrexClient.KeyEvent;
/*     */ import ZyrexClient.mods.ModDraggable;
/*     */ import net.minecraft.client.Minecraft;
/*     */ import org.lwjgl.input.Keyboard;
/*     */ import org.lwjgl.opengl.Display;
/*     */ 
/*     */ 
/*     */ public class ZyrexModPerspective
/*     */   extends ModDraggable
/*     */ {
/*  15 */   private static Minecraft mc = Minecraft.getMinecraft();
/*     */   
/*  17 */   private static float cameraYaw = 0.0F;
/*  18 */   private static float cameraPitch = 0.0F;
/*  19 */   private static int previousePrespective = 0;
/*     */   private static boolean perspectiveToggled = false;
/*     */   public static boolean returnOnRelease = true;
/*     */   
/*     */   @EventTarget
/*     */   public void keyboardEvent(KeyEvent e) {
/*  25 */     Minecraft mc = Minecraft.getMinecraft();
/*  26 */     if (e.getKey() == mc.gameSettings.CLIENT_PERSPECTIVE_TOGGLE.getKeyCode())
/*     */     {
/*  28 */       if (Keyboard.getEventKeyState()) {
/*     */         
/*  30 */         perspectiveToggled = !perspectiveToggled;
/*     */         
/*  32 */         cameraYaw = Minecraft.thePlayer.rotationYaw;
/*  33 */         cameraPitch = Minecraft.thePlayer.rotationPitch;
/*     */         
/*  35 */         if (perspectiveToggled) {
/*  36 */           previousePrespective = mc.gameSettings.thirdPersonView;
/*  37 */           mc.gameSettings.thirdPersonView = 1;
/*     */         } else {
/*     */           
/*  40 */           mc.gameSettings.thirdPersonView = previousePrespective;
/*     */         }
/*     */       
/*     */       }
/*  44 */       else if (returnOnRelease) {
/*  45 */         perspectiveToggled = false;
/*  46 */         mc.gameSettings.thirdPersonView = previousePrespective;
/*     */       } 
/*     */     }
/*     */     
/*  50 */     if (Keyboard.getEventKey() == mc.gameSettings.keyBindTogglePerspective.getKeyCode()) {
/*  51 */       perspectiveToggled = false;
/*     */     }
/*     */   }
/*     */   
/*     */   public static float getCameraYaw() {
/*  56 */     Minecraft mc = Minecraft.getMinecraft();
/*  57 */     return perspectiveToggled ? cameraYaw : Minecraft.thePlayer.rotationYaw;
/*     */   }
/*     */   
/*     */   public static float getCameraPitch() {
/*  61 */     Minecraft mc = Minecraft.getMinecraft();
/*  62 */     return perspectiveToggled ? cameraPitch : Minecraft.thePlayer.rotationPitch;
/*     */   }
/*     */   
/*     */   public static boolean overriderMouse() {
/*  66 */     Minecraft mc = Minecraft.getMinecraft();
/*  67 */     if (mc.inGameHasFocus && Display.isActive()) {
/*     */       
/*  69 */       if (!perspectiveToggled) {
/*  70 */         return true;
/*     */       }
/*     */       
/*  73 */       mc.mouseHelper.mouseXYChange();
/*  74 */       float f1 = mc.gameSettings.mouseSensitivity * 0.6F + 0.2F;
/*  75 */       float f2 = f1 * f1 * f1 * 8.0F;
/*  76 */       float f3 = mc.mouseHelper.deltaX * f2;
/*  77 */       float f4 = mc.mouseHelper.deltaY * f2;
/*     */       
/*  79 */       cameraYaw += f3 * 0.15F;
/*  80 */       cameraPitch += f4 * 0.15F;
/*     */       
/*  82 */       if (cameraPitch > 90.0F) cameraPitch = 90.0F; 
/*  83 */       if (cameraPitch < -90.0F) cameraPitch = -90.0F;
/*     */     
/*     */     } 
/*     */     
/*  87 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int getWidth() {
/*  93 */     return this.font.getStringWidth("[Freelook (Toggled)]");
/*     */   }
/*     */ 
/*     */   
/*     */   public int getHeight() {
/*  98 */     return this.font.FONT_HEIGHT;
/*     */   }
/*     */ 
/*     */   
/*     */   public void render(ScreenPosition pos) {
/* 103 */     if (perspectiveToggled) {
/* 104 */       this.font.drawString("[Freelook (Toggled)]", pos.getAbsoluteX(), pos.getAbsoluteY(), -1);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public void renderDummy(ScreenPosition pos) {
/* 110 */     this.font.drawString("[Freelook (Toggled)]", pos.getAbsoluteX(), pos.getAbsoluteY(), -1);
/*     */   }
/*     */ }


/* Location:              C:\Users\Lenovo\Downloads\ZyrexClientV1 (1).jar!\ZyrexClient\mods\impl\ZyrexModPerspective.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */