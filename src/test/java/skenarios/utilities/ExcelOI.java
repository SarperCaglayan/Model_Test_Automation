package skenarios.utilities;

import org.apache.poi.ss.usermodel.*;
import org.junit.Test;
import skenarios.pages.ValuationPage;

import java.io.File;
import java.io.IOException;

public class ExcelOI {

    @Test
    public void ReadFromExcel() throws IOException {
        String path= "C:\\Users\\u_arg\\Downloads\\Comparable_import_2.xlsx";
        Workbook workbook= WorkbookFactory.create(new File(path));
        Sheet sheet = workbook.getSheet("Buildings");
        Sheet sheet2= workbook.getSheet("Units");
        Row row0 = sheet.getRow(5);
        Cell country= row0.getCell(0);
        Cell cityXlsx = row0.getCell(1);
        Cell addressCellValue = row0.getCell(2);
        Cell postCodeXlsx= row0.getCell(3);
        System.out.println("postCodeXlsx = " + postCodeXlsx);
        Cell buildYearXlsx = row0.getCell(4);
        Cell buildingTypeXlsx = row0.getCell(5);
        System.out.println("buildingTypeXlsx = " + buildingTypeXlsx);
        Cell buildingIdXlsx = row0.getCell(6);
        Cell groupIdXlsx = row0.getCell(7);
        Cell floorsXlsx = row0.getCell(8);
        Cell ownLotXlsx = row0.getCell(9);

        Row row2= sheet2.getRow(5);
        Cell unitIdXlsx= row2.getCell(1);
        Cell floorAreaXlsx = row2.getCell(2);
        System.out.println("floorAreaXlsx.getNumericCellValue() = " + floorAreaXlsx.getNumericCellValue());
        Cell roomsXlsx = row2.getCell(3);
        System.out.println("roomsXlsx = " + roomsXlsx);
        Cell unitFloorXlsx = row2.getCell(4);
        Cell conditionXlsx = row2.getCell(5);
        System.out.println("conditionXlsx = " + conditionXlsx);
        Cell balconyXlsx = row2.getCell(6);
        System.out.println("balconyXlsx = " + balconyXlsx);
        Cell kitchenXlsx = row2.getCell(7);
        System.out.println("kitchenXlsx = " + kitchenXlsx);
        Cell saunaXlsx = row2.getCell(8);
        Cell maintenanceXlsx = row2.getCell(9);
        System.out.println("maintenanceXlsx = " + maintenanceXlsx);
        double maintenanceXlsxNumericCellValue = maintenanceXlsx.getNumericCellValue();
        System.out.println("saunaXlsx = " + saunaXlsx);
        System.out.println("maintenanceXlsxNumericCellValue = " + maintenanceXlsxNumericCellValue);

        System.out.println("Country Code= " + country.getStringCellValue());
        System.out.println("city = " + cityXlsx);
        System.out.println("addressCellValue = " + addressCellValue);

        System.out.println("unitIdXlsx = " + unitIdXlsx);
        BrowserUtils.waitFor(3);

        ValuationPage valuationPage = new ValuationPage();

        String coordinatePage = ConfigurationReader.get("gps_Url");
        Driver.get().get(coordinatePage);
        //valuationPage.acceptButton.click();
        BrowserUtils.waitFor(2);
        String stringCellAddress = addressCellValue.getStringCellValue();
        valuationPage.coordinateAddress.sendKeys(stringCellAddress);
        BrowserUtils.waitFor(1);
        valuationPage.findGPS_Button.click();
        BrowserUtils.waitFor(2);
        String latitude = valuationPage.getLatitude.getAttribute("value");
        System.out.println("latitude = " + latitude);
        String longitude = valuationPage.getLongitude.getAttribute("value");
        System.out.println("longitude = " + longitude);

    }

}
