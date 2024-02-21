package com.example.demoDBBoot.responses;

import com.example.demoDBBoot.entity.Register;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class RefreshResponse extends DataBaseResponse{
/*    private Long id;
    public RefreshResponse(Boolean success, String message, Long id) {
        super(success, message);
        this.id = id;
    }*/
    private Register reg;
    public RefreshResponse(Boolean success, String message, Register reg) {
        super(success, message);
        this.reg = reg;
    }
}