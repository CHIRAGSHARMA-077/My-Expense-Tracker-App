package com.example.myexpensetrackerapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

public class AddExpenseActivity extends AppCompatActivity {

    private EditText etCategory, etAmount, etDate, etNote;
    private Button btnSave;
    private ExpenseViewModel expenseViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_expense);

        // Bind views
        etCategory = findViewById(R.id.etCategory);
        etAmount = findViewById(R.id.etAmount);
        etDate = findViewById(R.id.etDate);
        etNote = findViewById(R.id.etNote);
        btnSave = findViewById(R.id.btnSave);

        // Initialize ViewModel
        expenseViewModel = new ViewModelProvider(this).get(ExpenseViewModel.class);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String category = etCategory.getText().toString().trim();
                String amountStr = etAmount.getText().toString().trim();
                String date = etDate.getText().toString().trim();
                String note = etNote.getText().toString().trim();

                if (!category.isEmpty() && !amountStr.isEmpty() && !date.isEmpty()) {
                    double amount = Double.parseDouble(amountStr);
                    Expense expense = new Expense(amount, category, date, note);
                    expenseViewModel.insert(expense);
                    finish(); // Close activity
                } else {
                    Toast.makeText(AddExpenseActivity.this, "Fill all required fields", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
