package com.infra;

import static java.util.Objects.nonNull;

import java.net.URI;

import org.springframework.http.ResponseEntity;
import org.springframework.web.util.UriComponentsBuilder;

import lombok.Builder;

@Builder
public class UriResponseBuilder {

    private static final String QUERY_PREFIX = "/query/api/v";

    protected String fullPath;

    protected String id;

    public URI toUri() {
        var uri = fullPath.replace("/api/v", QUERY_PREFIX);
        var uriBuilder = UriComponentsBuilder.fromUriString(uri);

        if (nonNull(id))
            uriBuilder.pathSegment(id);

        return uriBuilder.build().toUri();
    }

    public ResponseEntity<Void> toCreated() {
        URI location = toUri();

        return ResponseEntity
            .created(location)
            .build();
    }

}

