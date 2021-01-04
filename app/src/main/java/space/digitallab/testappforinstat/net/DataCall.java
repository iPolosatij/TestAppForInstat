package space.digitallab.testappforinstat.net;


import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.POST;
import space.digitallab.testappforinstat.dto.VideoUrls;

public interface DataCall {

    @POST("https://api.instat.tv/test/video-urls")
    Call<List<VideoUrls>> videoUrls(@Header ("Content-Type") String content_type, @Body BodyUrlResponse bodyUrlResponse);
}
