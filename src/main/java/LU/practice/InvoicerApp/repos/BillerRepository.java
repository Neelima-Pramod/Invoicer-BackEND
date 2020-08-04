package LU.practice.InvoicerApp.repos;

import LU.practice.InvoicerApp.model.Biller;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BillerRepository extends MongoRepository<Biller,String> {
}
