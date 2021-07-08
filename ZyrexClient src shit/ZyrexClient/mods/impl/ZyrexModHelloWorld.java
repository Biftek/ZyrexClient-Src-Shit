/*    */ package ZyrexClient.mods.impl;
/*    */ 
/*    */ import ZyrexClient.Gui.ScreenPosition;
/*    */ import ZyrexClient.mods.ModDraggable;
/*    */ 
/*    */ public class ZyrexModHelloWorld
/*    */   extends ModDraggable
/*    */ {
/*    */   public int getWidth() {
/* 10 */     return this.font.getStringWidth("Hello World (Dummy)");
/*    */   }
/*    */ 
/*    */   
/*    */   public int getHeight() {
/* 15 */     return this.font.FONT_HEIGHT;
/*    */   }
/*    */ 
/*    */   
/*    */   public void render(ScreenPosition pos) {
/* 20 */     this.font.drawString("Hello World", (pos.getAbsoluteX() + 1), (pos.getAbsoluteY() + 1), -1);
/*    */   }
/*    */ 
/*    */   
/*    */   public void renderDummy(ScreenPosition pos) {
/* 25 */     this.font.drawString("Hello World (Dummy)", (pos.getAbsoluteX() + 1), (pos.getAbsoluteY() + 1), -16711936);
/*    */   }
/*    */ }


/* Location:              C:\Users\Lenovo\Downloads\ZyrexClientV1 (1).jar!\ZyrexClient\mods\impl\ZyrexModHelloWorld.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */