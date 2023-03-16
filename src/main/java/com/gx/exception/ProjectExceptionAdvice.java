package com.gx.exception;

import com.baomidou.mybatisplus.extension.api.R;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.security.auth.login.AccountException;

@RestControllerAdvice
public class ProjectExceptionAdvice {
    @ExceptionHandler(com.gx.exception.SystemException.class)
    public R doSystemException(SystemException ex) {
        return R.failed("系统异常").setCode(500);
    }

    @ExceptionHandler(BusinessException.class)
    public R doBusinessException(BusinessException ex) {
        return R.failed("业务异常").setCode(500);
    }

    //@ExceptionHandler(CaptchaException.class)
    //public R doCaptchaException(CaptchaException ex) { return R.failed("验证码异常").setCode(500); }

    @ExceptionHandler(Exception.class)
    public R doException(Exception ex) { return R.failed("数据异常1").setCode(500); }
}
