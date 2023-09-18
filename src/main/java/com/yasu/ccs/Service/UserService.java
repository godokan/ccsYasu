package com.yasu.ccs.Service;

import com.yasu.ccs.DTO.CcsUserDto;
import com.yasu.ccs.Domain.Entity.CcsUserEntity;
import com.yasu.ccs.Domain.Repository.CcsUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.Objects;

@Service
public class UserService {

    @Autowired
    CcsUserRepository userRepository;

    CcsUserEntity userEntity;

    public boolean login(CcsUserDto userDto) {
        boolean flag = false;
        try {
            userEntity = userDto.toEntity();
            CcsUserEntity findEntity = userRepository.findCcsUserEntityByIdAndPw(userEntity.getId(), userEntity.getPw());
            if (Objects.equals(userEntity.getId(), findEntity.getId()) && Objects.equals(userEntity.getPw(), findEntity.getPw()))
                flag = true;
        } catch (NullPointerException e) {
            return false;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }

    public boolean signIn(CcsUserDto userDto) {
        boolean flag = false;
        try {
            userEntity = userDto.toEntity();
            userRepository.save(userEntity);
            flag = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }
}
