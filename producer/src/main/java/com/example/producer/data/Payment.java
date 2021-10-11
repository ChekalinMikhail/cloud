package com.example.producer.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Payment implements Payload {
  private long senderId;
  private String sendersCardNumber;
  private long amount;
  private String receiversCardNumber;
  private String comment;
}
