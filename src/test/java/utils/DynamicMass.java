package utils;

import com.github.javafaker.Faker;
import domain.UserDmn;

import java.util.Random;

public class DynamicMass {

    /**
     * Returns a random email.
     *
     * @return
     */

    public static String randomEmail() {
        String emailInt = "testName";
        String emailFinal = "@gmail.com";
        Random randomEmail = new Random();

        int min = 100000;
        int max = 100000000;
        int dynamicNumber = randomEmail.nextInt(max - min) + min;
        return emailInt + dynamicNumber + emailFinal;
    }

    /**
     * Returns a random password.
     *
     * @return
     */

    public static String randomPassword() {
        Random randomPasswd = new Random();
        int min = 10000000;
        int max = 90000000;
        String dynamicNumber = String.valueOf(randomPasswd.nextInt(max - min) + min);

        return dynamicNumber;
    }

    /**
     * Returns a random name.
     *
     * @return
     */

    public static String randomName() {
        String[] name = {"Pedro", "Gustavo", "João", "Fernando", "Lucas", "Daniel", "Maria", "Rosa", "Bruno", "Luana", "Miguel", "Jose", "Hugo", "Claudia"};

        int min = 0;
        int max = (name.length) - 1;
        Random randomName = new Random();

        int position = randomName.nextInt(max - min) + min;
        return name[position];
    }

    /**
     * Returns a random last name.
     *
     * @return
     */


    public static String randomLastName() {
        String[] name = {"Santos", "Gomes", "Ferreira", "Silva", "Oliveira", "Coltinho", "Correia"};

        int min = 0;
        int max = (name.length) - 1;
        Random randomName = new Random();

        int position = randomName.nextInt(max - min) + min;
        return name[position];
    }

    /**
     * Returns a random name company.
     *
     * @return
     */

    public static String randomNameCompany() {
        String[] name = {"Next", "Test Software", "Test Machine", "Testsmart", "Testsmart", "Never"};

        int min = 0;
        int max = (name.length) - 1;
        Random randomName = new Random();

        int position = randomName.nextInt(max - min) + min;
        return name[position];
    }

    /**
     * Return an object randomic from new user.
     *
     * @return Object
     */

    public static UserDmn generateRandomUser() {
        UserDmn user = new UserDmn();
        Faker faker = new Faker();

        user.setFirstName(randomName());
        user.setLastName(randomLastName());
        user.setCompany(randomNameCompany());
        user.setEmail(randomEmail());

        user.setCountry(String.valueOf(faker.country()));
        user.setZip(String.valueOf(faker.code()));
        user.setAddress(String.valueOf(faker.address()));
        user.setAdditionalNotes(String.valueOf(faker.music()));
        return user;
    }
}