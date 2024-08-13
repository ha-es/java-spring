package com.example.firstproject.controller;


import com.example.firstproject.api.MemberDto;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/get-api")
public class GetController {

//    @RequestMapping(value = "/hello", method = RequestMethod.GET)
//    public String getHello(){
//        return "hello world!";
//    }

    //매개변수 없는 GET ->거의안쓰임
//    @GetMapping(value = "/name")
//    public String getName(){
//        return "eunseo";
//    }

    //@PathVariable 활용
    //{variable}안에 변수 넣기
    @GetMapping(value = "/variable1/{variable}")
    public String getVariable1(@PathVariable String variable){
        return variable;
    }

    //@RequestParam 쿼리 형식으로 전달
    @GetMapping(value ="/request1")
    public String getRequestParam1(
            @RequestParam String name,
            @RequestParam String email,
            @RequestParam int age
    ){
        return name+" "+email+" "+age;
    }

    //만약 쿼리스트링에 어떤 값이 들어올지 모른다면? -> Map객체 활용
    // 예) 회원가입 api에서 id,pwd같은 필수 항목이 아니라
    // 취미와 같은 선택항목에 대해서 값을 기입하지 않는 경우
    // 즉, 매개변수의 항목이 일정하지 않는 경우! Map객체로 받는게 유용하다.
    @GetMapping("/request2")
    public String getRequestParam2(@RequestParam Map<String, String> param){
        StringBuilder sb = new StringBuilder();

        param.entrySet().forEach(map -> {
            sb.append(map.getKey() + " : "+map.getValue()+"\n");
        });

        return sb.toString();
    }


    //MemberDto 에서 받아 온 값 호출하기
    @GetMapping(value = "/request3")
    public String getRequestParam3(MemberDto memberDto){
        return memberDto.toString();
    }
}
