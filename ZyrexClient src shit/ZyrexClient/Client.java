/*     */ package ZyrexClient;
/*     */ 
/*     */ import ZyrexClient.Gui.HUDManager;
/*     */ import ZyrexClient.Gui.Notifications.NotificationManager;
/*     */ import ZyrexClient.Gui.SplashProgress;
/*     */ import ZyrexClient.ModHuds.ModHud5;
/*     */ import ZyrexClient.ModToggle.ModToggle;
/*     */ import ZyrexClient.UpdateChecker.UpdateChecker;
/*     */ import ZyrexClient.UpdateChecker.UpdateHud;
/*     */ import ZyrexClient.impl.ClientTickEvent;
/*     */ import ZyrexClient.mods.ModInstances;
/*     */ import ZyrexClient.mods.impl.ClientSettings;
/*     */ import java.awt.Color;
/*     */ import net.minecraft.client.Minecraft;
/*     */ import net.minecraft.client.entity.AbstractClientPlayer;
/*     */ import net.minecraft.client.gui.GuiScreen;
/*     */ import net.minecraft.util.ChatComponentText;
/*     */ import net.minecraft.util.IChatComponent;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Client
/*     */ {
/*     */   public static final String NAME = "Zyrex Client";
/*     */   public static final String VERSION = "1.0.1";
/*  28 */   public static final Client INSTANCE = new Client();
/*     */   
/*  30 */   private static Minecraft mc = Minecraft.getMinecraft();
/*     */ 
/*     */   
/*     */   public static final String Zyrex = "Zyrex";
/*     */ 
/*     */   
/*     */   public static final String zyrexText = "Zyrex";
/*     */   
/*  38 */   public static boolean WhiteCape = ModToggle.loadEnabledFromFileCosmetics("Cosmetics/Capes/WhiteCape").booleanValue();
/*  39 */   public static boolean BlackCape = ModToggle.loadEnabledFromFileCosmetics("Cosmetics/Capes/BlackCape").booleanValue();
/*  40 */   public static boolean PurpleCape = ModToggle.loadEnabledFromFileCosmetics("Cosmetics/Capes/PurpleCape").booleanValue();
/*  41 */   public static boolean UserCape = ModToggle.loadEnabledFromFileCosmetics("Cosmetics/Capes/UserCape").booleanValue();
/*  42 */   public static boolean CyanCape = ModToggle.loadEnabledFromFileCosmetics("Cosmetics/Capes/CyanCape").booleanValue();
/*  43 */   public static boolean BlueCape = ModToggle.loadEnabledFromFileCosmetics("Cosmetics/Capes/BlueCape").booleanValue();
/*     */ 
/*     */   
/*  46 */   public static boolean CosmeticWings = ModToggle.loadEnabledFromFileCosmetics("Cosmetics/Wings/DefaultWings").booleanValue();
/*  47 */   public static boolean CosmeticWingsRed = ModToggle.loadEnabledFromFileCosmetics("Cosmetics/Wings/RedWings").booleanValue();
/*  48 */   public static boolean CosmeticWingsBlack = ModToggle.loadEnabledFromFileCosmetics("Cosmetics/Wings/BlackWings").booleanValue();
/*  49 */   public static boolean CosmeticWingsWhite = ModToggle.loadEnabledFromFileCosmetics("Cosmetics/Wings/WhiteWings").booleanValue();
/*  50 */   public static boolean CosmeticWingsDarkGray = ModToggle.loadEnabledFromFileCosmetics("Cosmetics/Wings/DarkGrayWings").booleanValue();
/*     */ 
/*     */   
/*  53 */   public static boolean CosmeticEasterEggs = ModToggle.loadEnabledFromFileCosmetics("Cosmetics/HeadWears/EasterEggs").booleanValue();
/*  54 */   public static boolean CosmeticRockPet = ModToggle.loadEnabledFromFileCosmetics("Cosmetics/HeadWears/PetRock").booleanValue();
/*  55 */   public static boolean CosmeticWitchHat = ModToggle.loadEnabledFromFileCosmetics("Cosmetics/HeadWears/WitchHat").booleanValue();
/*     */ 
/*     */   
/*  58 */   public static boolean ModArmorStatus = ModToggle.loadEnabledFromFile("Mods/ZyrexModArmorStatus/ModArmorStatus").booleanValue();
/*  59 */   public static boolean ModBossbar = ModToggle.loadEnabledFromFile("Mods/ZyrexModBossbar/ModBossbar").booleanValue();
/*  60 */   public static boolean ModCPS = ModToggle.loadEnabledFromFile("Mods/ZyrexModCPS/ModCPS").booleanValue();
/*  61 */   public static boolean ModFPS = ModToggle.loadEnabledFromFile("Mods/ZyrexModFPS/ModFPS").booleanValue();
/*  62 */   public static boolean ModPing = ModToggle.loadEnabledFromFile("Mods/ZyrexModPing/ModPing").booleanValue();
/*  63 */   public static boolean ModKeystrokes = ModToggle.loadEnabledFromFile("Mods/ZyrexModKeystrokes/ModKeystrokes").booleanValue();
/*  64 */   public static boolean ModPotionStatus = ModToggle.loadEnabledFromFile("Mods/ZyrexModPotionStatus/ModPotionStatus").booleanValue();
/*  65 */   public static boolean ModCoordinates = ModToggle.loadEnabledFromFile("Mods/ZyrexModCoordinates/ModCoordinates").booleanValue();
/*  66 */   public static boolean InventoryBlur = ModToggle.loadEnabledFromFile("Mods/ZyrexModInventoryBlur/ModBlur").booleanValue();
/*  67 */   public static boolean CleanButtons = ModToggle.loadEnabledFromFileFalse("Buttons/CleanButtonMod/ModButton").booleanValue();
/*  68 */   public static boolean MotionBlur = ModToggle.loadEnabledFromFileFalse("Mods/ZyrexModMotionBlur/MotionBlur").booleanValue();
/*  69 */   public static boolean Nametag = ModToggle.loadEnabledFromFileFalse("Mods/ZyrexModNametag/ModNametag").booleanValue();
/*  70 */   public static boolean oldAnimations = ModToggle.loadEnabledFromFile("Mods/ZyrexModOldAnims/ModOldAnims").booleanValue();
/*  71 */   public static boolean ModDirection = ModToggle.loadEnabledFromFileFalse("Mods/ZyrexModDirection/ModDirection").booleanValue();
/*  72 */   public static boolean SmoothZoom = ModToggle.loadEnabledFromFile("Mods/ZyrexModZoom/SmoothZoom").booleanValue();
/*     */ 
/*     */   
/*  75 */   public static boolean EatingAnimation = ModToggle.loadEnabledFromFile("Mods/ZyrexModOldAnims/EatingAnimation").booleanValue();
/*  76 */   public static boolean BlockHitAnimation = ModToggle.loadEnabledFromFile("Mods/ZyrexModOldAnims/BlockHitAnimation").booleanValue();
/*  77 */   public static boolean BowAnimation = ModToggle.loadEnabledFromFile("Mods/ZyrexModOldAnims/BowAnimation").booleanValue();
/*  78 */   public static boolean SwordAnimation = ModToggle.loadEnabledFromFile("Mods/ZyrexModOldAnims/SwordAnimation").booleanValue();
/*     */ 
/*     */   
/*  81 */   public static boolean KeystrokesCPS = ModToggle.loadEnabledFromFile("Mods/ZyrexModKeystrokes/KeystrokesCPS").booleanValue();
/*     */ 
/*     */   
/*  84 */   public static boolean CustomChat = ModToggle.loadEnabledFromFileFalse("Mods/ZyrexModCustomChat/ModCustomChat").booleanValue();
/*  85 */   public static boolean CompactChat = ModToggle.loadEnabledFromFile("Mods/ZyrexModCustomChat/ModCompactChat").booleanValue();
/*  86 */   public static boolean NoBackground = ModToggle.loadEnabledFromFile("Mods/ZyrexModCustomChat/ModNoBackground").booleanValue();
/*     */ 
/*     */   
/*  89 */   public static boolean CPSChroma = ModToggle.loadEnabledFromFile("Mods/ZyrexModCPS/isChromaDisabled").booleanValue();
/*  90 */   public static boolean FPSChroma = ModToggle.loadEnabledFromFile("Mods/ZyrexModFPS/isChromaDisabled").booleanValue();
/*  91 */   public static boolean PingChroma = ModToggle.loadEnabledFromFile("Mods/ZyrexModPing/isChromaDisabled").booleanValue();
/*  92 */   public static boolean KeystrokesChroma = ModToggle.loadEnabledFromFile("Mods/ZyrexModKeystrokes/isChromaDisabled").booleanValue();
/*  93 */   public static boolean ArmorStatusChroma = ModToggle.loadEnabledFromFile("Mods/ZyrexModArmorStatus/isChromaDisabled").booleanValue();
/*  94 */   public static boolean PotionStatusChroma = ModToggle.loadEnabledFromFile("Mods/ZyrexModPotStatus/isChromaDisabled").booleanValue();
/*  95 */   public static boolean CoordinatesChroma = ModToggle.loadEnabledFromFile("Mods/ZyrexModCoordinates/isChromaDisabled").booleanValue();
/*     */ 
/*     */   
/*  98 */   public static boolean CPSBackground = ModToggle.loadEnabledFromFile("Mods/ZyrexModCPS/CPSBackground").booleanValue();
/*  99 */   public static boolean FPSBackground = ModToggle.loadEnabledFromFile("Mods/ZyrexModFPS/FPSBackground").booleanValue();
/* 100 */   public static boolean PingBackground = ModToggle.loadEnabledFromFile("Mods/ZyrexModPing/PingBackground").booleanValue();
/* 101 */   public static boolean CoordinatesBackground = ModToggle.loadEnabledFromFile("Mods/ZyrexModCoordinates/CoordinatesBackground").booleanValue();
/* 102 */   public static boolean ArmorStatusBackground = ModToggle.loadEnabledFromFile("Mods/ZyrexModArmorStatusBackground/ArmorStatusBackground").booleanValue();
/*     */ 
/*     */   
/* 105 */   public static boolean MotionBlurHideFromHud = ModToggle.loadEnabledFromFileFalse("Mods/ZyrexModMotionBlur/MotionBlurHud").booleanValue();
/*     */ 
/*     */   
/*     */   public static boolean ping;
/*     */   
/*     */   public static Object Client;
/*     */ 
/*     */   
/*     */   public static final Client getInstance() {
/* 114 */     return INSTANCE;
/*     */   }
/*     */   
/* 117 */   private DiscordRP discordRP = new DiscordRP();
/*     */   
/*     */   private HUDManager hudManager;
/*     */   
/*     */   public NotificationManager notificationManager;
/*     */   
/*     */   public static int RainbowEffect(int i, float f) {
/* 124 */     return Color.HSBtoRGB((float)(System.currentTimeMillis() % 20000L) / 1000.0F, 0.8F, 0.8F);
/*     */   }
/*     */   
/*     */   public void init() {
/* 128 */     SplashProgress.setProgress(1, "Zyrex - Loading DiscordRP...");
/* 129 */     FileManager.init();
/* 130 */     this.discordRP.start();
/* 131 */     EventManager.register(this);
/*     */   }
/*     */   
/*     */   public static boolean messageTyped(String message, AbstractClientPlayer player) {
/* 135 */     if (message.startsWith(".")) {
/* 136 */       String msg = message.substring(1);
/* 137 */       if (msg.equalsIgnoreCase("motionblur")) {
/* 138 */         ClientSettings.MOTIONBLUR = !ClientSettings.MOTIONBLUR;
/* 139 */         player.addChatMessage((IChatComponent)new ChatComponentText(ClientSettings.MOTIONBLUR ? "MOTIONBLUR on" : "MOTIONBLUR off"));
/*     */       } 
/* 141 */       return true;
/*     */     } 
/* 143 */     return false;
/*     */   }
/*     */   
/*     */   public void start() {
/* 147 */     if (UpdateChecker.shouldUpdate()) {
/*     */       
/* 149 */       System.out.println("update your client");
/* 150 */       mc.displayGuiScreen((GuiScreen)new UpdateHud());
/*     */     } 
/* 152 */     this.hudManager = HUDManager.getInstance();
/* 153 */     ModInstances.register(this.hudManager);
/*     */   }
/*     */   
/*     */   public void shutdown() {
/* 157 */     this.discordRP.shutdown();
/*     */   }
/*     */   
/*     */   public DiscordRP getDiscordRP() {
/* 161 */     return this.discordRP;
/*     */   }
/*     */   
/*     */   @EventTarget
/*     */   public void onTick(ClientTickEvent e) {
/* 166 */     if ((Minecraft.getMinecraft()).gameSettings.CLIENT_GUI_MOD_POS.isPressed()) {
/* 167 */       this.hudManager.openConfigScreen();
/*     */     }
/*     */     
/* 170 */     if ((Minecraft.getMinecraft()).gameSettings.CLIENT_GUI_MOD_TOGGLE.isPressed()) {
/* 171 */       Minecraft.getMinecraft().displayGuiScreen((GuiScreen)new ModHud5());
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public Object getCosmeticController() {
/* 177 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\Users\Lenovo\Downloads\ZyrexClientV1 (1).jar!\ZyrexClient\Client.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */