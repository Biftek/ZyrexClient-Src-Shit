/*    */ package ZyrexClient.Gui;
/*    */ 
/*    */ import ZyrexClient.EventManager;
/*    */ import ZyrexClient.EventTarget;
/*    */ import ZyrexClient.impl.RenderEvent;
/*    */ import com.google.common.collect.Sets;
/*    */ import java.util.Collection;
/*    */ import java.util.Set;
/*    */ import net.minecraft.client.Minecraft;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class HUDManager
/*    */ {
/* 22 */   private static HUDManager instance = null;
/*    */ 
/*    */   
/*    */   public static HUDManager getInstance() {
/* 26 */     if (instance != null) {
/* 27 */       return instance;
/*    */     }
/*    */     
/* 30 */     instance = new HUDManager();
/* 31 */     EventManager.register(instance);
/*    */     
/* 33 */     return instance;
/*    */   }
/*    */ 
/*    */   
/* 37 */   private Set<IRenderer> registeredRenderers = Sets.newHashSet();
/* 38 */   private Minecraft mc = Minecraft.getMinecraft(); public void register(IRenderer... renderers) { byte b;
/*    */     int i;
/*    */     IRenderer[] arrayOfIRenderer;
/* 41 */     for (i = (arrayOfIRenderer = renderers).length, b = 0; b < i; ) { IRenderer render = arrayOfIRenderer[b];
/* 42 */       this.registeredRenderers.add(render);
/*    */       b++; }
/*    */      } public void unregister(IRenderer... renderers) { byte b;
/*    */     int i;
/*    */     IRenderer[] arrayOfIRenderer;
/* 47 */     for (i = (arrayOfIRenderer = renderers).length, b = 0; b < i; ) { IRenderer render = arrayOfIRenderer[b];
/* 48 */       this.registeredRenderers.remove(render);
/*    */       b++; }
/*    */      }
/*    */   
/*    */   public Collection<IRenderer> getRegisteredRenderers() {
/* 53 */     return Sets.newHashSet(this.registeredRenderers);
/*    */   }
/*    */   
/*    */   public void openConfigScreen() {
/* 57 */     this.mc.displayGuiScreen(new HUDConfigScreen(this));
/*    */   }
/*    */   
/*    */   @EventTarget
/*    */   public void onRender(RenderEvent e) {
/* 62 */     if (this.mc.currentScreen == null) {
/* 63 */       for (IRenderer renderer : this.registeredRenderers) {
/* 64 */         callRenderer(renderer);
/*    */       }
/*    */     }
/*    */   }
/*    */   
/*    */   private void callRenderer(IRenderer renderer) {
/* 70 */     if (!renderer.isEnabled()) {
/*    */       return;
/*    */     }
/*    */     
/* 74 */     ScreenPosition pos = renderer.load();
/*    */     
/* 76 */     if (pos == null) {
/* 77 */       pos = ScreenPosition.fromRelativePosition(0.5D, 0.5D);
/*    */     }
/*    */     
/* 80 */     renderer.render(pos);
/*    */   }
/*    */ }


/* Location:              C:\Users\Lenovo\Downloads\ZyrexClientV1 (1).jar!\ZyrexClient\Gui\HUDManager.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */