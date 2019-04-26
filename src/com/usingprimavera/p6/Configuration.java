package com.usingprimavera.p6;

import java.io.File;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.FileInputStream;

import java.util.Properties;

public class Configuration {

  private static Configuration _instance;

  private static String DEFAULT_CONFIGURATION_FILENAME = System.getProperty("user.dir") + File.separator + "PrimaveraSDK.properties";

  private Properties _props = null;
  private File _file = null;

  private Configuration() {
    this(DEFAULT_CONFIGURATION_FILENAME);
  }

  private Configuration(String filePathName) {

    _props = new Properties(createDefaultConfiguration());

    try {
      _file = createOrReturnFile(filePathName);
	    FileInputStream in = new FileInputStream(_file);
	    _props.load(in);
	    in.close();
    }
    catch (java.io.IOException ex) {
      System.out.println("IOException reading configuration file:" + ex);
    }


  }

  public synchronized static Configuration getInstance() {
    if (_instance==null) {
      _instance = new Configuration();
    }

    return _instance;
  }

  public synchronized static Configuration getInstance(String filePathName) {
    if (_instance==null) {
      _instance = new Configuration(filePathName);
    }

    return _instance;
  }

  public synchronized static void delete() {
    _instance = null;
  }

  public String getFileName() {
    return _file.getName();
  }

  public String getPathName() {
    return _file.getPath();
  }

  public String getP6SessionType() {
    return _props.getProperty("P6SessionType", null);
  }

  public String getP6RMIHostName() {
    return _props.getProperty("P6RMIHostName", null);
  }

  public long getP6RMIPort() {
    return Long.parseLong(_props.getProperty("P6RMIPort", null));
  }

  public Boolean getP6BatchFailOnFirstFlag() {
    return Boolean.parseBoolean(_props.getProperty("P6BatchFailOnFirstFlag", null));
  }

  public long getP6BusinessObjectBatchSize() {
    return Long.parseLong(_props.getProperty("P6BusinessObjectBatchSize", null));
  }

  public long getP6BindParameterLimitOnLoad() {
    return Long.parseLong(_props.getProperty("P6BindParameterLimitOnLoad", null));
  }

  public String getP6WSHostName() {
    return _props.getProperty("P6WSHostName", null);
  }

  public String getP6WSSecurity() {
    return _props.getProperty("P6WSSecurity", null);
  }

  /**
   * Create default Properties
   **/
  private Properties createDefaultConfiguration() {

    Properties defaultProps = new Properties();

    defaultProps.setProperty("P6SessionType","LOCAL_SERVICE");
    defaultProps.setProperty("P6RMIHostName","http://ple-1808-demo");
    defaultProps.setProperty("P6RMIPort","9099");
    defaultProps.setProperty("P6BatchFailOnFirstFlag","true");
    defaultProps.setProperty("P6BusinessObjectBatchSize","1000");
    defaultProps.setProperty("P6BindParameterLimitOnLoad","20");
    defaultProps.setProperty("P6WSHostName","http://ple-1808-demo");
    defaultProps.setProperty("P6WSSecurity","UsernameToken");

    return defaultProps;
  }

  /**
   * create a new configuration file or return an existing one
   **/
  private File createOrReturnFile(String filename) {

    File file = null;
    boolean isCreated = false;

    try {
      file = new File(filename);
      if (file.exists()) return file;
      isCreated = file.createNewFile();
    }
    catch (IOException ex) {
      System.out.println("createOrReturnFile() Error while creating a new empty file :" + ex);
    }

    return file;
  }


}
