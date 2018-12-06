package com.moneysupermarket.retroactions.response;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class RetroActionResponse {

    private String id;
    private String message;

}
