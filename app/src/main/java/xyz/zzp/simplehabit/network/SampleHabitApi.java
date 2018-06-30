package xyz.zzp.simplehabit.network;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import xyz.zzp.simplehabit.network.responses.GetCategoryProgramResponse;
import xyz.zzp.simplehabit.network.responses.GetCurrentProgramResponse;
import xyz.zzp.simplehabit.network.responses.GetTopicResponse;

public interface SampleHabitApi {

    @FormUrlEncoded
    @POST("getCurrentProgram.php")
    Observable<GetCurrentProgramResponse> loadCurrentProgram(
            @Field("access_token")String accessToken,
            @Field("page")int page);

    @FormUrlEncoded
    @POST("getCategoriesPrograms.php")
    Observable<GetCategoryProgramResponse> loadCategoryProgram(@Field("access_token")String accessToken,
                                                         @Field("page")int page);

    @FormUrlEncoded
    @POST("getTopics.php")
    Observable<GetTopicResponse> loadTopic(@Field("access_token")String accessToken,
                                     @Field("page")int page);

}
