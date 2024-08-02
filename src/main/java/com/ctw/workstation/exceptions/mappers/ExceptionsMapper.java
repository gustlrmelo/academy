/*
package com.ctw.workstation.exceptions.mappers;

import io.quarkus.logging.Log;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

@Provider
public class ExceptionsMapper implements ExceptionMapper<Throwable> {

    @Override
    public Response toResponse(Throwable throwable) {
        return Response.status(500, "Internal Server Error").entity("Internal Server Error").build();
    }
}
*/