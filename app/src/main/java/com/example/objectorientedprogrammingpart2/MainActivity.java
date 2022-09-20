/**
 * IMPORTANT: Make sure you are using the correct package name.
 * This example uses the package name:
 * package com.example.android.justjava
 * If you get an error when copying this code into Android studio, update it to match teh package name found
 * in the project's AndroidManifest.xml file.
 **/

package com.example.objectorientedprogrammingpart2;


import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.objectorientedprogrammingpart2.R;

import org.w3c.dom.Text;

import java.text.NumberFormat;
/** not doing intents because udacity says it doesn't work on the emulator

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the order button is clicked.
     */

    int quantity = 2;

    /**
     * This method displays the given text on the screen.
     */
    private void displayMessage(String message) {
        TextView priceTextView = (TextView) findViewById(R.id.order_summary_price);
        priceTextView.setText(message);
    }

    public void submitOrder(View view) {
        CheckBox whippedCreamCheckBox = (CheckBox) findViewById(R.id.whipped_cream_checkbox);
        boolean whippedCream = whippedCreamCheckBox.isChecked();
        CheckBox chocolateCheckBox = (CheckBox) findViewById(R.id.chocolate_checkbox);
        boolean chocolate = chocolateCheckBox.isChecked();
        createOrderSummary(quantity);
    }

    public void increment(View view){
        if(quantity != 100) {
            quantity++;
            displayQuantity(quantity);
        }
    }
    public void decrement(View view){
        if(quantity != 1){
            quantity--;
            displayQuantity(quantity);
        }
    }
    /**
     * Calculates the price of the order based on the current quantity.
     *
     * @return the price
     */
    private int calculatePrice() {
        int price = 5;
        CheckBox whippedCreamCheckBox = (CheckBox) findViewById(R.id.whipped_cream_checkbox);
        if(whippedCreamCheckBox.isChecked()){price ++;}
        CheckBox chocolateCheckBox = (CheckBox) findViewById(R.id.chocolate_checkbox);
        if(chocolateCheckBox.isChecked()){price += 2;}
        return quantity * price;
    }
    private void createOrderSummary(int quantity) {
        TextView name = (TextView) findViewById(R.id.order_summary_name);
        EditText nameEdit = (EditText) findViewById(R.id.name_edit);
        name.setText("Name: " + nameEdit.getText());
        TextView creamView = (TextView) findViewById(R.id.order_summary_cream);
        CheckBox whippedCreamCheckBox = (CheckBox) findViewById(R.id.whipped_cream_checkbox);
        if(whippedCreamCheckBox.isChecked())
            {creamView.setText("Add whipped cream? true");}
        else{creamView.setText("Add whipped cream? false");}
        TextView chocView = (TextView) findViewById(R.id.order_summary_chocolate);
        CheckBox chocolateCheckBox = (CheckBox) findViewById(R.id.chocolate_checkbox);
        if(chocolateCheckBox.isChecked())
            {chocView.setText("Add chocolate? true");}
        else{chocView.setText("Add chocolate? false");}

        TextView quantityView = (TextView) findViewById(R.id.order_summary_quantity);
        quantityView.setText("Quantity: " + quantity);
        TextView orderSummaryPrice = (TextView) findViewById(R.id.order_summary_price);
        orderSummaryPrice.setText("Price: $" + calculatePrice());


    }
    /**
     * This method displays the given quantity value on the screen.
     */
    private void displayQuantity(int quantity) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + quantity);
    }
    /**
     * This method displays the given price on the screen.
     */
    private void displayPrice(int number) {
        TextView orderSummaryPrice = (TextView) findViewById(R.id.order_summary_price);
        orderSummaryPrice.setText("Price: $" + NumberFormat.getCurrencyInstance().format(number));
    }
}