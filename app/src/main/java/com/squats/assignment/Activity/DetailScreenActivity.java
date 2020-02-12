package com.squats.assignment.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.squats.assignment.Activity.API.Model.PostDetails;
import com.squats.assignment.R;

import de.hdodenhof.circleimageview.CircleImageView;

public class DetailScreenActivity extends AppCompatActivity {

   private TextView txtTitle,txtCuisne,txtDesc;
   private CircleImageView profileImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_screen);

        setTitle(getString(R.string.detailScreen));

        txtCuisne = findViewById(R.id.txtCuisne);
        txtDesc = findViewById(R.id.txtDesc);
        txtTitle = findViewById(R.id.txtTitle);
         profileImage =findViewById(R.id.profileImage);

        Intent intent=getIntent();

        PostDetails postDetails= (PostDetails) intent.getSerializableExtra("DATA");

            if(postDetails!=null){

                Glide.with(getApplicationContext()).load(postDetails.getImage_url())
                        .thumbnail(0.5f)
                        .error(R.drawable.image_not_available)
                        .diskCacheStrategy(DiskCacheStrategy.ALL)
                        .into(profileImage);

                txtTitle.setText("Name       :"+postDetails.getName()!=null?postDetails.getName():"NA");
                txtCuisne.setText("Cusine :"+postDetails.getCuisine()!=null?postDetails.getCuisine():"NA");
                txtDesc.setText("Descriptuion : "+postDetails.getDescription()!=null?postDetails.getDescription():"NA");

            }


    }
}
