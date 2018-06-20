package vip.parvez.selectioncontrols;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatCheckBox;
import android.support.v7.widget.AppCompatRadioButton;
import android.support.v7.widget.SwitchCompat;
import android.widget.CompoundButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    SwitchCompat switchLight;
    AppCompatCheckBox checkBox;
    AppCompatRadioButton radioButton;
    RadioGroup genderRadioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        switchLight = findViewById(R.id.switch_light);
        checkBox = findViewById(R.id.checkbox);
        radioButton = findViewById(R.id.radio_button);
        genderRadioGroup = findViewById(R.id.gender_radio_group);

        switchLight.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Toast.makeText(getApplicationContext(), "Light is : " + isChecked, Toast.LENGTH_LONG).show();
            }
        });

        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Toast.makeText(getApplicationContext(), "CheckBox is : " + isChecked, Toast.LENGTH_LONG).show();
            }
        });

        radioButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Toast.makeText(getApplicationContext(), "RadioButton is : " + isChecked, Toast.LENGTH_LONG).show();
            }
        });

        genderRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                AppCompatRadioButton checkedRadioButton = group.findViewById(checkedId);
                boolean isChecked = checkedRadioButton.isChecked();
                Toast.makeText(getApplicationContext(),"Radio Group child: "+checkedRadioButton.getText()+" is "+isChecked,Toast.LENGTH_LONG).show();
            }
        });
    }
}
