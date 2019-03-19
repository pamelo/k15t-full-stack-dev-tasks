---

## Implementation details of the project k15t-full-stack-dev-tasks

---

### Changes made during development

1 - **registration.vm**

On this file, I used some bootstrap classes(ie: form-group, formControl, container) to make the input fields look nicer;
and then I added the field definitions and validations

2 - **RegistrationResource.java**

This file had annotations such as ```@Path, @Component```, I removed those annotations and replaced them with ```@service``` 
so that it can behave as storage layer interface. In here I implemented the logic to store the data provided by the form.

In terms of data store, I could have added an in-memory sql database dependency (ie: h2) for store the registration data; 
but since it is only one model/entity, I decided to store the data as (key,value) pair which why you see the ```Map<Integer, Registration```
declared and used instead of sql.

3 - **RegistrationController.java**

In this class I implemented the rest endpoint that will capture the form data. Once the endpoint gets a request, it forward
the registration data to the service layer which will store the data into the database.