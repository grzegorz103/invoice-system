package com.uph.tpsi.services.interfaces;

import com.uph.tpsi.models.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService
{
        User create( User user);

        boolean isLoginCorrect(String username, String password);

        boolean hasAdminRole ();
}
