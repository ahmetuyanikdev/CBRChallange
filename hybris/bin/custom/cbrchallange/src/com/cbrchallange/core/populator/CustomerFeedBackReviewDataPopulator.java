package com.cbrchallange.core.populator;

import com.cbrchallange.core.data.CustomerFeedBackReviewData;
import com.cbrchallenge.core.model.CustomerFeedbackReviewModel;
import de.hybris.platform.converters.Populator;
import de.hybris.platform.servicelayer.dto.converter.ConversionException;

public class CustomerFeedBackReviewDataPopulator implements Populator<CustomerFeedbackReviewModel, CustomerFeedBackReviewData> {

    @Override
    public void populate(CustomerFeedbackReviewModel customerFeedbackReviewModel,
                         CustomerFeedBackReviewData customerFeedBackReviewData) throws ConversionException {
        customerFeedBackReviewData.setCode(customerFeedbackReviewModel.getCode());
        customerFeedBackReviewData.setExplanation(customerFeedbackReviewModel.getExplanation());
        customerFeedBackReviewData.setIssueDate(customerFeedbackReviewModel.getIssueDate());
        customerFeedBackReviewData.setPriority(customerFeedbackReviewModel.getPriority().getCode());
    }
}
