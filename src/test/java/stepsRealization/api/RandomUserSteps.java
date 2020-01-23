package stepsRealization.api;

import DTOs.DTORandomUser;
import clients.restClients.RandomUserClient;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


import java.io.*;
import java.util.List;
import java.util.Random;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class RandomUserSteps {
    private RandomUserClient randomUserClient = new RandomUserClient();
    private List<DTORandomUser.Result> resultsList;
    private static Logger log = Logger.getLogger(RandomUserSteps.class.getName());
    private static final String NAME_OF_FILE= "target/generated-sources/usersData.xlsx";

    public void getSetOfUsers(int numberOfUsers) {
        log.info(String.format("Getting %d random users...",numberOfUsers));
        resultsList = randomUserClient.getMultipleUsers(numberOfUsers);
    }

    public int getGenderAmountFromUsersList(String gender) {
        return (int) resultsList.stream()
                                .filter(e -> e.getGender().equalsIgnoreCase(gender))
                                .count();
    }
    public String getNameOfRandomUser(){
        return getRandomUser().getName();
    }

    private DTORandomUser.Result getRandomUser() {
        log.info("Getting one random user...");
        return randomUserClient.getUser();
    }

    public List<String> getUserNames() {
        return resultsList.stream().map(x -> x.getName()).collect(Collectors.toList());
    }

    public void writeUsersIntoFile() throws IOException {
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Users");
        List<String> usersName = getUserNames();

        for (int i = 0; i < usersName.size(); i++) {
            Row row = sheet.createRow(i);
            Cell idCell = row.createCell(0);
            idCell.setCellValue(i+1);

            Cell nameCell = row.createCell(1);
            nameCell.setCellValue(usersName.get(i));
        }

        FileOutputStream out = new FileOutputStream(new File(NAME_OF_FILE));
        workbook.write(out);
        out.close();
    }

    public String readNameOfRandomUserFromFile(int amount) {
        Random random = new Random();
        int i = random.nextInt(100) + 1;
        return readUserNameById(i);
    }

    public String readUserNameById(int id) {
        String name = "";
        try {

            Workbook myExcelBook = WorkbookFactory.create(new FileInputStream(NAME_OF_FILE));
            Sheet myExcelSheet = myExcelBook.getSheet("Users");
            Row row = myExcelSheet.getRow(id);

            if (row.getCell(1).getCellType() == HSSFCell.CELL_TYPE_STRING) {
                name = row.getCell(1).getStringCellValue();
            }
            myExcelBook.close();

        } catch (IOException | InvalidFormatException e) {
            System.out.println("Something went wrong: " + e.getMessage());
        }
        return name;
    }
}
