package bd.org.infobox.newsappmvvm.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;
import android.support.annotation.NonNull;

import java.util.List;

import bd.org.infobox.newsappmvvm.model.Article;
import bd.org.infobox.newsappmvvm.model.repository.NewsRepository;

public class MainActivityViewModel extends AndroidViewModel {

    NewsRepository newsRepository;

    public MainActivityViewModel(@NonNull Application application) {
        super(application);
        newsRepository = new NewsRepository(application);
    }

    public LiveData<List<Article>> getAllArticle(){
        return newsRepository.getMutableLiveData();
    }


}
