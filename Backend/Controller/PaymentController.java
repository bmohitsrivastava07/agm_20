package com.ArtGalleryManagement.Backend.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ArtGalleryManagement.Backend.RequestModels.PaymentInfoRequest;
import com.ArtGalleryManagement.Backend.Service.PaymentService;
import com.stripe.exception.StripeException;
import com.stripe.model.PaymentIntent;

@RestController
@CrossOrigin("https://localhost:3000")
@RequestMapping("/payment/secure")
public class PaymentController {

	PaymentService paymentService;
	
	@Autowired
	public PaymentController(PaymentService paymentService) {
		this.paymentService = paymentService;
	}
	
	@PostMapping("/payment-intent")
	public ResponseEntity<String> createPaymentIntent(@RequestBody PaymentInfoRequest paymentInfoRequest) throws StripeException{
		PaymentIntent paymentIntent= paymentService.createPaymentIntent(paymentInfoRequest);
		String paymentStr= paymentIntent.toJson();
		return new ResponseEntity<>(paymentStr,HttpStatus.OK);
	}
	
	@PutMapping("/payment-complete")
	public ResponseEntity<String> stripePaymentComplete() throws Exception{
		String userEmail="ankita@gmail.com";
		if(userEmail==null) {
			throw new Exception("User Email is missing");
		}
		return paymentService.stripePayment(userEmail);
	}
	
	
	
}
