package com.example.demoDBBoot.controller;

import com.example.demoDBBoot.entity.Register;
import com.example.demoDBBoot.repo.RegisterRepo;
import com.example.demoDBBoot.responses.CheckResponse;
import com.example.demoDBBoot.responses.DataBaseResponse;
import com.example.demoDBBoot.responses.RefreshResponse;
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
        return ResponseEntity.ok( new RegisterResponse(true, "Полеты", service.getAll()));
    }
    @PostMapping("/add")
    public ResponseEntity<DataBaseResponse> registration(@RequestBody Register data) {
        try {
            if (service.findById(data.getId()).isEmpty()) {
                Register reg = service.save(data);
                return ResponseEntity.ok(new RefreshResponse(true, "da", reg));
                //return ResponseEntity.ok(new RefreshResponse(true, "Полет добавлен", reg.getId()));
            } else  {
                return ResponseEntity.badRequest().body(new RefreshResponse(false, "Полет не был добавлен", null));
            }
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(new  RefreshResponse(true, "Полет не был добавлен",  null));
        }
    }
    @GetMapping("/find{id}")
    public ResponseEntity<DataBaseResponse> find(@RequestParam long id)  {
        try {
            if (service.findById(id).isPresent()) {
                service.findById(id).get();
                System.out.println(service.findById(id).get());
                return ResponseEntity.ok( new CheckResponse(service.findById(id)));
            } else  {
                return ResponseEntity.badRequest().body(new DataBaseResponse(false, "Полёт не найден!"));
            }
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(new DataBaseResponse(false, e.getMessage()));
        }
    }
   /*@PutMapping("/update/{id}")
    public ResponseEntity<DataBaseResponse> update(@RequestBody Register data, @PathVariable(value = "id") String id) {
        try {
            if (service.findById(data.getId()).isEmpty()) {
                Register updateReg = registerRepo.findById(Long.valueOf(id))
                        .orElseThrow();

                updateReg.setNumFlight(data.getNumFlight());
                updateReg.setTrip(data.getTrip());
                updateReg.setStopoverPoints(data.getStopoverPoints());
                updateReg.setTimeFlight(data.getTimeFlight());
                updateReg.setDayFlight(data.getDayFlight());
                updateReg.setAvailabilitySeatsFlight(data.getAvailabilitySeatsFlight());

                service.findById(Long.valueOf(id)).get();
                registerRepo.save(updateReg);
                System.out.println(service.findById(Long.valueOf(id)).get()); // временное отображение данных по id в консоль
                return ResponseEntity.ok(new DataBaseResponse(true, "Полёт изменен"));
            } else  {
                return ResponseEntity.badRequest().body(new DataBaseResponse(false, "Полёт не был найден и не был изменен!"));
            }
                //service.save(data);
                //return ResponseEntity.ok(new DataBaseResponse(true, "В рейс были внесены изменения"));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(new DataBaseResponse(false, e.getMessage()));
        }
    }*/

    @PostMapping("/update")
    public ResponseEntity<DataBaseResponse> update(@RequestBody Register data) {
        try {
            if (service.findById(data.getId()).isPresent()) {
                Register reg = service.save(data);
                return ResponseEntity.ok(new RefreshResponse(true, "Полет изменен", reg));
            } else {
                return ResponseEntity.badRequest().body(new RefreshResponse(false, "Полет не изменен", null));
            }
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(new RefreshResponse(false, e.getMessage(), null));
        }
    }

    @DeleteMapping("/delete{id}")
    public ResponseEntity delete(@RequestParam long id) {
        try {
            service.delete(id);
            return ResponseEntity.ok(new DataBaseResponse(true, "Рейс был удален"));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(new DataBaseResponse(false, e.getMessage()));
        }
    }
}
