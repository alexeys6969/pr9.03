package com.example.matule_shashin;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.example.uicomponents.button.BthBig;
import com.example.uicomponents.button.BthCustom;

import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.example.uicomponents.et.EtCustom;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        BthBig bthPrimary = findViewById(R.id.bthPrimary);
        BthBig bthEnable = findViewById(R.id.bthEnable);
        BthBig bthTetriary = findViewById(R.id.bthTertiary);
        BthBig bthSecondary = findViewById(R.id.bthSecondary);

        bthPrimary.init("Отправить", BthCustom.TypeButton.PRIMARY);
        bthEnable.setEnabled(false);
        bthTetriary.init("Авторизоваться", BthCustom.TypeButton.TETRTIARY);
        bthSecondary.init("Забыли пароль?", BthCustom.TypeButton.SECONDARY);

        EtCustom etName = findViewById(R.id.etName);
        EtCustom etLastName = findViewById(R.id.etLastName);
        EtCustom etLastNameError = findViewById(R.id.etLastNameError);

        etName.init("Укажите имя", "Иван", "", EtCustom.TypeET.DEFAULT);
        etLastName.init("Укажите фамилию", "Иванов", "", EtCustom.TypeET.DEFAULT);
        etLastNameError.init("Укажите email", "example@mail.com", "", EtCustom.TypeET.DEFAULT);

        etName.Et.setOnFocusChangeListener((v, hasFocus) -> {
            if (hasFocus) {
                etName.setType(EtCustom.TypeET.HOVER);
            } else if (etName.getText().isEmpty()) {
                etName.setType(EtCustom.TypeET.DEFAULT);
            }
        });

        etLastName.Et.setOnFocusChangeListener((v, hasFocus) -> {
            if (hasFocus) {
                etLastName.setType(EtCustom.TypeET.HOVER);
            } else if (etLastName.getText().isEmpty()) {
                etLastName.setType(EtCustom.TypeET.DEFAULT);
            }
        });

        etLastNameError.Et.setOnFocusChangeListener((v, hasFocus) -> {
            if (hasFocus) {
                etLastNameError.setType(EtCustom.TypeET.HOVER);
            } else if (etLastNameError.getText().isEmpty()) {
                etLastNameError.setType(EtCustom.TypeET.DEFAULT);
            }
        });

        bthTetriary.Bth.setOnClickListener(v -> {
            boolean isValid = true;

            if (etName.getText().isEmpty()) {
                etName.setError("Имя обязательно для заполнения");
                isValid = false;
            } else {
                etName.clearError();
            }

            if (etLastName.getText().isEmpty()) {
                etLastName.setError("Фамилия обязательна для заполнения");
                isValid = false;
            } else {
                etLastName.clearError();
            }

            if (etLastNameError.getText().isEmpty()) {
                etLastNameError.setError("Введите корректный email");
                isValid = false;
            } else {
                etLastNameError.clearError();
            }

            if (isValid) {
                Toast.makeText(this, "Данные отправлены", Toast.LENGTH_SHORT).show();
            }
        });
    }
}