package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RadioGroup radioGroupGender;
    RadioButton radioButtonMale;
    RadioButton radioButtonFemale;
    RadioGroup radioGroupGrade;
    RadioButton radioButtonFreshman;
    RadioButton radioButtonSophomore;
    RadioButton radioButtonJunior;
    RadioButton radioButtonSenior;
    RadioButton radioButtonGraduate;
    CheckBox checkBoxCanteen;
    CheckBox checkBoxRestaurant;
    CheckBox checkBoxStreetVendor;
    CheckBox checkBoxDelivery;
    EditText editTextOtherDiningPlace;
    EditText editTextExpenditure;
    Button buttonSubmit;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //get ID
        radioGroupGender = findViewById(R.id.radio_group_gender);
        radioButtonMale = findViewById(R.id.radio_button_male);
        radioButtonFemale = findViewById(R.id.radio_button_female);

        radioGroupGrade = findViewById(R.id.radio_group_grade);
        radioButtonFreshman = findViewById(R.id.radio_button_freshman);
        radioButtonSophomore = findViewById(R.id.radio_button_sophomore);
        radioButtonJunior = findViewById(R.id.radio_button_junior);
        radioButtonSenior = findViewById(R.id.radio_button_senior);
        radioButtonGraduate = findViewById(R.id.radio_button_graduate);

        checkBoxCanteen = findViewById(R.id.check_box_canteen);
        checkBoxRestaurant = findViewById(R.id.check_box_restaurant);
        checkBoxStreetVendor = findViewById(R.id.check_box_street_vendor);
        checkBoxDelivery = findViewById(R.id.check_box_delivery);
        editTextOtherDiningPlace = findViewById(R.id.edit_text_other_dining_place);

        editTextExpenditure = findViewById(R.id.edit_text_expenditure);

        buttonSubmit = findViewById(R.id.button_submit);

        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //get gender
                int selectedGenderID = radioGroupGender.getCheckedRadioButtonId();
                String selectedGender = "";
                if (selectedGenderID != -1) {
                    RadioButton radioButton = findViewById(selectedGenderID);
                    selectedGender = radioButton.getText().toString();
                }

                // get grade
                int selectedGradeId = radioGroupGrade.getCheckedRadioButtonId();
                String selectedGrade = "";
                if (selectedGradeId != -1) {
                    RadioButton radioButton = findViewById(selectedGradeId);
                    selectedGrade = radioButton.getText().toString();
                }

                // get dining place
                List<String> selectedDiningPlaceList = new ArrayList<>();
                if (checkBoxCanteen.isChecked()) {
                    selectedDiningPlaceList.add(checkBoxCanteen.getText().toString());
                }
                if (checkBoxRestaurant.isChecked()) {
                    selectedDiningPlaceList.add(checkBoxRestaurant.getText().toString());
                }
                if (checkBoxStreetVendor.isChecked()) {
                    selectedDiningPlaceList.add(checkBoxStreetVendor.getText().toString());
                }
                if (checkBoxDelivery.isChecked()) {
                    selectedDiningPlaceList.add(checkBoxDelivery.getText().toString());
                }
                if (!editTextOtherDiningPlace.getText().toString().isEmpty()) {
                    selectedDiningPlaceList.add(editTextOtherDiningPlace.getText().toString());
                }

                // get expenditure
                Double expenditure = null;
                if (!editTextExpenditure.getText().toString().isEmpty()) {
                    expenditure = Double.parseDouble(editTextExpenditure.getText().toString());
                }

            }
        });
    }



}