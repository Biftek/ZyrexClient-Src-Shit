/*     */ package ZyrexClient.mods.impl;
/*     */ 
/*     */ import ZyrexClient.Gui.ScreenPosition;
/*     */ import ZyrexClient.mods.ModDraggable;
/*     */ import com.google.common.base.Predicate;
/*     */ import com.google.common.collect.Iterables;
/*     */ import com.google.common.collect.Lists;
/*     */ import java.util.Collection;
/*     */ import java.util.List;
/*     */ import net.minecraft.client.Minecraft;
/*     */ import net.minecraft.client.gui.FontRenderer;
/*     */ import net.minecraft.client.gui.Gui;
/*     */ import net.minecraft.client.gui.ScaledResolution;
/*     */ import net.minecraft.client.renderer.GlStateManager;
/*     */ import net.minecraft.scoreboard.Score;
/*     */ import net.minecraft.scoreboard.ScoreObjective;
/*     */ import net.minecraft.scoreboard.ScorePlayerTeam;
/*     */ import net.minecraft.scoreboard.Scoreboard;
/*     */ import net.minecraft.scoreboard.Team;
/*     */ import net.minecraft.util.EnumChatFormatting;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ZyrexModScoreboard
/*     */   extends ModDraggable
/*     */ {
/*     */   private int listHeight;
/*     */   private int listWidth;
/*     */   
/*     */   public int getWidth() {
/*  32 */     return this.listWidth;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getHeight() {
/*  37 */     return this.listHeight;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void render(ScreenPosition pos) {
/*  46 */     if (this.mc.theWorld.getScoreboard() != null) {
/*     */       
/*  48 */       Scoreboard scoreboard = this.mc.theWorld.getScoreboard();
/*  49 */       ScoreObjective scoreobjective = null;
/*  50 */       ScorePlayerTeam scoreplayerteam = scoreboard.getPlayersTeam(Minecraft.thePlayer.getCommandSenderName());
/*     */       
/*  52 */       ScoreObjective scoreobjective1 = (scoreobjective != null) ? scoreobjective : scoreboard.getObjectiveInDisplaySlot(1);
/*  53 */       ScaledResolution scaledresolution = new ScaledResolution(this.mc);
/*  54 */       int i = scaledresolution.getScaledWidth();
/*  55 */       int j = scaledresolution.getScaledHeight();
/*     */       
/*  57 */       if (scoreplayerteam != null) {
/*     */         
/*  59 */         int i1 = scoreplayerteam.getChatFormat().getColorIndex();
/*     */         
/*  61 */         if (i1 >= 0)
/*     */         {
/*  63 */           scoreobjective = scoreboard.getObjectiveInDisplaySlot(3 + i1);
/*     */         }
/*     */       } 
/*     */       
/*  67 */       if (scoreobjective1 != null)
/*     */       {
/*  69 */         renderScoreboard(scoreobjective1, scaledresolution);
/*     */       }
/*     */       
/*  72 */       GlStateManager.enableBlend();
/*  73 */       GlStateManager.tryBlendFuncSeparate(770, 771, 1, 0);
/*  74 */       GlStateManager.disableAlpha();
/*  75 */       GlStateManager.pushMatrix();
/*  76 */       GlStateManager.translate(0.0F, (j - 48), 0.0F);
/*     */ 
/*     */ 
/*     */       
/*  80 */       GlStateManager.popMatrix();
/*  81 */       scoreobjective1 = scoreboard.getObjectiveInDisplaySlot(0);
/*     */ 
/*     */       
/*  84 */       GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
/*  85 */       GlStateManager.disableLighting();
/*  86 */       GlStateManager.enableAlpha();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void renderScoreboard(ScoreObjective p_180475_1_, ScaledResolution scaledResolution) {
/*  93 */     Scoreboard scoreboard = p_180475_1_.getScoreboard();
/*  94 */     Collection<Score> collection = scoreboard.getSortedScores(p_180475_1_);
/*  95 */     List<Score> list = Lists.newArrayList(Iterables.filter(collection, new Predicate<Score>()
/*     */           {
/*     */             public boolean apply(Score p_apply_1_)
/*     */             {
/*  99 */               return (p_apply_1_.getPlayerName() != null && !p_apply_1_.getPlayerName().startsWith("#"));
/*     */             }
/*     */           }));
/*     */     
/* 103 */     if (list.size() > 15) {
/*     */       
/* 105 */       collection = Lists.newArrayList(Iterables.skip(list, collection.size() - 15));
/*     */     }
/*     */     else {
/*     */       
/* 109 */       collection = list;
/*     */     } 
/*     */     
/* 112 */     int i = getFontRenderer().getStringWidth(p_180475_1_.getDisplayName());
/*     */     
/* 114 */     for (Score score : collection) {
/*     */       
/* 116 */       ScorePlayerTeam scoreplayerteam = scoreboard.getPlayersTeam(score.getPlayerName());
/* 117 */       String s = String.valueOf(ScorePlayerTeam.formatPlayerName((Team)scoreplayerteam, score.getPlayerName())) + ": " + EnumChatFormatting.RED + score.getScorePoints();
/* 118 */       i = Math.max(i, getFontRenderer().getStringWidth(s));
/*     */     } 
/*     */     
/* 121 */     int i1 = collection.size() * (getFontRenderer()).FONT_HEIGHT;
/* 122 */     int j1 = this.pos.getAbsoluteY() + i1 + 10;
/* 123 */     int k1 = 3;
/* 124 */     int l1 = this.pos.getAbsoluteX() - i + i - k1 + 5;
/* 125 */     int j = 0;
/*     */     
/* 127 */     for (Score score1 : collection) {
/*     */       
/* 129 */       j++;
/* 130 */       ScorePlayerTeam scoreplayerteam1 = scoreboard.getPlayersTeam(score1.getPlayerName());
/* 131 */       String s1 = ScorePlayerTeam.formatPlayerName((Team)scoreplayerteam1, score1.getPlayerName());
/* 132 */       String s2 = EnumChatFormatting.RED + score1.getScorePoints();
/* 133 */       int k = j1 - j * (getFontRenderer()).FONT_HEIGHT;
/* 134 */       int l = this.pos.getAbsoluteX() - k1 + 2 + i;
/* 135 */       Gui.drawRect(l1 - 2, k, l, k + (getFontRenderer()).FONT_HEIGHT, 1342177280);
/* 136 */       getFontRenderer().drawString(s1, l1, k, 553648127);
/* 137 */       getFontRenderer().drawString(s2, (l - getFontRenderer().getStringWidth(s2)), k, 553648127);
/*     */       
/* 139 */       this.listHeight = i1 + 10;
/* 140 */       this.listWidth = l - l1 - 2;
/*     */       
/* 142 */       if (j == collection.size()) {
/*     */         
/* 144 */         String s3 = p_180475_1_.getDisplayName();
/* 145 */         Gui.drawRect(l1 - 2, k - (getFontRenderer()).FONT_HEIGHT - 1, l, k - 1, 1610612736);
/* 146 */         Gui.drawRect(l1 - 2, k - 1, l, k, 1342177280);
/* 147 */         getFontRenderer().drawString(s3, (l1 + i / 2 - getFontRenderer().getStringWidth(s3) / 2), (k - (getFontRenderer()).FONT_HEIGHT), 553648127);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private FontRenderer getFontRenderer() {
/* 154 */     return this.mc.fontRendererObj;
/*     */   }
/*     */ 
/*     */   
/*     */   public void renderDummy(ScoreObjective p_180475_1_, ScaledResolution scaledResolution) {
/* 159 */     Scoreboard scoreboard = this.mc.theWorld.getScoreboard();
/* 160 */     ScoreObjective scoreobjective = null;
/* 161 */     ScorePlayerTeam scoreplayerteam = scoreboard.getPlayersTeam(Minecraft.thePlayer.getCommandSenderName());
/*     */     
/* 163 */     ScoreObjective scoreobjective1 = (scoreobjective != null) ? scoreobjective : scoreboard.getObjectiveInDisplaySlot(1);
/* 164 */     ScaledResolution scaledresolution = new ScaledResolution(this.mc);
/* 165 */     int i = scaledresolution.getScaledWidth();
/* 166 */     int j = scaledresolution.getScaledHeight();
/*     */     
/* 168 */     if (scoreplayerteam != null) {
/*     */       
/* 170 */       int i1 = scoreplayerteam.getChatFormat().getColorIndex();
/*     */       
/* 172 */       if (i1 >= 0)
/*     */       {
/* 174 */         scoreobjective = scoreboard.getObjectiveInDisplaySlot(3 + i1);
/*     */       }
/*     */     } 
/*     */     
/* 178 */     if (scoreobjective1 != null)
/*     */     {
/* 180 */       renderScoreboard(scoreobjective1, scaledresolution);
/*     */     }
/*     */     
/* 183 */     GlStateManager.enableBlend();
/* 184 */     GlStateManager.tryBlendFuncSeparate(770, 771, 1, 0);
/* 185 */     GlStateManager.disableAlpha();
/* 186 */     GlStateManager.pushMatrix();
/* 187 */     GlStateManager.translate(0.0F, (j - 48), 0.0F);
/*     */ 
/*     */ 
/*     */     
/* 191 */     GlStateManager.popMatrix();
/* 192 */     scoreobjective1 = scoreboard.getObjectiveInDisplaySlot(0);
/*     */ 
/*     */     
/* 195 */     GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
/* 196 */     GlStateManager.disableLighting();
/* 197 */     GlStateManager.enableAlpha();
/*     */   }
/*     */ }


/* Location:              C:\Users\Lenovo\Downloads\ZyrexClientV1 (1).jar!\ZyrexClient\mods\impl\ZyrexModScoreboard.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */