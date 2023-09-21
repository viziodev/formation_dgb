package com.dgb.formation_dgb.validators;

import com.dgb.formation_dgb.repositories.FournisseurRepository;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ListIdExistConstraintValidator implements ConstraintValidator<ListIdExistConstraint, List<Long>> {
    @Autowired
    private FournisseurRepository fournisseurRepository;
    @Override
    public boolean isValid(List<Long> value, ConstraintValidatorContext constraintValidatorContext) {
        if (value==null) return false;
        boolean b = value
                .stream()
                .map(idFour -> fournisseurRepository.findById(idFour))
                .filter(four -> four.isEmpty())
                .count() == 0;
        return b;


    }
}
