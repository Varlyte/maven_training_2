package fr.lernejo.tester;

import fr.lernejo.tester.internal.TestClassDescription;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class TestClassDescriptionLernejoTests {
    final static TestClassDescription testVar = new TestClassDescription(SomeLernejoTests.class);

    public static void main(String[] args){
        TestClassDescriptionLernejoTests testMain = new TestClassDescriptionLernejoTests();
        testMain.testFx();
    }

    @Test
    static void testFx(){
        String expected1 = "public void fr.lernejo.tester.SomeLernejoTests.ok()";
        String expected2 = "public void fr.lernejo.tester.SomeLernejoTests.ko()";

        List<Method> listOfMethodTest = new ArrayList<Method>();
        listOfMethodTest = testVar.listTestMethods();
        Assertions.assertThat(listOfMethodTest.get(0).toString().equals(expected1));
        Assertions.assertThat(listOfMethodTest.get(1).toString().equals(expected2));
    }
}
