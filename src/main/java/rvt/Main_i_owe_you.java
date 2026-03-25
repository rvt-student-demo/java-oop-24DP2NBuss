package rvt;

import java.util.*;

public class Main_i_owe_you {
    public static void main(String[] args) {
        I_owe_you mattsIOU = new I_owe_you(); // izveidojam parādu sarakstu

        mattsIOU.setSum("Arthur", 51.5); // ieliekam summu, ko esam parādā Arthur
        mattsIOU.setSum("Michael", 30); // ieliekam summu, ko esam parādā Michael

        System.out.println(mattsIOU.howMuchDoIOweTo("Arthur")); // izdrukā parādu Arthur
        System.out.println(mattsIOU.howMuchDoIOweTo("Michael")); // izdrukā parādu Michael

        mattsIOU.setSum("Arthur", 10.5); // atjaunojam Arthur parāda summu
        System.out.println(mattsIOU.howMuchDoIOweTo("Arthur")); // izdrukā jauno Arthur summu

        System.out.println(mattsIOU.howMuchDoIOweTo("John")); // ja cilvēka nav, izdrukā 0.0
    }
}