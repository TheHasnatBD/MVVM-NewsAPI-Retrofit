package bd.org.infobox.newsappmvvm.model.repository;

import android.app.Application;
import android.arch.lifecycle.MutableLiveData;

import java.util.List;

import bd.org.infobox.newsappmvvm.model.Article;
import bd.org.infobox.newsappmvvm.remote.NewsServiceApi;
import bd.org.infobox.newsappmvvm.R;
import bd.org.infobox.newsappmvvm.remote.RetrofitClient;
import bd.org.infobox.newsappmvvm.model.News;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NewsRepository {

    MutableLiveData<List<Article>> mutableLiveData;
    private Application application;


    public final static String BASE_URL = "https://newsapi.org/v2/";

    String apiKey = String.valueOf(R.string.api_key);
    //String news_url = String.format("v2/top-headlines?country=us&category=%s&apiKey=%s", catName, apiKey);
    String news_url = String.format("top-headlines?country=us&category=business&apiKey=78e088eee2a74423a9e70b2b67d353de");

    public NewsRepository(Application application) {
        this.application = application;
    }


    public MutableLiveData<List<Article>> getMutableLiveData(){
        if (mutableLiveData == null){
            mutableLiveData = new MutableLiveData<>();
        }
        NewsServiceApi serviceApi = RetrofitClient.getClient(BASE_URL).create(NewsServiceApi.class);
        serviceApi.getAllNews(news_url)
                .enqueue(new Callback<News>() {
                    @Override
                    public void onResponse(Call<News> call, Response<News> response) {
                        if (response.isSuccessful()){
                            News newsRes = response.body();
                            List<Article> articleList = newsRes.getArticles();
                            mutableLiveData.setValue(articleList);
                        }
                    }

                    @Override
                    public void onFailure(Call<News> call, Throwable t) {
                    }
                });
        return mutableLiveData;
    }

}
