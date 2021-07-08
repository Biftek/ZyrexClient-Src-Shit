/*    */ package ZyrexClient.Gui.Login2.TheAlteningAuth;
/*    */ 
/*    */ public enum AlteningServiceType
/*    */ {
/*  5 */   MOJANG("https://authserver.mojang.com/", "https://sessionserver.mojang.com/"),
/*  6 */   THEALTENING("http://authserver.thealtening.com/", "http://sessionserver.thealtening.com/");
/*    */   
/*    */   private final String authServer;
/*    */   private final String sessionServer;
/*    */   
/*    */   AlteningServiceType(String authServer, String sessionServer) {
/* 12 */     this.authServer = authServer;
/* 13 */     this.sessionServer = sessionServer;
/*    */   }
/*    */   
/*    */   public String getAuthServer() {
/* 17 */     return this.authServer;
/*    */   }
/*    */   
/*    */   public String getSessionServer() {
/* 21 */     return this.sessionServer;
/*    */   }
/*    */ }


/* Location:              C:\Users\Lenovo\Downloads\ZyrexClientV1 (1).jar!\ZyrexClient\Gui\Login2\TheAlteningAuth\AlteningServiceType.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */