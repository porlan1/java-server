package com.example.helloworld.resources.api;

import com.example.helloworld.core.Converter;
import com.google.common.base.Optional;
import com.codahale.metrics.annotation.Timed;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.util.concurrent.atomic.AtomicLong;
import java.util.Map;
import org.owasp.encoder.Encode;

@Path("/convert")
@Produces(MediaType.APPLICATION_JSON)
public class HelloWorldResource {
    private final String template;
    private final String defaultName;
    private final AtomicLong counter;

    public HelloWorldResource(String template, String defaultName) {
        this.template = template;
        this.defaultName = defaultName;
        this.counter = new AtomicLong();
    }

    @GET
    @Timed
    public Map<String, String> converter(@QueryParam("input") Optional<String> input) throws Exception {
        final String value = String.format(Encode.forHtml(input.or(defaultName)));
        Converter converter = new Converter(value);
        return converter.convertInput();
    }
}
