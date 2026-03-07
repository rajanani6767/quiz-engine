package com.example.demo.service;

import java.io.ByteArrayOutputStream;

import org.springframework.stereotype.Service;

import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;

@Service
public class CertificateService {

    public byte[] generateCertificate(String userName, String quizTitle, int score) {

        try {

            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

            PdfWriter writer = new PdfWriter(outputStream);
            PdfDocument pdfDocument = new PdfDocument(writer);
            Document document = new Document(pdfDocument);

            document.add(new Paragraph("CERTIFICATE OF COMPLETION"));
            document.add(new Paragraph(" "));
            document.add(new Paragraph("This is to certify that"));
            document.add(new Paragraph(userName));
            document.add(new Paragraph("has successfully completed the quiz"));
            document.add(new Paragraph(quizTitle));
            document.add(new Paragraph("Score: " + score));

            document.close();

            return outputStream.toByteArray();

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("PDF generation failed");
        }
    }
}