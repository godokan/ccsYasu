package com.yasu.ccs.DTO;

import com.yasu.ccs.Domain.Entity.BoardFreeEntity;
import com.yasu.ccs.Domain.Entity.BoardNoticeEntity;
import com.yasu.ccs.Domain.Entity.CcsUserEntity;
import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

@Data
public class BoardDto {
    @NonNull
    private Integer no;
    private Integer studNum;
    private String context;

    @Builder
    public BoardDto(@NonNull Integer no, Integer studNum, String context) {
        this.no = no;
        this.studNum = studNum;
        this.context = context;
    }

    public BoardFreeEntity toBoardFreeEntity() {
        return BoardFreeEntity.builder()
                .no(no)
                .studNum(CcsUserEntity.builder().studNum(this.studNum).build())
                .context(context)
                .build();
    }

    public BoardNoticeEntity toBoardNoticeEntity() {
        return BoardNoticeEntity.builder()
                .no(no)
                .studNum(CcsUserEntity.builder().studNum(this.studNum).build())
                .context(context)
                .build();
    }
}
