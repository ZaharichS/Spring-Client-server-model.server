package com.example.demoDBBoot.responses;

import com.example.demoDBBoot.entity.Register;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class RegisterResponse extends DataBaseResponse {
    public  RegisterResponse(Iterable<Register> data) {
        super(true,"Полёты");
        this.data = data;
    }

    private Iterable<Register> data;

}
