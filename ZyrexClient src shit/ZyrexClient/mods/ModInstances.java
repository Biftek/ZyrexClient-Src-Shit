/*     */ package ZyrexClient.mods;
/*     */ 
/*     */ import ZyrexClient.Gui.HUDManager;
/*     */ import ZyrexClient.Gui.IRenderer;
/*     */ import ZyrexClient.mods.impl.ZyexModPackDisplay;
/*     */ import ZyrexClient.mods.impl.ZyrexModArmorStatus;
/*     */ import ZyrexClient.mods.impl.ZyrexModBossbar;
/*     */ import ZyrexClient.mods.impl.ZyrexModCPS;
/*     */ import ZyrexClient.mods.impl.ZyrexModCoordinates;
/*     */ import ZyrexClient.mods.impl.ZyrexModDirection;
/*     */ import ZyrexClient.mods.impl.ZyrexModFPS;
/*     */ import ZyrexClient.mods.impl.ZyrexModHelloWorld;
/*     */ import ZyrexClient.mods.impl.ZyrexModKeystrokes;
/*     */ import ZyrexClient.mods.impl.ZyrexModMotionBlur;
/*     */ import ZyrexClient.mods.impl.ZyrexModPerspective;
/*     */ import ZyrexClient.mods.impl.ZyrexModPing;
/*     */ import ZyrexClient.mods.impl.ZyrexModPotStatus;
/*     */ import ZyrexClient.mods.impl.ZyrexModScoreboard;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ModInstances
/*     */ {
/*     */   private static ZyrexModHelloWorld modHelloWorld;
/*     */   private static ZyrexModArmorStatus modArmorStatus;
/*     */   public static ZyrexModFPS modFPS;
/*     */   public static ZyrexModCPS modCPS;
/*     */   private static ZyrexModKeystrokes modKeystrokes;
/*     */   private static ZyrexModDirection modDirection;
/*     */   private static ZyrexModPotStatus modPotionsStatus;
/*     */   private static ZyrexModPing modPing;
/*     */   private static ZyrexModScoreboard modScoreboard;
/*     */   private static ZyrexModBossbar modBossbar;
/*     */   private static Mod mod;
/*     */   private static ZyrexModCoordinates modCord;
/*     */   private static ZyrexModMotionBlur modMB;
/*     */   private static ZyrexModPerspective modPE;
/*     */   private static ZyexModPackDisplay modPD;
/*     */   
/*     */   public static void register(HUDManager api) {
/*  54 */     modArmorStatus = new ZyrexModArmorStatus();
/*  55 */     api.register(new IRenderer[] { (IRenderer)modArmorStatus });
/*     */     
/*  57 */     modFPS = new ZyrexModFPS();
/*  58 */     api.register(new IRenderer[] { (IRenderer)modFPS });
/*     */     
/*  60 */     modKeystrokes = new ZyrexModKeystrokes();
/*  61 */     api.register(new IRenderer[] { (IRenderer)modKeystrokes });
/*     */     
/*  63 */     modDirection = new ZyrexModDirection();
/*  64 */     api.register(new IRenderer[] { (IRenderer)modDirection });
/*     */     
/*  66 */     modPotionsStatus = new ZyrexModPotStatus();
/*  67 */     api.register(new IRenderer[] { (IRenderer)modPotionsStatus });
/*     */     
/*  69 */     modPing = new ZyrexModPing();
/*  70 */     api.register(new IRenderer[] { (IRenderer)modPing });
/*     */     
/*  72 */     modBossbar = new ZyrexModBossbar();
/*  73 */     api.register(new IRenderer[] { (IRenderer)modBossbar });
/*     */     
/*  75 */     modCord = new ZyrexModCoordinates();
/*  76 */     api.register(new IRenderer[] { (IRenderer)modCord });
/*     */     
/*  78 */     modCPS = new ZyrexModCPS();
/*  79 */     api.register(new IRenderer[] { (IRenderer)modCPS });
/*     */     
/*  81 */     modScoreboard = new ZyrexModScoreboard();
/*  82 */     api.register(new IRenderer[] { (IRenderer)modScoreboard });
/*     */     
/*  84 */     modMB = new ZyrexModMotionBlur();
/*  85 */     api.register(new IRenderer[] { (IRenderer)modMB });
/*     */     
/*  87 */     modPE = new ZyrexModPerspective();
/*  88 */     api.register(new IRenderer[] { (IRenderer)modPE });
/*     */     
/*  90 */     modPD = new ZyexModPackDisplay();
/*  91 */     api.register(new IRenderer[] { (IRenderer)modPD });
/*     */   }
/*     */ 
/*     */   
/*     */   public static ZyrexModHelloWorld getModhelloWorld() {
/*  96 */     return modHelloWorld;
/*     */   }
/*     */   
/*     */   public static ZyrexModPerspective getModPerspective() {
/* 100 */     return modPE;
/*     */   }
/*     */   
/*     */   public static ZyrexModScoreboard getModScoreboard() {
/* 104 */     return modScoreboard;
/*     */   }
/*     */ }


/* Location:              C:\Users\Lenovo\Downloads\ZyrexClientV1 (1).jar!\ZyrexClient\mods\ModInstances.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */