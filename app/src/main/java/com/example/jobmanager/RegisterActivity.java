package com.example.jobmanager;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
public class RegisterActivity extends AppCompatActivity {
    EditText username, password, repassword, oficina;
    Button signup, signin;
    DBHelper DB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        repassword = (EditText) findViewById(R.id.repassword);
        oficina = (EditText) findViewById(R.id.oficina);
        signup = (Button) findViewById(R.id.btnsignup);
        signin = (Button) findViewById(R.id.btnsignin);
        DB = new DBHelper(this);

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = username.getText().toString();
                String pass = password.getText().toString();
                String repass = repassword.getText().toString();
                String ofi = oficina.getText().toString();

                if(user.equals("")||pass.equals("")||repass.equals("")||ofi.equals(""))
                    Toast.makeText(RegisterActivity.this, "Por favor, cubre todos los campos", Toast.LENGTH_SHORT).show();
                    else if(Integer.parseInt(ofi)<1||Integer.parseInt(ofi)>10) {
                        Toast.makeText(RegisterActivity.this, "Introduce un número de oficina válido (1-10)", Toast.LENGTH_LONG).show();
                        }else{
                            if(pass.equals(repass)){
                                Boolean checkuser = DB.checkusername(user);
                                if(checkuser==false){
                                    Boolean insert = DB.insertData(user, pass, Integer.parseInt(ofi));
                                    if(insert==true){
                                        Toast.makeText(RegisterActivity.this, "Registro exitoso", Toast.LENGTH_SHORT).show();
                                        Intent intent = new Intent(getApplicationContext(),UserMenu.class);
                                        startActivity(intent);
                                    }else{
                                        Toast.makeText(RegisterActivity.this, "Registro fallido", Toast.LENGTH_SHORT).show();
                                    }
                                }
                                else{
                                    Toast.makeText(RegisterActivity.this, "El usuario ya existe", Toast.LENGTH_SHORT).show();
                                }
                            }else{
                                Toast.makeText(RegisterActivity.this, "Las contraseñas no coinciden", Toast.LENGTH_SHORT).show();
                            }
                        }
                    }
        });
        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });
    }
}