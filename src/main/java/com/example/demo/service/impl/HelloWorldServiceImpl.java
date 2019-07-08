package com.example.demo.service.impl;

import com.example.demo.mapper.HelloWorldMapper;
import com.example.demo.service.HelloWorldService;
import com.example.demo.vo.req.HelloWorldRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Rising
 * @date 2019/6/11
 */
@Service
@Transactional
public class HelloWorldServiceImpl implements HelloWorldService {

    @Autowired
    HelloWorldMapper helloWorldMapper;

    @Override
    public int insert(HelloWorldRequest request) {
        int result = helloWorldMapper.insert(request);
        System.out.println("写入结果：" + result);
        //异常统一返回测试
        //String.valueOf(null);
        return result;
    }

}
