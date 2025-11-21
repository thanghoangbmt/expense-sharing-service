package com.thanghoang.expensesharing.controller;

import com.thanghoang.expensesharing.model.Group;
import com.thanghoang.expensesharing.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/groups")
public class GroupController {
    @Autowired
    private GroupService groupService;

    @PostMapping
    public Group createGroup(@RequestBody Map<String, String> body, @AuthenticationPrincipal UserDetails userDetails) {
        String name = body.get("name");
        return groupService.createGroup(name, userDetails.getUsername());
    }

    @GetMapping
    public List<Group> getGroups(@AuthenticationPrincipal UserDetails userDetails) {
        return groupService.getGroups(userDetails.getUsername());
    }

    @PostMapping("/{id}/members")
    public Group addMember(@PathVariable Long id, @RequestBody Map<String, String> body) {
        String email = body.get("email");
        return groupService.addMember(id, email);
    }
}
