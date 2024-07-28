package com.linsir.auth.exception;

import com.linsir.base.core.code.ICode;
import com.linsir.base.core.exception.IException;

/**
 * @author linsir
 * @version 1.0.0
 * @title AuthException
 * @description
 * @create 2024/7/28 19:47
 */


public class AuthException extends RuntimeException implements IException {

    private ICode code;

    @Override
    public ICode getCode() {
        return code;
    }

    public AuthException(ICode code) {
        super(code.getMsg());
        this.code = code;
    }

    public AuthException(String message) {
        super(message);
    }


    public static AuthException authException(ICode code)
    {
        return new AuthException(code);
    }
}
