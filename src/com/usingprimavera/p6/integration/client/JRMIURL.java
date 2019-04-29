package com.usingprimavera.p6.integration.client;

public class JRMIURL implements IRMIURL {

  public String getDefaultHost() {
    return com.primavera.integration.client.RMIURL.getDefaultHost();
  }

  public int getDefaultPort() {
    return com.primavera.integration.client.RMIURL.getDefaultPort();
  }

  public String getRmiUrl() {
    return com.primavera.integration.client.RMIURL.getRmiUrl();
  }

  public String getRmiUrl(int iMode) {
    return com.primavera.integration.client.RMIURL.getRmiUrl(iMode);
  }

  public String getRmiUrl(int iMode, String sHost, int iPort) {
    return com.primavera.integration.client.RMIURL.getRmiUrl(iMode, sHost, iPort);
  }

  public void setDefaultHost(String sHost) {
    com.primavera.integration.client.RMIURL.setDefaultHost(sHost);
  }

  public void setDefaultPort(int iPort) {
    com.primavera.integration.client.RMIURL.setDefaultPort(iPort);
  }


}
