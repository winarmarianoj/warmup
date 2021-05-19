package com.marianowinar.warmup.dto.response;

import java.net.URI;

public class UserCreationResponseDto {

    private Long id;

    private URI uri;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public URI getUri() {
        return uri;
    }

    public void setUri(URI uri) {
        this.uri = uri;
    }
}
