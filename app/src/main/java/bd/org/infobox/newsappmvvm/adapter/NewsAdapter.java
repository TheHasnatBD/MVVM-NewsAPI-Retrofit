package bd.org.infobox.newsappmvvm.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.List;

import bd.org.infobox.newsappmvvm.R;
import bd.org.infobox.newsappmvvm.model.Article;


public class NewsAdapter  extends RecyclerView.Adapter<NewsAdapter.NewsViewHolder> {

    List<Article> articles;
    private Context context;

    public NewsAdapter(List<Article> articles, Context context) {
        this.articles = articles;
        this.context = context;
    }

    @NonNull
    @Override
    public NewsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.single_news_view, parent,false);
        return new NewsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NewsViewHolder holder, final int position) {
        holder.title.setText(articles.get(position).getTitle());
        holder.date.setText(articles.get(position).getPublishedAt());

        String photoUrl = articles.get(position).getUrlToImage();
        Picasso.get().load(photoUrl).into(holder.imageView);


    }

    @Override
    public int getItemCount() {
        return articles.size();
    }


    public class NewsViewHolder extends RecyclerView.ViewHolder{
        TextView title, date;
        ImageView imageView;

        public NewsViewHolder(@NonNull final View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.title);
            date = itemView.findViewById(R.id.date);
            imageView = itemView.findViewById(R.id.image);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position = getAdapterPosition();


                }
            });
        }
    }

}