package com.usingprimavera.p6.integration.client;

interface IRMIURL {

  public String getDefaultHost();

  public int getDefaultPort();

  public String getRmiUrl();

  public String getRmiUrl(int iMode);

  public String getRmiUrl(int iMode, String sHost, int iPort);

  public void setDefaultHost(String sHost);

  public void setDefaultPort(int iPort);
}
