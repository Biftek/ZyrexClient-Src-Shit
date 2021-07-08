/*    */ package ZyrexClient.UpdateChecker;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class UpdateChecker
/*    */ {
/*    */   private static final String URL = "https://raw.githubusercontent.com/BarniDW/version/main/version.json";
/*    */   
/*    */   public static boolean shouldUpdate() {
/* 11 */     Version CurrentVersion = new Version("1.0.1");
/* 12 */     Version LatestVersion = new Version(APIUtil.getJSONResponse("https://raw.githubusercontent.com/BarniDW/version/main/version.json").get("latest").getAsString());
/* 13 */     if (CurrentVersion.compareTo(LatestVersion) == -1)
/* 14 */       return true; 
/* 15 */     if ((((CurrentVersion.compareTo(LatestVersion) == 1) ? 1 : 0) | CurrentVersion.equals(LatestVersion)) != 0) {
/* 16 */       return false;
/*    */     }
/* 18 */     return false;
/*    */   }
/*    */ }


/* Location:              C:\Users\Lenovo\Downloads\ZyrexClientV1 (1).jar!\ZyrexClient\UpdateChecker\UpdateChecker.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */