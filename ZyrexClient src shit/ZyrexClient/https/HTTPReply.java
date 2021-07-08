/*    */ package ZyrexClient.https;
/*    */ 
/*    */ import org.apache.http.HttpResponse;
/*    */ import org.apache.http.util.EntityUtils;
/*    */ 
/*    */ public class HTTPReply
/*    */ {
/*    */   private String body;
/*    */   private int statusCode;
/*    */   
/*    */   public HTTPReply(HttpResponse resp) {
/* 12 */     if (resp == null) {
/* 13 */       this.body = "";
/* 14 */       this.statusCode = -1;
/*    */     } else {
/*    */       
/* 17 */       this.statusCode = resp.getStatusLine().getStatusCode();
/*    */       try {
/* 19 */         this.body = EntityUtils.toString(resp.getEntity());
/*    */       }
/* 21 */       catch (Exception e) {
/* 22 */         this.body = "error";
/*    */       } 
/*    */     } 
/*    */   }
/*    */   
/*    */   public String getBody() {
/* 28 */     return this.body;
/*    */   }
/*    */   
/*    */   public int getStatusCode() {
/* 32 */     return this.statusCode;
/*    */   }
/*    */ }


/* Location:              C:\Users\Lenovo\Downloads\ZyrexClientV1 (1).jar!\ZyrexClient\https\HTTPReply.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */