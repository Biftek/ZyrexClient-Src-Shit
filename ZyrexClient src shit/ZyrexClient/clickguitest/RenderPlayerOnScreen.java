/*    */ package ZyrexClient.clickguitest;
/*    */ 
/*    */ import net.minecraft.client.Minecraft;
/*    */ import net.minecraft.client.renderer.GlStateManager;
/*    */ import net.minecraft.client.renderer.OpenGlHelper;
/*    */ import net.minecraft.client.renderer.RenderHelper;
/*    */ import net.minecraft.client.renderer.entity.RenderManager;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.entity.EntityLivingBase;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class RenderPlayerOnScreen
/*    */ {
/*    */   public static void drawEntityOnScreen(int posX, int posY, int scale, float rotation, EntityLivingBase ent) {
/* 18 */     float rY = ent.rotationYaw % 360.0F;
/* 19 */     float rYH = ent.rotationYawHead % 360.0F;
/* 20 */     float rYO = ent.renderYawOffset;
/* 21 */     ent.rotationYawHead = rotation + rYH - rYO;
/* 22 */     ent.rotationYaw = rotation;
/* 23 */     ent.renderYawOffset = rotation;
/* 24 */     GlStateManager.enableColorMaterial();
/* 25 */     GlStateManager.pushMatrix();
/* 26 */     GlStateManager.translate(posX, posY, 50.0F);
/* 27 */     GlStateManager.scale(-scale, scale, scale);
/* 28 */     GlStateManager.rotate(180.0F, 0.0F, 0.0F, 1.0F);
/* 29 */     GlStateManager.rotate(135.0F, 0.0F, 1.0F, 0.0F);
/* 30 */     RenderHelper.enableStandardItemLighting();
/* 31 */     GlStateManager.rotate(-135.0F, 0.0F, 1.0F, 0.0F);
/* 32 */     GlStateManager.translate(0.0F, 0.0F, 0.0F);
/* 33 */     RenderManager rendermanager = Minecraft.getMinecraft().getRenderManager();
/* 34 */     rendermanager.setPlayerViewY(180.0F);
/* 35 */     rendermanager.setRenderShadow(false);
/* 36 */     rendermanager.renderEntityWithPosYaw((Entity)ent, 0.0D, 0.0D, 0.0D, 0.0F, 1.0F);
/* 37 */     rendermanager.setRenderShadow(true);
/* 38 */     GlStateManager.popMatrix();
/* 39 */     RenderHelper.disableStandardItemLighting();
/* 40 */     GlStateManager.disableRescaleNormal();
/* 41 */     GlStateManager.setActiveTexture(OpenGlHelper.lightmapTexUnit);
/* 42 */     GlStateManager.disableTexture2D();
/* 43 */     GlStateManager.setActiveTexture(OpenGlHelper.defaultTexUnit);
/* 44 */     ent.rotationYaw = rY;
/* 45 */     ent.rotationYawHead = rYH;
/* 46 */     ent.renderYawOffset = rYO;
/*    */   }
/*    */ 
/*    */   
/*    */   public static void drawEntityOnScreenv(int posX, int posY, int scale, float mouseX, float mouseY, EntityLivingBase ent) {
/* 51 */     GlStateManager.enableColorMaterial();
/* 52 */     GlStateManager.pushMatrix();
/* 53 */     GlStateManager.translate(posX, posY, 50.0F);
/* 54 */     GlStateManager.scale(-scale, scale, scale);
/* 55 */     GlStateManager.rotate(180.0F, 0.0F, 0.0F, 1.0F);
/* 56 */     float f = ent.renderYawOffset;
/* 57 */     float f1 = ent.rotationYaw;
/* 58 */     float f2 = ent.rotationPitch;
/* 59 */     float f3 = ent.prevRotationYawHead;
/* 60 */     float f4 = ent.rotationYawHead;
/* 61 */     GlStateManager.rotate(135.0F, 0.0F, 1.0F, 0.0F);
/* 62 */     RenderHelper.enableStandardItemLighting();
/* 63 */     GlStateManager.rotate(-135.0F, 0.0F, 1.0F, 0.0F);
/* 64 */     GlStateManager.rotate(-((float)Math.atan((mouseY / 40.0F))) * 20.0F, 1.0F, 0.0F, 0.0F);
/* 65 */     ent.renderYawOffset = (float)Math.atan((mouseX / 40.0F)) * 20.0F;
/* 66 */     ent.rotationYaw = (float)Math.atan((mouseX / 40.0F)) * 40.0F;
/* 67 */     ent.rotationPitch = -((float)Math.atan((mouseY / 40.0F))) * 20.0F;
/* 68 */     ent.rotationYawHead = ent.rotationYaw;
/* 69 */     ent.prevRotationYawHead = ent.rotationYaw;
/* 70 */     GlStateManager.translate(0.0F, 0.0F, 0.0F);
/* 71 */     RenderManager rendermanager = Minecraft.getMinecraft().getRenderManager();
/* 72 */     rendermanager.setPlayerViewY(180.0F);
/* 73 */     rendermanager.setRenderShadow(false);
/* 74 */     rendermanager.renderEntityWithPosYaw((Entity)ent, 0.0D, 0.0D, 0.0D, 0.0F, 1.0F);
/* 75 */     rendermanager.setRenderShadow(true);
/* 76 */     ent.renderYawOffset = f;
/* 77 */     ent.rotationYaw = f1;
/* 78 */     ent.rotationPitch = f2;
/* 79 */     ent.prevRotationYawHead = f3;
/* 80 */     ent.rotationYawHead = f4;
/* 81 */     GlStateManager.popMatrix();
/* 82 */     RenderHelper.disableStandardItemLighting();
/* 83 */     GlStateManager.disableRescaleNormal();
/* 84 */     GlStateManager.setActiveTexture(OpenGlHelper.lightmapTexUnit);
/* 85 */     GlStateManager.disableTexture2D();
/* 86 */     GlStateManager.setActiveTexture(OpenGlHelper.defaultTexUnit);
/*    */   }
/*    */ }


/* Location:              C:\Users\Lenovo\Downloads\ZyrexClientV1 (1).jar!\ZyrexClient\clickguitest\RenderPlayerOnScreen.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */