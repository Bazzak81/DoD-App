package com.example.dod_xp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActionBar;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import static android.text.TextUtils.isDigitsOnly;

public class MainActivity extends AppCompatActivity {

    private EditText editTextCurrentSkill;
    private EditText editTextNewSkill;
    private TextView textViewSkillCostSum;
    private Button btnPrimary;
    private Button btnProfession;
    private Button btnSecondary;
    private int calculationMultiplier = 0;
    private String currentValue = "";
    private String newValue = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);

        initiate();
    }

    public void initiate() {
        editTextCurrentSkill = (EditText) findViewById(R.id.editTextCurrentSkill);
        editTextNewSkill = (EditText) findViewById(R.id.editTextNewSkill);
        textViewSkillCostSum = (TextView) findViewById(R.id.textViewSkillCostSum);
        btnPrimary = (Button) findViewById(R.id.btnPrimary);
        btnProfession = (Button) findViewById(R.id.btnProfession);
        btnSecondary = (Button) findViewById(R.id.btnSecondary);

        btnPrimary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (controlOfNumbers()) {
                    calculationMultiplier = 2; //TODO Kolla med henke
                    calculate();
                }
            }
        });

        btnProfession.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (controlOfNumbers()) {
                    calculationMultiplier = 3; //TODO Kolla med henke
                    calculate();
                }
            }
        });

        btnSecondary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (controlOfNumbers()) {
                    calculationMultiplier = 5; //TODO Kolla med henke
                    calculate();
                }
            }
        });
    }

    public boolean controlOfNumbers() {
        currentValue = editTextCurrentSkill.getText().toString();
        newValue = editTextNewSkill.getText().toString();

        if (!currentValue.equals("") && !newValue.equals("")) {
            if (isDigitsOnly(currentValue) && isDigitsOnly(newValue)) {
                return true;
            }
        }
        textViewSkillCostSum.setText("Error: Input must be numbers");
        return false;
    }

    public void calculate() {
        int currentValueInt = Integer.parseInt(currentValue);
        int newValueInt = Integer.parseInt(newValue);
        int result = 0;

        if (currentValueInt >= 50 || currentValueInt > newValueInt ) {
            textViewSkillCostSum.setText("Error: index out of bound");
        } else {
            while (currentValueInt < newValueInt) {
                if (currentValueInt < 10) {
                    result++;
                    currentValueInt++;
                } else if (currentValueInt >= 10 && currentValueInt < 14) {
                    result = result + 2;
                    currentValueInt++;
                } else if (currentValueInt >= 14 && currentValueInt < 17) {
                    result = result + 3;
                    currentValueInt++;
                } else if (currentValueInt >= 17 && currentValueInt < 20) {
                    result = result + 4;
                    currentValueInt++;
                } else if (currentValueInt >= 20 && currentValueInt < 23) {
                    result = result + 5;
                    currentValueInt++;
                } else if (currentValueInt >= 23 && currentValueInt < 26) {
                    result = result + 6;
                    currentValueInt++;
                } else if (currentValueInt >= 26 && currentValueInt < 29) {
                    result = result + 7;
                    currentValueInt++;
                } else if (currentValueInt >= 29 && currentValueInt < 32) {
                    result = result + 8;
                    currentValueInt++;
                } else if (currentValueInt >= 32 && currentValueInt < 35) {
                    result = result + 9;
                    currentValueInt++;
                } else if (currentValueInt >= 35 && currentValueInt < 38) {
                    result = result + 10;
                    currentValueInt++;
                } else if (currentValueInt >= 38 && currentValueInt < 41) {
                    result = result + 11;
                    currentValueInt++;
                } else if (currentValueInt >= 41 && currentValueInt < 44) {
                    result = result + 12;
                    currentValueInt++;
                } else if (currentValueInt >= 44 && currentValueInt < 47) {
                    result = result + 13;
                    currentValueInt++;
                } else if (currentValueInt >= 47 && currentValueInt < 50) {
                    result = result + 14;
                    currentValueInt++;
                }
            }
            result = result * calculationMultiplier;
            textViewSkillCostSum.setText(String.valueOf(result));
        }
        currentValue = "";
        newValue = "";
        calculationMultiplier = 0;
    }

}
