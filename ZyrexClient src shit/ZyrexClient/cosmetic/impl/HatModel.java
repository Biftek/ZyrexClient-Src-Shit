/*     */ package ZyrexClient.cosmetic.impl;
/*     */ 
/*     */ import ZyrexClient.cosmetic.CosmeticModelBase;
/*     */ import net.minecraft.client.Minecraft;
/*     */ import net.minecraft.client.model.ModelBase;
/*     */ import net.minecraft.client.model.ModelRenderer;
/*     */ import net.minecraft.client.renderer.entity.RenderPlayer;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.util.ResourceLocation;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class HatModel
/*     */   extends CosmeticModelBase
/*     */ {
/*     */   private ModelRenderer witchHat;
/*     */   
/*     */   public HatModel(RenderPlayer player) {
/*  72 */     super(player);
/*     */     
/*  74 */     this.witchHat = (new ModelRenderer((ModelBase)this)).setTextureSize(64, 128);
/*  75 */     this.witchHat.setTextureOffset(0, 64).addBox(0.0F, 0.0F, 0.0F, 10, 2, 10);
/*  76 */     ModelRenderer modelrenderer = (new ModelRenderer((ModelBase)this)).setTextureSize(64, 128);
/*  77 */     modelrenderer.setRotationPoint(1.75F, -4.0F, 2.0F);
/*  78 */     modelrenderer.setTextureOffset(0, 76).addBox(0.0F, 0.0F, 0.0F, 7, 4, 7);
/*  79 */     modelrenderer.rotateAngleX = -0.05235988F;
/*  80 */     modelrenderer.rotateAngleZ = 0.02617994F;
/*  81 */     this.witchHat.addChild(modelrenderer);
/*  82 */     ModelRenderer modelrenderer1 = (new ModelRenderer((ModelBase)this)).setTextureSize(64, 128);
/*  83 */     modelrenderer1.setRotationPoint(1.75F, -4.0F, 2.0F);
/*  84 */     modelrenderer1.setTextureOffset(0, 87).addBox(0.0F, 0.0F, 0.0F, 4, 4, 4);
/*  85 */     modelrenderer1.rotateAngleX = -0.10471976F;
/*  86 */     modelrenderer1.rotateAngleZ = 0.05235988F;
/*  87 */     modelrenderer.addChild(modelrenderer1);
/*  88 */     ModelRenderer modelrenderer2 = (new ModelRenderer((ModelBase)this)).setTextureSize(64, 128);
/*  89 */     modelrenderer2.setRotationPoint(1.75F, -2.0F, 2.0F);
/*  90 */     modelrenderer2.setTextureOffset(0, 95).addBox(0.0F, 0.0F, 0.0F, 1, 2, 1, 0.25F);
/*  91 */     modelrenderer2.rotateAngleX = -0.20943952F;
/*  92 */     modelrenderer2.rotateAngleZ = 0.10471976F;
/*  93 */     modelrenderer1.addChild(modelrenderer2);
/*     */   }
/*     */ 
/*     */   
/*     */   public void render(Entity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float headYaw, float headPitch, float scale) {
/*  98 */     ResourceLocation TEXTURE = new ResourceLocation("HexenHut.png");
/*  99 */     Minecraft.getMinecraft().getTextureManager().bindTexture(TEXTURE);
/* 100 */     this.witchHat.render(scale);
/*     */   }
/*     */ }


/* Location:              C:\Users\Lenovo\Downloads\ZyrexClientV1 (1).jar!\ZyrexClient\cosmetic\impl\HatModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */