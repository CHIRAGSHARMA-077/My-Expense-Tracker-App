package com.example.myexpensetrackerapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ExpenseViewModel expenseViewModel;
    private RecyclerView rvExpenses;
    private TextView tvTotalAmount;
    private FloatingActionButton fabAdd;
    private ExpenseAdapter adapter;  // you'll create this next

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);  // uses the XML you shared

        rvExpenses = findViewById(R.id.rvExpenses);
        tvTotalAmount = findViewById(R.id.tvTotalAmount);
        fabAdd = findViewById(R.id.fabAdd);

        rvExpenses.setLayoutManager(new LinearLayoutManager(this));
        adapter = new ExpenseAdapter();
        rvExpenses.setAdapter(adapter);

        expenseViewModel = new ViewModelProvider(this).get(ExpenseViewModel.class);

        // Observe list of expenses
        expenseViewModel.getAllExpenses().observe(this, new Observer<List<Expense>>() {
            @Override
            public void onChanged(List<Expense> expenses) {
                adapter.setExpenses(expenses);
            }
        });

        // Observe total amount
        expenseViewModel.getTotalAmount().observe(this, new Observer<Double>() {
            @Override
            public void onChanged(Double total) {
                if (total != null) {
                    tvTotalAmount.setText("Total: ₹" + total);
                } else {
                    tvTotalAmount.setText("Total: ₹0");
                }
            }
        });

        // FloatingActionButton click listener
        fabAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // TODO: Replace with your AddExpenseActivity when ready
                Intent intent = new Intent(MainActivity.this, AddExpenseActivity.class);
                startActivity(intent);
            }
        });
    }
}
