package sk.stopangin.payment.event;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import sk.stopangin.payment.common.Status;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentUpdated implements Event {

  private String id;
  private Status status;

}
