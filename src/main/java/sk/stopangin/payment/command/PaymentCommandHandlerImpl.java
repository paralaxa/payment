package sk.stopangin.payment.command;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sk.stopangin.payment.common.Status;
import sk.stopangin.payment.event.EventPublisher;
import sk.stopangin.payment.event.OrderCreated;
import sk.stopangin.payment.event.PaymentUpdated;

@Service
@RequiredArgsConstructor
public class PaymentCommandHandlerImpl implements
    PaymentCommandHandler {

  private final EventPublisher eventPublisher;

  @Override
  public void handle(CreateAccount createAccount) {

  }

  @Override
  public void handleUpdate(WithdrawFromAccount withdrawFromAccount) {

  }

  @Override
  public PaymentUpdated handleOrder(OrderCreated orderCreated) {
    return new PaymentUpdated(orderCreated.getId(), Status.DONE);
  }
}
