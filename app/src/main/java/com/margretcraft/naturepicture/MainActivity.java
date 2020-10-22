package com.margretcraft.naturepicture;

import android.graphics.Bitmap;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;


public class MainActivity extends AppCompatActivity {
    ArrayList<String> paths = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ProgressBar progressBar = findViewById(R.id.progressBar);

        GetPictureArray gpa = new GetPictureArray(this);
        try {
            paths = gpa.execute().get();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        ArrayList<ThreePicture> threePictures = new ArrayList<>();

        Bitmap bitmap = null;
        Bitmap[] bmarray = new Bitmap[3];
        int i = 0;
        for (String path : paths) {

            try {
                ShowPicture showPicture = new ShowPicture();
                bitmap = showPicture.execute(path).get();
                bmarray[i] = bitmap;
                i++;
            } catch (ExecutionException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if (i == 3) {

                threePictures.add(new ThreePicture(bmarray[0], bmarray[1], bmarray[2]));
                i = 0;
                bmarray[0] = null;
                bmarray[1] = null;
                bmarray[2] = null;

            }
        }
        if (i > 0) {
            threePictures.add(new ThreePicture(bmarray[0], bmarray[1], bmarray[2]));
        }

        RecyclerView recyclerView = findViewById(R.id.RecyclerView);

        ItemAdapter adapter = new ItemAdapter(threePictures, this);
        recyclerView.setAdapter(adapter);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        progressBar.setVisibility(View.INVISIBLE);

        adapter.notifyDataSetChanged();
    }
}