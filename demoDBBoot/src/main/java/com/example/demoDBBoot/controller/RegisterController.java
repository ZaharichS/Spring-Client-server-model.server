package com.example.demoDBBoot.controller;

import com.example.demoDBBoot.entity.Register;
import com.example.demoDBBoot.repo.RegisterRepo;
import com.example.demoDBBoot.responses.CheckResponse;
import com.example.demoDBBoot.responses.DataBaseResponse;
import com.example.demoDBBoot.responses.RegisterResponse;
import com.example.demoDBBoot.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.xml.crypto.Data;

@RestController
@RequestMapping("api/v1/register")
public class RegisterController {
    private RegisterService service;
    private RegisterController(RegisterService service) { this.service = service; }

    @Autowired
    private RegisterRepo registerRepo;

    @GetMapping("/all")
    public ResponseEntity<DataBaseResponse> getAll() {
        return ResponseEntity.ok( new RegisterResponse((service.getAll())));
    }
    @PostMapping("/add")
    public ResponseEntity<DataBaseResponse> registration(@RequestBody Register data) {
        try {
            if (service.findById(data.getId()).isEmpty()) {
                service.save(data);
                return ResponseEntity.ok(new DataBaseResponse(true, "Полёт добавлен"));
            } else  {
                return ResponseEntity.badRequest().body(new DataBaseResponse(false, "Полёт не найден!"));
            }
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(new DataBaseResponse(false, e.getMessage()));
        }
    }
    @GetMapping("/find")
    public ResponseEntity<DataBaseResponse> find(@RequestParam long id)  {
        try {
            if (service.findById(id).isPresent()) {
                service.findById(id).get();
                System.out.println(service.findById(id).get()); // временное отображение данных по id в консоль
                //return ResponseEntity.ok(new DataBaseResponse(true, "Полёт найден"));
                return ResponseEntity.ok( new CheckResponse( service.findById(id) ));
            } else  {
                return ResponseEntity.badRequest().body(new DataBaseResponse(false, "Полёт не найден!"));
            }
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(new DataBaseResponse(false, e.getMessage()));
        }
    }
   @PutMapping("/update{id}")
    public ResponseEntity<DataBaseResponse> update(@RequestBody Register data, @RequestParam long id) {
        try {
            if (/*service.findById(id).isPresent()*/ service.findById(data.getId()).isEmpty()) {
                Register updateReg = registerRepo.findById(id)
                        .orElseThrow();

                updateReg.setNumFlight(data.getNumFlight());
                updateReg.setTrip(data.getTrip());
                updateReg.setStopoverPoints(data.getStopoverPoints());
                updateReg.setTimeFlight(data.getTimeFlight());
                updateReg.setDayFlight(data.getDayFlight());
                updateReg.setAvailabilitySeatsFlight(data.getAvailabilitySeatsFlight());

                service.findById(id).get();
                registerRepo.save(updateReg);
                System.out.println(service.findById(id).get()); // временное отображение данных по id в консоль
                return ResponseEntity.ok(new DataBaseResponse(true, "Полёт изменен"));
            } else  {
                return ResponseEntity.badRequest().body(new DataBaseResponse(false, "Полёт не был найден и не был изменен!"));
            }
                //service.save(data);
                //return ResponseEntity.ok(new DataBaseResponse(true, "В рейс были внесены изменения"));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(new DataBaseResponse(false, e.getMessage()));
        }
    }
/*@PutMapping("{id}")
public ResponseEntity update(@RequestBody Register data, @PathVariable long id) {
    try {
        Register updateReg = registerRepo.findById(id)
                        .orElseThrow();
        updateReg.setTimeFlight(data.getTimeFlight());

        registerRepo.save(updateReg);
        return ResponseEntity.ok(updateReg);
*//*        if (data.getId() != null) {
            service.save(data);
            return ResponseEntity.ok(new DataBaseResponse(true, "В рейс были внесены изменения"));
        } else  {
            return ResponseEntity.badRequest().body(new DataBaseResponse(false, "рейс не найден!"));
        }*//*

    } catch (Exception e) {
        return ResponseEntity.badRequest().body(new DataBaseResponse(false, e.getMessage()));
    }
}*/
    @DeleteMapping("/delete")
    public ResponseEntity delete(@RequestParam long id) {
        try {
            service.delete(id);
            return ResponseEntity.ok(new DataBaseResponse(true, "Рейс был удален"));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(new DataBaseResponse(false, e.getMessage()));
        }
    }
}
