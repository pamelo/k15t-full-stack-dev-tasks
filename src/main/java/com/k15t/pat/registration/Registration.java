package com.k15t.pat.registration;

import org.hibernate.validator.constraints.Email;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class Registration {

    private int id;

    @NotNull
    @Pattern(regexp = "[a-zA-Z ]+", message = "Name must not contain numbers")
    @Size(max = 100, message = "Name must not surpass 100 characters")
    private String name;

    @NotNull
    @Pattern(regexp = "[a-zA-Z0-9]{8,20}", message = "Password must be alpha-numeric, and must be between 8-20 characters")
    private String password;

    @Size(max = 100,  message = "Address must follow this format: 123 street name, city name, state name, zip code, country")
    private String address;

    @NotNull
    @Email
    @Size(max = 100, message = "Email must not surpass 100 characters")
    private String email;

    @NotNull
    @Pattern(regexp = "[0-9]{9,15}", message = "Phone must be between 9 to 15 characters")
    private String phone;

    private Address formattedAddress;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Address getFormattedAddress() {
        return formattedAddress;
    }

    public void setFormattedAddress(Address formattedAddress) {
        this.formattedAddress = formattedAddress;
    }

    @Override
    public String toString() {
        return "Registration{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", formattedAddress=" + formattedAddress +
                '}';
    }
}
