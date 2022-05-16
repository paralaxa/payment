package sk.stopangin.payment.event;

import lombok.Data;

@Data
public class AccountCreated implements Event {

  private String id;
}
