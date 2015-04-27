package bluecup.com.restclient.services;

import android.os.AsyncTask;
import android.util.Log;

import org.springframework.web.client.HttpStatusCodeException;

import bluecup.com.restclient.dtos.OfferResponse;
import bluecup.com.restclient.services.data.Constants;
import bluecup.com.restclient.services.utils.ServiceCallback;
/**
 *
 */

public class RestaurantService  extends AsyncTask<ServiceCallParameters, Void, Void> {

    public final String LOG_TAG = RestaurantService.class.getSimpleName();
    @Override
    protected Void doInBackground(ServiceCallParameters... args) {

        getOfferList(args[0].callback);

        return null;
    }

    private void getOfferList(ServiceCallback callBack) {
        OfferResponse [] response;
        try {
            response = RestClient.restTemplate.getForObject(Constants.apiUrl, OfferResponse[].class);
//            String id = response[0].getId();
//            String about = response[0].getAbout();

//            int O_id =  response[0].getO_id();
//            Log.d(LOG_TAG,Integer.toString(O_id));
//            Log.d(LOG_TAG+" id", id);
//            Log.d(LOG_TAG+" about",about);
            callBack.onSuccess(response);
        }
        catch (RuntimeException e) {
            e.printStackTrace();
            if(e instanceof HttpStatusCodeException){
                String errorResponse=((HttpStatusCodeException)e).getResponseBodyAsString();
                Log.d(LOG_TAG+" HttpStatusCodeException", errorResponse);
            }
            callBack.onFailure("Failure");
        }
    }

}
