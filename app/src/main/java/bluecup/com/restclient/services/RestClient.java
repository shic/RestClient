package bluecup.com.restclient.services;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.joda.JodaModule;

import org.apache.http.params.CoreConnectionPNames;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import bluecup.com.restclient.services.data.Constants;

public class RestClient {

    //This is a singleton
    static RestTemplate restTemplate = null;

    public static void inizializeRestTemplate() {
        if(restTemplate==null){
            HttpHeaders requestHeaders = new HttpHeaders();
            requestHeaders.setContentType(MediaType.APPLICATION_JSON);
            restTemplate = new RestTemplate();
            HttpComponentsClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory();
            requestFactory.getHttpClient().getParams().setIntParameter(CoreConnectionPNames.CONNECTION_TIMEOUT,Constants.CONNECTION_TO);
            requestFactory.getHttpClient().getParams().setIntParameter(CoreConnectionPNames.SO_TIMEOUT, Constants.SO_TO);
            restTemplate.setRequestFactory(requestFactory);
            MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
            ObjectMapper mapper = converter.getObjectMapper();
            mapper.registerModule(new JodaModule());
            mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, true);
            mapper.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);
            mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            restTemplate.getMessageConverters().add(converter);

			/*List<ClientHttpRequestInterceptor> ris = new ArrayList<ClientHttpRequestInterceptor>();
		    ris.add(new LoggingRequestInterceptor());
		    restTemplate.setInterceptors(ris);*/
            //return restTemplate;
        }
    }


}
