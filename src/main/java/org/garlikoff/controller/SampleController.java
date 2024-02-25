package org.garlikoff.controller;

import org.garlikoff.data.Menu;
import org.garlikoff.data.RoleAccess;
import org.garlikoff.data.repository.RoleAccessRepository;
import org.garlikoff.user.UserDetails;
import org.keycloak.KeycloakPrincipal;
import org.keycloak.KeycloakSecurityContext;
import org.keycloak.adapters.springsecurity.token.KeycloakAuthenticationToken;
import org.keycloak.representations.AccessToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class SampleController {

    @GetMapping("/anonymous")
    public String getAnonymousInfo() {
        return "Anonymous";
    }

    @GetMapping("/user")
    @PreAuthorize("hasRole('USER')")
    public String getUserInfo() {
        return "user info";
    }

    @GetMapping("/admin")
    @PreAuthorize("hasRole('ADMIN')")
    public String getAdminInfo() {
        return "admin info";
    }

    @GetMapping("/service")
    @PreAuthorize("hasRole('SERVICE')")
    public String getServiceInfo() {
        return "service info";
    }

    @Autowired
    RoleAccessRepository roleAccessRepository;
    @GetMapping("/me")
    public Object getMe() {
        UserDetails user = new UserDetails();

        user.getRoles().forEach(role -> {
            Optional<RoleAccess> rr = roleAccessRepository.findById(role);
            //System.out.println(rr.stream().map(RoleAccess::getName));
            //System.out.println(rr.orElseGet( r-> r.getMenu().getName()));
            Optional<Menu> menu = rr.map(RoleAccess::getMenu);
            System.out.println(menu.map(Menu::getName));
        });


        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        KeycloakPrincipal principal2 = (KeycloakPrincipal)auth.getPrincipal();
        KeycloakSecurityContext session = principal2.getKeycloakSecurityContext();
        AccessToken accessToken2 = session.getToken();
        return accessToken2.getPreferredUsername();

    }

    @GetMapping("/me2")
    public String whoAmI(Principal principal){

      KeycloakAuthenticationToken keycloakAuthenticationToken = (KeycloakAuthenticationToken) principal;
        AccessToken accessToken = keycloakAuthenticationToken.getAccount().getKeycloakSecurityContext().getToken();
        return accessToken.getPreferredUsername();
    }
}
