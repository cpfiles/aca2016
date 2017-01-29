package edu.uca.aca2016.validation;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import org.springframework.stereotype.Component;

import edu.uca.aca2016.objects.Artist;
import java.util.logging.Logger;

@Component
public class ArtistValidator implements Validator {
    
    private static final Logger logger = Logger.getLogger(ArtistValidator.class.getName());

	@Override
	public boolean supports(Class<?> clazz) {
		return Artist.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "artist.name.required");
        
        Artist artist = (Artist)target;
		if(artist.getName().length() > 120) {
			errors.rejectValue("name","artist.name.length");
		}
	}
}
