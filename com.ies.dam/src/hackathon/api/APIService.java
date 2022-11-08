package hackathon.api;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.*;

interface APIService {

    @GET
    Call<ResponseBody> getCall(@Url String url, @Header("group") String group);

    @POST
    Call<ResponseBody> postCall(@Url String url, @Body RequestBody data, @Header("group") String group);

    @PUT
    Call<ResponseBody> putCall(@Url String url, @Body RequestBody data, @Header("group") String group);

    @DELETE
    Call<ResponseBody> deleteCall(@Url String url, @Header("group") String group);
}