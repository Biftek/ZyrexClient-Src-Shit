/*    */ package ZyrexClient.Gui.Login2.TheAlteningAuth;
/*    */ 
/*    */ import java.net.URL;
/*    */ 
/*    */ public final class ServiceSwitcher
/*    */ {
/*  7 */   private final String MINECRAFT_SESSION_SERVICE_CLASS = "com.mojang.authlib.yggdrasil.YggdrasilMinecraftSessionService";
/*  8 */   private final String MINECRAFT_AUTHENTICATION_SERVICE_CLASS = "com.mojang.authlib.yggdrasil.YggdrasilUserAuthentication";
/*    */   
/* 10 */   private final String[] WHITELISTED_DOMAINS = new String[] { ".minecraft.net", ".mojang.com", ".thealtening.com" };
/*    */   
/* 12 */   private final FieldAdapter minecraftSessionServer = new FieldAdapter("com.mojang.authlib.yggdrasil.YggdrasilMinecraftSessionService");
/* 13 */   private final FieldAdapter userAuthentication = new FieldAdapter("com.mojang.authlib.yggdrasil.YggdrasilUserAuthentication");
/*    */   
/*    */   public ServiceSwitcher() {
/*    */     try {
/* 17 */       this.minecraftSessionServer.updateFieldIfPresent("WHITELISTED_DOMAINS", this.WHITELISTED_DOMAINS);
/* 18 */     } catch (Exception e) {
/* 19 */       e.printStackTrace();
/*    */     } 
/*    */   }
/*    */   
/*    */   public AlteningServiceType switchToService(AlteningServiceType service) {
/*    */     try {
/* 25 */       String authServer = service.getAuthServer();
/* 26 */       FieldAdapter userAuth = this.userAuthentication;
/* 27 */       userAuth.updateFieldIfPresent("BASE_URL", authServer);
/* 28 */       userAuth.updateFieldIfPresent("ROUTE_AUTHENTICATE", new URL(String.valueOf(authServer) + "authenticate"));
/* 29 */       userAuth.updateFieldIfPresent("ROUTE_INVALIDATE", new URL(String.valueOf(authServer) + "invalidate"));
/* 30 */       userAuth.updateFieldIfPresent("ROUTE_REFRESH", new URL(String.valueOf(authServer) + "refresh"));
/* 31 */       userAuth.updateFieldIfPresent("ROUTE_VALIDATE", new URL(String.valueOf(authServer) + "validate"));
/* 32 */       userAuth.updateFieldIfPresent("ROUTE_SIGNOUT", new URL(String.valueOf(authServer) + "signout"));
/*    */       
/* 34 */       String sessionServer = service.getSessionServer();
/* 35 */       FieldAdapter userSession = this.minecraftSessionServer;
/* 36 */       userSession.updateFieldIfPresent("BASE_URL", String.valueOf(sessionServer) + "session/minecraft/");
/* 37 */       userSession.updateFieldIfPresent("JOIN_URL", new URL(String.valueOf(sessionServer) + "session/minecraft/join"));
/* 38 */       userSession.updateFieldIfPresent("CHECK_URL", new URL(String.valueOf(sessionServer) + "session/minecraft/hasJoined"));
/* 39 */     } catch (Exception ignored) {
/* 40 */       ignored.printStackTrace();
/* 41 */       return AlteningServiceType.MOJANG;
/*    */     } 
/*    */     
/* 44 */     return service;
/*    */   }
/*    */ }


/* Location:              C:\Users\Lenovo\Downloads\ZyrexClientV1 (1).jar!\ZyrexClient\Gui\Login2\TheAlteningAuth\ServiceSwitcher.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */