package com.example.demoDBBoot.repo;

import com.example.demoDBBoot.entity.Register;
import org.springframework.data.repository.CrudRepository;

public interface RegisterRepo extends CrudRepository<Register, Long> {
}
