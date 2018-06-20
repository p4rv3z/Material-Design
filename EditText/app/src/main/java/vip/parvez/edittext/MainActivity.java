package vip.parvez.edittext;

import android.support.constraint.ConstraintLayout;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatEditText;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;

import vip.parvez.services.L;

public class MainActivity extends AppCompatActivity {
    AppCompatEditText userName;
    AppCompatEditText userPassword;
    ConstraintLayout constraintLayout;
    TextInputLayout userNameLayout, userPasswordLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        userName = findViewById(R.id.user_name);
        userPassword = findViewById(R.id.user_password);
        constraintLayout = findViewById(R.id.constraint_layout);
        userNameLayout = findViewById(R.id.user_name_layout);
        userPasswordLayout = findViewById(R.id.user_password_layout);

        constraintLayout.setOnClickListener(null);//focus none

        userName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                L.d("beforeTextChanged: " + s.toString());
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                L.d("onTextChanged: " + s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {
                L.d("afterTextChanged: " + s.toString());

            }
        });
        userPassword.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (userPassword.getText().toString().isEmpty()) {
                    userPasswordLayout.setErrorEnabled(true);
                    userPasswordLayout.setError("Please enter your user name.");
                } else {
                    userPasswordLayout.setErrorEnabled(false);
                }
                L.d("onFocusChange: " + hasFocus);
            }
        });

        userPassword.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                L.d("beforeTextChanged: " + s.toString());
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (userPassword.getText().toString().isEmpty()) {
                    userPasswordLayout.setErrorEnabled(true);
                    userPasswordLayout.setError("Please enter your user name.");
                } else {
                    userPasswordLayout.setErrorEnabled(false);
                }
                L.d("onTextChanged: " + s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {
                L.d("afterTextChanged: " + s.toString());

            }
        });
        userNameLayout.setCounterEnabled(true);
        userNameLayout.setCounterMaxLength(50);
    }
}
