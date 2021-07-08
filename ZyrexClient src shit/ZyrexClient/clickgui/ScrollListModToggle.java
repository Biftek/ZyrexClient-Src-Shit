/*    */ package ZyrexClient.clickgui;
/*    */ 
/*    */ import ModHud4;
/*    */ import java.util.List;
/*    */ import net.minecraft.client.Minecraft;
/*    */ import net.minecraft.client.gui.GuiListExtended;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ScrollListModToggle
/*    */   extends GuiListExtended
/*    */ {
/*    */   private final List<ModEntry> entrys;
/*    */   
/*    */   public ScrollListModToggle(Minecraft paramMinecraft, ModHud4 paramModHud4) {}
/*    */   
/*    */   public GuiListExtended.IGuiListEntry getListEntry(int index) {
/* 30 */     return this.entrys.get(index);
/*    */   }
/*    */ 
/*    */   
/*    */   protected int getSize() {
/* 35 */     return this.entrys.size();
/*    */   }
/*    */ }


/* Location:              C:\Users\Lenovo\Downloads\ZyrexClientV1 (1).jar!\ZyrexClient\clickgui\ScrollListModToggle.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */