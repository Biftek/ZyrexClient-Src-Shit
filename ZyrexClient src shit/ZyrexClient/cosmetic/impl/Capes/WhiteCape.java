/*    */ package ZyrexClient.cosmetic.impl.Capes;
/*    */ 
/*    */ import ZyrexClient.Client;
/*    */ import ZyrexClient.cosmetic.AnimatedResourceLocation;
/*    */ import net.minecraft.client.Minecraft;
/*    */ import net.minecraft.client.entity.AbstractClientPlayer;
/*    */ import net.minecraft.client.renderer.GlStateManager;
/*    */ import net.minecraft.client.renderer.entity.RenderPlayer;
/*    */ import net.minecraft.client.renderer.entity.layers.LayerRenderer;
/*    */ import net.minecraft.entity.EntityLivingBase;
/*    */ import net.minecraft.entity.player.EnumPlayerModelParts;
/*    */ import net.minecraft.util.MathHelper;
/*    */ import net.minecraft.util.ResourceLocation;
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
/*    */ public class WhiteCape
/*    */   implements LayerRenderer
/*    */ {
/*    */   private final RenderPlayer playerRenderer;
/*    */   private static final String __OBFID = "CL_00002425";
/* 31 */   public static AnimatedResourceLocation ar = new AnimatedResourceLocation("zyrexcapewhite.png", 6, 20);
/*    */   
/*    */   public WhiteCape(RenderPlayer renderPlayer) {
/* 34 */     this.playerRenderer = renderPlayer;
/*    */   }
/*    */ 
/*    */   
/*    */   public void doRenderLayer(AbstractClientPlayer entitylivingbaseIn, float p_177141_2_, float p_177141_3_, float partialTicks, float p_177141_5_, float p_177141_6_, float p_177141_7_, float scale) {
/* 39 */     if (entitylivingbaseIn.hasPlayerInfo() && !entitylivingbaseIn.isInvisible() && entitylivingbaseIn.isWearing(EnumPlayerModelParts.CAPE)) {
/*    */       
/* 41 */       Minecraft.getMinecraft(); if (Client.WhiteCape && entitylivingbaseIn == Minecraft.thePlayer) {
/* 42 */         GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
/* 43 */         Minecraft.getMinecraft().getTextureManager().bindTexture(new ResourceLocation("zyrexcapewhite.png"));
/* 44 */         GlStateManager.pushMatrix();
/* 45 */         GlStateManager.translate(0.0F, 0.0F, 0.125F);
/* 46 */         double d0 = entitylivingbaseIn.prevChasingPosX + (entitylivingbaseIn.chasingPosX - entitylivingbaseIn.prevChasingPosX) * partialTicks - entitylivingbaseIn.prevPosX + (entitylivingbaseIn.posX - entitylivingbaseIn.prevPosX) * partialTicks;
/* 47 */         double d1 = entitylivingbaseIn.prevChasingPosY + (entitylivingbaseIn.chasingPosY - entitylivingbaseIn.prevChasingPosY) * partialTicks - entitylivingbaseIn.prevPosY + (entitylivingbaseIn.posY - entitylivingbaseIn.prevPosY) * partialTicks;
/* 48 */         double d2 = entitylivingbaseIn.prevChasingPosZ + (entitylivingbaseIn.chasingPosZ - entitylivingbaseIn.prevChasingPosZ) * partialTicks - entitylivingbaseIn.prevPosZ + (entitylivingbaseIn.posZ - entitylivingbaseIn.prevPosZ) * partialTicks;
/* 49 */         float f = entitylivingbaseIn.prevRenderYawOffset + (entitylivingbaseIn.renderYawOffset - entitylivingbaseIn.prevRenderYawOffset) * partialTicks;
/* 50 */         double d3 = MathHelper.sin(f * 3.1415927F / 180.0F);
/* 51 */         double d4 = -MathHelper.cos(f * 3.1415927F / 180.0F);
/* 52 */         float f1 = (float)d1 * 10.0F;
/* 53 */         f1 = MathHelper.clamp_float(f1, -6.0F, 32.0F);
/* 54 */         float f2 = (float)(d0 * d3 + d2 * d4) * 100.0F;
/* 55 */         float f3 = (float)(d0 * d4 - d2 * d3) * 100.0F;
/*    */         
/* 57 */         if (f2 < 0.0F)
/*    */         {
/* 59 */           f2 = 0.0F;
/*    */         }
/*    */         
/* 62 */         if (f2 > 165.0F)
/*    */         {
/* 64 */           f2 = 165.0F;
/*    */         }
/*    */         
/* 67 */         float f4 = entitylivingbaseIn.prevCameraYaw + (entitylivingbaseIn.cameraYaw - entitylivingbaseIn.prevCameraYaw) * partialTicks;
/* 68 */         f1 += MathHelper.sin((entitylivingbaseIn.prevDistanceWalkedModified + (entitylivingbaseIn.distanceWalkedModified - entitylivingbaseIn.prevDistanceWalkedModified) * partialTicks) * 6.0F) * 32.0F * f4;
/*    */         
/* 70 */         if (entitylivingbaseIn.isSneaking()) {
/*    */           
/* 72 */           f1 += 25.0F;
/* 73 */           GlStateManager.translate(0.0F, 0.142F, -0.0178F);
/*    */         } 
/*    */         
/* 76 */         GlStateManager.rotate(6.0F + f2 / 2.0F + f1, 1.0F, 0.0F, 0.0F);
/* 77 */         GlStateManager.rotate(f3 / 2.0F, 0.0F, 0.0F, 1.0F);
/* 78 */         GlStateManager.rotate(-f3 / 2.0F, 0.0F, 1.0F, 0.0F);
/* 79 */         GlStateManager.rotate(180.0F, 0.0F, 1.0F, 0.0F);
/* 80 */         this.playerRenderer.getMainModel().renderCape(0.0625F);
/*    */         
/* 82 */         GlStateManager.popMatrix();
/*    */       } 
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean shouldCombineTextures() {
/* 92 */     return false;
/*    */   }
/*    */ 
/*    */   
/*    */   public void doRenderLayer(EntityLivingBase entitylivingbaseIn, float p_177141_2_, float p_177141_3_, float partialTicks, float p_177141_5_, float p_177141_6_, float p_177141_7_, float scale) {
/* 97 */     doRenderLayer((AbstractClientPlayer)entitylivingbaseIn, p_177141_2_, p_177141_3_, partialTicks, p_177141_5_, p_177141_6_, p_177141_7_, scale);
/*    */   }
/*    */ }


/* Location:              C:\Users\Lenovo\Downloads\ZyrexClientV1 (1).jar!\ZyrexClient\cosmetic\impl\Capes\WhiteCape.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */