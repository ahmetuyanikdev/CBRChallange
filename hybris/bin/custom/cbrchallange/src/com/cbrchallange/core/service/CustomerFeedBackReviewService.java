package com.cbrchallange.core.service;

import com.cbrchallange.core.data.CustomerFeedBackReviewData;

import java.util.List;

public interface CustomerFeedBackReviewService {
    List<CustomerFeedBackReviewData> getAllReviews();
    List<CustomerFeedBackReviewData> getAllReviewsByCustomerId(final String customerId);
}
