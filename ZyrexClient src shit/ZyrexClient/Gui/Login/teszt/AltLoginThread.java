/*    */ package ZyrexClient.Gui.Login.teszt;
/*    */ 
/*    */ import com.mojang.authlib.Agent;
/*    */ import com.mojang.authlib.exceptions.AuthenticationException;
/*    */ import com.mojang.authlib.yggdrasil.YggdrasilAuthenticationService;
/*    */ import com.mojang.authlib.yggdrasil.YggdrasilUserAuthentication;
/*    */ import java.net.Proxy;
/*    */ import net.minecraft.client.Minecraft;
/*    */ import net.minecraft.util.EnumChatFormatting;
/*    */ import net.minecraft.util.Session;
/*    */ 
/*    */ 
/*    */ 
/*    */ public final class AltLoginThread
/*    */   extends Thread
/*    */ {
/*    */   private final String password;
/*    */   private String status;
/*    */   private final String username;
/* 20 */   private Minecraft mc = Minecraft.getMinecraft();
/*    */   
/*    */   public AltLoginThread(String username, String password) {
/* 23 */     super("Alt Login Thread");
/* 24 */     this.username = username;
/* 25 */     this.password = password;
/* 26 */     this.status = EnumChatFormatting.GRAY + "Waiting...";
/*    */   }
/*    */   
/*    */   private Session createSession(String username, String password) {
/* 30 */     YggdrasilAuthenticationService service = new YggdrasilAuthenticationService(Proxy.NO_PROXY, "");
/* 31 */     YggdrasilUserAuthentication auth = (YggdrasilUserAuthentication)service.createUserAuthentication(Agent.MINECRAFT);
/* 32 */     auth.setUsername(username);
/* 33 */     auth.setPassword(password);
/*    */     try {
/* 35 */       auth.logIn();
/* 36 */       return new Session(auth.getSelectedProfile().getName(), auth.getSelectedProfile().getId().toString(), auth.getAuthenticatedToken(), "mojang");
/*    */     }
/* 38 */     catch (AuthenticationException localAuthenticationException) {
/* 39 */       localAuthenticationException.printStackTrace();
/* 40 */       return null;
/*    */     } 
/*    */   }
/*    */   
/*    */   public String getStatus() {
/* 45 */     return this.status;
/*    */   }
/*    */ 
/*    */   
/*    */   public void run() {
/* 50 */     if (this.password.equals("")) {
/* 51 */       this.status = EnumChatFormatting.GREEN + "§cLogin Failed!";
/*    */       return;
/*    */     } 
/* 54 */     this.status = EnumChatFormatting.YELLOW + "Logging in...";
/* 55 */     Session auth = createSession(this.username, this.password);
/* 56 */     if (auth == null) {
/* 57 */       this.status = EnumChatFormatting.RED + "Login failed!";
/*    */     } else {
/* 59 */       this.status = EnumChatFormatting.GREEN + "Logged in. (" + auth.getUsername() + ")";
/* 60 */       this.mc.session = auth;
/*    */     } 
/*    */   }
/*    */   
/*    */   public void setStatus(String status) {
/* 65 */     this.status = status;
/*    */   }
/*    */ }


/* Location:              C:\Users\Lenovo\Downloads\ZyrexClientV1 (1).jar!\ZyrexClient\Gui\Login\teszt\AltLoginThread.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */