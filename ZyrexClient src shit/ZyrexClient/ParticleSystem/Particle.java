/*    */ package ZyrexClient.ParticleSystem;
/*    */ 
/*    */ import java.util.Random;
/*    */ import org.lwjgl.opengl.Display;
/*    */ import org.lwjgl.util.vector.Vector2f;
/*    */ 
/*    */ public class Particle
/*    */ {
/*  9 */   private static final Random random = new Random();
/*    */   
/*    */   private Vector2f velocity;
/*    */   
/*    */   private Vector2f pos;
/*    */   private float size;
/*    */   private float alpha;
/*    */   
/*    */   public Particle(Vector2f velocity, float x, float y, float size) {
/* 18 */     this.velocity = velocity;
/* 19 */     this.pos = new Vector2f(x, y);
/* 20 */     this.size = size;
/*    */   }
/*    */   
/*    */   public static Particle generateParticle() {
/* 24 */     Vector2f velocity = new Vector2f((float)(Math.random() * 2.0D - 1.0D), (float)(Math.random() * 2.0D - 1.0D));
/* 25 */     float x = random.nextInt(Display.getWidth());
/* 26 */     float y = random.nextInt(Display.getHeight());
/* 27 */     float size = (float)(Math.random() * 4.0D) + 1.0F;
/* 28 */     return new Particle(velocity, x, y, size);
/*    */   }
/*    */ 
/*    */   
/*    */   public float getAlpha() {
/* 33 */     return this.alpha;
/*    */   }
/*    */ 
/*    */   
/*    */   public Vector2f getVelocity() {
/* 38 */     return this.velocity;
/*    */   }
/*    */   
/*    */   public void setVelocity(Vector2f velocity) {
/* 42 */     this.velocity = velocity;
/*    */   }
/*    */   
/*    */   public float getX() {
/* 46 */     return this.pos.getX();
/*    */   }
/*    */   
/*    */   public void setX(float x) {
/* 50 */     this.pos.setX(x);
/*    */   }
/*    */   
/*    */   public float getY() {
/* 54 */     return this.pos.getY();
/*    */   }
/*    */   
/*    */   public void setY(float y) {
/* 58 */     this.pos.setY(y);
/*    */   }
/*    */   
/*    */   public float getSize() {
/* 62 */     return this.size;
/*    */   }
/*    */   
/*    */   public void setSize(float size) {
/* 66 */     this.size = size;
/*    */   }
/*    */   
/*    */   public void tick(int delta, float speed) {
/* 70 */     this.pos.x += this.velocity.getX() * delta * speed;
/* 71 */     this.pos.y += this.velocity.getY() * delta * speed;
/* 72 */     if (this.alpha < 255.0F) this.alpha += 0.05F * delta;
/*    */     
/* 74 */     if (this.pos.getX() > Display.getWidth()) this.pos.setX(0.0F); 
/* 75 */     if (this.pos.getX() < 0.0F) this.pos.setX(Display.getWidth());
/*    */     
/* 77 */     if (this.pos.getY() > Display.getHeight()) this.pos.setY(0.0F); 
/* 78 */     if (this.pos.getY() < 0.0F) this.pos.setY(Display.getHeight()); 
/*    */   }
/*    */   
/*    */   public float getDistanceTo(Particle particle1) {
/* 82 */     return getDistanceTo(particle1.getX(), particle1.getY());
/*    */   }
/*    */   
/*    */   public float getDistanceTo(float x, float y) {
/* 86 */     return (float)MathUtil.distance(getX(), getY(), x, y);
/*    */   }
/*    */ }


/* Location:              C:\Users\Lenovo\Downloads\ZyrexClientV1 (1).jar!\ZyrexClient\ParticleSystem\Particle.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */