/*    */ package ZyrexClient.cosmetic.impl;
/*    */ 
/*    */ import ZyrexClient.Client;
/*    */ import ZyrexClient.cosmetic.CosmeticBase;
/*    */ import ZyrexClient.cosmetic.CosmeticModelBase;
/*    */ import net.minecraft.client.Minecraft;
/*    */ import net.minecraft.client.entity.AbstractClientPlayer;
/*    */ import net.minecraft.client.renderer.GlStateManager;
/*    */ import net.minecraft.client.renderer.block.model.ItemCameraTransforms;
/*    */ import net.minecraft.client.renderer.entity.RenderPlayer;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.entity.EntityLivingBase;
/*    */ import net.minecraft.init.Items;
/*    */ import net.minecraft.item.ItemStack;
/*    */ import org.lwjgl.opengl.GL11;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CosmeticEasterEgg
/*    */   extends CosmeticBase
/*    */ {
/*    */   private final CosmeticVilligerNose2 EggsModel;
/*    */   
/*    */   public CosmeticEasterEgg(RenderPlayer renderPlayer) {
/* 31 */     super(renderPlayer);
/* 32 */     this.EggsModel = new CosmeticVilligerNose2(renderPlayer);
/*    */   }
/*    */ 
/*    */   
/*    */   public void render(AbstractClientPlayer player, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
/* 37 */     GL11.glPushMatrix();
/* 38 */     if (player.isSneaking()) {
/* 39 */       GlStateManager.translate(0.0D, 0.262D, 0.0D);
/*    */     }
/* 41 */     GlStateManager.rotate(netHeadYaw, 0.0F, 1.0F, 0.0F);
/* 42 */     GlStateManager.rotate(headPitch, 1.0F, 0.0F, 0.0F);
/* 43 */     GlStateManager.rotate(ageInTicks * 17.0F, 0.0F, 1.0F, 0.0F);
/* 44 */     GlStateManager.rotate(180.0F, 1.0F, 0.0F, 0.0F);
/* 45 */     String uuid = player.getUniqueID().toString();
/* 46 */     if (uuid.contains("dwabdwbo8adb8wbdwa")) {
/* 47 */       this.EggsModel.render((Entity)player, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);
/* 48 */       GL11.glColor3d(1.0D, 1.0D, 1.0D);
/*    */     } 
/*    */ 
/*    */     
/* 52 */     Minecraft.getMinecraft(); if (player == Minecraft.thePlayer && Client.CosmeticEasterEggs) {
/* 53 */       this.EggsModel.render((Entity)player, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);
/*    */     }
/* 55 */     GL11.glPopMatrix();
/*    */   }
/*    */   
/*    */   public class CosmeticVilligerNose2
/*    */     extends CosmeticModelBase
/*    */   {
/*    */     public CosmeticVilligerNose2(RenderPlayer player) {
/* 62 */       super(player);
/*    */     }
/*    */ 
/*    */ 
/*    */ 
/*    */     
/*    */     public void render(Entity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float headYaw, float headPitch, float scale) {
/* 69 */       Minecraft mc = null;
/*    */ 
/*    */ 
/*    */       
/* 73 */       GlStateManager.pushMatrix();
/* 74 */       GlStateManager.scale(0.25D, 0.25D, 0.25D);
/* 75 */       GlStateManager.translate(2.0D, 1.5D, 0.0D);
/* 76 */       ItemStack itemsword = new ItemStack(Items.egg);
/* 77 */       Minecraft.getMinecraft().getItemRenderer().renderItem((EntityLivingBase)entityIn, itemsword, ItemCameraTransforms.TransformType.NONE);
/* 78 */       GlStateManager.translate(-4.0F, 0.0F, 0.0F);
/* 79 */       Minecraft.getMinecraft().getItemRenderer().renderItem((EntityLivingBase)entityIn, itemsword, ItemCameraTransforms.TransformType.NONE);
/* 80 */       GlStateManager.translate(2.0F, 0.0F, 2.0F);
/* 81 */       Minecraft.getMinecraft().getItemRenderer().renderItem((EntityLivingBase)entityIn, itemsword, ItemCameraTransforms.TransformType.NONE);
/* 82 */       GlStateManager.translate(0.0F, 0.0F, -4.0F);
/* 83 */       Minecraft.getMinecraft().getItemRenderer().renderItem((EntityLivingBase)entityIn, itemsword, ItemCameraTransforms.TransformType.NONE);
/*    */       
/* 85 */       GlStateManager.popMatrix();
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Users\Lenovo\Downloads\ZyrexClientV1 (1).jar!\ZyrexClient\cosmetic\impl\CosmeticEasterEgg.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */