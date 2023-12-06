package pgdp.hello;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import de.tum.in.test.api.*;

@MirrorOutput
@StrictTimeout(2)
@Deadline("2022-10-29 18:00 Europe/Berlin")
@ActivateHiddenBefore("2022-10-19 16:00 Europe/Berlin")
@WhitelistPath(value = "../pgdp2223*w01h01**", type = PathType.GLOB) // for manual assessment and development
@WhitelistPath("target") // mainly for Artemis
@BlacklistPath(value = "{test,target/test}**Test*.{java,class}", type = PathType.GLOB)
@Documented
@Retention(RUNTIME)
@Target({ TYPE, ANNOTATION_TYPE })
public @interface W01H01 {
    // meta annotation
}
