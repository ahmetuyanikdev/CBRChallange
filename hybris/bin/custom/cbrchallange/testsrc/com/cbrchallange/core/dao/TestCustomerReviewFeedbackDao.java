package com.cbrchallange.core.dao;


import com.cbrchallange.core.dao.impl.DefaultCustomerFeedBackReviewDao;
import com.cbrchallange.core.data.CustomerFeedBackReviewData;
import com.cbrchallenge.core.model.CustomerFeedbackReviewModel;
import de.hybris.bootstrap.annotations.UnitTest;
import de.hybris.platform.servicelayer.search.FlexibleSearchQuery;
import de.hybris.platform.servicelayer.search.FlexibleSearchService;
import de.hybris.platform.servicelayer.search.SearchResult;
import de.hybris.platform.servicelayer.search.impl.SearchResultImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

@UnitTest
@RunWith(MockitoJUnitRunner.class)
public class TestCustomerReviewFeedbackDao {

    @InjectMocks
    private DefaultCustomerFeedBackReviewDao defaultCustomerFeedBackReviewDao;

    @Mock
    private FlexibleSearchService flexibleSearchService;

    @Before
    public void setup(){
        final List<CustomerFeedbackReviewModel> customerFeedbackReviewModels = new ArrayList<>();
        CustomerFeedbackReviewModel model1 = new CustomerFeedbackReviewModel();
        model1.setCode("sample1");
        CustomerFeedbackReviewModel model2 = new CustomerFeedbackReviewModel();
        model1.setCode("sample2");
        customerFeedbackReviewModels.add(model1);
        customerFeedbackReviewModels.add(model2);
        final SearchResult searchResult = new SearchResultImpl<>(customerFeedbackReviewModels,2,2,1);
        Mockito.when(flexibleSearchService.search(Mockito.anyString())).thenReturn(searchResult);

        final List<CustomerFeedbackReviewModel> customerFeedbackReviewModels2 = new ArrayList<>();
        customerFeedbackReviewModels2.add(model2);
        final SearchResult searchResult2 = new SearchResultImpl<>(customerFeedbackReviewModels2,1,1,1);
        Mockito.when(flexibleSearchService.search(Mockito.any(FlexibleSearchQuery.class))).thenReturn(searchResult2);
    }

    @Test
    public void testGetAllCustomerReviews(){
       final List<CustomerFeedbackReviewModel> result = defaultCustomerFeedBackReviewDao.getAllCustomerReviews();
       Assert.assertNotNull(result);
       Assert.assertEquals(result.size(),2);
    }

    @Test
    public void testGetAllCustomerReviewsByCustomer(){
        final List<CustomerFeedbackReviewModel> result = defaultCustomerFeedBackReviewDao.getAllCustomerReviewsByCustomerId("23232323");
        Assert.assertNotNull(result);
        Assert.assertEquals(result.size(),1);
    }

}
