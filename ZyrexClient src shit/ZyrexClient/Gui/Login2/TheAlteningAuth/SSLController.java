/*    */ package ZyrexClient.Gui.Login2.TheAlteningAuth;
/*    */ 
/*    */ import java.security.GeneralSecurityException;
/*    */ import java.security.NoSuchAlgorithmException;
/*    */ import java.security.SecureRandom;
/*    */ import java.security.cert.X509Certificate;
/*    */ import javax.net.ssl.HostnameVerifier;
/*    */ import javax.net.ssl.HttpsURLConnection;
/*    */ import javax.net.ssl.SSLContext;
/*    */ import javax.net.ssl.SSLSession;
/*    */ import javax.net.ssl.SSLSocketFactory;
/*    */ import javax.net.ssl.TrustManager;
/*    */ import javax.net.ssl.X509TrustManager;
/*    */ 
/*    */ 
/*    */ public final class SSLController
/*    */ {
/*    */   public SSLController() {
/* 19 */     SSLContext sc = null;
/*    */     try {
/* 21 */       sc = SSLContext.getInstance("SSL");
/* 22 */       sc.init(null, ALL_TRUSTING_TRUST_MANAGER, new SecureRandom());
/* 23 */     } catch (NoSuchAlgorithmException|java.security.KeyManagementException e) {
/* 24 */       e.printStackTrace();
/*    */     } 
/*    */     
/* 27 */     this.allTrustingFactory = sc.getSocketFactory();
/* 28 */     this.originalFactory = HttpsURLConnection.getDefaultSSLSocketFactory();
/* 29 */     this.originalHostVerifier = HttpsURLConnection.getDefaultHostnameVerifier();
/*    */   }
/*    */   
/*    */   public void enableCertificateValidation() {
/* 33 */     updateCertificateValidation(this.originalFactory, this.originalHostVerifier);
/*    */   }
/*    */   
/*    */   public void disableCertificateValidation() {
/* 37 */     updateCertificateValidation(this.allTrustingFactory, ALTENING_HOSTING_VERIFIER);
/*    */   }
/*    */   
/*    */   private void updateCertificateValidation(SSLSocketFactory factory, HostnameVerifier hostnameVerifier) {
/* 41 */     HttpsURLConnection.setDefaultSSLSocketFactory(factory);
/* 42 */     HttpsURLConnection.setDefaultHostnameVerifier(hostnameVerifier);
/*    */   }
/*    */ 
/*    */   
/* 46 */   private static final TrustManager[] ALL_TRUSTING_TRUST_MANAGER = new TrustManager[] {
/* 47 */       new X509TrustManager() { public void checkClientTrusted(X509Certificate[] certs, String authType) {}
/*    */         public X509Certificate[] getAcceptedIssuers() {
/* 49 */           return null;
/*    */         }
/*    */         
/*    */         public void checkServerTrusted(X509Certificate[] certs, String authType) {} }
/*    */        };
/*    */   
/*    */   static {
/* 56 */     ALTENING_HOSTING_VERIFIER = ((hostname, session) -> 
/* 57 */       !(!hostname.equals("authserver.thealtening.com") && !hostname.equals("sessionserver.thealtening.com")));
/*    */   }
/*    */   
/*    */   private static final HostnameVerifier ALTENING_HOSTING_VERIFIER;
/*    */   private final SSLSocketFactory allTrustingFactory;
/*    */   private final SSLSocketFactory originalFactory;
/*    */   private final HostnameVerifier originalHostVerifier;
/*    */ }


/* Location:              C:\Users\Lenovo\Downloads\ZyrexClientV1 (1).jar!\ZyrexClient\Gui\Login2\TheAlteningAuth\SSLController.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */