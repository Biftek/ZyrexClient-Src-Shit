/*    */ package ZyrexClient.Gui.Login2;
/*    */ 
/*    */ import java.io.IOException;
/*    */ import net.minecraft.client.gui.GuiButton;
/*    */ import net.minecraft.client.gui.GuiScreen;
/*    */ import net.minecraft.client.gui.GuiTextField;
/*    */ import net.minecraft.util.EnumChatFormatting;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class GuiRenameAlt
/*    */   extends GuiScreen
/*    */ {
/*    */   private final GuiAltManager manager;
/*    */   private GuiTextField nameField;
/*    */   private PasswordField pwField;
/* 18 */   private String status = EnumChatFormatting.GRAY + "Waiting...";
/*    */   
/*    */   public GuiRenameAlt(GuiAltManager manager) {
/* 21 */     this.manager = manager;
/*    */   }
/*    */ 
/*    */   
/*    */   public void actionPerformed(GuiButton button) {
/* 26 */     switch (button.id) {
/*    */       case 1:
/* 28 */         mc.displayGuiScreen(this.manager);
/*    */         break;
/*    */       
/*    */       case 0:
/* 32 */         this.manager.selectedAlt.setMask(this.nameField.getText());
/* 33 */         this.manager.selectedAlt.setPassword(this.pwField.getText());
/* 34 */         this.status = "Edited!";
/*    */         break;
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public void drawScreen(int par1, int par2, float par3) {
/* 41 */     drawDefaultBackground();
/* 42 */     drawCenteredString(fontRendererObj, "Edit Alt", width / 2, 10, -1);
/* 43 */     drawCenteredString(fontRendererObj, this.status, width / 2, 20, -1);
/* 44 */     this.nameField.drawTextBox();
/* 45 */     this.pwField.drawTextBox();
/* 46 */     if (this.nameField.getText().isEmpty()) {
/* 47 */       drawString(mc.fontRendererObj, "New name", width / 2 - 96, 66, -7829368);
/*    */     }
/* 49 */     if (this.pwField.getText().isEmpty()) {
/* 50 */       drawString(mc.fontRendererObj, "New password", width / 2 - 96, 106, -7829368);
/*    */     }
/* 52 */     super.drawScreen(par1, par2, par3);
/*    */   }
/*    */ 
/*    */   
/*    */   public void initGui() {
/* 57 */     buttonList.add(new GuiButton(0, width / 2 - 100, height / 4 + 92 + 12, "Edit"));
/* 58 */     buttonList.add(new GuiButton(1, width / 2 - 100, height / 4 + 116 + 12, "Cancel"));
/* 59 */     this.nameField = new GuiTextField(this.eventButton, mc.fontRendererObj, width / 2 - 100, 60, 200, 20);
/* 60 */     this.pwField = new PasswordField(mc.fontRendererObj, width / 2 - 100, 100, 200, 20);
/*    */   }
/*    */ 
/*    */   
/*    */   protected void keyTyped(char par1, int par2) {
/* 65 */     this.nameField.textboxKeyTyped(par1, par2);
/* 66 */     this.pwField.textboxKeyTyped(par1, par2);
/* 67 */     if (par1 == '\t' && (this.nameField.isFocused() || this.pwField.isFocused())) {
/* 68 */       this.nameField.setFocused(!this.nameField.isFocused());
/* 69 */       this.pwField.setFocused(!this.pwField.isFocused());
/*    */     } 
/* 71 */     if (par1 == '\r') {
/* 72 */       actionPerformed(buttonList.get(0));
/*    */     }
/*    */   }
/*    */ 
/*    */   
/*    */   protected void mouseClicked(int par1, int par2, int par3) {
/*    */     try {
/* 79 */       super.mouseClicked(par1, par2, par3);
/*    */     }
/* 81 */     catch (IOException e) {
/* 82 */       e.printStackTrace();
/*    */     } 
/* 84 */     this.nameField.mouseClicked(par1, par2, par3);
/* 85 */     this.pwField.mouseClicked(par1, par2, par3);
/*    */   }
/*    */ }


/* Location:              C:\Users\Lenovo\Downloads\ZyrexClientV1 (1).jar!\ZyrexClient\Gui\Login2\GuiRenameAlt.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */