package com.desafioPicPay.services;

import com.desafioPicPay.domain.user.User;
import com.desafioPicPay.domain.user.UserType;
import com.desafioPicPay.dtos.UserDTO;
import com.desafioPicPay.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class UserServices {

    @Autowired
    private UserRepository userRepository;


    public void validateTransaction(User sender, BigDecimal amount) throws Exception{

        if(sender.getUserType() == UserType.MERCHANT){
            throw new Exception("Usuário do tipo logista não está autorizado a realizar transações.");
        }

        if(sender.getBalance().compareTo(amount) < 0){
            throw new Exception("Saldo insuficiente.");
        }

    }

    public User findUserById(Long id) throws Exception{
        return this.userRepository.findUserById(id).orElseThrow(() -> new Exception("Usuário não encontrado."));
    }

    public void saveUser(User user){
        this.userRepository.save(user);
    }

    public User createUser(UserDTO user) {

        User newUser = new User(user);

        this.saveUser(newUser);

        return newUser;

    }

    public List<User> getAllUsers() {

        return this.userRepository.findAll();

    }
}
