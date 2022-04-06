package pnj.ac.id.latihanti6;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btnPindah,btnBrowser;
    int REQUEST_CODE_CAMERA = 100;
    int REQUEST_CODE_GALERY = 200;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnPindah = findViewById(R.id.btnPindah);
        btnBrowser= findViewById(R.id.btnBrowser);
        btnPindah.setOnClickListener(this);
        btnBrowser.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnPindah:
//                Intent intent = new Intent(this, ActivityKe2.class);
//                intent.putExtra("nama","Syamsi Dwi Cahya");
//                intent.putExtra("umur", 18);
//                startActivity(intent);
                pilihDialog();
                break;
            case R.id.btnBrowser:
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://google.com"));
                startActivity(intent);
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(resultCode==RESULT_OK) {
            int type = data.getExtras().getInt("type",0);
            Log.e("type : ", ""+type);
        }
    }

    void pilihDialog() {
        AlertDialog.Builder dialog = new AlertDialog.Builder(this);

        dialog.setItems(new String[]{"Camera","Gallery"}, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                switch (i){
                    case 0:
                        Intent intent = new Intent(MainActivity.this, ActivityKe2.class);
                        startActivityForResult(intent,REQUEST_CODE_CAMERA);
                        break;
                    case 1:
                        Intent intent2 = new Intent(MainActivity.this, AktivityKe3.class);
                        startActivityForResult(intent2,REQUEST_CODE_GALERY);
                        break;
                }
            }
        });
        dialog.show();
    }
}
