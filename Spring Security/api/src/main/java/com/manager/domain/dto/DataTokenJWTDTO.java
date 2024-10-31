package com.manager.domain.dto;

public record DataTokenJWTDTO(
        String tokenJWT,
        UserReturnDto user
) {}