package com.cbrchallange.core.dao;

import com.cbrchallange.core.dao.impl.DefaultCustomerFeedBackReviewDao;
import com.cbrchallange.core.data.CustomerFeedBackReviewData;
import com.cbrchallange.core.service.impl.DefaultCustomerFeedBackReviewService;
import com.cbrchallenge.core.model.CustomerFeedbackReviewModel;
import de.hybris.bootstrap.annotations.UnitTest;
import de.hybris.platform.servicelayer.dto.converter.Converter;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.LinkedList;
import java.util.List;

@UnitTest
@RunWith(MockitoJUnitRunner.class)
public class DefaultCustomerFeedbackReviewServiceTest {

    @InjectMocks
    private DefaultCustomerFeedBackReviewService defaultCustomerFeedBackReviewService;

    @Mock
    private DefaultCustomerFeedBackReviewDao defaultCustomerFeedBackReviewDao;

    @Mock
    private Converter customerFeedBackReviewDataConverter;

    @Before
    public void setup(){
        final List<CustomerFeedbackReviewModel> reviewModels = new LinkedList<>();
        final List<CustomerFeedBackReviewData> reviewDataList= new LinkedList<>();

        final CustomerFeedbackReviewModel model = new CustomerFeedbackReviewModel();
        model.setCode("model1");
        reviewModels.add(model);
        final CustomerFeedBackReviewData data = new CustomerFeedBackReviewData();
        data.setCode("model1");
        reviewDataList.add(data);
        Mockito.when(defaultCustomerFeedBackReviewDao.getAllCustomerReviews()).thenReturn(reviewModels);
        Mockito.when(customerFeedBackReviewDataConverter.convertAll(Mockito.anyListOf(CustomerFeedbackReviewModel.class))).thenReturn(reviewDataList);
    }

    @Test
    public void testGetAllReviews(){
        final List<CustomerFeedBackReviewData> dataList = defaultCustomerFeedBackReviewService.getAllReviews();
        Assert.assertEquals(dataList.size(),1);
        Assert.assertEquals(dataList.iterator().next().getCode(),"model1");
    }

}
