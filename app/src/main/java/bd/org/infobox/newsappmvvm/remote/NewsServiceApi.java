package bd.org.infobox.newsappmvvm.remote;

import bd.org.infobox.newsappmvvm.model.News;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;

public interface NewsServiceApi {

    @GET
    Call<News> getAllNews(@Url String urlString);

}
