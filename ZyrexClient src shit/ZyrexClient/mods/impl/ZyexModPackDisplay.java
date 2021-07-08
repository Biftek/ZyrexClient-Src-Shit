/*    */ package ZyrexClient.mods.impl;
/*    */ 
/*    */ import ZyrexClient.Gui.ScreenPosition;
/*    */ import ZyrexClient.mods.ModDraggable;
/*    */ import java.util.List;
/*    */ import net.minecraft.client.Minecraft;
/*    */ import net.minecraft.client.resources.IResourcePack;
/*    */ import net.minecraft.client.resources.ResourcePackRepository;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ZyexModPackDisplay
/*    */   extends ModDraggable
/*    */ {
/*    */   public int getWidth() {
/* 20 */     return 102;
/*    */   }
/*    */ 
/*    */   
/*    */   public int getHeight() {
/* 25 */     return 15;
/*    */   }
/*    */ 
/*    */   
/*    */   public void render(ScreenPosition pos) {
/* 30 */     if (this.mc.getNetHandler() != null && Minecraft.thePlayer != null && this.mc.getNetHandler().getPlayerInfo(Minecraft.thePlayer.getUniqueID()) != null) {
/* 31 */       this.font.drawString(getCurrentPack().getPackName(), (pos.getAbsoluteX() + getWidth() - 49), (pos.getAbsoluteY() + 4), -1);
/*    */     }
/*    */   }
/*    */ 
/*    */   
/*    */   public void renderDummy(ScreenPosition pos) {
/* 37 */     if (this.mc.getNetHandler() != null && Minecraft.thePlayer != null && this.mc.getNetHandler().getPlayerInfo(Minecraft.thePlayer.getUniqueID()) != null) {
/* 38 */       this.font.drawString(getCurrentPack().getPackName(), (pos.getAbsoluteX() + getWidth() - 49), (pos.getAbsoluteY() + 4), -1);
/*    */     }
/*    */   }
/*    */   
/*    */   private static int getX(int width) {
/* 43 */     return width;
/*    */   }
/*    */   
/*    */   private IResourcePack getCurrentPack() {
/* 47 */     List<ResourcePackRepository.Entry> list = this.mc.getResourcePackRepository().getRepositoryEntries();
/* 48 */     Object pack = null;
/*    */     
/* 50 */     return (list.size() > 0) ? ((ResourcePackRepository.Entry)list.get(0)).getResourcePack() : (IResourcePack)this.mc.mcDefaultResourcePack;
/*    */   }
/*    */ }


/* Location:              C:\Users\Lenovo\Downloads\ZyrexClientV1 (1).jar!\ZyrexClient\mods\impl\ZyexModPackDisplay.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */