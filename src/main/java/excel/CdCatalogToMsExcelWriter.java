package excel;

import cddisk.CdDisk;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

public class CdCatalogToMsExcelWriter {
    private static final System.Logger logger = System.getLogger("CdCatalogToMsExcelWriter");
    private static final String FONT_NAME = "Arial";
    private static final String SHEET_NAME = "CdCatalog";
    private static final String FILE_NAME_XLSX = "cdCatalog.xlsx";
    private final XSSFWorkbook workbook;
    private final Sheet sheet;

    public CdCatalogToMsExcelWriter() {
        this.workbook = new XSSFWorkbook();
        this.sheet = workbook.createSheet(SHEET_NAME);
    }

    public void write(List<CdDisk> data) {
        createHeader();
        for (int i = 0; i < data.size(); i++) {
            final Row row = sheet.createRow(i + 1);
            setToCell(row, 0, data.get(i).getTitle());
            setToCell(row, 1, data.get(i).getArtist());
            setToCell(row, 2, data.get(i).getCountry());
            setToCell(row, 3, data.get(i).getCompany());
            setToCell(row, 4, data.get(i).getPrice());
            setToCell(row, 5, data.get(i).getYear());
        }
        writeToTheFile();
    }

    private void createHeader() {
        final CellStyle headerStyle = workbook.createCellStyle();
        headerStyle.setFillForegroundColor(IndexedColors.LAVENDER.getIndex());
        headerStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        headerStyle.setFont(createFont());

        final Row header = sheet.createRow(0);

        Cell headerCell = header.createCell(0);
        headerCell.setCellValue("title");

        headerCell = header.createCell(1);
        headerCell.setCellValue("artist");

        headerCell = header.createCell(2);
        headerCell.setCellValue("country");

        headerCell = header.createCell(3);
        headerCell.setCellValue("company");

        headerCell = header.createCell(4);
        headerCell.setCellValue("price");

        headerCell = header.createCell(5);
        headerCell.setCellValue("year");
    }

    private XSSFFont createFont() {
        final XSSFFont font = workbook.createFont();
        font.setFontName(FONT_NAME);
        font.setFontHeightInPoints((short) 12);
        font.setBold(false);
        return font;
    }

    private void setToCell(Row row, int column, String value) {
        row.createCell(column).setCellValue(value);
    }

    private void writeToTheFile() {
        final String path = new File(".").getAbsolutePath();
        final String fileLocation = path.substring(0, path.length() - 1) + FILE_NAME_XLSX;

        try {
            final FileOutputStream outputStream = new FileOutputStream(fileLocation);
            workbook.write(outputStream);
            workbook.close();
        } catch (Exception e) {
            logger.log(System.Logger.Level.ERROR, "Something went wrong during working with file");
        }

    }
}
