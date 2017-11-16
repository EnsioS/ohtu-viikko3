package ohtu;

import com.google.gson.Gson;
import java.io.IOException;
import org.apache.http.client.fluent.Request;

public class Main {

    public static void main(String[] args) throws IOException {
        // vaihda oma opiskelijanumerosi seuraavaan, ÄLÄ kuitenkaan laita githubiin omaa opiskelijanumeroasi
        String studentNr = "011120775";
        if (args.length > 0) {
            studentNr = args[0];
        }

        String url = "https://studies.cs.helsinki.fi/ohtustats/students/" + studentNr + "/submissions";

        String bodyText = Request.Get(url).execute().returnContent().asString();

//        System.out.println("json-muotoinen data:");
//        System.out.println(bodyText);
        String url2 = "https://studies.cs.helsinki.fi/ohtustats/courseinfo";

        String bodyText2 = Request.Get(url2).execute().returnContent().asString();
//        System.out.println("json-muotoinen data:");
//        System.out.println(bodyText2);
        Gson mapper = new Gson();

        Kurssi kurssi = mapper.fromJson(bodyText2, Kurssi.class);

        System.out.println("Kurssi: " + kurssi.getName() + ", " + kurssi.getTerm());
        System.out.println("");

        Submission[] subs = mapper.fromJson(bodyText, Submission[].class);

        System.out.println("opiskelijanummero: " + studentNr);
        System.out.println("");

        int exercises = 0;
        int hours = 0;

        for (Submission submission : subs) {
            submission.setKurssi(kurssi);
            exercises += submission.getExercises().size();
            hours += submission.getHuors();
            System.out.println(submission);
        }

        System.out.println("");
        System.out.println("yhteensä: " + exercises + " tehtävää " + hours + " tuntia");

    }
}
