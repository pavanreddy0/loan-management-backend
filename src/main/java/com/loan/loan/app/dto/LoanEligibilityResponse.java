package com.loan.loan.app.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class LoanEligibilityResponse {
    private boolean eligible;
}
