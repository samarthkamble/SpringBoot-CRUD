package com.example.demo.services;

import java.util.Base64;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Users;
import com.example.demo.repo.UsersRepository;

@Service
public class UsersService {
    @Autowired
    private UsersRepository usersRepository;

    public Users saveUser(Users user) {
        // Encrypt the password before saving
        user.setPassword(encryptPassword(user.getPassword()));
        return usersRepository.save(user);
    }

    public String encryptPassword(String password) {
        // You can use your preferred encryption algorithm/library here
        // For simplicity, let's assume a basic encryption using Base64
        return Base64.getEncoder().encodeToString(password.getBytes());
    }

    public boolean validateUser(String userName, String password) {
        Optional<Users> optionalUser = usersRepository.findByUserName(userName);
        if (optionalUser.isPresent()) {
            Users user = optionalUser.get();
            // Decrypt the stored password and check if it matches
            String decryptedPassword = decryptPassword(user.getPassword());
            return decryptedPassword.equals(password);
        }
        return false;
    }

    public String decryptPassword(String encryptedPassword) {
        // You can use your preferred decryption algorithm/library here
        // For simplicity, let's assume a basic decryption using Base64
        byte[] decodedBytes = Base64.getDecoder().decode(encryptedPassword);
        return new String(decodedBytes);
    }
}
