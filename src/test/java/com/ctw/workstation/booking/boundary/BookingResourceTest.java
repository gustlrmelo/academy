package com.ctw.workstation.booking.boundary;

import com.ctw.workstation.booking.entity.BookingRepository;
import com.ctw.workstation.config.DatabaseTestResource;
import io.quarkus.test.InjectMock;
import io.quarkus.test.common.QuarkusTestResource;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@QuarkusTest
@QuarkusTestResource(DatabaseTestResource.class)
//@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class BookingResourceTest {

    @Inject
    BookingResource bookingResource;

   @InjectMock
   BookingRepository bookingRepository;


    @Test
    void doIt(){


    }

}