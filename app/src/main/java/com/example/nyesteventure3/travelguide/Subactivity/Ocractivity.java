package com.example.nyesteventure3.travelguide.Subactivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.nyesteventure3.travelguide.R;

public class Ocractivity extends AppCompatActivity implements OnItemSelectedListener{


    private final int REQUEST_GALLERY = 0;
    private final int REQUEST_CAMERA = 1;

    private static final String TAG = Ocractivity.class.getSimpleName();

    private Uri imageUri;
    private TextView detectedTextView;

     String[] country = {"choose language","Bengali","Gujarati","Hindi","Kannada","Malayalam","Marathi","Punjabi","Tamil","Telugu","Urdu"};
     Spinner spin;
     public static String language1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ocractivity);

        setTitle("Camera Translation");

        Button TButton = (Button) findViewById(R.id.Translatebutton);
        final TextView Ttext = (TextView) findViewById(R.id.TranslateTextView);
        detectedTextView = (TextView) findViewById(R.id.detected_text);

        detectedTextView.setText(" ");
        Ttext.setText("");
        detectedTextView.clearFocus();



                Spinner spin = (Spinner) findViewById(R.id.spinner1);
                spin.setOnItemSelectedListener(this);
                ArrayAdapter aa = new ArrayAdapter(this,android.R.layout.simple_spinner_item,country);
                aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spin.setAdapter(aa);




        SharedPreferences sharedPreferences;

        sharedPreferences = getSharedPreferences("MyPref",
                Context.MODE_PRIVATE);
        SharedPreferences.Editor ed=sharedPreferences.edit();
        if (sharedPreferences.contains("keyname")) {
            //   if("keyname"!=null)
            detectedTextView.setText(sharedPreferences.getString("keyname", ""));

            ed.putString("keyname"," ");
            ed.commit();
            // else
            //   detectedTextView.setText(" ");
        }

        findViewById(R.id.take_a_photo).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Ocractivity.this, Camera1.class);
                startActivity(i);


            }
        });


        TButton.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("NewApi")
            @Override
            public void onClick(View view) {

                if (language1.equals("Hindi"))
                {
                    String inputString = detectedTextView.getText().toString();
                    String text = Ttext.getText().toString();
                    detectedTextView.setText(" ");
                    if (inputString.contains("Right")) {
                        Ttext.setText((text + System.lineSeparator() + "सही"));
                    }
                    if (inputString.contains("Left")) {
                        Ttext.setText((text + System.lineSeparator() + "बाएं"));
                    }
                    if (inputString.contains("Place")) {
                        Ttext.setText((text + System.lineSeparator() + "जगह"));
                    }
                    if (inputString.equals("Where")) {
                        Ttext.setText((text + System.lineSeparator() + "कहा पे"));
                    }
                    if (inputString.contains("When")) {
                        Ttext.setText((text + System.lineSeparator() + "कब"));
                    }
                    if (inputString.contains("Time")) {
                        Ttext.setText((text + System.lineSeparator() + "पहर"));
                    }
                    if (inputString.equals("How")) {
                        Ttext.setText((text + System.lineSeparator() + "किस तरह"));
                    }
                    if (inputString.contains("Vehicle")) {
                        Ttext.setText((text + System.lineSeparator() + "वाहन"));
                    }
                    if (inputString.contains("Me")) {
                        Ttext.setText((text + System.lineSeparator() + "मुझे"));
                    }
                    if (inputString.contains("Yours")) {
                        Ttext.setText((text + System.lineSeparator() + "आपका अपना"));
                    }
                    if (inputString.contains("Who")) {
                        Ttext.setText((text + System.lineSeparator() + "कौन"));
                    }
                    if (inputString.contains("Clothes")) {
                        Ttext.setText((text + System.lineSeparator() + "वस्त्र"));
                    }
                    if (inputString.contains("Money")) {
                        Ttext.setText((text + System.lineSeparator() + "पैसे"));
                    }
                    if (inputString.contains("Tea")) {
                        Ttext.setText((text + System.lineSeparator() + "चाय"));
                    }
                    if (inputString.contains("Water")) {
                        Ttext.setText((text + System.lineSeparator() + "पानी"));
                    }
                    if (inputString.contains("Food")) {
                        Ttext.setText((text + System.lineSeparator() + "भोजन"));
                    }
                    if (inputString.contains("Speak")) {
                        Ttext.setText((text + System.lineSeparator() + "बोले"));
                    }
                    if (inputString.contains("Slowly")) {
                        Ttext.setText((text + System.lineSeparator() + "धीरे से"));
                    }
                    if (inputString.contains("No")) {
                        Ttext.setText((text + System.lineSeparator() + "नहीं"));
                    }
                    if (inputString.contains("Yes")) {
                        Ttext.setText((text + System.lineSeparator() + "हाँ"));
                    }
                    if (inputString.contains("Please")) {
                        Ttext.setText((text + System.lineSeparator() + "कृप्या"));
                    }
                    if (inputString.contains("Thank you")) {
                        Ttext.setText((text + System.lineSeparator() + "धन्यवाद"));
                    }
                    if (inputString.contains("Happy")) {
                        Ttext.setText((text + System.lineSeparator() + "खुश"));
                    }
                    if (inputString.contains("What")) {
                        Ttext.setText((text + System.lineSeparator() + "क्या"));
                    }
                    if (inputString.contains("ticket")) {
                        Ttext.setText((text + System.lineSeparator() + "मुझे यह टिकट कहाँ मिल सकता है"));
                    }
                    if (inputString.contains("icecream")) {
                        Ttext.setText((text + System.lineSeparator() + "मुझे यह आइसक्रीम कहां मिल सकती है"));
                    }
                    if (inputString.contains("marinedrive")) {
                        Ttext.setText((text + System.lineSeparator() + "मैं समुद्री ड्राइव कैसे पहुंचा?"));
                    }
                    if (inputString.contains("fortkochi")) {
                        Ttext.setText((text + System.lineSeparator() + "मैं किला कोच्चि तक कैसे पहुंचा?"));
                    }
                    if (inputString.contains("Can")) {
                        Ttext.setText((text + System.lineSeparator() + "क्या आप मेरी मदद कर सकते हैं"));
                    }
                    if (inputString.contains("Help")) {
                        Ttext.setText((text + System.lineSeparator() + "मेरी मदद करो"));
                    }
                    if (inputString.contains("lost")) {
                        Ttext.setText((text + System.lineSeparator() + "मै खो गया हूँ"));
                    }
                    if (inputString.contains("cherai")) {
                        Ttext.setText((text + System.lineSeparator() + "चेरी कहाँ है"));
                    }
                    if (inputString.contains("tripunithura")) {
                        Ttext.setText("ट्रिपिनिथरा कहां है");
                    }
                    detectedTextView.setText(" ");

                }
                if (language1.equals("Malayalam")) {
                    String inputString = detectedTextView.getText().toString();
                    String text = Ttext.getText().toString();
                    detectedTextView.setText(" ");

                    if (inputString.contains("Right")) {
                        Ttext.setText((text + System.lineSeparator() + "വലത്തെ"));
                    }

                    if (inputString.contains("Left")) {
                        Ttext.setText((text + System.lineSeparator() + "ഇടത്തെ"));
                    }
                    if (inputString.contains("Place")) {
                        Ttext.setText((text + System.lineSeparator() + "സ്ഥലം"));
                    }
                    if (inputString.equals("Where")) {
                        Ttext.setText((text + System.lineSeparator() + "എവിടെയാണ്"));
                    }
                    if (inputString.contains("When")) {
                        Ttext.setText((text + System.lineSeparator() + "എപ്പോൾ"));
                    }
                    if (inputString.contains("Time")) {
                        Ttext.setText((text + System.lineSeparator() + "സമയം"));
                    }
                    if (inputString.equals("How")) {
                        Ttext.setText((text + System.lineSeparator() + "എങ്ങനെ"));
                    }
                    if (inputString.contains("Vehicle")) {
                        Ttext.setText((text + System.lineSeparator() + "വാഹനം"));
                    }
                    if (inputString.contains("Me")) {
                        Ttext.setText((text + System.lineSeparator() + "ഞാൻ"));
                    }
                    if (inputString.contains("Yours")) {
                        Ttext.setText((text + System.lineSeparator() + "താങ്കളുടെ"));
                    }
                    if (inputString.contains("Who")) {
                        Ttext.setText((text + System.lineSeparator() + "ആര്"));
                    }
                    if (inputString.contains("Cloth")) {
                        Ttext.setText((text + System.lineSeparator() + "വസ്ത്രം"));
                    }
                    if (inputString.contains("Money")) {
                        Ttext.setText((text + System.lineSeparator() + "പണം"));
                    }
                    if (inputString.contains("Tea")) {
                        Ttext.setText((text + System.lineSeparator() + "ചായ"));
                    }
                    if (inputString.contains("Water")) {
                        Ttext.setText((text + System.lineSeparator() + "വെള്ളം"));
                    }
                    if (inputString.contains("Food")) {
                        Ttext.setText((text + System.lineSeparator() + "ഭക്ഷണം"));
                    }
                    if (inputString.contains("Speak")) {
                        Ttext.setText((text + System.lineSeparator() + "സംസാരിക്കുക"));
                    }
                    if (inputString.contains("Slowly")) {
                        Ttext.setText((text + System.lineSeparator() + "പതുക്കെ"));
                    }
                    if (inputString.contains("No")) {
                        Ttext.setText((text + System.lineSeparator() + "ഇല്ല"));
                    }
                    if (inputString.contains("Yes")) {
                        Ttext.setText((text + System.lineSeparator() + "അതെ"));
                    }
                    if (inputString.contains("Please")) {
                        Ttext.setText((text + System.lineSeparator() + "ദയവായി"));
                    }
                    if (inputString.contains("Thank you")) {
                        Ttext.setText((text + System.lineSeparator() + "നന്ദി"));
                    }
                    if (inputString.contains("Happy")) {
                        Ttext.setText((text + System.lineSeparator() + "സന്തോഷം"));
                    }
                    if (inputString.contains("What")) {
                        Ttext.setText((text + System.lineSeparator() + "എന്ത്"));
                    }
                    if (inputString.contains("ticket")) {
                        Ttext.setText((text + System.lineSeparator() + "ടിക്കറ്റ്"));
                    }
                    if (inputString.contains("icecream")) {
                        Ttext.setText((text + System.lineSeparator() + "ഐസ്ക്രീം"));
                    }

                    if (inputString.contains("Can")) {
                        Ttext.setText((text + System.lineSeparator() + "കഴിയും"));
                    }
                    if (inputString.contains("Help")) {
                        Ttext.setText((text + System.lineSeparator() + "സഹായിക്കൂ"));
                    }
                    if (inputString.contains("lost")) {
                        Ttext.setText((text + System.lineSeparator() + "നഷ്ടപ്പെട്ടു"));
                    }

                            detectedTextView.setText(" ");
                }
                if (language1.equals("Kannada")) {
                    String inputString = detectedTextView.getText().toString();
                    String text = Ttext.getText().toString();
                    detectedTextView.setText(" ");

                    if (inputString.contains("Right")) {
                        Ttext.setText((text + System.lineSeparator() + "ಬಲ"));
                    }

                    if (inputString.contains("Left")) {
                        Ttext.setText((text + System.lineSeparator() + "ಎಡ"));
                    }
                    if (inputString.contains("Place")) {
                        Ttext.setText((text + System.lineSeparator() + "ಸ್ಥಳ"));
                    }
                    if (inputString.equals("Where")) {
                        Ttext.setText((text + System.lineSeparator() + "ಎಲ್ಲಿ"));
                    }
                    if (inputString.contains("When")) {
                        Ttext.setText((text + System.lineSeparator() + "ಯಾವಾಗ"));
                    }
                    if (inputString.contains("Time")) {
                        Ttext.setText((text + System.lineSeparator() + "ಸಮಯ"));
                    }
                    if (inputString.equals("How")) {
                        Ttext.setText((text + System.lineSeparator() + "ಹೇಗೆ"));
                    }
                    if (inputString.contains("Vehicle")) {
                        Ttext.setText((text + System.lineSeparator() + "ವಾಹನ"));
                    }
                    if (inputString.contains("Me")) {
                        Ttext.setText((text + System.lineSeparator() + "ಮಿ"));
                    }
                    if (inputString.contains("Yours")) {
                        Ttext.setText((text + System.lineSeparator() + "ನಿಮ್ಮದು"));
                    }
                    if (inputString.contains("Who")) {
                        Ttext.setText((text + System.lineSeparator() + "ಯಾರು"));
                    }
                    if (inputString.contains("Clothes")) {
                        Ttext.setText((text + System.lineSeparator() + "ಬಟ್ಟೆ"));
                    }
                    if (inputString.contains("Money")) {
                        Ttext.setText((text + System.lineSeparator() + "ಹಣ"));
                    }
                    if (inputString.contains("Tea")) {
                        Ttext.setText((text + System.lineSeparator() + "ಚಹಾ"));
                    }
                    if (inputString.contains("Water")) {
                        Ttext.setText((text + System.lineSeparator() + "ನೀರು"));
                    }
                    if (inputString.contains("Food")) {
                        Ttext.setText((text + System.lineSeparator() + "ಆಹಾರ"));
                    }
                    if (inputString.contains("Speak")) {
                        Ttext.setText((text + System.lineSeparator() + "ಮಾತನಾಡಿ"));
                    }
                    if (inputString.contains("Slowly")) {
                        Ttext.setText((text + System.lineSeparator() + "ನಿಧಾನವಾಗಿ"));
                    }
                    if (inputString.contains("No")) {
                        Ttext.setText((text + System.lineSeparator() + "ಇಲ್ಲ"));
                    }
                    if (inputString.contains("Yes")) {
                        Ttext.setText((text + System.lineSeparator() + "ಹೌದು"));
                    }
                    if (inputString.contains("Please")) {
                        Ttext.setText((text + System.lineSeparator() + "ದಯವಿಟ್ಟು"));
                    }
                    if (inputString.contains("Thank you")) {
                        Ttext.setText((text + System.lineSeparator() + "ಧನ್ಯವಾದ"));
                    }
                    if (inputString.contains("Happy")) {
                        Ttext.setText((text + System.lineSeparator() + "ಸಂತೋಷ"));
                    }
                    if (inputString.contains("What")) {
                        Ttext.setText((text + System.lineSeparator() + "ಏನು"));
                    }
                    if (inputString.contains("ticket")) {
                        Ttext.setText((text + System.lineSeparator() + "ಟಿಕೆಟ್"));
                    }
                    if (inputString.contains("icecream")) {
                        Ttext.setText((text + System.lineSeparator() + "ಐಸ್ ಕ್ರೀಮ್"));
                    }

                    if (inputString.contains("Can")) {
                        Ttext.setText((text + System.lineSeparator() + "ಕ್ಯಾನ್"));
                    }
                    if (inputString.contains("Help")) {
                        Ttext.setText((text + System.lineSeparator() + "ಸಹಾಯ"));
                    }
                    if (inputString.contains("lost")) {
                        Ttext.setText((text + System.lineSeparator() + "ಕಳೆದುಹೋಗಿದೆ"));
                    }

                    detectedTextView.setText(" ");
                }
                if (language1.equals("Marathi")) {
                    String inputString = detectedTextView.getText().toString();
                    String text = Ttext.getText().toString();
                    detectedTextView.setText(" ");

                    if (inputString.contains("Right")) {
                        Ttext.setText((text + System.lineSeparator() + "उजवे"));
                    }

                    if (inputString.contains("Left")) {
                        Ttext.setText((text + System.lineSeparator() + "डावे"));
                    }
                    if (inputString.contains("Place")) {
                        Ttext.setText((text + System.lineSeparator() + "ठिकाण"));
                    }
                    if (inputString.equals("Where")) {
                        Ttext.setText((text + System.lineSeparator() + "कुठे"));
                    }
                    if (inputString.contains("When")) {
                        Ttext.setText((text + System.lineSeparator() + "कधी"));
                    }
                    if (inputString.contains("Time")) {
                        Ttext.setText((text + System.lineSeparator() + "वेळ"));
                    }
                    if (inputString.equals("How")) {
                        Ttext.setText((text + System.lineSeparator() + "कसे"));
                    }
                    if (inputString.contains("Vehicle")) {
                        Ttext.setText((text + System.lineSeparator() + "वाहन"));
                    }
                    if (inputString.contains("Me")) {
                        Ttext.setText((text + System.lineSeparator() + "मी"));
                    }
                    if (inputString.contains("Yours")) {
                        Ttext.setText((text + System.lineSeparator() + "आपला"));
                    }
                    if (inputString.contains("Who")) {
                        Ttext.setText((text + System.lineSeparator() + "कोण"));
                    }
                    if (inputString.contains("Clothes")) {
                        Ttext.setText((text + System.lineSeparator() + "कपडे"));
                    }
                    if (inputString.contains("Money")) {
                        Ttext.setText((text + System.lineSeparator() + "पैसे"));
                    }
                    if (inputString.contains("Tea")) {
                        Ttext.setText((text + System.lineSeparator() + "चहा"));
                    }
                    if (inputString.contains("Water")) {
                        Ttext.setText((text + System.lineSeparator() + "पाणी"));
                    }
                    if (inputString.contains("Food")) {
                        Ttext.setText((text + System.lineSeparator() + "अन्न"));
                    }
                    if (inputString.contains("Speak")) {
                        Ttext.setText((text + System.lineSeparator() + "बोला"));
                    }
                    if (inputString.contains("Slowly")) {
                        Ttext.setText((text + System.lineSeparator() + "हळूहळू"));
                    }
                    if (inputString.contains("No")) {
                        Ttext.setText((text + System.lineSeparator() + "नाही"));
                    }
                    if (inputString.contains("Yes")) {
                        Ttext.setText((text + System.lineSeparator() + "होय"));
                    }
                    if (inputString.contains("Please")) {
                        Ttext.setText((text + System.lineSeparator() + "कृपया"));
                    }
                    if (inputString.contains("Thank you")) {
                        Ttext.setText((text + System.lineSeparator() + "धन्यवाद"));
                    }
                    if (inputString.contains("Happy")) {
                        Ttext.setText((text + System.lineSeparator() + "आनंदी"));
                    }
                    if (inputString.contains("What")) {
                        Ttext.setText((text + System.lineSeparator() + "काय"));
                    }
                    if (inputString.contains("ticket")) {
                        Ttext.setText((text + System.lineSeparator() + "तिकीट"));
                    }
                    if (inputString.contains("icecream")) {
                        Ttext.setText((text + System.lineSeparator() + "आईसक्रीम"));
                    }

                    if (inputString.contains("Can")) {
                        Ttext.setText((text + System.lineSeparator() + "कॅन"));
                    }
                    if (inputString.contains("Help")) {
                        Ttext.setText((text + System.lineSeparator() + "मदत"));
                    }
                    if (inputString.contains("lost")) {
                        Ttext.setText((text + System.lineSeparator() + "गमावले"));
                    }

                    detectedTextView.setText(" ");
                }
                if (language1.equals("Bengali")) {
                    String inputString = detectedTextView.getText().toString();
                    String text = Ttext.getText().toString();
                    detectedTextView.setText(" ");

                    if (inputString.contains("Right")) {
                        Ttext.setText((text + System.lineSeparator() + "অধিকার"));
                    }

                    if (inputString.contains("Left")) {
                        Ttext.setText((text + System.lineSeparator() + "বাম"));
                    }
                    if (inputString.contains("Place")) {
                        Ttext.setText((text + System.lineSeparator() + "জায়গা"));
                    }
                    if (inputString.equals("Where")) {
                        Ttext.setText((text + System.lineSeparator() + "কোথায়"));
                    }
                    if (inputString.contains("When")) {
                        Ttext.setText((text + System.lineSeparator() + "কখন"));
                    }
                    if (inputString.contains("Time")) {
                        Ttext.setText((text + System.lineSeparator() + "সময়"));
                    }
                    if (inputString.equals("How")) {
                        Ttext.setText((text + System.lineSeparator() + "কিভাবে"));
                    }
                    if (inputString.contains("Vehicle")) {
                        Ttext.setText((text + System.lineSeparator() + "বাহন"));
                    }
                    if (inputString.contains("Me")) {
                        Ttext.setText((text + System.lineSeparator() + "আমাকে"));
                    }
                    if (inputString.contains("Yours")) {
                        Ttext.setText((text + System.lineSeparator() + "আপনার"));
                    }
                    if (inputString.contains("Who")) {
                        Ttext.setText((text + System.lineSeparator() + "কে"));
                    }
                    if (inputString.contains("Clothes")) {
                        Ttext.setText((text + System.lineSeparator() + "বস্ত্র"));
                    }
                    if (inputString.contains("Money")) {
                        Ttext.setText((text + System.lineSeparator() + "টাকা"));
                    }
                    if (inputString.contains("Tea")) {
                        Ttext.setText((text + System.lineSeparator() + "চা"));
                    }
                    if (inputString.contains("Water")) {
                        Ttext.setText((text + System.lineSeparator() + "পানি"));
                    }
                    if (inputString.contains("Food")) {
                        Ttext.setText((text + System.lineSeparator() + "খাদ্য"));
                    }
                    if (inputString.contains("Speak")) {
                        Ttext.setText((text + System.lineSeparator() + "কথা বলা"));
                    }
                    if (inputString.contains("Slowly")) {
                        Ttext.setText((text + System.lineSeparator() + "ধীরে ধীরে"));
                    }
                    if (inputString.contains("No")) {
                        Ttext.setText((text + System.lineSeparator() + "না"));
                    }
                    if (inputString.contains("Yes")) {
                        Ttext.setText((text + System.lineSeparator() + "হাঁ"));
                    }
                    if (inputString.contains("Please")) {
                        Ttext.setText((text + System.lineSeparator() + "অনুগ্রহ"));
                    }
                    if (inputString.contains("Thank you")) {
                        Ttext.setText((text + System.lineSeparator() + "ধন্যবাদ"));
                    }
                    if (inputString.contains("Happy")) {
                        Ttext.setText((text + System.lineSeparator() + "খুশি"));
                    }
                    if (inputString.contains("What")) {
                        Ttext.setText((text + System.lineSeparator() + "কি"));
                    }
                    if (inputString.contains("ticket")) {
                        Ttext.setText((text + System.lineSeparator() + "টিকেট"));
                    }
                    if (inputString.contains("icecream")) {
                        Ttext.setText((text + System.lineSeparator() + "আইসক্রিম"));
                    }

                    if (inputString.contains("Can")) {
                        Ttext.setText((text + System.lineSeparator() + "ক্যান"));
                    }
                    if (inputString.contains("Help")) {
                        Ttext.setText((text + System.lineSeparator() + "সাহায্য করুন"));
                    }
                    if (inputString.contains("lost")) {
                        Ttext.setText((text + System.lineSeparator() + "নষ্ট"));
                    }

                    detectedTextView.setText(" ");
                }
                if (language1.equals("Telugu")) {
                    String inputString = detectedTextView.getText().toString();
                    String text = Ttext.getText().toString();
                    detectedTextView.setText(" ");

                    if (inputString.contains("Right")) {
                        Ttext.setText((text + System.lineSeparator() + "కుడి"));
                    }

                    if (inputString.contains("Left")) {
                        Ttext.setText((text + System.lineSeparator() + "ఎడమ"));
                    }
                    if (inputString.contains("Place")) {
                        Ttext.setText((text + System.lineSeparator() + "ప్లేస్"));
                    }
                    if (inputString.equals("Where")) {
                        Ttext.setText((text + System.lineSeparator() + "ఎక్కడ"));
                    }
                    if (inputString.contains("When")) {
                        Ttext.setText((text + System.lineSeparator() + "ఎప్పుడు"));
                    }
                    if (inputString.contains("Time")) {
                        Ttext.setText((text + System.lineSeparator() + "సమయం"));
                    }
                    if (inputString.equals("How")) {
                        Ttext.setText((text + System.lineSeparator() + "ఎలా"));
                    }
                    if (inputString.contains("Vehicle")) {
                        Ttext.setText((text + System.lineSeparator() + "వాహనం"));
                    }
                    if (inputString.contains("Me")) {
                        Ttext.setText((text + System.lineSeparator() + "నాకు"));
                    }
                    if (inputString.contains("Yours")) {
                        Ttext.setText((text + System.lineSeparator() + "యువర్స్"));
                    }
                    if (inputString.contains("Who")) {
                        Ttext.setText((text + System.lineSeparator() + "ఎవరు"));
                    }
                    if (inputString.contains("Clothes")) {
                        Ttext.setText((text + System.lineSeparator() + "బట్టలు"));
                    }
                    if (inputString.contains("Money")) {
                        Ttext.setText((text + System.lineSeparator() + "మనీ"));
                    }
                    if (inputString.contains("Tea")) {
                        Ttext.setText((text + System.lineSeparator() + "టీ"));
                    }
                    if (inputString.contains("Water")) {
                        Ttext.setText((text + System.lineSeparator() + "నీటి"));
                    }
                    if (inputString.contains("Food")) {
                        Ttext.setText((text + System.lineSeparator() + "ఆహార"));
                    }
                    if (inputString.contains("Speak")) {
                        Ttext.setText((text + System.lineSeparator() + "మాట్లాడు"));
                    }
                    if (inputString.contains("Slowly")) {
                        Ttext.setText((text + System.lineSeparator() + "నెమ్మదిగా"));
                    }
                    if (inputString.contains("No")) {
                        Ttext.setText((text + System.lineSeparator() + "తోబుట్టువుల"));
                    }
                    if (inputString.contains("Yes")) {
                        Ttext.setText((text + System.lineSeparator() + "అవును"));
                    }
                    if (inputString.contains("Please")) {
                        Ttext.setText((text + System.lineSeparator() + "దయచేసి"));
                    }
                    if (inputString.contains("Thank you")) {
                        Ttext.setText((text + System.lineSeparator() + "ధన్యవాదాలు"));
                    }
                    if (inputString.contains("Happy")) {
                        Ttext.setText((text + System.lineSeparator() + "హ్యాపీ"));
                    }
                    if (inputString.contains("What")) {
                        Ttext.setText((text + System.lineSeparator() + "ఏం"));
                    }
                    if (inputString.contains("ticket")) {
                        Ttext.setText((text + System.lineSeparator() + "టికెట్"));
                    }
                    if (inputString.contains("icecream")) {
                        Ttext.setText((text + System.lineSeparator() + "ఐస్ క్రీం"));
                    }

                    if (inputString.contains("Can")) {
                        Ttext.setText((text + System.lineSeparator() + "కెన్"));
                    }
                    if (inputString.contains("Help")) {
                        Ttext.setText((text + System.lineSeparator() + "సహాయం"));
                    }
                    if (inputString.contains("lost")) {
                        Ttext.setText((text + System.lineSeparator() + "కోల్పోయిన"));
                    }

                    detectedTextView.setText(" ");
                }
                if (language1.equals("Urdu")) {
                    String inputString = detectedTextView.getText().toString();
                    String text = Ttext.getText().toString();
                    detectedTextView.setText(" ");

                    if (inputString.contains("Right")) {
                        Ttext.setText((text + System.lineSeparator() + "ٹھیک ہے"));
                    }

                    if (inputString.contains("Left")) {
                        Ttext.setText((text + System.lineSeparator() + "بائیں"));
                    }
                    if (inputString.contains("Place")) {
                        Ttext.setText((text + System.lineSeparator() + "جگہ"));
                    }
                    if (inputString.equals("Where")) {
                        Ttext.setText((text + System.lineSeparator() + "کہاں"));
                    }
                    if (inputString.contains("When")) {
                        Ttext.setText((text + System.lineSeparator() + "کب"));
                    }
                    if (inputString.contains("Time")) {
                        Ttext.setText((text + System.lineSeparator() + "وقت"));
                    }
                    if (inputString.equals("How")) {
                        Ttext.setText((text + System.lineSeparator() + "کیسے"));
                    }
                    if (inputString.contains("Vehicle")) {
                        Ttext.setText((text + System.lineSeparator() + "گاڑی"));
                    }
                    if (inputString.contains("Me")) {
                        Ttext.setText((text + System.lineSeparator() + "مجھے"));
                    }
                    if (inputString.contains("Yours")) {
                        Ttext.setText((text + System.lineSeparator() + "تمہارا"));
                    }
                    if (inputString.contains("Who")) {
                        Ttext.setText((text + System.lineSeparator() + "کون ہے\n"));
                    }
                    if (inputString.contains("Clothes")) {
                        Ttext.setText((text + System.lineSeparator() + "کپڑے"));
                    }
                    if (inputString.contains("Money")) {
                        Ttext.setText((text + System.lineSeparator() + "پیسہ"));
                    }
                    if (inputString.contains("Tea")) {
                        Ttext.setText((text + System.lineSeparator() + "چائے"));
                    }
                    if (inputString.contains("Water")) {
                        Ttext.setText((text + System.lineSeparator() + "پانی"));
                    }
                    if (inputString.contains("Food")) {
                        Ttext.setText((text + System.lineSeparator() + "کھانا"));
                    }
                    if (inputString.contains("Speak")) {
                        Ttext.setText((text + System.lineSeparator() + "بولو"));
                    }
                    if (inputString.contains("Slowly")) {
                        Ttext.setText((text + System.lineSeparator() + "آہستہ آہستہ"));
                    }
                    if (inputString.contains("No")) {
                        Ttext.setText((text + System.lineSeparator() + "نہیں"));
                    }
                    if (inputString.contains("Yes")) {
                        Ttext.setText((text + System.lineSeparator() + "جی ہاں"));
                    }
                    if (inputString.contains("Please")) {
                        Ttext.setText((text + System.lineSeparator() + "براہ کرم\n"));
                    }
                    if (inputString.contains("Thank you")) {
                        Ttext.setText((text + System.lineSeparator() + "شکریہ"));
                    }
                    if (inputString.contains("Happy")) {
                        Ttext.setText((text + System.lineSeparator() + "مبارک ہو\n"));
                    }
                    if (inputString.contains("What")) {
                        Ttext.setText((text + System.lineSeparator() + "کیا"));
                    }
                    if (inputString.contains("ticket")) {
                        Ttext.setText((text + System.lineSeparator() + "ٹکٹ"));
                    }
                    if (inputString.contains("icecream")) {
                        Ttext.setText((text + System.lineSeparator() + "آئس کریم\n"));
                    }

                    if (inputString.contains("Can")) {
                        Ttext.setText((text + System.lineSeparator() + "کر سکتے ہیں\n"));
                    }
                    if (inputString.contains("Help")) {
                        Ttext.setText((text + System.lineSeparator() + "مدد"));
                    }
                    if (inputString.contains("lost")) {
                        Ttext.setText((text + System.lineSeparator() + "کھو دیا\n"));
                    }

                    detectedTextView.setText(" ");
                }
                if (language1.equals("Gujarati")) {
                    String inputString = detectedTextView.getText().toString();
                    String text = Ttext.getText().toString();
                    detectedTextView.setText(" ");

                    if (inputString.contains("Right")) {
                        Ttext.setText((text + System.lineSeparator() + "અધિકાર"));
                    }

                    if (inputString.contains("Left")) {
                        Ttext.setText((text + System.lineSeparator() + "ડાબે"));
                    }
                    if (inputString.contains("Place")) {
                        Ttext.setText((text + System.lineSeparator() + "પ્લેસ"));
                    }
                    if (inputString.equals("Where")) {
                        Ttext.setText((text + System.lineSeparator() + "ક્યાં"));
                    }
                    if (inputString.contains("When")) {
                        Ttext.setText((text + System.lineSeparator() + "ક્યારે"));
                    }
                    if (inputString.contains("Time")) {
                        Ttext.setText((text + System.lineSeparator() + "સમય"));
                    }
                    if (inputString.equals("How")) {
                        Ttext.setText((text + System.lineSeparator() + "કેવી રીતે"));
                    }
                    if (inputString.contains("Vehicle")) {
                        Ttext.setText((text + System.lineSeparator() + "વાહન"));
                    }
                    if (inputString.contains("Me")) {
                        Ttext.setText((text + System.lineSeparator() + "મને"));
                    }
                    if (inputString.contains("Yours")) {
                        Ttext.setText((text + System.lineSeparator() + "તમારો"));
                    }
                    if (inputString.contains("Who")) {
                        Ttext.setText((text + System.lineSeparator() + "કોણ"));
                    }
                    if (inputString.contains("Clothes")) {
                        Ttext.setText((text + System.lineSeparator() + "કપડાં"));
                    }
                    if (inputString.contains("Money")) {
                        Ttext.setText((text + System.lineSeparator() + "નાણાં"));
                    }
                    if (inputString.contains("Tea")) {
                        Ttext.setText((text + System.lineSeparator() + "ટી"));
                    }
                    if (inputString.contains("Water")) {
                        Ttext.setText((text + System.lineSeparator() + "પાણી"));
                    }
                    if (inputString.contains("Food")) {
                        Ttext.setText((text + System.lineSeparator() + "ફૂડ"));
                    }
                    if (inputString.contains("Speak")) {
                        Ttext.setText((text + System.lineSeparator() + "બોલો"));
                    }
                    if (inputString.contains("Slowly")) {
                        Ttext.setText((text + System.lineSeparator() + "ધીમે ધીમે"));
                    }
                    if (inputString.contains("No")) {
                        Ttext.setText((text + System.lineSeparator() + "ના"));
                    }
                    if (inputString.contains("Yes")) {
                        Ttext.setText((text + System.lineSeparator() + "હા"));
                    }
                    if (inputString.contains("Please")) {
                        Ttext.setText((text + System.lineSeparator() + "મહેરબાની કરીને"));
                    }
                    if (inputString.contains("Thank you")) {
                        Ttext.setText((text + System.lineSeparator() + "આભાર"));
                    }
                    if (inputString.contains("Happy")) {
                        Ttext.setText((text + System.lineSeparator() + "હેપી"));
                    }
                    if (inputString.contains("What")) {
                        Ttext.setText((text + System.lineSeparator() + "શું"));
                    }
                    if (inputString.contains("ticket")) {
                        Ttext.setText((text + System.lineSeparator() + "ટિકિટ"));
                    }
                    if (inputString.contains("icecream")) {
                        Ttext.setText((text + System.lineSeparator() + "આઇસક્રીમ"));
                    }

                    if (inputString.contains("Can")) {
                        Ttext.setText((text + System.lineSeparator() + "કરી શકો છો"));
                    }
                    if (inputString.contains("Help")) {
                        Ttext.setText((text + System.lineSeparator() + "મદદ"));
                    }
                    if (inputString.contains("lost")) {
                        Ttext.setText((text + System.lineSeparator() + "ગુમાવ્યું"));
                    }

                    detectedTextView.setText(" ");
                }
                if (language1.equals("Punjabi")) {
                    String inputString = detectedTextView.getText().toString();
                    String text = Ttext.getText().toString();
                    detectedTextView.setText(" ");

                    if (inputString.contains("Right")) {
                        Ttext.setText((text + System.lineSeparator() + "ਸੱਜਾ"));
                    }

                    if (inputString.contains("Left")) {
                        Ttext.setText((text + System.lineSeparator() + "ਖੱਬੇ ਪਾਸੇ"));
                    }
                    if (inputString.contains("Place")) {
                        Ttext.setText((text + System.lineSeparator() +  "ਸਥਾਨ"));
                    }
                    if (inputString.equals("Where")) {
                        Ttext.setText((text + System.lineSeparator() + "ਕਿੱਥੇ"));
                    }
                    if (inputString.contains("When")) {
                        Ttext.setText((text + System.lineSeparator() + "ਜਦੋਂ"));
                    }
                    if (inputString.contains("Time")) {
                        Ttext.setText((text + System.lineSeparator() + "ਸਮਾਂ"));
                    }
                    if (inputString.equals("How")) {
                        Ttext.setText((text + System.lineSeparator() + "ਕਿਵੇਂ"));
                    }
                    if (inputString.contains("Vehicle")) {
                        Ttext.setText((text + System.lineSeparator() + "ਵਾਹਨ"));
                    }
                    if (inputString.contains("Me")) {
                        Ttext.setText((text + System.lineSeparator() + "ਮੈਨੂੰ"));
                    }
                    if (inputString.contains("Yours")) {
                        Ttext.setText((text + System.lineSeparator() + "ਤੁਹਾਡਾ"));
                    }
                    if (inputString.contains("Who")) {
                        Ttext.setText((text + System.lineSeparator() + "ਕੌਣ"));
                    }
                    if (inputString.contains("Clothes")) {
                        Ttext.setText((text + System.lineSeparator() + "ਕੱਪੜੇ"));
                    }
                    if (inputString.contains("Money")) {
                        Ttext.setText((text + System.lineSeparator() + "ਪੈਸਾ"));
                    }
                    if (inputString.contains("Tea")) {
                        Ttext.setText((text + System.lineSeparator() + "ਚਾਹ"));
                    }
                    if (inputString.contains("Water")) {
                        Ttext.setText((text + System.lineSeparator() + "ਪਾਣੀ"));
                    }
                    if (inputString.contains("Food")) {
                        Ttext.setText((text + System.lineSeparator() + "ਭੋਜਨ"));
                    }
                    if (inputString.contains("Speak")) {
                        Ttext.setText((text + System.lineSeparator() + "ਬੋਲੋ"));
                    }
                    if (inputString.contains("Slowly")) {
                        Ttext.setText((text + System.lineSeparator() + "ਹੌਲੀ ਹੌਲੀ"));
                    }
                    if (inputString.contains("No")) {
                        Ttext.setText((text + System.lineSeparator() + "ਨਹੀਂ"));
                    }
                    if (inputString.contains("Yes")) {
                        Ttext.setText((text + System.lineSeparator() + "ਹਾਂ"));
                    }
                    if (inputString.contains("Please")) {
                        Ttext.setText((text + System.lineSeparator() + "ਕ੍ਰਿਪਾ"));
                    }
                    if (inputString.contains("Thank you")) {
                        Ttext.setText((text + System.lineSeparator() + "ਤੁਹਾਡਾ ਧੰਨਵਾਦ"));
                    }
                    if (inputString.contains("Happy")) {
                        Ttext.setText((text + System.lineSeparator() + "ਖੁਸ਼ੀ"));
                    }
                    if (inputString.contains("What")) {
                        Ttext.setText((text + System.lineSeparator() + "ਕੀ"));
                    }
                    if (inputString.contains("ticket")) {
                        Ttext.setText((text + System.lineSeparator() + "ਟਿਕਟ"));
                    }
                    if (inputString.contains("icecream")) {
                        Ttext.setText((text + System.lineSeparator() + "ਆਇਸ ਕਰੀਮ"));
                    }

                    if (inputString.contains("Can")) {
                        Ttext.setText((text + System.lineSeparator() + "ਕੀ"));
                    }
                    if (inputString.contains("Help")) {
                        Ttext.setText((text + System.lineSeparator() + "ਮਦਦ ਕਰੋ"));
                    }
                    if (inputString.contains("lost")) {
                        Ttext.setText((text + System.lineSeparator() + "ਗੁੰਮ ਗਿਆ"));
                    }

                    detectedTextView.setText(" ");
                }
                if (language1.equals("Tamil")) {
                    String inputString = detectedTextView.getText().toString();
                    String text = Ttext.getText().toString();
                    detectedTextView.setText(" ");

                    if (inputString.contains("Right")) {
                        Ttext.setText((text + System.lineSeparator() + "வலப்பக்கம்"));
                    }

                    if (inputString.contains("Left")) {
                        Ttext.setText((text + System.lineSeparator() + "இடப்பக்கம்"));
                    }
                    if (inputString.contains("Place")) {
                        Ttext.setText((text + System.lineSeparator() + "தானம்"));
                    }
                    if (inputString.equals("Where")) {
                        Ttext.setText((text + System.lineSeparator() + "எங்கே"));
                    }
                    if (inputString.contains("When")) {
                        Ttext.setText((text + System.lineSeparator() + "எப்போது"));
                    }
                    if (inputString.contains("Time")) {
                        Ttext.setText((text + System.lineSeparator() + "நேரம்"));
                    }
                    if (inputString.equals("How")) {
                        Ttext.setText((text + System.lineSeparator() + "வகை"));
                    }
                    if (inputString.contains("Vehicle")) {
                        Ttext.setText((text + System.lineSeparator() + "சும்பபிகள்"));
                    }
                    if (inputString.contains("Me")) {
                        Ttext.setText((text + System.lineSeparator() + "எனக்கு"));
                    }
                    if (inputString.contains("Yours")) {
                        Ttext.setText((text + System.lineSeparator() + "உன்னுடையது"));
                    }
                    if (inputString.contains("Who")) {
                        Ttext.setText((text + System.lineSeparator() + "எவர்"));
                    }
                    if (inputString.contains("Clothes")) {
                        Ttext.setText((text + System.lineSeparator() + "உடைகள"));
                    }
                    if (inputString.contains("Money")) {
                        Ttext.setText((text + System.lineSeparator() + "பணம்"));
                    }
                    if (inputString.contains("Tea")) {
                        Ttext.setText((text + System.lineSeparator() + "தேநீர்"));
                    }
                    if (inputString.contains("Water")) {
                        Ttext.setText((text + System.lineSeparator() + "நீர்"));
                    }
                    if (inputString.contains("Food")) {
                        Ttext.setText((text + System.lineSeparator() + "உணவு"));
                    }
                    if (inputString.contains("Speak")) {
                        Ttext.setText((text + System.lineSeparator() + "பேசு"));
                    }
                    if (inputString.contains("Slowly")) {
                        Ttext.setText((text + System.lineSeparator() + "மெதுவாக"));
                    }
                    if (inputString.contains("No")) {
                        Ttext.setText((text + System.lineSeparator() + "இல்லை"));
                    }
                    if (inputString.contains("Yes")) {
                        Ttext.setText((text + System.lineSeparator() + "ஆம்"));
                    }
                    if (inputString.contains("Please")) {
                        Ttext.setText((text + System.lineSeparator() + "தயவுசேய்து"));
                    }
                    if (inputString.contains("Thank you")) {
                        Ttext.setText((text + System.lineSeparator() + "நன்றி"));
                    }
                    if (inputString.contains("Happy")) {
                        Ttext.setText((text + System.lineSeparator() + "மகிழ்ச்சி"));
                    }
                    if (inputString.contains("What")) {
                        Ttext.setText((text + System.lineSeparator() + "என்ன"));
                    }
                    if (inputString.contains("ticket")) {
                        Ttext.setText((text + System.lineSeparator() + "சீட்டு"));
                    }
                    if (inputString.contains("icecream")) {
                        Ttext.setText((text + System.lineSeparator() + "குளிர்களி"));
                    }

                    if (inputString.contains("Can")) {
                        Ttext.setText((text + System.lineSeparator() + "பிடியுள்ள தகரக்குவளை"));
                    }
                    if (inputString.contains("Help")) {
                        Ttext.setText((text + System.lineSeparator() + "உதவி"));
                    }
                    if (inputString.contains("lost")) {
                        Ttext.setText((text + System.lineSeparator() + "நட்ட அழைப்பு"));
                    }

                    detectedTextView.setText(" ");

                }
            }
        });
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        	     //   Toast.makeText(getApplicationContext(),country[position] , Toast.LENGTH_LONG).show();

        language1=country[position];

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
