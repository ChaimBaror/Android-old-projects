package com.example.cookingrecipeapplication.ui;


import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.example.cookingrecipeapplication.MainActivity;
import com.example.cookingrecipeapplication.R;
import com.example.cookingrecipeapplication.adapters.DatabaseAdapter;
import com.example.cookingrecipeapplication.models.User;
import com.google.android.material.textfield.TextInputLayout;

import static androidx.core.content.ContextCompat.startActivity;

public class RegisterActivity extends ToolbarActivity {

    private DatabaseAdapter databaseAdapter;



    private  TextInputLayout mUsername;
    private TextInputLayout mFullname;
    private TextInputLayout mEmail;
    private TextInputLayout mPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        databaseAdapter = DatabaseAdapter.getInstance(this);

        mToolbar = findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setTitle("Create Account");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mUsername = findViewById(R.id.reg_display_name);
        mFullname = findViewById(R.id.login_fullname);
        mEmail = findViewById(R.id.login_email);
        mPassword = findViewById(R.id.login_password);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    public void onCreateAccountPressed(View view) {
        String username = mUsername.getEditText().getText().toString();
        String fullname = mFullname.getEditText().getText().toString();
        String email = mEmail.getEditText().getText().toString();
        String password = mPassword.getEditText().getText().toString();

        registerUser(new User(username, fullname, email, password));
    }

    private void registerUser(User user) {
        databaseAdapter.addNewUser(user);

        Intent intent = new Intent(this, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }
}
