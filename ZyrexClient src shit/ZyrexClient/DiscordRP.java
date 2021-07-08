/*    */ package ZyrexClient;
/*    */ 
/*    */ import net.arikia.dev.drpc.DiscordEventHandlers;
/*    */ import net.arikia.dev.drpc.DiscordRPC;
/*    */ import net.arikia.dev.drpc.DiscordRichPresence;
/*    */ import net.arikia.dev.drpc.DiscordUser;
/*    */ import net.arikia.dev.drpc.callbacks.ReadyCallback;
/*    */ 
/*    */ public class DiscordRP
/*    */ {
/*    */   private boolean running = true;
/* 12 */   private static long created = 0L;
/*    */ 
/*    */   
/*    */   public void start() {
/* 16 */     created = System.currentTimeMillis();
/*    */     
/* 18 */     DiscordEventHandlers handlers = (new DiscordEventHandlers.Builder()).setReadyEventHandler(new ReadyCallback()
/*    */         {
/*    */           public void apply(DiscordUser user)
/*    */           {
/* 22 */             System.out.println("Websome " + user.username + "#" + user.discriminator + ".");
/* 23 */             DiscordRP.this.update("Booting up...", "");
/*    */           }
/* 26 */         }).build();
/*    */     
/* 28 */     DiscordRPC.discordInitialize("833408811959058432", handlers, true);
/*    */     
/* 30 */     (new Thread("Discord RPC Callback")
/*    */       {
/*    */         
/*    */         public void run()
/*    */         {
/* 35 */           while (DiscordRP.this.running) {
/* 36 */             DiscordRPC.discordRunCallbacks();
/*    */ 
/*    */ 
/*    */           
/*    */           }
/*    */         }
/* 42 */       }).start();
/*    */   }
/*    */ 
/*    */   
/*    */   public void shutdown() {
/* 47 */     this.running = false;
/* 48 */     DiscordRPC.discordShutdown();
/*    */   }
/*    */   
/*    */   public void update(String firstLine, String secondLine) {
/* 52 */     DiscordRichPresence.Builder b = new DiscordRichPresence.Builder(secondLine);
/* 53 */     b.setBigImage("zyrex_logo_black", "discord.io/zyrexclient");
/* 54 */     b.setDetails(firstLine);
/* 55 */     b.setStartTimestamps(created);
/*    */     
/* 57 */     DiscordRPC.discordUpdatePresence(b.build());
/*    */   }
/*    */ }


/* Location:              C:\Users\Lenovo\Downloads\ZyrexClientV1 (1).jar!\ZyrexClient\DiscordRP.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */