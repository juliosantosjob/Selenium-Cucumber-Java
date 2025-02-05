package utils;

import com.github.javafaker.Faker;
import domain.UserDmn;

import java.util.Random;

public class DynamicMass {

    /**
     * Returns a random email.
     *
     * @return String
     */

    public static String randomEmail() {
        String nameUser = "user";
        String domain = "@gmail.com";
        Random randomEmail = new Random();

        int min = 1000000;
        int max = 1000000000;
        int randomNumber = randomEmail.nextInt(max - min) + min;
        return nameUser + randomNumber + domain;
    }

    /**
     * Returns a random password.
     *
     * @return String
     */

    public static String randomPassword() {
        Random random = new Random();
        int min = 10000000;
        int max = 90000000;

        String randomNumber = String.valueOf(random.nextInt(max - min) + min);
        return "Teste@" + randomNumber;
    }

    /**
     * Returns a random name.
     *
     * @return String
     */

    public static String randomFirstName() {
        String[] name = {"Pedro", "Gustavo", "João", "Fernando", "Lucas", "Daniel", "Maria", "Rosa", "Bruno", "Luana", "Miguel", "Jose", "Hugo", "Claudia"};

        int min = 0;
        int max = (name.length) - 1;
        Random random = new Random();

        int position = random.nextInt(max - min) + min;
        return name[position];
    }

    /**
     * Returns a random last name.
     *
     * @return String
     */


    public static String randomLastName() {
        String[] name = {"Santos", "Gomes", "Ferreira", "Silva", "Oliveira", "Coltinho", "Correia"};

        int min = 0;
        int max = (name.length) - 1;
        Random random = new Random();

        int position = random.nextInt(max - min) + min;
        return name[position];
    }

    /**
     * Returns a random name company.
     *
     * @return String
     */

    public static String randomNameCompany() {
        String[] companyName = {"NextQA", "SoftTest", "MachinaTest", "SmartQA", "TestWise", "EverTest"};

        int min = 0;
        int max = (companyName.length) - 1;
        Random randomName = new Random();

        int position = randomName.nextInt(max - min) + min;
        return companyName[position];
    }

    /**
     * Return an object randomic from new user.
     *
     * @return Object
     */

    public static UserDmn generateRandomUser() {
        UserDmn newUser = new UserDmn();
        Faker faker = new Faker();

        newUser.setFirstName(randomFirstName());
        newUser.setLastName(randomLastName());
        newUser.setCompany(randomNameCompany());
        newUser.setEmail(randomEmail());
        newUser.setCountry(String.valueOf(faker.country()));
        newUser.setZip(String.valueOf(faker.code()));
        newUser.setAddress(String.valueOf(faker.address()));
        newUser.setAdditionalNotes(String.valueOf(faker.music()));

        return newUser;
    }
}