package com.wyh2020.fstore.base.annotation;


import com.wyh2020.fstore.base.annotation.validator.NotEmojiValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 唯一性.
 *
 */

@Constraint(validatedBy = {NotEmojiValidator.class})
@Target({ElementType.ANNOTATION_TYPE,ElementType.METHOD,ElementType.FIELD,ElementType.CONSTRUCTOR,ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface NotEmoji {
    String message();


    Class<? extends Payload>[] payload() default {};
    String field() default "";


    Class<?>[] groups() default {};

}
