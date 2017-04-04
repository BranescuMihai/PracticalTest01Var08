package ro.pub.cs.systems.eim.practicaltest01var08;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Copyright © 2017 Deutsche Bank. All rights reserved.
 */
public class PracticalTest01Var08SecondaryActivity extends AppCompatActivity {

    private Button sum, product;
    private EditText editText1, editText2, editText3, editText4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_var08_secondary);

        sum = (Button) findViewById(R.id.sum);
        product = (Button) findViewById(R.id.product);
        editText1 = (EditText) findViewById(R.id.edit1);
        editText2 = (EditText) findViewById(R.id.edit2);
        editText3 = (EditText) findViewById(R.id.edit3);
        editText4 = (EditText) findViewById(R.id.edit4);

        editText1.setText(getIntent().getStringExtra(PracticalTest01Var08MainActivity.FIRST_VALUE));
        editText2.setText(getIntent().getStringExtra(PracticalTest01Var08MainActivity.SECOND_VALUE));
        editText3.setText(getIntent().getStringExtra(PracticalTest01Var08MainActivity.THIRD_VALUE));
        editText4.setText(getIntent().getStringExtra(PracticalTest01Var08MainActivity.FORTH_VALUE));

        sum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int sum = Integer.valueOf(editText1.getText().toString()) +
                        Integer.valueOf(editText2.getText().toString()) +
                        Integer.valueOf(editText3.getText().toString()) +
                        Integer.valueOf(editText4.getText().toString());
                Toast.makeText(PracticalTest01Var08SecondaryActivity.this, String.valueOf(sum),
                        Toast.LENGTH_LONG).show();
            }
        });

        product.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int prod = Integer.valueOf(editText1.getText().toString()) *
                        Integer.valueOf(editText2.getText().toString()) *
                        Integer.valueOf(editText3.getText().toString()) *
                        Integer.valueOf(editText4.getText().toString());
                Toast.makeText(PracticalTest01Var08SecondaryActivity.this, String.valueOf(prod),
                        Toast.LENGTH_LONG).show();
            }
        });

    }
}
