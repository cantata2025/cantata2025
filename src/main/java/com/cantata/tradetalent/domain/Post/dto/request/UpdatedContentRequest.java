package com.cantata.tradetalent.domain.Post.dto.request;
import lombok.*;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Builder
public class UpdatedContentRequest {
    private int id;
    private String newContent;
}
