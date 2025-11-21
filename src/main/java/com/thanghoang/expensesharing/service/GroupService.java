package com.thanghoang.expensesharing.service;

import com.thanghoang.expensesharing.model.Group;
import com.thanghoang.expensesharing.model.User;
import com.thanghoang.expensesharing.repository.GroupRepository;
import com.thanghoang.expensesharing.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class GroupService {
    @Autowired
    private GroupRepository groupRepository;
    @Autowired
    private UserRepository userRepository;

    public Group createGroup(String name, String creatorEmail) {
        User creator = userRepository.findByEmail(creatorEmail).orElseThrow();
        Group group = new Group();
        group.setName(name);
        group.setCreatedBy(creator);
        groupRepository.save(group);
        return group;
    }

    public List<Group> getGroups(String userEmail) {
        User user = userRepository.findByEmail(userEmail).orElseThrow();
        return groupRepository.findByCreatedBy(user);
    }

    public Group addMember(Long groupId, String memberEmail) {
        Group group = groupRepository.findById(groupId).orElseThrow();
        User user = userRepository.findByEmail(memberEmail).orElseThrow();
        // TODO: Implement member addition logic (e.g., group.members)
        return group;
    }
}
