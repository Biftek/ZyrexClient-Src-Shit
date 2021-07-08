/*    */ package ZyrexClient.Gui.Login2;
/*    */ 
/*    */ public final class Alt {
/*  4 */   private String mask = "";
/*    */   private final String username;
/*    */   private String password;
/*    */   
/*    */   public Alt(String username, String password) {
/*  9 */     this(username, password, "");
/*    */   }
/*    */   
/*    */   public Alt(String username, String password, String mask) {
/* 13 */     this.username = username;
/* 14 */     this.password = password;
/* 15 */     this.mask = mask;
/*    */   }
/*    */   
/*    */   public String getMask() {
/* 19 */     return this.mask;
/*    */   }
/*    */   
/*    */   public String getPassword() {
/* 23 */     return this.password;
/*    */   }
/*    */   
/*    */   public String getUsername() {
/* 27 */     return this.username;
/*    */   }
/*    */   
/*    */   public void setMask(String mask) {
/* 31 */     this.mask = mask;
/*    */   }
/*    */   
/*    */   public void setPassword(String password) {
/* 35 */     this.password = password;
/*    */   }
/*    */ }


/* Location:              C:\Users\Lenovo\Downloads\ZyrexClientV1 (1).jar!\ZyrexClient\Gui\Login2\Alt.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */