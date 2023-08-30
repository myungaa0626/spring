package com.javassem.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.javassem.domain.SampleVO;


@RestController
public class SampleController {

   // 1. 문자열 반환
   @GetMapping(value = "/getText", produces = "text/plain;charset=utf-8")
   @ResponseBody
   public String getTest() {
      return "컨트롤러에서 보냄";
   }
   
   // 2. 객체 반환
   @GetMapping(value = "/getObject")
   public SampleVO getObject(Model model) {
      SampleVO vo = new SampleVO("김연아", 33, "레스트 테스트");
      model.addAttribute("vo",vo);
      return vo;
   }
   
   // 3. 리스트 객체 반환
      @GetMapping(value = "/getList")
      public List<SampleVO> getList() {
         List list = new ArrayList();
         list.add(new SampleVO("김연아", 33, "레스트 테스트"));
         list.add(new SampleVO("박태환", 22, "수영선수"));
         list.add(new SampleVO("세종대왕", 77, "한글창제"));
         return list;
      }
   
      // 4. URL에서 정보 얻기     /sample/{cate}/{no}
      @GetMapping(value = "sample/{cate}/{cno}")
      public String[] getPath(@PathVariable String cate, @PathVariable Integer cno) {
         return new String[] {"카테고리 : "+cate, "번호 : "+cno};
      }
      
      @GetMapping(path = "query-param")  //@GetMapping("/query-param") 이랑 같음
      public String queryParam(@RequestParam String name, @RequestParam String age, @RequestParam String message) {
         System.out.println(name);
         System.out.println(age);
         System.out.println(message);
         return name+", "+age+", "+message;
      }
      
      @GetMapping(path = "query-param2")
      public String queryParam2(SampleVO dto) {   // 객체 타입으로 리턴할때는 @RequestParam 안씀.    권장방식
         System.out.println(dto);
         System.out.println(dto.getName());
         System.out.println(dto.getAge());
         System.out.println(dto.getMessage());
         return dto.toString();
      }
      
      
      
      // 5. POST 전송
      @PostMapping("/sample/data")
      public SampleVO post(@RequestBody SampleVO vo) {   //요청이 body에 숨겨져서 옴 (post 방식)
         System.out.println(vo);
         System.out.println("[확인]");
         return vo;
      }
      
      
      @PostMapping("/post")
      public void postSample(@RequestBody Map<String, Object> vo) {    // return 타입이 아니여서 보여지지 않음
//         vo.entrySet().forEach(objEntry->{
//            System.out.println("key: "+objEntry.getKey());
//            System.out.println("value: "+objEntry.getValue());
//         });
         
         vo.forEach((key, value)->{
            System.out.println("key: "+ key );
            System.out.println("value: "+ value );
         });
         
      }
      
      
      
      //////////////////////////////////////////////////////////////////////////////////////////////////////
      @DeleteMapping(path = "/sample/delete/{name}")
      public void delete(@PathVariable String name) {
         System.out.println(name);
      }
      
      
      @PutMapping("/sample/put/{name}")
      public SampleVO put(@RequestBody SampleVO dto, @PathVariable String name) {
         
         System.out.println(name);
         System.out.println(dto);
         return dto;
      }
      
}