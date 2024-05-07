package com.example.springboot.Controller;

import com.example.springboot.DTO.ArrangementDTO;
import com.example.springboot.Service.ArragementService;
import com.example.springboot.model.Arrangement;
import org.kie.api.KieServices;
import org.kie.api.event.rule.DebugAgendaEventListener;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/api/arrangements")
public class ArragementsController {
    @Autowired
    ArragementService arrangementService;

    @GetMapping(value = "/")
    ResponseEntity<List<ArrangementDTO>> getAll(){
        List<Arrangement> arrangements = arrangementService.findAll();

        List<ArrangementDTO> arragementsDTO = new ArrayList<>();
        for(Arrangement a : arrangements){
            arragementsDTO.add(new ArrangementDTO(a));
        }
        return new ResponseEntity<>(arragementsDTO, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    ResponseEntity<ArrangementDTO> getOne(@PathVariable int id){
        Arrangement arrangement = arrangementService.findOne(id);
        if(arrangement != null){
            return new ResponseEntity<>(new ArrangementDTO(arrangement), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @GetMapping(value = "/recommend")
    ResponseEntity<List<ArrangementDTO>> getRecommend(){
        List<Arrangement> arrangements = arrangementService.findAll();
        ArrayList<Arrangement> popular = new ArrayList<>();
        KieServices ks = KieServices.Factory.get();
        KieContainer kieContainer = ks.getKieClasspathContainer();
        KieSession kSession = kieContainer.newKieSession("ksession-rules");

        kSession.addEventListener(new DebugAgendaEventListener());
        kSession.setGlobal("preporuceniAranzmani", popular);

        for (Arrangement a : arrangements) {
            kSession.insert(a);
        }

        int fired = kSession.fireAllRules();

        System.out.println("Fired: " + popular.size());
        System.out.println("Fired: " + arrangements.size());

        List<ArrangementDTO> arragementsDTO = new ArrayList<>();
        for(Arrangement a : popular){
            arragementsDTO.add(new ArrangementDTO(a));
        }
        return new ResponseEntity<>(arragementsDTO, HttpStatus.OK);
    }





    @PostMapping(value = "/add")
    public ResponseEntity<ArrangementDTO> addArrangement(@RequestBody ArrangementDTO arrangementDTO) {
        ArrangementDTO savedArrangementDTO = arrangementService.addArrangement(arrangementDTO);
        if (savedArrangementDTO != null) {
            return new ResponseEntity<>(savedArrangementDTO, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
