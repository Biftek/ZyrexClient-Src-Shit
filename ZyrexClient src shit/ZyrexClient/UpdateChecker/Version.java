/*    */ package ZyrexClient.UpdateChecker;
/*    */ 
/*    */ public class Version
/*    */   implements Comparable<Version> {
/*    */   private String version;
/*    */   
/*    */   public final String get() {
/*  8 */     return this.version;
/*    */   }
/*    */   
/*    */   public Version(String version) {
/* 12 */     if (version == null)
/* 13 */       throw new IllegalArgumentException("Version can not be null"); 
/* 14 */     if (!version.matches("[0-9]+(\\.[0-9]+)*"))
/* 15 */       throw new IllegalArgumentException("Invalid version format"); 
/* 16 */     this.version = version;
/*    */   }
/*    */   
/*    */   public int compareTo(Version that) {
/* 20 */     if (that == null)
/* 21 */       return 1; 
/* 22 */     String[] thisParts = get().split("\\.");
/* 23 */     String[] thatParts = that.get().split("\\.");
/* 24 */     int length = Math.max(thisParts.length, thatParts.length);
/* 25 */     for (int i = 0; i < length; i++) {
/* 26 */       int thisPart = (i < thisParts.length) ? 
/* 27 */         Integer.parseInt(thisParts[i]) : 0;
/* 28 */       int thatPart = (i < thatParts.length) ? 
/* 29 */         Integer.parseInt(thatParts[i]) : 0;
/* 30 */       if (thisPart < thatPart)
/* 31 */         return -1; 
/* 32 */       if (thisPart > thatPart)
/* 33 */         return 1; 
/*    */     } 
/* 35 */     return 0;
/*    */   }
/*    */   
/*    */   public boolean equals(Object that) {
/* 39 */     if (this == that)
/* 40 */       return true; 
/* 41 */     if (that == null)
/* 42 */       return false; 
/* 43 */     if (getClass() != that.getClass())
/* 44 */       return false; 
/* 45 */     return (compareTo((Version)that) == 0);
/*    */   }
/*    */ }


/* Location:              C:\Users\Lenovo\Downloads\ZyrexClientV1 (1).jar!\ZyrexClient\UpdateChecker\Version.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */