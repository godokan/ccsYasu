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
    private String date;

    @Builder
    public BoardDto(@NonNull Integer no, Integer studNum, String context, String date) {
        this.no = no;
        this.studNum = studNum;
        this.context = context;
        this.date = date;
    }

    public BoardFreeEntity toBoardFreeEntity() {
        return BoardFreeEntity.builder()
                .no(no)
                .studNum(CcsUserEntity.builder().studNum(this.studNum).build())
                .context(context)
                .date(date)
                .build();
    }

    public BoardNoticeEntity toBoardNoticeEntity() {
        return BoardNoticeEntity.builder()
                .no(no)
                .studNum(CcsUserEntity.builder().studNum(this.studNum).build())
                .context(context)
                .date(date)
                .build();
    }

}
