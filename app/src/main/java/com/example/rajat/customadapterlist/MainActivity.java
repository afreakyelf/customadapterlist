package com.example.rajat.customadapterlist;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView listView;

    int image[] = {R.drawable.ic_launcher_background,R.drawable.ic_launcher_foreground
            ,R.drawable.ic_launcher_background,R.drawable.ic_launcher_foreground
            ,R.drawable.ic_launcher_background,R.drawable.ic_launcher_foreground};

    String tv[] = {"A","B","C","D","E","F"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listview);
        myadapter arrayAdapter = new myadapter(this,R.layout.item,tv,image);
        listView.setAdapter(arrayAdapter);

    }
}

class myadapter extends ArrayAdapter{

    int image[];
    String name[];
    Context context;

    public myadapter(@NonNull Context context, int resource, @NonNull Object[] name, int[] image) {
        super(context, resource, name);
        this.context = context;
        this.image = image;
        this.name = (String[])name ;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater l = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView =  l.inflate(R.layout.item,null);

        ImageView images = convertView.findViewById(R.id.image);
        TextView text= convertView.findViewById(R.id.text);

        images.setImageResource(image[position]);
        text.setText(name[position]);
        
        return convertView;
    }
}
