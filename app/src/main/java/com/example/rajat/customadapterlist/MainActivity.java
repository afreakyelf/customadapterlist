package com.example.rajat.customadapterlist;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.GridLayout;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    GridView listView;

    int image[] = {R.drawable.ic_launcher_background,R.drawable.ic_launcher_foreground
            ,R.drawable.ic_launcher_background,R.drawable.ic_launcher_foreground
            ,R.drawable.ic_launcher_background,R.drawable.ic_launcher_foreground};

    String tv[] = {"A","B","C","D","E","F"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView= findViewById(R.id.gridview);
        myadapter arrayAdapter = new myadapter(this,R.layout.item,tv,image);
        listView.setAdapter(arrayAdapter);

    }
}

class myadapter extends BaseAdapter{

    int image[];
    String name[];
    Context context;

    public myadapter(Context context,int resource,Object[] text,int[] image){
        this.context = context;
        this.image = image;
        this.name = (String[]) text;
    }

    @Override
    public int getCount() {
        return image.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull final ViewGroup parent) {

        LayoutInflater l = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView =  l.inflate(R.layout.item,null);

        final ImageView images = convertView.findViewById(R.id.image);
        TextView text= convertView.findViewById(R.id.text);

        images.setImageResource(image[position]);
        text.setText(name[position]);

        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
        //        Toast.makeText(context, image[position], Toast.LENGTH_SHORT).show();

                Intent intent =new Intent(context,fullview.class);
                intent.putExtra("image",String.valueOf(image[position]));

                context.startActivity(intent);
            }
        });

        return convertView;
    }
}
