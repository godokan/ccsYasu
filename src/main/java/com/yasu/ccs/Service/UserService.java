package com.yasu.ccs.Service;

import com.yasu.ccs.DTO.CcsUserDto;
import com.yasu.ccs.Domain.Entity.CcsUserEntity;
import com.yasu.ccs.Domain.Repository.CcsUserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


import java.util.Arrays;
import java.util.Objects;

@Slf4j
@Service
public class UserService {

    @Autowired
    CcsUserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    CcsUserEntity userEntity;

    public CcsUserDto login(CcsUserDto userDto) {
        CcsUserDto findDto;
        try {
            userEntity = userDto.toEntity();
            CcsUserEntity findEntity = userRepository.findCcsUserEntityById(userEntity.getId());
            log.info("UserService - login : " + userEntity.getPw() + " / " + findEntity.getPw());
            if (Objects.equals(userEntity.getId(), findEntity.getId()) && passwordEncoder.matches(userEntity.getPw(), findEntity.getPw()))
                findDto = findEntity.toDto();
            else {
                return CcsUserDto.builder().name("PW_NOT_MATCHES").build();
            }
        } catch (Exception e) {
            log.info("유저 정보 없음");
            log.debug(Arrays.toString(e.getStackTrace()));
            return null;
        }
        return findDto;
    }

    public boolean signIn(CcsUserDto userDto) {
        boolean flag = false;
        try {
            userDto.setPw(passwordEncoder.encode(userDto.getPw()));
            log.info("UserService - signIn : "+userDto.getId()+" / "+userDto.getName()+" Password Encrypted. : "+userDto.getPw());
            userEntity = userDto.toEntity();
            userRepository.save(userEntity);
            flag = true;
        } catch (Exception e) {
            log.info("회원 가입 오류");
            log.debug(Arrays.toString(e.getStackTrace()));
        }
        return flag;
    }

    public boolean findId(CcsUserDto id) {
        boolean flag = false;
        userEntity = id.toEntity();
        CcsUserEntity foundId = userRepository.findCcsUserEntityById(userEntity.getId());
        if (foundId!=null) flag = true;
        return flag;
    }
}
