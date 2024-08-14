package com.example.firstproject.controller;


import com.example.firstproject.dto.Member2Dto;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/put-api")
public class PutController {

    @PutMapping(value = "/member")
    public String postMember(@RequestBody Map<String, Object> putData){
        StringBuilder sb = new StringBuilder();
        putData.entrySet().forEach(map ->{
            sb.append(map.getKey()+" : "+ map.getValue()+"\n");
        });
        return sb.toString();
    }


    //Dto객체 활용하여 구현하기

    // String 형식
    @PutMapping(value = "/member1")
    public String postMemberDto1(@RequestBody Member2Dto memberDto){
        return memberDto.toString();
    }


    //JSON 형식
    @PutMapping(value = "/member2")
    public Member2Dto postMemberDto2(@RequestBody Member2Dto memberDto){
        return memberDto;
    }
}
