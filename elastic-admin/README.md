**通过实现ConstraintValidator完成自定义校验注解**

```java
/**
 * @author: lu.yongmin
 * @date: 2019/1/31 14:57
 * @description:
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class LoginVo {
    @NotNull
    private String mobile;
    private String password;

}

@Target({ElementType.METHOD,ElementType.FIELD,ElementType.ANNOTATION_TYPE,ElementType.CONSTRUCTOR, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = {MobileValidator.class})
public @interface MobileCheck {
    boolean required() default true;
    String message() default "手机号码格式有误!";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

}


/**
 * @author: lu.yongmin
 * @date: 2019/1/31 15:06
 * @description:
 */
public class MobileValidator implements ConstraintValidator<MobileCheck, String> {
    private boolean require = false;
    @Override
    public void initialize(MobileCheck isMobile) {
        require = isMobile.required();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
        if(require){
            return ValidatorUtil.isMobile(value);
        }else {
            if(StringUtils.isEmpty(value)){
                return true;
            }else{
                return ValidatorUtil.isMobile(value) ;
            }
        }
    }
}

```

1. LoginVo类为一个普通的实体类，其中mobile属性添加了自定义注解
2. Constrain 指定了校验类，值得一提的是除了自定义的message，require属性外，下面groups payload也是必须添加的。
3. ValidatorUtils为工具类
4. MobileValidator自定义注解校验类

---
校验类实现了ConstraintValidator接口
接口使用了泛型，需要指定两个参数，第一个自定义注解类，第二个为需要校验的数据类型

校验不通过，会产生BindException异常  

javaEE 6 提出了Bean Validation 规范，使用注解的方式对java Bean 进行约束验证，不局限于某一层次
，不局限于某一编程模型。



































