package space.digitallab.testappforinstat.net;


import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import space.digitallab.testappforinstat.dto.MatchInfo;


public interface MatchInfoCall {

    @POST("https://api.instat.tv/test/data")
    Call<MatchInfo> matchInfo(@Header ("Content-Type") String content_type, @Body BodyDataResponse bodyDataResponse);

}
