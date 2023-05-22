package com.ArtGalleryManagement.Backend.Service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ArtGalleryManagement.Backend.Repository.PaymentRepository;
import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.PaymentIntent;

import lombok.Value;

@Service
@Transactional
public class PaymentService {

   PaymentRepository paymentRepository;

   @Autowired
	public PaymentService(PaymentRepository paymentRepository, @Value("${stripe.key.secret}")String secretKey) {
		this.paymentRepository=paymentRepository;
		Stripe.apiKey=secretKey;
	}
   
   public PaymentIntent createPaymentIntent(PaymentInfoRequest paymentInfoRequest) throws StripeException{
	   List<String> paymentMethodTypes=new ArrayList<>();
   }
   
}
