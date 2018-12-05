package com.moneysupermarket.retroactions.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

@Getter
@Setter
@EqualsAndHashCode
public class RetroAction {

    @Id
    private String id;

    private String title;
    private String description;
    private RetroActionStatus status;
    private String createdDate;

    public RetroAction(String title, String description, RetroActionStatus status) {
        this.title = title;
        this.description = description;
        this.status = status;
        this.createdDate = ZonedDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE);
    }
}