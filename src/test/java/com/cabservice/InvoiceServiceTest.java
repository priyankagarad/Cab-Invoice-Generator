package com.cabservice;
import com.bl.cabservice.InvoiceService;
import com.bl.cabservice.InvoiceSummery;
import com.bl.cabservice.Ride;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
public class InvoiceServiceTest{
    InvoiceService invoiceService;

    @Before
    public void setUp() {
        invoiceService = new InvoiceService();
    }

    @Test
    public void givenDistanceAndTime_shouldReturnTotalFare() {
        double distance = 2.0;
        int time = 5;
        double fare = invoiceService.calculateFare(distance, time);
        Assert.assertEquals(25, fare, 0.0);
    }

    @Test
    public void givenDistanceAndTime_shouldReturnMinimumFare() {
        double distance = 0.3;
        int time = 1;
        double fare = invoiceService.calculateFare(distance, time);
        Assert.assertEquals(5, fare, 0.0);
    }

    @Test
    public void givenMultipleRides_shouldReturnInvoiceSummary() {
        Ride[] rides = {
                new Ride(2.0, 5),
                new Ride(0.1, 1)};
        InvoiceSummery summery = invoiceService.multipleRide(rides);
        InvoiceSummery expectedInvoiceSummary = new InvoiceSummery(2, 30.0);
        Assert.assertEquals(expectedInvoiceSummary, summery);
    }
    @Test
    public void givenUserIdAndRides_shouldReturnInvoiceSummary() {
        String userId = "asd";
        Ride[] rides = { new Ride(2.0, 5),
                new Ride(0.1, 1)};
        invoiceService.addRides(userId, rides);
        InvoiceSummery summary = invoiceService.getInvoiceSummary(userId);
        InvoiceSummery expectedInvoiceSummary = new InvoiceSummery(2, 30.0);
        Assert.assertEquals(expectedInvoiceSummary, summary);
    }
}