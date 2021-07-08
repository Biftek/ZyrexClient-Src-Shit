/*    */ package ZyrexClient.Gui.Login2;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class AltManager
/*    */ {
/*    */   public static Alt lastAlt;
/* 11 */   public static ArrayList<Alt> registry = new ArrayList<>();
/*    */ 
/*    */   
/*    */   public ArrayList<Alt> getRegistry() {
/* 15 */     return registry;
/*    */   }
/*    */   
/*    */   public void setLastAlt(Alt alt2) {
/* 19 */     lastAlt = alt2;
/*    */   }
/*    */ }


/* Location:              C:\Users\Lenovo\Downloads\ZyrexClientV1 (1).jar!\ZyrexClient\Gui\Login2\AltManager.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */