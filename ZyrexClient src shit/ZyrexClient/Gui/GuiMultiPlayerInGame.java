/*    */ package ZyrexClient.Gui;
/*    */ 
/*    */ import java.io.IOException;
/*    */ import net.minecraft.client.gui.GuiButton;
/*    */ import net.minecraft.client.gui.GuiMultiplayer;
/*    */ 
/*    */ 
/*    */ public class GuiMultiPlayerInGame
/*    */   extends GuiMultiplayer
/*    */ {
/*    */   public GuiMultiPlayerInGame() {
/* 12 */     super(null);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   protected void actionPerformed(GuiButton button) throws IOException {
/* 18 */     if (button.id == 1 || button.id == 4) {
/* 19 */       disconnect();
/*    */     }
/*    */     
/* 22 */     super.actionPerformed(button);
/*    */   }
/*    */   
/*    */   private void disconnect() {
/* 26 */     if (mc.theWorld != null) {
/*    */       
/* 28 */       mc.theWorld.sendQuittingDisconnectingPacket();
/* 29 */       mc.loadWorld(null);
/* 30 */       mc.displayGuiScreen(null);
/* 31 */       this.parentScreen = null;
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void connectToSelected() {
/* 38 */     disconnect();
/* 39 */     super.connectToSelected();
/*    */   }
/*    */ }


/* Location:              C:\Users\Lenovo\Downloads\ZyrexClientV1 (1).jar!\ZyrexClient\Gui\GuiMultiPlayerInGame.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */