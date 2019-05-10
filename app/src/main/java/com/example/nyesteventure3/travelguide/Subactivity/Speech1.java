package com.example.nyesteventure3.travelguide.Subactivity;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.speech.RecognizerIntent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.nyesteventure3.travelguide.R;

import java.util.ArrayList;
import java.util.Locale;

public class Speech1 extends AppCompatActivity implements AdapterView.OnItemSelectedListener {


    private TextView txtSpeechInput;
    private ImageButton btnSpeak;
    private final int REQ_CODE_SPEECH_INPUT = 100;

    String[] country = {"choose language","Bengali","Gujarati","Hindi","Kannada","Malayalam","Marathi","Punjabi","Tamil","Telugu","Urdu"};
    Spinner spin;
    public static String language1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_speech1);



        txtSpeechInput = (TextView) findViewById(R.id.txtSpeechInput);
        btnSpeak = (ImageButton) findViewById(R.id.btnSpeak);

        Spinner spin = (Spinner) findViewById(R.id.spinner1);
        spin.setOnItemSelectedListener(this);
        ArrayAdapter aa = new ArrayAdapter(this,android.R.layout.simple_spinner_item,country);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin.setAdapter(aa);


        btnSpeak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                promptSpeechInput();
            }
        });
    }

    private void promptSpeechInput() {
        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,
                RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault());
        intent.putExtra(RecognizerIntent.EXTRA_PROMPT,
                getString(R.string.speech_prompt));
        try {
            startActivityForResult(intent, REQ_CODE_SPEECH_INPUT);
        } catch (ActivityNotFoundException a) {
            Toast.makeText(getApplicationContext(),
                    getString(R.string.speech_not_supported),
                    Toast.LENGTH_SHORT).show();
        }
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode) {
            case REQ_CODE_SPEECH_INPUT: {
                if (resultCode == RESULT_OK && null != data) {

                    ArrayList<String> result = data
                            .getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                    if (result.get(0).equals("right")) {
                        if (language1.equals("Hindi")) {
                            txtSpeechInput.setText("सही");
                        }
                        if (language1.equals("Malayalam")) {
                            txtSpeechInput.setText("വലത്തെ");
                        }
                        if (language1.equals("Kannada")) {
                            txtSpeechInput.setText("ಬಲ");
                        }
                        if (language1.equals("Marathi")) {
                            txtSpeechInput.setText("उजवे");
                        }
                        if (language1.equals("Bengali")) {
                            txtSpeechInput.setText("অধিকার");
                        }
                        if (language1.equals("Telugu")) {
                            txtSpeechInput.setText("కుడి");
                        }
                        if (language1.equals("Urdu")) {
                            txtSpeechInput.setText("ٹھیک ہے");
                        }
                        if (language1.equals("Gujarati")) {
                            txtSpeechInput.setText("અધિકાર");
                        }
                        if (language1.equals("Punjabi")) {
                            txtSpeechInput.setText("ਸੱਜਾ");
                        }
                        if (language1.equals("Tamil")) {
                            txtSpeechInput.setText("வலப்பக்கம்");
                        }
                    }
                    if (result.get(0).equals("left")) {

                        if (language1.equals("Hindi")) {
                            txtSpeechInput.setText("बाएं");
                        }
                        if (language1.equals("Malayalam")) {
                            txtSpeechInput.setText("ഇടത്തെ");
                        }
                        if (language1.equals("Kannada")) {
                            txtSpeechInput.setText("ಎಡ");
                        }
                        if (language1.equals("Marathi")) {
                            txtSpeechInput.setText("डावे");
                        }
                        if (language1.equals("Bengali")) {
                            txtSpeechInput.setText("বাম");
                        }
                        if (language1.equals("Telugu")) {
                            txtSpeechInput.setText("ఎడమ");
                        }
                        if (language1.equals("Urdu")) {
                            txtSpeechInput.setText("بائیں");
                        }
                        if (language1.equals("Gujarati")) {
                            txtSpeechInput.setText("ડાબે");
                        }
                        if (language1.equals("Punjabi")) {
                            txtSpeechInput.setText("ਖੱਬੇ ਪਾਸੇ");
                        }
                        if (language1.equals("Tamil")) {
                            txtSpeechInput.setText("இடப்பக்கம்");
                        }
                    }
                    if (result.get(0).equals("place")) {

                        if (language1.equals("Hindi")) {
                            txtSpeechInput.setText("जगह");
                        }
                        if (language1.equals("Malayalam")) {
                            txtSpeechInput.setText("സ്ഥലം");
                        }
                        if (language1.equals("Kannada")) {
                            txtSpeechInput.setText("ಸ್ಥಳ");
                        }
                        if (language1.equals("Marathi")) {
                            txtSpeechInput.setText("ठिकाण");
                        }
                        if (language1.equals("Bengali")) {
                            txtSpeechInput.setText("জায়গা");
                        }
                        if (language1.equals("Telugu")) {
                            txtSpeechInput.setText("ప్లేస్");
                        }
                        if (language1.equals("Urdu")) {
                            txtSpeechInput.setText("جگہ");
                        }
                        if (language1.equals("Gujarati")) {
                            txtSpeechInput.setText("પ્લેસ");
                        }
                        if (language1.equals("Punjabi")) {
                            txtSpeechInput.setText("ਸਥਾਨ");
                        }
                        if (language1.equals("Tamil")) {
                            txtSpeechInput.setText("தானம்");
                        }
                    }
                    if (result.get(0).equals("where")) {

                        if (language1.equals("Hindi")) {
                            txtSpeechInput.setText("कहा पे");
                        }
                        if (language1.equals("Malayalam")) {
                            txtSpeechInput.setText("എവിടെയാണ്");
                        }
                        if (language1.equals("Kannada")) {
                            txtSpeechInput.setText("ಎಲ್ಲಿ");
                        }
                        if (language1.equals("Marathi")) {
                            txtSpeechInput.setText("कुठे");
                        }
                        if (language1.equals("Bengali")) {
                            txtSpeechInput.setText("কোথায়");
                        }
                        if (language1.equals("Telugu")) {
                            txtSpeechInput.setText("ఎక్కడ");
                        }
                        if (language1.equals("Urdu")) {
                            txtSpeechInput.setText("کہاں");
                        }
                        if (language1.equals("Gujarati")) {
                            txtSpeechInput.setText("ક્યાં");
                        }
                        if (language1.equals("Punjabi")) {
                            txtSpeechInput.setText("ਕਿੱਥੇ");
                        }
                        if (language1.equals("Tamil")) {
                            txtSpeechInput.setText("எங்கே");
                        }
                    }
                    if (result.get(0).equals("when")) {

                        if (language1.equals("Hindi")) {
                            txtSpeechInput.setText("कब");
                        }
                        if (language1.equals("Malayalam")) {
                            txtSpeechInput.setText("എപ്പോൾ");
                        }
                        if (language1.equals("Kannada")) {
                            txtSpeechInput.setText("ಯಾವಾಗ");
                        }
                        if (language1.equals("Marathi")) {
                            txtSpeechInput.setText("कधी");
                        }
                        if (language1.equals("Bengali")) {
                            txtSpeechInput.setText("কখন");
                        }
                        if (language1.equals("Telugu")) {
                            txtSpeechInput.setText("ఎప్పుడు");
                        }
                        if (language1.equals("Urdu")) {
                            txtSpeechInput.setText("کب");
                        }
                        if (language1.equals("Gujarati")) {
                            txtSpeechInput.setText("ક્યારે");
                        }
                        if (language1.equals("Punjabi")) {
                            txtSpeechInput.setText("ਜਦੋਂ");
                        }
                        if (language1.equals("Tamil")) {
                            txtSpeechInput.setText("எப்போது");
                        }
                    }
                    if (result.get(0).equals("time")) {

                        if (language1.equals("Hindi")) {
                            txtSpeechInput.setText("पहर");
                        }
                        if (language1.equals("Malayalam")) {
                            txtSpeechInput.setText("സമയം");
                        }
                        if (language1.equals("Kannada")) {
                            txtSpeechInput.setText("ಸಮಯ");
                        }
                        if (language1.equals("Marathi")) {
                            txtSpeechInput.setText("वेळ");
                        }
                        if (language1.equals("Bengali")) {
                            txtSpeechInput.setText("সময়");
                        }
                        if (language1.equals("Telugu")) {
                            txtSpeechInput.setText("సమయం");
                        }
                        if (language1.equals("Urdu")) {
                            txtSpeechInput.setText("وقت");
                        }
                        if (language1.equals("Gujarati")) {
                            txtSpeechInput.setText("સમય");
                        }
                        if (language1.equals("Punjabi")) {
                            txtSpeechInput.setText("ਸਮਾਂ");
                        }
                        if (language1.equals("Tamil")) {
                            txtSpeechInput.setText("நேரம்");
                        }
                    }
                    if (result.get(0).equals("how")) {

                        if (language1.equals("Hindi")) {
                            txtSpeechInput.setText("किस तरह");
                        }
                        if (language1.equals("Malayalam")) {
                            txtSpeechInput.setText("എങ്ങനെ");
                        }
                        if (language1.equals("Kannada")) {
                            txtSpeechInput.setText("ಹೇಗೆ");
                        }
                        if (language1.equals("Marathi")) {
                            txtSpeechInput.setText("कसे");
                        }
                        if (language1.equals("Bengali")) {
                            txtSpeechInput.setText("কিভাবে");
                        }
                        if (language1.equals("Telugu")) {
                            txtSpeechInput.setText("ఎలా");
                        }
                        if (language1.equals("Urdu")) {
                            txtSpeechInput.setText("کیسے");
                        }
                        if (language1.equals("Gujarati")) {
                            txtSpeechInput.setText("કેવી રીતે");
                        }
                        if (language1.equals("Punjabi")) {
                            txtSpeechInput.setText("ਕਿਵੇਂ");
                        }
                        if (language1.equals("Tamil")) {
                            txtSpeechInput.setText("வகை");
                        }
                    }
                    if (result.get(0).equals("vehicle")) {

                        if (language1.equals("Hindi")) {
                            txtSpeechInput.setText("वाहन");
                        }
                        if (language1.equals("Malayalam")) {
                            txtSpeechInput.setText("വാഹനം");
                        }
                        if (language1.equals("Kannada")) {
                            txtSpeechInput.setText("ವಾಹನ");
                        }
                        if (language1.equals("Marathi")) {
                            txtSpeechInput.setText("वाहन");
                        }
                        if (language1.equals("Bengali")) {
                            txtSpeechInput.setText("বাহন");
                        }
                        if (language1.equals("Telugu")) {
                            txtSpeechInput.setText("వాహనం");
                        }
                        if (language1.equals("Urdu")) {
                            txtSpeechInput.setText("گاڑی");
                        }
                        if (language1.equals("Gujarati")) {
                            txtSpeechInput.setText("વાહન");
                        }
                        if (language1.equals("Punjabi")) {
                            txtSpeechInput.setText("ਵਾਹਨ");
                        }
                        if (language1.equals("Tamil")) {
                            txtSpeechInput.setText("சும்பபிகள்");
                        }
                    }
                    if (result.get(0).equals("me")) {

                        if (language1.equals("Hindi")) {
                            txtSpeechInput.setText("मुझे");
                        }
                        if (language1.equals("Malayalam")) {
                            txtSpeechInput.setText("ഞാൻ");
                        }
                        if (language1.equals("Kannada")) {
                            txtSpeechInput.setText("ನಿಮ್ಮದು");
                        }
                        if (language1.equals("Marathi")) {
                            txtSpeechInput.setText("आपला");
                        }
                        if (language1.equals("Bengali")) {
                            txtSpeechInput.setText("আপনার");
                        }
                        if (language1.equals("Telugu")) {
                            txtSpeechInput.setText("నాకు");
                        }
                        if (language1.equals("Urdu")) {
                            txtSpeechInput.setText("مجھے");
                        }
                        if (language1.equals("Gujarati")) {
                            txtSpeechInput.setText("મને");
                        }
                        if (language1.equals("Punjabi")) {
                            txtSpeechInput.setText("ਮੈਨੂੰ");
                        }
                        if (language1.equals("Tamil")) {
                            txtSpeechInput.setText("எனக்கு");
                        }
                    }
                    if (result.get(0).equals("yours")) {

                        if (language1.equals("Hindi")) {
                            txtSpeechInput.setText("आपका अपना");
                        }
                        if (language1.equals("Malayalam")) {
                            txtSpeechInput.setText("താങ്കളുടെ");
                        }
                        if (language1.equals("Kannada")) {
                            txtSpeechInput.setText("ನಿಮ್ಮದು");
                        }
                        if (language1.equals("Marathi")) {
                            txtSpeechInput.setText("उजवे");
                        }
                        if (language1.equals("Bengali")) {
                            txtSpeechInput.setText("আপনার");
                        }
                        if (language1.equals("Telugu")) {
                            txtSpeechInput.setText("యువర్స్");
                        }
                        if (language1.equals("Urdu")) {
                            txtSpeechInput.setText("تمہارا");
                        }
                        if (language1.equals("Gujarati")) {
                            txtSpeechInput.setText("તમારો");
                        }
                        if (language1.equals("Punjabi")) {
                            txtSpeechInput.setText("ਤੁਹਾਡਾ");
                        }
                        if (language1.equals("Tamil")) {
                            txtSpeechInput.setText("உன்னுடையது");
                        }
                    }
                    if (result.get(0).equals("who")) {

                        if (language1.equals("Hindi")) {
                            txtSpeechInput.setText("कौन");
                        }
                        if (language1.equals("Malayalam")) {
                            txtSpeechInput.setText("ആര്");
                        }
                        if (language1.equals("Kannada")) {
                            txtSpeechInput.setText("ಯಾರು");
                        }
                        if (language1.equals("Marathi")) {
                            txtSpeechInput.setText("उजवे");
                        }
                        if (language1.equals("Bengali")) {
                            txtSpeechInput.setText("অধিকার");
                        }
                        if (language1.equals("Telugu")) {
                            txtSpeechInput.setText("కుడి");
                        }
                        if (language1.equals("Urdu")) {
                            txtSpeechInput.setText("ٹھیک ہے");
                        }
                        if (language1.equals("Gujarati")) {
                            txtSpeechInput.setText("અધિકાર");
                        }
                        if (language1.equals("Punjabi")) {
                            txtSpeechInput.setText("ਸੱਜਾ");
                        }
                        if (language1.equals("Tamil")) {
                            txtSpeechInput.setText("வலப்பக்கம்");
                        }
                    }
                    if (result.get(0).equals("cloth")) {

                        if (language1.equals("Hindi")) {
                            txtSpeechInput.setText("वस्त्र");
                        }
                        if (language1.equals("Malayalam")) {
                            txtSpeechInput.setText("വസ്ത്രം");
                        }
                        if (language1.equals("Kannada")) {
                            txtSpeechInput.setText("ಬಟ್ಟೆ");
                        }
                        if (language1.equals("Marathi")) {
                            txtSpeechInput.setText("उजवे");
                        }
                        if (language1.equals("Bengali")) {
                            txtSpeechInput.setText("অধিকার");
                        }
                        if (language1.equals("Telugu")) {
                            txtSpeechInput.setText("కుడి");
                        }
                        if (language1.equals("Urdu")) {
                            txtSpeechInput.setText("ٹھیک ہے");
                        }
                        if (language1.equals("Gujarati")) {
                            txtSpeechInput.setText("અધિકાર");
                        }
                        if (language1.equals("Punjabi")) {
                            txtSpeechInput.setText("ਸੱਜਾ");
                        }
                        if (language1.equals("Tamil")) {
                            txtSpeechInput.setText("வலப்பக்கம்");
                        }
                    }
                    if (result.get(0).equals("money")) {

                        if (language1.equals("Hindi")) {
                            txtSpeechInput.setText("पैसे");
                        }
                        if (language1.equals("Malayalam")) {
                            txtSpeechInput.setText("പണം");
                        }
                        if (language1.equals("Kannada")) {
                            txtSpeechInput.setText("ಹಣ");
                        }
                        if (language1.equals("Marathi")) {
                            txtSpeechInput.setText("उजवे");
                        }
                        if (language1.equals("Bengali")) {
                            txtSpeechInput.setText("অধিকার");
                        }
                        if (language1.equals("Telugu")) {
                            txtSpeechInput.setText("కుడి");
                        }
                        if (language1.equals("Urdu")) {
                            txtSpeechInput.setText("ٹھیک ہے");
                        }
                        if (language1.equals("Gujarati")) {
                            txtSpeechInput.setText("અધિકાર");
                        }
                        if (language1.equals("Punjabi")) {
                            txtSpeechInput.setText("ਸੱਜਾ");
                        }
                        if (language1.equals("Tamil")) {
                            txtSpeechInput.setText("வலப்பக்கம்");
                        }
                    }
                    if (result.get(0).equals("tea")) {

                        if (language1.equals("Hindi")) {
                            txtSpeechInput.setText("चाय");
                        }
                        if (language1.equals("Malayalam")) {
                            txtSpeechInput.setText("ചായ");
                        }
                        if (language1.equals("Kannada")) {
                            txtSpeechInput.setText("ಚಹಾ");
                        }
                        if (language1.equals("Marathi")) {
                            txtSpeechInput.setText("उजवे");
                        }
                        if (language1.equals("Bengali")) {
                            txtSpeechInput.setText("অধিকার");
                        }
                        if (language1.equals("Telugu")) {
                            txtSpeechInput.setText("కుడి");
                        }
                        if (language1.equals("Urdu")) {
                            txtSpeechInput.setText("ٹھیک ہے");
                        }
                        if (language1.equals("Gujarati")) {
                            txtSpeechInput.setText("અધિકાર");
                        }
                        if (language1.equals("Punjabi")) {
                            txtSpeechInput.setText("ਸੱਜਾ");
                        }
                        if (language1.equals("Tamil")) {
                            txtSpeechInput.setText("வலப்பக்கம்");
                        }
                    }
                    if (result.get(0).equals("water")) {

                        if (language1.equals("Hindi")) {
                            txtSpeechInput.setText("पानी");
                        }
                        if (language1.equals("Malayalam")) {
                            txtSpeechInput.setText("വെള്ളം");
                        }
                        if (language1.equals("Kannada")) {
                            txtSpeechInput.setText("ನೀರು");
                        }
                        if (language1.equals("Marathi")) {
                            txtSpeechInput.setText("उजवे");
                        }
                        if (language1.equals("Bengali")) {
                            txtSpeechInput.setText("অধিকার");
                        }
                        if (language1.equals("Telugu")) {
                            txtSpeechInput.setText("కుడి");
                        }
                        if (language1.equals("Urdu")) {
                            txtSpeechInput.setText("ٹھیک ہے");
                        }
                        if (language1.equals("Gujarati")) {
                            txtSpeechInput.setText("અધિકાર");
                        }
                        if (language1.equals("Punjabi")) {
                            txtSpeechInput.setText("ਸੱਜਾ");
                        }
                        if (language1.equals("Tamil")) {
                            txtSpeechInput.setText("வலப்பக்கம்");
                        }
                    }
                    if (result.get(0).equals("food")) {

                        if (language1.equals("Hindi")) {
                            txtSpeechInput.setText("भोजन");
                        }
                        if (language1.equals("Malayalam")) {
                            txtSpeechInput.setText("ഭക്ഷണം");
                        }
                        if (language1.equals("Kannada")) {
                            txtSpeechInput.setText("ಆಹಾರ");
                        }
                        if (language1.equals("Marathi")) {
                            txtSpeechInput.setText("उजवे");
                        }
                        if (language1.equals("Bengali")) {
                            txtSpeechInput.setText("অধিকার");
                        }
                        if (language1.equals("Telugu")) {
                            txtSpeechInput.setText("కుడి");
                        }
                        if (language1.equals("Urdu")) {
                            txtSpeechInput.setText("ٹھیک ہے");
                        }
                        if (language1.equals("Gujarati")) {
                            txtSpeechInput.setText("અધિકાર");
                        }
                        if (language1.equals("Punjabi")) {
                            txtSpeechInput.setText("ਸੱਜਾ");
                        }
                        if (language1.equals("Tamil")) {
                            txtSpeechInput.setText("வலப்பக்கம்");
                        }
                    }
                    if (result.get(0).equals("speak")) {

                        if (language1.equals("Hindi")) {
                            txtSpeechInput.setText("बोले");
                        }
                        if (language1.equals("Malayalam")) {
                            txtSpeechInput.setText("സംസാരിക്കുക");
                        }
                        if (language1.equals("Kannada")) {
                            txtSpeechInput.setText("ಮಾತನಾಡಿ");
                        }
                        if (language1.equals("Marathi")) {
                            txtSpeechInput.setText("उजवे");
                        }
                        if (language1.equals("Bengali")) {
                            txtSpeechInput.setText("অধিকার");
                        }
                        if (language1.equals("Telugu")) {
                            txtSpeechInput.setText("కుడి");
                        }
                        if (language1.equals("Urdu")) {
                            txtSpeechInput.setText("ٹھیک ہے");
                        }
                        if (language1.equals("Gujarati")) {
                            txtSpeechInput.setText("અધિકાર");
                        }
                        if (language1.equals("Punjabi")) {
                            txtSpeechInput.setText("ਸੱਜਾ");
                        }
                        if (language1.equals("Tamil")) {
                            txtSpeechInput.setText("வலப்பக்கம்");
                        }
                    }
                    if (result.get(0).equals("slowly")) {

                        if (language1.equals("Hindi")) {
                            txtSpeechInput.setText("धीरे से");
                        }
                        if (language1.equals("Malayalam")) {
                            txtSpeechInput.setText("പതുക്കെ");
                        }
                        if (language1.equals("Kannada")) {
                            txtSpeechInput.setText("ಆಹಾರ");
                        }
                        if (language1.equals("Marathi")) {
                            txtSpeechInput.setText("उजवे");
                        }
                        if (language1.equals("Bengali")) {
                            txtSpeechInput.setText("অধিকার");
                        }
                        if (language1.equals("Telugu")) {
                            txtSpeechInput.setText("కుడి");
                        }
                        if (language1.equals("Urdu")) {
                            txtSpeechInput.setText("ٹھیک ہے");
                        }
                        if (language1.equals("Gujarati")) {
                            txtSpeechInput.setText("અધિકાર");
                        }
                        if (language1.equals("Punjabi")) {
                            txtSpeechInput.setText("ਸੱਜਾ");
                        }
                        if (language1.equals("Tamil")) {
                            txtSpeechInput.setText("வலப்பக்கம்");
                        }
                    }
                    if (result.get(0).equals("no")) {

                        if (language1.equals("Hindi")) {
                            txtSpeechInput.setText("नहीं");
                        }
                        if (language1.equals("Malayalam")) {
                            txtSpeechInput.setText("ഇല്ല");
                        }
                        if (language1.equals("Kannada")) {
                            txtSpeechInput.setText("ಆಹಾರ");
                        }
                        if (language1.equals("Marathi")) {
                            txtSpeechInput.setText("उजवे");
                        }
                        if (language1.equals("Bengali")) {
                            txtSpeechInput.setText("অধিকার");
                        }
                        if (language1.equals("Telugu")) {
                            txtSpeechInput.setText("కుడి");
                        }
                        if (language1.equals("Urdu")) {
                            txtSpeechInput.setText("ٹھیک ہے");
                        }
                        if (language1.equals("Gujarati")) {
                            txtSpeechInput.setText("અધિકાર");
                        }
                        if (language1.equals("Punjabi")) {
                            txtSpeechInput.setText("ਸੱਜਾ");
                        }
                        if (language1.equals("Tamil")) {
                            txtSpeechInput.setText("வலப்பக்கம்");
                        }
                    }
                    if (result.get(0).equals("yes")) {

                        if (language1.equals("Hindi")) {
                            txtSpeechInput.setText("हाँ");
                        }
                        if (language1.equals("Malayalam")) {
                            txtSpeechInput.setText("അതെ");
                        }
                        if (language1.equals("Kannada")) {
                            txtSpeechInput.setText("ಆಹಾರ");
                        }
                        if (language1.equals("Marathi")) {
                            txtSpeechInput.setText("उजवे");
                        }
                        if (language1.equals("Bengali")) {
                            txtSpeechInput.setText("অধিকার");
                        }
                        if (language1.equals("Telugu")) {
                            txtSpeechInput.setText("కుడి");
                        }
                        if (language1.equals("Urdu")) {
                            txtSpeechInput.setText("ٹھیک ہے");
                        }
                        if (language1.equals("Gujarati")) {
                            txtSpeechInput.setText("અધિકાર");
                        }
                        if (language1.equals("Punjabi")) {
                            txtSpeechInput.setText("ਸੱਜਾ");
                        }
                        if (language1.equals("Tamil")) {
                            txtSpeechInput.setText("வலப்பக்கம்");
                        }
                    }
                    if (result.get(0).equals("please")) {

                        if (language1.equals("Hindi")) {
                            txtSpeechInput.setText("कृप्या");
                        }
                        if (language1.equals("Malayalam")) {
                            txtSpeechInput.setText("ദയവായി");
                        }
                        if (language1.equals("Kannada")) {
                            txtSpeechInput.setText("ಆಹಾರ");
                        }
                        if (language1.equals("Marathi")) {
                            txtSpeechInput.setText("उजवे");
                        }
                        if (language1.equals("Bengali")) {
                            txtSpeechInput.setText("অধিকার");
                        }
                        if (language1.equals("Telugu")) {
                            txtSpeechInput.setText("కుడి");
                        }
                        if (language1.equals("Urdu")) {
                            txtSpeechInput.setText("ٹھیک ہے");
                        }
                        if (language1.equals("Gujarati")) {
                            txtSpeechInput.setText("અધિકાર");
                        }
                        if (language1.equals("Punjabi")) {
                            txtSpeechInput.setText("ਸੱਜਾ");
                        }
                        if (language1.equals("Tamil")) {
                            txtSpeechInput.setText("வலப்பக்கம்");
                        }
                    }
                    if (result.get(0).contains("thank")) {

                        if (language1.equals("Hindi")) {
                            txtSpeechInput.setText("धन्यवाद");
                        }
                        if (language1.equals("Malayalam")) {
                            txtSpeechInput.setText("നന്ദിനന്ദി");
                        }
                        if (language1.equals("Kannada")) {
                            txtSpeechInput.setText("ಆಹಾರ");
                        }
                        if (language1.equals("Marathi")) {
                            txtSpeechInput.setText("उजवे");
                        }
                        if (language1.equals("Bengali")) {
                            txtSpeechInput.setText("অধিকার");
                        }
                        if (language1.equals("Telugu")) {
                            txtSpeechInput.setText("కుడి");
                        }
                        if (language1.equals("Urdu")) {
                            txtSpeechInput.setText("ٹھیک ہے");
                        }
                        if (language1.equals("Gujarati")) {
                            txtSpeechInput.setText("અધિકાર");
                        }
                        if (language1.equals("Punjabi")) {
                            txtSpeechInput.setText("ਸੱਜਾ");
                        }
                        if (language1.equals("Tamil")) {
                            txtSpeechInput.setText("வலப்பக்கம்");
                        }
                    }
                    if (result.get(0).equals("happy")) {

                        if (language1.equals("Hindi")) {
                            txtSpeechInput.setText("खुश");
                        }
                        if (language1.equals("Malayalam")) {
                            txtSpeechInput.setText("സന്തോഷം");
                        }
                        if (language1.equals("Kannada")) {
                            txtSpeechInput.setText("ಆಹಾರ");
                        }
                        if (language1.equals("Marathi")) {
                            txtSpeechInput.setText("उजवे");
                        }
                        if (language1.equals("Bengali")) {
                            txtSpeechInput.setText("অধিকার");
                        }
                        if (language1.equals("Telugu")) {
                            txtSpeechInput.setText("కుడి");
                        }
                        if (language1.equals("Urdu")) {
                            txtSpeechInput.setText("ٹھیک ہے");
                        }
                        if (language1.equals("Gujarati")) {
                            txtSpeechInput.setText("અધિકાર");
                        }
                        if (language1.equals("Punjabi")) {
                            txtSpeechInput.setText("ਸੱਜਾ");
                        }
                        if (language1.equals("Tamil")) {
                            txtSpeechInput.setText("வலப்பக்கம்");
                        }
                    }
                    if (result.get(0).equals("what")) {

                        if (language1.equals("Hindi")) {
                            txtSpeechInput.setText("क्या");
                        }
                        if (language1.equals("Malayalam")) {
                            txtSpeechInput.setText("എന്ത്");
                        }
                        if (language1.equals("Kannada")) {
                            txtSpeechInput.setText("ಆಹಾರ");
                        }
                        if (language1.equals("Marathi")) {
                            txtSpeechInput.setText("उजवे");
                        }
                        if (language1.equals("Bengali")) {
                            txtSpeechInput.setText("অধিকার");
                        }
                        if (language1.equals("Telugu")) {
                            txtSpeechInput.setText("కుడి");
                        }
                        if (language1.equals("Urdu")) {
                            txtSpeechInput.setText("ٹھیک ہے");
                        }
                        if (language1.equals("Gujarati")) {
                            txtSpeechInput.setText("અધિકાર");
                        }
                        if (language1.equals("Punjabi")) {
                            txtSpeechInput.setText("ਸੱਜਾ");
                        }
                        if (language1.equals("Tamil")) {
                            txtSpeechInput.setText("வலப்பக்கம்");
                        }
                    }
                    if (result.get(0).contains("ticket")) {

                        if (language1.equals("Hindi")) {
                            txtSpeechInput.setText("मुझे यह टिकट कहाँ मिल सकता है");
                        }
                        if (language1.equals("Malayalam")) {
                            txtSpeechInput.setText("ടിക്കറ്റ്");
                        }
                        if (language1.equals("Kannada")) {
                            txtSpeechInput.setText("ಆಹಾರ");
                        }
                        if (language1.equals("Marathi")) {
                            txtSpeechInput.setText("उजवे");
                        }
                        if (language1.equals("Bengali")) {
                            txtSpeechInput.setText("অধিকার");
                        }
                        if (language1.equals("Telugu")) {
                            txtSpeechInput.setText("కుడి");
                        }
                        if (language1.equals("Urdu")) {
                            txtSpeechInput.setText("ٹھیک ہے");
                        }
                        if (language1.equals("Gujarati")) {
                            txtSpeechInput.setText("અધિકાર");
                        }
                        if (language1.equals("Punjabi")) {
                            txtSpeechInput.setText("ਸੱਜਾ");
                        }
                        if (language1.equals("Tamil")) {
                            txtSpeechInput.setText("வலப்பக்கம்");
                        }
                    }
                    if (result.get(0).endsWith("cream")) {

                        if (language1.equals("Hindi")) {
                            txtSpeechInput.setText("मुझे यह आइसक्रीम कहां मिल सकती है");
                        }
                        if (language1.equals("Malayalam")) {
                            txtSpeechInput.setText("ഐസ്ക്രീം");
                        }
                        if (language1.equals("Kannada")) {
                            txtSpeechInput.setText("ಆಹಾರ");
                        }
                        if (language1.equals("Marathi")) {
                            txtSpeechInput.setText("उजवे");
                        }
                        if (language1.equals("Bengali")) {
                            txtSpeechInput.setText("অধিকার");
                        }
                        if (language1.equals("Telugu")) {
                            txtSpeechInput.setText("కుడి");
                        }
                        if (language1.equals("Urdu")) {
                            txtSpeechInput.setText("ٹھیک ہے");
                        }
                        if (language1.equals("Gujarati")) {
                            txtSpeechInput.setText("અધિકાર");
                        }
                        if (language1.equals("Punjabi")) {
                            txtSpeechInput.setText("ਸੱਜਾ");
                        }
                        if (language1.equals("Tamil")) {
                            txtSpeechInput.setText("வலப்பக்கம்");
                        }
                    }
                    if (result.get(0).contains("reach")) {

                        if (language1.equals("Hindi")) {
                            txtSpeechInput.setText("मैं किला कोच्चि तक कैसे पहुंचा?");
                        }
                        if (language1.equals("Malayalam")) {
                            txtSpeechInput.setText("ഭക്ഷണം");
                        }
                        if (language1.equals("Kannada")) {
                            txtSpeechInput.setText("ಆಹಾರ");
                        }
                        if (language1.equals("Marathi")) {
                            txtSpeechInput.setText("उजवे");
                        }
                        if (language1.equals("Bengali")) {
                            txtSpeechInput.setText("অধিকার");
                        }
                        if (language1.equals("Telugu")) {
                            txtSpeechInput.setText("కుడి");
                        }
                        if (language1.equals("Urdu")) {
                            txtSpeechInput.setText("ٹھیک ہے");
                        }
                        if (language1.equals("Gujarati")) {
                            txtSpeechInput.setText("અધિકાર");
                        }
                        if (language1.equals("Punjabi")) {
                            txtSpeechInput.setText("ਸੱਜਾ");
                        }
                        if (language1.equals("Tamil")) {
                            txtSpeechInput.setText("வலப்பக்கம்");
                        }
                    }
                    if (result.get(0).startsWith("can")) {

                        if (language1.equals("Hindi")) {
                            txtSpeechInput.setText("क्या आप मेरी मदद कर सकते हैं");
                        }
                        if (language1.equals("Malayalam")) {
                            txtSpeechInput.setText("കഴിയും");
                        }
                        if (language1.equals("Kannada")) {
                            txtSpeechInput.setText("ಆಹಾರ");
                        }
                        if (language1.equals("Marathi")) {
                            txtSpeechInput.setText("उजवे");
                        }
                        if (language1.equals("Bengali")) {
                            txtSpeechInput.setText("অধিকার");
                        }
                        if (language1.equals("Telugu")) {
                            txtSpeechInput.setText("కుడి");
                        }
                        if (language1.equals("Urdu")) {
                            txtSpeechInput.setText("ٹھیک ہے");
                        }
                        if (language1.equals("Gujarati")) {
                            txtSpeechInput.setText("અધિકાર");
                        }
                        if (language1.equals("Punjabi")) {
                            txtSpeechInput.setText("ਸੱਜਾ");
                        }
                        if (language1.equals("Tamil")) {
                            txtSpeechInput.setText("வலப்பக்கம்");
                        }
                    }
                    if (result.get(0).startsWith("help")) {

                        if (language1.equals("Hindi")) {
                            txtSpeechInput.setText("मेरी मदद करो");
                        }
                        if (language1.equals("Malayalam")) {
                            txtSpeechInput.setText("സഹായിക്കൂ");
                        }
                        if (language1.equals("Kannada")) {
                            txtSpeechInput.setText("ಆಹಾರ");
                        }
                        if (language1.equals("Marathi")) {
                            txtSpeechInput.setText("उजवे");
                        }
                        if (language1.equals("Bengali")) {
                            txtSpeechInput.setText("অধিকার");
                        }
                        if (language1.equals("Telugu")) {
                            txtSpeechInput.setText("కుడి");
                        }
                        if (language1.equals("Urdu")) {
                            txtSpeechInput.setText("ٹھیک ہے");
                        }
                        if (language1.equals("Gujarati")) {
                            txtSpeechInput.setText("અધિકાર");
                        }
                        if (language1.equals("Punjabi")) {
                            txtSpeechInput.setText("ਸੱਜਾ");
                        }
                        if (language1.equals("Tamil")) {
                            txtSpeechInput.setText("வலப்பக்கம்");
                        }
                    }
                    if (result.get(0).endsWith("lost")) {

                        if (language1.equals("Hindi")) {
                            txtSpeechInput.setText("मै खो गया हूँ");
                        }
                        if (language1.equals("Malayalam")) {
                            txtSpeechInput.setText("നഷ്ടപ്പെട്ടു");
                        }
                        if (language1.equals("Kannada")) {
                            txtSpeechInput.setText("ಆಹಾರ");
                        }
                        if (language1.equals("Marathi")) {
                            txtSpeechInput.setText("उजवे");
                        }
                        if (language1.equals("Bengali")) {
                            txtSpeechInput.setText("অধিকার");
                        }
                        if (language1.equals("Telugu")) {
                            txtSpeechInput.setText("కుడి");
                        }
                        if (language1.equals("Urdu")) {
                            txtSpeechInput.setText("ٹھیک ہے");
                        }
                        if (language1.equals("Gujarati")) {
                            txtSpeechInput.setText("અધિકાર");
                        }
                        if (language1.equals("Punjabi")) {
                            txtSpeechInput.setText("ਸੱਜਾ");
                        }
                        if (language1.equals("Tamil")) {
                            txtSpeechInput.setText("வலப்பக்கம்");
                        }
                    }

                }
                break;
            }

        }
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        language1=country[position];
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
