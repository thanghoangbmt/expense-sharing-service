package com.thanghoang.expensesharing.repository;

import com.thanghoang.expensesharing.model.Expense;
import com.thanghoang.expensesharing.model.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExpenseRepository extends JpaRepository<Expense, Long> {
    List<Expense> findByGroup(Group group);
}
