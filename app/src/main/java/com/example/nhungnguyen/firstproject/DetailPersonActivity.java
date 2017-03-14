package com.example.nhungnguyen.firstproject;

import android.content.Intent;
import android.provider.ContactsContract;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class DetailPersonActivity extends AppCompatActivity {
    private TextView mTvPerson,mTvAge,mTvContent;
    private ImageView mfavorite;
    private List<DataItemTestLayout> mdata = new ArrayList<>();
    private DataItemTestLayout data;
    private int poisision;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_person);
        mTvPerson=(TextView) findViewById(R.id.tvDetail1);
        mTvAge=(TextView) findViewById(R.id.tvDetail2);
        mTvContent=(TextView) findViewById(R.id.tvDetail3);
        mfavorite=(ImageView)findViewById(R.id.imgFavoriteDetail);
        final Bundle bundle = getIntent().getExtras();
        data=bundle.getParcelable("para");
        poisision=bundle.getInt("poin");
        mTvPerson.setText(data.getTvUser());
        mTvAge.setText(data.getTvAge());
        mTvContent.setText(data.getTvContent());
        mfavorite.setSelected(data.isFavorite());
        mfavorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mfavorite.setSelected(!data.isFavorite());
                data.setFavorite(!data.isFavorite());

            }
        });
    }

    @Override
    public void onBackPressed() {
        Intent i=new Intent();
        i.putExtra("favor", data);
        i.putExtra("poinfavor",poisision);
        setResult(RESULT_OK,i);
        finish();
    }
}
