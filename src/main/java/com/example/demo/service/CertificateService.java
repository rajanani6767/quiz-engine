package com.example.demo.service;

import org.springframework.stereotype.Service;
import java.io.ByteArrayOutputStream;
import java.time.LocalDate;

import com.openhtmltopdf.pdfboxout.PdfRendererBuilder;

@Service
public class CertificateService {

    public byte[] generateCertificate(String name, String quiz, int score) {

        String date = LocalDate.now().toString();

        String html = "<html><body style='font-family:Times New Roman;text-align:center;'>"
                + "<div style='width:900px;margin:auto;padding:50px;border:12px solid #2c3e50;'>"

                + "<h1>CERTIFICATE OF COMPLETION</h1>"

                + "<p>This is to certify that</p>"

                + "<h2>" + name + "</h2>"

                + "<p>has successfully completed the quiz</p>"

                + "<h3>" + quiz + "</h3>"

                + "<p>Score : " + score + "</p>"

                + "<p>Date : " + date + "</p>"

                + "</div></body></html>";

        try {
            ByteArrayOutputStream out = new ByteArrayOutputStream();

            PdfRendererBuilder builder = new PdfRendererBuilder();
            builder.withHtmlContent(html, null);
            builder.toStream(out);
            builder.run();

            return out.toByteArray();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}