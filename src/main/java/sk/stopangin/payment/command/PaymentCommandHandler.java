package sk.stopangin.payment.command;

import sk.stopangin.payment.event.OrderCreated;
import sk.stopangin.payment.event.PaymentUpdated;

public interface PaymentCommandHandler {

  void handle(CreateAccount createAccount);

  void handleUpdate(WithdrawFromAccount withdrawFromAccount);

  PaymentUpdated handleOrder(OrderCreated orderCreated);

}
