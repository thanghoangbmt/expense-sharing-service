package com.thanghoang.expensesharing.repository;

import com.thanghoang.expensesharing.model.Group;
import com.thanghoang.expensesharing.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GroupRepository extends JpaRepository<Group, Long> {
    List<Group> findByCreatedBy(User user);
}
