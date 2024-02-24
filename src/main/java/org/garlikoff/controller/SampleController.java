package org.garlikoff.controller;

import org.keycloak.KeycloakPrincipal;
import org.keycloak.KeycloakSecurityContext;
import org.keycloak.adapters.springsecurity.token.KeycloakAuthenticationToken;
import org.keycloak.representations.AccessToken;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

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

    @GetMapping("/me")
    public Object getMe() {
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
