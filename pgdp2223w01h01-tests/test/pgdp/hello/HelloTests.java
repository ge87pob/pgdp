package pgdp.hello;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import de.tum.in.test.api.jupiter.HiddenTest;
import de.tum.in.test.api.jupiter.PublicTest;
import org.junit.jupiter.api.*;

import de.tum.in.test.api.dynamic.Check;
import de.tum.in.test.api.dynamic.DynamicClass;
import de.tum.in.test.api.dynamic.DynamicMethod;
import de.tum.in.test.api.io.IOTester;

@W01H01
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class HelloTests {

    private static final DynamicMethod<?> MAIN = DynamicClass.toDynamic("pgdp.hello.Hello").method(void.class, "main",
            String[].class);
    private static final Object ARG = new String[0];

    private static int hiddenPinguPoints;

    @Order(1)
    @PublicTest
    public void testHelloWorldPublic(IOTester tester) {
        List<String> output = runMain(tester);
        if (output.size() < 1)
            fail("Es wurde nichts ausgegeben");
        if (!containsString("Hello World", output)) {
            fail("Hello World konnte nicht in der Ausgabe gefunden werden. Erste Zeile: " + output.get(0));
        }
        assertEquals("Hello World", output.get(0), "Falscher Text in Zeile 1");
    }

    // hack preventing artemis to hide points given by public test
    @Order(1)
    @HiddenTest
    public void testHelloWorld(IOTester tester) {
        testHelloWorldPublic(tester);
    }

    @Order(2)
    @HiddenTest
    public void countHiddenPinguPoints(IOTester tester) {
        List<String> output = runMain(tester);
        hiddenPinguPoints = countPinguPoints(output, "Pingu");

        String[] possibleWrongPenguString = {"Pengu", "Penguin", "Pinguin", "pengu", "penguin", "pinguin"};
        for (int i = 0; hiddenPinguPoints < 2 && i < possibleWrongPenguString.length; i++) {
            int points = countPinguPoints(output, possibleWrongPenguString[i]);
            hiddenPinguPoints = Math.max(hiddenPinguPoints, points - 1);
        }
    }

    private int countPinguPoints(List<String> output, String penguString) {
        int points = 0;
        if (containsMatchingString(String.format("S..er %s(\\!)", penguString), output) || containsString(String.format("Suesser %s(\\!)", penguString), output)) {
            points++;
        }
        if (containsString(String.format("Süßer %s", penguString), output)) {
            points++;
        }
        if(output.size() == 2 && output.get(1).matches(String.format("S..er %s(!?)", penguString))) {
            points++;
        }
        return points;
    }

    @Order(3)
    @HiddenTest
    public void hiddenPinguPointsOne() {
        assertTrue(hiddenPinguPoints >= 1, """
                Deine Ausgabe von "Süßer Pingu!" erfüllt keine der geforderten Sachen:
                1) Ist in UTF-8 formatiert
                2) Hat das ! am Ende des korrekten Strings
                3) Ist genau in der zweiten Zeile und es gibt nichts danach.
                """);
    }

    @Order(3)
    @HiddenTest
    public void hiddenPinguPointsTwo() {
        assertTrue(hiddenPinguPoints >= 2, """
                Deine Ausgabe von "Süßer Pingu!" erfüllt maximal eine geforderte Sache:
                1) Ist in UTF-8 formatiert
                2) Hat das ! am Ende des korrekten Strings
                3) Ist genau in der zweiten Zeile und es gibt nichts danach.
                """);
    }

    @Order(3)
    @HiddenTest
    public void hiddenPinguPointsThree() {
        assertTrue(hiddenPinguPoints >= 3, """
                Deine Ausgabe von "Süßer Pingu!" erfüllt maximal zwei der geforderten Sachen:
                1) Ist in UTF-8 formatiert
                2) Hat das ! am Ende des korrekten Strings
                3) Ist genau in der zweiten Zeile und es gibt nichts danach.
                """);
    }

    private static List<String> runMain(IOTester tester) {
        MAIN.check(Check.PUBLIC);
        MAIN.invokeStatic(ARG);
        return tester.out().getLinesAsString();
    }


    private static boolean containsString(String text, List<String> lines) {
        return lines.stream().anyMatch(s -> s.contains(text));
    }

    private static boolean containsMatchingString(String regEx, List<String> lines) {
        return lines.stream().anyMatch(s -> s.matches(regEx));
    }
}
