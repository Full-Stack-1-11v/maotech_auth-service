package cl.mao_tech.auth_service.service;

import cl.mao_tech.auth_service.model.User;
import cl.mao_tech.auth_service.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@Transactional
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String mail) throws UsernameNotFoundException {
        User user = userRepository.findByMail(mail);
        if (user == null){
            throw new UsernameNotFoundException("Mail Not Found");
        }
        return new org.springframework.security.core.userdetails.User(user.getMail(), user.getPassword(), new ArrayList<>());
    }
}
