/*    */ package ZyrexClient.Url;
/*    */ 
/*    */ import ZyrexClient.Gui.ScreenPosition;
/*    */ import ZyrexClient.mods.ModDraggable;
/*    */ import net.minecraft.client.gui.Gui;
/*    */ import net.minecraft.util.ResourceLocation;
/*    */ import org.lwjgl.opengl.GL11;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ModUrlImageTest
/*    */   extends ModDraggable
/*    */ {
/* 16 */   private ResourceLocation img = null;
/*    */   
/*    */   private boolean hasTriedToDownload = false;
/*    */   
/*    */   public int getHeight() {
/* 21 */     return 100;
/*    */   }
/*    */ 
/*    */   
/*    */   public int getWidth() {
/* 26 */     return 100;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void render(ScreenPosition pos) {
/* 32 */     if (this.img == null && !this.hasTriedToDownload) {
/* 33 */       this.hasTriedToDownload = true;
/* 34 */       UrlTextureUtil.downloadAndSetTexture("https://flif.info/example-images/fish.png", new UrlTextureUtil.ResourceLocationCallback()
/*    */           {
/*    */             public void onTextureLoaded(ResourceLocation rl)
/*    */             {
/* 38 */               ModUrlImageTest.this.img = rl;
/*    */             }
/*    */           });
/*    */     } 
/*    */     
/* 43 */     if (this.img != null) {
/* 44 */       GL11.glPushMatrix();
/* 45 */       this.mc.getTextureManager().bindTexture(this.img);
/* 46 */       Gui.drawModalRectWithCustomSizedTexture(pos.getAbsoluteX(), pos.getAbsoluteY(), 1.0F, 1.0F, 100, 100, 100.0F, 100.0F);
/* 47 */       GL11.glPopMatrix();
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\Lenovo\Downloads\ZyrexClientV1 (1).jar!\ZyrexClient\Url\ModUrlImageTest.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */