package muskan.myappcompany.numbershapes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    class Number{
        int num;
        public boolean isSquare(){
            double squareRoot = Math.sqrt(num);
            if(squareRoot == Math.floor(squareRoot)){
                return true;
            }else{
                return false;
            }

        }

        public boolean isTriangular(){
            int x = 1;
            int triangularNumber = 1;
            while(triangularNumber < num){
                x++;
                triangularNumber = triangularNumber + x;
            }
            if(triangularNumber == num){
                return true;
            }else{
                return false;
            }
        }
    }
    public void testNumber(View view){
        Log.i("Info", "Button pressed!");
        EditText editText = (EditText) findViewById(R.id.editText);
        Number myNumber = new Number();
        myNumber.num = Integer.parseInt(editText.getText().toString());
        String message = Integer.toString(myNumber.num);
        if(myNumber.isSquare() && myNumber.isTriangular()){
            message += " is both square and triangular!";
        }else if(myNumber.isSquare()){
            message += " is sqaure but not triangular.";
        }else if(myNumber.isTriangular()){
            message += " is triangular but not square.";
        }
        else{
            message += " is neither square nor triangular.";
        }

        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
