package com.awt.utills.reusablecomponents;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

/**
 * @author Ankit Yadav
 */
@Inherited
@Documented
@Retention(RUNTIME)
@Target(METHOD)
public @interface Owner {

	public String name();

}
