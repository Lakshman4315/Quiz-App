package com.example.task4;

import java.util.HashMap;
import java.util.Map;

public class Utils {

    public static Map<String, Map<String,Boolean>> getScienceQuestions(){
        HashMap<String, Map<String,Boolean>> questions = new HashMap<>();

        HashMap<String,Boolean> ans1 = new HashMap<>();
        ans1.put("Dog",false);
        ans1.put("Cat",false);
        ans1.put("Duck",true);
        ans1.put("Sheep",false);
        questions.put("1. Which animal lays eggs?",ans1);

        HashMap<String,Boolean> ans2 = new HashMap<>();
        ans1.put("Ox",true);
        ans1.put("Dog",false);
        ans1.put("Sheep",false);
        ans1.put("Monkey",false);
        questions.put("2. A male cow is called?",ans2);

        HashMap<String,Boolean> ans3 = new HashMap<>();
        ans1.put("House",false);
        ans1.put("Water",true);
        ans1.put("Chocolate",false);
        ans1.put("Fruits",false);
        questions.put("3. All animals need food, air, and ____ to survive.",ans3);

        HashMap<String,Boolean> ans4 = new HashMap<>();
        ans1.put("Hen",false);
        ans1.put("Crocodile",false);
        ans1.put("Tortoise",false);
        ans1.put("Cat",true);
        questions.put("4. Which one is a fur-bearing animal?",ans4);

        HashMap<String,Boolean> ans5 = new HashMap<>();
        ans1.put("Sun",false);
        ans1.put("Mars",false);
        ans1.put("Venus",false);
        ans1.put("Moon",true);
        questions.put("5. What is Earth’s only natural satellite?",ans5);

        HashMap<String,Boolean> ans6 = new HashMap<>();
        ans1.put("Hair",false);
        ans1.put("Root",false);
        ans1.put("Leaves",true);
        ans1.put("Trunk",false);
        questions.put("6. The tree has a branch filled with green _____.",ans1);

        HashMap<String,Boolean> ans7 = new HashMap<>();
        ans1.put("Eyes",false);
        ans1.put("Lungs",false);
        ans1.put("Pancreas",false);
        ans1.put("Muscles",true);
        questions.put("7. What part of the body helps you move?",ans7);

        HashMap<String,Boolean> ans8 = new HashMap<>();
        ans1.put("Eyelids",false);
        ans1.put("Nostrils",true);
        ans1.put("Nails",false);
        ans1.put("Hair",false);
        questions.put("8. The two holes of the nose are called?",ans8);

        HashMap<String,Boolean> ans9 = new HashMap<>();
        ans1.put("Moon",false);
        ans1.put("Venus",false);
        ans1.put("Mars",false);
        ans1.put("Sun",true);
        questions.put("9. What star shines in the day and provides light?",ans9);

        HashMap<String,Boolean> ans10 = new HashMap<>();
        ans1.put("Ankles",false);
        ans1.put("Pelvis",false);
        ans1.put("Hands",true);
        ans1.put("Skull",false);
        questions.put("10. Legs have feet and arms have ___.",ans10);

        return questions;

    }

}
