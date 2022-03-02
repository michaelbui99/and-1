package io.github.michaelbui99.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayDeque;
import java.util.Queue;

public class MainActivity extends AppCompatActivity {
    private String tempBuffer = "";
    private TextView display;
    private Queue<Integer> operandQueue = new ArrayDeque<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LinearLayout buttonContainer1 = findViewById(R.id.button_container_1);
        LinearLayout buttonContainer2 = findViewById(R.id.button_container_2);
        LinearLayout buttonContainer3 = findViewById(R.id.button_container_3);
        LinearLayout buttonContainer4 = findViewById(R.id.button_container_4);

        Button clearButton = findViewById(R.id.button_clear);
        Button plusButton = findViewById(R.id.button_plus);
        Button equalsButton = findViewById(R.id.button_equals);

        display = findViewById(R.id.display);

        assignOnNumberToChildrenElements(buttonContainer1);
        assignOnNumberToChildrenElements(buttonContainer2);
        assignOnNumberToChildrenElements(buttonContainer3);
        assignOnNumberToChildrenElements(buttonContainer4);

        clearButton.setOnClickListener(this::onClearClick);
        plusButton.setOnClickListener(this::onPlusClick);
        equalsButton.setOnClickListener(this::onEqualsClick);
    }

    public void onNumberButtonClick(View v) {
        Button buttonClicked = (Button) v;
        String textValue = buttonClicked.getText().toString();
        tempBuffer += textValue;

        display.setText(tempBuffer);
    }

    public void onClearClick(View v) {
        tempBuffer = "";
        display.setText("");
        operandQueue.clear();
    }

    public void onPlusClick(View v) {
        enqueueTempBuffer();

        if (!operandQueue.isEmpty()){
            int currentSum = getSum();
            display.setText(String.valueOf(currentSum));
        }

    }


    public void onEqualsClick(View v){
        enqueueTempBuffer();
        display.setText(String.valueOf(getSum()));
        tempBuffer="";
        operandQueue.clear();
    }

    private void assignOnNumberToChildrenElements(LinearLayout view) {
        for (int i = 0; i < view.getChildCount(); i++) {
            Button button = (Button) view.getChildAt(i);
            if (button.getId() != R.id.button_clear && button.getId() != R.id.button_plus) {
                button.setOnClickListener(this::onNumberButtonClick);
            }
        }
    }

    private void enqueueTempBuffer(){
        int tempBufferValue = Integer.parseInt(tempBuffer);
        tempBuffer = "";
        operandQueue.add(tempBufferValue);
    }

    private int getSum() {
        int sum = 0;
        for (Integer i : operandQueue) {
            sum += i;
        }

        return sum;
    }
}