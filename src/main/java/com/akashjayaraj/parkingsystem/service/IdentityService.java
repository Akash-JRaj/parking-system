package com.akashjayaraj.parkingsystem.service;

import com.akashjayaraj.parkingsystem.exception.InvalidAadhaarException;
import com.akashjayaraj.parkingsystem.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class IdentityService {

    private Set<Long> verifiedUsers = new HashSet<>();

    public void register(User user) {
        if(validateAadhaar(user.getAadhaarId())) {
            verifiedUsers.add(user.getId());
            user.setVerifiedUser(true);
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

}
