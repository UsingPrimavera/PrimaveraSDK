package com.usingprimavera.p6.integration.client;

import com.usingprimavera.p6.Configuration;

public class RMIURL {

  private static Configuration _config = null;
  private static IRMIURL _rmiurl = null;

  public static final int COMPRESSION_RMI_SERVICE = com.primavera.integration.client.RMIURL.COMPRESSION_RMI_SERVICE;
  public static final int LOCAL_SERVICE = com.primavera.integration.client.RMIURL.LOCAL_SERVICE;
  public static final int SSL_RMI_SERVICE = com.primavera.integration.client.RMIURL.SSL_RMI_SERVICE;
  public static final int STANDARD_RMI_SERVICE = com.primavera.integration.client.RMIURL.STANDARD_RMI_SERVICE;

  public static String getDefaultHost() {
    setupEnvironment();
    return _rmiurl.getDefaultHost();
  }

  public static int getDefaultPort() {
    setupEnvironment();
    return _rmiurl.getDefaultPort();
  }

  public static String getRmiUrl() {
    setupEnvironment();
    return _rmiurl.getRmiUrl();
  }

  public static String getRmiUrl(int iMode) {
    setupEnvironment();
    return _rmiurl.getRmiUrl(iMode);
  }

  public static String getRmiUrl(int iMode, String sHost, int iPort) {
    setupEnvironment();
    return _rmiurl.getRmiUrl(iMode, sHost, iPort);
  }

  public static void setDefaultHost(String sHost) {
    setupEnvironment();
    _rmiurl.setDefaultHost(sHost);
  }

  public static void setDefaultPort(int iPort) {
    setupEnvironment();
    _rmiurl.setDefaultPort(iPort);
  }

  private static void setupEnvironment() {
    if (_config == null) {
      _config = Configuration.getInstance();
      switch (_config.getP6SessionType()) {
        case "WEB_SERVICE": _rmiurl = new WRMIURL();
             break;
        default: _rmiurl = new JRMIURL();
      }
    }
  }


}
