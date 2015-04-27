package bluecup.com.restclient;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import bluecup.com.restclient.dtos.OfferResponse;
import bluecup.com.restclient.dtos.RestaurantResponse;
import bluecup.com.restclient.services.RestClient;
import bluecup.com.restclient.services.RestaurantService;
import bluecup.com.restclient.services.ServiceCallParameters;
import bluecup.com.restclient.services.utils.ServiceCallback;


public class OfferNumberActivity extends ActionBarActivity {

    public final String LOG_TAG = OfferNumberActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_offer_number);

        ServiceCallback callback = new ServiceCallback() {
            @Override
            public void onSuccess(Object obj) {

                OfferResponse[] offers = (OfferResponse[]) obj;

                int totleOfferNumber = offers.length;
                String offerTitle = offers[0].getO_titolo();
                String offerImgUrl = offers[1].getO_img_url();
                String[] offerValidateDays = offers[1].getO_val_day();
                int offerValidateDaysNumber =offerValidateDays.length;
                Log.d(LOG_TAG,Integer.toString(offerValidateDaysNumber));
                Log.d(LOG_TAG,offerImgUrl);


                RestaurantResponse restaurantObj = offers[1].getO_ristorante();

                String[] restaurantImgUrl = restaurantObj.getGallery();

                for (int i = 0; i< restaurantImgUrl.length; i++){
                    Log.d(LOG_TAG,restaurantImgUrl[i]);
                }



            }

            @Override
            public void onFailure(Object obj) {
                Log.d(LOG_TAG,"Callback Failure");
            }
        };

        ServiceCallParameters parameter = new ServiceCallParameters(null, callback);
        RestClient.inizializeRestTemplate();
        new RestaurantService().execute(parameter);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_offer_number, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
