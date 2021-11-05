//package PDFBox;
//
//import java.io.File;
//import java.io.IOException;
//import java.net.MalformedURLException;
//import java.util.List;
//
//import org.apache.pdfbox.pdmodel.PDDocument;
//import org.apache.pdfbox.pdmodel.PDPage;
//import org.apache.pdfbox.pdmodel.PDPageContentStream;
//import org.apache.pdfbox.pdmodel.common.PDRectangle;
//import org.apache.pdfbox.pdmodel.font.PDFont;
//import org.apache.pdfbox.pdmodel.font.PDType1Font;
//
//import com.itextpdf.text.DocumentException;
//import com.itextpdf.text.ExceptionConverter;
//import com.itextpdf.text.Image;
//import com.itextpdf.text.pdf.ColumnText;
//import com.itextpdf.text.pdf.PdfContentByte;
//import com.itextpdf.text.pdf.PdfName;
//import com.itextpdf.text.pdf.PdfPTable;
//import com.itextpdf.text.pdf.PdfPageEventHelper;
//import com.itextpdf.text.pdf.PdfTemplate;
//import com.itextpdf.text.pdf.PdfWriter;
//
///**
// * Hello world!
// *
// */
//public class App  extends PdfPageEventHelper
//{
//    public static void main( String[] args ) throws IOException
//    {
////        System.out.println( "Hello World!" );
//    	 File file = new File("D:\\\\PDFBox\\\\PDFBox\\\\src\\\\main\\\\java\\\\PDFBox/blank.pdf");   
//         PDDocument doc = PDDocument.load(file);   
//         
////         PDDocument doc = null;
////         try
////         {
////             doc = PDDocument.load( file );
////
////             List allPages = (List) doc.getDocumentCatalog().getPages();
////             //PDFont font = PDType1Font.HELVETICA_BOLD;
////
////             for( int i=0; i<allPages.size(); i++ )
////             {
////                 PDPage page = (PDPage)allPages.get( i );
////                 PDRectangle pageSize = page.fin
////                 PDPageContentStream contentStream = new PDPageContentStream(doc, page, true, true,true);
////                 page.getResources().getFontNames();
////                 PDFont font = PDType1Font.TIMES_ROMAN;
////                 float fontSize = 15.0f;
////                 contentStream.beginText();
////                 // set font and font size
////                 contentStream.setFont( font, fontSize);
////                 contentStream.moveTextPositionByAmount(700, 1150);
////                 contentStream.drawString( message);
////                 contentStream.endText();
////
////                 //contentStream.
////                 contentStream.close();}
////
////             doc.save( outfile );
////         }
////         finally
////         {
////             if( doc != null )
////             {
////                 doc.close();
////             }
////         }
////     }`
//    	
////    	  PDDocument doc = new PDDocument();
//    	  
//    	  
//    	  
////    	  for (int i=0; i<5; i++) {  
////    		    //Creating a blank page   
////    		              PDPage blankPage = new PDPage();  
////    		  
////    		    //Adding the blank page to the document  
////    		    doc.addPage( blankPage );  
////    		           }   
//    	  
//         PdfTemplate t;
//         Image total;
//
//         public void onOpenDocument(PdfWriter writer, Document document) {
//             t = writer.getDirectContent().createTemplate(30, 16);
//             try {
//                 total = Image.getInstance(t);
//                 total.setRole(PdfName.ARTIFACT);
//             } catch (DocumentException de) {
//                 throw new ExceptionConverter(de);
//             }
//         }
//
//         @Override
//         public void onEndPage(PdfWriter writer1, Document document) {
//             addHeader(writer1);
//             addFooter(writer1);
//         }
//
//         private void addHeader(PdfWriter writer){
//             PdfPTable header = new PdfPTable(2);
//             try {
//                 // set defaults
//                 header.setWidths(new int[]{2, 24});
//                 header.setTotalWidth(527);
//                 header.setLockedWidth(true);
//                 header.getDefaultCell().setFixedHeight(40);
//                 header.getDefaultCell().setBorder(Rectangle.BOTTOM);
//                 header.getDefaultCell().setBorderColor(BaseColor.LIGHT_GRAY);
//
//                 // add image
//                 Image logo = Image.getInstance(HeaderFooterPageEvent.class.getResource("/memorynotfound-logo.jpg"));
//                 header.addCell(logo);
//
//                 // add text
//                 PdfPCell text = new PdfPCell();
//                 text.setPaddingBottom(15);
//                 text.setPaddingLeft(10);
//                 text.setBorder(Rectangle.BOTTOM);
//                 text.setBorderColor(BaseColor.LIGHT_GRAY);
//                 text.addElement(new Phrase("iText PDF Header Footer Example", new Font(Font.FontFamily.HELVETICA, 12)));
//                 text.addElement(new Phrase("https://memorynotfound.com", new Font(Font.FontFamily.HELVETICA, 8)));
//                 header.addCell(text);
//
//                 // write content
//                 header.writeSelectedRows(0, -1, 34, 803, writer.getDirectContent());
//             } catch(DocumentException de) {
//                 throw new ExceptionConverter(de);
//             } catch (MalformedURLException e) {
//                 throw new ExceptionConverter(e);
//             } catch (IOException e) {
//                 throw new ExceptionConverter(e);
//             }
//         }
//
//         private void addFooter(PdfWriter writer){
//             PdfPTable footer = new PdfPTable(3);
//             try {
//                 // set defaults
//                 footer.setWidths(new int[]{24, 2, 1});
//                 footer.setTotalWidth(527);
//                 footer.setLockedWidth(true);
//                 footer.getDefaultCell().setFixedHeight(40);
//                 footer.getDefaultCell().setBorder(Rectangle.TOP);
//                 footer.getDefaultCell().setBorderColor(BaseColor.LIGHT_GRAY);
//
//                 // add copyright
//                 footer.addCell(new Phrase("\u00A9 Memorynotfound.com", new Font(Font.FontFamily.HELVETICA, 12, Font.BOLD)));
//
//                 // add current page count
//                 footer.getDefaultCell().setHorizontalAlignment(Element.ALIGN_RIGHT);
//                 footer.addCell(new Phrase(String.format("Page %d of", writer.getPageNumber()), new Font(Font.FontFamily.HELVETICA, 8)));
//
//                 // add placeholder for total page count
//                 PdfPCell totalPageCount = new PdfPCell(total);
//                 totalPageCount.setBorder(Rectangle.TOP);
//                 totalPageCount.setBorderColor(BaseColor.LIGHT_GRAY);
//                 footer.addCell(totalPageCount);
//
//                 // write page
//                 PdfContentByte canvas = writer.getDirectContent();
//                 canvas.beginMarkedContentSequence(PdfName.ARTIFACT);
//                 footer.writeSelectedRows(0, -1, 34, 50, canvas);
//                 canvas.endMarkedContentSequence();
//             } catch(DocumentException de) {
//                 throw new ExceptionConverter(de);
//             }
//         }
//
//         public void onCloseDocument(PdfWriter writer, Document document) {
//             int totalLength = String.valueOf(writer.getPageNumber()).length();
//             int totalWidth = totalLength * 5;
//             ColumnText.showTextAligned(t, Element.ALIGN_RIGHT,
//                     new Phrase(String.valueOf(writer.getPageNumber()), new Font(Font.FontFamily.HELVETICA, 8)),
//                     totalWidth, 6, 0);
//         }
//          
//    	    //Saving the document  
//    	    doc.save("D:\\PDFBox\\PDFBox\\src\\main\\java\\PDFBox/blank.pdf");  
//    	          
//    	          System.out.println("PDF created");    
//    	      
//    	    //Closing the document    
//    	    doc.close();  
//    }
//}
