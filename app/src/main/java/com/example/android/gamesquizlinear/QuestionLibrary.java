package com.example.android.gamesquizlinear;

/**
 * Created by Bobeš on 12/15/2017.
 */

public class QuestionLibrary {


    //Database for 2nd part of quiz with RadioBox
    // question No. @quizQestionNumber

    private String quizQuestionNumber[] = {
            "Question No. 1:",
            "Question No. 2:",
            "Question No. 3:",
            "Question No. 4:",
            "Question No. 5:",
            "Question No. 6:",
            "Question No. 7:",
    };

    // Question @quizQuestion,

    private String quizQuestion[] = {
            "First-person shooter video game developed by id Software and published by Apogee Software and FormGen, originally released on May 5, 1992 was:",
            "Real-time strategy video game developed by Westwood Studios and released by Virgin Games in December 1992 was:",
            "Video game franchise created by Jordan Mechner, originally developed and published by Brøderbund was:",
            "Puzzle-platformer video game originally developed by DMA Design and first published by Psygnosis for the Amiga in 1991 was:",
            "Which games series ware developed by the German studio Blue Byte, and were published by either Blue Byte or Ubisoft?",
            "Real-time strategy game (RTS), developed by Blizzard Entertainment and published by Blizzard and Interplay Productions was:",
            "Computer and video game released by Electronic Arts in 1989 for various platforms was:",
    };

    // Options for buttons @quizChoices,
    private String quizChoices[][] = {
            {"Wolfstein 3D", "Doom", "Duke Nukem 3D", "Corridor 7"},
            {"Warcraft 1", "Dune 2", "KKnD", "Master of Orion"},
            {"Tomb Raider", "Turrican", "Prince of Persia", "Assassins' Creed"},
            {"Troddlers", "Lemmings", "PushOver", "Quadrax"},
            {"Civilization", "Jagged Alliance", "The Settlers", "Caesar"},
            {"Warcraft: Orcs & Human", "Dune 2", "Command & Conquer", "Dune 2000"},
            {"Karateka", "Budokan: Martial Spirit", "Double Dragon", "Brutal pawns of Fury"},
    };

    // Picture No. @quizPicture,
    private String quizPicture[] = {
            "q1_picture",
            "q2_picture",
            "q3_picture",
            "q4_picture",
            "q5_picture",
            "q6_picture",
            "q7_picture",
    };

    // Correct answer @quizAnswer
    private String quizAnswer[] = {"Wolfstein 3D", "Dune 2", "Prince of Persia", "Lemmings", "The Settlers", "Warcraft: Orcs & Human", "Budokan: Martial Spirit"};


    private String urlHelp[] = {
            "https://en.wikipedia.org/wiki/Wolfenstein_3D",
            "https://en.wikipedia.org/wiki/Dune_II",
            "https://en.wikipedia.org/wiki/Prince_of_Persia",
            "https://en.wikipedia.org/wiki/Lemmings_(video_game)",
            "https://en.wikipedia.org/wiki/The_Settlers",
            "https://en.wikipedia.org/wiki/Warcraft:_Orcs_%26_Humans",
            "https://en.wikipedia.org/wiki/Budokan:_The_Martial_Spirit",
    };


// methods called from MainActivity for update

    public String getQuizQuestionNumber(int a) {
        String questionNumber = quizQuestionNumber[a];
        return questionNumber;
    }

    public String getQuizQuestionText(int a) {
        String questionText = quizQuestion[a];
        return questionText;
    }

    public String getQuizChoice1(int a) {
        String questionChoice0 = quizChoices[a][0];
        return questionChoice0;
    }

    public String getQuizChoice2(int a) {
        String questionChoice1 = quizChoices[a][1];
        return questionChoice1;
    }

    public String getQuizChoice3(int a) {
        String questionChoice2 = quizChoices[a][2];
        return questionChoice2;
    }

    public String getQuizChoice4(int a) {
        String questionChoice3 = quizChoices[a][3];
        return questionChoice3;
    }

    public String getCorrectAnswer(int a) {
        String answer = quizAnswer[a];
        return answer;
    }

    public String getPicture(int a) {
        String pictureNo = quizPicture[a];
        return pictureNo;
    }

    public String getUrlHelp(int a) {
        String urlLink = urlHelp[a];
        return urlLink;

    }
}