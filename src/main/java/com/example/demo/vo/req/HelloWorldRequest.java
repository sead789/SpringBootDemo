package com.example.demo.vo.req;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;

/**
 * @author Rising
 * @date 2019/6/11
 */
@Data
public class HelloWorldRequest {

    public Integer id;

    @NotBlank(message = "code不能为空")
    public String code;

    @Length(min = 6, message = "长度不能小于6")
    public String msg;

}
