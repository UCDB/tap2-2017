package br.ucdb;

/**
 * Created by Virmerson on 07/08/2017.
 */
public class ServiceException extends Throwable {
    public ServiceException(String msg) {
        super(msg);
    }

    public ServiceException( String msg, Throwable causa) {
        super(msg, causa);
    }
}
