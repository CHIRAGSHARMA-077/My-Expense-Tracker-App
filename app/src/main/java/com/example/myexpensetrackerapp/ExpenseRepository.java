package com.example.myexpensetrackerapp;

import android.app.Application;
import android.os.Handler;
import android.os.Looper;

import androidx.lifecycle.LiveData;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExpenseRepository {
    private final ExecutorService executor;
    private final Handler handler;
    private final ExpenseDao expenseDao;

    private final LiveData<List<Expense>> allExpenses;
    private final LiveData<Double> totalAmount;

    public ExpenseRepository(Application application) {
        ExpenseDatabase expenseDatabase = ExpenseDatabase.getInstance(application);
        expenseDao = expenseDatabase.expenseDao();
        allExpenses = expenseDao.getAllExpenses();
        totalAmount = expenseDao.getTotalAmount();
        executor = Executors.newSingleThreadExecutor();
        handler = new Handler(Looper.getMainLooper());
    }

    public void insert(Expense expense) {
        executor.execute(() -> expenseDao.insert(expense));
    }

    public void delete(Expense expense) {
        executor.execute(() -> expenseDao.delete(expense));
    }

    public LiveData<List<Expense>> getAllExpenses() {
        return allExpenses;
    }

    public LiveData<Double> getTotalAmount() {
        return totalAmount;
    }
}
