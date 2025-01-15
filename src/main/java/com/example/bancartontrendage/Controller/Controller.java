package com.example.bancartontrendage.Controller;

import com.example.bancartontrendage.Dto.MemeDto;
import com.example.bancartontrendage.Dto.MemeQuestionDto;
import com.example.bancartontrendage.Service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@org.springframework.stereotype.Controller
@RequestMapping("/admin")
public class Controller {
    @Autowired
    private Service service;

    @GetMapping("/inputMemes")
    public String adminPage() {
        return "admin";
    }

    @PostMapping("/createMeme")
    public String createMemeAdmin(@RequestParam("question") String question,
                                  @RequestParam("choice1") String choice1,
                                  @RequestParam("choice2") String choice2,
                                  @RequestParam("choice3") String choice3,
                                  @RequestParam("year") String year,
                                  @RequestParam(value = "answer", required = false) String[] answers) {
        MemeDto memeDto = new MemeDto();
        MemeQuestionDto memeQuestionDto1 = new MemeQuestionDto();
        MemeQuestionDto memeQuestionDto2 = new MemeQuestionDto();
        MemeQuestionDto memeQuestionDto3 = new MemeQuestionDto();


            Long answer = Long.parseLong(String.join(", ", answers)); //체크박스 오류 체크
            memeDto.setAnswer(answer);
            memeDto.setContent("admin");
            memeDto.setExplanation(question);
            memeDto.setQuestion(question);
            memeDto.setYear(Long.parseLong(year));

            memeQuestionDto1.setChoice(choice1);
            memeQuestionDto2.setChoice(choice2);
            memeQuestionDto3.setChoice(choice3);

            service.createMemeAdmin(memeDto, memeQuestionDto1, memeQuestionDto2, memeQuestionDto3);





        return "admin";
    }

}
