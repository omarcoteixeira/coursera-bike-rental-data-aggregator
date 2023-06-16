package br.com.omarcoteixeira.apps.bikerental.cronserver.data.mixin;

import br.com.omarcoteixeira.apps.bikerental.cronserver.data.dto.NetworkDto;
import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.io.IOException;
import java.util.stream.StreamSupport;

public class BikeNetworkDeserializer extends JsonDeserializer<NetworkDto> {

  @Override
  public NetworkDto deserialize(
      JsonParser jsonParser, DeserializationContext deserializationContext)
      throws IOException, JacksonException {

    ObjectMapper objectMapper = (ObjectMapper) jsonParser.getCodec();
    ObjectNode objectNode = objectMapper.readTree(jsonParser);

    NetworkDto result =
        NetworkDto.builder()
            .id(objectNode.get("id").asText())
            .name(objectNode.get("name").asText())
            .href(objectNode.get("href").asText())
            .build();

    if (!objectNode.get("company").isNull()) {
      if (objectNode.get("company").isArray()) {
        var items =
            StreamSupport.stream(objectNode.withArray("company").spliterator(), true)
                .map(JsonNode::asText)
                .toList();

        result.setCompanies(items);
      } else {
        result.getCompanies().add(objectNode.get("company").textValue());
      }
    }
    return result;
  }
}
