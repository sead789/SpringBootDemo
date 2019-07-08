package com.example.demo.service;

import com.example.demo.vo.req.HelloWorldRequest;

/**
 * @author Rising
 * @date 2019/6/12
 */
public interface HelloWorldService {

    /**
     * 写入测试
     *
     * @param helloWorldRequest
     * @return
     */
    int insert(HelloWorldRequest helloWorldRequest);

}
