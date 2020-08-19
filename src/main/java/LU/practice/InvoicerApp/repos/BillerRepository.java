package LU.practice.InvoicerApp.repos;

import LU.practice.InvoicerApp.model.Biller;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BillerRepository extends MongoRepository<Biller,String> {

    Biller findByEmail(String email);
}
