package com.examplel.servletandjspusingspringboot;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class ServletController {

  @RequestMapping("/test")
  public String test() {
    return "Controller is working!";
  }

  @RequestMapping("/")
  public String home() {
    return "index";
  }

  @RequestMapping("/add")
  public ModelAndView addTwoNumbers(/** @RequestParam("num1")  optional when we define different name */
  int num1, int num2, ModelAndView mv) {

    int result = num1 + num2;
    mv.addObject("result", result);
    mv.setViewName("result");

    return mv;
  }

  // using model
  // public String addTwoNumbers(int num1, int num2, Model model) {

  // int result = num1 + num2;
  // model.addAttribute("result", result);

  // return "result";
  // }

  // useing the request
  // public String add(
  // @RequestParam int num1,
  // @RequestParam int num2,
  // HttpServletRequest request) {

  // int result = num1 + num2;

  // request.setAttribute("result", result);

  // return "result";
  // }

  // using the session
  // public String add(
  // @RequestParam int num1,
  // @RequestParam int num2,
  // HttpSession session) {

  // int result = num1 + num2;

  // session.setAttribute("result", result);

  // return "result";
  // }


  @RequestMapping("/add-alien")
  public String addAlien() {
      return "alien";
  }

  @RequestMapping("/view-alien")
  public String viewAlienResult(@ModelAttribute ("alien1") /** optional if you need to cuse different names */ Alien alien)
  {
    return "result-alien";
  }

  @ModelAttribute ("language")
  public String LanguageName()
  {
    return "Java";
  }
}
