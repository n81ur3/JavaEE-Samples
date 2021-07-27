package com.example.MyWebApp.validation;

import com.example.MyWebApp.service.UserService;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import javax.inject.Inject;

@FacesValidator(value="com.example.MyWebApp.validation.UniqueEmailValidator", managed = true)
public class UniqueEmailValidator implements Validator<String> {

    @Inject
    private UserService userService;

    @Override
    public void validate(FacesContext context, UIComponent component, String email) throws ValidatorException {

        if (email == null || email.isEmpty()) {
            return; // Let @NotNull or required=true handle this.
        }

        String oldEmail = (String) ((UIInput) component).getValue();

        if (!email.equals(oldEmail) && userService.exist(email)) {
            throw new ValidatorException(new FacesMessage("Email already in use"));
        }
    }
}
