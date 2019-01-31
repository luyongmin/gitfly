package com.example.admin.pojo;

import com.example.admin.validator.MobileCheck;
import lombok.*;

import javax.validation.constraints.NotNull;

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
    @MobileCheck
    private String mobile;
    private String password;

}
