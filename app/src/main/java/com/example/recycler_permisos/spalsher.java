package com.example.recycler_permisos;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.widget.Toast;

import androidx.core.content.ContextCompat;

import java.util.Timer;
import java.util.TimerTask;

public class spalsher extends Activity {

    private int activityToStart = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spalsher);

        TimerTask tarea = new TimerTask() {
            @Override
            public void run() {
                checkAllPermissions();

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        if (activityToStart == 1) {
                            Intent i = new Intent(spalsher.this, PantallaPrincipal.class);
                            startActivity(i);
                        } else {
                            Intent i = new Intent(spalsher.this, MainActivity.class);
                            startActivity(i);
                        }
                        finish();
                    }
                });
            }
        };
        Timer tiempo = new Timer();
        tiempo.schedule(tarea, 3000);
    }

    private void checkAllPermissions() {
        String[] permissionsToCheck = {
                android.Manifest.permission.CALL_PHONE,
                android.Manifest.permission.CAMERA,
                android.Manifest.permission.ACCESS_FINE_LOCATION
        };

        boolean anyPermissionGranted = false;
        StringBuilder grantedPermissions = new StringBuilder();

        for (String permission : permissionsToCheck) {
            if (ContextCompat.checkSelfPermission(this, permission) == PackageManager.PERMISSION_GRANTED) {
                grantedPermissions.append(permission).append("\n");
                anyPermissionGranted = true;
            }
        }

        if (anyPermissionGranted) {
            final String permissionsMessage = grantedPermissions.toString();
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    Toast.makeText(spalsher.this, "Permisos otorgados:\n" + permissionsMessage, Toast.LENGTH_LONG).show();
                }
            });
            activityToStart = 1;
        }
    }
}
