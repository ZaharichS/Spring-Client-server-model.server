package com.example.demoDBBoot.responses;

import com.example.demoDBBoot.entity.Register;

public class RegisterResponse extends DataBaseResponse {
    public  RegisterResponse(Iterable<Register> data) {
        super(true,"Полёты");
        this.data = data;
    }

    private Iterable<Register> data;


}
