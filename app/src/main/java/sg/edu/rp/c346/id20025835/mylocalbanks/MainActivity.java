package sg.edu.rp.c346.id20025835.mylocalbanks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button dbs;
    Button uob;
    Button ocbc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dbs = findViewById(R.id.dbs);
        uob = findViewById(R.id.uob);
        ocbc = findViewById(R.id.ocbc);

        dbs.setOnClickListener((view) -> {
            Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + 1800 + "-" + 111 + "-" + 1111));
            startActivity(intentCall);
        });

        uob.setOnClickListener((view) -> {
            Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + 1800 + "-" + 222 + "-" + 2121));
            startActivity(intentCall);
        });

        ocbc.setOnClickListener((view) -> {
            Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + 1800 + "-" + 363 + "-" + 3333));
            startActivity(intentCall);
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here.
        int id = item.getItemId();

        if (id == R.id.EnglishSelection) {
            dbs.setText("DBS");
            uob.setText("UOB");
            ocbc.setText("OCBC");
            return true;
        } else if (id == R.id.ChineseSelection) {
            dbs.setText("星展银行");
            uob.setText("大华银行");
            ocbc.setText("华侨银行");
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
