package edu.temple.signupform;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextClock;
import android.widget.TextView;
import android.widget.Toast;

public class FormActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //declare variable
        //Textview
        TextView text_name = (TextView)findViewById(R.id.textViewName);
        TextView text_email = (TextView)findViewById(R.id.textViewEmail);
        TextView text_password = (TextView)findViewById(R.id.textViewPassword);
        TextView text_confirm = (TextView)findViewById(R.id.textViewPasswordConfirm);
        TextView text_name_msg = (TextView)findViewById(R.id.textViewNameMsg);
        TextView text_email_msg = (TextView)findViewById(R.id.textViewEmailMsg);
        TextView text_password_msg = (TextView)findViewById(R.id.textViewPasswordMsg);
        TextView text_confirm_msg = (TextView)findViewById(R.id.textViewConfirmMsg);
        //input field
        EditText input_name = (EditText)findViewById(R.id.editTextName);
        EditText input_email = (EditText)findViewById(R.id.editTextEmail);
        EditText input_password = (EditText)findViewById(R.id.editTextPassword);
        EditText input_confirm = (EditText)findViewById(R.id.editTextConfirm);
        //button
        Button save = (Button)findViewById(R.id.buttonSave);

        //onclick listener
        save.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                //store input to variable
                String name = String.valueOf(input_name.getText());
                String password = String.valueOf(input_password.getText());
                String confirm = String.valueOf(input_confirm.getText());
                //flag to check if all fields are filled and password matches with confirmation
                boolean flag = true;
                if(String.valueOf(input_name.getText()).isEmpty()){
                    text_name_msg.setText("Can't be empty here!");
                    flag=false;
                }else{
                    text_name_msg.setText(" ");
                }

                if(String.valueOf(input_email.getText()).isEmpty()){
                    text_email_msg.setText("Can't be empty here!");
                    flag=false;
                }else{
                    text_email_msg.setText(" ");
                }

                if(password.isEmpty()){
                    text_password_msg.setText("Can't be empty here!");
                    flag=false;
                }else{
                    text_password_msg.setText(" ");
                }

                if(confirm.isEmpty()){
                    text_confirm_msg.setText("Can't be empty here!");
                    flag=false;
                }else{
                    text_confirm_msg.setText(" ");
                }

                if(!confirm.isEmpty()&&!password.equals(confirm)){
                    text_confirm_msg.setText("Not match!");
                    flag=false;
                }

                //pop toast msg if all fields are completed and passwords match
                if(flag){
                    Context context = getApplicationContext();
                    String text = "welcome, "+name+", to the SignUpForm App";
                    int duration = Toast.LENGTH_SHORT;
                    Toast toast=Toast.makeText(context, text, duration);
                    toast.show();
                }
            }
        });
    }
}