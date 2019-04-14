package com.usingprimavera.client;

import java.lang.StringBuilder;

public class Version {

  private static String majorVersion = "0";
  private static String minorVersion = "0";
  private static String maintenanceVersion = "1";

  public static String getMajorVersion() {
    return majorVersion;
  }

  public static String getMinorVersion() {
    return minorVersion;
  }

  public static String getMaintenanceVersion() {
    return maintenanceVersion;
  }

  public static String getVersion() {

    StringBuilder builder = new StringBuilder("v");
    builder.append(majorVersion);
    builder.append(".");
    builder.append(minorVersion);
    builder.append(".");
    builder.append(maintenanceVersion);

    return builder.substring(0);
  }

}
