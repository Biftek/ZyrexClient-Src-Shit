/*    */ package ZyrexClient.Gui.Login2.TheAlteningAuth;
/*    */ 
/*    */ import java.lang.invoke.MethodHandle;
/*    */ import java.lang.invoke.MethodHandles;
/*    */ import java.lang.reflect.Field;
/*    */ import java.lang.reflect.Modifier;
/*    */ import java.util.HashMap;
/*    */ import java.util.Optional;
/*    */ 
/*    */ 
/*    */ public final class FieldAdapter
/*    */ {
/* 13 */   private final HashMap<String, MethodHandle> fields = new HashMap<>();
/*    */   private static final MethodHandles.Lookup LOOKUP;
/*    */   private static Field MODIFIERS;
/*    */   
/*    */   public FieldAdapter(String parent) {
/*    */     try {
/* 19 */       Class<?> cls = Class.forName(parent);
/* 20 */       Field modifiers = MODIFIERS; byte b; int i; Field[] arrayOfField;
/* 21 */       for (i = (arrayOfField = cls.getDeclaredFields()).length, b = 0; b < i; ) { Field field = arrayOfField[b];
/* 22 */         field.setAccessible(true);
/* 23 */         int accessFlags = field.getModifiers();
/* 24 */         if (Modifier.isFinal(accessFlags)) {
/* 25 */           modifiers.setInt(field, accessFlags & 0xFFFFFFEF);
/*    */         }
/*    */         
/* 28 */         MethodHandle handler = LOOKUP.unreflectSetter(field);
/* 29 */         handler = handler.asType(handler.type().generic().changeReturnType(void.class));
/* 30 */         this.fields.put(field.getName(), handler); b++; }
/*    */     
/* 32 */     } catch (ClassNotFoundException e) {
/* 33 */       throw new RuntimeException("Couldn't load/find the specified class");
/* 34 */     } catch (Exception e) {
/* 35 */       throw new RuntimeException("Couldn't create a method handler for the field");
/*    */     } 
/*    */   }
/*    */   
/*    */   public void updateFieldIfPresent(String name, Object newValue) {
/* 40 */     Optional.<MethodHandle>ofNullable(this.fields.get(name)).ifPresent(setter -> {
/*    */           try {
/*    */             setter.invokeExact(paramObject);
/* 43 */           } catch (Throwable e) {
/*    */             e.printStackTrace();
/*    */           } 
/*    */         });
/*    */   }
/*    */   static {
/*    */     MethodHandles.Lookup lookupObject;
/*    */     try {
/* 51 */       MODIFIERS = Field.class.getDeclaredField("modifiers");
/* 52 */       MODIFIERS.setAccessible(true);
/* 53 */     } catch (NoSuchFieldException e) {
/* 54 */       e.printStackTrace();
/*    */     } 
/*    */ 
/*    */     
/*    */     try {
/* 59 */       Field lookupImplField = MethodHandles.Lookup.class.getDeclaredField("IMPL_LOOKUP");
/* 60 */       lookupImplField.setAccessible(true);
/* 61 */       lookupObject = (MethodHandles.Lookup)lookupImplField.get((Object)null);
/* 62 */     } catch (ReflectiveOperationException e) {
/* 63 */       lookupObject = MethodHandles.lookup();
/*    */     } 
/*    */     
/* 66 */     LOOKUP = lookupObject;
/*    */   }
/*    */ }


/* Location:              C:\Users\Lenovo\Downloads\ZyrexClientV1 (1).jar!\ZyrexClient\Gui\Login2\TheAlteningAuth\FieldAdapter.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */