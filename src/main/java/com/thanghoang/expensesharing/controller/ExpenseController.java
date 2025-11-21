package com.thanghoang.expensesharing.controller;

import com.thanghoang.expensesharing.model.Expense;
import com.thanghoang.expensesharing.service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/expenses")
public class ExpenseController {
    @Autowired
    private ExpenseService expenseService;

    @PostMapping
    public Expense createExpense(@RequestBody Map<String, Object> body, @AuthenticationPrincipal UserDetails userDetails) {
        Long groupId = Long.valueOf(body.get("groupId").toString());
        BigDecimal amount = new BigDecimal(body.get("amount").toString());
        String description = body.get("description").toString();
        return expenseService.createExpense(groupId, amount, description, userDetails.getUsername());
    }

    @GetMapping("/group/{groupId}")
    public List<Expense> getExpensesByGroup(@PathVariable Long groupId) {
        return expenseService.getExpensesByGroup(groupId);
    }
}
