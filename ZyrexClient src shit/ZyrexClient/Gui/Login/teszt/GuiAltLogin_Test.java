/*     */ package ZyrexClient.Gui.Login.teszt;
/*     */ 
/*     */ import ZyrexClient.RectUtils;
/*     */ import java.io.IOException;
/*     */ import net.minecraft.client.Minecraft;
/*     */ import net.minecraft.client.gui.Gui;
/*     */ import net.minecraft.client.gui.GuiButton;
/*     */ import net.minecraft.client.gui.GuiScreen;
/*     */ import net.minecraft.client.gui.GuiTextField;
/*     */ import net.minecraft.client.gui.ScaledResolution;
/*     */ import net.minecraft.util.EnumChatFormatting;
/*     */ import net.minecraft.util.ResourceLocation;
/*     */ import org.lwjgl.input.Keyboard;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class GuiAltLogin_Test
/*     */   extends GuiScreen
/*     */ {
/*     */   private PasswordField password;
/*     */   private final GuiScreen previousScreen;
/*     */   private AltLoginThread thread;
/*     */   private GuiTextField username;
/*     */   
/*     */   public GuiAltLogin_Test(GuiScreen previousScreen) {
/*  28 */     this.previousScreen = previousScreen;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void actionPerformed(GuiButton button) {
/*  33 */     switch (button.id) {
/*     */       case 1:
/*  35 */         mc.displayGuiScreen(this.previousScreen);
/*     */         break;
/*     */       
/*     */       case 0:
/*  39 */         this.thread = new AltLoginThread(this.username.getText(), this.password.getText());
/*  40 */         this.thread.start();
/*     */         break;
/*     */     } 
/*     */   }
/*     */   
/*     */   public static void drawBackgroundPicture(int width, int height, String location) {
/*  46 */     Minecraft mc = Minecraft.getMinecraft();
/*  47 */     ScaledResolution scaledResolution = new ScaledResolution(mc);
/*  48 */     ResourceLocation loc = new ResourceLocation(location);
/*  49 */     mc.getTextureManager().bindTexture(loc);
/*  50 */     Gui.drawModalRectWithCustomSizedTexture(0, 0, 0.0F, 0.0F, scaledResolution.getScaledWidth(), scaledResolution.getScaledHeight(), scaledResolution.getScaledWidth(), scaledResolution.getScaledHeight());
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void drawScreen(int x2, int y2, float z2) {
/*  56 */     int var3 = height / 4 + 24;
/*  57 */     ScaledResolution sr = new ScaledResolution(Minecraft.getMinecraft());
/*  58 */     RectUtils.drawRoundedOutline((width / 2 - 120), (var3 + 102 + 120), 100.0F, 100.0F, 100.0F, 1.0F);
/*  59 */     drawDefaultBackground();
/*  60 */     drawBackgroundPicture(1920, 1080, "Images/test.png");
/*  61 */     this.username.drawTextBox();
/*  62 */     this.password.drawTextBox();
/*  63 */     drawCenteredString(mc.fontRendererObj, "Please log in", width / 2, 20, -1);
/*  64 */     drawCenteredString(mc.fontRendererObj, (this.thread == null) ? (EnumChatFormatting.GRAY + "Idle...") : this.thread.getStatus(), width / 2, 29, -1);
/*  65 */     if (this.username.getText().isEmpty()) {
/*  66 */       drawString(mc.fontRendererObj, "Username / E-Mail", width / 2 - 96, 66, -7829368);
/*     */     }
/*  68 */     if (this.password.getText().isEmpty()) {
/*  69 */       drawString(mc.fontRendererObj, "Password", width / 2 - 96, 106, -7829368);
/*     */     }
/*  71 */     super.drawScreen(x2, y2, z2);
/*     */   }
/*     */ 
/*     */   
/*     */   public void initGui() {
/*  76 */     int var3 = height / 4 + 24;
/*  77 */     buttonList.add(new GuiButton(0, width / 2 - 100, var3 + 72 + 12, "Login"));
/*  78 */     buttonList.add(new GuiButton(1, width / 2 - 100, var3 + 72 + 12 + 24, "Back"));
/*  79 */     this.username = new GuiTextField(var3, mc.fontRendererObj, width / 2 - 100, 60, 200, 20);
/*  80 */     this.password = new PasswordField(mc.fontRendererObj, width / 2 - 100, 100, 200, 20);
/*  81 */     this.username.setFocused(true);
/*  82 */     Keyboard.enableRepeatEvents(true);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void keyTyped(char character, int key) {
/*     */     try {
/*  88 */       super.keyTyped(character, key);
/*     */     }
/*  90 */     catch (IOException e) {
/*  91 */       e.printStackTrace();
/*     */     } 
/*  93 */     if (character == '\t') {
/*  94 */       if (!this.username.isFocused() && !this.password.isFocused()) {
/*  95 */         this.username.setFocused(true);
/*     */       } else {
/*  97 */         this.username.setFocused(this.password.isFocused());
/*  98 */         this.password.setFocused(!this.username.isFocused());
/*     */       } 
/*     */     }
/* 101 */     if (character == '\r') {
/* 102 */       actionPerformed(buttonList.get(0));
/*     */     }
/* 104 */     this.username.textboxKeyTyped(character, key);
/* 105 */     this.password.textboxKeyTyped(character, key);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void mouseClicked(int x2, int y2, int button) {
/*     */     try {
/* 111 */       super.mouseClicked(x2, y2, button);
/*     */     }
/* 113 */     catch (IOException e) {
/* 114 */       e.printStackTrace();
/*     */     } 
/* 116 */     this.username.mouseClicked(x2, y2, button);
/* 117 */     this.password.mouseClicked(x2, y2, button);
/*     */   }
/*     */ 
/*     */   
/*     */   public void onGuiClosed() {
/* 122 */     Keyboard.enableRepeatEvents(false);
/*     */   }
/*     */ 
/*     */   
/*     */   public void updateScreen() {
/* 127 */     this.username.updateCursorCounter();
/* 128 */     this.password.updateCursorCounter();
/*     */   }
/*     */ }


/* Location:              C:\Users\Lenovo\Downloads\ZyrexClientV1 (1).jar!\ZyrexClient\Gui\Login\teszt\GuiAltLogin_Test.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */