package LU.practice.InvoicerApp.service;

import java.util.ArrayList;

import LU.practice.InvoicerApp.model.Biller;
import LU.practice.InvoicerApp.repos.BillerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class JWTBillerDetailsService  implements UserDetailsService{

    @Autowired
    private BillerRepository billerRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Biller billerByEmail = billerRepository.findByEmail(username);

        if (billerByEmail==null) {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
        return new User(billerByEmail.getEmail(),billerByEmail.getPassword(), new ArrayList<>());
    }
}
