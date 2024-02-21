package com.example.demoDBBoot.responses;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class RefreshResponse extends DataBaseResponse{
    private Long id;

    public RefreshResponse(Boolean success, String message, Long id) {
        super(success, message);
        this.id = id;
    }
}