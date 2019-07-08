package com.example.commons.result;

/**
 * 统一返回工具类
 *
 * @author Rising
 * @date 2019/6/21
 */
public class ResultUtil {

    public static ResultEntity setMsg(ResultCode e) {
        return new ResultEntity(e.getCode(), e.name(), null);
    }

    public static ResultEntity setMsg(ResultCode e, String msg) {
        return new ResultEntity(e.getCode(), msg, null);
    }

    public static ResultEntity setMsg(ResultCode e, Object obj) {
        return new ResultEntity(e.getCode(), e.name(), obj);
    }

    public static ResultEntity setMsg(Object obj) {
        return new ResultEntity(ResultCode.成功.toString(), ResultCode.成功.getCode(), obj);
    }

}
