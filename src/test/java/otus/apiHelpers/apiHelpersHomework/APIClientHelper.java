package otus.apiHelpers.apiHelpersHomework;

import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

public class APIClientHelper {

    public static final String BASE_URL = "http:/reqres.in/api/";

    private static Retrofit retrofit = null;

    static Retrofit getClient(){
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(JacksonConverterFactory.create())
                .build();

        return retrofit;
    }
}
