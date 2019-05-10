package com.example.nyesteventure3.travelguide;

import android.Manifest;
import android.annotation.TargetApi;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.nyesteventure3.travelguide.Guest.Guesthome;
import com.example.nyesteventure3.travelguide.Login1.Log0;

public class FirstPage extends AppCompatActivity {


    Button next;

    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_page);

        checkRunTimePermission();
        imageView=(ImageView)findViewById(R.id.imageViewguide);
        next=(Button)findViewById(R.id.btn_next);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//              Intent n=news_data Intent(FirstPage.this,Log0.class);
                Intent n=new Intent(FirstPage.this,Guesthome.class);
                    startActivity(n);
            }
        });
    }

    private void checkRunTimePermission() {
        String[] permissionArrays = new String[]{Manifest.permission.CAMERA,
                Manifest.permission.WRITE_EXTERNAL_STORAGE,

                Manifest.permission.ACCESS_COARSE_LOCATION,
                Manifest.permission.ACCESS_FINE_LOCATION,
                Manifest.permission.ACCESS_FINE_LOCATION,
                Manifest.permission.READ_EXTERNAL_STORAGE,
                Manifest.permission.INTERNET,
                Manifest.permission.ACCESS_NETWORK_STATE,
                Manifest.permission.SEND_SMS};

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            requestPermissions(permissionArrays, 11111);
        } else {
            // if already permition granted
            // PUT YOUR ACTION (Like Open cemara etc..)
        }
    }
    @TargetApi(Build.VERSION_CODES.M)
    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        boolean openActivityOnce = true;
        boolean openDialogOnce = true;
        if (requestCode == 11111) {
            boolean isPermitted = false;
            for (int i = 0; i < grantResults.length; i++) {
                String permission = permissions[i];

                isPermitted = grantResults[i] == PackageManager.PERMISSION_GRANTED;

                if (grantResults[i] == PackageManager.PERMISSION_DENIED) {
                    // user rejected the permission
                    boolean showRationale = shouldShowRequestPermissionRationale(permission);
                    if (!showRationale) {
                        //execute when 'never Ask Again' tick and permission dialog not show
                    } else {
                        if (openDialogOnce) {
                            alertView();
                        }
                    }
                }
            }


        }

        }

    private void alertView() {
        AlertDialog.Builder dialog = new AlertDialog.Builder(FirstPage.this);

        dialog.setTitle("Permission Denied")
                .setInverseBackgroundForced(true)
                //.setIcon(R.drawable.ic_info_black_24dp)
                .setMessage("Without those permission the app is unable to save your profile. App needs to save profile image in your external storage and also need to get profile image from camera or external storage.Are you sure you want to deny this permission?")

                .setNegativeButton("I'M SURE", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialoginterface, int i) {
                        dialoginterface.dismiss();
                    }
                })
                .setPositiveButton("RE-TRY", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialoginterface, int i) {
                        dialoginterface.dismiss();
                        checkRunTimePermission();

                    }
                }).show();
    }

}
