package com.codeshare.permission.common.exception;

import com.codeshare.common.JsonUtils;
import com.codeshare.permission.common.ResponseVo;

import io.jsonwebtoken.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageConversionException;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

import static com.codeshare.permission.common.ResponseConstant.*;

/**
 * 统一异常处理，只会处理没有被try catch的异常，如果异常被捕获是不生效的
 *
 * @author cjbi
 */
@ResponseBody
@ControllerAdvice
public class DefaultExceptionHandler {

    public static final Logger LOGGER = LoggerFactory.getLogger(DefaultExceptionHandler.class);

    /**
     * @param e
     * @return
     */
    @ExceptionHandler({Throwable.class})
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseVo<Object> handlerThrowable(HttpServletRequest request, Throwable e) {
        LOGGER.error("Execute method exception error.Url is {}", request.getRequestURI(), e);
        return ResponseVo.failure(e, FAILED.intValue(), FAILED_MSG, e.getClass().getName() + ": " + e.getMessage());
    }

    /**
     * 业务异常
     *
     * @param e
     * @return
     */
    @ExceptionHandler({BusinessException.class})
    public ResponseVo handlerBusinessException(HttpServletRequest request, BusinessException e) {
        LOGGER.info("BusinessException occurred,url is {}", request.getRequestURI(), e);
        return ResponseVo.failure(e.getCode(), e.getMessage());
    }

    /**
     * 使用 @Valid 注解时校验不过会抛参数校验异常
     *
     * @param request
     * @param e
     * @return
     */
    @ExceptionHandler({MethodArgumentNotValidException.class})
    public ResponseVo handlerMethodArgumentNotValidException(HttpServletRequest request, MethodArgumentNotValidException e) {
        LOGGER.warn("Validation failed for argument.url is {}", request.getRequestURI());
        Map<String, String> errorMsgMap = new HashMap<>(16);
        for (FieldError error : e.getBindingResult().getFieldErrors()) {
            errorMsgMap.put(error.getField(), error.getDefaultMessage());
        }
        return ResponseVo.failure(errorMsgMap, PARAM_ERROR, JsonUtils.obj2json(errorMsgMap), e.getMessage());
    }

    @ExceptionHandler({JwtException.class})
    public ResponseVo handlerJwtException(JwtException e) {
        if (e instanceof ExpiredJwtException) {
            LOGGER.info("Jwt expired", e);
            return ResponseVo.failure(JWT_EXPIRED_ERROR, JWT_EXPIRED_ERROR_MSG, e.getMessage());
        } else if (e instanceof SignatureException) {
            LOGGER.info("Exception indicating that either calculating a signature or verifying an existing signature of a JWT failed.", e);
        } else if (e instanceof MalformedJwtException) {
            LOGGER.info("Exception indicating that a JWT was not correctly constructed and should be rejected.");
        } else if (e instanceof InvalidClaimException) {
            LOGGER.info("Exception indicating a parsed claim is invalid in some way.  Subclasses reflect the specific reason the claim is invalid.", e);
        }
        return ResponseVo.failure(JWT_ERROR, JWT_ERROR_MSG);
    }

    /**
     * 主键冲突异常
     *
     * @param e
     * @return
     */
    @ExceptionHandler(DuplicateKeyException.class)
    public ResponseVo handlerDuplicateKeyException(DuplicateKeyException e) {
        LOGGER.warn(e.getMostSpecificCause().getMessage(), e);
        return ResponseVo.failure(DB_DUPLICATE_KEY, DB_DUPLICATE_KEY_MSG, e.getMostSpecificCause().getMessage());
    }

    /**
     * Thrown by {@link HttpMessageConverter} implementations when the
     * {@link HttpMessageConverter#read} method fails.
     *
     * @param e
     * @return
     */
    @ExceptionHandler(HttpMessageConversionException.class)
    public ResponseVo handlerHttpMessageConversionException(HttpMessageConversionException e) {
        return ResponseVo.failure(HTTP_MESSAGE_ERROR, HTTP_MESSAGE_ERROR_MSG, e.getMessage());
    }

}
