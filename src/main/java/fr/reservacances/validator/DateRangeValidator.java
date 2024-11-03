package fr.reservacances.validator;

import fr.reservacances.request.vol.CreateOrUpdateVolRequest;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.time.LocalDateTime;

public class DateRangeValidator implements ConstraintValidator<ValidDateRange, CreateOrUpdateVolRequest> {

    @Override
    public boolean isValid(CreateOrUpdateVolRequest obj, ConstraintValidatorContext context) {
        LocalDateTime dateDepart = obj.getDateDebut();
        LocalDateTime dateArrivee = obj.getDateFin();

        if (dateDepart == null || dateArrivee == null) {
            return true; // Laissez d'autres annotations gérer les valeurs null si nécessaire
        }

        return dateDepart.isBefore(dateArrivee);
    }
}
