package demo.controller;

import demo.Util.DebugAgendaEventListener;
import demo.dto.ArrangementDTO;
import demo.model.Arrangement;
import demo.service.ArrangementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "api/arrangements")
public class ArrangementController {

    @Autowired
    ArrangementService arrangementService;



    @GetMapping(value = "/all")
    ResponseEntity<List<ArrangementDTO>> getAll(){
        List<Arrangement> arrangements = arrangementService.findAll();

        List<ArrangementDTO> arragementsDTO = new ArrayList<>();
        for(Arrangement a : arrangements){
            arragementsDTO.add(new ArrangementDTO(a));
        }
        return new ResponseEntity<>(arragementsDTO, HttpStatus.OK);
    }


    @GetMapping(value = "/recommend")
    ResponseEntity<List<ArrangementDTO>> getRecommend(){
        List<Arrangement> arrangements = arrangementService.findAll();

        KieServices ks = KieServices.Factory.get();
        KieContainer kieContainer = ks.getKieClasspathContainer();
        KieSession kSession = kieContainer.newKieSession("ksession-rules");

        kSession.addEventListener(new DebugAgendaEventListener());

        kSession.insert(arrangements);

        int fired = kSession.fireAllRules();



        List<ArrangementDTO> arragementsDTO = new ArrayList<>();
        for(Arrangement a : arrangements){
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
