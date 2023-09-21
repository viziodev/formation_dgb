package com.dgb.formation_dgb.validators;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Constraint(validatedBy = ListIdExistConstraintValidator.class)
@Retention(RetentionPolicy.RUNTIME)
public @interface ListIdExistConstraint {
    String message() default "Au moins un identifiant n'existe Pas ";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

}
