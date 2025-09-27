package com.akashjayaraj.parkingsystem.service;

import com.akashjayaraj.parkingsystem.exception.InvalidAadhaarException;
import com.akashjayaraj.parkingsystem.exception.UserNotFoundException;
import com.akashjayaraj.parkingsystem.model.User;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class IdentityService {
    private Map<Long, User> users = new HashMap<>();
    private Set<Long> verifiedUsers = new HashSet<>();

    public void register(User user) {
        if(validateAadhaar(user.getAadhaarId())) {
            verifiedUsers.add(user.getId());
            user.setVerifiedUser(true);
            users.put(user.getId(), user);
        }
        else {
            throw new InvalidAadhaarException("Aadhaar details are invalid! Cannot verify aadhaar.");
        }
    }

    public boolean validateAadhaar(String aadhaarId) {
        return aadhaarId.length() == 16 && OTPValidation(aadhaarId);
    }

    public boolean OTPValidation(String aadhaarId) {
        //can implement later
        return true;
    }

    public boolean isVerifiedUser(User user) {
        return verifiedUsers.contains(user.getId());
    }

    public List<Long> getVerifiedUserId() {
        return new ArrayList<>(verifiedUsers);
    }

    public User getUserByUserId(Long userId) {
        if(users.containsKey(userId)) {
            throw new UserNotFoundException("User with id " + userId + " Not found!");
        }
        return users.get(userId);
    }

}
