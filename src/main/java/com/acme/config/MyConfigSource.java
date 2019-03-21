package com.acme.config;

import java.util.HashMap;
import java.util.Map;
import org.eclipse.microprofile.config.spi.ConfigSource;

public class MyConfigSource implements ConfigSource {

  private static final Map<String, String> PROPERTIES = new HashMap<>();

  public MyConfigSource() {
    System.out.println("*** Initializing MyConfigSource ***");
    PROPERTIES.put("my.prop", "propB");
  }

  @Override
  public int getOrdinal() {
    return 800;
  }

  @Override
  public String getValue(String key) {
    if (PROPERTIES.containsKey(key)) {
      return PROPERTIES.get(key);
    }
    return null;
  }

  @Override
  public String getName() {
    return "MyCustomConfigSource";
  }

  @Override
  public Map<String, String> getProperties() {
    return PROPERTIES;
  }
}
