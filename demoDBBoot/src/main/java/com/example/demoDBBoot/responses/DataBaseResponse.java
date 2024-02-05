package com.example.demoDBBoot.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class DataBaseResponse {
    protected boolean success;
    protected String message;
}
