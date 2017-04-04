package ro.pub.cs.systems.eim.practicaltest01var08;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class PracticalTest01Var08MainActivity extends AppCompatActivity {

    private Button button;
    private EditText editText1, editText2, editText3, editText4;
    private PracticalTest01Var08Service practicalTest01Var08Service;

    private IntentFilter intentFilter = new IntentFilter();

    public static final String FIRST_VALUE = "FIRST_VALUE";
    public static final String SECOND_VALUE = "SECOND_VALUE";
    public static final String THIRD_VALUE = "THIRD_VALUE";
    public static final String FORTH_VALUE = "FORTH_VALUE";


    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        editText1.setText(savedInstanceState.getString(FIRST_VALUE));
        editText2.setText(savedInstanceState.getString(SECOND_VALUE));
        editText3.setText(savedInstanceState.getString(THIRD_VALUE));
        editText4.setText(savedInstanceState.getString(FORTH_VALUE));
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);

        savedInstanceState.putString(FIRST_VALUE, editText1.getText().toString());
        savedInstanceState.putString(SECOND_VALUE, editText2.getText().toString());
        savedInstanceState.putString(THIRD_VALUE, editText3.getText().toString());
        savedInstanceState.putString(FORTH_VALUE, editText4.getText().toString());
    }

    @Override
    protected void onPause() {
        unregisterReceiver(myReceiver);
        stopService(new Intent(this, PracticalTest01Var08Service.class));
        super.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        startService(new Intent(this, PracticalTest01Var08Service.class));
        registerReceiver(myReceiver, intentFilter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_var08_main);

        intentFilter.addAction(PracticalTest01Var08Service.ACTION_BROAD);

        button = (Button) findViewById(R.id.button);
        editText1 = (EditText) findViewById(R.id.edit1);
        editText2 = (EditText) findViewById(R.id.edit2);
        editText3 = (EditText) findViewById(R.id.edit3);
        editText4 = (EditText) findViewById(R.id.edit4);

        editText1.setSaveEnabled(false);
        editText2.setSaveEnabled(false);
        editText3.setSaveEnabled(false);
        editText4.setSaveEnabled(false);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!isValidInteger(editText1.getText().toString()) || !isValidInteger(editText1.getText().toString()) ||
                        !isValidInteger(editText1.getText().toString()) || !isValidInteger(editText1.getText().toString()))
                    return;

                Intent intent = new Intent(PracticalTest01Var08MainActivity.this, PracticalTest01Var08SecondaryActivity.class);
                intent.putExtra(FIRST_VALUE, editText1.getText().toString());
                intent.putExtra(SECOND_VALUE, editText2.getText().toString());
                intent.putExtra(THIRD_VALUE, editText3.getText().toString());
                intent.putExtra(FORTH_VALUE, editText4.getText().toString());
                startActivity(intent);
            }
        });
    }

    public static Boolean isValidInteger(String value) {
        try {
            Integer val = Integer.valueOf(value);
            if (val != null)
                return true;
            else
                return false;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private BroadcastReceiver myReceiver = new BroadcastReceiver() {

        public void onReceive(Context context, Intent intent) {
            if(intent.getIntExtra(FIRST_VALUE, 0) != 0) {
                editText1.setText(String.valueOf(intent.getIntExtra(FIRST_VALUE,0)));
                editText2.setText(String.valueOf(intent.getIntExtra(SECOND_VALUE,0)));
                editText3.setText(String.valueOf(intent.getIntExtra(THIRD_VALUE,0)));
                editText4.setText(String.valueOf(intent.getIntExtra(FORTH_VALUE,0)));
            }
        }
    };
}
