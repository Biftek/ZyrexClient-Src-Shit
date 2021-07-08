/*     */ package ZyrexClient.Gui.Login;
/*     */ 
/*     */ import ZyrexClient.Client;
/*     */ import java.io.IOException;
/*     */ import net.minecraft.client.gui.GuiButton;
/*     */ import net.minecraft.client.gui.GuiMainMenu;
/*     */ import net.minecraft.client.gui.GuiScreen;
/*     */ import net.minecraft.client.gui.GuiTextField;
/*     */ import org.lwjgl.input.Keyboard;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class GuiLogin
/*     */   extends GuiScreen
/*     */ {
/*     */   private GuiMainMenu guimainmenu;
/*     */   private GuiTextField loginNameField;
/*     */   private GuiTextField loginPassField;
/*     */   private String loginName;
/*     */   private String loginPass;
/*     */   
/*     */   public GuiLogin(GuiMainMenu guiMainMenu) {
/*  25 */     this.guimainmenu = guiMainMenu;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void updateScreen() {
/*  33 */     this.loginNameField.updateCursorCounter();
/*  34 */     this.loginPassField.updateCursorCounter();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void initGui() {
/*  42 */     Client.getInstance().getDiscordRP().update("Bejelentkez�s", "Login Men�ben");
/*  43 */     Keyboard.enableRepeatEvents(true);
/*  44 */     buttonList.clear();
/*  45 */     buttonList.add(new GuiButton(0, width / 2 - 100, height / 4 + 96 + 18, "Bejelentkez�s"));
/*  46 */     buttonList.add(new GuiButton(1, width / 2 - 100, height / 4 + 120 + 18, "M�gse"));
/*  47 */     this.loginNameField = new GuiTextField(0, fontRendererObj, width / 2 - 100, 66, 200, 20);
/*  48 */     this.loginNameField.setMaxStringLength(128);
/*  49 */     this.loginNameField.setFocused(true);
/*  50 */     this.loginPassField = new GuiTextField(1, fontRendererObj, width / 2 - 100, 106, 200, 20);
/*  51 */     this.loginPassField.setMaxStringLength(128);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void onGuiClosed() {
/*  59 */     Keyboard.enableRepeatEvents(false);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void actionPerformed(GuiButton button) throws IOException {
/*  64 */     if (button.enabled)
/*     */     {
/*  66 */       if (button.id == 1) {
/*     */         
/*  68 */         mc.displayGuiScreen((GuiScreen)new GuiMainMenu());
/*     */       }
/*  70 */       else if (button.id == 0) {
/*     */         
/*  72 */         this.loginName = this.loginNameField.getText();
/*  73 */         this.loginPass = this.loginPassField.getText();
/*  74 */         SessionChanger.getInstance().setUser(this.loginName, this.loginPass);
/*  75 */         mc.displayGuiScreen((GuiScreen)new GuiMainMenu());
/*     */       } 
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void keyTyped(char typedChar, int keyCode) throws IOException {
/*  86 */     this.loginNameField.textboxKeyTyped(typedChar, keyCode);
/*  87 */     this.loginPassField.textboxKeyTyped(typedChar, keyCode);
/*     */     
/*  89 */     if (keyCode == 15) {
/*     */       
/*  91 */       this.loginNameField.setFocused(!this.loginNameField.isFocused());
/*  92 */       this.loginPassField.setFocused(!this.loginPassField.isFocused());
/*     */     } 
/*     */     
/*  95 */     if (keyCode == 28 || keyCode == 156)
/*     */     {
/*  97 */       actionPerformed(buttonList.get(0));
/*     */     }
/*     */     
/* 100 */     ((GuiButton)buttonList.get(0)).enabled = (this.loginPassField.getText().length() > 0 && (this.loginPassField.getText().split(":")).length > 0 && this.loginNameField.getText().length() > 0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void mouseClicked(int mouseX, int mouseY, int mouseButton) throws IOException {
/* 108 */     super.mouseClicked(mouseX, mouseY, mouseButton);
/* 109 */     this.loginPassField.mouseClicked(mouseX, mouseY, mouseButton);
/* 110 */     this.loginNameField.mouseClicked(mouseX, mouseY, mouseButton);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void drawScreen(int mouseX, int mouseY, float partialTicks) {
/* 118 */     drawDefaultBackground();
/* 119 */     drawCenteredString(fontRendererObj, "Login", width / 2, 17, 16777215);
/* 120 */     drawString(fontRendererObj, "Felhaszn�l�n�v", width / 2 - 100, 53, 10526880);
/* 121 */     drawString(fontRendererObj, "Password", width / 2 - 100, 94, 10526880);
/* 122 */     this.loginNameField.drawTextBox();
/* 123 */     this.loginPassField.drawTextBox();
/* 124 */     super.drawScreen(mouseX, mouseY, partialTicks);
/*     */   }
/*     */ }


/* Location:              C:\Users\Lenovo\Downloads\ZyrexClientV1 (1).jar!\ZyrexClient\Gui\Login\GuiLogin.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */