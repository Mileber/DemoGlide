package mileber.retrofit;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by Mileber on 2016/10/19.
 */

public interface WeatherService {
    @GET("x3/weather?key=HefengKey")
    Call<ResponseBody> getResponse(@Query("city") String city);

    //TODO:关于POST，HTTP等相关注解的内容
}
