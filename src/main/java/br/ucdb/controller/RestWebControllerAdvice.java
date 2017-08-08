package br.ucdb.controller;

import br.ucdb.service.ServiceException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * Created by Virmerson on 07/08/2017.
 */
@RestControllerAdvice
public class RestWebControllerAdvice {

    @ExceptionHandler(ServiceException.class)
    public ResponseMsg handleServiceException(ServiceException e){
        ResponseMsg msg = new ResponseMsg();
        msg.setMensagem(e.getMessage());
        return msg;
    }
}
