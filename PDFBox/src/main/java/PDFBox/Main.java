//import org.apache.pdfbox.pdmodel.PDDocument;
//import org.apache.pdfbox.pdmodel.PDPage;
//import org.apache.pdfbox.pdmodel.PDPageContentStream;
//import org.apache.pdfbox.pdmodel.PDPageContentStream.AppendMode;
//import org.apache.pdfbox.pdmodel.common.PDRectangle;
//import org.apache.pdfbox.pdmodel.font.PDType1Font;
//import java.io.File;
//import java.io.IOException;
//import be.quodlibet.boxable.BaseTable;
//import be.quodlibet.boxable.Cell;
//import be.quodlibet.boxable.HorizontalAlignment;
//import be.quodlibet.boxable.Row;
//import be.quodlibet.boxable.line.LineStyle;
//import be.quodlibet.boxable.utils.ImageUtils;
//import be.quodlibet.boxable.utils.PDStreamUtils;   
//
// public void createPdfDocuments () {
//        PDDocument document = new PDDocument();
//        PDPage page = new PDPage(new PDRectangle(PDRectangle.A3.getHeight(), PDRectangle.A3.getWidth()));
//        document.addPage(page);
//        float yStartNewPage = page.getMediaBox().getHeight() - (4 * margin);
//        float tableWidth = page.getMediaBox().getWidth() + (18 * margin);
//        boolean drawContent = true;
//        float yStart = yStartNewPage;
//        float bottomMargin = 70;
//        float pageTopMargin = 70;
//        String migrantHeading = "Migrant";
//        BaseTable table = new BaseTable(yStart, yStartNewPage, pageTopMargin, bottomMargin, tableWidth, margin * 3,
//                document, page, true, drawContent);
//
//        LineStyle lineStyle = new LineStyle(Color.WHITE, 1);
//               // add cell in table.
//        Row<PDPage> headerRow = table.createRow(30f);
//        Cell<PDPage> cell = headerRow.createCell(35, "//Contents in header row");
//        cell.setFont(PDType1Font.HELVETICA_BOLD);
//        cell.setFontSize(14);
//        cell.setLeftPadding(40);
//        cell.setTextColor(new Color(28, 69, 135));
//        cell.setBorderStyle(lineStyle);
//        
//                // add other content to pdf......
//
//
//                // draw table 
//        table.draw();
//        // call a method to add footer or header 
//                addFooter(document);
//        addHeader(document, listofcellDetails, listOfCellSize, false, 0);
//
//        File file = new File(filename);
//        Files.createParentDirs(file);
//        document.save(file);
//        document.close();
//    }
//
//// method to add footer
//
// public void addFooter(PDDocument document) throws IOException {
//
//// get all number of pages.
//
//         int numberOfPages = document.getNumberOfPages();
//
//        for (int i = 0; i < numberOfPages; i++) {
//            PDPage fpage = document.getPage(i);
//
//// content stream to write content in pdf page.
//            PDPageContentStream contentStream = new PDPageContentStream(document, fpage, AppendMode.APPEND, true);
//            PDStreamUtils.write(contentStream, "contents to write",
//                    PDType1Font.HELVETICA, 10, 460, 50, new Color(102, 102, 102));//set stayle and size
//            contentStream.close();
//
//        }
//    }