package sg.edu.rp.c346.id20025835.mylocalbanks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button dbs;
    Button uob;
    Button ocbc;

    String wordClicked = "";
    String visit="Visit Website";
    String call= "Contact Bank";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dbs = findViewById(R.id.dbs);
        uob = findViewById(R.id.uob);
        ocbc = findViewById(R.id.ocbc);

        registerForContextMenu(dbs);
        registerForContextMenu(uob);
        registerForContextMenu(ocbc);
    }

        @Override
        public void onCreateContextMenu(ContextMenu menu, View v,ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.add(0,0,0,visit);
        menu.add(0,1,1,call);

        if (v == uob) {
            wordClicked = "UOB";
        } else if (v == dbs) {
            wordClicked = "DBS";
        } else if(v == ocbc) {
            wordClicked = "OCBC" ;
        }
    }
        @Override
        public boolean onContextItemSelected(MenuItem item) {
            if (wordClicked == "DBS") {
                if (item.getItemId() == 0) {
                    Intent intentWebsite = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.dbs.com.sg"));
                    startActivity(intentWebsite);
                    return true;

                } else if (item.getItemId() == 1) {
                    Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + 1800 + "-" + 111 + "-" + 1111));
                    startActivity(intentCall);
                    return true;
                }
            } else if (wordClicked == "UOB") {
                if (item.getItemId() == 0) {
                    Intent intentWebsite = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.uob.com.sg"));
                    startActivity(intentWebsite);
                    return true;

                } else if (item.getItemId() == 1) {
                    Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + 1800 + "-" + 222 + "-" + 2121));
                    startActivity(intentCall);
                    return true;
                }
            } else if (wordClicked == "OCBC") {
                if (item.getItemId() == 0) {
                    Intent intentWebsite = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.ocbc.com"));
                    startActivity(intentWebsite);
                    return true;

                } else if (item.getItemId() == 1) {
                    Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + 1800 + "-" + 363 + "-" + 3333));
                    startActivity(intentCall);
                    return true;
                }
            }
            return super.onContextItemSelected(item);
        }

        @Override
        public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
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
