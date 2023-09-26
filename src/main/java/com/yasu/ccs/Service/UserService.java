package com.yasu.ccs.Service;

import com.yasu.ccs.DTO.CcsUserDto;
import com.yasu.ccs.Domain.Entity.CcsUserEntity;
import com.yasu.ccs.Domain.Repository.CcsUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


import java.util.Objects;

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
            System.out.println(userEntity.getPw() + " " + findEntity.getPw());
            if (Objects.equals(userEntity.getId(), findEntity.getId()) && passwordEncoder.matches(userEntity.getPw(), findEntity.getPw()))
                findDto = findEntity.toDto();
            else {
                return CcsUserDto.builder().name("PW_NOT_MATCHES").build();
            }
        } catch (Exception e) {
            System.out.println("유저 정보 없음");
            return null;
        }
        return findDto;
    }

    public boolean signIn(CcsUserDto userDto) {
        boolean flag = false;
        try {
            userDto.setPw(passwordEncoder.encode(userDto.getPw()));
            userEntity = userDto.toEntity();
            userRepository.save(userEntity);
            flag = true;
        } catch (Exception e) {
            System.out.println("회원 가입 오류");
        }
        return flag;
    }
}
