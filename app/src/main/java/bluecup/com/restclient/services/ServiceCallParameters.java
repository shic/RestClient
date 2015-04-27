package bluecup.com.restclient.services;

import bluecup.com.restclient.services.utils.ServiceCallback;

/**
 * This class is used to set Service Parameters
 */

public class ServiceCallParameters {


    public Object param;
    public ServiceCallback callback;


    public ServiceCallParameters(Object param, ServiceCallback callback) {
        this.param = param;
        this.callback = callback;
    }
}
