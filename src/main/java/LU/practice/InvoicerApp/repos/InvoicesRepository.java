package LU.practice.InvoicerApp.repos;

import LU.practice.InvoicerApp.model.Biller.Biller;
import LU.practice.InvoicerApp.model.Invoices.Invoices;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InvoicesRepository extends MongoRepository<Invoices,String> {
    long countByCreatedBy(String id);
}
