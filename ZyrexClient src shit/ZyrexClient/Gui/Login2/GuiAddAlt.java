/*     */ package ZyrexClient.Gui.Login2;
/*     */ 
/*     */ import com.mojang.authlib.Agent;
/*     */ import com.mojang.authlib.exceptions.AuthenticationException;
/*     */ import com.mojang.authlib.yggdrasil.YggdrasilAuthenticationService;
/*     */ import com.mojang.authlib.yggdrasil.YggdrasilUserAuthentication;
/*     */ import java.io.IOException;
/*     */ import java.net.Proxy;
/*     */ import net.minecraft.client.gui.GuiButton;
/*     */ import net.minecraft.client.gui.GuiScreen;
/*     */ import net.minecraft.client.gui.GuiTextField;
/*     */ import net.minecraft.util.EnumChatFormatting;
/*     */ import net.minecraft.util.Session;
/*     */ import org.lwjgl.input.Keyboard;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class GuiAddAlt
/*     */   extends GuiScreen
/*     */ {
/*     */   private final GuiAltManager manager;
/*     */   private PasswordField password;
/*  24 */   private String status = EnumChatFormatting.GRAY + "Idle...";
/*     */   private GuiTextField username;
/*     */   
/*     */   public GuiAddAlt(GuiAltManager manager) {
/*  28 */     this.manager = manager;
/*     */   }
/*     */   
/*     */   protected void actionPerformed(GuiButton button) {
/*     */     AddAltThread login;
/*  33 */     switch (button.id) {
/*     */       case 0:
/*  35 */         login = new AddAltThread(this.username.getText(), this.password.getText());
/*  36 */         login.start();
/*     */         break;
/*     */       
/*     */       case 1:
/*  40 */         mc.displayGuiScreen(this.manager);
/*     */         break;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void drawScreen(int i2, int j2, float f2) {
/*  47 */     drawDefaultBackground();
/*  48 */     this.username.drawTextBox();
/*  49 */     this.password.drawTextBox();
/*  50 */     drawCenteredString(fontRendererObj, "Add Alt", width / 2, 20, -1);
/*  51 */     if (this.username.getText().isEmpty()) {
/*  52 */       drawString(mc.fontRendererObj, "Username / E-Mail", width / 2 - 96, 66, -7829368);
/*     */     }
/*  54 */     if (this.password.getText().isEmpty()) {
/*  55 */       drawString(mc.fontRendererObj, "Password", width / 2 - 96, 106, -7829368);
/*     */     }
/*  57 */     drawCenteredString(fontRendererObj, this.status, width / 2, 30, -1);
/*  58 */     super.drawScreen(i2, j2, f2);
/*     */   }
/*     */ 
/*     */   
/*     */   public void initGui() {
/*  63 */     Keyboard.enableRepeatEvents(true);
/*  64 */     buttonList.clear();
/*  65 */     buttonList.add(new GuiButton(0, width / 2 - 100, height / 4 + 92 + 12, "Login"));
/*  66 */     buttonList.add(new GuiButton(1, width / 2 - 100, height / 4 + 116 + 12, "Back"));
/*  67 */     this.username = new GuiTextField(this.eventButton, mc.fontRendererObj, width / 2 - 100, 60, 200, 20);
/*  68 */     this.password = new PasswordField(mc.fontRendererObj, width / 2 - 100, 100, 200, 20);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void keyTyped(char par1, int par2) {
/*  73 */     this.username.textboxKeyTyped(par1, par2);
/*  74 */     this.password.textboxKeyTyped(par1, par2);
/*  75 */     if (par1 == '\t' && (this.username.isFocused() || this.password.isFocused())) {
/*  76 */       this.username.setFocused(!this.username.isFocused());
/*  77 */       this.password.setFocused(!this.password.isFocused());
/*     */     } 
/*  79 */     if (par1 == '\r') {
/*  80 */       actionPerformed(buttonList.get(0));
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   protected void mouseClicked(int par1, int par2, int par3) {
/*     */     try {
/*  87 */       super.mouseClicked(par1, par2, par3);
/*     */     }
/*  89 */     catch (IOException e) {
/*  90 */       e.printStackTrace();
/*     */     } 
/*  92 */     this.username.mouseClicked(par1, par2, par3);
/*  93 */     this.password.mouseClicked(par1, par2, par3);
/*     */   }
/*     */ 
/*     */   
/*     */   private class AddAltThread
/*     */     extends Thread
/*     */   {
/*     */     private final String password;
/*     */     
/*     */     private final String username;
/*     */ 
/*     */     
/*     */     public AddAltThread(String username, String password) {
/* 106 */       this.username = username;
/* 107 */       this.password = password;
/* 108 */       GuiAddAlt.this.status = EnumChatFormatting.GRAY + "Idle...";
/*     */     }
/*     */     
/*     */     private final void checkAndAddAlt(String username, String password) throws IOException {
/* 112 */       YggdrasilAuthenticationService service = new YggdrasilAuthenticationService(Proxy.NO_PROXY, "");
/* 113 */       YggdrasilUserAuthentication auth = (YggdrasilUserAuthentication)service.createUserAuthentication(Agent.MINECRAFT);
/* 114 */       auth.setUsername(username);
/* 115 */       auth.setPassword(password);
/*     */       try {
/* 117 */         auth.logIn();
/* 118 */         Session auth1 = createSession(this.username, this.password);
/* 119 */         AltManager.registry.add(new Alt(username, password, auth1.getProfile().getName()));
/*     */         
/* 121 */         GuiAddAlt.this.status = "Alt added. (" + username + ")";
/*     */       }
/* 123 */       catch (AuthenticationException e) {
/* 124 */         GuiAddAlt.this.status = EnumChatFormatting.RED + "Alt failed!";
/* 125 */         e.printStackTrace();
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/*     */     public void run() {
/* 131 */       if (this.password.equals("")) {
/* 132 */         Session auth = createSession(this.username, this.password);
/* 133 */         AltManager.registry.add(new Alt(this.username, ""));
/* 134 */         GuiAddAlt.this.status = EnumChatFormatting.GREEN + "Alt added. (" + this.username + " - offline name)";
/*     */         return;
/*     */       } 
/* 137 */       GuiAddAlt.this.status = EnumChatFormatting.YELLOW + "Trying alt...";
/*     */       try {
/* 139 */         checkAndAddAlt(this.username, this.password);
/*     */       }
/* 141 */       catch (IOException e) {
/* 142 */         e.printStackTrace();
/*     */       } 
/*     */     }
/*     */     
/*     */     private Session createSession(String username, String password) {
/* 147 */       YggdrasilAuthenticationService service = new YggdrasilAuthenticationService(Proxy.NO_PROXY, "");
/* 148 */       YggdrasilUserAuthentication auth = (YggdrasilUserAuthentication)service.createUserAuthentication(Agent.MINECRAFT);
/* 149 */       auth.setUsername(username);
/* 150 */       auth.setPassword(password);
/*     */       try {
/* 152 */         auth.logIn();
/* 153 */         return new Session(auth.getSelectedProfile().getName(), auth.getSelectedProfile().getId().toString(), auth.getAuthenticatedToken(), "mojang");
/*     */       }
/* 155 */       catch (AuthenticationException localAuthenticationException) {
/* 156 */         localAuthenticationException.printStackTrace();
/* 157 */         return null;
/*     */       } 
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Lenovo\Downloads\ZyrexClientV1 (1).jar!\ZyrexClient\Gui\Login2\GuiAddAlt.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */