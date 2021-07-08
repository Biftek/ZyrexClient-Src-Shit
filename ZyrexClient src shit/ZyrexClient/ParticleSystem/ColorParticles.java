/*    */ package ZyrexClient.ParticleSystem;
/*    */ 
/*    */ import java.awt.Color;
/*    */ 
/*    */ public class ColorParticles {
/*    */   public static Color rainbow(float speed, float off) {
/*  7 */     double time = System.currentTimeMillis() / speed;
/*  8 */     time += off;
/*  9 */     time %= 255.0D;
/* 10 */     return Color.getHSBColor((float)(time / 255.0D), 1.0F, 1.0F);
/*    */   }
/*    */ }


/* Location:              C:\Users\Lenovo\Downloads\ZyrexClientV1 (1).jar!\ZyrexClient\ParticleSystem\ColorParticles.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */