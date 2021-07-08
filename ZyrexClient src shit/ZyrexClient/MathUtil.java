/*    */ package ZyrexClient;
/*    */ 
/*    */ import net.minecraft.util.MathHelper;
/*    */ 
/*    */ public class MathUtil {
/*  6 */   private static final double[] a = new double[65536];
/*    */   
/*  8 */   private static final double[] b = new double[360];
/*    */   
/*    */   static {
/*    */     int i;
/* 12 */     for (i = 0; i < 65536; i++)
/* 13 */       a[i] = Math.sin(i * Math.PI * 2.0D / 65536.0D); 
/* 14 */     for (i = 0; i < 360; i++)
/* 15 */       b[i] = Math.sin(Math.toRadians(i)); 
/*    */   }
/*    */   
/*    */   public static double getAngle(int paramInt) {
/* 19 */     paramInt %= 360;
/* 20 */     return b[paramInt];
/*    */   }
/*    */   
/*    */   public static double getRightAngle(int paramInt) {
/* 24 */     paramInt += 90;
/* 25 */     paramInt %= 360;
/* 26 */     return b[paramInt];
/*    */   }
/*    */   
/*    */   private static float snapToStep(float value, float valueStep) {
/* 30 */     if (valueStep > 0.0F)
/* 31 */       value = valueStep * Math.round(value / valueStep); 
/* 32 */     return value;
/*    */   }
/*    */   
/*    */   public static float normalizeValue(float p_148266_1_, float valueMin, float valueMax, float valueStep) {
/* 36 */     return MathHelper.clamp_float((snapToStepClamp(p_148266_1_, valueMin, valueMax, valueStep) - valueMin) / (valueMax - valueMin), 0.0F, 1.0F);
/*    */   }
/*    */   
/*    */   private static float snapToStepClamp(float value, float valueMin, float valueMax, float valueStep) {
/* 40 */     value = snapToStep(value, valueStep);
/* 41 */     return MathHelper.clamp_float(value, valueMin, valueMax);
/*    */   }
/*    */   
/*    */   public static float denormalizeValue(float value, float valueMin, float valueMax, float valueStep) {
/* 45 */     return snapToStepClamp(valueMin + (valueMax - valueMin) * MathHelper.clamp_float(value, 0.0F, 1.0F), valueMin, valueMax, valueStep);
/*    */   }
/*    */ }


/* Location:              C:\Users\Lenovo\Downloads\ZyrexClientV1 (1).jar!\ZyrexClient\MathUtil.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */