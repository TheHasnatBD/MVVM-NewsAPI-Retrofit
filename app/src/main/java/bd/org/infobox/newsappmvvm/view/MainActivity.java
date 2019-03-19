package bd.org.infobox.newsappmvvm.view;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.List;

import bd.org.infobox.newsappmvvm.R;
import bd.org.infobox.newsappmvvm.adapter.NewsAdapter;
import bd.org.infobox.newsappmvvm.databinding.ActivityMainBinding;
import bd.org.infobox.newsappmvvm.model.Article;
import bd.org.infobox.newsappmvvm.viewmodel.MainActivityViewModel;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        //final ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);

        MainActivityViewModel activityViewModel = ViewModelProviders.of(this).get(MainActivityViewModel.class);
        activityViewModel.getAllArticle().observe(this, new Observer<List<Article>>() {
            @Override
            public void onChanged(@Nullable List<Article> articles) {
                recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                recyclerView.setAdapter(new NewsAdapter( articles, MainActivity.this));
            }
        });

    }
}
