package com.ArtGalleryManagement.Backend.ResponseModels;

import com.ArtGalleryManagement.Backend.Entity.*;
import lombok.Data;

@Data
public class ShelfCurrentLoansResponse {

    public ShelfCurrentLoansResponse(Product product, int daysLeft) {
        this.product = product;
        this.daysLeft = daysLeft;
    }

    private Product product;

    private int daysLeft;
}
