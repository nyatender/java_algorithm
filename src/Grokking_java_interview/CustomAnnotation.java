package Grokking_java_interview;

import java.lang.annotation.Documented;

public class CustomAnnotation {
}

// Creates an annotation which can be used to specify
// the longitude and latitude.
@Documented
@interface Location {

    // We provide a default value of 0
    double longitude() default 0;
    double latitude() default 0;
}

@Location(longitude = 37.400214, latitude = -121.943682)
class MySuperClass {
    // Your awesome code here
}