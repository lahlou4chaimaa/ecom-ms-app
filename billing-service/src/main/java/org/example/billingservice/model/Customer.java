
package org.example.billingservice.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Customer {
    private String id;
    private String name;
    private String email;
}
