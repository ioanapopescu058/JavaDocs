package ro.teamnet.zth.api.annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created by Ioana.Popescu on 7/12/2017.
 */
@Target(FIELD)
@Retention(RUNTIME)
public @interface Column {

    String name() default "";
}
