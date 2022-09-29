package br.com.heitorsoares.IntroApp.service;

import br.com.heitorsoares.IntroApp.model.ClientModel;
import br.com.heitorsoares.IntroApp.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientServiceV2 {

    @Autowired
    private ClientRepository repository;

    public Optional<ClientModel> findById(long id){
        return repository.findById(id);
    }

    public List<ClientModel> findAll(){
        return repository.findAll();
    }

    public ClientModel save(ClientModel model){
        return repository.save(model);
    }

    public ClientModel update(ClientModel model){
        var found = repository.findById(model.getId());

        if(found.isPresent()){
            found.get().setName((model.getName()));
            found.get().setGender((model.getGender()));
            found.get().setCity((model.getCity()));
            //.. new attribute of V2
            found.get().setEmail((model.getEmail()));
            return repository.save(found.get());
        } else {
            return null;
        }
    }

    public void delete(long id){
        var found = repository.findById(id);

        if(found.isPresent()){
            repository.delete(found.get());
        }
    }

    public List<ClientModel> findByEmail(String email){
        return repository.findByEmailStartsWithIgnoreCase(email);
    }
}
