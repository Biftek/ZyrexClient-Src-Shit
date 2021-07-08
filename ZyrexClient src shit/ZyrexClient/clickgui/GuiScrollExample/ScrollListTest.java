/*    */ package ZyrexClient.clickgui.GuiScrollExample;
/*    */ 
/*    */ import ZyrexClient.clickguitest.ModToggleButton;
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import net.minecraft.client.Minecraft;
/*    */ import net.minecraft.client.gui.GuiListExtended;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ScrollListTest
/*    */   extends GuiListExtended
/*    */ {
/* 16 */   private final List<GuiListExtended.IGuiListEntry> entrys = new ArrayList<>();
/*    */   
/*    */   public ScrollListTest(Minecraft mcIn, GuiTestList inGui) {
/* 19 */     super(mcIn, GuiTestList.width, GuiTestList.height, 63, GuiTestList.height - 32, 115);
/* 20 */     for (int i = 0; i < 10; i++) {
/* 21 */       this.entrys.add(new BtnEntry("Btn: " + i, null));
/*    */     }
/*    */   }
/*    */ 
/*    */   
/*    */   public GuiListExtended.IGuiListEntry getListEntry(int index) {
/* 27 */     return this.entrys.get(index);
/*    */   }
/*    */ 
/*    */   
/*    */   protected int getSize() {
/* 32 */     return this.entrys.size();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public class BtnEntry
/*    */     implements GuiListExtended.IGuiListEntry
/*    */   {
/* 42 */     private final ModToggleButton btn = new ModToggleButton(0, 0, 0, 22, 12, "a");
/* 43 */     private final ModToggleButton btn2 = new ModToggleButton(0, 0, 0, 22, 12, " - 2");
/*    */ 
/*    */ 
/*    */ 
/*    */     
/*    */     public void drawEntry(int slotIndex, int x, int y, int listWidth, int slotHeight, int mouseX, int mouseY, boolean isSelected) {
/* 49 */       this.btn.xPosition = x + 105;
/* 50 */       this.btn.yPosition = y + 100;
/* 51 */       this.btn.drawButton(ScrollListTest.this.mc, mouseX, mouseY);
/*    */       
/* 53 */       this.btn2.xPosition = x + 10;
/* 54 */       this.btn2.yPosition = y + 100;
/* 55 */       this.btn2.drawButton(ScrollListTest.this.mc, mouseX, mouseY);
/*    */     }
/*    */ 
/*    */ 
/*    */     
/*    */     public boolean mousePressed(int slotIndex, int x, int y, int p_148278_4_, int p_148278_5_, int p_148278_6_) {
/* 61 */       return this.btn.mousePressed(ScrollListTest.this.mc, x, y);
/*    */     }
/*    */ 
/*    */ 
/*    */     
/*    */     public void mouseReleased(int slotIndex, int x, int y, int mouseEvent, int relativeX, int relativeY) {
/* 67 */       this.btn.mouseReleased(x, y);
/*    */     }
/*    */     
/*    */     public void setSelected(int p_178011_1_, int p_178011_2_, int p_178011_3_) {}
/*    */     
/*    */     private BtnEntry(String name) {}
/*    */   }
/*    */ }


/* Location:              C:\Users\Lenovo\Downloads\ZyrexClientV1 (1).jar!\ZyrexClient\clickgui\GuiScrollExample\ScrollListTest.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */