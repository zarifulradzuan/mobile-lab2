package com.example.bitp3453labs;

import android.content.Intent;
import android.graphics.Bitmap;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class FirstActivity extends AppCompatActivity {
    TextView txtvwAge;
    EditText edtName, edtYear;
    Button btnClick;
    ImageView imageView2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        txtvwAge = (TextView) findViewById(R.id.txtvwAge);
        edtName = (EditText) findViewById(R.id.editName);
        edtYear = (EditText) findViewById(R.id.editYear);
        imageView2 = (ImageView) findViewById(R.id.imageView2);
        imageView2.setImageResource(R.drawable.refresh);
        btnClick = (Button) findViewById(R.id.btnMe);
        btnClick.setText("To New Activity");
    }

    public void fnGreet(View vw){
        String strName = edtName.getText().toString().trim();
        int year = Integer.parseInt(edtYear.getText().toString().trim());
        txtvwAge.setText("Hello and welcome "+strName+". You are "+(2019-year)+" years old.");
    }

    public void fnThreadedActivity(View vw){
        fnGreet(vw);
        Intent intent = new Intent(this, ThreadedActivity.class);
        String strMsg = ((EditText) findViewById(R.id.editName)).getText().toString();
        intent.putExtra("varStr1",strMsg);
        startActivityForResult(intent,0);
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        if(requestCode!=RESULT_OK){
        super.onActivityResult(requestCode,resultCode,data);

        Bitmap bp = (Bitmap) data.getExtras().get("data");
        imageView2.setImageBitmap(bp);
        }
    }
}
