package com.usingprimavera.p6;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import java.util.Properties;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class ConfigurationTest {


	@Test
	public void testLoadDefaultConfigurationFile() {
    String filename = "PrimaveraSDK.properties";
    createConfigurationFile(filename,createDefaultConfiguration());
		Configuration.delete();
    Configuration config = Configuration.getInstance();
		assertEquals(filename, config.getFileName());
    assertEquals(getDefaultPathname() + filename, config.getPathName());
    assertEquals("LOCAL_SERVICE", config.getP6SessionType());
    assertEquals("http://ple-1808-demo", config.getP6RMIHostName());
    assertEquals(9099, config.getP6RMIPort());
    assertEquals(true, config.getP6BatchFailOnFirstFlag());
    assertEquals(1000, config.getP6BusinessObjectBatchSize());
    assertEquals(20, config.getP6BindParameterLimitOnLoad());
    assertEquals("http://ple-1808-demo", config.getP6WSHostName());
    assertEquals("UsernameToken", config.getP6WSSecurity());
	}

  @Test
	public void testLoadSpecifiedConfigurationFile() {
    String filename = "MyOwnPrimaveraSDK.properties";
    createConfigurationFile(filename,createCustomConfiguration());
		Configuration.delete();
    Configuration config = Configuration.getInstance(getDefaultPathname() + filename);
		assertEquals(filename, config.getFileName());
    assertEquals(getDefaultPathname() + filename, config.getPathName());
    assertEquals("STANDARD_RMI_SERVICE", config.getP6SessionType());
    assertEquals("http://ple-1808-custom", config.getP6RMIHostName());
    assertEquals(9024, config.getP6RMIPort());
    assertEquals(false, config.getP6BatchFailOnFirstFlag());
    assertEquals(2000, config.getP6BusinessObjectBatchSize());
    assertEquals(10, config.getP6BindParameterLimitOnLoad());
    assertEquals("http://ple-1808-ws", config.getP6WSHostName());
    assertEquals("SAML", config.getP6WSSecurity());

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
    * Create a custom Configuration file
    **/
    private Properties createCustomConfiguration() {

      Properties defaultProps = new Properties();

      defaultProps.setProperty("P6SessionType","STANDARD_RMI_SERVICE");
      defaultProps.setProperty("P6RMIHostName","http://ple-1808-custom");
      defaultProps.setProperty("P6RMIPort","9024");
      defaultProps.setProperty("P6BatchFailOnFirstFlag","false");
      defaultProps.setProperty("P6BusinessObjectBatchSize","2000");
      defaultProps.setProperty("P6BindParameterLimitOnLoad","10");
      defaultProps.setProperty("P6WSHostName","http://ple-1808-ws");
      defaultProps.setProperty("P6WSSecurity","SAML");

      return defaultProps;
    }
  /**
   * Creates a Configuration file using given set of properties.  This will overwrite any
   * existing Configuration file withthe same name
   **/
  private void createConfigurationFile(String filePathName, Properties configProps) {

    File file = new File(filePathName);

    try {
      if (file.exists()) {
        file.delete();
        file.createNewFile();
      }

      FileOutputStream out = new FileOutputStream(file);
      configProps.store(out, "---Testing---");
      out.close();
    }
    catch (FileNotFoundException ex) {
      System.out.println("FileNotFoundException writing " + filePathName);
    }
    catch (IOException ex) {
      System.out.println("IOException writing " + filePathName);
    }

  }

  /**
   * returns the default path where the file is stored
   **/
  private String getDefaultPathname() {
    return System.getProperty("user.dir") + File.separator;
  }
}
