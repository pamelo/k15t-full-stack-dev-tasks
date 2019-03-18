package com.k15t.pat.registration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.core.Response;


@RestController
@RequestMapping("/registration")
public class RegistrationResource {

    Logger logger = LoggerFactory.getLogger(RegistrationResource.class);

    // Extend the current resource to receive and store the data in memory.
    // Return a success information to the user including the entered information.
    // In case of the address split the information into a better format/structure
    // for better handling later on.
    @PostMapping
    public Response save(@ModelAttribute Registration registration) {
        logger.info("Begin: RegistrationResource.save() ", registration);
        return Response.ok().build();
    }


}
