package com.grasshoper.grasshopper;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.AssetManager;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.CallbackManager;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.grasshoper.grasshopper.OnTagClickListener;
import com.grasshoper.grasshopper.OnTagDeleteListener;
import com.grasshoper.grasshopper.Tag;
import com.grasshoper.grasshopper.TagView;
import com.squareup.picasso.Picasso;


import java.util.Random;

import de.hdodenhof.circleimageview.CircleImageView;

public class social_profile extends AppCompatActivity {

    ImageView selectedImage;
    private TagView tagView;
    private EditText editText;
    private Random random;
    ImageView slide;

    private CallbackManager mCallbackManager;
    private FirebaseAuth mauth;
    private FirebaseAuth.AuthStateListener mAuthlistener;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_social_new);

        AssetManager assetManager = this.getAssets();

        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);

        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        ImageView togglen = (ImageView) findViewById(R.id.togglenew);

        togglen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(social_profile.this, social.class);
                startActivity(in);
            }
        });

        ImageView store = (ImageView) findViewById(R.id.storrr);

        store.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(social_profile.this, MainActivity.class);
                startActivity(in);
            }
        });

        /*

        Gallery gallery = (Gallery) findViewById(R.id.gallery);

        selectedImage=(ImageView)findViewById(R.id.slide);
        gallery.setSpacing(1);
        final GalleryImageAdapter galleryImageAdapter= new GalleryImageAdapter(this);
        gallery.setAdapter(galleryImageAdapter);
        gallery.setSelection(1);



        gallery.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                // show the selected Image
                selectedImage.setImageResource(galleryImageAdapter.mImageIds[position]);
            }
        });

        */



        //findViewById(R.id.tv_add).setOnClickListener(this);

        Typeface mytypeface1 = Typeface.createFromAsset(assetManager, "Montserrat-Regular.ttf");
        final TextView mytextview1 = (TextView) findViewById(R.id.profile_name);
        mytextview1.setTypeface(mytypeface1);


        SharedPreferences sp1= this.getSharedPreferences("Login",0);

        String unm=sp1.getString("Unm", null);
        String propicbig = sp1.getString("propicbig",null);

        EditText editText = (EditText)findViewById(R.id.profile_name);
        editText.setText(unm, TextView.BufferType.EDITABLE);



        ImageView post_image = (ImageView) findViewById(R.id.slide);

        Picasso.with(getApplicationContext()).load(propicbig).placeholder(R.drawable.pro_pic).into(post_image);

        /*

        TextView tvadd = (TextView) findViewById(R.id.tv_add);
        tvadd.setVisibility(View.GONE);

        editText = (EditText) findViewById(R.id.edit_tag);
        editText.setVisibility(View.GONE);


        tagView = (TagView) this.findViewById(R.id.tagview);
        //SET LISTENER
        tagView.setOnTagClickListener(new OnTagClickListener() {

            @Override
            public void onTagClick(int position, Tag tag) {

            }
        });
        tagView.setOnTagDeleteListener(new OnTagDeleteListener() {

            @Override
            public void onTagDeleted(int position, Tag tag) {

            }
        });
        //ADD TAG


        String[] colors = this.getResources().getStringArray(R.array.colors);

        Tag tag = new Tag("Border");
        tag = new Tag("Custom Background");
        tag.tagTextColor = Color.parseColor(colors[0]);
        tag.background = this.getResources().getDrawable(R.drawable.bg_tag);
        tagView.addTag(tag);

        */

















    }

}
