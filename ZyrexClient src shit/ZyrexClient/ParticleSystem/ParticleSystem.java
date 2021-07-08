/*     */ package ZyrexClient.ParticleSystem;
/*     */ 
/*     */ import java.awt.Color;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import org.lwjgl.input.Mouse;
/*     */ import org.lwjgl.opengl.Display;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ 
/*     */ public class ParticleSystem
/*     */ {
/*     */   private static final float SPEED = 0.1F;
/*  13 */   private List<Particle> particleList = new ArrayList<>();
/*     */   
/*     */   private boolean mouse;
/*     */   private boolean rainbow;
/*     */   private int dist;
/*     */   
/*     */   public ParticleSystem(int initAmount, boolean mouse, boolean rainbow, int dist) {
/*  20 */     addParticles(initAmount);
/*  21 */     this.mouse = mouse;
/*  22 */     this.dist = dist;
/*  23 */     this.rainbow = rainbow;
/*     */   }
/*     */ 
/*     */   
/*     */   public void addParticles(int amount) {
/*  28 */     for (int i = 0; i < amount; i++) {
/*  29 */       this.particleList.add(Particle.generateParticle());
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public void tick(int delta) {
/*  35 */     if (Mouse.isButtonDown(0)) addParticles(1); 
/*  36 */     for (Particle particle : this.particleList) {
/*  37 */       particle.tick(delta, 0.1F);
/*     */     }
/*     */   }
/*     */   
/*     */   public void render() {
/*  42 */     for (Particle particle : this.particleList) {
/*  43 */       GL11.glColor4f(1.0F, 1.0F, 1.0F, particle.getAlpha() / 255.0F);
/*  44 */       GL11.glPointSize(particle.getSize());
/*  45 */       GL11.glBegin(0);
/*     */       
/*  47 */       GL11.glVertex2f(particle.getX(), particle.getY());
/*  48 */       GL11.glEnd();
/*     */       
/*  50 */       if (this.mouse) {
/*     */         
/*  52 */         Color c = null;
/*  53 */         if (this.rainbow)
/*     */         {
/*  55 */           c = ColorParticles.rainbow(50.0F, 0.0F);
/*     */         }
/*     */ 
/*     */         
/*  59 */         float distance = (float)MathUtil.distance(particle.getX(), particle.getY(), Mouse.getX(), (Display.getHeight() - Mouse.getY()));
/*  60 */         if (distance < this.dist) {
/*  61 */           float alpha = Math.min(1.0F, Math.min(1.0F, 1.0F - distance / this.dist));
/*  62 */           drawLine(particle.getX(), 
/*  63 */               particle.getY(), 
/*  64 */               Mouse.getX(), (
/*  65 */               Display.getHeight() - Mouse.getY()), 
/*  66 */               this.rainbow ? (c.getRed() / 255.0F) : 1.0F, 
/*  67 */               this.rainbow ? (c.getGreen() / 255.0F) : 1.0F, 
/*  68 */               this.rainbow ? (c.getBlue() / 255.0F) : 1.0F, 
/*  69 */               alpha);
/*     */         } 
/*     */         
/*     */         continue;
/*     */       } 
/*  74 */       float nearestDistance = 0.0F;
/*  75 */       Particle nearestParticle = null;
/*     */       
/*  77 */       for (Particle particle1 : this.particleList) {
/*  78 */         float distance = particle.getDistanceTo(particle1);
/*  79 */         if (distance <= this.dist && (
/*  80 */           MathUtil.distance(Mouse.getX(), (Display.getHeight() - Mouse.getY()), particle.getX(), particle.getY()) <= this.dist || 
/*  81 */           MathUtil.distance(Mouse.getX(), (Display.getHeight() - Mouse.getY()), particle1.getX(), particle1.getY()) <= this.dist) && (
/*  82 */           nearestDistance <= 0.0F || distance <= nearestDistance)) {
/*     */           
/*  84 */           nearestDistance = distance;
/*  85 */           nearestParticle = particle1;
/*     */         } 
/*     */       } 
/*     */ 
/*     */       
/*  90 */       if (nearestParticle != null) {
/*     */         
/*  92 */         Color c = null;
/*  93 */         if (this.rainbow)
/*     */         {
/*  95 */           c = ColorParticles.rainbow(50.0F, 0.0F);
/*     */         }
/*     */         
/*  98 */         float alpha = Math.min(1.0F, Math.min(1.0F, 1.0F - nearestDistance / this.dist));
/*  99 */         drawLine(particle.getX(), 
/* 100 */             particle.getY(), 
/* 101 */             nearestParticle.getX(), 
/* 102 */             nearestParticle.getY(), 
/* 103 */             this.rainbow ? (c.getRed() / 255.0F) : 1.0F, 
/* 104 */             this.rainbow ? (c.getGreen() / 255.0F) : 1.0F, 
/* 105 */             this.rainbow ? (c.getBlue() / 255.0F) : 1.0F, 
/* 106 */             alpha);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void drawLine(float x, float y, float x1, float y1, float r, float g, float b, float alpha) {
/* 115 */     GL11.glColor4f(r, g, b, alpha);
/* 116 */     GL11.glLineWidth(0.5F);
/* 117 */     GL11.glBegin(1);
/*     */     
/* 119 */     GL11.glVertex2f(x, y);
/* 120 */     GL11.glVertex2f(x1, y1);
/* 121 */     GL11.glEnd();
/*     */   }
/*     */ }


/* Location:              C:\Users\Lenovo\Downloads\ZyrexClientV1 (1).jar!\ZyrexClient\ParticleSystem\ParticleSystem.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */