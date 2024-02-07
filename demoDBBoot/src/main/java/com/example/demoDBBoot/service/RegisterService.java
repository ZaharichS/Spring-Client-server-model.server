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

    public void save(Register registerFlight) {
        repo.save(registerFlight);
    }
    public void delete(Long id) {
        repo.deleteById(id);
    }
    public void findById(Long id  /*,Register register*/) {
        repo.findById(id);
    }
    public Iterable<Register> getAll() {
        return repo.findAll();
    }
}
