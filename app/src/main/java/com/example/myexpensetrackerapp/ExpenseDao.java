package com.example.myexpensetrackerapp;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao

public interface ExpenseDao {
@Insert
    void insert(Expense expense);
@Delete
    void delete(Expense expense);
@Query("SELECT*FROM expense_table ORDER BY id DESC")
    LiveData<List<Expense>> getAllExpenses();
@Query("SELECT SUM(amount) FROM expense_table")
    LiveData<Double>getTotalAmount();
}
