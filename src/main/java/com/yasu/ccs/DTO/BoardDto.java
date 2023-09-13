package com.yasu.ccs.DTO;

import com.yasu.ccs.Domain.Entity.BoardFreeEntity;
import com.yasu.ccs.Domain.Entity.BoardNoticeEntity;
import com.yasu.ccs.Domain.Entity.CcsUserEntity;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NonNull;

@Data
public class BoardDto {
    @NonNull
    private Integer no;
    private Integer stud_num;
    private String context;

    @Builder
    public BoardDto(@NonNull Integer no, Integer stud_num, String context) {
        this.no = no;
        this.stud_num = stud_num;
        this.context = context;
    }

    public BoardFreeEntity toBoardFreeEntity() {
        return BoardFreeEntity.builder()
                .no(no)
                .studNum(CcsUserEntity.builder().studNum(this.stud_num).build())
                .context(context)
                .build();
    }

    public BoardNoticeEntity toBoardNoticeEntity() {
        return BoardNoticeEntity.builder()
                .no(no)
                .studNum(CcsUserEntity.builder().studNum(this.stud_num).build())
                .context(context)
                .build();
    }
}
