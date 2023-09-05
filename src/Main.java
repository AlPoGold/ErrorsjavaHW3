import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main {
    final static int n = 6;
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        boolean repeat = true;
        String lastName;
        String name;
        String patronymic;
        Date birthDate;
        long phoneNumber;
        Gender gender;
        while(repeat) {
            System.out.println("Please, enter data: last name, name, patronymic, birth date(in format dd.mm.yyyy), " +
                    "phone number (only numbers without any signs) and gender(m or f) with space between: ");
            String answer = scan.nextLine();


            String[] data = answer.split(" ");
            try {
                if (data.length != n) {
                    if (data.length < n) {
                        throw new DataLengthException("You should enter more parameters!");
                    } else throw new DataLengthException("You should enter less parameters!");
                }

                lastName = data[0];
                String lastNameVar = "last name";
                name = data[1];
                String nameVar = "name";
                patronymic = data[2];
                String patronymicVar = "patronymic name";
                if (!isAlpha(lastName)) {
                    throw new WrongLNPException(lastNameVar);
                } else if (!isAlpha(nameVar)) {
                    throw new WrongLNPException(name);
                } else if (!isAlpha(patronymic)) {
                    throw new WrongLNPException(patronymicVar);
                }

                String dateBirthString = data[3];
                SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");
                try {
                    birthDate = format.parse(dateBirthString);
                } catch (ParseException e) {
                    throw new WrongBirthDateException();
                }

                String phoneNumberString = data[4];
                try {
                    phoneNumber = Long.parseLong(phoneNumberString);
                } catch (NumberFormatException e) {
                    throw new WrongPhoneNumberException();
                }

                String genderString = data[5];
                if (!(genderString.equals(Gender.m.value) | genderString.equals(Gender.f.value))) {
                    throw new WrongGenderException();
                }else gender = Gender.fromString(genderString);

                makeFiles(lastName, name, patronymic, birthDate, phoneNumber, gender);
                repeat = false;


            }catch(DataLengthException| WrongLNPException | WrongBirthDateException | WrongPhoneNumberException | WrongGenderException e){
                System.out.println(e.getMessage());

            }
        }
    }


    public static boolean isAlpha(String name) {
        return name.matches("^[a-zA-Zа-яА-Я]*$");
    }

    public static void makeFiles(String lastName, String name, String patronymic, Date birthDate, long phoneNumber, Gender gender){
        String filePath = "files\\" + lastName.toLowerCase() + ".txt";
        File file = new File(filePath);
        Format format = new SimpleDateFormat("dd.MM.yyyy");
        StringBuilder sb = new StringBuilder();
        sb.append(lastName);
        sb.append(" ");
        sb.append(name);
        sb.append(" ");
        sb.append(patronymic);
        sb.append(" ");
        sb.append(format.format(birthDate));
        sb.append(" ");
        sb.append(phoneNumber);
        sb.append(" ");
        sb.append(gender.toString());

        try (FileWriter fileWriter = new FileWriter(file, true)){
            if (file.length() > 0){
                fileWriter.write('\n');
            }
            fileWriter.write(String.valueOf(sb));
        }catch (IOException e){
            e.printStackTrace();
            throw new WorkFileException();
        }

    }



}
