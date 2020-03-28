package appmoviles.com.clientesingleton;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText coordX, coordY;
    private Button posSendBtn;
    private ComunicacionTCP comunicacionTCP;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        comunicacionTCP = ComunicacionTCP.getInstance();
        comunicacionTCP.solicitarConexion("10.0.2.2");

        coordX = findViewById(R.id.coordX);
        coordY = findViewById(R.id.coordY);
        posSendBtn = findViewById(R.id.posSendBtn);

        posSendBtn.setOnClickListener(
                (v)->{
                    comunicacionTCP.mandarMensaje("POS::"+coordX.getText()+"::"+coordY.getText());
                    Intent i = new Intent(this, ColorActivity.class);
                    startActivity(i);
                }
        );
    }
}