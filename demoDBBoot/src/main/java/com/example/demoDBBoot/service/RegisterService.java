package com.example.demoDBBoot.service;


import com.example.demoDBBoot.entity.Register;
import com.example.demoDBBoot.repo.RegisterRepo;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RegisterService {
    private final RegisterRepo repo;
    public RegisterService(RegisterRepo repo) {
        this.repo = repo;
    }

    public Register save(Register registerFlight) {
        repo.save(registerFlight);
        return registerFlight;
    }
    public void delete(long id) {
        repo.deleteById(id);
    }
    public Optional<Register> findById(long id) {
        return repo.findById(id);
    }
    public Iterable<Register> getAll() {
        return repo.findAll();
    }
}
