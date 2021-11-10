package com.cbrchallange.core.service.impl;

import com.cbrchallange.core.dao.CustomerFeedBackReviewDao;
import com.cbrchallange.core.data.CustomerFeedBackReviewData;
import com.cbrchallange.core.service.CustomerFeedBackReviewService;
import com.cbrchallenge.core.model.CustomerFeedbackReviewModel;
import de.hybris.platform.servicelayer.dto.converter.Converter;
import org.springframework.beans.factory.annotation.Required;

import java.util.List;

public class DefaultCustomerFeedBackReviewService implements CustomerFeedBackReviewService {

    private CustomerFeedBackReviewDao customerFeedBackReviewDao;
    private Converter<CustomerFeedbackReviewModel,CustomerFeedBackReviewData> customerFeedBackReviewDataConverter;

    @Override
    public List<CustomerFeedBackReviewData> getAllReviews() {
        final List<CustomerFeedbackReviewModel> customerFeedbackReviewModels = getCustomerFeedBackReviewDao().getAllCustomerReviews();
        return getCustomerFeedBackReviewDataConverter().convertAll(customerFeedbackReviewModels);
    }

    @Override
    public List<CustomerFeedBackReviewData> getAllReviewsByCustomerId(final String customerId) {
        final List<CustomerFeedbackReviewModel> customerFeedbackReviewModels = getCustomerFeedBackReviewDao().getAllCustomerReviewsByCustomerId(customerId);
        return getCustomerFeedBackReviewDataConverter().convertAll(customerFeedbackReviewModels);
    }

    public CustomerFeedBackReviewDao getCustomerFeedBackReviewDao() {
        return customerFeedBackReviewDao;
    }

    @Required
    public void setCustomerFeedBackReviewDao(CustomerFeedBackReviewDao customerFeedBackReviewDao) {
        this.customerFeedBackReviewDao = customerFeedBackReviewDao;
    }

    public Converter<CustomerFeedbackReviewModel, CustomerFeedBackReviewData> getCustomerFeedBackReviewDataConverter() {
        return customerFeedBackReviewDataConverter;
    }

    @Required
    public void setCustomerFeedBackReviewDataConverter(Converter<CustomerFeedbackReviewModel, CustomerFeedBackReviewData> customerFeedBackReviewDataConverter) {
        this.customerFeedBackReviewDataConverter = customerFeedBackReviewDataConverter;
    }
}
