/*    */ package ZyrexClient.ModEveryLook;
/*    */ 
/*    */ import ZyrexClient.EventCancelable;
/*    */ 
/*    */ public class KeyEvent
/*    */   extends EventCancelable {
/*    */   public KeyEvent(int key) {
/*  8 */     this.key = key;
/*    */   }
/*    */   private final int key;
/*    */   public int getKey() {
/* 12 */     return this.key;
/*    */   }
/*    */   
/*    */   public void call() {}
/*    */ }


/* Location:              C:\Users\Lenovo\Downloads\ZyrexClientV1 (1).jar!\ZyrexClient\ModEveryLook\KeyEvent.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */