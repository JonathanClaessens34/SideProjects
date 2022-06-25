package be.pxl.researchproject;

import com.google.api.services.sheets.v4.Sheets;
import com.google.api.services.sheets.v4.model.BatchGetValuesResponse;
import com.google.api.services.sheets.v4.model.ValueRange;
import org.hibernate.mapping.Value;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Test.*;
import org.junit.jupiter.api.Assertions.*;
import org.springframework.boot.test.context.SpringBootTest;
import org.testng.annotations.BeforeClass;


import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
public class GoogleSheetsLiveTest {
    private static Sheets sheetsService;
    private static String SPREADSHEET_ID = "1VcIc52crIouDFiRlLHWAlYDpaSQJ3QDtW_4rSFMhTcc";

    @BeforeClass
    public static void setup() throws GeneralSecurityException, IOException {
        sheetsService = SheetsServiceUtil.getSheetsService();
    }

    @Test
    public void readData() throws IOException {
        List<String> ranges = Arrays.asList("E2","E4");
        String range = "E2:E4";
        ValueRange response = sheetsService.spreadsheets().values()
                .get(SPREADSHEET_ID, range)
                .execute();

        List<List<Object>> values = response.getValues();

        if (values == null || values.isEmpty()) {
            throw new Error("values are null or empty.");
        }
        else {
            ValueRange januaryTotal = (ValueRange) response.get(0);
            assertThat(januaryTotal.getValues().get(0).get(0))
                    .isEqualTo("Leuven");
        }


    }
}