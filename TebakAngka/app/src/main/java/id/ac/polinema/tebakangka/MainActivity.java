package id.ac.polinema.tebakangka;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import java.util.Random;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
	private Button rtReset;
	private Button btnAngka;
	private EditText etAngka;
	private int angkaRandom = (int) (Math.random() * 5);
	//  TODO: deklarasikan variabel di sini

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		btnAngka = (Button) findViewById(R.id.btTebakAngka);
		etAngka = (EditText) findViewById(R.id.etTebak);
		rtReset = (Button) findViewById(R.id.resButton);
		angkaRandom = buatAngkaRandom(1, 5);
		// TODO: bind layout di sini
	}

	// TODO: generate angka random di sini
	private void initRandomNumber() {
		btnAngka.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				if (!etAngka.equals("")) {
					handleGuess(view);
				}
			}
		});
	}
	public void handleGuess(View view) {
		int angkaTebakan = Integer.parseInt(etAngka.getText().toString());
		if (angkaTebakan == angkaRandom) {
			btnAngka.setClickable(false);
			Toast.makeText(this, "Tebakan Anda Benar", Toast.LENGTH_SHORT).show();
		} else if (angkaTebakan < angkaRandom) {
			Toast.makeText(this, "Tebakan Anda Terlalu KECIL", Toast.LENGTH_SHORT).show();
		} else if (angkaTebakan > angkaRandom) {
			Toast.makeText(this, "Tebakan Anda Terlalu BESAR", Toast.LENGTH_SHORT).show();
		} else {
			Toast.makeText(this, "Tebakan Anda Salah", Toast.LENGTH_SHORT).show();
		}
		angkaRandom = buatAngkaRandom(1, 5);
	}
	private int buatAngkaRandom(int angkaMin, int angkaMax) {
		Random rand = new Random();
		int randomNum = rand.nextInt(angkaMax - angkaMin) + angkaMin;
		return randomNum;
	}

	// TODO: Tambahkan logika untuk melakukan pengecekan angka

	public void handleReset(View view) {
		// TODO: Reset tampilan
		rtReset.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				initRandomNumber();
				etAngka.setText("");
			}
		});
	}
}
