package com.klef.jfsd.insemlab;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ClientController {

    /**
     * 1. Greeting message with username as input
     * URL: /greet?username=<name>
     */
    @GetMapping("/greet")
    public String greetUser(@RequestParam(value = "username", defaultValue = "Guest") String username, Model model) {
        model.addAttribute("message", "Hello, " + username + "!");
        return "greet";
    }

    /**
     * 2. Render the "about" page
     * URL: /about
     */
    @GetMapping("/about")
    public String aboutPage() {
        return "about";
    }

    /**
     * 3. Display age and country parameters
     * URL: /demo1?age=<age>&country=<country>
     */
    @GetMapping("/demo1")
    public String demo1(
            @RequestParam(value = "age", defaultValue = "0") int age,
            @RequestParam(value = "country", defaultValue = "Unknown") String country,
            Model model) {
        model.addAttribute("age", age);
        model.addAttribute("country", country);
        return "demo1";
    }

    /**
     * 4. Subtraction and division of two numbers
     * URL: /demo2/<num1>/<num2>
     */
    @GetMapping("/demo2/{num1}/{num2}")
    public String demo2(
            @PathVariable("num1") int num1,
            @PathVariable("num2") int num2,
            Model model) {
        int subtraction = num1 - num2;
        String divisionResult;

        // Avoid division by zero
        if (num2 != 0) {
            divisionResult = String.valueOf(num1 / num2);
        } else {
            divisionResult = "Undefined (division by zero)";
        }

        model.addAttribute("subtraction", subtraction);
        model.addAttribute("division", divisionResult);
        return "demo2";
    }

    /**
     * 5. Display the product form
     * URL: /productform
     */
    @GetMapping("/productform")
    public String showProductForm() {
        return "productform";
    }

    /**
     * 6. Multiply two numbers and display the result
     * URL: /multiplyNumbers?num1=<value>&num2=<value>
     */
    @GetMapping("/multiplyNumbers")
    public String multiplyNumbers(
            @RequestParam("num1") int num1,
            @RequestParam("num2") int num2,
            Model model) {
        int result = num1 * num2;
        model.addAttribute("result", result);
        return "multiplyNumbers";
    }

    /**
     * 7. Reverse two strings
     * URL: /reverse?str1=<string1>&str2=<string2>
     */
    @GetMapping("/reverse")
    public String reverseStrings(
            @RequestParam("str1") String str1,
            @RequestParam("str2") String str2,
            Model model) {
        String reversedStr1 = new StringBuilder(str1).reverse().toString();
        String reversedStr2 = new StringBuilder(str2).reverse().toString();

        model.addAttribute("reversedStr1", reversedStr1);
        model.addAttribute("reversedStr2", reversedStr2);
        return "reverse";
    }

    /**
     * 8. Perform addition and subtraction of two values
     * URL: /calculate?num1=<value>&num2=<value>
     */
    @GetMapping("/calculate")
    public String calculate(
            @RequestParam("num1") int num1,
            @RequestParam("num2") int num2,
            Model model) {
        int subtraction = num1 - num2;
        int addition = num1 + num2;

        model.addAttribute("subtraction", subtraction);
        model.addAttribute("addition", addition);
        return "calculate";
    }
}
