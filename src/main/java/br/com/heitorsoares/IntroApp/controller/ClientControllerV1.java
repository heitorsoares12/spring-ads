package br.com.heitorsoares.IntroApp.controller;

import br.com.heitorsoares.IntroApp.model.ClientModel;
import br.com.heitorsoares.IntroApp.service.ClientServiceV1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/clients/v1")
public class ClientControllerV1 {

    @Autowired
    private ClientServiceV1 service;

    @GetMapping("/{id}")
    public Optional<ClientModel> findById(@PathVariable("id") long id){
        return service.findById(id);
    }

    @GetMapping
    public List<ClientModel> findAll(){
        return  service.findAll();
    }

    @PostMapping
    public ClientModel save(@RequestBody ClientModel model){
        return service.save(model);
    }

    @PutMapping
    public ClientModel update(@RequestBody ClientModel model) {
        return service.update(model);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") long id){
        var found = service.findById(id);
        if(found.isPresent()){
            service.delete(id);
            return ResponseEntity.ok().build();
        } else {
            return null;
        }
    }
}
