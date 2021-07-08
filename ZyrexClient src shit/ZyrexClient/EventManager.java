/*     */ package ZyrexClient;
/*     */ 
/*     */ import java.lang.reflect.Method;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.Map;
/*     */ 
/*     */ public class EventManager
/*     */ {
/*  11 */   private static final Map<Class<? extends Event>, ArrayList<EventData>> REGISTRY_MAP = new HashMap<>();
/*     */ 
/*     */   
/*     */   private static void sortListValue(Class<? extends Event> clazz) {
/*  15 */     ArrayList<EventData> flexableArray = new ArrayList<>(); byte b; int i;
/*     */     byte[] arrayOfByte;
/*  17 */     for (i = (arrayOfByte = EventPriority.VALUE_ARRAY).length, b = 0; b < i; ) { byte b1 = arrayOfByte[b];
/*  18 */       for (EventData methodData : REGISTRY_MAP.get(clazz)) {
/*  19 */         if (methodData.priority == b1) {
/*  20 */           flexableArray.add(methodData);
/*     */         }
/*     */       } 
/*     */       b++; }
/*     */     
/*  25 */     REGISTRY_MAP.put(clazz, flexableArray);
/*     */   }
/*     */ 
/*     */   
/*     */   private static boolean isMethodBad(Method method) {
/*  30 */     return !((method.getParameterTypes()).length == 1 && method.isAnnotationPresent((Class)EventTarget.class));
/*     */   }
/*     */   
/*     */   private static boolean isMethodBad(Method method, Class<? extends Event> clazz) {
/*  34 */     return !(!isMethodBad(method) && !method.getParameterTypes()[0].equals(clazz));
/*     */   }
/*     */   
/*     */   public static ArrayList<EventData> get(Class<? extends Event> clazz) {
/*  38 */     return REGISTRY_MAP.get(clazz);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void cleanMap(boolean removeOnlyEmptyValues) {
/*  43 */     Iterator<Map.Entry<Class<? extends Event>, ArrayList<EventData>>> iterator = REGISTRY_MAP.entrySet().iterator();
/*     */     
/*  45 */     while (iterator.hasNext()) {
/*  46 */       if (!removeOnlyEmptyValues || ((ArrayList)((Map.Entry)iterator.next()).getValue()).isEmpty()) {
/*  47 */         iterator.remove();
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public static void unregister(Object o, Class<? extends Event> clazz) {
/*  54 */     if (REGISTRY_MAP.containsKey(clazz)) {
/*  55 */       for (EventData methodData : REGISTRY_MAP.get(clazz)) {
/*  56 */         if (methodData.source.equals(o)) {
/*  57 */           ((ArrayList)REGISTRY_MAP.get(clazz)).remove(methodData);
/*     */         }
/*     */       } 
/*     */     }
/*     */     
/*  62 */     cleanMap(true);
/*     */   }
/*     */   
/*     */   public static void unregister(Object o) {
/*  66 */     for (ArrayList<EventData> flexableArray : REGISTRY_MAP.values()) {
/*  67 */       for (int i = flexableArray.size() - 1; i >= 0; i--) {
/*  68 */         if (((EventData)flexableArray.get(i)).source.equals(o)) {
/*  69 */           flexableArray.remove(i);
/*     */         }
/*     */       } 
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/*  76 */     cleanMap(true);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static void register(Method method, Object o) {
/*  82 */     Class<?> clazz = method.getParameterTypes()[0];
/*     */     
/*  84 */     EventData methodData = new EventData(o, method, ((EventTarget)method.<EventTarget>getAnnotation(EventTarget.class)).value());
/*     */     
/*  86 */     if (!methodData.target.isAccessible()) {
/*  87 */       methodData.target.setAccessible(true);
/*     */     }
/*     */     
/*  90 */     if (REGISTRY_MAP.containsKey(clazz)) {
/*     */       
/*  92 */       if (!((ArrayList)REGISTRY_MAP.get(clazz)).contains(methodData)) {
/*  93 */         ((ArrayList<EventData>)REGISTRY_MAP.get(clazz)).add(methodData);
/*  94 */         sortListValue((Class)clazz);
/*     */       } 
/*     */     } else {
/*     */       
/*  98 */       REGISTRY_MAP.put(clazz, new ArrayList<EventData>(methodData)
/*     */           {
/*     */           
/*     */           });
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static void register(Object o, Class<? extends Event> clazz) {
/*     */     byte b;
/*     */     int i;
/*     */     Method[] arrayOfMethod;
/* 111 */     for (i = (arrayOfMethod = o.getClass().getMethods()).length, b = 0; b < i; ) { Method method = arrayOfMethod[b];
/* 112 */       if (!isMethodBad(method, clazz))
/* 113 */         register(method, o); 
/*     */       b++; }
/*     */   
/*     */   } public static void register(Object o) {
/*     */     byte b;
/*     */     int i;
/*     */     Method[] arrayOfMethod;
/* 120 */     for (i = (arrayOfMethod = o.getClass().getMethods()).length, b = 0; b < i; ) { Method method = arrayOfMethod[b];
/* 121 */       if (!isMethodBad(method))
/* 122 */         register(method, o); 
/*     */       b++; }
/*     */   
/*     */   }
/*     */ }


/* Location:              C:\Users\Lenovo\Downloads\ZyrexClientV1 (1).jar!\ZyrexClient\EventManager.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */