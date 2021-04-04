package org.softwaremanager.backoffice.auth.service;

import org.softwaremanager.backoffice.auth.domain.User;
import org.softwaremanager.backoffice.auth.web.dto.UserRegistrationDto;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    User save(UserRegistrationDto registrationDto);
}