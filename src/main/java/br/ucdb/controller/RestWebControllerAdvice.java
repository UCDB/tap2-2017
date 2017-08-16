package br.ucdb.controller;

import br.ucdb.service.ServiceException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * Created by Virmerson on 07/08/2017.
 * Fonte: http://javasampleapproach.com/spring-framework/spring-mvc/use-restcontrolleradvice-new-features-spring-framework-4-3
 */
@RestControllerAdvice
public class RestWebControllerAdvice {

    @ResponseStatus(value= HttpStatus.FORBIDDEN)
    @ExceptionHandler(ServiceException.class)
    public ResponseMsg handleServiceException(ServiceException e){
        ResponseMsg msg = new ResponseMsg();
        msg.setMensagem(e.getMessage());
        return msg;
    }
}
