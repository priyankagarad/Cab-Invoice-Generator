package com.cabservice;
import com.bl.cabservice.InvoiceGenerator;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
public class InvoiceGeneratorTest {
    InvoiceGenerator invoiceGenerator;
    @Before
    public void setUp()
    {
        invoiceGenerator=new InvoiceGenerator();
    }

    @Test
    public void givenDistanceAndTime_whenInvoiceGenerator_shouldReturnTotalFare()
    {
        invoiceGenerator=new InvoiceGenerator();
        double distance=2.0;
        int time=5;
        double fare=invoiceGenerator.calculateFare(distance,time);
        Assert.assertEquals(25,fare,0.0);
    }

    @Test
    public void givenDistanceAndTime_whenTotalFareLessThanFare_shouldReturnMinimumFare()
    {
        double distance=0.3;
        int time=1;
        double fare=invoiceGenerator.calculateFare(distance,time);
        Assert.assertEquals(5,fare,0.0);
    }
}
