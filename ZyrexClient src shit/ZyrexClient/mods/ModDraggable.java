/*    */ package ZyrexClient.mods;
/*    */ 
/*    */ import ZyrexClient.FileManager;
/*    */ import ZyrexClient.Gui.IRenderer;
/*    */ import ZyrexClient.Gui.ScreenPosition;
/*    */ import java.io.File;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public abstract class ModDraggable
/*    */   extends Mod
/*    */   implements IRenderer
/*    */ {
/* 15 */   protected ScreenPosition pos = loadPositionFromFile();
/*    */   
/*    */   private ScreenPosition loadPositionFromFile() {
/* 18 */     ScreenPosition loaded = (ScreenPosition)FileManager.readFromJson(new File(getFolder(), "pos.json"), ScreenPosition.class);
/*    */     
/* 20 */     if (loaded == null) {
/* 21 */       loaded = ScreenPosition.fromRelativePosition(0.5D, 0.5D);
/* 22 */       this.pos = loaded;
/* 23 */       savePositionToFile();
/*    */     } 
/*    */     
/* 26 */     return loaded;
/*    */   }
/*    */   
/*    */   public void savePositionToFile() {
/* 30 */     FileManager.writeJsonToFile(new File(getFolder(), "pos.json"), this.pos);
/*    */   }
/*    */   
/*    */   private File getFolder() {
/* 34 */     File file = new File(FileManager.getModsDirectory(), getClass().getSimpleName());
/* 35 */     file.mkdirs();
/* 36 */     return file;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public ScreenPosition load() {
/* 42 */     return this.pos;
/*    */   }
/*    */ 
/*    */   
/*    */   public void save(ScreenPosition pos) {
/* 47 */     this.pos = pos;
/* 48 */     savePositionToFile();
/*    */   }
/*    */ 
/*    */   
/*    */   public int getLineOffset(ScreenPosition pos, int lineNum) {
/* 53 */     return pos.getAbsoluteY() + getLineOffset(lineNum);
/*    */   }
/*    */   
/*    */   private int getLineOffset(int lineNum) {
/* 57 */     return (this.font.FONT_HEIGHT + 3) * lineNum;
/*    */   }
/*    */ }


/* Location:              C:\Users\Lenovo\Downloads\ZyrexClientV1 (1).jar!\ZyrexClient\mods\ModDraggable.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */