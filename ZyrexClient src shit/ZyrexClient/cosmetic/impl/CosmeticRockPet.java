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
/*    */ import net.minecraft.init.Blocks;
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
/*    */ 
/*    */ public class CosmeticRockPet
/*    */   extends CosmeticBase
/*    */ {
/*    */   private final CosmeticVilligerNose2 EggsModel;
/*    */   
/*    */   public CosmeticRockPet(RenderPlayer renderPlayer) {
/* 32 */     super(renderPlayer);
/* 33 */     this.EggsModel = new CosmeticVilligerNose2(renderPlayer);
/*    */   }
/*    */ 
/*    */   
/*    */   public void render(AbstractClientPlayer player, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
/* 38 */     GL11.glPushMatrix();
/* 39 */     if (player.isSneaking()) {
/* 40 */       GlStateManager.translate(0.0D, 0.262D, 0.0D);
/*    */     }
/* 42 */     GlStateManager.rotate(180.0F, 1.0F, 0.0F, 0.0F);
/* 43 */     String uuid = player.getUniqueID().toString();
/* 44 */     if (uuid.contains("dwabdwbo8adb8wbdwa")) {
/* 45 */       this.EggsModel.render((Entity)player, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);
/* 46 */       GL11.glColor3d(1.0D, 1.0D, 1.0D);
/*    */     } 
/*    */ 
/*    */     
/* 50 */     Minecraft.getMinecraft(); if (player == Minecraft.thePlayer && Client.CosmeticRockPet) {
/* 51 */       this.EggsModel.render((Entity)player, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);
/*    */     }
/* 53 */     GL11.glPopMatrix();
/*    */   }
/*    */   
/*    */   public class CosmeticVilligerNose2
/*    */     extends CosmeticModelBase
/*    */   {
/*    */     public CosmeticVilligerNose2(RenderPlayer player) {
/* 60 */       super(player);
/*    */     }
/*    */ 
/*    */ 
/*    */ 
/*    */     
/*    */     public void render(Entity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float headYaw, float headPitch, float scale) {
/* 67 */       Minecraft mc = null;
/*    */ 
/*    */ 
/*    */       
/* 71 */       GlStateManager.pushMatrix();
/* 72 */       GlStateManager.scale(0.25D, 0.25D, 0.25D);
/* 73 */       GlStateManager.translate(1.6D, 0.8D, 0.0D);
/* 74 */       ItemStack eye = new ItemStack(Blocks.coal_block);
/*    */       
/* 76 */       ItemStack stone = new ItemStack(Blocks.stone);
/*    */       
/* 78 */       Minecraft.getMinecraft().getItemRenderer().renderItem((EntityLivingBase)entityIn, stone, ItemCameraTransforms.TransformType.NONE);
/* 79 */       GlStateManager.translate(-0.23D, 0.0D, 0.5D);
/* 80 */       GlStateManager.scale(0.2D, 0.2D, 0.2D);
/* 81 */       Minecraft.getMinecraft().getItemRenderer().renderItem((EntityLivingBase)entityIn, eye, ItemCameraTransforms.TransformType.NONE);
/* 82 */       GlStateManager.translate(0.0D, 0.0D, -2.0D);
/* 83 */       GlStateManager.translate(2.2D, 0.0D, 2.0D);
/* 84 */       Minecraft.getMinecraft().getItemRenderer().renderItem((EntityLivingBase)entityIn, eye, ItemCameraTransforms.TransformType.NONE);
/*    */       
/* 86 */       GlStateManager.popMatrix();
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Users\Lenovo\Downloads\ZyrexClientV1 (1).jar!\ZyrexClient\cosmetic\impl\CosmeticRockPet.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */