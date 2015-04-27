package bluecup.com.restclient.dtos;

/**
 * Created by hanjing on 23/04/15.
 */

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class OfferResponse {

    //Jackson ask for the blank constructor
    public OfferResponse() {
    }

    private int o_id;
    private String o_titolo;
    private String o_id_ristorante;
    private String o_img_url;
    private String[] o_val_day;

    private RestaurantResponse o_ristorante;



    public int getO_id() {
        return o_id;

    }

    public void setO_id(int o_id) {
        this.o_id = o_id;
    }

    public String getO_titolo() {
        return o_titolo;
    }

    public void setO_titolo(String o_titolo) {
        this.o_titolo = o_titolo;
    }

    public String getO_id_ristorante() {
        return o_id_ristorante;
    }

    public void setO_id_ristorante(String o_id_ristorante) {
        this.o_id_ristorante = o_id_ristorante;
    }

    public String getO_img_url() {
        return o_img_url;
    }

    public void setO_img_url(String o_img_url) {
        this.o_img_url = o_img_url;
    }


    public String[] getO_val_day() {
        return o_val_day;
    }

    public void setO_val_day(String[] o_val_day) {
        this.o_val_day = o_val_day;
    }

    public RestaurantResponse getO_ristorante() {
        return o_ristorante;
    }

    public void setO_ristorante(RestaurantResponse o_ristorante) {
        this.o_ristorante = o_ristorante;
    }
//    private String code;
//    private String name;
//    private int rate;
//
//
//    public String getCode() {
//        return code;
//    }
//
//    public void setCode(String code) {
//        this.code = code;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public int getRate() {
//        return rate;
//    }
//
//    public void setRate(int rate) {
//        this.rate = rate;
//    }


}


