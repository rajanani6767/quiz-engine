package com.example.demo.service;

import org.springframework.stereotype.Service;
import java.io.ByteArrayOutputStream;
import java.time.LocalDate;

import com.openhtmltopdf.pdfboxout.PdfRendererBuilder;

@Service
public class CertificateService {

    public byte[] generateCertificate(String name, String quiz, int score) {

        String date = LocalDate.now().toString();

        String html = "<html>"
                + "<head>"
                + "<style>"

                + "@page { size: A4; margin: 40px; }"

                + "body {"
                + "font-family: 'Times New Roman';"
                + "text-align: center;"
                + "}"

                + ".certificate {"
                + "border: 10px solid #2c3e50;"
                + "padding: 40px;"
                + "height: 90%;"
                + "}"

                + "h1 {"
                + "font-size: 30px;"
                + "margin-bottom: 20px;"
                + "}"

                + "h2 {"
                + "font-size: 26px;"
                + "margin: 15px;"
                + "}"

                + "h3 {"
                + "font-size: 22px;"
                + "}"

                + "p {"
                + "font-size: 18px;"
                + "}"

                + "</style>"
                + "</head>"

                + "<body>"
                + "<div class='certificate'>"

                + "<h1>CERTIFICATE OF COMPLETION</h1>"

                + "<p>This is to certify that</p>"

                + "<h2>" + name + "</h2>"

                + "<p>has successfully completed the quiz</p>"

                + "<h3>" + quiz + "</h3>"

                + "<p>Score : " + score + "</p>"

                + "<p>Date : " + date + "</p>"

                + "</div>"
                + "</body>"
                + "</html>";

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