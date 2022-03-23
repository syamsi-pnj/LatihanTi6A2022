package pnj.ac.id.latihanti6;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AktivityKe3 extends AppCompatActivity {
    Button selesai;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aktivity_ke3);
        selesai = findViewById(R.id.btnSelesai);
        selesai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent();
                intent.putExtra("type", 3);
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }
}