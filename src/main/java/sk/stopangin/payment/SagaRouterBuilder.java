package sk.stopangin.payment;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.SagaPropagation;
import org.springframework.stereotype.Component;
import sk.stopangin.payment.command.PaymentCommandHandler;

@Slf4j
@Component
@RequiredArgsConstructor
public class SagaRouterBuilder extends RouteBuilder {

  private final PaymentCommandHandler paymentCommandHandler;

  @Override
  public void configure() throws Exception {
    restConfiguration().port(8183).host("localhost");

    from("kafka:order")
        .saga()
        .propagation(SagaPropagation.REQUIRED)
        .bean(paymentCommandHandler,
            "handleOrder")
        .to("kafka:paymentUpdates");//todo kafkaCommandHandler#publish ChargeCreditCard (command)

    from("direct:orderCancel")
        .transform(header("orderId"))
        .bean(paymentCommandHandler, "handleUpdate") //todo transform na UpdateCommand
        .log("Credit for Custom Id ${body} refunded");

  }

}

