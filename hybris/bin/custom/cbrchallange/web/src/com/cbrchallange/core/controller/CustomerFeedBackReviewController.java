package com.cbrchallange.core.controller;

import com.cbrchallange.core.data.CustomerFeedBackReviewData;
import com.cbrchallange.core.service.CustomerFeedBackReviewService;
import org.apache.log4j.Logger;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping(value = "/reviews")
public class CustomerFeedBackReviewController {

    Logger LOG = Logger.getLogger(CustomerFeedBackReviewController.class);

    @Resource(name = "customerFeedBackReviewService")
    private CustomerFeedBackReviewService customerFeedBackReviewService;

    @ResponseBody
    @RequestMapping(method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<CustomerFeedBackReviewData> getAllReviews() {
        LOG.info("retrieving customer feedback reviews");
        return getCustomerFeedBackReviewService().getAllReviews();
    }

    @ResponseBody
    @RequestMapping(value = "/{customerId}",method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<CustomerFeedBackReviewData> getAllReviewsByCustomerId(@PathVariable final String customerId) {
        LOG.info("retrieving customer feedback reviews");
        return getCustomerFeedBackReviewService().getAllReviewsByCustomerId(customerId);
    }


    public CustomerFeedBackReviewService getCustomerFeedBackReviewService() {
        return customerFeedBackReviewService;
    }

    public void setCustomerFeedBackReviewService(CustomerFeedBackReviewService customerFeedBackReviewService) {
        this.customerFeedBackReviewService = customerFeedBackReviewService;
    }
}
