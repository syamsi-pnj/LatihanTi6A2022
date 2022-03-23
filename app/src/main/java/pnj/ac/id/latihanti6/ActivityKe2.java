package pnj.ac.id.latihanti6;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipData;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ActivityKe2 extends AppCompatActivity {
    TextView txtData;
    Button selesai;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ke2);
        txtData = findViewById(R.id.txtData);
        selesai = findViewById(R.id.btnSelesai);
        selesai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.putExtra("type", 2);
                setResult(RESULT_OK, intent);
                finish();
            }
        });


        Intent datas = getIntent();

//        if(datas!=null){
//            String nama = datas.getExtras().getString("nama", "-");
//            int umur = datas.getExtras().getInt("umur",0);
//
//            Log.e("nama : ", nama);
//            Log.e("Umur : ", ""+umur);
//        }


        try {
            Uri[] datak = null;

//        String url = i.getClipData();

            ClipData mClipData = datas.getClipData();
            if (mClipData != null && mClipData.getItemCount() > 0) {
                datak = new Uri[mClipData.getItemCount()];
                ClipData.Item item =  mClipData.getItemAt(0);
                String textData = (String) item.getText();
                for (int i = 0; i < mClipData.getItemCount(); i++) {
                    ClipData.Item mItem = mClipData.getItemAt(i);
                    datak[i] = mItem.getUri();
                }
            }
        }catch (Exception ex){

        }

    }
}