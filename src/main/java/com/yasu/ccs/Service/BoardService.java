package com.yasu.ccs.Service;

import com.yasu.ccs.DTO.ApiListDto;
import com.yasu.ccs.DTO.BoardDto;
import com.yasu.ccs.Domain.Entity.ApiListEntity;
import com.yasu.ccs.Domain.Entity.BoardFreeEntity;
import com.yasu.ccs.Domain.Entity.BoardNoticeEntity;
import com.yasu.ccs.Domain.Entity.CcsUserEntity;
import com.yasu.ccs.Domain.Repository.ApiListRepository;
import com.yasu.ccs.Domain.Repository.BoardFreeRepository;
import com.yasu.ccs.Domain.Repository.BoardNoticeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class BoardService {

    @Autowired
    private BoardFreeRepository freeRepository;
    @Autowired
    private BoardNoticeRepository noticeRepository;
    @Autowired
    private ApiListRepository apiListRepository;

    // 메인화면 출력용 리스트 5개 조회

    public List<BoardDto> getFiveNoticeList() {
        List<BoardNoticeEntity> notices = noticeRepository.findAll();
        List<BoardNoticeEntity> refined = new ArrayList<>();
        List<BoardDto> out = new ArrayList<>();

        if (notices.size() < 5) {
//            refined = notices;
            for (int i = notices.size()-1; i >= 0; --i) {
                System.out.println(i);
                refined.add(notices.get(i));
            }
            for (int i = refined.size(); i < 5; i++) {
                refined.add(BoardNoticeEntity.builder()
                        .no(-1)
                        .studNum(111111111)
                        .context("글이 없습니다.")
                        .date("2023-00-00")
                        .build());
            }
        } else {
            for (int i = notices.size()-1; i > notices.size()-6; --i) {
                refined.add(notices.get(i));
            }
        }

        refined.forEach(entity->out.add(entity.toDto()));
        return out;
    }

    public List<BoardDto> getFiveFreeList() {
        List<BoardFreeEntity> freedom = freeRepository.findAll();
        List<BoardFreeEntity> refined = new ArrayList<>();
        List<BoardDto> out = new ArrayList<>();

        if (freedom.size() < 5) {
            refined = freedom;
            for (int i = freedom.size(); i < 5; i++) {
                refined.add(BoardFreeEntity.builder()
                        .no(-1)
                        .studNum(111111111)
                        .context("글이 없습니다.")
                        .date("2023-00-00")
                        .build());
            }
        } else {
            for (int i = freedom.size()-1; i > freedom.size()-6; --i) {
                refined.add(freedom.get(i));
            }
        }

        refined.forEach(entity->out.add(entity.toDto()));
        return out;
    }

    // 게시판 전체 조회

    public List<BoardDto> getFreeList() {
        List<BoardFreeEntity> entities = freeRepository.findAllByOrderByNoDesc();
        List<BoardDto> dtos = new ArrayList<>();
        entities.forEach(entity -> dtos.add(entity.toDto()));
        return dtos;
    }

    public List<BoardDto> getNoticeList() {
        List<BoardNoticeEntity> entities = noticeRepository.findAllByOrderByNoDesc();
        List<BoardDto> dtos = new ArrayList<>();
        entities.forEach(entity -> dtos.add(entity.toDto()));
        return dtos;
    }

    // 게시판 게시글 상세 조회

    public BoardDto getDetailFree(Integer no) {
        BoardFreeEntity entity = freeRepository.findById(no).orElse(BoardFreeEntity.builder().no(-1).build());
        return entity.toDto();
    }

    public BoardDto getDetailNotice(Integer no) {
        BoardNoticeEntity entity = noticeRepository.findById(no).orElse(BoardNoticeEntity.builder().no(-1).build());
        return entity.toDto();
    }

    // 게시글 작성

    public BoardFreeEntity initFreeBoard(CcsUserEntity userEntity, String context){
        LocalDate localDate = LocalDate.now(ZoneId.of("Asia/Seoul"));

        BoardFreeEntity freeEntity = BoardFreeEntity.builder()
                .studNum(userEntity.getStudNum())
                .context(context)
                .date(localDate.toString())
                .build();
        return freeRepository.save(freeEntity);
    }

    public BoardNoticeEntity initNoticeBoard(CcsUserEntity userEntity, String context){
        LocalDate localDate = LocalDate.now(ZoneId.of("Asia/Seoul"));

        BoardNoticeEntity noticeEntity = BoardNoticeEntity.builder()
                .studNum(userEntity.getStudNum())
                .context(context)
                .date(localDate.toString())
                .build();
        return noticeRepository.save(noticeEntity);
    }
}
