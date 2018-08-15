package com.mcuadrada.p1_permisos;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final String[] MY_PERMISSIONS = {
            Manifest.permission.ACCESS_FINE_LOCATION,
            Manifest.permission.CAMERA,
            Manifest.permission.READ_EXTERNAL_STORAGE};

    private static final int[] PERMISSIONS_CODE = {700, 701, 702};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        checkPermissions();
    }

    /*
    Esta función verifica si la aplicación tiene permisos para usar el GPS
     */
    private void checkPermissions() {
        //Verificar si la versión de Android es mayor de 22
        if (Build.VERSION.SDK_INT > 22) {

            //Comprobar si el primer permiso no está otorgado
            if (checkSelfPermission(MY_PERMISSIONS[0]) != PackageManager.PERMISSION_GRANTED) {
                //Mandar la solicitud en un arreglo de cadenas y con un código único
                requestPermissions(new String[]{MY_PERMISSIONS[0]}, PERMISSIONS_CODE[0]);
            }
            //Comprobar si el segundo permiso no está otorgado
            if (checkSelfPermission(MY_PERMISSIONS[1]) != PackageManager.PERMISSION_GRANTED) {
                //Mandar la solicitud en un arreglo de cadenas y con un código único
                requestPermissions(new String[]{MY_PERMISSIONS[1]}, PERMISSIONS_CODE[1]);
            }
            //Comprobar si el segundo permiso no está otorgado
            if (checkSelfPermission(MY_PERMISSIONS[2]) != PackageManager.PERMISSION_GRANTED) {
                //Mandar la solicitud en un arreglo de cadenas y con un código único
                requestPermissions(new String[]{MY_PERMISSIONS[2]}, PERMISSIONS_CODE[2]);
            }

        } else {
            Toast.makeText(this, "Ya aceptaste los permisos cuando fue " +
                            "instalada esta App, si no, no estuvieras viendo esta actividad",
                    Toast.LENGTH_LONG).show();
        }
    }

    /*
    Esta función se activa cuando el usuario otorga o deniega permisos.
    En ella podemos interactuar con el permiso que se solicitó y su respuesta.
     */
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case 700:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED)
                    Toast.makeText(this,
                            "Se han concedido permisos para el uso del GPS satélital",
                            Toast.LENGTH_SHORT)
                            .show();
                break;
            case 701:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED)
                    Toast.makeText(this,
                            "Se han concedido permisos para el uso de la camara",
                            Toast.LENGTH_SHORT)
                            .show();
                break;
            case 702:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED)
                    Toast.makeText(this,
                            "Se han concedido permisos para el uso de la lectura de la memoria externa",
                            Toast.LENGTH_SHORT)
                            .show();
                else{
                    finish();
                }
                break;
        }
    }
}
