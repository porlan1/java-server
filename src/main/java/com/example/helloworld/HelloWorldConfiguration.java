package com.example.helloworld;

import io.dropwizard.Configuration;
import io.dropwizard.bundles.assets.AssetsBundleConfiguration;
import io.dropwizard.bundles.assets.AssetsConfiguration;
import com.fasterxml.jackson.annotation.JsonProperty;

public class HelloWorldConfiguration extends Configuration implements AssetsBundleConfiguration {
    
    @JsonProperty
    private final AssetsConfiguration assets = AssetsConfiguration.builder().build();
  
    @Override
    public AssetsConfiguration getAssetsConfiguration() {
      return assets;
    }
}
