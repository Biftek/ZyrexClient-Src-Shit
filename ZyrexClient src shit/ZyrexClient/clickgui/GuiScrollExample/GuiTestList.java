/*    */ package ZyrexClient.clickgui.GuiScrollExample;
/*    */ 
/*    */ import java.io.IOException;
/*    */ import net.minecraft.client.gui.GuiScreen;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class GuiTestList
/*    */   extends GuiScreen
/*    */ {
/*    */   private ScrollListTest scrollerThingy;
/*    */   
/*    */   public void initGui() {
/* 19 */     this.scrollerThingy = new ScrollListTest(mc, this);
/* 20 */     buttonList.clear();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void handleMouseInput() throws IOException {
/* 27 */     super.handleMouseInput();
/* 28 */     this.scrollerThingy.handleMouseInput();
/*    */   }
/*    */ 
/*    */   
/*    */   protected void mouseClicked(int mouseX, int mouseY, int mouseButton) throws IOException {
/* 33 */     if (mouseButton != 0 || !this.scrollerThingy.mouseClicked(mouseX, mouseY, mouseButton))
/*    */     {
/* 35 */       super.mouseClicked(mouseX, mouseY, mouseButton);
/*    */     }
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   protected void mouseReleased(int mouseX, int mouseY, int state) {
/* 42 */     if (state != 0 || !this.scrollerThingy.mouseReleased(mouseX, mouseY, state))
/*    */     {
/* 44 */       super.mouseReleased(mouseX, mouseY, state);
/*    */     }
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void drawScreen(int mouseX, int mouseY, float partialTicks) {
/* 52 */     this.scrollerThingy.drawScreen(mouseX, mouseY, partialTicks);
/* 53 */     drawCenteredString(fontRendererObj, "Scroll Test (Like controls)", width / 2, 8, 16777215);
/*    */     
/* 55 */     super.drawScreen(mouseX, mouseY, partialTicks);
/*    */   }
/*    */ }


/* Location:              C:\Users\Lenovo\Downloads\ZyrexClientV1 (1).jar!\ZyrexClient\clickgui\GuiScrollExample\GuiTestList.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */