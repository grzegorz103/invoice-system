package com.uph.tpsi.controllers;

import com.ii.uph.tpsi.models.User;
import com.ii.uph.tpsi.services.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping ("/api/users")
@CrossOrigin
public class UserController
{
        private final UserService userService;

        @Autowired
        public UserController ( UserService userService )
        {
                this.userService = userService;
        }

        @PostMapping ("/login")
        public boolean login ( String username, String password )
        {
                return userService.isLoginCorrect( username, password );
        }

        @PostMapping
        public User create ( @RequestBody User user )
        {
                return userService.create( user );
        }

        @GetMapping ("/admin")
        public Boolean hasAdminRole ()
        {
                return userService.hasAdminRole();
        }

}
