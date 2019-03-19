package com.k15t.pat.registration;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.StringWriter;


@RestController
public class RegistrationController {

    @Autowired private VelocityEngine velocityEngine;
    @Autowired RegistrationResource registrationResource;


    @GetMapping("/registration.html")
    public String registration() {

        Template template = velocityEngine.getTemplate("templates/registration.vm");
        VelocityContext context = new VelocityContext();
        context.put("com/k15t/pat", new Registration());
        StringWriter writer = new StringWriter();
        template.merge(context, writer);

        return writer.toString();
    }

    @PostMapping("/registration")
    public ResponseEntity<Registration> save(@ModelAttribute @Valid  Registration registration) {
        Registration res = registrationResource.save(registration);
        if(res != null) {
            return new ResponseEntity<>(res, HttpStatus.CREATED);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
