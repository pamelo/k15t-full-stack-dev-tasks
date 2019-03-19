package com.k15t.pat.registration;

import org.apache.velocity.app.VelocityEngine;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = {RegistrationController.class})
@AutoConfigureMockMvc
public class RegistrationControllerTest {

   @Autowired
   private MockMvc mockMvc;

   @MockBean
   VelocityEngine velocityEngine;

   @MockBean
   RegistrationResource registrationResource;



    @Test
    public void testSuccessRegistration() throws Exception {
        String uri = "/registration";

        Mockito.when(registrationResource.save(requestData())).thenReturn(responseData());

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post(uri, requestData())
                .contentType(MediaType.APPLICATION_JSON)).andReturn();
                //.andExpect(MockMvcResultMatchers.status().isCreated())
                //.andExpect(MockMvcResultMatchers.jsonPath("$.id", Matchers.is(responseData().getId())))
                //.andExpect(MockMvcResultMatchers.jsonPath("$.name", Matchers.is(responseData().getName())));
        System.out.println(result.getResponse());
    }

    private Registration requestData() {
        Registration registration = new Registration();
        registration.setName("FirstName LastName");
        registration.setEmail("you.are.awsome@gmail.com");
        registration.setPassword("AverySecureP455w0rd");
        registration.setPhone("5698962541");
        registration.setAddress("123 Awesome Street, Great City, Silicone State, 12345, United States");

        return registration;
    }

    private Registration responseData() {
        Registration registration = new Registration();
        registration.setId(1);
        registration.setName("FirstName LastName");
        registration.setEmail("you.are.awsome@gmail.com");
        registration.setPassword("AverySecureP455w0rd");
        registration.setPhone("5698962541");
        registration.setAddress("123 Awesome Street, Great City, Silicone State, 12345, United States");

        return registration;
    }
}
