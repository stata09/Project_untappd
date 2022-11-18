package com.example.project_untappd_10_try;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Arrays;

public class Create_account extends AppCompatActivity {

    private ImageButton mSelectImage;
    public static final int GALLERY_REQUEST = 1;

    @SuppressLint({"MissingInflatedId", "ClickableViewAccessibility"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);
        mSelectImage = findViewById(R.id.main_photo);
        mSelectImage.setOnClickListener(v -> {
            Intent galleryIntent = new Intent(Intent.ACTION_GET_CONTENT);
            galleryIntent.setType("image/*");
            startActivityForResult(galleryIntent, GALLERY_REQUEST);
        });

        EditText password;
        final boolean[] pass_visible = {true};

        password = findViewById(R.id.Password);
        password.setOnTouchListener(new View.OnTouchListener() {
            @SuppressLint("ClickableViewAccessibility")
            @Override
            public boolean onTouch(View view, MotionEvent event) {
                final int Right = 2;
                if (event.getAction() == MotionEvent.ACTION_UP) {
                    if (event.getRawX() >= password.getRight() - password.getCompoundDrawables()[Right].getBounds().width()) {
                        int selection = password.getSelectionEnd();
                        if (pass_visible[0]) {
                            //set drawable image here
                            password.setCompoundDrawablesRelativeWithIntrinsicBounds(0, 0, R.drawable.visible_off, 0);
                            //for hide password
                            password.setTransformationMethod(PasswordTransformationMethod.getInstance());
                            pass_visible[0] = false;
                        } else {
                            //set drawable image here
                            password.setCompoundDrawablesRelativeWithIntrinsicBounds(0, 0, R.drawable.visible1, 0);
                            //for show password
                            password.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                            pass_visible[0] = true;
                        }
                        password.setSelection(selection);
                    }
                }
                return false;
            }
        });

        TextView Country;
        ArrayList<String> Countries;

        Country = findViewById(R.id.Country);
        String Country_names = "Абхазия, Австралия, Австрия, Азербайджан, Албания, Алжир, Ангола, Андорра, Антигуа, Аргентина, Армения, Афганистан, Бангладеш, Барбадос, Бахрейн, Белиз, Белоруссия, Бельгия, Бенин, Болгария, Боливия, Ботсвана, Бразилия, Бруней, Буркина-Фасо, Бурунди, Бутан, Вануату, Ватикан, Великобритания, Венгрия, Венесуэла, Вьетнам, Габон, Гаити, Гайана, Гамбия, Гана, Гватемала, Гвинея, Гвинея-Бисау, Германия, Гондурас, Государство, Палестина, Гренада, Греция, Грузия, Дания, Джибути, Доминика, Египет, Замбия, Зимбабве, Израиль, Индия, Индонезия, Иордания, Ирак, Иран, Ирландия, Исландия, Испания, Италия, Йемен, Кабо-Верде, Казахстан, Камбоджа, Камерун, Канада, Катар, Кения, Кипр, Киргизия, Кирибати, Китай, КНДР, Колумбия, Коста-Рика, Куба, Кувейт, Лаос, Латвия, Лесото, Либерия, Ливан, Ливия, Литва, Лихтенштейн, Люксембург, Маврикий, Мавритания, Мадагаскар, Малави, Малайзия, Мали, Мальта, Марокко, Мексика, Мозамбик, Молдавия, Монако, Монголия, Мьянма, Намибия, Науру, Непал, Нигер, Нигерия, Нидерланды, Никарагуа, Норвегия, ОАЭ, Оман, Пакистан, Палау, Панама, Парагвай, Перу, Польша, Португалия, Россия, Руанда, Румыния, Сальвадор, Самоа, Сан-Марино, Саудовская Аравия, Сенегал, Сент-Винсент, Сент-Китс, Сент-Люсия, Сербия, Сингапур, Сирия, Словакия, Словения, Сомали, Судан, Суринам, США, Сьерра-Леоне, Таджикистан, Таиланд, Танзания, Того, Тонга, Тувалу, Тунис, Туркмения, Турция, Уганда, Узбекистан, Украина, Уругвай, Фиджи, Филиппины, Финляндия, Франция, Хорватия, ЦАР, Чад, Черногория, Чехия, Чили, Швейцария, Швеция, Шри-Ланка, Эквадор, Эритрея, Эсватини, Эстония, Эфиопия, ЮАР, Ямайка, Япония";
        Countries = new ArrayList<String>(Arrays.asList(Country_names.split(" , ")));
        Country.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Dialog dialog = new Dialog(Create_account.this);
                dialog.setContentView(R.layout.dialog_search_country);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == GALLERY_REQUEST && resultCode == RESULT_OK) {
            Uri imageUri = data.getData();
            mSelectImage.setImageURI(imageUri);
        }
    }
}