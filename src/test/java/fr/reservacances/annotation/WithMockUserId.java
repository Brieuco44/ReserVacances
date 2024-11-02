package fr.reservacances.annotation;

import fr.reservacances.security.WithMockUserIdSecurityContextFactory;
import org.springframework.security.test.context.support.WithSecurityContext;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
@WithSecurityContext(factory = WithMockUserIdSecurityContextFactory.class)
public @interface WithMockUserId {
    String value() default "fa064aa8-80de-439e-8ab7-28084e55985c";
}
