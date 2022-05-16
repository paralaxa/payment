package sk.stopangin.payment.event;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME)
@JsonSubTypes({
    @JsonSubTypes.Type(value = OrderCreated.class, name = "OrderCreated"),
    @JsonSubTypes.Type(value = AccountCreated.class, name = "AccountCreated"),
    @JsonSubTypes.Type(value = AccountUpdated.class, name = "AccountUpdated")})
public interface Event {

  String getId();
}
