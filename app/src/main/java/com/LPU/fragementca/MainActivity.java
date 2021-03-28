package com.LPU.fragementca;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public MainActivity(){
        super(R.layout.activity_main);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(savedInstanceState == null){
            getSupportFragmentManager().beginTransaction()
                    .setReorderingAllowed(true)
                    .add(R.id.fragment_cont, new LoginFragment(), null)
                    .commit();
        }

        TextView register = findViewById(R.id.register);

        View.OnClickListener openRegisterFragment = new View.OnClickListener(){
            @Override
            public void onClick(View view){
                replaceFragment(RegisterFragment.class);
                register.setVisibility(view.INVISIBLE);
            }
        };

        register.setOnClickListener(openRegisterFragment);

    }

    public void replaceFragment(Class fragment){
        getSupportFragmentManager().beginTransaction()
                .setReorderingAllowed(true)
                .replace(R.id.fragment_cont, fragment, null)
                .commit();
    }

}