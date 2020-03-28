package appmoviles.com.clientesingleton;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

public class ColorActivity extends AppCompatActivity {


    private ComunicacionTCP comunicacionTCP;
    private Button rojoBtn, verdeBtn, azulBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_color);

        rojoBtn = findViewById(R.id.rojoBtn);
        verdeBtn = findViewById(R.id.verdeBtn);
        azulBtn = findViewById(R.id.azulBtn);

        comunicacionTCP = ComunicacionTCP.getInstance(); //Cogemos la misma instancia


        rojoBtn.setOnClickListener(
                (v)->{
                    comunicacionTCP.mandarMensaje("COLOR::ROJO");
                    finish();
                }
        );

        verdeBtn.setOnClickListener(
                (v)->{
                    comunicacionTCP.mandarMensaje("COLOR::VERDE");
                    finish();
                }
        );

        azulBtn.setOnClickListener(
                (v)->{
                    comunicacionTCP.mandarMensaje("COLOR::AZUL");
                    finish();
                }
        );

    }
}
