/*    */ package ZyrexClient.ModToggle;
/*    */ 
/*    */ import ZyrexClient.FileManager;
/*    */ import java.io.File;
/*    */ 
/*    */ 
/*    */ public class ModToggle
/*    */ {
/*    */   public static File getFolder(String mod) {
/* 10 */     File file = new File(FileManager.ROOT_DIR, mod);
/* 11 */     file.mkdirs();
/* 12 */     return file;
/*    */   }
/*    */   
/*    */   public static void saveIsEnabledToFile(String mod, Boolean b) {
/* 16 */     FileManager.writeJsonToFile(new File(getFolder(mod), "Enabled.json"), b);
/*    */   }
/*    */   public static Boolean loadEnabledFromFile(String mod) {
/* 19 */     Boolean b = (Boolean)FileManager.readFromJson(new File(getFolder(mod), "Enabled.json"), Boolean.class);
/*    */     
/* 21 */     if (b == null) {
/* 22 */       b = Boolean.valueOf(true);
/* 23 */       saveIsEnabledToFile(mod, b);
/*    */     } 
/* 25 */     return b;
/*    */   }
/*    */   
/*    */   public static Boolean loadEnabledFromFileFalse(String mod) {
/* 29 */     Boolean b = (Boolean)FileManager.readFromJson(new File(getFolder(mod), "Enabled.json"), Boolean.class);
/*    */     
/* 31 */     if (b == null) {
/* 32 */       b = Boolean.valueOf(false);
/* 33 */       saveIsEnabledToFile(mod, b);
/*    */     } 
/* 35 */     return b;
/*    */   }
/*    */   
/*    */   public static Boolean loadEnabledFromFileCosmetics(String mod) {
/* 39 */     Boolean b = (Boolean)FileManager.readFromJson(new File(getFolder(mod), "Enabled.json"), Boolean.class);
/*    */     
/* 41 */     if (b == null) {
/* 42 */       b = Boolean.valueOf(false);
/* 43 */       saveIsEnabledToFile(mod, b);
/*    */     } 
/* 45 */     return b;
/*    */   }
/*    */   
/*    */   public static void saveDoubleToFile(String mod, Double b) {
/* 49 */     FileManager.writeJsonToFile(new File(getFolder(mod), "Double.json"), b);
/*    */   }
/*    */   public static Double loadDoubleFromFile(String mod) {
/* 52 */     Double b = (Double)FileManager.readFromJson(new File(getFolder(mod), "Double.json"), Double.class);
/*    */     
/* 54 */     if (b == null) {
/* 55 */       b = Double.valueOf(1.0D);
/* 56 */       saveDoubleToFile(mod, b);
/*    */     } 
/* 58 */     return b;
/*    */   }
/*    */ }


/* Location:              C:\Users\Lenovo\Downloads\ZyrexClientV1 (1).jar!\ZyrexClient\ModToggle\ModToggle.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */