/*    */ package ZyrexClient.Gui.Login;
/*    */ 
/*    */ import com.mojang.authlib.Agent;
/*    */ import com.mojang.authlib.UserAuthentication;
/*    */ import com.mojang.authlib.yggdrasil.YggdrasilAuthenticationService;
/*    */ import com.mojang.util.UUIDTypeAdapter;
/*    */ import java.util.UUID;
/*    */ import net.minecraft.client.Minecraft;
/*    */ import net.minecraft.util.Session;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class SessionChanger
/*    */ {
/*    */   private static SessionChanger instance;
/*    */   private final UserAuthentication auth;
/*    */   
/*    */   public static SessionChanger getInstance() {
/* 19 */     if (instance == null) {
/* 20 */       instance = new SessionChanger();
/*    */     }
/*    */     
/* 23 */     return instance;
/*    */   }
/*    */ 
/*    */   
/*    */   private SessionChanger() {
/* 28 */     UUID notSureWhyINeedThis = UUID.randomUUID();
/* 29 */     YggdrasilAuthenticationService yggdrasilAuthenticationService = new YggdrasilAuthenticationService(Minecraft.getMinecraft().getProxy(), notSureWhyINeedThis.toString());
/* 30 */     this.auth = yggdrasilAuthenticationService.createUserAuthentication(Agent.MINECRAFT);
/* 31 */     yggdrasilAuthenticationService.createMinecraftSessionService();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void setUser(String email, String password) {
/* 38 */     if (!Minecraft.getMinecraft().getSession().getUsername().equals(email) || Minecraft.getMinecraft().getSession().getToken().equals("0")) {
/*    */       
/* 40 */       this.auth.logOut();
/* 41 */       this.auth.setUsername(email);
/* 42 */       this.auth.setPassword(password);
/*    */       try {
/* 44 */         this.auth.logIn();
/* 45 */         Session session = new Session(this.auth.getSelectedProfile().getName(), UUIDTypeAdapter.fromUUID(this.auth.getSelectedProfile().getId()), this.auth.getAuthenticatedToken(), this.auth.getUserType().getName());
/* 46 */         setSession(session);
/*    */       }
/* 48 */       catch (Exception e) {
/* 49 */         e.printStackTrace();
/*    */       } 
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   private void setSession(Session session) {
/* 58 */     (Minecraft.getMinecraft()).session = session;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void setUserOffline(String username) {
/* 64 */     this.auth.logOut();
/* 65 */     Session session = new Session(username, username, "0", "legacy");
/* 66 */     setSession(session);
/*    */   }
/*    */ }


/* Location:              C:\Users\Lenovo\Downloads\ZyrexClientV1 (1).jar!\ZyrexClient\Gui\Login\SessionChanger.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */