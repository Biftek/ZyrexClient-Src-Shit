/*    */ package ZyrexClient.Url;
/*    */ 
/*    */ import java.awt.image.BufferedImage;
/*    */ import net.minecraft.client.Minecraft;
/*    */ import net.minecraft.client.renderer.IImageBuffer;
/*    */ import net.minecraft.client.renderer.ImageBufferDownload;
/*    */ import net.minecraft.client.renderer.ThreadDownloadImageData;
/*    */ import net.minecraft.client.renderer.texture.ITextureObject;
/*    */ import net.minecraft.client.renderer.texture.TextureManager;
/*    */ import net.minecraft.util.ResourceLocation;
/*    */ import org.apache.commons.io.FilenameUtils;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class UrlTextureUtil
/*    */ {
/*    */   public static void downloadAndSetTexture(String url, final ResourceLocationCallback callback) {
/* 20 */     if (url != null && !url.isEmpty()) {
/*    */       
/* 22 */       String baseName = FilenameUtils.getBaseName(url);
/* 23 */       final ResourceLocation resourcelocation = new ResourceLocation("clientname_temp/" + baseName);
/* 24 */       TextureManager texturemanager = Minecraft.getMinecraft().getTextureManager();
/* 25 */       ITextureObject itextureobject = texturemanager.getTexture(resourcelocation);
/*    */       
/* 27 */       if (itextureobject != null && itextureobject instanceof ThreadDownloadImageData) {
/*    */         
/* 29 */         ThreadDownloadImageData threaddownloadimagedata = (ThreadDownloadImageData)itextureobject;
/*    */         
/* 31 */         if (threaddownloadimagedata.imageFound != null) {
/*    */           
/* 33 */           if (threaddownloadimagedata.imageFound.booleanValue())
/*    */           {
/* 35 */             callback.onTextureLoaded(resourcelocation);
/*    */           }
/*    */           
/*    */           return;
/*    */         } 
/*    */       } 
/*    */       
/* 42 */       IImageBuffer iimagebuffer = new IImageBuffer()
/*    */         {
/* 44 */           ImageBufferDownload ibd = new ImageBufferDownload();
/*    */           
/*    */           public BufferedImage parseUserSkin(BufferedImage image) {
/* 47 */             return image;
/*    */           }
/*    */           
/*    */           public void skinAvailable() {
/* 51 */             callback.onTextureLoaded(resourcelocation);
/*    */           }
/*    */         };
/* 54 */       ThreadDownloadImageData threaddownloadimagedata1 = new ThreadDownloadImageData(null, url, null, iimagebuffer);
/* 55 */       threaddownloadimagedata1.pipeline = true;
/* 56 */       texturemanager.loadTexture(resourcelocation, (ITextureObject)threaddownloadimagedata1);
/*    */     } 
/*    */   }
/*    */   
/*    */   public static interface ResourceLocationCallback {
/*    */     void onTextureLoaded(ResourceLocation param1ResourceLocation);
/*    */   }
/*    */ }


/* Location:              C:\Users\Lenovo\Downloads\ZyrexClientV1 (1).jar!\ZyrexClient\Url\UrlTextureUtil.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */