/*    */ package ZyrexClient.cosmetic;
/*    */ 
/*    */ import net.minecraft.util.ResourceLocation;
/*    */ 
/*    */ 
/*    */ public class AnimatedResourceLocation
/*    */ {
/*    */   private final String folder;
/*    */   private final int frames;
/*    */   private final int fpt;
/* 11 */   private int currentTick = 0;
/* 12 */   private int currentFrame = 0;
/*    */   
/*    */   private ResourceLocation[] textures;
/*    */   
/*    */   public AnimatedResourceLocation(String folder, int frames, int fpt) {
/* 17 */     this.folder = folder;
/* 18 */     this.frames = frames;
/* 19 */     this.fpt = fpt;
/* 20 */     this.textures = new ResourceLocation[frames];
/*    */     
/* 22 */     for (int i = 0; i < frames; i++) {
/* 23 */       this.textures[i] = new ResourceLocation(String.valueOf(folder) + "/" + i + ".png");
/*    */     }
/*    */   }
/*    */ 
/*    */   
/*    */   public ResourceLocation getTexture() {
/* 29 */     return this.textures[this.currentFrame];
/*    */   }
/*    */   
/*    */   public void update() {
/* 33 */     if (this.currentTick > this.fpt) {
/* 34 */       this.currentTick = 0;
/* 35 */       this.currentFrame++;
/* 36 */       if (this.currentFrame > this.textures.length - 1) {
/* 37 */         this.currentFrame = 0;
/*    */       }
/*    */     } 
/* 40 */     this.currentTick++;
/*    */   }
/*    */ }


/* Location:              C:\Users\Lenovo\Downloads\ZyrexClientV1 (1).jar!\ZyrexClient\cosmetic\AnimatedResourceLocation.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */