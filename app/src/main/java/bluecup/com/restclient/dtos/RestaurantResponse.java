package bluecup.com.restclient.dtos;

/**
 * Created by hanjing on 24/04/15.
 */

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class RestaurantResponse {

    public RestaurantResponse() {
    }

    public String nome;
    public String[] gallery;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String[] getGallery() {
        return gallery;
    }

    public void setGallery(String[] gallery) {
        this.gallery = gallery;
    }
}
