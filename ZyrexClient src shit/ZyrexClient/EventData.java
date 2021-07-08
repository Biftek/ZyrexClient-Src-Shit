/*    */ package ZyrexClient;
/*    */ 
/*    */ import java.lang.reflect.Method;
/*    */ 
/*    */ public class EventData
/*    */ {
/*    */   public final Object source;
/*    */   public final Method target;
/*    */   public final byte priority;
/*    */   
/*    */   public EventData(Object source, Method target, byte priority) {
/* 12 */     this.source = source;
/* 13 */     this.target = target;
/* 14 */     this.priority = priority;
/*    */   }
/*    */ }


/* Location:              C:\Users\Lenovo\Downloads\ZyrexClientV1 (1).jar!\ZyrexClient\EventData.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */