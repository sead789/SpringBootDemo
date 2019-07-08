package com.example.demo.controller;

import com.example.commons.cookies.CookiesUtils;
import com.example.commons.redis.RedisUtils;
import com.example.commons.result.ResultCode;
import com.example.commons.result.ResultEntity;
import com.example.commons.result.ResultUtil;
import com.example.demo.service.HelloWorldService;
import com.example.demo.vo.req.HelloWorldRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

/**
 * http://{url}:{port}/swagger-ui.html 查看所有接口
 * classpath:/static/* 为静态资源目录
 * classpath:/templates/* 为页面存放目录
 *
 * @author Rising
 * @date 2019/7/8
 */
@Controller
public class HelloWorldController {

    @Autowired
    HelloWorldService helloWorldService;
    @Autowired
    RedisUtils redisUtils;

    /**
     * @param request
     * @return
     * @valid 请求参数验证
     * 异常统一返回（包括service层）
     * 结果返回工具返回参数
     */
    @RequestMapping(value = "hello-world", method = RequestMethod.POST)
    @ResponseBody
    public ResultEntity helloWorld(@Valid HelloWorldRequest request) {
        helloWorldService.insert(request);
        //异常统一返回测试
        //String.valueOf(null);
        return ResultUtil.setMsg(ResultCode.成功, request);
    }

    /**
     * restful 风格链接
     * 返回页面
     *
     * @param msg
     * @return
     */
    @RequestMapping(value = "hello/{msg}", method = RequestMethod.GET)
    public String hello(@PathVariable String msg) {
        System.out.println(msg);
        return "hello-world";
    }

    /**
     * redis 测试
     * 需开启redis
     *
     * @param value
     * @return
     */
    @GetMapping(value = "redis")
    @ResponseBody
    public String redis(String value, HttpServletRequest req) {
        //存储用户信息于redis中
        String cookiesId = CookiesUtils.getCookie(req, "Cookie");
        redisUtils.set(cookiesId, value);
        return "hello-world";
    }

}
