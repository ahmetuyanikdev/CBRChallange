package com.cbrchallange.core.dao;

import com.cbrchallenge.core.model.CustomerFeedbackReviewModel;

import java.util.List;

public interface CustomerFeedBackReviewDao {

     List<CustomerFeedbackReviewModel> getAllCustomerReviews();

     List<CustomerFeedbackReviewModel> getAllCustomerReviewsByCustomerId(final String customerId);
}
