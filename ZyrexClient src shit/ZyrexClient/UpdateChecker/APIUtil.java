/*     */ package ZyrexClient.UpdateChecker;
/*     */ 
/*     */ import com.google.gson.Gson;
/*     */ import com.google.gson.JsonArray;
/*     */ import com.google.gson.JsonElement;
/*     */ import com.google.gson.JsonObject;
/*     */ import java.io.BufferedReader;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.io.InputStreamReader;
/*     */ import java.net.HttpURLConnection;
/*     */ import java.net.URL;
/*     */ import net.minecraft.client.Minecraft;
/*     */ import net.minecraft.client.entity.EntityPlayerSP;
/*     */ import net.minecraft.util.ChatComponentText;
/*     */ import net.minecraft.util.EnumChatFormatting;
/*     */ import net.minecraft.util.IChatComponent;
/*     */ 
/*     */ 
/*     */ public class APIUtil
/*     */ {
/*     */   public static JsonObject getJSONResponse(String urlString) {
/*  23 */     Minecraft.getMinecraft(); EntityPlayerSP entityPlayerSP = Minecraft.thePlayer;
/*     */     
/*     */     try {
/*  26 */       URL url = new URL(urlString);
/*  27 */       HttpURLConnection conn = (HttpURLConnection)url.openConnection();
/*  28 */       conn.setRequestMethod("GET");
/*  29 */       conn.setUseCaches(false);
/*  30 */       conn.setRequestProperty("User-Agent", "Client/1.0.0");
/*     */       
/*  32 */       if (conn.getResponseCode() == 200) {
/*  33 */         BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
/*     */         
/*  35 */         StringBuilder response = new StringBuilder();
/*     */         String input;
/*  37 */         while ((input = in.readLine()) != null) {
/*  38 */           response.append(input);
/*     */         }
/*  40 */         in.close();
/*     */         
/*  42 */         Gson gson = new Gson();
/*     */         
/*  44 */         return (JsonObject)gson.fromJson(response.toString(), JsonObject.class);
/*     */       } 
/*  46 */       if (urlString.startsWith("https://api.hypixel.net/")) {
/*  47 */         InputStream errorStream = conn.getErrorStream();
/*  48 */         String input = null; Exception exception = null;
/*     */ 
/*     */         
/*     */         try {  }
/*     */         finally
/*     */         { Exception exception1;
/*  54 */           exception = null; if (input == null) { exception1 = exception; } else if (exception1 != exception) { exception1.addSuppressed(exception); }  } 
/*  55 */       }  if (urlString.startsWith("https://api.mojang.com/users/profiles/minecraft/") && conn.getResponseCode() == 204) {
/*  56 */         entityPlayerSP.addChatMessage((IChatComponent)new ChatComponentText(EnumChatFormatting.RED + "Failed with reason: Player does not exist."));
/*     */       } else {
/*  58 */         entityPlayerSP.addChatMessage((IChatComponent)new ChatComponentText(EnumChatFormatting.RED + "Request failed. HTTP Error Code: " + conn.getResponseCode()));
/*     */       }
/*     */     
/*  61 */     } catch (IOException ex) {
/*  62 */       entityPlayerSP.addChatMessage((IChatComponent)new ChatComponentText(EnumChatFormatting.RED + "An error has occured. See logs for more details."));
/*  63 */       ex.printStackTrace();
/*     */     } 
/*     */     
/*  66 */     return new JsonObject();
/*     */   }
/*     */ 
/*     */   
/*     */   public static JsonArray getArrayResponse(String urlString) {
/*  71 */     Minecraft.getMinecraft(); EntityPlayerSP entityPlayerSP = Minecraft.thePlayer;
/*     */     
/*     */     try {
/*  74 */       URL url = new URL(urlString);
/*  75 */       HttpURLConnection conn = (HttpURLConnection)url.openConnection();
/*  76 */       conn.setRequestMethod("GET");
/*     */       
/*  78 */       if (conn.getResponseCode() == 200) {
/*  79 */         BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
/*     */         
/*  81 */         StringBuilder response = new StringBuilder();
/*     */         String input;
/*  83 */         while ((input = in.readLine()) != null) {
/*  84 */           response.append(input);
/*     */         }
/*  86 */         in.close();
/*     */         
/*  88 */         Gson gson = new Gson();
/*     */         
/*  90 */         return (JsonArray)gson.fromJson(response.toString(), JsonArray.class);
/*     */       } 
/*  92 */       entityPlayerSP.addChatMessage((IChatComponent)new ChatComponentText(EnumChatFormatting.RED + "Request failed. HTTP Error Code: " + conn.getResponseCode()));
/*     */     }
/*  94 */     catch (IOException ex) {
/*  95 */       entityPlayerSP.addChatMessage((IChatComponent)new ChatComponentText(EnumChatFormatting.RED + "An error has occured. See logs for more details."));
/*  96 */       ex.printStackTrace();
/*     */     } 
/*     */     
/*  99 */     return new JsonArray();
/*     */   }
/*     */   
/*     */   public static String getUUID(String username) {
/* 103 */     JsonObject uuidResponse = getJSONResponse("https://api.mojang.com/users/profiles/minecraft/" + username);
/* 104 */     return uuidResponse.get("id").getAsString();
/*     */   }
/*     */   
/*     */   public static String getLatestProfileID(String UUID, String key) {
/* 108 */     Minecraft.getMinecraft(); EntityPlayerSP entityPlayerSP = Minecraft.thePlayer;
/*     */ 
/*     */     
/* 111 */     System.out.println("Fetching profiles...");
/*     */     
/* 113 */     JsonObject profilesResponse = getJSONResponse("https://api.hypixel.net/skyblock/profiles?uuid=" + UUID + "&key=" + key);
/* 114 */     if (!profilesResponse.get("success").getAsBoolean()) {
/* 115 */       String reason = profilesResponse.get("cause").getAsString();
/* 116 */       entityPlayerSP.addChatMessage((IChatComponent)new ChatComponentText(EnumChatFormatting.RED + "Failed with reason: " + reason));
/* 117 */       return null;
/*     */     } 
/* 119 */     if (profilesResponse.get("profiles").isJsonNull()) {
/* 120 */       entityPlayerSP.addChatMessage((IChatComponent)new ChatComponentText(EnumChatFormatting.RED + "This player doesn't appear to have played SkyBlock."));
/* 121 */       return null;
/*     */     } 
/*     */ 
/*     */     
/* 125 */     System.out.println("Looping through profiles...");
/* 126 */     String latestProfile = "";
/* 127 */     long latestSave = 0L;
/* 128 */     JsonArray profilesArray = profilesResponse.get("profiles").getAsJsonArray();
/*     */     
/* 130 */     for (JsonElement profile : profilesArray) {
/* 131 */       JsonObject profileJSON = profile.getAsJsonObject();
/* 132 */       long profileLastSave = 1L;
/* 133 */       if (profileJSON.get("members").getAsJsonObject().get(UUID).getAsJsonObject().has("last_save")) {
/* 134 */         profileLastSave = profileJSON.get("members").getAsJsonObject().get(UUID).getAsJsonObject().get("last_save").getAsLong();
/*     */       }
/*     */       
/* 137 */       if (profileLastSave > latestSave) {
/* 138 */         latestProfile = profileJSON.get("profile_id").getAsString();
/* 139 */         latestSave = profileLastSave;
/*     */       } 
/*     */     } 
/*     */     
/* 143 */     return latestProfile;
/*     */   }
/*     */ }


/* Location:              C:\Users\Lenovo\Downloads\ZyrexClientV1 (1).jar!\ZyrexClient\UpdateChecker\APIUtil.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */