package com.cbrchallange.core.interceptor;

import com.cbrchallenge.core.model.CustomerFeedbackReviewModel;
import de.hybris.platform.servicelayer.interceptor.InterceptorContext;
import de.hybris.platform.servicelayer.interceptor.InterceptorException;
import de.hybris.platform.servicelayer.interceptor.PrepareInterceptor;

public class CustomerFeedbackReviewPrepareInterceptor implements PrepareInterceptor<CustomerFeedbackReviewModel> {

    @Override
    public void onPrepare(CustomerFeedbackReviewModel customerFeedbackReviewModel, InterceptorContext interceptorContext) throws InterceptorException {
        customerFeedbackReviewModel.setCode(String.valueOf(System.currentTimeMillis())); // can be done with more suitable strategy
    }
}
