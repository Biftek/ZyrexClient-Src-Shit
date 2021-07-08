/*    */ package ZyrexClient.Gui.Login2.TheAlteningAuth;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public final class TheAlteningAuthentication
/*    */ {
/* 14 */   private final ServiceSwitcher serviceSwitcher = new ServiceSwitcher();
/* 15 */   private final SSLController sslController = new SSLController();
/*    */   private static TheAlteningAuthentication instance;
/*    */   private AlteningServiceType service;
/*    */   
/*    */   private TheAlteningAuthentication(AlteningServiceType service) {
/* 20 */     updateService(service);
/*    */   }
/*    */   
/*    */   public void updateService(AlteningServiceType service) {
/* 24 */     if (service == null || this.service == service) {
/*    */       return;
/*    */     }
/*    */     
/* 28 */     switch (service) {
/*    */       case null:
/* 30 */         this.sslController.enableCertificateValidation();
/*    */         break;
/*    */       
/*    */       case THEALTENING:
/* 34 */         this.sslController.disableCertificateValidation();
/*    */         break;
/*    */     } 
/*    */     
/* 38 */     this.service = this.serviceSwitcher.switchToService(service);
/*    */   }
/*    */   
/*    */   public AlteningServiceType getService() {
/* 42 */     return this.service;
/*    */   }
/*    */   
/*    */   public static TheAlteningAuthentication mojang() {
/* 46 */     return withService(AlteningServiceType.MOJANG);
/*    */   }
/*    */   
/*    */   public static TheAlteningAuthentication theAltening() {
/* 50 */     return withService(AlteningServiceType.THEALTENING);
/*    */   }
/*    */   
/*    */   private static TheAlteningAuthentication withService(AlteningServiceType service) {
/* 54 */     if (instance == null) {
/* 55 */       instance = new TheAlteningAuthentication(service);
/* 56 */     } else if (instance.getService() != service) {
/* 57 */       instance.updateService(service);
/*    */     } 
/*    */     
/* 60 */     return instance;
/*    */   }
/*    */ }


/* Location:              C:\Users\Lenovo\Downloads\ZyrexClientV1 (1).jar!\ZyrexClient\Gui\Login2\TheAlteningAuth\TheAlteningAuthentication.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */