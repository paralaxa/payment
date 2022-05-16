package sk.stopangin.payment.event;

import lombok.Data;

@Data
public class AccountUpdated implements Event {

  private String id;

}
