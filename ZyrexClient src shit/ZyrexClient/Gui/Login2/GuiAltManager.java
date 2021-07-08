/*     */ package ZyrexClient.Gui.Login2;
/*     */ 
/*     */ import ZyrexClient.Gui.Login2.TheAlteningAuth.AlteningServiceType;
/*     */ import ZyrexClient.Gui.Login2.TheAlteningAuth.TheAlteningAuthentication;
/*     */ import com.mojang.authlib.Agent;
/*     */ import com.mojang.authlib.exceptions.AuthenticationException;
/*     */ import com.mojang.authlib.yggdrasil.YggdrasilAuthenticationService;
/*     */ import com.mojang.authlib.yggdrasil.YggdrasilUserAuthentication;
/*     */ import java.io.IOException;
/*     */ import java.net.Proxy;
/*     */ import net.minecraft.client.gui.FontRenderer;
/*     */ import net.minecraft.client.gui.Gui;
/*     */ import net.minecraft.client.gui.GuiButton;
/*     */ import net.minecraft.client.gui.GuiScreen;
/*     */ import net.minecraft.client.gui.ScaledResolution;
/*     */ import net.minecraft.util.EnumChatFormatting;
/*     */ import net.minecraft.util.Session;
/*     */ import org.lwjgl.input.Keyboard;
/*     */ import org.lwjgl.input.Mouse;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ 
/*     */ public class GuiAltManager extends GuiScreen {
/*     */   private GuiButton login;
/*     */   private GuiButton remove;
/*     */   private GuiButton rename;
/*     */   private AltLoginThread loginThread;
/*     */   private int offset;
/*  28 */   public Alt selectedAlt = null;
/*  29 */   private String status = EnumChatFormatting.GRAY + "No alts selected";
/*  30 */   private TheAlteningAuthentication serviceSwitcher = TheAlteningAuthentication.mojang();
/*     */   
/*     */   public void actionPerformed(GuiButton button) throws IOException {
/*     */     String user;
/*     */     Session auth_;
/*     */     String pass;
/*  36 */     switch (button.id) {
/*     */       case 0:
/*  38 */         if (this.loginThread == null) {
/*  39 */           mc.displayGuiScreen(null);
/*     */           break;
/*     */         } 
/*  42 */         if (!this.loginThread.getStatus().equals(EnumChatFormatting.YELLOW + "Attempting to log in") && !this.loginThread.getStatus().equals(EnumChatFormatting.RED + "Do not hit back!" + EnumChatFormatting.YELLOW + " Logging in...")) {
/*  43 */           mc.displayGuiScreen(null);
/*     */           break;
/*     */         } 
/*  46 */         this.loginThread.setStatus(EnumChatFormatting.RED + "Failed to login! Please try again!" + EnumChatFormatting.YELLOW + " Logging in...");
/*     */         break;
/*     */       
/*     */       case 1:
/*  50 */         user = this.selectedAlt.getUsername();
/*  51 */         pass = this.selectedAlt.getPassword();
/*  52 */         this.loginThread = new AltLoginThread(user, pass);
/*  53 */         this.loginThread.start();
/*     */         break;
/*     */       
/*     */       case 2:
/*  57 */         if (this.loginThread != null) {
/*  58 */           this.loginThread = null;
/*     */         }
/*  60 */         auth_ = createSession(this.username, this.password);
/*  61 */         AltManager.registry.remove(this.selectedAlt);
/*  62 */         this.status = "§aRemoved.";
/*  63 */         this.selectedAlt = null;
/*     */         break;
/*     */       
/*     */       case 3:
/*  67 */         mc.displayGuiScreen(new GuiAddAlt(this));
/*     */         break;
/*     */       
/*     */       case 4:
/*  71 */         mc.displayGuiScreen(new GuiAltLogin2(this));
/*     */         break;
/*     */ 
/*     */       
/*     */       case 6:
/*  76 */         mc.displayGuiScreen(new GuiRenameAlt(this));
/*     */         break;
/*     */ 
/*     */       
/*     */       case 7:
/*  81 */         this.serviceSwitcher.updateService(AlteningServiceType.MOJANG);
/*     */         break;
/*     */ 
/*     */       
/*     */       case 8:
/*  86 */         this.serviceSwitcher.updateService(AlteningServiceType.THEALTENING);
/*     */         break;
/*     */     } 
/*     */   }
/*     */   
/*     */   private Object username;
/*     */   private Object password;
/*     */   
/*     */   public void drawScreen(int par1, int par2, float par3) {
/*  95 */     if (Mouse.hasWheel()) {
/*  96 */       int wheel = Mouse.getDWheel();
/*  97 */       if (wheel < 0) {
/*  98 */         this.offset += 26;
/*  99 */         if (this.offset < 0) {
/* 100 */           this.offset = 0;
/*     */         }
/* 102 */       } else if (wheel > 0) {
/* 103 */         this.offset -= 26;
/* 104 */         if (this.offset < 0) {
/* 105 */           this.offset = 0;
/*     */         }
/*     */       } 
/*     */     } 
/* 109 */     drawDefaultBackground();
/* 110 */     drawString(GuiAltManager.fontRendererObj, mc.session.getUsername(), 10, 10, -7829368);
/* 111 */     FontRenderer fontRendererObj = GuiAltManager.fontRendererObj;
/* 112 */     StringBuilder sb2 = new StringBuilder("Account Manager - ");
/*     */     
/* 114 */     drawCenteredString(fontRendererObj, sb2.append(AltManager.registry.size()).append(" alts").toString(), width / 2, 10, -1);
/* 115 */     drawCenteredString(GuiAltManager.fontRendererObj, (this.loginThread == null) ? this.status : this.loginThread.getStatus(), width / 2, 20, -1);
/* 116 */     Gui.drawRect(50, 33, width - 50, height - 50, -16777216);
/* 117 */     GL11.glPushMatrix();
/* 118 */     prepareScissorBox(0.0F, 33.0F, width, (height - 50));
/* 119 */     GL11.glEnable(3089);
/* 120 */     int y2 = 38;
/* 121 */     Session auth_ = createSession(this.username, this.password);
/* 122 */     for (Alt alt2 : AltManager.registry) {
/* 123 */       if (!isAltInArea(y2))
/* 124 */         continue;  String name = alt2.getMask().equals("") ? alt2.getUsername() : alt2.getMask();
/* 125 */       String pass = alt2.getPassword().equals("") ? "§cCracked" : alt2.getPassword().replaceAll(".", "*");
/* 126 */       if (alt2 == this.selectedAlt) {
/* 127 */         if (isMouseOverAlt(par1, par2, y2 - this.offset) && Mouse.isButtonDown(0)) {
/* 128 */           Gui.drawRect(52, y2 - this.offset - 4, width - 52, y2 - this.offset + 20, -2142943931);
/* 129 */         } else if (isMouseOverAlt(par1, par2, y2 - this.offset)) {
/* 130 */           Gui.drawRect(52, y2 - this.offset - 4, width - 52, y2 - this.offset + 20, -2142088622);
/*     */         } else {
/* 132 */           Gui.drawRect(52, y2 - this.offset - 4, width - 52, y2 - this.offset + 20, -2144259791);
/*     */         } 
/* 134 */       } else if (isMouseOverAlt(par1, par2, y2 - this.offset) && Mouse.isButtonDown(0)) {
/* 135 */         Gui.drawRect(52, y2 - this.offset - 4, width - 52, y2 - this.offset + 20, -16777216);
/* 136 */       } else if (isMouseOverAlt(par1, par2, y2 - this.offset)) {
/* 137 */         Gui.drawRect(52, y2 - this.offset - 4, width - 52, y2 - this.offset + 20, -16777216);
/*     */       } 
/* 139 */       drawCenteredString(GuiAltManager.fontRendererObj, name, width / 2, y2 - this.offset, -1);
/* 140 */       drawCenteredString(GuiAltManager.fontRendererObj, pass, width / 2, y2 - this.offset + 10, 5592405);
/* 141 */       y2 += 26;
/*     */     } 
/* 143 */     GL11.glDisable(3089);
/* 144 */     GL11.glPopMatrix();
/* 145 */     super.drawScreen(par1, par2, par3);
/* 146 */     if (this.selectedAlt == null) {
/* 147 */       this.login.enabled = false;
/* 148 */       this.remove.enabled = false;
/* 149 */       this.rename.enabled = false;
/*     */     } else {
/* 151 */       this.login.enabled = true;
/* 152 */       this.remove.enabled = true;
/* 153 */       this.rename.enabled = true;
/*     */     } 
/* 155 */     if (Keyboard.isKeyDown(200)) {
/* 156 */       this.offset -= 26;
/* 157 */       if (this.offset < 0) {
/* 158 */         this.offset = 0;
/*     */       }
/* 160 */     } else if (Keyboard.isKeyDown(208)) {
/* 161 */       this.offset += 26;
/* 162 */       if (this.offset < 0) {
/* 163 */         this.offset = 0;
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   private Session createSession(Object username2, Object password2) {
/* 169 */     YggdrasilAuthenticationService service = new YggdrasilAuthenticationService(Proxy.NO_PROXY, "");
/* 170 */     YggdrasilUserAuthentication auth = (YggdrasilUserAuthentication)service.createUserAuthentication(Agent.MINECRAFT);
/* 171 */     auth.setUsername((String)username2);
/* 172 */     auth.setPassword((String)password2);
/*     */     try {
/* 174 */       auth.logIn();
/* 175 */       return new Session(auth.getSelectedProfile().getName(), auth.getSelectedProfile().getId().toString(), auth.getAuthenticatedToken(), "mojang");
/*     */     }
/* 177 */     catch (AuthenticationException localAuthenticationException) {
/* 178 */       localAuthenticationException.printStackTrace();
/* 179 */       return null;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void initGui() {
/* 185 */     buttonList.add(new GuiButton(0, width / 2 + 4 + 50, height - 24, 100, 20, "Cancel"));
/* 186 */     this.login = new GuiButton(1, width / 2 - 154, height - 48, 100, 20, "Login");
/* 187 */     buttonList.add(this.login);
/* 188 */     this.remove = new GuiButton(2, width / 2 - 154, height - 24, 100, 20, "Remove");
/* 189 */     buttonList.add(this.remove);
/* 190 */     buttonList.add(new GuiButton(3, width / 2 + 4 + 50, height - 48, 100, 20, "Add"));
/* 191 */     buttonList.add(new GuiButton(4, width / 2 - 50, height - 48, 100, 20, "Direct Login"));
/* 192 */     this.rename = new GuiButton(6, width / 2 - 50, height - 24, 100, 20, "Edit");
/* 193 */     buttonList.add(this.rename);
/* 194 */     buttonList.add(new GuiButton(7, width - 100, 0, 100, 20, "Use Mojang"));
/* 195 */     buttonList.add(new GuiButton(8, width - 200, 0, 100, 20, "Use TheAltening"));
/* 196 */     this.login.enabled = false;
/* 197 */     this.remove.enabled = false;
/* 198 */     this.rename.enabled = false;
/*     */   }
/*     */   
/*     */   private boolean isAltInArea(int y2) {
/* 202 */     if (y2 - this.offset <= height - 50) {
/* 203 */       return true;
/*     */     }
/* 205 */     return false;
/*     */   }
/*     */   
/*     */   private boolean isMouseOverAlt(int x2, int y2, int y1) {
/* 209 */     if (x2 >= 52 && y2 >= y1 - 4 && x2 <= width - 52 && y2 <= y1 + 20 && x2 >= 0 && y2 >= 33 && x2 <= width && y2 <= height - 50) {
/* 210 */       return true;
/*     */     }
/* 212 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void mouseClicked(int par1, int par2, int par3) throws IOException {
/* 217 */     if (this.offset < 0) {
/* 218 */       this.offset = 0;
/*     */     }
/* 220 */     int y2 = 38 - this.offset;
/* 221 */     Session auth1 = createSession(this.username, this.password);
/* 222 */     for (Alt alt2 : AltManager.registry) {
/* 223 */       if (isMouseOverAlt(par1, par2, y2)) {
/* 224 */         if (alt2 == this.selectedAlt) {
/* 225 */           actionPerformed(buttonList.get(1));
/*     */           return;
/*     */         } 
/* 228 */         this.selectedAlt = alt2;
/*     */       } 
/* 230 */       y2 += 26;
/*     */     } 
/*     */     try {
/* 233 */       super.mouseClicked(par1, par2, par3);
/*     */     }
/* 235 */     catch (IOException e) {
/* 236 */       e.printStackTrace();
/*     */     } 
/*     */   }
/*     */   
/*     */   public void prepareScissorBox(float x2, float y2, float x22, float y22) {
/* 241 */     ScaledResolution scale = new ScaledResolution(mc);
/* 242 */     int factor = scale.getScaleFactor();
/* 243 */     GL11.glScissor((int)(x2 * factor), (int)((scale.getScaledHeight() - y22) * factor), (int)((x22 - x2) * factor), (int)((y22 - y2) * factor));
/*     */   }
/*     */ 
/*     */   
/*     */   private Session createSession1(String username2, String password2) {
/* 248 */     YggdrasilAuthenticationService service = new YggdrasilAuthenticationService(Proxy.NO_PROXY, "");
/* 249 */     YggdrasilUserAuthentication auth = (YggdrasilUserAuthentication)service.createUserAuthentication(Agent.MINECRAFT);
/* 250 */     auth.setUsername(username2);
/* 251 */     auth.setPassword(password2);
/*     */     try {
/* 253 */       auth.logIn();
/* 254 */       return new Session(auth.getSelectedProfile().getName(), auth.getSelectedProfile().getId().toString(), auth.getAuthenticatedToken(), "mojang");
/*     */     }
/* 256 */     catch (AuthenticationException localAuthenticationException) {
/* 257 */       localAuthenticationException.printStackTrace();
/* 258 */       return null;
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Lenovo\Downloads\ZyrexClientV1 (1).jar!\ZyrexClient\Gui\Login2\GuiAltManager.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */