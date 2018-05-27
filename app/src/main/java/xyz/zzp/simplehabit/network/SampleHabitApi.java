package xyz.zzp.simplehabit.network;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import xyz.zzp.simplehabit.network.responses.GetCategoryProgramResponse;
import xyz.zzp.simplehabit.network.responses.GetCurrentProgramResponse;
import xyz.zzp.simplehabit.network.responses.GetTopicResponse;

public interface SampleHabitApi {

    @FormUrlEncoded
    @POST("getTopics.php")
    Call<GetTopicResponse> loadTopic(@Field("access_token")String accessToken,
                                     @Field("page")int page);

    @FormUrlEncoded
    @POST("getCurrentProgram.php")
    Call<GetCurrentProgramResponse> loadCurrentProgram(@Field("access_token")String accessToken,
                                              @Field("page")int page);

    @FormUrlEncoded
    @POST("getCategoriesPrograms.php")
    Call<GetCategoryProgramResponse> loadCategoryProgram(@Field("access_token")String accessToken,
                                                        @Field("page")int page);
}
