package mileber.retrofit;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by Mileber on 2016/10/19.
 */

public interface BaiduService {
    @GET("x3/weather?cityid={cityId}&key=52a6eb4fc76b47829bbe69b1b7197fa0")
    Call<ResponseBody> getResponse(@Path("cityId")String cityId);
}
