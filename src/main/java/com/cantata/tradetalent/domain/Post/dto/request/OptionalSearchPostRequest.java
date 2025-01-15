package com.cantata.tradetalent.domain.Post.dto.request;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Builder
public class OptionalSearchPostRequest {
    private String option;
    private String keyword;
}
