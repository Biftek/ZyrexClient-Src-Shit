/*     */ package ZyrexClient.Gui.Login2;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import net.minecraft.client.gui.GuiButton;
/*     */ import net.minecraft.client.gui.GuiScreen;
/*     */ import net.minecraft.client.gui.GuiTextField;
/*     */ import net.minecraft.util.EnumChatFormatting;
/*     */ import org.lwjgl.input.Keyboard;
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class GuiAltLogin2
/*     */   extends GuiScreen
/*     */ {
/*     */   private PasswordField password;
/*     */   private final GuiScreen previousScreen;
/*     */   private AltLoginThread thread;
/*     */   private GuiTextField username;
/*     */   
/*     */   public GuiAltLogin2(GuiScreen previousScreen) {
/*  21 */     this.previousScreen = previousScreen;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void actionPerformed(GuiButton button) {
/*  26 */     switch (button.id) {
/*     */       case 1:
/*  28 */         mc.displayGuiScreen(this.previousScreen);
/*     */         break;
/*     */       
/*     */       case 0:
/*  32 */         this.thread = new AltLoginThread(this.username.getText(), this.password.getText());
/*  33 */         this.thread.start();
/*     */         break;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void drawScreen(int x2, int y2, float z2) {
/*  40 */     drawDefaultBackground();
/*  41 */     this.username.drawTextBox();
/*  42 */     this.password.drawTextBox();
/*  43 */     drawCenteredString(mc.fontRendererObj, "Alt Login", width / 2, 20, -1);
/*  44 */     drawCenteredString(mc.fontRendererObj, (this.thread == null) ? (EnumChatFormatting.GRAY + "Idle...") : this.thread.getStatus(), width / 2, 29, -1);
/*  45 */     if (this.username.getText().isEmpty()) {
/*  46 */       drawString(mc.fontRendererObj, "Username / E-Mail", width / 2 - 96, 66, -7829368);
/*     */     }
/*  48 */     if (this.password.getText().isEmpty()) {
/*  49 */       drawString(mc.fontRendererObj, "Password", width / 2 - 96, 106, -7829368);
/*     */     }
/*  51 */     super.drawScreen(x2, y2, z2);
/*     */   }
/*     */ 
/*     */   
/*     */   public void initGui() {
/*  56 */     int var3 = height / 4 + 24;
/*  57 */     buttonList.add(new GuiButton(0, width / 2 - 100, var3 + 72 + 12, "Login"));
/*  58 */     buttonList.add(new GuiButton(1, width / 2 - 100, var3 + 72 + 12 + 24, "Back"));
/*  59 */     this.username = new GuiTextField(var3, mc.fontRendererObj, width / 2 - 100, 60, 200, 20);
/*  60 */     this.password = new PasswordField(mc.fontRendererObj, width / 2 - 100, 100, 200, 20);
/*  61 */     this.username.setFocused(true);
/*  62 */     Keyboard.enableRepeatEvents(true);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void keyTyped(char character, int key) {
/*     */     try {
/*  68 */       super.keyTyped(character, key);
/*     */     }
/*  70 */     catch (IOException e) {
/*  71 */       e.printStackTrace();
/*     */     } 
/*  73 */     if (character == '\t') {
/*  74 */       if (!this.username.isFocused() && !this.password.isFocused()) {
/*  75 */         this.username.setFocused(true);
/*     */       } else {
/*  77 */         this.username.setFocused(this.password.isFocused());
/*  78 */         this.password.setFocused(!this.username.isFocused());
/*     */       } 
/*     */     }
/*  81 */     if (character == '\r') {
/*  82 */       actionPerformed(buttonList.get(0));
/*     */     }
/*  84 */     this.username.textboxKeyTyped(character, key);
/*  85 */     this.password.textboxKeyTyped(character, key);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void mouseClicked(int x2, int y2, int button) {
/*     */     try {
/*  91 */       super.mouseClicked(x2, y2, button);
/*     */     }
/*  93 */     catch (IOException e) {
/*  94 */       e.printStackTrace();
/*     */     } 
/*  96 */     this.username.mouseClicked(x2, y2, button);
/*  97 */     this.password.mouseClicked(x2, y2, button);
/*     */   }
/*     */ 
/*     */   
/*     */   public void onGuiClosed() {
/* 102 */     Keyboard.enableRepeatEvents(false);
/*     */   }
/*     */ 
/*     */   
/*     */   public void updateScreen() {
/* 107 */     this.username.updateCursorCounter();
/* 108 */     this.password.updateCursorCounter();
/*     */   }
/*     */ }


/* Location:              C:\Users\Lenovo\Downloads\ZyrexClientV1 (1).jar!\ZyrexClient\Gui\Login2\GuiAltLogin2.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */