package org.garlikoff.user;

import lombok.Data;
import org.keycloak.KeycloakPrincipal;
import org.keycloak.KeycloakSecurityContext;
import org.keycloak.representations.AccessToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.ArrayList;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

@Data
public class UserDetails {

    private String username;
    private ArrayList<String> roles;

    public UserDetails(){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        KeycloakPrincipal principal2 = (KeycloakPrincipal)auth.getPrincipal();
        KeycloakSecurityContext session = principal2.getKeycloakSecurityContext();
        AccessToken accessToken = session.getToken();

        username = accessToken.getPreferredUsername();
        roles = new ArrayList<>(new ArrayList<>(accessToken.getRealmAccess().getRoles()));
    }
}
