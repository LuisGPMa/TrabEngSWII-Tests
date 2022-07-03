package br.pucrs.engswii.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.pucrs.engswii.beans.LoginSystem;
import br.pucrs.engswii.beans.LoginSystemRegistration;
import br.pucrs.engswii.beans.LoginSystemReply;
import br.pucrs.engswii.beans.User;

@RestController
public class UserLogin {

    @PostMapping("/login")
    public LoginSystemReply registerLogin(@RequestBody User userLogin){
        System.out.println("Login request!");
        LoginSystemReply loginSystemReply = new LoginSystemReply();
        boolean sucessLogin = LoginSystemRegistration.getInstance().processLogins(userLogin);
        System.out.println("Login Sucess: " + sucessLogin);
        if(sucessLogin){
            loginSystemReply.setUser(userLogin);
            loginSystemReply.setloginSys(true);            
        }

        return loginSystemReply;
    } 

    @PutMapping("/logout")
    public String Logout(){
        System.out.println("Logout request!");
        LoginSystem.getInstance().setUserLogged(null);
        System.out.println("Logout...");
        return "Logout!";
    }

    
}
