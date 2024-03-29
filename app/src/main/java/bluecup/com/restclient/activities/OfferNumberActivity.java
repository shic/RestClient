package bluecup.com.restclient.activities;

import android.content.Context;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;

import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;
import com.vincentbrison.openlibraries.android.dualcache.lib.DualCache;
import com.vincentbrison.openlibraries.android.dualcache.lib.DualCacheBuilder;
import com.vincentbrison.openlibraries.android.dualcache.lib.DualCacheContextUtils;

import bluecup.com.restclient.R;
import bluecup.com.restclient.dtos.OfferResponse;
import bluecup.com.restclient.dtos.RestaurantResponse;
import bluecup.com.restclient.services.RestClient;
import bluecup.com.restclient.services.RestaurantService;
import bluecup.com.restclient.services.ServiceCallParameters;
import bluecup.com.restclient.services.data.Constants;
import bluecup.com.restclient.services.utils.ServiceCallback;


public class OfferNumberActivity extends ActionBarActivity {
    public final String LOG_TAG = OfferNumberActivity.class.getSimpleName();

    ImageView imageView;
    private String mCacheId;
    //private DualCache<OfferResponse> mCache;
    private DualCache<OfferResponse[]> mCache;

    OfferResponse[] offers;
    OfferResponse singleOffer;
    Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_offer_number);

        imageView = (ImageView) findViewById(R.id.restaurantImageView);
        context = this;

        //Provide a context to the cache
        DualCacheContextUtils.setContext(getApplicationContext());


        ServiceCallback callback = new ServiceCallback() {
            @Override
            public void onSuccess(Object obj) {

                offers = (OfferResponse[]) obj;

                int totleOfferNumber = offers.length;
                String offerTitle = offers[0].getO_titolo();
                String offerImgUrl = offers[1].getO_img_url();
                String[] offerValidateDays = offers[1].getO_val_day();
                int offerValidateDaysNumber = offerValidateDays.length;
                Log.d(LOG_TAG, Integer.toString(offerValidateDaysNumber));
                Log.d(LOG_TAG, offerImgUrl);


                RestaurantResponse restaurantObj = offers[1].getO_ristorante();

                String[] restaurantImgUrl  = restaurantObj.getGallery();

                for (int i = 0; i < restaurantImgUrl.length - 1; i++) {
                    SystemClock.sleep(4 * 1000);
                    String restaurantImgUrlSingle= restaurantImgUrl[i];
                    Log.d(LOG_TAG,restaurantImgUrlSingle );


                }


                
                //easy cache
                mCacheId = "first_cache";
                mCache = new DualCacheBuilder<OfferResponse[]>(mCacheId, 1, OfferResponse[].class)
                        .useDefaultSerializerInRam(Constants.RAM_CACHE_SIZE)
                        .useDefaultSerializerInDisk(Constants.DISK_CACHE_SIZE, true);

                mCache.put("first_cache", offers);
                //mCache.put("b","ObjectB");

                OfferResponse[] offerResult = mCache.get("first_cache");

                String offerResultTitle = offerResult[0].getO_titolo();
                Log.d(LOG_TAG, offerResultTitle);
                refreshCacheSize();

            }

            @Override
            public void onFailure(Object obj) {
                Log.d(LOG_TAG, "Callback Failure");
            }
        };

        ServiceCallParameters parameter = new ServiceCallParameters(null, callback);
        RestClient.inizializeRestTemplate();
        new RestaurantService().execute(parameter);

        //Picasso ??? 
        Picasso.with(context)
                //.load(offerResult[0].getO_img_url())
                .load("https://cms-assets.tutsplus.com/uploads/users/21/posts/19431/featured_image/CodeFeature.jpg")
                .error(R.drawable.error)
                .into(imageView, new Callback.EmptyCallback() {
                    @Override public void onSuccess() {
                        //progressBar.setVisibility(View.GONE);
                    }
                    @Override
                    public void onError() {
                        //progressBar.setVisibility(View.GONE);
                    }
                });
        Log.d(LOG_TAG,"try");

        //Picasso.with(this).load(restaurantImgUrl[0]).into(mIVRestaurant);

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

    private void refreshCacheSize() {
        Log.d(LOG_TAG + "RamCache", Long.toString(mCache.getRamSize()));
        Log.d(LOG_TAG + "DiskCache", Long.toString(mCache.getDiskSize()));
    }
}
