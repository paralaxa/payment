package sk.stopangin.payment.event;

public interface EventPublisher {

  void publish(Event event);

  void publish(String lraId, Event event);
}