package org.garlikoff.controller;

import lombok.extern.slf4j.Slf4j;
import org.garlikoff.model.AbstractInterface;
import org.garlikoff.model.UniversalTransport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
/*import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;*/
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@Slf4j
public class SampleController {

    @Autowired
    ApplicationContext context;
    @GetMapping("/anonymous")
    public String getAnonymousInfo() {

      /*  AbstractInterface svc = (AbstractInterface) context.getBean("temp");
        svc.run("2");
        svc = (AbstractInterface) context.getBean("temp2");
        svc.run("3");
*/
        return "Anonymous";
    }
    @PostMapping("/send")
    public void sendObject(@RequestBody UniversalTransport msg) {
        log.info("asfdgsfdgdsfgfdsfdgsfd");
        AbstractInterface svc = (AbstractInterface) context.getBean("temp");
        svc.run(msg);
        svc = (AbstractInterface) context.getBean("temp2");
        svc.run(msg);

    }
    @GetMapping("/user")
    @PreAuthorize("hasRole('USER')")
    public String getUserInfo() {
        return "user info";
    }

/*

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
        final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication.getName();
    }

    @GetMapping("/me2")
    public Authentication whoAmI(){
        SecurityContext context = SecurityContextHolder.getContext();
        return context.getAuthentication();
    }
*/
}

