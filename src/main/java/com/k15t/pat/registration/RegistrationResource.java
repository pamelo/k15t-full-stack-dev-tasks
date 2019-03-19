package com.k15t.pat.registration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class RegistrationResource {

    Logger logger = LoggerFactory.getLogger(RegistrationResource.class);

    // Extend the current resource to receive and store the data in memory.
    // Return a success information to the user including the entered information.
    // In case of the address split the information into a better format/structure
    // for better handling later on.
    private Map<Integer, Registration> localDataStore = new HashMap<>();

    /**
     * This method takes the registration data provided by the form, clean up the data and then store it
     * */
    public Registration save(Registration registration) {
        logger.info("Begin: RegistrationResource.save() ", registration);
        if(registration != null) {
            int primaryKey = getPrimaryKey(localDataStore);
            registration.setId(primaryKey);
            registration.setFormattedAddress(formatAddress(registration.getAddress()));
            localDataStore.put(primaryKey, registration);
            return registration;
        }
        return null;
    }

    /**
     * This method assumes the address is given as comma separated values of (street, city, state, zipCode, County)
     * @param String
     * @return Address
     * */
    private Address formatAddress(String address) {
        if(StringUtils.isEmpty(address)) {
            return null;
        }
        List<String> splitAddress = address.contains(",") ? Arrays.asList(address.split(",")) : Arrays.asList(address);
        Address cleanAddress = new Address();
        cleanAddress.setStreet(splitAddress.size() > 0 ? splitAddress.get(0).trim(): "");
        cleanAddress.setCity(splitAddress.size() > 1 ? splitAddress.get(1).trim(): "");
        cleanAddress.setState(splitAddress.size() > 2 ? splitAddress.get(2).trim(): "");
        cleanAddress.setZipCode(splitAddress.size() > 3 ? splitAddress.get(3).trim(): "");
        cleanAddress.setCountry(splitAddress.size() > 4 ? splitAddress.get(4).trim(): "");
        return cleanAddress;
    }

    /**
     * This method takes the data store and returns the nex index that can be used as key
     * @param  Map
     * @return Integer
     * */
    private Integer getPrimaryKey(Map dataStore) {
        return dataStore.size() + 1;
    }


}
