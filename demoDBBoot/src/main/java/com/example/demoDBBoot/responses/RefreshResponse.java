package com.example.demoDBBoot.responses;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class RefreshResponse extends DataBaseResponse{
    private long id;

    public RefreshResponse(long id) {
        super(true, "Полет добавлен");
        this.id = id;
    }
}