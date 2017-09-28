package com.example.patrickcaruso.activistwatch;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.patrickcaruso.activistwatch.Adapter.UserAdapter;
import com.example.patrickcaruso.activistwatch.Database.Database;
import com.example.patrickcaruso.activistwatch.Organization.Organization;
import com.example.patrickcaruso.activistwatch.User.ThisUser;
import com.example.patrickcaruso.activistwatch.User.User;

import java.io.IOException;
import java.util.List;


public class MyOrganizationsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_organizations);

        //Get organizations list
        User user;
        int userId = ThisUser.getId();
        String response = "";
        try {
            response = Database.lookupUser(userId);
        } catch (IOException e) {
            e.printStackTrace();
        }
        user = UserAdapter.adapt(response);
        List<Organization> orgs = user.getOrganizations();

        //Add to ScrollView
        LinearLayout scrollViewLayout = (LinearLayout)findViewById(R.id.orgScrollLayout);
        for (Organization org: orgs) {
            String orgNameStr = org.getName();
            TextView orgNameText = new TextView(this);
            orgNameText.setText(orgNameStr);
            scrollViewLayout.addView(orgNameText);
        }

        //Add Org Button press
        Button addButton = (Button) findViewById(R.id.addButton);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               //Code here
            }
        });
    }
}