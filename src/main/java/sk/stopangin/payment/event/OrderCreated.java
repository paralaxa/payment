package sk.stopangin.payment.event;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import sk.stopangin.payment.common.OrderedItem;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderCreated implements Event {

  private String id;
  private List<OrderedItem> orderedItems;
}
