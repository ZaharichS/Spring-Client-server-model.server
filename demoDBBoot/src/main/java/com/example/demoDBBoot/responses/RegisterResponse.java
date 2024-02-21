package com.example.demoDBBoot.responses;

import com.example.demoDBBoot.entity.Register;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Optional;

@Data
@EqualsAndHashCode(callSuper = false)
public class RegisterResponse extends DataBaseResponse {
    public  RegisterResponse(Boolean success,String message, Iterable<Register> data) {
        super(success,message);
        this.data = data;
    }

    private Iterable<Register> data;
}
