package LU.practice.InvoicerApp.controller;

import LU.practice.InvoicerApp.model.Biller;
import LU.practice.InvoicerApp.model.BillerJwtLoginRequest;
import LU.practice.InvoicerApp.model.BillerJwtResponse;
import LU.practice.InvoicerApp.repos.BillerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import LU.practice.InvoicerApp.configuration.JwtTokenUtil;
import LU.practice.InvoicerApp.service.JWTBillerDetailsService;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.context.annotation.Bean;

import java.util.List;

@CrossOrigin
@RestController
public class BillerController {

    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Autowired
    private JWTBillerDetailsService userDetailsService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private BillerRepository billerRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping(value="/api/biller/login")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody BillerJwtLoginRequest billerLoginRequest) throws Exception
    {
        authenticate(billerLoginRequest.getUsername(), billerLoginRequest.getPassword());

        UserDetails userDetails = userDetailsService
                .loadUserByUsername(billerLoginRequest.getUsername());
        String token = jwtTokenUtil.generateToken(userDetails.getUsername());
        return ResponseEntity.ok(new BillerJwtResponse(token));
    }

    private void authenticate(String username, String password) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (DisabledException e) {
            throw new Exception("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }
    }

    //Get Request
    @GetMapping(value = "biller/{id}")
    public Biller getOne(@PathVariable String id)
    {
        return billerRepository.findById(id).get();
    }

    @GetMapping(value = "/biller")
    public List<Biller> getAll()
    {
        return billerRepository.findAll();
    }


    //Post Request
    @PostMapping(value = "/api/biller")
    public Biller saveBiller(@RequestBody Biller biller)
    {
        biller.setPassword(passwordEncoder.encode(biller.getPassword()));
        return billerRepository.save(biller);
    }



    //To Update biller
    @PutMapping(value = "/{id}")
    public Biller update(@PathVariable String id, @RequestBody Biller biller) {
        Biller biller1 = billerRepository.findById(id)
                .orElseThrow();
        biller1.setPhoneNumber(biller.getPhoneNumber());
        biller1.setEmail(biller.getEmail());

        return billerRepository.save(biller1);
    }

    //To delete Biller
    @DeleteMapping(value = "delete/{id}")
    public void delete(@PathVariable String id) {
        Biller biller = billerRepository.findById(id)
                .orElseThrow();
        billerRepository.delete(biller);
    }



}
