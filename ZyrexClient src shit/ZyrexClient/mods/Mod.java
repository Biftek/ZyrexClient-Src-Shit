/*    */ package ZyrexClient.mods;
/*    */ 
/*    */ import ZyrexClient.Client;
/*    */ import ZyrexClient.EventManager;
/*    */ import net.minecraft.client.Minecraft;
/*    */ import net.minecraft.client.gui.FontRenderer;
/*    */ 
/*    */ 
/*    */ public class Mod
/*    */ {
/*    */   public boolean isEnabled = true;
/*    */   protected final Minecraft mc;
/*    */   protected final FontRenderer font;
/*    */   protected final Client client;
/*    */   
/*    */   public Mod() {
/* 17 */     this.mc = Minecraft.getMinecraft();
/* 18 */     this.font = this.mc.fontRendererObj;
/* 19 */     this.client = Client.getInstance();
/*    */     
/* 21 */     setEnabled(this.isEnabled);
/*    */   }
/*    */   
/*    */   public void setEnabled(boolean isEnabled) {
/* 25 */     this.isEnabled = isEnabled;
/*    */     
/* 27 */     if (isEnabled) {
/* 28 */       EventManager.register(this);
/*    */     } else {
/*    */       
/* 31 */       EventManager.unregister(this);
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean isEnabled() {
/* 37 */     return this.isEnabled;
/*    */   }
/*    */ }


/* Location:              C:\Users\Lenovo\Downloads\ZyrexClientV1 (1).jar!\ZyrexClient\mods\Mod.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */