/*    */ package ZyrexClient.Gui;
/*    */ 
/*    */ public interface IRenderer extends IRenderConfig {
/*    */   int getWidth();
/*    */   
/*    */   int getHeight();
/*    */   
/*    */   void render(ScreenPosition paramScreenPosition);
/*    */   
/*    */   default void renderDummy(ScreenPosition pos) {
/* 11 */     render(pos);
/*    */   }
/*    */   
/*    */   ScreenPosition load();
/*    */   
/*    */   boolean isEnabled();
/*    */ }


/* Location:              C:\Users\Lenovo\Downloads\ZyrexClientV1 (1).jar!\ZyrexClient\Gui\IRenderer.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */