/*     */ package ZyrexClient.cosmetic.impl.wings;
/*     */ 
/*     */ import ZyrexClient.Client;
/*     */ import ZyrexClient.cosmetic.CosmeticBase;
/*     */ import ZyrexClient.cosmetic.CosmeticModelBase;
/*     */ import ZyrexClient.cosmetic.impl.DatabaseUtil;
/*     */ import java.awt.Color;
/*     */ import java.io.IOException;
/*     */ import net.minecraft.client.Minecraft;
/*     */ import net.minecraft.client.entity.AbstractClientPlayer;
/*     */ import net.minecraft.client.model.ModelBase;
/*     */ import net.minecraft.client.model.ModelRenderer;
/*     */ import net.minecraft.client.renderer.GlStateManager;
/*     */ import net.minecraft.client.renderer.entity.RenderPlayer;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.util.ResourceLocation;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class CosmeticWingsBlack
/*     */   extends CosmeticBase
/*     */ {
/*     */   private final CosmeticVilligerNose2 wingsModel;
/*     */   
/*     */   public CosmeticWingsBlack(RenderPlayer renderPlayer) {
/*  31 */     super(renderPlayer);
/*  32 */     this.wingsModel = new CosmeticVilligerNose2(renderPlayer);
/*     */   }
/*     */ 
/*     */   
/*     */   public void render(AbstractClientPlayer player, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
/*  37 */     GL11.glPushMatrix();
/*  38 */     if (player.isSneaking()) {
/*  39 */       GlStateManager.rotate(20.0F, 1.0F, 0.0F, 0.0F);
/*  40 */       GlStateManager.translate(0.0D, 0.2D, -0.05D);
/*     */     } 
/*     */     
/*  43 */     Minecraft.getMinecraft(); if (Client.CosmeticWingsBlack && player == Minecraft.thePlayer) {
/*  44 */       (Minecraft.getMinecraft()).fontRendererObj.drawString("", 0.0F, 0.0F, Color.BLACK.getRGB(), true);
/*     */       
/*  46 */       this.wingsModel.render((Entity)player, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);
/*     */     } 
/*  48 */     String uuid = player.getUniqueID().toString();
/*     */     try {
/*  50 */       if (uuid.contains("dwhnioad8zvwavdbwa8zdw")) {
/*  51 */         GL11.glColor3d(DatabaseUtil.getDouble(uuid, "wings-r"), DatabaseUtil.getDouble(uuid, "wings-g"), DatabaseUtil.getDouble(uuid, "wings-b"));
/*  52 */         this.wingsModel.render((Entity)player, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);
/*  53 */         GL11.glColor3d(1.0D, 1.0D, 1.0D);
/*     */       } 
/*  55 */     } catch (IOException e) {
/*  56 */       e.printStackTrace();
/*     */     } 
/*  58 */     GL11.glPopMatrix();
/*     */   }
/*     */   
/*     */   public class CosmeticVilligerNose2
/*     */     extends CosmeticModelBase
/*     */   {
/*     */     private ModelRenderer wing;
/*     */     private ModelRenderer wingTip;
/*     */     
/*     */     public CosmeticVilligerNose2(RenderPlayer player) {
/*  68 */       super(player);
/*     */       
/*  70 */       setTextureOffset("wing.bone", 0, 0);
/*  71 */       setTextureOffset("wing.skin", -10, 8);
/*  72 */       setTextureOffset("wingtip.bone", 0, 5);
/*  73 */       setTextureOffset("wingtip.skin", -10, 18);
/*  74 */       this.wing = new ModelRenderer((ModelBase)this, "wing");
/*  75 */       this.wing.setTextureSize(30, 30);
/*  76 */       this.wing.setRotationPoint(-2.0F, 0.0F, 0.0F);
/*  77 */       this.wing.addBox("bone", -10.0F, -1.0F, -1.0F, 10, 2, 2);
/*  78 */       this.wing.addBox("skin", -10.0F, 0.0F, 0.5F, 10, 0, 10);
/*  79 */       this.wingTip = new ModelRenderer((ModelBase)this, "wingtip");
/*  80 */       this.wingTip.setTextureSize(30, 30);
/*  81 */       this.wingTip.setRotationPoint(-10.0F, 0.0F, 0.0F);
/*  82 */       this.wingTip.addBox("bone", -10.0F, -0.5F, -0.5F, 10, 1, 1);
/*  83 */       this.wingTip.addBox("skin", -10.0F, 0.0F, 0.5F, 10, 0, 10);
/*  84 */       this.wing.addChild(this.wingTip);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public void render(Entity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float headYaw, float headPitch, float scale) {
/*  90 */       GlStateManager.pushMatrix();
/*  91 */       GlStateManager.disableLighting();
/*  92 */       GlStateManager.scale(0.7D, 0.7D, 0.7D);
/*  93 */       GlStateManager.rotate(20.0F, 1.0F, 0.0F, 0.0F);
/*  94 */       GlStateManager.translate(0.0D, 0.0D, 0.09D);
/*  95 */       GlStateManager.translate(0.0D, 0.2D, 0.0D);
/*  96 */       Minecraft.getMinecraft().getTextureManager().bindTexture(new ResourceLocation("wings.png"));
/*  97 */       for (int j = 0; j < 2; j++) {
/*  98 */         float f11 = (float)(System.currentTimeMillis() % 1000L) / 1000.0F * 3.1415927F * 2.0F;
/*  99 */         this.wing.rotateAngleX = (float)Math.toRadians(-80.0D) - (float)Math.cos(f11) * 0.4F;
/* 100 */         this.wing.rotateAngleY = (float)Math.toRadians(30.0D) + (float)Math.sin(f11) * 0.2F;
/* 101 */         this.wing.rotateAngleZ = (float)Math.toRadians(20.0D);
/* 102 */         this.wingTip.rotateAngleZ = -((float)(Math.sin((f11 + 2.0F)) + 0.9D)) * 0.75F;
/*     */         
/* 104 */         this.wing.render(0.0625F);
/* 105 */         GlStateManager.scale(-1.0F, 1.0F, 1.0F);
/* 106 */         if (j == 0);
/*     */       } 
/* 108 */       GlStateManager.enableLighting();
/* 109 */       GlStateManager.popMatrix();
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Lenovo\Downloads\ZyrexClientV1 (1).jar!\ZyrexClient\cosmetic\impl\wings\CosmeticWingsBlack.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */