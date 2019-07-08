package com.example.demo.mapper;

import com.example.demo.vo.req.HelloWorldRequest;

/**
 * @author Rising
 * @date 2019/6/11
 */
public interface HelloWorldMapper {

    /**
     * 写入entity测试
     *
     * @param request
     * @return
     */
    int insert(HelloWorldRequest request);

}
