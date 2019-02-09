package com.example.user.contextmenu;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button bt = (Button) findViewById(R.id.btnShow);
        registerForContextMenu(bt);
    }

    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.setHeaderTitle("Context Menu");
        menu.add(0, v.getId(), 0, "Camera");
        menu.add(0, v.getId(), 0, "Web");
        menu.add(0, v.getId(), 0, "Phone");

        menu.add(0, v.getId(), 0, "Sms");
    }

    public boolean onContextItemSelected(MenuItem item) {

        if (item.getTitle() == "Camera") {
            Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);

            startActivity(cameraIntent);
        } else if (item.getTitle() == "Web") {
            Intent intent = new Intent();
            intent.setAction(Intent.ACTION_VIEW);
            intent.addCategory(Intent.CATEGORY_BROWSABLE);
            intent.setData(Uri.parse("http://www.yourURL.com"));
            startActivity(intent);
        } else if (item.getTitle() == "Phone") {
            Intent i = new Intent(Intent.ACTION_DIAL);

            startActivity(i);

        } else if (item.getTitle() == "Sms") {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("sms:" ));

            startActivity(intent);
        } else {


            return false;
        }
        return true;
    }
}





