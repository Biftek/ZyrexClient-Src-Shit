/*    */ package ZyrexClient;
/*    */ 
/*    */ import com.google.gson.Gson;
/*    */ import java.io.BufferedReader;
/*    */ import java.io.File;
/*    */ import java.io.FileInputStream;
/*    */ import java.io.FileOutputStream;
/*    */ import java.io.InputStreamReader;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class FileManager
/*    */ {
/* 15 */   public static final String MOD_DIR = null;
/*    */   
/* 17 */   private static Gson gson = new Gson();
/*    */   
/* 19 */   public static File BUTTON_DIR = new File("Zyrex/Buttons");
/* 20 */   public static File ROOT_DIR = new File("Zyrex");
/* 21 */   public static File MODS_DIR = new File(ROOT_DIR, "Mods");
/*    */   
/*    */   public static void init() {
/* 24 */     if (!BUTTON_DIR.exists()) BUTTON_DIR.mkdirs(); 
/* 25 */     if (!ROOT_DIR.exists()) ROOT_DIR.mkdirs(); 
/* 26 */     if (!MODS_DIR.exists()) MODS_DIR.mkdirs(); 
/*    */   }
/*    */   
/*    */   public static Gson getGson() {
/* 30 */     return gson;
/*    */   }
/*    */   
/*    */   public static File getModsDirectory() {
/* 34 */     return MODS_DIR;
/*    */   }
/*    */   
/*    */   public static boolean writeJsonToFile(File file, Object obj) {
/*    */     try {
/* 39 */       if (!file.exists()) {
/* 40 */         file.createNewFile();
/*    */       }
/* 42 */       FileOutputStream outPutStream = new FileOutputStream(file);
/* 43 */       outPutStream.write(gson.toJson(obj).getBytes());
/* 44 */       outPutStream.flush();
/* 45 */       outPutStream.close();
/* 46 */       return true;
/*    */     }
/* 48 */     catch (Exception e) {
/* 49 */       e.printStackTrace();
/* 50 */       return false;
/*    */     } 
/*    */   }
/*    */   
/*    */   public static <T> T readFromJson(File file, Class<T> c) {
/*    */     try {
/* 56 */       FileInputStream fileInputStream = new FileInputStream(file);
/* 57 */       InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
/* 58 */       BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
/*    */       
/* 60 */       StringBuilder builder = new StringBuilder();
/*    */       
/*    */       String line;
/* 63 */       while ((line = bufferedReader.readLine()) != null) {
/* 64 */         builder.append(line);
/*    */       }
/* 66 */       bufferedReader.close();
/* 67 */       inputStreamReader.close();
/* 68 */       fileInputStream.close();
/*    */       
/* 70 */       return (T)gson.fromJson(builder.toString(), c);
/*    */     }
/* 72 */     catch (Exception e) {
/* 73 */       e.printStackTrace();
/* 74 */       return null;
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\Lenovo\Downloads\ZyrexClientV1 (1).jar!\ZyrexClient\FileManager.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */