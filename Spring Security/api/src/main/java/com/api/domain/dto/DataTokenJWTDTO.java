package com.api.domain.dto;

public record DataTokenJWTDTO(
        String tokenJWT,
        UserReturnDto user
) {}