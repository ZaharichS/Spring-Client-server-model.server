package com.example.demoDBBoot.service;


import com.example.demoDBBoot.entity.Register;
import com.example.demoDBBoot.repo.RegisterRepo;
import org.springframework.stereotype.Service;

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
    public Iterable<Register> getAll() {
        return repo.findAll();
    }
}
