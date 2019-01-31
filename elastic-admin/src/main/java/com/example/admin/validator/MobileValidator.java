package com.example.admin.validator;

import com.example.admin.util.ValidatorUtil;
import org.springframework.util.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

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
