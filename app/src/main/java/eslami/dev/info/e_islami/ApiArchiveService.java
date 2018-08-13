package eslami.dev.info.e_islami;

import eslami.dev.info.e_islami.Models.ApiGlobalModel;
import eslami.dev.info.e_islami.Models.ApiModel;
import eslami.dev.info.e_islami.Models.MetaDataModel;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiArchiveService {



    @GET("/advancedsearch.php?q=%D8%A7%D9%84%D9%82%D8%B1%D8%A7%D9%86+%D8%A7%D9%84%D9%83%D8%B1%D9%8A%D9%85+%D9%83%D8%A7%D9%85%D9%84&fl%5B%5D=identifier&fl%5B%5D=title&sort%5B%5D=&sort%5B%5D=&sort%5B%5D=&rows=200&page=1&output=json")
    Call<ApiGlobalModel> getObjectSound();


    @GET("/metadata/{identifier}")
    Call<ApiModel> getPlayListById(@Path("identifier") String identifier);

    @GET("/metadata/{identifier}")
    Call<MetaDataModel> getMetadataById(@Path("identifier") String identifier);


}
