package com.example.bai51_xemtintuc;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class NewsAdapter extends BaseAdapter {
    List<News> list;
    Context context ;
    int layout;

    public NewsAdapter(List<News> list, Context context, int layout) {
        this.list = list;
        this.context = context;
        this.layout = layout;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        if(view == null){
            viewHolder = new ViewHolder();
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = layoutInflater.inflate(layout,null);
            //anh xa len view
            viewHolder.imgImage = view.findViewById(R.id.imgImage);
            viewHolder.txtTitle = view.findViewById(R.id.txtTitle);
            viewHolder.txtDesc = view.findViewById(R.id.txtDesc);
            view.setTag(viewHolder);


        }else {
            viewHolder = (ViewHolder) view.getTag();
        }
        News news = list.get(i);
        viewHolder.txtTitle.setText(news.getTitle());
        viewHolder.txtDesc.setText(news.getTitle());
        //viewHolder.imgImage.setImageResource(news.getImage());
        Picasso.get().load(news.getImage()).into(viewHolder.imgImage);

        return view;
    }
    class ViewHolder{
        TextView txtTitle, txtDesc;
        ImageView imgImage;

    }

}
