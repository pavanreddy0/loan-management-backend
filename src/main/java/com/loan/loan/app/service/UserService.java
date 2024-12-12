package com.loan.loan.app.service;

import com.loan.loan.app.model.Users;
import com.loan.loan.app.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService  {
    @Autowired
    private UserRepository userReposiroty;


    /**
     * Once user logs in,
     * I should be able to see some items on my page
     * Cart items
     * Orders in the Orders Page
     */
//    public List<Items> getItemsInCart(Users users){
//        return cartRepository.findAllByUser(users);
//    }
    public List<Users> getAllUsers(){
        return userReposiroty.findAll();
    }

    public Users getUserByMail(String email) throws UsernameNotFoundException{
        Optional<Users> users = userReposiroty.findByUsername(email);
        return users.get();
    }

    public List<Users> saveUser(Users users){
        userReposiroty.save(users);
        return getAllUsers();
    }

    public boolean isEligibleForLoan(Users users, Integer loanAmount){
        Integer creditScore = users.getCreditScore();
//        500 - 900
        /*
        * 500 - 550 -> 0 - 1999
        * 551 - 600 -> 2000 - 2999
        * 601 - 650 -> 3000
        * 651 - 700 -> 4000
        * 701 - 750 -> 5000
        * 751 - 800 -> 600
        * 801 - 850 -> 7000
        * >= 851 -> 8000
        * */
        if(loanAmount > 0 && loanAmount < 2000){
            if(creditScore >= 500)
                return true;
        }
        else if(loanAmount > 2000 && loanAmount < 3000){
            if(creditScore > 550)
                return true;
        }
        else if(loanAmount > 3000 && loanAmount < 4000){
            if(creditScore > 600)
                return true;
        }
        else if(loanAmount > 4000 && loanAmount < 5000){
            if(creditScore > 650)
                return true;
        }
        else if(loanAmount > 5000 && loanAmount < 6000){
            if(creditScore > 700)
                return true;
        }
        else if(loanAmount > 6000 && loanAmount < 7000){
            if(creditScore > 750)
                return true;
        }
        else if(loanAmount > 7000 && loanAmount < 8000){
            if(creditScore > 800)
                return true;
        }
        else if(loanAmount > 8000){
            if(creditScore > 850)
                return true;
        }

        return false;
    }


}
