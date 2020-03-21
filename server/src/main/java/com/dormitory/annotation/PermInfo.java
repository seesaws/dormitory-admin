package com.dormitory.annotation;

/**
 * @ClassName PermInfo
 * @Description 注释
 * @Author CoderL
 * @Date 2020/2/28 15:01
 **/
import java.lang.annotation.*;

@Target({ElementType.TYPE,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface PermInfo {

    /**
     * 权限值
     * @return
     */
    String pval() default "";

    /**
     * 权限名称
     * pname的别名
     * @return
     */
    String value() default "";

}
