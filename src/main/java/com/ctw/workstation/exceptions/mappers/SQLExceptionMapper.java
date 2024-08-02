package com.ctw.workstation.exceptions.mappers;

import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;
import org.hibernate.engine.jdbc.spi.SqlExceptionHelper;

import java.sql.SQLException;

@Provider
public class SQLExceptionMapper implements ExceptionMapper<SQLException> {

    @Override
    public Response toResponse(SQLException throwables) {
        return Response.status(400).entity("Cringe, muda cena").build();
    }
}
