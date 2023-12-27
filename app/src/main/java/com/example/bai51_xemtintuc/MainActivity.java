package com.example.bai51_xemtintuc;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    NewsAdapter adapter;
    List<News> list;
    ListView lbNewList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myInit();
        adapter = new NewsAdapter(list,MainActivity.this,R.layout.news_line);
        lbNewList.setAdapter(adapter);
        String linkRSS = "https://vnexpress.net/rss/the-thao.rss";
        new ReadContentAsyncTask().execute(linkRSS);

        lbNewList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                News selectedNews = list.get(position);
                String newsUrl = selectedNews.getLink();
                // Chuyển đến trang tin tức mới với đường dẫn newsUrl
                // Ví dụ: mở trình duyệt web với đường dẫn newsUrl
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.hutech.edu.vn/"));
                startActivity(browserIntent);
            }
        });

    }
    private void myInit()
    {
        lbNewList = findViewById(R.id.lbNewList);
        list = new ArrayList<>();
        list.add(new News("Truong hutech tphcm","https://file1.hutech.edu.vn/file/news/2730011703678073.jpg","RSS ( viết tắt từ Really Simple Syndication ) là một tiêu chuẩn định dạng tài liệu dựa trên XML nhằm giúp người sử dụng dễ d",""));
        list.add(new News("Truong hutech tphcm123","https://file1.hutech.edu.vn/file/editor/homepage1/158160-dsc00088jpg.jpg","RSS ( viết tắt từ Really Simple Syndication ) là một tiêu chuẩn định dạng tài liệu dựa trên XML nhằm giúp người sử dụng dễ d",""));
    }
    class ReadContentAsyncTask extends AsyncTask<String,Void,String>{

        @Override
        protected String doInBackground(String... strings) {
            StringBuffer stringBuffer = new StringBuffer();
            try
            {
                URL url = new URL(strings[0]);
                URLConnection urlConnection = url.openConnection();
                InputStream inputStream = urlConnection.getInputStream();
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                BufferedReader br = new BufferedReader(inputStreamReader);
                String line="";
                while ((line=br.readLine()) != null){
                    stringBuffer.append(line+"\n");
            }
            }catch (Exception ex){

            }
            return stringBuffer.toString();
        }

//        @Override
//        protected void onPostExecute(String s) {
//            super.onPostExecute(s);
//
//            XMLDOMParser parser = new XMLDOMParser();
//
//            Document doc = parser.getDocument(s);
//            NodeList nodeList = doc.getElementsByTagName("item");
//            String title= "";
//            String link="";
//            String desc ="";
//            String imageLink = "";
//            String htmlDesc="";
//            for(int i = 0;i< nodeList.getLength(); i++){
//                Element element = (Element) nodeList.item(i);
//                title = parser.getValue(element,"title");
//                htmlDesc = parser.getValueDesc(element,"description");
//                link = parser.getValue(element,"link");
//                imageLink = parser.getImageLink(htmlDesc);
//                desc = parser.getDescContent(htmlDesc);
//                //Toast.makeText(MainActivity.this, ""+imageLink, Toast.LENGTH_LONG).show();
//                //Toast.makeText(MainActivity.this, ""+desc, Toast.LENGTH_LONG).show();
//                News news = new News(title , imageLink,desc, link);
//                list.add(news);
//                //Log.d("AAA",title);
//
//            }
//            adapter.notifyDataSetChanged();
//        }
    }

}