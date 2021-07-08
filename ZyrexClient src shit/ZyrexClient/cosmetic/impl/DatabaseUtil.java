/*    */ package ZyrexClient.cosmetic.impl;
/*    */ 
/*    */ import com.google.gson.JsonArray;
/*    */ import com.google.gson.JsonObject;
/*    */ import com.google.gson.JsonParser;
/*    */ import java.io.IOException;
/*    */ import java.net.URL;
/*    */ import java.util.Scanner;
/*    */ 
/*    */ public class DatabaseUtil
/*    */ {
/* 12 */   private static String stringurl = "https://raw.githubusercontent.com/cornly/coscoremod/main/cos.json";
/*    */ 
/*    */ 
/*    */   
/*    */   private static JsonArray data;
/*    */ 
/*    */ 
/*    */   
/*    */   public static void parseData() {
/* 21 */     URL url = null;
/*    */     try {
/* 23 */       url = new URL(stringurl);
/*    */       
/* 25 */       Scanner scanner = (new Scanner(url.openStream(), "UTF-8")).useDelimiter("\\A");
/*    */       
/* 27 */       String result = scanner.next();
/*    */       
/* 29 */       JsonParser parser = new JsonParser();
/* 30 */       data = parser.parse(result).getAsJsonArray();
/*    */       
/* 32 */       scanner.close();
/* 33 */     } catch (Exception e) {
/* 34 */       e.printStackTrace();
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public static boolean getBoolean(String playerUUID, String key) throws IOException {
/* 41 */     for (int i = 0; i < data.size(); i++) {
/* 42 */       JsonObject jsonObject = data.get(i).getAsJsonObject();
/*    */       
/* 44 */       if (jsonObject.get("uuid").getAsString().equals(playerUUID) && 
/* 45 */         jsonObject.get(key).getAsBoolean()) {
/* 46 */         return true;
/*    */       }
/*    */     } 
/*    */ 
/*    */     
/* 51 */     return false;
/*    */   }
/*    */   
/*    */   public static double getDouble(String playerUUID, String key) throws IOException {
/* 55 */     for (int i = 0; i < data.size(); i++) {
/* 56 */       JsonObject jsonObject = data.get(i).getAsJsonObject();
/*    */       
/* 58 */       if (jsonObject.get("uuid").getAsString().equals(playerUUID)) {
/* 59 */         return jsonObject.get(key).getAsDouble();
/*    */       }
/*    */     } 
/*    */     
/* 63 */     return null.doubleValue();
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public static String getString(String playerUUID, String key) throws IOException {
/* 69 */     for (int i = 0; i < data.size(); i++) {
/* 70 */       JsonObject jsonObject = data.get(i).getAsJsonObject();
/*    */       
/* 72 */       if (jsonObject.get("uuid").getAsString().equals(playerUUID)) {
/* 73 */         return jsonObject.get(key).getAsString();
/*    */       }
/*    */     } 
/*    */     
/* 77 */     return null;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static Integer getInt(String playerUUID, String key) throws IOException {
/* 85 */     for (int i = 0; i < data.size(); i++) {
/* 86 */       JsonObject jsonObject = data.get(i).getAsJsonObject();
/*    */       
/* 88 */       if (jsonObject.get("uuid").getAsString().equals(playerUUID)) {
/* 89 */         return Integer.valueOf(jsonObject.get(key).getAsInt());
/*    */       }
/*    */     } 
/*    */     
/* 93 */     return null;
/*    */   }
/*    */ }


/* Location:              C:\Users\Lenovo\Downloads\ZyrexClientV1 (1).jar!\ZyrexClient\cosmetic\impl\DatabaseUtil.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */