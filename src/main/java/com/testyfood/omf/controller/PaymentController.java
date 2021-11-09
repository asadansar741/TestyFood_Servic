package com.testyfood.omf.controller;


import com.testyfood.omf.model.Payment;
import com.testyfood.omf.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


@RequiredArgsConstructor
@RequestMapping("/payment/")
@RestController
public class PaymentController {

    private final PaymentService paymentService;

    @PostMapping(path = "takepayment")
    public ResponseEntity takePayment(@RequestBody @Validated Payment payment){
        return new ResponseEntity<>(paymentService.savePayment(payment), HttpStatus.CREATED);
    }

}
