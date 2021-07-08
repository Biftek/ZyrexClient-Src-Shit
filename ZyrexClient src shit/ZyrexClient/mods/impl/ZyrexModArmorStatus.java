/*    */ package ZyrexClient.mods.impl;
/*    */ 
/*    */ import ZyrexClient.Client;
/*    */ import ZyrexClient.Gui.ScreenPosition;
/*    */ import ZyrexClient.ModHuds.Rainbow;
/*    */ import ZyrexClient.mods.ModDraggable;
/*    */ import java.awt.Color;
/*    */ import net.minecraft.client.Minecraft;
/*    */ import net.minecraft.client.gui.GuiScreen;
/*    */ import net.minecraft.client.renderer.GlStateManager;
/*    */ import net.minecraft.client.renderer.RenderHelper;
/*    */ import net.minecraft.init.Items;
/*    */ import net.minecraft.item.Item;
/*    */ import net.minecraft.item.ItemStack;
/*    */ 
/*    */ public class ZyrexModArmorStatus
/*    */   extends ModDraggable
/*    */ {
/*    */   public int getWidth() {
/* 20 */     if (Client.ModArmorStatus) {
/* 21 */       return 42;
/*    */     }
/* 23 */     return 0;
/*    */   }
/*    */ 
/*    */   
/*    */   public int getHeight() {
/* 28 */     if (Client.ModArmorStatus) {
/* 29 */       return 62;
/*    */     }
/* 31 */     return 0;
/*    */   }
/*    */ 
/*    */   
/*    */   public void render(ScreenPosition pos) {
/* 36 */     if (Client.ModArmorStatus) {
/* 37 */       if (Client.ArmorStatusBackground) {
/* 38 */         GuiScreen.drawRect(pos.getAbsoluteX() / 1 + 1, pos.getAbsoluteY() / 1 + 62, pos.getAbsoluteX() + 42, pos.getAbsoluteY() + 1, (new Color(0, 0, 0, 100)).getRGB());
/*    */       }
/*    */ 
/*    */       
/* 42 */       for (int i = 0; i < Minecraft.thePlayer.inventory.armorInventory.length; i++) {
/* 43 */         ItemStack itemStack = Minecraft.thePlayer.inventory.armorInventory[i];
/* 44 */         renderItemStack(pos, i, itemStack);
/*    */       } 
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void renderDummy(ScreenPosition pos) {
/* 54 */     if (Client.ModArmorStatus) {
/* 55 */       if (Client.ArmorStatusBackground) {
/* 56 */         GuiScreen.drawRect(pos.getAbsoluteX() / 1 + 1, pos.getAbsoluteY() / 1 + 62, pos.getAbsoluteX() + 42, pos.getAbsoluteY() + 1, (new Color(0, 0, 0, 100)).getRGB());
/*    */       }
/*    */ 
/*    */       
/* 60 */       renderItemStack(pos, 3, new ItemStack((Item)Items.diamond_helmet));
/* 61 */       renderItemStack(pos, 2, new ItemStack((Item)Items.diamond_chestplate));
/* 62 */       renderItemStack(pos, 1, new ItemStack((Item)Items.diamond_leggings));
/* 63 */       renderItemStack(pos, 0, new ItemStack((Item)Items.diamond_boots));
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   private void renderItemStack(ScreenPosition pos, int i, ItemStack itemStack) {
/* 70 */     if (itemStack == null)
/*    */       return; 
/* 72 */     GlStateManager.pushMatrix();
/* 73 */     int yAdd = -16 * i + 48;
/* 74 */     if (itemStack.getItem().isDamageable())
/* 75 */       if (Client.ArmorStatusChroma) {
/* 76 */         this.font.drawStringWithShadow(String.valueOf(itemStack.getMaxDamage() - itemStack.getItemDamage()), (pos.getAbsoluteX() + 20), (pos.getAbsoluteY() + yAdd + 5), -1);
/*    */       } else {
/* 78 */         Rainbow.drawChromaString(String.valueOf(itemStack.getMaxDamage() - itemStack.getItemDamage()), pos.getAbsoluteX() + 20, pos.getAbsoluteY() + yAdd + 5, true);
/*    */       }  
/* 80 */     RenderHelper.enableGUIStandardItemLighting();
/* 81 */     this.mc.getRenderItem().renderItemAndEffectIntoGUI(itemStack, pos.getAbsoluteX(), pos.getAbsoluteY() + yAdd);
/* 82 */     GlStateManager.popMatrix();
/*    */   }
/*    */ }


/* Location:              C:\Users\Lenovo\Downloads\ZyrexClientV1 (1).jar!\ZyrexClient\mods\impl\ZyrexModArmorStatus.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */