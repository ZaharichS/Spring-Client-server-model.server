package com.example.demoDBBoot.controller;

import com.example.demoDBBoot.entity.Register;
import com.example.demoDBBoot.repo.RegisterRepo;
import com.example.demoDBBoot.responses.DataBaseResponse;
import com.example.demoDBBoot.responses.RegisterResponse;
import com.example.demoDBBoot.service.RegisterService;
import org.apache.catalina.connector.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/register")
public class RegisterController {
    private RegisterService service;
    private RegisterController(RegisterService service) { this.service = service; }

    @GetMapping("/all")
    public ResponseEntity<DataBaseResponse> getAll() {
        return ResponseEntity.ok( new RegisterResponse((service.getAll())));
    }
    @PostMapping("/add")
    public ResponseEntity<DataBaseResponse> registration(@RequestBody Register data) {
        try {
            service.save(data);
            return ResponseEntity.ok(new DataBaseResponse(true, "Полёт добавлен"));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(new DataBaseResponse(false, e.getMessage()));
        }
    }
    @GetMapping("find")
    public ResponseEntity<DataBaseResponse> find(@RequestParam Long id)  {
        try {
            if (service.findById(id).isPresent()) {
                service.findById(id).get();
                System.out.println(service.findById(id).get()); // временное отображение данных по id в консоль
                return ResponseEntity.ok(new DataBaseResponse(true, "Полёт найден"));
            } else  {
                return ResponseEntity.badRequest().body(new DataBaseResponse(false, "Полёт не найден!"));
            }
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(new DataBaseResponse(false, e.getMessage()));
        }
    }
    @PostMapping("/update")
    public ResponseEntity update(@RequestBody Register data) {
        try {
            if (data.getId() != null) {
                service.save(data);
            }
            return ResponseEntity.ok(new DataBaseResponse(true, "В рейс были внесены изменения"));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(new DataBaseResponse(false, e.getMessage()));
        }
    }
    @DeleteMapping("/delete")
    public ResponseEntity delete(@RequestParam Long id) {
        try {
            service.delete(id);
            return ResponseEntity.ok(new DataBaseResponse(true, "Рейс был удален"));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(new DataBaseResponse(false, e.getMessage()));
        }
    }
}
