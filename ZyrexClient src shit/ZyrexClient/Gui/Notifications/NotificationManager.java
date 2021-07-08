/*    */ package ZyrexClient.Gui.Notifications;
/*    */ 
/*    */ import java.util.concurrent.LinkedBlockingQueue;
/*    */ 
/*    */ public class NotificationManager
/*    */ {
/*  7 */   private static LinkedBlockingQueue<Notification> pendingNotifications = new LinkedBlockingQueue<>();
/*  8 */   private static Notification currentNotification = null;
/*    */   
/*    */   public static void show(Notification notification) {
/* 11 */     pendingNotifications.add(notification);
/*    */   }
/*    */   
/*    */   public static void update() {
/* 15 */     if (currentNotification != null && !currentNotification.isShown()) {
/* 16 */       currentNotification = null;
/*    */     }
/*    */     
/* 19 */     if (currentNotification == null && !pendingNotifications.isEmpty()) {
/* 20 */       currentNotification = pendingNotifications.poll();
/* 21 */       currentNotification.show();
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public static void render() {
/* 27 */     update();
/*    */     
/* 29 */     if (currentNotification != null)
/* 30 */       currentNotification.render(); 
/*    */   }
/*    */ }


/* Location:              C:\Users\Lenovo\Downloads\ZyrexClientV1 (1).jar!\ZyrexClient\Gui\Notifications\NotificationManager.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */