package br.com.heitorsoares.IntroApp.repository;

import br.com.heitorsoares.IntroApp.model.ClientModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ClientRepository extends JpaRepository<ClientModel, Long> {

    Optional<ClientModel> findById(long id);

    List<ClientModel> findByNameContainsIgnoreCaseOrderByName(String name);

    //..new methods of v2
    List<ClientModel> findByEmailStartsWithIgnoreCase(String email);
}
