package lab.refactoring.web.jersey;

import java.text.SimpleDateFormat;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.ext.ContextResolver;
import javax.ws.rs.ext.Provider;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

@Provider
@Produces(MediaType.APPLICATION_JSON)
public class ObjectMapperContextResolver implements ContextResolver<ObjectMapper> {

  private final Logger log = LoggerFactory.getLogger(getClass());

  private final ObjectMapper objectMapper;

  public ObjectMapperContextResolver() {
    log.debug("Configurando o Jackson no Jersey.");
    objectMapper = new ObjectMapper();
    objectMapper.setDateFormat(new SimpleDateFormat("dd/MM/yyyy HH:mm"));
    objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
  }

  @Override
  public ObjectMapper getContext(Class<?> type) {
    return objectMapper;
  }
}