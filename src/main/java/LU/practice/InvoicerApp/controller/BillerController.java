package LU.practice.InvoicerApp.controller;

import LU.practice.InvoicerApp.model.Biller;
import LU.practice.InvoicerApp.repos.BillerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin
@RestController
public class BillerController {

    @GetMapping(value ="/add")
    public int add()
    {
        return 5;
    }
    @GetMapping(value="/addTwo/{num1}/{num2}")
    public int addTwo(@PathVariable("num1") int a, @PathVariable("num2") int b){
        return a+b;
    }
    @GetMapping(value="/addThree")
    public int addThree(@RequestParam(value="num1") int a, @RequestParam(value="num2") int b){
        return  a+b;
    }

    @Autowired
    private BillerRepository billerRepository;

    @GetMapping(value = "getOne/{id}")
    public Biller getOne(@PathVariable String id)
    {
        return billerRepository.findById(id).get();
    }
    @GetMapping(value = "getAll")
    public List<Biller> getAll()
    {
        return billerRepository.findAll();
    }
    @PostMapping(value = "saveBiller")
    public Biller saveBiller(@RequestBody Biller biller)
    {
        return billerRepository.save(biller);
    }

    @PutMapping(value = "/{id}")
    public Biller update(@PathVariable String id, @RequestBody Biller biller) {
        Biller biller1 = billerRepository.findById(id)
                .orElseThrow();
        biller1.setPhoneNumber(biller.getPhoneNumber());
        biller1.setEmail(biller.getEmail());

        return billerRepository.save(biller1);
    }

    @DeleteMapping(value = "delete/{id}")
    public void delete(@PathVariable String id) {
        Biller biller = billerRepository.findById(id)
                .orElseThrow();
        billerRepository.delete(biller);
    }



}
