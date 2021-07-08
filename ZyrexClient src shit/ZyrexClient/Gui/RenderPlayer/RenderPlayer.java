/*    */ package ZyrexClient.Gui.RenderPlayer;
/*    */ 
/*    */ import net.minecraft.client.Minecraft;
/*    */ import net.minecraft.client.renderer.GlStateManager;
/*    */ import net.minecraft.client.renderer.OpenGlHelper;
/*    */ import net.minecraft.client.renderer.RenderHelper;
/*    */ import net.minecraft.client.renderer.entity.RenderManager;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.entity.EntityLivingBase;
/*    */ 
/*    */ public class RenderPlayer {
/*    */   public static void drawEntityOnScreen(int posX, int posY, int scale, float rotation, EntityLivingBase ent) {
/* 13 */     float rY = ent.rotationYaw % 360.0F;
/* 14 */     float rYH = ent.rotationYawHead % 360.0F;
/* 15 */     float rYO = ent.renderYawOffset;
/* 16 */     ent.rotationYawHead = rotation + rYH - rYO;
/* 17 */     ent.rotationYaw = rotation;
/* 18 */     ent.renderYawOffset = rotation;
/* 19 */     GlStateManager.enableColorMaterial();
/* 20 */     GlStateManager.pushMatrix();
/* 21 */     GlStateManager.translate(posX, posY, 50.0F);
/* 22 */     GlStateManager.scale(-scale, scale, scale);
/* 23 */     GlStateManager.rotate(180.0F, 0.0F, 0.0F, 1.0F);
/* 24 */     GlStateManager.rotate(135.0F, 0.0F, 1.0F, 0.0F);
/* 25 */     RenderHelper.enableStandardItemLighting();
/* 26 */     GlStateManager.rotate(-135.0F, 0.0F, 1.0F, 0.0F);
/* 27 */     GlStateManager.translate(0.0F, 0.0F, 0.0F);
/* 28 */     RenderManager rendermanager = Minecraft.getMinecraft().getRenderManager();
/* 29 */     rendermanager.setPlayerViewY(180.0F);
/* 30 */     rendermanager.setRenderShadow(false);
/* 31 */     rendermanager.renderEntityWithPosYaw((Entity)ent, 0.0D, 0.0D, 0.0D, 0.0F, 1.0F);
/* 32 */     rendermanager.setRenderShadow(true);
/* 33 */     GlStateManager.popMatrix();
/* 34 */     RenderHelper.disableStandardItemLighting();
/* 35 */     GlStateManager.disableRescaleNormal();
/* 36 */     GlStateManager.setActiveTexture(OpenGlHelper.lightmapTexUnit);
/* 37 */     GlStateManager.disableTexture2D();
/* 38 */     GlStateManager.setActiveTexture(OpenGlHelper.defaultTexUnit);
/* 39 */     ent.rotationYaw = rY;
/* 40 */     ent.rotationYawHead = rYH;
/* 41 */     ent.renderYawOffset = rYO;
/*    */   }
/*    */ }


/* Location:              C:\Users\Lenovo\Downloads\ZyrexClientV1 (1).jar!\ZyrexClient\Gui\RenderPlayer\RenderPlayer.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */