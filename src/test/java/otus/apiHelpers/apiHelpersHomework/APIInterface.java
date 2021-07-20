package otus.apiHelpers.apiHelpersHomework;

import otus.apiHelpers.apiHelpersHomework.pojo.requestBodies.UserBody;
import otus.apiHelpers.apiHelpersHomework.pojo.responses.CreatedUser;
import otus.apiHelpers.apiHelpersHomework.pojo.responses.Resource;
import otus.apiHelpers.apiHelpersHomework.pojo.responses.User;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.List;

public interface APIInterface {

    @GET("users/2")
    Call<User> getUser();

    @GET("unknown/2")
    Call<Resource> getResource();

    @POST("users")
    Call<CreatedUser> createUser(@Body UserBody userBody);

}
