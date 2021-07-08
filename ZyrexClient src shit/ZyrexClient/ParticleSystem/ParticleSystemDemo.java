/*    */ package ZyrexClient.ParticleSystem;
/*    */ import javax.swing.JCheckBox;
/*    */ import javax.swing.JLabel;
/*    */ import javax.swing.JPanel;
/*    */ import javax.swing.JSlider;
/*    */ import javax.swing.JSpinner;
/*    */ import org.newdawn.slick.AppGameContainer;
/*    */ import org.newdawn.slick.GameContainer;
/*    */ import org.newdawn.slick.SlickException;
/*    */ 
/*    */ public class ParticleSystemDemo extends BasicGame {
/*    */   private ParticleSystem particleSystem;
/*    */   private boolean mouse;
/*    */   
/*    */   public ParticleSystemDemo() {
/* 16 */     super("ParticleSystem");
/*    */   }
/*    */   private boolean rainbow; private int dist;
/*    */   public static void main(String[] args) {
/* 20 */     JPanel jPanel = new JPanel();
/* 21 */     jPanel.setLayout(new GridLayout(6, 2));
/* 22 */     JSpinner width = new JSpinner();
/* 23 */     width.setValue(Integer.valueOf(1280));
/* 24 */     JSpinner height = new JSpinner();
/* 25 */     height.setValue(Integer.valueOf(720));
/* 26 */     JCheckBox fullScreen = new JCheckBox("");
/* 27 */     JCheckBox connectMouse = new JCheckBox("");
/* 28 */     JCheckBox rainBow = new JCheckBox("");
/* 29 */     JLabel distLabel = new JLabel("connectingDistance (150):");
/* 30 */     JSlider dist = new JSlider(0, 100, 500, 150);
/* 31 */     dist.addChangeListener(e -> paramJLabel.setText("connectingDistance (".concat(String.valueOf(paramJSlider.getValue()).concat("):"))));
/*    */ 
/*    */ 
/*    */ 
/*    */     
/* 36 */     jPanel.add(new JLabel("Width:"));
/* 37 */     jPanel.add(width);
/* 38 */     jPanel.add(new JLabel("Height:"));
/* 39 */     jPanel.add(height);
/* 40 */     jPanel.add(new JLabel("Fullscreen:"));
/* 41 */     jPanel.add(fullScreen);
/* 42 */     jPanel.add(new JLabel("Rainbow:"));
/* 43 */     jPanel.add(rainBow);
/* 44 */     jPanel.add(new JLabel("ConnectMouse:"));
/* 45 */     jPanel.add(connectMouse);
/* 46 */     jPanel.add(distLabel);
/* 47 */     jPanel.add(dist);
/* 48 */     if (JOptionPane.showConfirmDialog(null, jPanel, "ParticleSystem settings", 2) != 0) {
/*    */       return;
/*    */     }
/*    */     try {
/* 52 */       ParticleSystemDemo demo = new ParticleSystemDemo();
/* 53 */       AppGameContainer container = new AppGameContainer((Game)demo);
/* 54 */       demo.mouse = connectMouse.isSelected();
/* 55 */       demo.dist = dist.getValue();
/* 56 */       demo.rainbow = rainBow.isSelected();
/* 57 */       container.setDisplayMode(((Integer)width.getValue()).intValue(), ((Integer)height.getValue()).intValue(), fullScreen.isSelected());
/* 58 */       container.setVSync(true);
/* 59 */       container.setShowFPS(true);
/* 60 */       container.start();
/* 61 */     } catch (SlickException e) {
/* 62 */       JOptionPane.showMessageDialog(null, e.getLocalizedMessage(), "ERROR", 0);
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public void init(GameContainer gameContainer) throws SlickException {
/* 68 */     this.particleSystem = new ParticleSystem(200, this.mouse, this.rainbow, this.dist);
/*    */   }
/*    */ 
/*    */   
/*    */   public void update(GameContainer gameContainer, int delta) throws SlickException {
/* 73 */     this.particleSystem.tick(delta);
/*    */   }
/*    */ 
/*    */   
/*    */   public void render(GameContainer gameContainer, Graphics graphics) throws SlickException {
/* 78 */     graphics.clearAlphaMap();
/* 79 */     graphics.clear();
/* 80 */     this.particleSystem.render();
/*    */   }
/*    */ }


/* Location:              C:\Users\Lenovo\Downloads\ZyrexClientV1 (1).jar!\ZyrexClient\ParticleSystem\ParticleSystemDemo.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */