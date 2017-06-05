package com.jsonaop.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


/**
*
* @author ZZD
* @time 17/6/5 下午2:51
*/

@Retention(RetentionPolicy.CLASS)//编译器还是运行期
@Target(ElementType.METHOD)
public @interface BehaviorTrace {
    String value();
}
