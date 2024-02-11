package com.example.demoDBBoot.responses;

import com.example.demoDBBoot.entity.Register;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Optional;

@Data
@EqualsAndHashCode(callSuper = false)
public class CheckResponse extends DataBaseResponse{
    public CheckResponse(Optional<Register> dataFindRegister) {
        super(true,"Полёт найден");
        this.dataFindRegister = dataFindRegister;
    }
    private Optional<Register> dataFindRegister;
}
