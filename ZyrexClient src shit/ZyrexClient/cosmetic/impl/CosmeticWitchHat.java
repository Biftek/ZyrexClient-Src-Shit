/*    */ package ZyrexClient.cosmetic.impl;
/*    */ 
/*    */ import ZyrexClient.Client;
/*    */ import ZyrexClient.cosmetic.CosmeticBase;
/*    */ import java.io.IOException;
/*    */ import net.minecraft.client.Minecraft;
/*    */ import net.minecraft.client.entity.AbstractClientPlayer;
/*    */ import net.minecraft.client.renderer.GlStateManager;
/*    */ import net.minecraft.client.renderer.entity.RenderPlayer;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.util.ResourceLocation;
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
/*    */ public class CosmeticWitchHat
/*    */   extends CosmeticBase
/*    */ {
/*    */   private final HatModel hatModel;
/* 27 */   private static final ResourceLocation TEXTURE = new ResourceLocation("HexenHut.png");
/*    */   public CosmeticWitchHat(RenderPlayer renderPlayer) {
/* 29 */     super(renderPlayer);
/* 30 */     this.hatModel = new HatModel(renderPlayer);
/*    */   }
/*    */ 
/*    */   
/*    */   public void render(AbstractClientPlayer player, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
/* 35 */     GL11.glPushMatrix();
/*    */     
/* 37 */     if (player.isSneaking()) {
/* 38 */       GlStateManager.translate(0.0D, 0.262D, 0.0D);
/*    */     }
/* 40 */     GlStateManager.rotate(netHeadYaw, 0.0F, 1.0F, 0.0F);
/* 41 */     GlStateManager.rotate(headPitch, 1.0F, 0.0F, 0.0F);
/* 42 */     GlStateManager.translate(-0.3125D, -0.55D, -0.3125D);
/* 43 */     this.renderPlayer.bindTexture(TEXTURE);
/* 44 */     Minecraft.getMinecraft(); if (Client.CosmeticWitchHat && player == Minecraft.thePlayer) {
/* 45 */       this.hatModel.render((Entity)player, limbSwing, limbSwingAmount, ageInTicks, headPitch, headPitch, scale);
/* 46 */       GL11.glColor3d(1.0D, 1.0D, 1.0D);
/*    */     } 
/* 48 */     String uuid = player.getUniqueID().toString();
/*    */     try {
/* 50 */       if (uuid.contains("dwaodbwabdwo8ad")) {
/*    */         
/* 52 */         GL11.glColor3d(DatabaseUtil.getDouble(uuid, "hat-r"), DatabaseUtil.getDouble(uuid, "hat-g"), DatabaseUtil.getDouble(uuid, "hat-b"));
/* 53 */         this.hatModel.render((Entity)player, limbSwing, limbSwingAmount, ageInTicks, headPitch, headPitch, scale);
/* 54 */         GL11.glColor3d(1.0D, 1.0D, 1.0D);
/*    */       } 
/* 56 */     } catch (IOException e) {
/* 57 */       e.printStackTrace();
/*    */     } 
/*    */ 
/*    */     
/* 61 */     GL11.glColor3f(1.0F, 1.0F, 1.0F);
/* 62 */     GL11.glPopMatrix();
/*    */   }
/*    */ }


/* Location:              C:\Users\Lenovo\Downloads\ZyrexClientV1 (1).jar!\ZyrexClient\cosmetic\impl\CosmeticWitchHat.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */