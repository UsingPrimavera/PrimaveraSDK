package com.usingprimavera.p6.integration.client;

public class RMIURL {

  public static final int COMPRESSION_RMI_SERVICE = com.primavera.integration.client.RMIURL.COMPRESSION_RMI_SERVICE;
  public static final int LOCAL_SERVICE = com.primavera.integration.client.RMIURL.LOCAL_SERVICE;
  public static final int SSL_RMI_SERVICE = com.primavera.integration.client.RMIURL.SSL_RMI_SERVICE;
  public static final int STANDARD_RMI_SERVICE = com.primavera.integration.client.RMIURL.STANDARD_RMI_SERVICE;

  public static String getDefaultHost() {
    return com.primavera.integration.client.RMIURL.getDefaultHost();
  }

  public static int getDefaultPort() {
    return com.primavera.integration.client.RMIURL.getDefaultPort();
  }

  public static String getRmiUrl() {
    return com.primavera.integration.client.RMIURL.getRmiUrl();
  }

  public static String getRmiUrl(int iMode) {
    return com.primavera.integration.client.RMIURL.getRmiUrl(iMode);
  }

  public static String getRmiUrl(int iMode, String sHost, int iPort) {
    return com.primavera.integration.client.RMIURL.getRmiUrl(iMode, sHost, iPort);
  }

  public static void setDefaultHost(String sHost) {
    com.primavera.integration.client.RMIURL.setDefaultHost(sHost);
  }

  public static void setDefaultPort(int iPort) {
    com.primavera.integration.client.RMIURL.setDefaultPort(iPort);
  }


}
