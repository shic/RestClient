package bluecup.com.restclient.services.data;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by sergio on 17/03/15.
 */
public class Constants {

    //timeout???
    public static final int CONNECTION_TO = 30*1000;
    public static final int SO_TO = 30*1000;


    public static final String EASY_DINNER_URL = "http://www.easydinner.it/";

    public static final String apiUrl = "http://www.easydinner.it/appjson.php";
    public static final String apiUrlTest = "http://graph.facebook.com/pivotalsoftware";
    public static final String apiUrlBitCoin ="https://bitpay.com/api/rates";
    public static final long DB_TTL_MILLIS = 3*24*3600*1000L; // 7d

    public static final String ALL_VALUES = "All";
    public static final String SHARED_PREFERENCES = "sharedpref";
    public static final String SP_LAST_DB_UPDATE = "lastDbRefresh";
    public static final String APP_LANDING_PAGE = "http://www.easydinner.it/mobile-app";

    public static final double MAX_EVENT_OFFER_DISTANCE = 50.0;
    public static final double MAX_USER_RESTAURANT_DISTANCE = 25.0; //in meters
    public static double userLon = 12.51133;
    public static double userLat = 41.89193;



    public static Map<String,String> weekDaysTranslations = new HashMap<String,String>();
    public static Map<String,String> dayMomentsTranslations = new HashMap<String,String>();
    public static Map<String,String> cousinesTranslations = new HashMap<String,String>();

    public static String GA_CATEGORY = "android";

    public static String GA_EVENT_DOWNLOAD = "download";
    public static String GA_EVENT_OFFERVIEW = "offerview";
    public static String GA_EVENT_REQUESTGIFTUNLOCK = "request gift unlock";
    public static String GA_EVENT_GIFTUNLOCKOK = "gift unlock ok";
    public static String GA_EVENT_GIFTUNLOCKKO = "gift unlock ko";
    public static String GA_EVENT_LAUNCH = "launch";
    public static String GA_EVENT_NAVIGATE = "navigate";
    public static String GA_EVENT_SHARE = "share";
    public static String GA_EVENT_OFFERUSE = "offeruse";


    public static String geodecode(String address){
        return "http://maps.googleapis.com/maps/api/geocode/json?address=" + address + "&sensor=false";
    }

    //DEPRECATED API!!!
//    public static final String offersListURL = "http://www.easydinner.it/?feed=offer";
//    public static final String offersListUrlJson = "http://www.easydinner.it/?feed=jsonoffer";
//    public static final String restaurantsListUrlJson = "http://www.easydinner.it/?feed=jsonristo";

    //used by lastdinnerDBUpdateService to retrive restaurants list upon request (a string in the intent is used to discriminate fetch)
    public static final String restaurantsListURL = "http://www.easydinner.it/?feed=risto";
    public static final String restaurantInfoURL = "http://www.easydinner.it/?feed=risto";

}
