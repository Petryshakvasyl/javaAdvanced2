package ua.lviv.lgs.spring.service.impl;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ua.lviv.lgs.spring.domain.User;
import ua.lviv.lgs.spring.repository.UserRepository;
import ua.lviv.lgs.spring.service.mapper.UserMapper;

import javax.transaction.Transactional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;

    private final UserMapper mapper;

    public UserDetailsServiceImpl(UserRepository userRepository, UserMapper mapper) {
        this.userRepository = userRepository;
        this.mapper = mapper;
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(name).orElseThrow(
                () -> new UsernameNotFoundException("Not found user with name " + name));
        return mapper.toUserDetails(user, true);
    }

}
