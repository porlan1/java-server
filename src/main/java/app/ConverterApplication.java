package app;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import io.dropwizard.bundles.assets.ConfiguredAssetsBundle;
import app.resources.api.ConverterResource;

public class ConverterApplication extends Application<ConverterConfiguration> {
    public static void main(String[] args) throws Exception {
        new ConverterApplication().run(args);
    }

    @Override
    public void initialize(Bootstrap<ConverterConfiguration> bootstrap) {
        bootstrap.addBundle(new ConfiguredAssetsBundle("/assets/", "/", "index.html"));
    }

    @Override
    public void run(ConverterConfiguration configuration,
                Environment environment) {
        final ConverterResource resource = new ConverterResource();
        environment.jersey().register(resource);
    }
}
