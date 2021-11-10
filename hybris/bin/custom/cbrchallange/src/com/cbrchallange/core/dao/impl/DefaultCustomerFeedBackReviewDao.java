package com.cbrchallange.core.dao.impl;

import com.cbrchallange.core.dao.CustomerFeedBackReviewDao;
import com.cbrchallenge.core.model.CustomerFeedbackReviewModel;
import de.hybris.platform.core.model.user.CustomerModel;
import de.hybris.platform.servicelayer.search.FlexibleSearchQuery;
import de.hybris.platform.servicelayer.search.FlexibleSearchService;
import de.hybris.platform.servicelayer.search.SearchResult;
import org.springframework.beans.factory.annotation.Required;

import java.util.List;

public class DefaultCustomerFeedBackReviewDao implements CustomerFeedBackReviewDao {

    private static final String ALL_REVIEWS = "SELECT {" + CustomerFeedbackReviewModel.PK + "} FROM {" + CustomerFeedbackReviewModel._TYPECODE + "}";
    private static final String ALL_REVIEWS_BY_CUSTOMER_ID = "SELECT {" + CustomerFeedbackReviewModel.PK + "} FROM {" + CustomerFeedbackReviewModel._TYPECODE +
            " as cfr JOIN " + CustomerModel._TYPECODE + " as c ON " + " {cfr.customer} = {c.pk} } WHERE {c.uid}= ?customerID";
    private FlexibleSearchService flexibleSearchService;


    @Override
    public List<CustomerFeedbackReviewModel> getAllCustomerReviews() {
        final SearchResult<CustomerFeedbackReviewModel> reviewModelSearchResult = getFlexibleSearchService().search(ALL_REVIEWS);
        return reviewModelSearchResult.getResult();
    }

    @Override
    public List<CustomerFeedbackReviewModel> getAllCustomerReviewsByCustomerId(final String customerId) {
        final FlexibleSearchQuery query = new FlexibleSearchQuery(ALL_REVIEWS_BY_CUSTOMER_ID);
        query.addQueryParameter("customerId", customerId);
        final SearchResult<CustomerFeedbackReviewModel> reviewModelSearchResult = getFlexibleSearchService().search(query);
        return reviewModelSearchResult.getResult();
    }

    public FlexibleSearchService getFlexibleSearchService() {
        return flexibleSearchService;
    }

    @Required
    public void setFlexibleSearchService(FlexibleSearchService flexibleSearchService) {
        this.flexibleSearchService = flexibleSearchService;
    }
}
