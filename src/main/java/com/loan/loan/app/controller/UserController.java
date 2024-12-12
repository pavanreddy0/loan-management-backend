package com.loan.loan.app.controller;

import com.loan.loan.app.dto.Item;
import com.loan.loan.app.dto.Loan;
import com.loan.loan.app.dto.LoanEligibilityResponse;
import com.loan.loan.app.dto.OrderResponse;
import com.loan.loan.app.model.Users;
import com.loan.loan.app.service.UserService;
import com.loan.loan.app.utility.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/loan")
public class UserController {
    @Autowired
    private UserService userService;
    public Users authenticatedUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        System.out.println("authenticatedUser " + (Users) authentication.getPrincipal());
        return (Users) authentication.getPrincipal();
    }

//    @RequestMapping("/")
//    public ResponseEntity<?> getProducts(){
//        try{
//            List<Item> items = itemService.getAllItems();
//            ApiResponse<List<Item>> response = new ApiResponse<>("Success", HttpStatus.OK, items);
//            return new ResponseEntity<>(response, HttpStatus.OK);
//
//        } catch (Exception e){
//            ApiResponse<String> response = new ApiResponse<>("An error occurred: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, null);
//            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//
//    }


    @RequestMapping("/is_eligible/{amount}")
    public ResponseEntity<?> getOrders(@PathVariable Integer amount){
        try {
            Users user = authenticatedUser();
            System.out.println("User " + user);

            boolean isEligible = userService.isEligibleForLoan(user, amount);
            LoanEligibilityResponse loanEligibilityResponse = new LoanEligibilityResponse(isEligible);
            ApiResponse<LoanEligibilityResponse> response = new ApiResponse<>("Success", HttpStatus.OK, loanEligibilityResponse);
            return new ResponseEntity<>(response, HttpStatus.OK);

        } catch (Exception e){
            ApiResponse<String> response = new ApiResponse<>("An error occurred: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, null);
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
