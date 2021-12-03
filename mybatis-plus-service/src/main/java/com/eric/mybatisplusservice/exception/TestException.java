package com.eric.mybatisplusservice.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;

/**
 * TestException
 *
 * @author ericzhang 2021/11/17 9:59 下午
 */
@ControllerAdvice
public class TestException extends RuntimeException{

    public TestException(){
        this.msg = msg;
        this.condition = condition;
    }

    private String msg;
    private Boolean condition;

    public TestException(Throwable cause, Boolean aTrue) {
        this.condition = aTrue;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
