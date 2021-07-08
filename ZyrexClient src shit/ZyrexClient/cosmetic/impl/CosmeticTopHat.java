/*    */ package ZyrexClient.cosmetic.impl;
/*    */ 
/*    */ import ZyrexClient.cosmetic.CosmeticBase;
/*    */ import ZyrexClient.cosmetic.CosmeticController;
/*    */ import ZyrexClient.cosmetic.CosmeticModelBase;
/*    */ import net.minecraft.client.entity.AbstractClientPlayer;
/*    */ import net.minecraft.client.model.ModelBase;
/*    */ import net.minecraft.client.model.ModelRenderer;
/*    */ import net.minecraft.client.renderer.GlStateManager;
/*    */ import net.minecraft.client.renderer.entity.RenderPlayer;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.util.ResourceLocation;
/*    */ import org.lwjgl.opengl.GL11;
/*    */ 
/*    */ 
/*    */ public class CosmeticTopHat
/*    */   extends CosmeticBase
/*    */ {
/*    */   private final ModelTopHat modelTopHat;
/* 20 */   private static final ResourceLocation TEXTURE = new ResourceLocation("hat.png");
/*    */   
/*    */   public CosmeticTopHat(RenderPlayer renderPlayer) {
/* 23 */     super(renderPlayer);
/* 24 */     this.modelTopHat = new ModelTopHat(renderPlayer);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void render(AbstractClientPlayer player, float limbSwing, float limpSwingAmount, float partialTicks, float ageInTicks, float headYaw, float headPitch, float scale) {
/* 30 */     if (CosmeticController.shouldRenderTopHat(player)) {
/* 31 */       GlStateManager.pushMatrix();
/*    */       
/* 33 */       if (player.isSneaking()) {
/* 34 */         GL11.glTranslated(0.0D, 0.225D, 0.0D);
/*    */       }
/*    */ 
/*    */       
/* 38 */       float[] color = CosmeticController.getTopHatColor(player);
/* 39 */       GL11.glColor3f(color[0], color[1], color[2]);
/* 40 */       this.modelTopHat.render((Entity)player, limbSwing, limpSwingAmount, ageInTicks, headYaw, headPitch, scale, scale);
/* 41 */       GL11.glColor3f(1.0F, 1.0F, 1.0F);
/* 42 */       GL11.glPopMatrix();
/*    */     } 
/*    */   }
/*    */   
/*    */   private class ModelTopHat
/*    */     extends CosmeticModelBase {
/*    */     private ModelRenderer rim;
/*    */     private ModelRenderer pointy;
/*    */     
/*    */     public ModelTopHat(RenderPlayer player) {
/* 52 */       super(player);
/* 53 */       this.rim = new ModelRenderer((ModelBase)this.playerModel, 0, 0);
/* 54 */       this.rim.addBox(-5.5F, -9.0F, -5.5F, 11, 2, 11);
/* 55 */       this.pointy = new ModelRenderer((ModelBase)this.playerModel, 0, 13);
/* 56 */       this.pointy.addBox(-3.5F, -17.0F, -3.5F, 7, 8, 7);
/*    */     }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */     
/*    */     public void render(Entity entityIn, float limbSwing, float limpSwingAmount, float partialTicks, float ageInTicks, float headYaw, float headPitch, float scale) {
/* 67 */       this.rim.rotateAngleX = this.playerModel.bipedHead.rotateAngleX;
/* 68 */       this.rim.rotateAngleY = this.playerModel.bipedHead.rotateAngleY;
/* 69 */       this.rim.rotationPointX = 0.0F;
/* 70 */       this.rim.rotationPointY = 0.0F;
/* 71 */       this.rim.render(scale);
/*    */       
/* 73 */       this.pointy.rotateAngleX = this.playerModel.bipedHead.rotateAngleX;
/* 74 */       this.pointy.rotateAngleY = this.playerModel.bipedHead.rotateAngleY;
/* 75 */       this.pointy.rotationPointX = 0.0F;
/* 76 */       this.pointy.rotationPointY = 0.0F;
/* 77 */       this.pointy.render(scale);
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Users\Lenovo\Downloads\ZyrexClientV1 (1).jar!\ZyrexClient\cosmetic\impl\CosmeticTopHat.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */