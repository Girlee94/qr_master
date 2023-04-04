package com.qrmaster.api.board.entity.mongo;

import com.qrmaster.api.board.enums.DeleteFlag;
import com.qrmaster.api.board.enums.converter.DeleteFlagConverter;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Convert;
import java.time.LocalDateTime;

@Data
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document(collection = "board")
public class Board {

    @Id
    private String          _id;

    private long            user_idx;
    private String          title;
    @Convert(converter = DeleteFlagConverter.class)
    private String          content;
    private DeleteFlag      delete_flag;
    private LocalDateTime   register_date;
    private LocalDateTime   update_date;

}
