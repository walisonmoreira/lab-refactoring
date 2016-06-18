package lab.refactoring.web.jersey;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class GlobalExceptionMapper implements ExceptionMapper<Exception> {

  @Override
  public Response toResponse(Exception e) {
    String msg = buildExceptionMessage(e);
    return Response.serverError().entity(msg).build();
  }

  private String buildExceptionMessage(Throwable exception) {
    Throwable causeException = exception.getCause();
    Throwable targetException = causeException == null ? exception : causeException;
    String msg = targetException.getClass().getSimpleName();
    String exceptionMessage = targetException.getMessage();
    msg = msg + (exceptionMessage == null ? "" : ": " + exceptionMessage);
    return msg;
  }
}