package com.thanghoang.expensesharing.service;

import com.thanghoang.expensesharing.model.Expense;
import com.thanghoang.expensesharing.model.Group;
import com.thanghoang.expensesharing.model.User;
import com.thanghoang.expensesharing.repository.ExpenseRepository;
import com.thanghoang.expensesharing.repository.GroupRepository;
import com.thanghoang.expensesharing.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class ExpenseService {
    @Autowired
    private ExpenseRepository expenseRepository;
    @Autowired
    private GroupRepository groupRepository;
    @Autowired
    private UserRepository userRepository;

    public Expense createExpense(Long groupId, BigDecimal amount, String description, String paidByEmail) {
        Group group = groupRepository.findById(groupId).orElseThrow();
        User paidBy = userRepository.findByEmail(paidByEmail).orElseThrow();
        Expense expense = new Expense();
        expense.setGroup(group);
        expense.setAmount(amount);
        expense.setDescription(description);
        expense.setPaidBy(paidBy);
        expenseRepository.save(expense);
        return expense;
    }

    public List<Expense> getExpensesByGroup(Long groupId) {
        Group group = groupRepository.findById(groupId).orElseThrow();
        return expenseRepository.findByGroup(group);
    }
}
